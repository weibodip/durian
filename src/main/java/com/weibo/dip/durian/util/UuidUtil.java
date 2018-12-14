package com.weibo.dip.durian.util;

import java.util.UUID;

/** uuid util. */
public class UuidUtil {
  public static String getUuid() {
    return UUID.randomUUID().toString();
  }

  public static String getDipUuid() {
    return UUID.randomUUID().toString().replace("-", "");
  }
}
