package com.weibo.dip.durian.antlr.pql2;

import com.weibo.dip.durian.Symbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PinotSqlAnalyzerTester {
  private static final Logger LOGGER = LoggerFactory.getLogger(PinotSqlAnalyzerTester.class);

  private static List<Long> getTimeRanges(
      long beginTime, long endTime, String granularityTimeUnit, int granularityTimeSize) {
    long point = 0;
    long granularity = 0;

    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(beginTime);

    if (granularityTimeUnit.equals(PinotSqlListener.MINUTES)) {
      calendar.set(Calendar.SECOND, 0);
      calendar.set(Calendar.MILLISECOND, 0);

      granularity = granularityTimeSize * 60 * 1000;
    } else if (granularityTimeUnit.equals(PinotSqlListener.HOURS)) {
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.SECOND, 0);
      calendar.set(Calendar.MILLISECOND, 0);

      granularity = granularityTimeSize * 60 * 60 * 1000;
    } else if (granularityTimeUnit.equals(PinotSqlListener.DAYS)) {
      calendar.set(Calendar.HOUR_OF_DAY, 0);
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.SECOND, 0);
      calendar.set(Calendar.MILLISECOND, 0);

      granularity = granularityTimeSize * 24 * 60 * 60 * 1000;
    }

    point = calendar.getTimeInMillis();

    List<Long> timeRanges = new ArrayList<>();

    int offset = 0;

    while (true) {
      long value = offset++ * granularity + point;

      if (value <= beginTime) {
        timeRanges.add(beginTime);
      } else if (value > beginTime && value < endTime) {
        timeRanges.add(value);
      } else if (value >= endTime) {
        timeRanges.add(endTime);

        break;
      }
    }

    return timeRanges;
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

    PinotSqlAnalyzer analyzer = new PinotSqlAnalyzer();

    Analysis analysis = analyzer.analyze(sql);

    LOGGER.info("origin sql: {}", sql);
    LOGGER.info("analyze sql: " + analysis.getSql());

    long beginTime = analysis.getBeginTime();
    long endTime = analysis.getEndTime();
    LOGGER.info("beginTime: {}, endTime: {}", beginTime, endTime);

    String granularityTimeUnit = analysis.getGranularityTimeUnit();
    int granularityTimeSize = analysis.getGranularityTimeSize();
    LOGGER.info("granularity unit: {}, size: {}", granularityTimeUnit, granularityTimeSize);

    List<Long> timeRanges =
        getTimeRanges(beginTime, endTime, granularityTimeUnit, granularityTimeSize);
    LOGGER.info("timeRanges: {}", timeRanges);
  }
}
