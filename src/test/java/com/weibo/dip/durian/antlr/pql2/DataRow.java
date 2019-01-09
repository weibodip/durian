package com.weibo.dip.durian.antlr.pql2;

import java.util.ArrayList;
import java.util.List;

public class DataRow {
  private List<String> names;
  private List<Object> values;

  public DataRow() {}

  public DataRow(List<String> names, List<Object> values) {
    this.names = new ArrayList<>(names);
    this.values = new ArrayList<>(values);
  }

  public List<String> getNames() {
    return names;
  }

  public void setNames(List<String> names) {
    this.names = names;
  }

  public List<Object> getValues() {
    return values;
  }

  public void setValues(List<Object> values) {
    this.values = values;
  }

  public Object get(int index) {
    return values.get(index);
  }

  public Object get(String name) {
    return get(names.indexOf(name));
  }

  public long getLong(int index) {
    return (Long) get(index);
  }

  public long getLong(String name) {
    return (Long) get(name);
  }

  public String getString(int index) {
    return (String) get(index);
  }

  public String getString(String name) {
    return (String) get(name);
  }

  public double getDouble(int index) {
    return (Double) get(index);
  }

  public double getDouble(String name) {
    return (Double) get(name);
  }

  public void addMetric(String name, double value) {
    names.add(name);
    values.add(value);
  }

  public void replaceColumn(String columnName, String replaceColumnName) {
    if (!names.contains(columnName)) {
      return;
    }

    names.set(names.indexOf(columnName), replaceColumnName);
  }

  public void truncateColumn(int index) {
    names.remove(index);
    values.remove(index);
  }
}
