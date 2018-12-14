package com.weibo.dip.durian.antlr.expression;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link
 * ExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface ExpressionVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by the {@code Print} labeled alternative in {@link
   * ExpressionParser#stat}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrint(ExpressionParser.PrintContext ctx);
  /**
   * Visit a parse tree produced by the {@code AddOrSub} labeled alternative in {@link
   * ExpressionParser#expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAddOrSub(ExpressionParser.AddOrSubContext ctx);
  /**
   * Visit a parse tree produced by the {@code Parens} labeled alternative in {@link
   * ExpressionParser#expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParens(ExpressionParser.ParensContext ctx);
  /**
   * Visit a parse tree produced by the {@code MulOrDiv} labeled alternative in {@link
   * ExpressionParser#expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMulOrDiv(ExpressionParser.MulOrDivContext ctx);
  /**
   * Visit a parse tree produced by the {@code IntOrFloat} labeled alternative in {@link
   * ExpressionParser#expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIntOrFloat(ExpressionParser.IntOrFloatContext ctx);
  /**
   * Visit a parse tree produced by the {@code Aggregate} labeled alternative in {@link
   * ExpressionParser#expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAggregate(ExpressionParser.AggregateContext ctx);
  /**
   * Visit a parse tree produced by {@link ExpressionParser#method}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMethod(ExpressionParser.MethodContext ctx);
  /**
   * Visit a parse tree produced by {@link ExpressionParser#number}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNumber(ExpressionParser.NumberContext ctx);
}
