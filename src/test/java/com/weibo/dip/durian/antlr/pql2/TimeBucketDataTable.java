package com.weibo.dip.durian.antlr.pql2;

import com.weibo.dip.durian.table.ConsoleTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBucketDataTable {
  private String timeBucketName;
  private List<String> groupNames;
  private List<String> columnNames;

  private Map<Long, Map<List<String>, List<Double>>> buckets = new HashMap<>();

  public TimeBucketDataTable(
      String timeBucketName, List<String> groupNames, List<String> columnNames) {
    this.timeBucketName = timeBucketName;
    this.groupNames = groupNames;
    this.columnNames = columnNames;
  }

  public String getTimeBucketName() {
    return timeBucketName;
  }

  public List<String> getGroupNames() {
    return groupNames;
  }

  public List<String> getColumnNames() {
    return columnNames;
  }

  public Map<Long, Map<List<String>, List<Double>>> getBuckets() {
    return buckets;
  }

  public void addColumn(long timeBucketValue, List<String> groupValues, double columnValue) {
    if (!buckets.containsKey(timeBucketValue)) {
      buckets.put(timeBucketValue, new HashMap<>());
    }

    Map<List<String>, List<Double>> rows = buckets.get(timeBucketValue);
    if (!rows.containsKey(groupValues)) {
      rows.put(groupValues, new ArrayList<>());
    }

    List<Double> columnValues = rows.get(groupValues);

    columnValues.add(columnValue);
  }

  public void merge(TimeBucketDataTable anotherTable) {
    buckets.putAll(anotherTable.getBuckets());
  }

  public void print() {
    ConsoleTable table = new ConsoleTable();

    List<String> names = new ArrayList<>();

    names.add(timeBucketName);
    names.addAll(groupNames);
    names.addAll(columnNames);

    table.addRow(names.toArray(new String[0]));

    for (Map.Entry<Long, Map<List<String>, List<Double>>> bucket : buckets.entrySet()) {
      long timeBucket = bucket.getKey();

      for (Map.Entry<List<String>, List<Double>> entry : bucket.getValue().entrySet()) {
        List<String> groupValues = entry.getKey();
        List<Double> columnValues = entry.getValue();

        List<String> values = new ArrayList<>();

        values.add(String.valueOf(timeBucket));
        values.addAll(groupValues);
        columnValues.forEach(columnValue -> values.add(String.valueOf(columnValue)));

        table.addRow(values.toArray(new String[0]));
      }
    }

    table.print();
  }
}
