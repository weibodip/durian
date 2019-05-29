package com.weibo.dip.durian;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Init dict, hot load by interval.
 *
 * @author yurun
 */
public abstract class DictHotLoader<V> implements Closeable {
  private static final Logger LOGGER = LoggerFactory.getLogger(DictHotLoader.class);

  private static final long DEFAULT_INTERVAL = 3600 * 1000;

  protected Map<String, V> dict = new HashMap<>();

  private ReadWriteLock lock = new ReentrantReadWriteLock();

  private Lock readLock = lock.readLock();
  private Lock writeLock = lock.writeLock();

  private Timer timer = new Timer();

  public DictHotLoader() throws Exception {
    this(DEFAULT_INTERVAL);
  }

  /**
   * Construct instance with interval.
   *
   * @param interval interval(millis)
   */
  public DictHotLoader(long interval) throws Exception {
    load();

    timer.scheduleAtFixedRate(
        new TimerTask() {
          @Override
          public void run() {
            writeLock.lock();

            try {
              load();
            } catch (Exception e) {
              LOGGER.info("timer task load error: {}", ExceptionUtils.getFullStackTrace(e));
            } finally {
              writeLock.unlock();
            }
          }
        },
        interval,
        interval);
  }

  public abstract void load() throws Exception;

  /**
   * Get value by key.
   *
   * @param key key
   * @return value
   */
  public V get(String key) {
    readLock.lock();

    try {
      return dict.get(key);
    } finally {
      readLock.unlock();
    }
  }

  @Override
  public void close() {
    timer.cancel();
  }
}
