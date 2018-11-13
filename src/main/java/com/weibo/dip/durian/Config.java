package com.weibo.dip.durian;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Config. */
public class Config {
  private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

  private static final ClasspathProperties PROPERTIES;

  private static final LoadingCache<String, String> cache;

  static {
    try {
      PROPERTIES = new ClasspathProperties("config.properties");

      Class.forName(PROPERTIES.getString("db.driver"));

      cache =
          CacheBuilder.newBuilder()
              .maximumSize(PROPERTIES.getLong("cache.size"))
              .expireAfterWrite(PROPERTIES.getLong("cache.expire"), TimeUnit.SECONDS)
              .removalListener(
                  (new RemovalListener<String, String>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, String> notification) {
                      LOGGER.info(
                          "expire key: {}, value: {}",
                          notification.getKey(),
                          notification.getValue());
                    }
                  }))
              .build(
                  new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                      return getFromDb(key);
                    }
                  });
    } catch (Exception e) {
      throw new ExceptionInInitializerError(e);
    }
  }

  private static String getFromDb(String key) throws SQLException {
    String sql = "select cvalue from config where ckey = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String value = null;

    try {
      conn =
          DriverManager.getConnection(
              PROPERTIES.getString("db.url"),
              PROPERTIES.getString("db.user"),
              PROPERTIES.getString("db.passwd"));

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, key);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        value = rs.getString("cvalue");
        LOGGER.info("get key: {}, value: {} from db", key, value);
      }
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (Exception e) {
          // do nothing
        }
      }

      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (Exception e) {
          // do nothing
        }
      }

      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          // do nothing
        }
      }
    }

    return value;
  }

  private static String getProperty(String key) throws RuntimeException {
    String value;

    try {
      value = cache.get(key);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    return value;
  }

  public static String getString(String key) throws RuntimeException {
    return getProperty(key);
  }

  public static int getInt(String key) throws RuntimeException {
    return Integer.valueOf(getProperty(key));
  }

  public static long getLong(String key) throws RuntimeException {
    return Long.valueOf(getProperty(key));
  }

  public static float getFloat(String key) throws RuntimeException {
    return Float.valueOf(getProperty(key));
  }

  public static double getDouble(String key) throws RuntimeException {
    return Double.valueOf(getProperty(key));
  }

  public static boolean getBoolean(String key) throws RuntimeException {
    return Boolean.valueOf(getProperty(key));
  }

  /**
   * Add key and value.
   *
   * @param key key
   * @param value value
   * @throws RuntimeException if access db error
   */
  public static void add(String key, String value) throws RuntimeException {
    String sql = "insert into config (ckey, cvalue) values (?, ?)";

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      conn =
          DriverManager.getConnection(
              PROPERTIES.getString("db.url"),
              PROPERTIES.getString("db.user"),
              PROPERTIES.getString("db.passwd"));

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, key);
      pstmt.setString(2, value);

      pstmt.executeUpdate();

      LOGGER.info("add key: {}, value: {}", key, value);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (Exception e) {
          // do nothing
        }
      }

      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          // do nothing
        }
      }
    }
  }

  /**
   * Remove the value for the specified key.
   *
   * @param key key
   * @throws RuntimeException if access db error
   */
  public static void remove(String key) throws RuntimeException {
    String sql = "delete from config where ckey = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      conn =
          DriverManager.getConnection(
              PROPERTIES.getString("db.url"),
              PROPERTIES.getString("db.user"),
              PROPERTIES.getString("db.passwd"));

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, key);

      pstmt.executeUpdate();

      LOGGER.info("remove key: {}", key);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (Exception e) {
          // do nothing
        }
      }

      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          // do nothing
        }
      }
    }
  }
}
