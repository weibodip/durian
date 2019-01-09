package com.weibo.dip.durian;

public class KeyValue<K, V> {

  private K key;
  private V value;

  public KeyValue() {}

  public KeyValue(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof KeyValue)) {
      return false;
    }

    KeyValue kv = (KeyValue) obj;

    return key.equals(kv.key) && value.equals(kv.value);
  }

  @Override
  public int hashCode() {
    return key.hashCode() * value.hashCode();
  }

  @Override
  public String toString() {
    return "KeyValue{" + "key=" + key + ", value=" + value + '}';
  }
}
