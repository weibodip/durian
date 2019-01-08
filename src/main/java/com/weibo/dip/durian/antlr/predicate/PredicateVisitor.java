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
   * Visit a parse tree produced by {@link PredicateParser#root}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRoot(PredicateParser.RootContext ctx);
  /**
   * Visit a parse tree produced by {@link PredicateParser#statement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStatement(PredicateParser.StatementContext ctx);
  /**
   * Visit a parse tree produced by {@link PredicateParser#predicateList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPredicateList(PredicateParser.PredicateListContext ctx);
  /**
   * Visit a parse tree produced by the {@code PredicateParenthesisGroup} labeled alternative in
   * {@link PredicateParser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPredicateParenthesisGroup(PredicateParser.PredicateParenthesisGroupContext ctx);
  /**
   * Visit a parse tree produced by the {@code ComparisonPredicate} labeled alternative in {@link
   * PredicateParser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComparisonPredicate(PredicateParser.ComparisonPredicateContext ctx);
  /**
   * Visit a parse tree produced by {@link PredicateParser#booleanOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBooleanOperator(PredicateParser.BooleanOperatorContext ctx);
  /**
   * Visit a parse tree produced by {@link PredicateParser#comparisonClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComparisonClause(PredicateParser.ComparisonClauseContext ctx);
  /**
   * Visit a parse tree produced by the {@code IntegerLiteral} labeled alternative in {@link
   * PredicateParser#literal}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIntegerLiteral(PredicateParser.IntegerLiteralContext ctx);
  /**
   * Visit a parse tree produced by the {@code FloatingPointLiteral} labeled alternative in {@link
   * PredicateParser#literal}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFloatingPointLiteral(PredicateParser.FloatingPointLiteralContext ctx);
  /**
   * Visit a parse tree produced by {@link PredicateParser#comparisonOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComparisonOperator(PredicateParser.ComparisonOperatorContext ctx);
}
