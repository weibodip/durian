package com.weibo.dip.durian.antlr.pql2;

public class Analysis {
  private String sql;

  private long beginTime;
  private long endTime;

  private String granularityTimeUnit;
  private int granularityTimeSize;

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
}
