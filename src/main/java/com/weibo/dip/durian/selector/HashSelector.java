package com.weibo.dip.durian.selector;

import com.weibo.dip.durian.util.UuidUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hash selector.
 *
 * @param <T> select type
 */
public class HashSelector<T> implements Selector<T> {
  private List<T> candidates = new ArrayList<>();

  /**
   * Construct a instance.
   *
   * @param candidates select candidates
   */
  public HashSelector(List<T> candidates) {
    if (candidates != null && !candidates.isEmpty()) {
      this.candidates.addAll(candidates);
    }
  }

  /**
   * Construct a instance.
   *
   * @param candidates select candidates
   */
  public HashSelector(T[] candidates) {
    if (candidates != null && candidates.length > 0) {
      this.candidates.addAll(Arrays.asList(candidates));
    }
  }

  @Override
  public T select() {
    if (candidates.isEmpty()) {
      return null;
    }

    int hashCode = Math.abs(UuidUtil.getUuid().hashCode());

    return candidates.get(hashCode % candidates.size());
  }
}
