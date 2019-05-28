package com.weibo.dip.durian;

/** @author yurun */
public class DictHotLoaderTester {
  private static class LongDict extends DictHotLoader<Long> {

    public LongDict(long interval) {
      super(interval);
    }

    @Override
    void load() {
      dict.put("time", System.currentTimeMillis());
    }
  }

  public static void main(String[] args) throws Exception {
    LongDict dict = new LongDict(10 * 1000);

    int count = 0;
    while (++count < 20) {
      System.out.println(dict.get("time"));

      Thread.sleep(5 * 1000);
    }
  }
}
