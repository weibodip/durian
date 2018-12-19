package com.weibo.dip.durian.antlr.pql2; // Generated from PQL2.g4 by ANTLR 4.7.1

import org.antlr.v4.runtime.tree.ParseTreeListener;

/** This interface defines a complete listener for a parse tree produced by {@link PQL2Parser}. */
public interface PQL2Listener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link PQL2Parser#root}.
   *
   * @param ctx the parse tree
   */
  void enterRoot(PQL2Parser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#root}.
   *
   * @param ctx the parse tree
   */
  void exitRoot(PQL2Parser.RootContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#statement}.
   *
   * @param ctx the parse tree
   */
  void enterStatement(PQL2Parser.StatementContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#statement}.
   *
   * @param ctx the parse tree
   */
  void exitStatement(PQL2Parser.StatementContext ctx);
  /**
   * Enter a parse tree produced by the {@code Select} labeled alternative in {@link
   * PQL2Parser#selectStatement}.
   *
   * @param ctx the parse tree
   */
  void enterSelect(PQL2Parser.SelectContext ctx);
  /**
   * Exit a parse tree produced by the {@code Select} labeled alternative in {@link
   * PQL2Parser#selectStatement}.
   *
   * @param ctx the parse tree
   */
  void exitSelect(PQL2Parser.SelectContext ctx);
  /**
   * Enter a parse tree produced by the {@code Where} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void enterWhere(PQL2Parser.WhereContext ctx);
  /**
   * Exit a parse tree produced by the {@code Where} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void exitWhere(PQL2Parser.WhereContext ctx);
  /**
   * Enter a parse tree produced by the {@code GroupBy} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void enterGroupBy(PQL2Parser.GroupByContext ctx);
  /**
   * Exit a parse tree produced by the {@code GroupBy} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void exitGroupBy(PQL2Parser.GroupByContext ctx);
  /**
   * Enter a parse tree produced by the {@code Having} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void enterHaving(PQL2Parser.HavingContext ctx);
  /**
   * Exit a parse tree produced by the {@code Having} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void exitHaving(PQL2Parser.HavingContext ctx);
  /**
   * Enter a parse tree produced by the {@code OrderBy} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void enterOrderBy(PQL2Parser.OrderByContext ctx);
  /**
   * Exit a parse tree produced by the {@code OrderBy} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void exitOrderBy(PQL2Parser.OrderByContext ctx);
  /**
   * Enter a parse tree produced by the {@code Top} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void enterTop(PQL2Parser.TopContext ctx);
  /**
   * Exit a parse tree produced by the {@code Top} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void exitTop(PQL2Parser.TopContext ctx);
  /**
   * Enter a parse tree produced by the {@code Limit} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void enterLimit(PQL2Parser.LimitContext ctx);
  /**
   * Exit a parse tree produced by the {@code Limit} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void exitLimit(PQL2Parser.LimitContext ctx);
  /**
   * Enter a parse tree produced by the {@code Options} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void enterOptions(PQL2Parser.OptionsContext ctx);
  /**
   * Exit a parse tree produced by the {@code Options} labeled alternative in {@link
   * PQL2Parser#optionalClause}.
   *
   * @param ctx the parse tree
   */
  void exitOptions(PQL2Parser.OptionsContext ctx);
  /**
   * Enter a parse tree produced by the {@code StarColumnList} labeled alternative in {@link
   * PQL2Parser#outputColumns}.
   *
   * @param ctx the parse tree
   */
  void enterStarColumnList(PQL2Parser.StarColumnListContext ctx);
  /**
   * Exit a parse tree produced by the {@code StarColumnList} labeled alternative in {@link
   * PQL2Parser#outputColumns}.
   *
   * @param ctx the parse tree
   */
  void exitStarColumnList(PQL2Parser.StarColumnListContext ctx);
  /**
   * Enter a parse tree produced by the {@code OutputColumnList} labeled alternative in {@link
   * PQL2Parser#outputColumns}.
   *
   * @param ctx the parse tree
   */
  void enterOutputColumnList(PQL2Parser.OutputColumnListContext ctx);
  /**
   * Exit a parse tree produced by the {@code OutputColumnList} labeled alternative in {@link
   * PQL2Parser#outputColumns}.
   *
   * @param ctx the parse tree
   */
  void exitOutputColumnList(PQL2Parser.OutputColumnListContext ctx);
  /**
   * Enter a parse tree produced by the {@code OutputColumn} labeled alternative in {@link
   * PQL2Parser#outputColumnProjection}.
   *
   * @param ctx the parse tree
   */
  void enterOutputColumn(PQL2Parser.OutputColumnContext ctx);
  /**
   * Exit a parse tree produced by the {@code OutputColumn} labeled alternative in {@link
   * PQL2Parser#outputColumnProjection}.
   *
   * @param ctx the parse tree
   */
  void exitOutputColumn(PQL2Parser.OutputColumnContext ctx);
  /**
   * Enter a parse tree produced by the {@code ExpressionParenthesisGroup} labeled alternative in
   * {@link PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void enterExpressionParenthesisGroup(PQL2Parser.ExpressionParenthesisGroupContext ctx);
  /**
   * Exit a parse tree produced by the {@code ExpressionParenthesisGroup} labeled alternative in
   * {@link PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void exitExpressionParenthesisGroup(PQL2Parser.ExpressionParenthesisGroupContext ctx);
  /**
   * Enter a parse tree produced by the {@code Identifier} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void enterIdentifier(PQL2Parser.IdentifierContext ctx);
  /**
   * Exit a parse tree produced by the {@code Identifier} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void exitIdentifier(PQL2Parser.IdentifierContext ctx);
  /**
   * Enter a parse tree produced by the {@code Constant} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void enterConstant(PQL2Parser.ConstantContext ctx);
  /**
   * Exit a parse tree produced by the {@code Constant} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void exitConstant(PQL2Parser.ConstantContext ctx);
  /**
   * Enter a parse tree produced by the {@code BinaryMathOp} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void enterBinaryMathOp(PQL2Parser.BinaryMathOpContext ctx);
  /**
   * Exit a parse tree produced by the {@code BinaryMathOp} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void exitBinaryMathOp(PQL2Parser.BinaryMathOpContext ctx);
  /**
   * Enter a parse tree produced by the {@code FunctionCall} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void enterFunctionCall(PQL2Parser.FunctionCallContext ctx);
  /**
   * Exit a parse tree produced by the {@code FunctionCall} labeled alternative in {@link
   * PQL2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void exitFunctionCall(PQL2Parser.FunctionCallContext ctx);
  /**
   * Enter a parse tree produced by the {@code ExpressionList} labeled alternative in {@link
   * PQL2Parser#expressions}.
   *
   * @param ctx the parse tree
   */
  void enterExpressionList(PQL2Parser.ExpressionListContext ctx);
  /**
   * Exit a parse tree produced by the {@code ExpressionList} labeled alternative in {@link
   * PQL2Parser#expressions}.
   *
   * @param ctx the parse tree
   */
  void exitExpressionList(PQL2Parser.ExpressionListContext ctx);
  /**
   * Enter a parse tree produced by the {@code StarExpression} labeled alternative in {@link
   * PQL2Parser#expressions}.
   *
   * @param ctx the parse tree
   */
  void enterStarExpression(PQL2Parser.StarExpressionContext ctx);
  /**
   * Exit a parse tree produced by the {@code StarExpression} labeled alternative in {@link
   * PQL2Parser#expressions}.
   *
   * @param ctx the parse tree
   */
  void exitStarExpression(PQL2Parser.StarExpressionContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#binaryMathOperator}.
   *
   * @param ctx the parse tree
   */
  void enterBinaryMathOperator(PQL2Parser.BinaryMathOperatorContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#binaryMathOperator}.
   *
   * @param ctx the parse tree
   */
  void exitBinaryMathOperator(PQL2Parser.BinaryMathOperatorContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#function}.
   *
   * @param ctx the parse tree
   */
  void enterFunction(PQL2Parser.FunctionContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#function}.
   *
   * @param ctx the parse tree
   */
  void exitFunction(PQL2Parser.FunctionContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#tableName}.
   *
   * @param ctx the parse tree
   */
  void enterTableName(PQL2Parser.TableNameContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#tableName}.
   *
   * @param ctx the parse tree
   */
  void exitTableName(PQL2Parser.TableNameContext ctx);
  /**
   * Enter a parse tree produced by the {@code StringLiteral} labeled alternative in {@link
   * PQL2Parser#literal}.
   *
   * @param ctx the parse tree
   */
  void enterStringLiteral(PQL2Parser.StringLiteralContext ctx);
  /**
   * Exit a parse tree produced by the {@code StringLiteral} labeled alternative in {@link
   * PQL2Parser#literal}.
   *
   * @param ctx the parse tree
   */
  void exitStringLiteral(PQL2Parser.StringLiteralContext ctx);
  /**
   * Enter a parse tree produced by the {@code IntegerLiteral} labeled alternative in {@link
   * PQL2Parser#literal}.
   *
   * @param ctx the parse tree
   */
  void enterIntegerLiteral(PQL2Parser.IntegerLiteralContext ctx);
  /**
   * Exit a parse tree produced by the {@code IntegerLiteral} labeled alternative in {@link
   * PQL2Parser#literal}.
   *
   * @param ctx the parse tree
   */
  void exitIntegerLiteral(PQL2Parser.IntegerLiteralContext ctx);
  /**
   * Enter a parse tree produced by the {@code FloatingPointLiteral} labeled alternative in {@link
   * PQL2Parser#literal}.
   *
   * @param ctx the parse tree
   */
  void enterFloatingPointLiteral(PQL2Parser.FloatingPointLiteralContext ctx);
  /**
   * Exit a parse tree produced by the {@code FloatingPointLiteral} labeled alternative in {@link
   * PQL2Parser#literal}.
   *
   * @param ctx the parse tree
   */
  void exitFloatingPointLiteral(PQL2Parser.FloatingPointLiteralContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#whereClause}.
   *
   * @param ctx the parse tree
   */
  void enterWhereClause(PQL2Parser.WhereClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#whereClause}.
   *
   * @param ctx the parse tree
   */
  void exitWhereClause(PQL2Parser.WhereClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#predicateList}.
   *
   * @param ctx the parse tree
   */
  void enterPredicateList(PQL2Parser.PredicateListContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#predicateList}.
   *
   * @param ctx the parse tree
   */
  void exitPredicateList(PQL2Parser.PredicateListContext ctx);
  /**
   * Enter a parse tree produced by the {@code PredicateParenthesisGroup} labeled alternative in
   * {@link PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void enterPredicateParenthesisGroup(PQL2Parser.PredicateParenthesisGroupContext ctx);
  /**
   * Exit a parse tree produced by the {@code PredicateParenthesisGroup} labeled alternative in
   * {@link PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void exitPredicateParenthesisGroup(PQL2Parser.PredicateParenthesisGroupContext ctx);
  /**
   * Enter a parse tree produced by the {@code ComparisonPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void enterComparisonPredicate(PQL2Parser.ComparisonPredicateContext ctx);
  /**
   * Exit a parse tree produced by the {@code ComparisonPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void exitComparisonPredicate(PQL2Parser.ComparisonPredicateContext ctx);
  /**
   * Enter a parse tree produced by the {@code InPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void enterInPredicate(PQL2Parser.InPredicateContext ctx);
  /**
   * Exit a parse tree produced by the {@code InPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void exitInPredicate(PQL2Parser.InPredicateContext ctx);
  /**
   * Enter a parse tree produced by the {@code BetweenPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void enterBetweenPredicate(PQL2Parser.BetweenPredicateContext ctx);
  /**
   * Exit a parse tree produced by the {@code BetweenPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void exitBetweenPredicate(PQL2Parser.BetweenPredicateContext ctx);
  /**
   * Enter a parse tree produced by the {@code IsPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void enterIsPredicate(PQL2Parser.IsPredicateContext ctx);
  /**
   * Exit a parse tree produced by the {@code IsPredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void exitIsPredicate(PQL2Parser.IsPredicateContext ctx);
  /**
   * Enter a parse tree produced by the {@code RegexpLikePredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void enterRegexpLikePredicate(PQL2Parser.RegexpLikePredicateContext ctx);
  /**
   * Exit a parse tree produced by the {@code RegexpLikePredicate} labeled alternative in {@link
   * PQL2Parser#predicate}.
   *
   * @param ctx the parse tree
   */
  void exitRegexpLikePredicate(PQL2Parser.RegexpLikePredicateContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#inClause}.
   *
   * @param ctx the parse tree
   */
  void enterInClause(PQL2Parser.InClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#inClause}.
   *
   * @param ctx the parse tree
   */
  void exitInClause(PQL2Parser.InClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#isClause}.
   *
   * @param ctx the parse tree
   */
  void enterIsClause(PQL2Parser.IsClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#isClause}.
   *
   * @param ctx the parse tree
   */
  void exitIsClause(PQL2Parser.IsClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#comparisonClause}.
   *
   * @param ctx the parse tree
   */
  void enterComparisonClause(PQL2Parser.ComparisonClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#comparisonClause}.
   *
   * @param ctx the parse tree
   */
  void exitComparisonClause(PQL2Parser.ComparisonClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#comparisonOperator}.
   *
   * @param ctx the parse tree
   */
  void enterComparisonOperator(PQL2Parser.ComparisonOperatorContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#comparisonOperator}.
   *
   * @param ctx the parse tree
   */
  void exitComparisonOperator(PQL2Parser.ComparisonOperatorContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#betweenClause}.
   *
   * @param ctx the parse tree
   */
  void enterBetweenClause(PQL2Parser.BetweenClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#betweenClause}.
   *
   * @param ctx the parse tree
   */
  void exitBetweenClause(PQL2Parser.BetweenClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#regexpLikeClause}.
   *
   * @param ctx the parse tree
   */
  void enterRegexpLikeClause(PQL2Parser.RegexpLikeClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#regexpLikeClause}.
   *
   * @param ctx the parse tree
   */
  void exitRegexpLikeClause(PQL2Parser.RegexpLikeClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#booleanOperator}.
   *
   * @param ctx the parse tree
   */
  void enterBooleanOperator(PQL2Parser.BooleanOperatorContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#booleanOperator}.
   *
   * @param ctx the parse tree
   */
  void exitBooleanOperator(PQL2Parser.BooleanOperatorContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#groupByClause}.
   *
   * @param ctx the parse tree
   */
  void enterGroupByClause(PQL2Parser.GroupByClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#groupByClause}.
   *
   * @param ctx the parse tree
   */
  void exitGroupByClause(PQL2Parser.GroupByClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#groupByList}.
   *
   * @param ctx the parse tree
   */
  void enterGroupByList(PQL2Parser.GroupByListContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#groupByList}.
   *
   * @param ctx the parse tree
   */
  void exitGroupByList(PQL2Parser.GroupByListContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#havingClause}.
   *
   * @param ctx the parse tree
   */
  void enterHavingClause(PQL2Parser.HavingClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#havingClause}.
   *
   * @param ctx the parse tree
   */
  void exitHavingClause(PQL2Parser.HavingClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#orderByClause}.
   *
   * @param ctx the parse tree
   */
  void enterOrderByClause(PQL2Parser.OrderByClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#orderByClause}.
   *
   * @param ctx the parse tree
   */
  void exitOrderByClause(PQL2Parser.OrderByClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#orderByList}.
   *
   * @param ctx the parse tree
   */
  void enterOrderByList(PQL2Parser.OrderByListContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#orderByList}.
   *
   * @param ctx the parse tree
   */
  void exitOrderByList(PQL2Parser.OrderByListContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#orderByExpression}.
   *
   * @param ctx the parse tree
   */
  void enterOrderByExpression(PQL2Parser.OrderByExpressionContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#orderByExpression}.
   *
   * @param ctx the parse tree
   */
  void exitOrderByExpression(PQL2Parser.OrderByExpressionContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#ordering}.
   *
   * @param ctx the parse tree
   */
  void enterOrdering(PQL2Parser.OrderingContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#ordering}.
   *
   * @param ctx the parse tree
   */
  void exitOrdering(PQL2Parser.OrderingContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#topClause}.
   *
   * @param ctx the parse tree
   */
  void enterTopClause(PQL2Parser.TopClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#topClause}.
   *
   * @param ctx the parse tree
   */
  void exitTopClause(PQL2Parser.TopClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#limitClause}.
   *
   * @param ctx the parse tree
   */
  void enterLimitClause(PQL2Parser.LimitClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#limitClause}.
   *
   * @param ctx the parse tree
   */
  void exitLimitClause(PQL2Parser.LimitClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#optionListClause}.
   *
   * @param ctx the parse tree
   */
  void enterOptionListClause(PQL2Parser.OptionListClauseContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#optionListClause}.
   *
   * @param ctx the parse tree
   */
  void exitOptionListClause(PQL2Parser.OptionListClauseContext ctx);
  /**
   * Enter a parse tree produced by {@link PQL2Parser#option}.
   *
   * @param ctx the parse tree
   */
  void enterOption(PQL2Parser.OptionContext ctx);
  /**
   * Exit a parse tree produced by {@link PQL2Parser#option}.
   *
   * @param ctx the parse tree
   */
  void exitOption(PQL2Parser.OptionContext ctx);
}
