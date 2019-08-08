package com.weibo.dip.durian.util;

import java.util.Calendar;
import java.util.Date;

/** @author yurun */
public class DatetimeUtilTester {
  public static void main(String[] args) {
    Date now = new Date();

    now = DatetimeUtil.add(now, Calendar.DAY_OF_YEAR, -1);

    System.out.println(DatetimeUtil.COMMON_DATETIME_FORMAT.format(now));
  }
}
