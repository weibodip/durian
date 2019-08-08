package com.weibo.dip.durian.util;

import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * Datetime util.
 *
 * @author yurun
 */
public class DatetimeUtil {
  public static final FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance("yyyyMMddHHmmss");

  public static final FastDateFormat COMMON_DATETIME_FORMAT =
      FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

  public static final FastDateFormat ISO_8601_EXTENDED_DATETIME_FORMAT =
      DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT;

  public static int diffMilliSeconds(Date left, Date right) {
    return (int) (Math.abs(left.getTime() - right.getTime()));
  }

  public static int diffSeconds(Date left, Date right) {
    return diffMilliSeconds(left, right) / 1000;
  }

  /**
   * 基于Calendar规则对日期时间进行增加或减少操作.
   *
   * @param date 日期时间
   * @param field 时间域
   * @param amount 增加或减少的量值
   * @return 增加或减少之后的日期时间
   */
  public static Date add(Date date, int field, int amount) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    calendar.add(field, amount);

    return calendar.getTime();
  }
}
