package com.weibo.dip.durian.antlr.calculator;

/** @author yurun */
public class CalculatorTester {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    System.out.println(calculator.eval("1 / 0"));

    System.out.println(1 / 0);
  }
}
