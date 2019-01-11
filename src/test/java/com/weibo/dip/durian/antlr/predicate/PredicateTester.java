package com.weibo.dip.durian.antlr.predicate;

public class PredicateTester {
  public static void main(String[] args) {
    Predicate predicate = new Predicate();

    String expression = "NaN = 1 AND 3 > 4";

    boolean result = predicate.eval(expression);

    System.out.println(result);
  }
}
