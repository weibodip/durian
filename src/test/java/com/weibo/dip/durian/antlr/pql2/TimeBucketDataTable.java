package com.weibo.dip.durian.antlr.pql2;

import com.weibo.dip.durian.antlr.calculator.Calculator;
import com.weibo.dip.durian.antlr.expression.Expression;
import com.weibo.dip.durian.table.ConsoleTable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeBucketDataTable {
  private static final Logger LOGGER = LoggerFactory.getLogger(TimeBucketDataTable.class);

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

  public boolean containColumn(String columnName) {
    return columnNames.contains(columnName);
  }

  public void replaceColumns(List<String> outputColumnExpressions, List<String> outputColumnNames) {
    for (int index = 0; index < outputColumnExpressions.size(); index++) {
      replaceColumn(outputColumnExpressions.get(index), outputColumnNames.get(index));
    }
  }

  public void replaceColumn(String columnName, String replaceColumnName) {
    if (!containColumn(columnName)) {
      return;
    }

    columnNames.set(columnNames.indexOf(columnName), replaceColumnName);
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

  public void computeColumn(String columnExpression) {
    LOGGER.info("column expression: {}", columnExpression);

    Expression expression = new Expression();
    Calculator calculator = new Calculator();

    DecimalFormat decimalFormat = new DecimalFormat();

    decimalFormat.setGroupingUsed(false);
    decimalFormat.setMaximumFractionDigits(10);

    String[] operators = expression.eval(columnExpression);
    LOGGER.info(
        "column expression operators({}): {}", operators.length, ArrayUtils.toString(operators));

    for (Map.Entry<Long, Map<List<String>, List<Double>>> bucket : buckets.entrySet()) {
      Map<List<String>, List<Double>> datas = bucket.getValue();

      for (Map.Entry<List<String>, List<Double>> series : datas.entrySet()) {
        String columnExpressionTransformation = columnExpression;

        List<Double> metrics = series.getValue();

        for (String operator : operators) {
          double metric = metrics.get(columnNames.indexOf(operator));
          LOGGER.info("operator: {}, value: {}", operator, metric);

          columnExpressionTransformation =
              columnExpressionTransformation.replace(operator, decimalFormat.format(metric));
          LOGGER.info("columnExpressionTransformation: {}", columnExpressionTransformation);
        }

        double value = calculator.eval(columnExpressionTransformation);

        LOGGER.info(
            "columnExpression: {}, columnExpressionTransformation: {}, value: {}",
            columnExpression,
            columnExpressionTransformation,
            value);

        metrics.add(value);
      }
    }

    columnNames.add(columnExpression);
  }

  public void merge(TimeBucketDataTable anotherTable) {
    buckets.putAll(anotherTable.getBuckets());
  }

  public void truncateColumns(List<String> names) {
    List<Integer> indices = new ArrayList<>();

    for (int index = 0; index < columnNames.size(); index++) {
      if (!names.contains(columnNames.get(index))) {
        indices.add(index);
      }
    }

    Collections.reverse(indices);

    LOGGER.info("truncate columns: {}", indices);

    for (int index : indices) {
      columnNames.remove(index);
    }

    LOGGER.info(columnNames.toString());

    for (Map.Entry<Long, Map<List<String>, List<Double>>> bucket : buckets.entrySet()) {
      Map<List<String>, List<Double>> datas = bucket.getValue();

      for (Map.Entry<List<String>, List<Double>> series : datas.entrySet()) {
        List<Double> metrics = series.getValue();

        for (int index : indices) {
          metrics.remove(index);
        }
      }
    }
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
