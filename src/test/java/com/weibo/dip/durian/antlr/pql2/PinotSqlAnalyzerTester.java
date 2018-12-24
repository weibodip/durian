package com.weibo.dip.durian.antlr.pql2;

import com.google.common.base.Stopwatch;
import com.linkedin.pinot.client.Connection;
import com.linkedin.pinot.client.ConnectionFactory;
import com.linkedin.pinot.client.ResultSet;
import com.linkedin.pinot.client.ResultSetGroup;
import com.weibo.dip.durian.Symbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PinotSqlAnalyzerTester {
  private static final Logger LOGGER = LoggerFactory.getLogger(PinotSqlAnalyzerTester.class);

  private static final Connection CONNECTION =
      ConnectionFactory.fromHostList(
          "pinot.intra.dip.weibo.com:8099",
          "pinot.slave1.intra.dip.weibo.com:8099",
          "pinot.slave2.intra.dip.weibo.com:8099");

  private static List<Long> getTimeRanges(
      long beginTime, long endTime, String granularityTimeUnit, int granularityTimeSize) {
    long granularity = 0;

    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(beginTime);

    switch (granularityTimeUnit) {
      case PinotSqlListener.MINUTES:
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        granularity = granularityTimeSize * 60 * 1000;
        break;
      case PinotSqlListener.HOURS:
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        granularity = granularityTimeSize * 60 * 60 * 1000;
        break;
      case PinotSqlListener.DAYS:
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        granularity = granularityTimeSize * 24 * 60 * 60 * 1000;
        break;
    }

    long point = calendar.getTimeInMillis();

    List<Long> timeRanges = new ArrayList<>();

    int start = 0;

    while (true) {
      long value = start++ * granularity + point;

      if (value <= beginTime) {
        timeRanges.add(beginTime);
      } else if (value < endTime) {
        timeRanges.add(value);
      } else if (value >= endTime) {
        timeRanges.add(endTime);

        break;
      }
    }

    return timeRanges;
  }

  private static String getSplitSql(
      Analysis analysis, long beginTime, long endTime, boolean isPinot) {
    StringBuilder buffer = new StringBuilder();

    buffer.append("SELECT");

    buffer.append(Symbols.SPACE);
    if (!isPinot) {
      buffer.append(analysis.getOutputColumns());
    } else {
      buffer.append(
          StringUtils.join(analysis.getAggregateFunctions(), Symbols.COMMA + Symbols.SPACE));
    }
    buffer.append(Symbols.SPACE);

    buffer.append("FROM");
    buffer.append(Symbols.SPACE);
    buffer.append(analysis.getTableName());

    buffer.append(Symbols.SPACE);
    buffer.append("WHERE");
    buffer.append(Symbols.SPACE);
    buffer.append(
        analysis
            .getWhere()
            .replace(PinotSqlListener.FDATE_BEGIN_TIME, String.valueOf(beginTime))
            .replace(PinotSqlListener.FDATE_END_TIME, String.valueOf(endTime)));

    buffer.append(Symbols.SPACE);
    buffer.append("GROUP BY");
    buffer.append(Symbols.SPACE);
    buffer.append(analysis.getGroupBy());

    if (analysis.hasHaving() && !isPinot) {
      buffer.append(Symbols.SPACE);
      buffer.append("HAVING");
      buffer.append(Symbols.SPACE);
      buffer.append(analysis.getHaving());
    }

    if (analysis.hasOrderBy() && !isPinot) {
      buffer.append(Symbols.SPACE);
      buffer.append("ORDER BY");
      buffer.append(Symbols.SPACE);
      buffer.append(analysis.getOrderBy());
    }

    buffer.append(Symbols.SPACE);
    buffer.append("TOP");
    buffer.append(Symbols.SPACE);

    if (analysis.hasTop() && !isPinot) {
      buffer.append(analysis.getTop());
    } else if (isPinot) {
      buffer.append(String.valueOf(1000));
    }

    if (analysis.hasLimit() && !isPinot) {
      buffer.append(Symbols.SPACE);
      buffer.append("LIMIT");
      buffer.append(Symbols.SPACE);
      buffer.append(analysis.getLimit());
    }

    return buffer.toString();
  }

  private static class Selector implements Callable<Object> {

    private Analysis analysis;

    private long beginTime;
    private long endTime;

    public Selector(Analysis analysis, long beginTime, long endTime) {
      this.analysis = analysis;
      this.beginTime = beginTime;
      this.endTime = endTime;
    }

    @Override
    public Object call() {
      String splitSql = getSplitSql(analysis, beginTime, endTime, false);
      LOGGER.info("splitSql: {}", splitSql);

      /*
       TODO: cache
      */
      Stopwatch stopwatch = Stopwatch.createStarted();

      String pinotSql = getSplitSql(analysis, beginTime, endTime, true);
      LOGGER.info("pinotSql: {}", pinotSql);

      ResultSetGroup resultSetGroup = CONNECTION.execute(pinotSql);

      System.out.println(resultSetGroup.getResultSetCount());

      for (int index = 0; index < resultSetGroup.getResultSetCount(); index++) {
        ResultSet resultSet = resultSetGroup.getResultSet(index);

        LOGGER.info(
            resultSet.getGroupKeyLength()
                + "\t"
                + resultSet.getColumnCount()
                + "\t"
                + resultSet.getRowCount());
      }

      stopwatch.stop();

      LOGGER.info("pinot time: {} ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));

      return null;
    }
  }

  public static void main(String[] args) throws Exception {
    String sql =
        StringUtils.join(
            IOUtils.readLines(
                    PinotSqlAnalyzerTester.class.getClassLoader().getResourceAsStream("sql"),
                    CharEncoding.UTF_8)
                .stream()
                .map(String::trim)
                .iterator(),
            Symbols.SPACE);
    LOGGER.info("origin sql: {}", sql);

    Stopwatch stopwatch = Stopwatch.createStarted();

    PinotSqlAnalyzer analyzer = new PinotSqlAnalyzer();

    Analysis analysis = analyzer.analyze(sql);

    String analyzeSql = analysis.getSql();
    LOGGER.info("analyze sql: {}", analyzeSql);

    long beginTime = analysis.getBeginTime();
    long endTime = analysis.getEndTime();
    LOGGER.info("beginTime: {}, endTime: {}", beginTime, endTime);

    String granularityTimeUnit = analysis.getGranularityTimeUnit();
    int granularityTimeSize = analysis.getGranularityTimeSize();
    LOGGER.info("granularity unit: {}, size: {}", granularityTimeUnit, granularityTimeSize);

    List<Long> timeRanges =
        getTimeRanges(beginTime, endTime, granularityTimeUnit, granularityTimeSize);
    LOGGER.info("timeRanges: {}", timeRanges);

    ExecutorService executors = Executors.newCachedThreadPool();

    List<Future<Object>> futures = new ArrayList<>();

    for (int index = 0; index < timeRanges.size() - 1; index++) {
      Future<Object> future =
          executors.submit(
              new Selector(analysis, timeRanges.get(index), timeRanges.get(index + 1)));

      futures.add(future);
    }

    for (Future<Object> future : futures) {
      future.get();
    }

    executors.shutdown();

    stopwatch.stop();

    LOGGER.info("query time: {} ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
  }
}
