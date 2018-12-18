package com.weibo.dip.durian.antlr.pql2; // Generated from PQL2.g4 by ANTLR 4.7.1

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link
 * PQL2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface PQL2Visitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link PQL2Parser#root}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRoot(PQL2Parser.RootContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#statement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStatement(PQL2Parser.StatementContext ctx);
  /**
   * Visit a parse tree produced by the {@code Select} labeled alternative in {@link
   * PQL2Parser#selectStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSelect(PQL2Parser.SelectContext ctx);
  /**
   * Visit a parse tree produced by the {@code Where} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitWhere(PQL2Parser.WhereContext ctx);
  /**
   * Visit a parse tree produced by the {@code GroupBy} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitGroupBy(PQL2Parser.GroupByContext ctx);
  /**
   * Visit a parse tree produced by the {@code Having} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitHaving(PQL2Parser.HavingContext ctx);
  /**
   * Visit a parse tree produced by the {@code OrderBy} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOrderBy(PQL2Parser.OrderByContext ctx);
  /**
   * Visit a parse tree produced by the {@code Top} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTop(PQL2Parser.TopContext ctx);
  /**
   * Visit a parse tree produced by the {@code Limit} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLimit(PQL2Parser.LimitContext ctx);
  /**
   * Visit a parse tree produced by the {@code Options} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOptions(PQL2Parser.OptionsContext ctx);
  /**
   * Visit a parse tree produced by the {@code StarColumnList} labeled alternative in {@link
   * PQL2Parser#outputColumns}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStarColumnList(PQL2Parser.StarColumnListContext ctx);
  /**
   * Visit a parse tree produced by the {@code OutputColumnList} labeled alternative in {@link
   * PQL2Parser#outputColumns}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOutputColumnList(PQL2Parser.OutputColumnListContext ctx);
  /**
   * Visit a parse tree produced by the {@code OutputColumn} labeled alternative in {@link
   * PQL2Parser#outputColumnProjection}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOutputColumn(PQL2Parser.OutputColumnContext ctx);
  /**
   * Visit a parse tree produced by the {@code ExpressionParenthesisGroup} labeled alternative in
   * {@link PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpressionParenthesisGroup(PQL2Parser.ExpressionParenthesisGroupContext ctx);
  /**
   * Visit a parse tree produced by the {@code Identifier} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdentifier(PQL2Parser.IdentifierContext ctx);
  /**
   * Visit a parse tree produced by the {@code Constant} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstant(PQL2Parser.ConstantContext ctx);
  /**
   * Visit a parse tree produced by the {@code BinaryMathOp} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBinaryMathOp(PQL2Parser.BinaryMathOpContext ctx);
  /**
   * Visit a parse tree produced by the {@code FunctionCall} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionCall(PQL2Parser.FunctionCallContext ctx);
  /**
   * Visit a parse tree produced by the {@code ExpressionList} labeled alternative in {@link
   * PQL2Parser#expressions}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpressionList(PQL2Parser.ExpressionListContext ctx);
  /**
   * Visit a parse tree produced by the {@code StarExpression} labeled alternative in {@link
   * PQL2Parser#expressions}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStarExpression(PQL2Parser.StarExpressionContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#binaryMathOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBinaryMathOperator(PQL2Parser.BinaryMathOperatorContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#function}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunction(PQL2Parser.FunctionContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#tableName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTableName(PQL2Parser.TableNameContext ctx);
  /**
   * Visit a parse tree produced by the {@code StringLiteral} labeled alternative in {@link
   * PQL2Parser#literal}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStringLiteral(PQL2Parser.StringLiteralContext ctx);
  /**
   * Visit a parse tree produced by the {@code IntegerLiteral} labeled alternative in {@link
   * PQL2Parser#literal}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIntegerLiteral(PQL2Parser.IntegerLiteralContext ctx);
  /**
   * Visit a parse tree produced by the {@code FloatingPointLiteral} labeled alternative in {@link
   * PQL2Parser#literal}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFloatingPointLiteral(PQL2Parser.FloatingPointLiteralContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#whereClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitWhereClause(PQL2Parser.WhereClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#predicateList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPredicateList(PQL2Parser.PredicateListContext ctx);
  /**
   * Visit a parse tree produced by the {@code PredicateParenthesisGroup} labeled alternative in
   * {@link PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPredicateParenthesisGroup(PQL2Parser.PredicateParenthesisGroupContext ctx);
  /**
   * Visit a parse tree produced by the {@code ComparisonPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComparisonPredicate(PQL2Parser.ComparisonPredicateContext ctx);
  /**
   * Visit a parse tree produced by the {@code InPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInPredicate(PQL2Parser.InPredicateContext ctx);
  /**
   * Visit a parse tree produced by the {@code BetweenPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBetweenPredicate(PQL2Parser.BetweenPredicateContext ctx);
  /**
   * Visit a parse tree produced by the {@code IsPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIsPredicate(PQL2Parser.IsPredicateContext ctx);
  /**
   * Visit a parse tree produced by the {@code RegexpLikePredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRegexpLikePredicate(PQL2Parser.RegexpLikePredicateContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#inClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInClause(PQL2Parser.InClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#isClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIsClause(PQL2Parser.IsClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#comparisonClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComparisonClause(PQL2Parser.ComparisonClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#comparisonOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComparisonOperator(PQL2Parser.ComparisonOperatorContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#betweenClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBetweenClause(PQL2Parser.BetweenClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#regexpLikeClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRegexpLikeClause(PQL2Parser.RegexpLikeClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#booleanOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBooleanOperator(PQL2Parser.BooleanOperatorContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#groupByClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitGroupByClause(PQL2Parser.GroupByClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#groupByList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitGroupByList(PQL2Parser.GroupByListContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#havingClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitHavingClause(PQL2Parser.HavingClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#orderByClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOrderByClause(PQL2Parser.OrderByClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#orderByList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOrderByList(PQL2Parser.OrderByListContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#orderByExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOrderByExpression(PQL2Parser.OrderByExpressionContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#ordering}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOrdering(PQL2Parser.OrderingContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#topClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTopClause(PQL2Parser.TopClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#limitClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLimitClause(PQL2Parser.LimitClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#optionListClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOptionListClause(PQL2Parser.OptionListClauseContext ctx);
  /**
   * Visit a parse tree produced by {@link PQL2Parser#option}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOption(PQL2Parser.OptionContext ctx);
}
