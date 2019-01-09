package com.weibo.dip.durian.antlr.pql2;

import com.google.common.base.Stopwatch;
import com.linkedin.pinot.client.Connection;
import com.linkedin.pinot.client.ConnectionFactory;
import com.linkedin.pinot.client.ResultSet;
import com.linkedin.pinot.client.ResultSetGroup;
import com.weibo.dip.durian.Symbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        timeRanges.add(value);
      } else if (value < endTime) {
        timeRanges.add(value);
      } else if (value >= endTime) {
        timeRanges.add(value);

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
    buffer.append(StringUtils.join(analysis.getGroupKeyNames(), Symbols.COMMA + Symbols.SPACE));

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

    //    if (analysis.hasLimit() && !isPinot) {
    //      buffer.append(Symbols.SPACE);
    //      buffer.append("LIMIT");
    //      buffer.append(Symbols.SPACE);
    //      buffer.append(analysis.getLimit());
    //    }

    return buffer.toString();
  }

  private static class Selector implements Callable<DataTable> {

    private Analysis analysis;

    private long beginTime;
    private long endTime;

    public Selector(Analysis analysis, long beginTime, long endTime) {
      this.analysis = analysis;
      this.beginTime = beginTime;
      this.endTime = endTime;
    }

    @Override
    public DataTable call() {
      String splitSql = getSplitSql(analysis, beginTime, endTime, false);
      LOGGER.info("splitSql: {}", splitSql);

      /*
       TODO: cache
      */
      Stopwatch stopwatch = Stopwatch.createStarted();

      String pinotSql = getSplitSql(analysis, beginTime, endTime, true);
      LOGGER.info("pinotSql: {}", pinotSql);

      ResultSetGroup resultSetGroup = CONNECTION.execute(pinotSql);

      List<String> names = new ArrayList<>();

      names.add(analysis.getTimeBucketName());
      names.addAll(analysis.getGroupKeyNames());
      names.addAll(analysis.getAggregateFunctions());

      DataTable dataTable = new DataTable(names);

      Map<List<String>, List<Double>> groups = new HashMap<>();

      for (int group = 0; group < resultSetGroup.getResultSetCount(); group++) {
        ResultSet resultSet = resultSetGroup.getResultSet(group);

        for (int row = 0; row < resultSet.getRowCount(); row++) {
          List<String> groupValues = new ArrayList<>();
          for (int groupKey = 0; groupKey < resultSet.getGroupKeyLength(); groupKey++) {
            groupValues.add(resultSet.getGroupKeyString(row, groupKey));
          }

          double columnValue = resultSet.getDouble(row, 0);

          if (!groups.containsKey(groupValues)) {
            groups.put(groupValues, new ArrayList<>());
          }

          groups.get(groupValues).add(columnValue);
        }
      }

      for (Map.Entry<List<String>, List<Double>> entry : groups.entrySet()) {
        long timestamp = beginTime;
        List<String> dimentions = entry.getKey();
        List<Double> metrics = entry.getValue();

        List<Object> values = new ArrayList<>();

        values.add(timestamp);
        values.addAll(dimentions);
        values.addAll(metrics);

        DataRow dataRow = new DataRow(names, values);

        dataTable.addRow(dataRow);
      }

      dataTable.print();

      List<String> outputColumnExpressions = analysis.getOutputColumnExpressions();
      List<String> outputColumnNames = analysis.getOutputColumnNames();

      for (String outputColumnExpression : outputColumnExpressions) {
        if (dataTable.containMetric(outputColumnExpression)) {
          continue;
        }

        LOGGER.info("outputColumnExpression {} not contain", outputColumnExpression);

        dataTable.computeMetric(outputColumnExpression);
      }

      dataTable.replaceColumns(outputColumnExpressions, outputColumnNames);

      dataTable.print();

      List<String> truncateColumns = new ArrayList<>();

      truncateColumns.add(analysis.getTimeBucketName());
      truncateColumns.addAll(analysis.getGroupKeyNames());
      truncateColumns.addAll(outputColumnNames);

      dataTable.truncateColumns(truncateColumns);

      dataTable.print();

      dataTable.having(analysis.getHaving(), analysis.getHavingKeyNames());

      dataTable.print();

      stopwatch.stop();

      LOGGER.info("pinot time: {} ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));

      return dataTable;
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

    List<String> outputColumnExpressions = analysis.getOutputColumnExpressions();
    LOGGER.info("outputColumnExpressions: {}", outputColumnExpressions);

    List<String> outputColumnNames = analysis.getOutputColumnNames();
    LOGGER.info("outputColumnNames: {}", outputColumnNames);

    long beginTime = analysis.getBeginTime();
    long endTime = analysis.getEndTime();
    LOGGER.info("beginTime: {}, endTime: {}", beginTime, endTime);

    String granularityTimeUnit = analysis.getGranularityTimeUnit();
    int granularityTimeSize = analysis.getGranularityTimeSize();
    LOGGER.info("granularity unit: {}, size: {}", granularityTimeUnit, granularityTimeSize);

    List<String> groupKeyNames = analysis.getGroupKeyNames();
    LOGGER.info("groupKeyNames: {}", groupKeyNames);

    List<String> havingKeyNames = analysis.getHavingKeyNames();
    LOGGER.info("havingKeyNames: {}", havingKeyNames);

    List<Long> timeRanges =
        getTimeRanges(beginTime, endTime, granularityTimeUnit, granularityTimeSize);
    LOGGER.info("timeRanges: {}", timeRanges);

    ExecutorService executors = Executors.newFixedThreadPool(1);

    List<Future<DataTable>> futures = new ArrayList<>();

    for (int index = 0; index < timeRanges.size() - 1; index++) {
      Future<DataTable> future =
          executors.submit(
              new Selector(analysis, timeRanges.get(index), timeRanges.get(index + 1) - 1));

      futures.add(future);
    }

    List<String> names = new ArrayList<>();

    names.add(analysis.getTimeBucketName());
    names.addAll(analysis.getGroupKeyNames());
    names.addAll(analysis.getOutputColumnNames());

    DataTable table = new DataTable(names);

    for (Future<DataTable> future : futures) {
      table.merge(future.get());
    }

    executors.shutdown();

    table.print();

    stopwatch.stop();

    LOGGER.info("query time: {} ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
  }
}
