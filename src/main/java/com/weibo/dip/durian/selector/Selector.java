package com.weibo.dip.durian.selector;

/**
 * Selector.
 *
 * @author yurun
 * @param <T> select type
 */
public interface Selector<T> {
  T select();
}
