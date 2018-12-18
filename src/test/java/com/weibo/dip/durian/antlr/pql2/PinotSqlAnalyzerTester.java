package com.weibo.dip.durian.antlr.pql2;

import com.weibo.dip.durian.Symbols;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PinotSqlAnalyzerTester {
  private static final Logger LOGGER = LoggerFactory.getLogger(PinotSqlAnalyzerTester.class);

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
    LOGGER.info("sql: {}", sql);

    PinotSqlAnalyzer analyzer = new PinotSqlAnalyzer();

    analyzer.analyze(sql);
  }
}
