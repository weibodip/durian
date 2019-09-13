package com.weibo.dip.durian.hive;

import java.io.Serializable;
import java.util.StringJoiner;

/** Hive table column. */
public class Column implements Serializable {
  private String name;
  private String type;
  private String comment;
  private boolean partitioned;

  public Column() {}

  /**
   * Construct a instance.
   *
   * @param name column name
   * @param type column type
   * @param comment column comment
   */
  public Column(String name, String type, String comment) {
    this.name = name;
    this.type = type;
    this.comment = comment;
    this.partitioned = false;
  }

  /**
   * Construct a instance.
   *
   * @param name column name
   * @param type column type
   * @param comment column comment
   * @param partitioned column is partitioned
   */
  public Column(String name, String type, String comment, boolean partitioned) {
    this.name = name;
    this.type = type;
    this.comment = comment;
    this.partitioned = partitioned;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public boolean isPartitioned() {
    return partitioned;
  }

  public void setPartitioned(boolean partitioned) {
    this.partitioned = partitioned;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (!(obj instanceof Column)) {
      return false;
    }

    Column column = (Column) obj;

    return this.name.equals(column.name) && this.type.equals(column.type);
  }

  @Override
  public int hashCode() {
    return name.hashCode() * type.hashCode() + 1;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Column.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("type='" + type + "'")
        .add("comment='" + comment + "'")
        .add("partitioned=" + partitioned)
        .toString();
  }
}
