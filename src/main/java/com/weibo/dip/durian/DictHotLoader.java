package com.weibo.dip.durian;

import java.util.HashMap;
import java.util.Map;
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
public abstract class DictHotLoader<V> {
  private static final Logger LOGGER = LoggerFactory.getLogger(DictHotLoader.class);

  private static final long DEFAULT_INTERVAL = 3600 * 1000;

  protected Map<String, V> dict = new HashMap<>();

  private ReadWriteLock lock = new ReentrantReadWriteLock();

  private Lock readLock = lock.readLock();
  private Lock writeLock = lock.writeLock();

  public DictHotLoader() {
    this(DEFAULT_INTERVAL);
  }

  public DictHotLoader(long interval) {
    load();

    Thread timer =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                while (true) {
                  try {
                    Thread.sleep(interval);
                  } catch (InterruptedException e) {
                    break;
                  }

                  writeLock.lock();

                  try {
                    load();
                  } catch (Exception e) {
                    LOGGER.error("hot load error: {}", ExceptionUtils.getFullStackTrace(e));
                  } finally {
                    writeLock.unlock();
                  }
                }
              }
            });

    timer.setDaemon(true);
    timer.start();
  }

  abstract void load();

  public V get(String key) {
    readLock.lock();

    try {
      return dict.get(key);
    } finally {
      readLock.unlock();
    }
  }
}
