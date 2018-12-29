package com.weibo.dip.durian.antlr.pql2;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class Analysis {
  private String sql;

  private long beginTime;
  private long endTime;

  private String granularityTimeUnit;
  private int granularityTimeSize;

  private String outputColumns;
  private String tableName;
  private String where;
  private String groupBy;
  private String having;
  private String orderBy;
  private String top;
  private String limit;

  private List<String> aggregateFunctions = new ArrayList<>();

  private List<String> outputColumnExpressions = new ArrayList<>();
  private List<String> outputColumnNames = new ArrayList<>();
  private String timeBucketName = "timeBucket";
  private List<String> groupKeyNames = new ArrayList<>();

  public String getSql() {
    return sql;
  }

  public void setSql(String sql) {
    this.sql = sql;
  }

  public long getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(long beginTime) {
    this.beginTime = beginTime;
  }

  public long getEndTime() {
    return endTime;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

  public String getGranularityTimeUnit() {
    return granularityTimeUnit;
  }

  public void setGranularityTimeUnit(String granularityTimeUnit) {
    this.granularityTimeUnit = granularityTimeUnit;
  }

  public int getGranularityTimeSize() {
    return granularityTimeSize;
  }

  public void setGranularityTimeSize(int granularityTimeSize) {
    this.granularityTimeSize = granularityTimeSize;
  }

  public List<String> getAggregateFunctions() {
    return aggregateFunctions;
  }

  public void addAggregateFunctions(String aggregateFunction) {
    aggregateFunctions.add(aggregateFunction);
  }

  public String getOutputColumns() {
    return outputColumns;
  }

  public void setOutputColumns(String outputColumns) {
    this.outputColumns = outputColumns;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getWhere() {
    return where;
  }

  public void setWhere(String where) {
    this.where = where;
  }

  public boolean hasWhere() {
    return StringUtils.isNotEmpty(where);
  }

  public String getGroupBy() {
    return groupBy;
  }

  public void setGroupBy(String groupBy) {
    this.groupBy = groupBy;
  }

  public boolean hasGroupBy() {
    return StringUtils.isNotEmpty(groupBy);
  }

  public String getHaving() {
    return having;
  }

  public void setHaving(String having) {
    this.having = having;
  }

  public boolean hasHaving() {
    return StringUtils.isNotEmpty(having);
  }

  public String getOrderBy() {
    return orderBy;
  }

  public boolean hasOrderBy() {
    return StringUtils.isNotEmpty(orderBy);
  }

  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  public String getTop() {
    return top;
  }

  public void setTop(String top) {
    this.top = top;
  }

  public boolean hasTop() {
    return StringUtils.isNotEmpty(top);
  }

  public String getLimit() {
    return limit;
  }

  public void setLimit(String limit) {
    this.limit = limit;
  }

  public boolean hasLimit() {
    return StringUtils.isNotEmpty(limit);
  }

  public List<String> getOutputColumnExpressions() {
    return outputColumnExpressions;
  }

  public void addOutputColumnExpression(String expression) {
    outputColumnExpressions.add(expression);
  }

  public List<String> getOutputColumnNames() {
    return outputColumnNames;
  }

  public void addOutputColumnName(String name) {
    outputColumnNames.add(name);
  }

  public String getTimeBucketName() {
    return timeBucketName;
  }

  public List<String> getGroupKeyNames() {
    return groupKeyNames;
  }

  public void addGroupKeyName(String name) {
    groupKeyNames.add(name);
  }
}
