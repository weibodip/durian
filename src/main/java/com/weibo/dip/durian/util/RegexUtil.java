package com.weibo.dip.durian.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/** Regex util. */
public class RegexUtil {
  private static final Map<String, Pattern> PATTERNS = new HashMap<>();

  private static synchronized Pattern getPattern(String regex) throws PatternSyntaxException {
    Pattern pattern = PATTERNS.get(regex);

    if (pattern == null) {
      pattern = Pattern.compile(regex);

      PATTERNS.put(regex, pattern);
    }

    return pattern;
  }

  /**
   * Check if value matches the regex.
   *
   * @param regex regex
   * @param value value
   * @return true if match, else false
   * @throws PatternSyntaxException if regex error
   */
  public static boolean match(String regex, String value) throws PatternSyntaxException {
    if (regex == null || value == null) {
      return false;
    }

    Pattern pattern = getPattern(regex);

    Matcher matcher = pattern.matcher(value);

    return matcher.matches();
  }

  /**
   * Split value using the regex.
   *
   * @param regex regex
   * @param value value
   * @return words
   * @throws PatternSyntaxException if regex error
   */
  public static String[] split(String regex, String value) throws PatternSyntaxException {
    if (value == null) {
      return null;
    }

    return value.split(regex);
  }

  /**
   * Split value using the regex(limit apply times).
   *
   * @param regex regex
   * @param value value
   * @param limit times
   * @return words
   * @throws PatternSyntaxException if regex error
   */
  public static String[] split(String regex, String value, int limit)
      throws PatternSyntaxException {
    if (value == null) {
      return null;
    }

    return value.split(regex, limit);
  }

  /**
   * Get groups from value using the regex.
   *
   * @param regex regex
   * @param value value
   * @return groups
   * @throws PatternSyntaxException if regex error
   */
  public static String[] groups(String regex, String value) throws PatternSyntaxException {
    String[] columns = null;

    Pattern pattern = getPattern(regex);

    Matcher matcher = pattern.matcher(value);

    if (matcher.matches()) {
      columns = new String[matcher.groupCount()];

      for (int index = 0; index < columns.length; index++) {
        columns[index] = matcher.group(index + 1);
      }
    }

    return columns;
  }
}
