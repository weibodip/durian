package com.weibo.dip.durian.antlr.pql2;

import com.weibo.dip.durian.KeyValue;
import com.weibo.dip.durian.antlr.calculator.Calculator;
import com.weibo.dip.durian.antlr.expression.Expression;
import com.weibo.dip.durian.antlr.predicate.PredicateCalculator;
import com.weibo.dip.durian.table.ConsoleTable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataTable {
  private static final Logger LOGGER = LoggerFactory.getLogger(DataTable.class);

  private List<String> names;
  private List<DataRow> rows;

  private String timeBucketName;
  private List<String> groupNames;
  private List<String> columnNames;

  private Map<Long, Map<List<String>, List<Double>>> buckets = new HashMap<>();

  public DataTable(List<String> names) {
    this.names = names;
    this.rows = new ArrayList<>();
  }

  public DataTable(String timeBucketName, List<String> groupNames, List<String> columnNames) {
    this.timeBucketName = timeBucketName;
    this.groupNames = new ArrayList<>(groupNames);
    this.columnNames = new ArrayList<>(columnNames);
  }

  public List<String> getNames() {
    return names;
  }

  public void setNames(List<String> names) {
    this.names = names;
  }

  public List<DataRow> getRows() {
    return rows;
  }

  public void setRows(List<DataRow> rows) {
    this.rows = rows;
  }

  public void addRow(DataRow row) {
    rows.add(row);
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

  public boolean containMetric(String name) {
    return names.contains(name);
  }

  public void replaceColumns(List<String> outputColumnExpressions, List<String> outputColumnNames) {
    for (int index = 0; index < outputColumnExpressions.size(); index++) {
      replaceColumn(outputColumnExpressions.get(index), outputColumnNames.get(index));
    }
  }

  public void replaceColumn(String columnName, String replaceColumnName) {
    if (!containMetric(columnName)) {
      return;
    }

    names.set(names.indexOf(columnName), replaceColumnName);

    for (DataRow row : rows) {
      row.replaceColumn(columnName, replaceColumnName);
    }
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

  public void computeMetric(String columnExpression) {
    LOGGER.info("column expression: {}", columnExpression);

    Expression expression = new Expression();
    Calculator calculator = new Calculator();

    DecimalFormat decimalFormat = new DecimalFormat();

    decimalFormat.setGroupingUsed(false);
    decimalFormat.setMaximumFractionDigits(10);

    String[] operators = expression.eval(columnExpression);
    LOGGER.info(
        "column expression operators({}): {}", operators.length, ArrayUtils.toString(operators));

    for (DataRow row : rows) {
      String columnExpressionTransformation = columnExpression;

      for (String operator : operators) {
        double value = row.getDouble(operator);
        LOGGER.debug("operator: {}, value: {}", operator, value);

        columnExpressionTransformation =
            columnExpressionTransformation.replace(operator, decimalFormat.format(value));
        LOGGER.debug("columnExpressionTransformation: {}", columnExpressionTransformation);
      }

      double value = calculator.eval(columnExpressionTransformation);

      LOGGER.debug(
          "columnExpression: {}, columnExpressionTransformation: {}, value: {}",
          columnExpression,
          columnExpressionTransformation,
          value);

      row.addMetric(columnExpression, value);
    }

    System.out.println(names);

    names.add(columnExpression);

    System.out.println(names);
  }

  public void truncateColumns(List<String> truncateNames) {
    List<Integer> indices = new ArrayList<>();

    for (int index = 0; index < names.size(); index++) {
      if (!truncateNames.contains(names.get(index))) {
        indices.add(index);
      }
    }

    Collections.reverse(indices);

    LOGGER.info("truncate columns: {}", indices);

    for (int index : indices) {
      names.remove(index);
    }

    for (DataRow row : rows) {
      for (int index : indices) {
        row.truncateColumn(index);
      }
    }
  }

  public void having(String having, List<String> havingKeyNames) {
    PredicateCalculator predicateCalculator = new PredicateCalculator();

    DecimalFormat decimalFormat = new DecimalFormat();

    decimalFormat.setGroupingUsed(false);
    decimalFormat.setMaximumFractionDigits(10);

    Iterator<DataRow> iter = rows.iterator();

    while (iter.hasNext()) {
      DataRow row = iter.next();

      String havingTransformation = having;

      for (String havingKeyName : havingKeyNames) {
        havingTransformation =
            havingTransformation.replace(
                havingKeyName, decimalFormat.format(row.getDouble(havingKeyName)));
      }

      if (!predicateCalculator.eval(havingTransformation)) {
        iter.remove();
      }
    }
  }

  public void merge(DataTable anotherTable) {
    List<DataRow> anotherRows = anotherTable.getRows();
    if (CollectionUtils.isEmpty(anotherRows)) {
      return;
    }

    rows.addAll(anotherTable.getRows());
  }

  public void sort(List<KeyValue<String, Boolean>> sorts) {
    rows.sort(
        (leftRow, rightRow) -> {
          for (KeyValue<String, Boolean> sort : sorts) {
            String metric = sort.getKey();
            boolean isAsc = sort.getValue();

            Comparable leftValue = (Comparable) leftRow.get(metric);
            Comparable rigthValue = (Comparable) rightRow.get(metric);

            @SuppressWarnings("unchecked")
            int compare = leftValue.compareTo(rigthValue);

            if (compare < 0) {
              if (isAsc) {
                return -1;
              } else {
                return 1;
              }
            } else if (compare > 0) {
              if (isAsc) {
                return 1;
              } else {
                return -1;
              }
            }
          }

          return 0;
        });
  }

  public void top(int top) {
    rows = rows.subList(0, top);
  }

  public List<DataRow> gets() {
    return rows;
  }

  public void print() {
    ConsoleTable table = new ConsoleTable();

    table.addRow(names.toArray(new String[0]));

    for (DataRow row : rows) {
      String[] values = new String[names.size()];

      for (int index = 0; index < names.size(); index++) {
        values[index] = String.valueOf(row.get(index));
      }

      table.addRow(values);
    }

    table.print();
  }
}
