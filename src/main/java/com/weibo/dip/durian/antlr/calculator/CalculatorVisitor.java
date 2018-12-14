package com.weibo.dip.durian.antlr.calculator;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link
 * CalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface CalculatorVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by the {@code Print} labeled alternative in {@link
   * CalculatorParser#stat}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrint(CalculatorParser.PrintContext ctx);

  /**
   * Visit a parse tree produced by the {@code AddOrSub} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAddOrSub(CalculatorParser.AddOrSubContext ctx);

  /**
   * Visit a parse tree produced by the {@code Parens} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParens(CalculatorParser.ParensContext ctx);

  /**
   * Visit a parse tree produced by the {@code MulOrDiv} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMulOrDiv(CalculatorParser.MulOrDivContext ctx);

  /**
   * Visit a parse tree produced by the {@code IntOrFloat} labeled alternative in {@link
   * CalculatorParser#expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIntOrFloat(CalculatorParser.IntOrFloatContext ctx);

  /**
   * Visit a parse tree produced by {@link CalculatorParser#number}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNumber(CalculatorParser.NumberContext ctx);
}
