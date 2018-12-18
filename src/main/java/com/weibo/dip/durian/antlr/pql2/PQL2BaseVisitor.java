package com.weibo.dip.durian.antlr.pql2; // Generated from PQL2.g4 by ANTLR 4.7.1

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link PQL2Visitor}, which can be extended to
 * create a visitor which only needs to handle a subset of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public class PQL2BaseVisitor<T> extends AbstractParseTreeVisitor<T> implements PQL2Visitor<T> {
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitRoot(PQL2Parser.RootContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitStatement(PQL2Parser.StatementContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitSelect(PQL2Parser.SelectContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitWhere(PQL2Parser.WhereContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitGroupBy(PQL2Parser.GroupByContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitHaving(PQL2Parser.HavingContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitOrderBy(PQL2Parser.OrderByContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitTop(PQL2Parser.TopContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitLimit(PQL2Parser.LimitContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitOptions(PQL2Parser.OptionsContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitStarColumnList(PQL2Parser.StarColumnListContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitOutputColumnList(PQL2Parser.OutputColumnListContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitOutputColumn(PQL2Parser.OutputColumnContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitExpressionParenthesisGroup(PQL2Parser.ExpressionParenthesisGroupContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitIdentifier(PQL2Parser.IdentifierContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitConstant(PQL2Parser.ConstantContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitBinaryMathOp(PQL2Parser.BinaryMathOpContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitFunctionCall(PQL2Parser.FunctionCallContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitExpressionList(PQL2Parser.ExpressionListContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitStarExpression(PQL2Parser.StarExpressionContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitBinaryMathOperator(PQL2Parser.BinaryMathOperatorContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitFunction(PQL2Parser.FunctionContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitTableName(PQL2Parser.TableNameContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitStringLiteral(PQL2Parser.StringLiteralContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitIntegerLiteral(PQL2Parser.IntegerLiteralContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitFloatingPointLiteral(PQL2Parser.FloatingPointLiteralContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitWhereClause(PQL2Parser.WhereClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitPredicateList(PQL2Parser.PredicateListContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitPredicateParenthesisGroup(PQL2Parser.PredicateParenthesisGroupContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitComparisonPredicate(PQL2Parser.ComparisonPredicateContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitInPredicate(PQL2Parser.InPredicateContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitBetweenPredicate(PQL2Parser.BetweenPredicateContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitIsPredicate(PQL2Parser.IsPredicateContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitRegexpLikePredicate(PQL2Parser.RegexpLikePredicateContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitInClause(PQL2Parser.InClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitIsClause(PQL2Parser.IsClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitComparisonClause(PQL2Parser.ComparisonClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitComparisonOperator(PQL2Parser.ComparisonOperatorContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitBetweenClause(PQL2Parser.BetweenClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitRegexpLikeClause(PQL2Parser.RegexpLikeClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitBooleanOperator(PQL2Parser.BooleanOperatorContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitGroupByClause(PQL2Parser.GroupByClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitGroupByList(PQL2Parser.GroupByListContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitHavingClause(PQL2Parser.HavingClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitOrderByClause(PQL2Parser.OrderByClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitOrderByList(PQL2Parser.OrderByListContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitOrderByExpression(PQL2Parser.OrderByExpressionContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitOrdering(PQL2Parser.OrderingContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitTopClause(PQL2Parser.TopClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitLimitClause(PQL2Parser.LimitClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitOptionListClause(PQL2Parser.OptionListClauseContext ctx) {
    return visitChildren(ctx);
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation returns the result of calling {@link #visitChildren} on {@code
   * ctx}.
   */
  @Override
  public T visitOption(PQL2Parser.OptionContext ctx) {
    return visitChildren(ctx);
  }
}
