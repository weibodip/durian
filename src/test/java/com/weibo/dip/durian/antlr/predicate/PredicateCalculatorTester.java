package com.weibo.dip.durian.antlr.predicate;

public class PredicateCalculatorTester {
  public static void main(String[] args) {
    PredicateCalculator calculator = new PredicateCalculator();

    String predicate = "((1 < 2) or 3 >= 4) and 5 != 6";

    boolean result = calculator.eval(predicate);

    System.out.println(result);
  }
}
