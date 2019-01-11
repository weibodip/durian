package com.weibo.dip.durian.antlr.predicate;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link
 * PredicateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface PredicateVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by the {@code Statement} labeled alternative in {@link
   * PredicateParser#stat}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStatement(PredicateParser.StatementContext ctx);
  /**
   * Visit a parse tree produced by the {@code Or} labeled alternative in {@link
   * PredicateParser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOr(PredicateParser.OrContext ctx);
  /**
   * Visit a parse tree produced by the {@code Comparison} labeled alternative in {@link
   * PredicateParser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComparison(PredicateParser.ComparisonContext ctx);
  /**
   * Visit a parse tree produced by the {@code Parens} labeled alternative in {@link
   * PredicateParser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParens(PredicateParser.ParensContext ctx);
  /**
   * Visit a parse tree produced by the {@code And} labeled alternative in {@link
   * PredicateParser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnd(PredicateParser.AndContext ctx);
  /**
   * Visit a parse tree produced by {@link PredicateParser#number}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNumber(PredicateParser.NumberContext ctx);
}
