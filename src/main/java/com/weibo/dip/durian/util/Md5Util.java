package com.weibo.dip.durian.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Md5Util {
  private static final Logger LOGGER = LoggerFactory.getLogger(Md5Util.class);

  private static final char[] DIGITS = {
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
  };

  /**
   * Get md5.
   *
   * @param data data
   * @return md5
   */
  public static String get(String data) throws NoSuchAlgorithmException {
    if (data == null) {
      return null;
    }

    MessageDigest digest = MessageDigest.getInstance("MD5");

    digest.update(data.getBytes());

    byte[] md = digest.digest();

    char[] md5 = new char[md.length * 2];

    for (int index = 0; index < md.length; index++) {
      md5[index * 2] = DIGITS[md[index] >>> 4 & 0xf];

      md5[index * 2 + 1] = DIGITS[md[index] & 0xf];
    }

    return new String(md5);
  }
}
