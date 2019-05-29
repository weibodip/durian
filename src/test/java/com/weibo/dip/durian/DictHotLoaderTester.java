package com.weibo.dip.durian;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** @author yurun */
public class DictHotLoaderTester {
  private static final Logger LOGGER = LoggerFactory.getLogger(DictHotLoaderTester.class);

  private static class LongDict extends DictHotLoader<Long> {

    public LongDict(long interval) throws Exception {
      super(interval);
    }

    @Override
    public void load() {
      dict.put("time", System.currentTimeMillis());
    }
  }

  public static void main(String[] args) throws Exception {
    LongDict dict = new LongDict(10 * 1000);

    int count = 0;
    while (++count < 10) {
      System.out.println(dict.get("time"));

      Thread.sleep(5 * 1000);
    }

    LOGGER.info("while break");

    Thread.sleep(5 * 1000);

    dict.close();
  }
}
