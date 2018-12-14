package com.weibo.dip.durian.antlr.calculator;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by the {@code Print} labeled alternative in {@link
   * CalculatorParser#stat}.
   *
   * @param ctx the parse tree
   */
  void enterPrint(CalculatorParser.PrintContext ctx);

  /**
   * Exit a parse tree produced by the {@code Print} labeled alternative in {@link
   * CalculatorParser#stat}.
   *
   * @param ctx the parse tree
   */
  void exitPrint(CalculatorParser.PrintContext ctx);

  /**
   * Enter a parse tree produced by the {@code AddOrSub} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   */
  void enterAddOrSub(CalculatorParser.AddOrSubContext ctx);

  /**
   * Exit a parse tree produced by the {@code AddOrSub} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   */
  void exitAddOrSub(CalculatorParser.AddOrSubContext ctx);

  /**
   * Enter a parse tree produced by the {@code Parens} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   */
  void enterParens(CalculatorParser.ParensContext ctx);

  /**
   * Exit a parse tree produced by the {@code Parens} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   */
  void exitParens(CalculatorParser.ParensContext ctx);

  /**
   * Enter a parse tree produced by the {@code MulOrDiv} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   */
  void enterMulOrDiv(CalculatorParser.MulOrDivContext ctx);

  /**
   * Exit a parse tree produced by the {@code MulOrDiv} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   */
  void exitMulOrDiv(CalculatorParser.MulOrDivContext ctx);

  /**
   * Enter a parse tree produced by the {@code IntOrFloat} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   */
  void enterIntOrFloat(CalculatorParser.IntOrFloatContext ctx);

  /**
   * Exit a parse tree produced by the {@code IntOrFloat} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   */
  void exitIntOrFloat(CalculatorParser.IntOrFloatContext ctx);

  /**
   * Enter a parse tree produced by {@link CalculatorParser#number}.
   *
   * @param ctx the parse tree
   */
  void enterNumber(CalculatorParser.NumberContext ctx);

  /**
   * Exit a parse tree produced by {@link CalculatorParser#number}.
   *
   * @param ctx the parse tree
   */
  void exitNumber(CalculatorParser.NumberContext ctx);
}
