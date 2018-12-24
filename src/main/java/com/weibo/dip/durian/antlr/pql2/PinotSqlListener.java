package com.weibo.dip.durian.antlr.pql2;

import com.weibo.dip.durian.Symbols;
import com.weibo.dip.durian.util.DatetimeUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.RuleContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PinotSqlListener extends PQL2BaseListener {
  private static final Logger LOGGER = LoggerFactory.getLogger(PinotSqlListener.class);

  private Analysis analysis = new Analysis();

  public Analysis getAnalysis() {
    return analysis;
  }

  private enum ClauseContext {
    /*
     optionalClause
    */
    OUTPUT_COLUMNS,
    WHERE,
    GROUP_BY,
    HAVING,
    ORDERBY,
    TOP,
    LIMIT,

    /*
     default
    */
    NULL
  }

  private Stack<ClauseContext> contexts = new Stack<>();

  private void inContext(ClauseContext context) {
    contexts.push(context);
  }

  private void upContext(ClauseContext context) {
    if (contexts.peek().equals(context)) {
      contexts.pop();
    } else {
      throw new RuntimeException(
          "clause context inconsistent, pop "
              + contexts.peek().name()
              + ", but up "
              + context.name());
    }
  }

  private boolean isContext(ClauseContext context) {
    return !(contexts.search(context) == -1);
  }

  private static final Set<String> AGGREGATE_FUNCTIONS = new HashSet<>();
  private static final Set<String> GRANULARITY_FUNCTIONS = new HashSet<>();

  public static final String MINUTES = "MINUTES";
  public static final String HOURS = "HOURS";
  public static final String DAYS = "DAYS";

  static {
    AGGREGATE_FUNCTIONS.add("COUNT");
    AGGREGATE_FUNCTIONS.add("SUM");
    AGGREGATE_FUNCTIONS.add("MAX");
    AGGREGATE_FUNCTIONS.add("MIN");
    AGGREGATE_FUNCTIONS.add("AVG");

    GRANULARITY_FUNCTIONS.add(MINUTES);
    GRANULARITY_FUNCTIONS.add(HOURS);
    GRANULARITY_FUNCTIONS.add(DAYS);
  }

  private static final String BOOLEAN_OPERATOR_AND = "AND";

  private static final String IDENTIFIER_FDATE = "fdate";

  private static final Pattern FDATE_PATTERN =
      Pattern.compile("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$");

  private Map<RuleContext, String> texts = new HashMap<>();

  private void setText(RuleContext context, String text) {
    if (!texts.containsKey(context)) {
      texts.put(context, text);
    }
  }

  private String getText(RuleContext context) {
    return texts.get(context);
  }

  public static final String FDATE_BEGIN_TIME = "$_FDATE_BEGIN_TIME";
  public static final String FDATE_END_TIME = "$_FDATE_END_TIME";

  /*
   selectStatement
  */

  @Override
  public void enterSelect(PQL2Parser.SelectContext ctx) {
    boolean hasWhere = false;
    boolean hasGroup = false;

    for (PQL2Parser.OptionalClauseContext optionalClauseContext : ctx.optionalClause()) {
      if (optionalClauseContext instanceof PQL2Parser.WhereContext) {
        hasWhere = true;
      } else if (optionalClauseContext instanceof PQL2Parser.GroupByContext) {
        hasGroup = true;
      }
    }

    if (!hasWhere) {
      throw new RuntimeException("sql: must have where clause");
    }

    if (!hasGroup) {
      throw new RuntimeException("sql: must have groupBy clause");
    }
  }

  @Override
  public void exitSelect(PQL2Parser.SelectContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(ctx.SELECT().getText().toUpperCase());

    if (ctx.topClause() != null) {
      buffer.append(Symbols.SPACE);
      buffer.append(getText(ctx.topClause()));
    }

    buffer.append(Symbols.SPACE);
    buffer.append(getText(ctx.outputColumns()));

    buffer.append(Symbols.SPACE);
    buffer.append(ctx.FROM().getText().toUpperCase());

    buffer.append(Symbols.SPACE);
    buffer.append(getText(ctx.tableName()));

    for (int index = 0; index < ctx.optionalClause().size(); index++) {
      buffer.append(Symbols.SPACE);
      buffer.append(getText(ctx.optionalClause(index)));
    }

    analysis.setSql(buffer.toString());
  }

  /*
   outputColumns
  */
  @Override
  public void enterStarColumnList(PQL2Parser.StarColumnListContext ctx) {
    throw new RuntimeException("select *: not supported");
  }

  @Override
  public void enterOutputColumnList(PQL2Parser.OutputColumnListContext ctx) {
    inContext(ClauseContext.OUTPUT_COLUMNS);
  }

  @Override
  public void exitOutputColumnList(PQL2Parser.OutputColumnListContext ctx) {
    List<String> buffer = new ArrayList<>();

    for (int index = 0; index < ctx.outputColumnProjection().size(); index++) {
      buffer.add(getText(ctx.outputColumnProjection(index)));
    }

    String outputColumns = StringUtils.join(buffer, Symbols.COMMA + Symbols.SPACE);

    setText(ctx, outputColumns);

    analysis.setOutputColumns(outputColumns);

    upContext(ClauseContext.OUTPUT_COLUMNS);
  }

  /*
   outputColumnProjection
  */
  @Override
  public void exitOutputColumn(PQL2Parser.OutputColumnContext ctx) {
    String expression = getText(ctx.expression());

    StringBuilder buffer = new StringBuilder();

    buffer.append(expression);

    if (ctx.AS() == null) {
      throw new RuntimeException(expression + ": expression must be specified a alias");
    }

    buffer.append(Symbols.SPACE);
    buffer.append(ctx.AS().getText().toUpperCase());
    buffer.append(Symbols.SPACE);

    String alias;

    if (ctx.IDENTIFIER() != null) {
      alias = ctx.IDENTIFIER().getText();
    } else {
      alias = ctx.STRING_LITERAL().getText();
    }

    buffer.append(alias);

    setText(ctx, buffer.toString());
  }

  /*
   expression
  */
  @Override
  public void exitIdentifier(PQL2Parser.IdentifierContext ctx) {
    setText(ctx, ctx.getText());
  }

  @Override
  public void exitConstant(PQL2Parser.ConstantContext ctx) {
    setText(ctx, getText(ctx.literal()));
  }

  @Override
  public void exitExpressionParenthesisGroup(PQL2Parser.ExpressionParenthesisGroupContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append("(");
    buffer.append(getText(ctx.expression()));
    buffer.append(")");

    String expression = buffer.toString();

    setText(ctx, expression);
  }

  @Override
  public void exitFunctionCall(PQL2Parser.FunctionCallContext ctx) {
    String functionName = getText(ctx.function());
    String functionParams = "";
    if (ctx.expressions() != null) {
      functionParams = getText(ctx.expressions());
    }

    if (isContext(ClauseContext.OUTPUT_COLUMNS)) {
      if (!(ctx.expressions().getChildCount() == 1
          && ctx.expressions().getChild(0) instanceof PQL2Parser.IdentifierContext)) {
        throw new RuntimeException(
            functionName + ": aggregate function parameter must be a metric field");
      }
    } else if (isContext(ClauseContext.GROUP_BY)) {
      if (!(ctx.expressions().getChildCount() == 1
          && ctx.expressions().getChild(0) instanceof PQL2Parser.ConstantContext
          && ((PQL2Parser.ConstantContext) ctx.expressions().getChild(0)).literal()
              instanceof PQL2Parser.IntegerLiteralContext)) {
        throw new RuntimeException(
            functionName + ": granularity function parameter must be a int number");
      }

      String granularityTimeUnit = functionName;
      int granularityTimeSize = Integer.valueOf(functionParams);

      analysis.setGranularityTimeUnit(granularityTimeUnit);
      analysis.setGranularityTimeSize(granularityTimeSize);

      functionName = "dateTimeConvert";

      List<String> params = new ArrayList<>();

      params.add(IDENTIFIER_FDATE);
      params.add("'1:MILLISECONDS:EPOCH'");
      params.add("'1:MILLISECONDS:EPOCH'");

      params.add("'" + granularityTimeSize + ":" + granularityTimeUnit + "'");

      functionParams = StringUtils.join(params, Symbols.COMMA + Symbols.SPACE);
    }

    StringBuilder buffer = new StringBuilder();

    buffer.append(functionName);
    buffer.append("(");
    if (functionParams != null) {
      buffer.append(functionParams);
    }
    buffer.append(")");

    String functionCallText = buffer.toString();

    setText(ctx, functionCallText);

    if (isContext(ClauseContext.OUTPUT_COLUMNS)) {
      if (!analysis.getAggregateFunctions().contains(functionCallText)) {
        analysis.addAggregateFunctions(functionCallText);
      }
    }
  }

  @Override
  public void exitBinaryMathOp(PQL2Parser.BinaryMathOpContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(getText(ctx.expression(0)));
    buffer.append(Symbols.SPACE);
    buffer.append(getText(ctx.binaryMathOperator()));
    buffer.append(Symbols.SPACE);
    buffer.append(getText(ctx.expression(1)));

    setText(ctx, buffer.toString());
  }

  @Override
  public void exitBinaryMathOperator(PQL2Parser.BinaryMathOperatorContext ctx) {
    setText(ctx, ctx.getText());
  }

  /*
   function
  */
  @Override
  public void enterFunction(PQL2Parser.FunctionContext ctx) {
    String funcName = ctx.IDENTIFIER().getText().toUpperCase();

    if (isContext(ClauseContext.OUTPUT_COLUMNS) && !AGGREGATE_FUNCTIONS.contains(funcName)) {
      throw new RuntimeException(funcName + ": aggregate function not supported");
    } else if (isContext(ClauseContext.GROUP_BY) && !GRANULARITY_FUNCTIONS.contains(funcName)) {
      throw new RuntimeException(funcName + ": granularity function not supported");
    }
  }

  @Override
  public void exitFunction(PQL2Parser.FunctionContext ctx) {
    setText(ctx, ctx.IDENTIFIER().getText().toUpperCase());
  }

  /*
    literal
  */
  @Override
  public void exitStringLiteral(PQL2Parser.StringLiteralContext ctx) {
    setText(ctx, ctx.STRING_LITERAL().getText());
  }

  @Override
  public void exitIntegerLiteral(PQL2Parser.IntegerLiteralContext ctx) {
    setText(ctx, ctx.INTEGER_LITERAL().getText());
  }

  @Override
  public void exitFloatingPointLiteral(PQL2Parser.FloatingPointLiteralContext ctx) {
    setText(ctx, ctx.FLOATING_POINT_LITERAL().getText());
  }

  /*
   expressions
  */
  @Override
  public void exitExpressionList(PQL2Parser.ExpressionListContext ctx) {
    List<String> buffer = new ArrayList<>();

    for (int index = 0; index < ctx.expression().size(); index++) {
      buffer.add(getText(ctx.expression(index)));
    }

    setText(ctx, StringUtils.join(buffer, Symbols.COMMA + Symbols.SPACE));
  }

  @Override
  public void exitStarExpression(PQL2Parser.StarExpressionContext ctx) {
    setText(ctx, ctx.getText());
  }

  /*
   tableName
  */
  @Override
  public void exitTableName(PQL2Parser.TableNameContext ctx) {
    String tableName = ctx.getText();

    setText(ctx, tableName);
    analysis.setTableName(tableName);
  }

  /*
   optionalClause
  */

  @Override
  public void enterWhere(PQL2Parser.WhereContext ctx) {}

  @Override
  public void exitWhere(PQL2Parser.WhereContext ctx) {
    setText(ctx, getText(ctx.whereClause()));
  }

  @Override
  public void enterGroupBy(PQL2Parser.GroupByContext ctx) {
    inContext(ClauseContext.GROUP_BY);
  }

  @Override
  public void exitGroupBy(PQL2Parser.GroupByContext ctx) {
    setText(ctx, getText(ctx.groupByClause()));

    upContext(ClauseContext.GROUP_BY);
  }

  @Override
  public void exitHaving(PQL2Parser.HavingContext ctx) {
    setText(ctx, getText(ctx.havingClause()));
  }

  @Override
  public void exitOrderBy(PQL2Parser.OrderByContext ctx) {
    setText(ctx, getText(ctx.orderByClause()));
  }

  @Override
  public void exitTop(PQL2Parser.TopContext ctx) {
    setText(ctx, getText(ctx.topClause()));
  }

  @Override
  public void exitLimit(PQL2Parser.LimitContext ctx) {
    setText(ctx, getText(ctx.limitClause()));
  }

  @Override
  public void exitOptions(PQL2Parser.OptionsContext ctx) {
    setText(ctx, getText(ctx.optionListClause()));
  }

  /*
   whereClause
  */

  @Override
  public void enterWhereClause(PQL2Parser.WhereClauseContext ctx) {
    inContext(ClauseContext.WHERE);

    PQL2Parser.PredicateContext firstPredicate = ctx.predicateList().predicate(0);

    String firstPredicateText = getText(firstPredicate);

    if (!(firstPredicate instanceof PQL2Parser.BetweenPredicateContext)) {
      throw new RuntimeException(
          firstPredicateText + ": Where clause first predicate must be between ... and ...");
    }

    PQL2Parser.BetweenClauseContext betweenClauseContext =
        ((PQL2Parser.BetweenPredicateContext) firstPredicate).betweenClause();

    PQL2Parser.ExpressionContext firstExpression = betweenClauseContext.expression(0);
    PQL2Parser.ExpressionContext secondExpression = betweenClauseContext.expression(1);
    PQL2Parser.ExpressionContext thirdExpression = betweenClauseContext.expression(2);

    if (!(firstExpression instanceof PQL2Parser.IdentifierContext
        && secondExpression instanceof PQL2Parser.ConstantContext
        && thirdExpression instanceof PQL2Parser.ConstantContext
        && ((PQL2Parser.ConstantContext) secondExpression).literal()
            instanceof PQL2Parser.StringLiteralContext
        && ((PQL2Parser.ConstantContext) thirdExpression).literal()
            instanceof PQL2Parser.StringLiteralContext)) {
      throw new RuntimeException(
          firstPredicateText
              + ": Where clause first predicate must be fdate between '...' and '...'");
    }

    String firstExpressionText = firstExpression.getText();

    String secondExpressionText =
        secondExpression.getText().substring(1, secondExpression.getText().length() - 1);
    String thirdExpressionText =
        thirdExpression.getText().substring(1, thirdExpression.getText().length() - 1);

    if (!(firstExpression.getText().equals(IDENTIFIER_FDATE)
        && FDATE_PATTERN.matcher(secondExpressionText).matches()
        && FDATE_PATTERN.matcher(thirdExpressionText).matches())) {
      throw new RuntimeException(
          firstPredicateText
              + ": Where clause first predicate must be fdate between 'yyyy-MM-dd HH:mm:ss' and 'yyyy-MM-dd HH:mm:ss'");
    }

    try {
      analysis.setBeginTime(
          DatetimeUtil.COMMON_DATETIME_FORMAT.parse(secondExpressionText).getTime());
      analysis.setEndTime(DatetimeUtil.COMMON_DATETIME_FORMAT.parse(thirdExpressionText).getTime());
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }

    if (ctx.predicateList().predicate().size() > 1) {
      PQL2Parser.BooleanOperatorContext firstBooleanOperator =
          ctx.predicateList().booleanOperator(0);

      String firstBooleanOperatorText = getText(firstBooleanOperator);

      if (!firstBooleanOperator.getText().toUpperCase().equals(BOOLEAN_OPERATOR_AND)) {
        throw new RuntimeException(
            firstBooleanOperatorText + ": Where clause first boolean operator must be and");
      }
    }
  }

  @Override
  public void exitWhereClause(PQL2Parser.WhereClauseContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(ctx.WHERE().getText().toUpperCase());
    buffer.append(Symbols.SPACE);

    String where = getText(ctx.predicateList());

    buffer.append(where);
    analysis.setWhere(where);

    setText(ctx, buffer.toString());

    upContext(ClauseContext.WHERE);
  }

  /*
   predicateList
  */
  @Override
  public void exitPredicateList(PQL2Parser.PredicateListContext ctx) {
    List<String> buffer = new ArrayList<>();

    buffer.add(getText(ctx.predicate(0)));

    for (int index = 1; index < ctx.predicate().size(); index++) {
      buffer.add(getText(ctx.booleanOperator(index - 1)));
      buffer.add(getText(ctx.predicate(index)));
    }

    setText(ctx, StringUtils.join(buffer, Symbols.SPACE));
  }

  /*
   predicate
  */
  @Override
  public void enterPredicateParenthesisGroup(PQL2Parser.PredicateParenthesisGroupContext ctx) {}

  @Override
  public void exitPredicateParenthesisGroup(PQL2Parser.PredicateParenthesisGroupContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(Symbols.LEFT_PARENTHESIS);
    buffer.append(getText(ctx.predicateList()));
    buffer.append(Symbols.RIGHT_PARENTHESIS);

    setText(ctx, buffer.toString());
  }

  @Override
  public void exitComparisonPredicate(PQL2Parser.ComparisonPredicateContext ctx) {
    setText(ctx, getText(ctx.comparisonClause()));
  }

  @Override
  public void exitInPredicate(PQL2Parser.InPredicateContext ctx) {
    setText(ctx, getText(ctx.inClause()));
  }

  @Override
  public void exitBetweenPredicate(PQL2Parser.BetweenPredicateContext ctx) {
    setText(ctx, getText(ctx.betweenClause()));
  }

  @Override
  public void exitIsPredicate(PQL2Parser.IsPredicateContext ctx) {
    setText(ctx, getText(ctx.isClause()));
  }

  @Override
  public void exitRegexpLikePredicate(PQL2Parser.RegexpLikePredicateContext ctx) {
    setText(ctx, getText(ctx.regexpLikeClause()));
  }

  /*
   inClause
  */
  @Override
  public void exitInClause(PQL2Parser.InClauseContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(getText(ctx.expression()));

    if (ctx.NOT() != null) {
      buffer.append(Symbols.SPACE);
      buffer.append(ctx.NOT().getText().toUpperCase());
    }

    buffer.append(Symbols.SPACE);
    buffer.append(ctx.IN().getText().toUpperCase());

    buffer.append(Symbols.SPACE);
    buffer.append(Symbols.LEFT_PARENTHESIS);

    List<String> literals = new ArrayList<>();

    for (int index = 0; index < ctx.literal().size(); index++) {
      literals.add(getText(ctx.literal(index)));
    }

    buffer.append(StringUtils.join(literals, Symbols.COMMA + Symbols.SPACE));

    buffer.append(Symbols.RIGHT_PARENTHESIS);

    setText(ctx, buffer.toString());
  }

  /*
   isClause
  */
  @Override
  public void exitIsClause(PQL2Parser.IsClauseContext ctx) {
    List<String> buffer = new ArrayList<>();

    buffer.add(getText(ctx.expression()));
    buffer.add(ctx.IS().getText().toUpperCase());
    if (ctx.NOT() != null) {
      buffer.add(ctx.NOT().getText().toUpperCase());
    }
    buffer.add(ctx.NULL().getText().toUpperCase());

    setText(ctx, StringUtils.join(buffer, Symbols.SPACE));
  }

  /*
   comparisonClause
  */
  @Override
  public void exitComparisonClause(PQL2Parser.ComparisonClauseContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(getText(ctx.expression(0)));
    buffer.append(Symbols.SPACE);
    buffer.append(getText(ctx.comparisonOperator()));
    buffer.append(Symbols.SPACE);
    buffer.append(getText(ctx.expression(1)));

    setText(ctx, buffer.toString());
  }

  /*
   betweenClause
  */
  @Override
  public void exitBetweenClause(PQL2Parser.BetweenClauseContext ctx) {
    List<String> buffer = new ArrayList<>();

    String firstExpressionText = getText(ctx.expression(0));

    buffer.add(firstExpressionText);
    buffer.add(ctx.BETWEEN().getText().toUpperCase());

    if (isContext(ClauseContext.WHERE) && firstExpressionText.equals(IDENTIFIER_FDATE)) {
      buffer.add(FDATE_BEGIN_TIME);
    } else {
      buffer.add(getText(ctx.expression(1)));
    }

    buffer.add(ctx.AND().getText().toUpperCase());

    if (isContext(ClauseContext.WHERE) && firstExpressionText.equals(IDENTIFIER_FDATE)) {
      buffer.add(FDATE_END_TIME);
    } else {
      buffer.add(getText(ctx.expression(2)));
    }

    setText(ctx, StringUtils.join(buffer, Symbols.SPACE));
  }

  /*
   regexpLikeClause
  */
  @Override
  public void exitRegexpLikeClause(PQL2Parser.RegexpLikeClauseContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(ctx.REGEXP_LIKE().getText().toUpperCase());
    buffer.append(Symbols.SPACE);
    buffer.append(Symbols.LEFT_PARENTHESIS);
    buffer.append(getText(ctx.expression()));
    buffer.append(Symbols.COMMA + Symbols.SPACE);
    buffer.append(getText(ctx.literal()));
    buffer.append(Symbols.RIGHT_PARENTHESIS);

    setText(ctx, buffer.toString());
  }

  /*
   comparisonOperator
  */
  @Override
  public void exitComparisonOperator(PQL2Parser.ComparisonOperatorContext ctx) {
    setText(ctx, ctx.getText());
  }

  /*
   booleanOperator
  */
  @Override
  public void exitBooleanOperator(PQL2Parser.BooleanOperatorContext ctx) {
    setText(ctx, ctx.getText());
  }

  /*
   groupByClause
  */
  @Override
  public void enterGroupByClause(PQL2Parser.GroupByClauseContext ctx) {
    for (int index = 0; index < ctx.groupByList().expression().size(); index++) {
      PQL2Parser.ExpressionContext expressionContext = ctx.groupByList().expression(index);

      if (index == 0) {
        if (!(expressionContext instanceof PQL2Parser.FunctionCallContext)) {
          throw new RuntimeException("Group clause first expression must be a function");
        }
      } else {
        if (!(expressionContext instanceof PQL2Parser.IdentifierContext)) {
          throw new RuntimeException("Group clause expression must be a dimession, except first");
        }
      }
    }
  }

  @Override
  public void exitGroupByClause(PQL2Parser.GroupByClauseContext ctx) {
    List<String> buffer = new ArrayList<>();

    buffer.add(ctx.GROUP().getText().toUpperCase());
    buffer.add(ctx.BY().getText().toUpperCase());

    String groupBy = getText(ctx.groupByList());

    buffer.add(groupBy);
    analysis.setGroupBy(groupBy);

    setText(ctx, StringUtils.join(buffer, Symbols.SPACE));
  }

  /*
   groupByList
  */
  @Override
  public void exitGroupByList(PQL2Parser.GroupByListContext ctx) {
    List<String> buffer = new ArrayList<>();

    for (int index = 0; index < ctx.expression().size(); index++) {
      buffer.add(getText(ctx.expression(index)));
    }

    setText(ctx, StringUtils.join(buffer, Symbols.COMMA + Symbols.SPACE));
  }

  /*
   havingClause
  */
  @Override
  public void exitHavingClause(PQL2Parser.HavingClauseContext ctx) {
    String having = getText(ctx.predicateList());

    setText(ctx, ctx.HAVING().getText().toUpperCase() + Symbols.SPACE + having);
    analysis.setHaving(having);
  }

  /*
   orderByClause
  */
  @Override
  public void exitOrderByClause(PQL2Parser.OrderByClauseContext ctx) {
    List<String> buffer = new ArrayList<>();

    buffer.add(ctx.ORDER().getText().toUpperCase());
    buffer.add(ctx.BY().getText().toUpperCase());

    String orderBy = getText(ctx.orderByList());

    buffer.add(orderBy);
    analysis.setOrderBy(orderBy);

    setText(ctx, StringUtils.join(buffer, Symbols.SPACE));
  }

  /*
   orderByList
  */
  @Override
  public void exitOrderByList(PQL2Parser.OrderByListContext ctx) {
    List<String> buffer = new ArrayList<>();

    for (int index = 0; index < ctx.orderByExpression().size(); index++) {
      buffer.add(getText(ctx.orderByExpression(index)));
    }

    setText(ctx, StringUtils.join(buffer, Symbols.COMMA + Symbols.SPACE));
  }

  /*
   orderByExpression
  */
  @Override
  public void exitOrderByExpression(PQL2Parser.OrderByExpressionContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(getText(ctx.expression()));
    if (ctx.ordering() != null) {
      buffer.append(Symbols.SPACE);
      buffer.append(getText(ctx.ordering()));
    }

    setText(ctx, buffer.toString());
  }

  /*
   ordering
  */
  @Override
  public void exitOrdering(PQL2Parser.OrderingContext ctx) {
    setText(ctx, ctx.getText());
  }

  /*
   topClause
  */
  @Override
  public void exitTopClause(PQL2Parser.TopClauseContext ctx) {
    String top = ctx.INTEGER_LITERAL().getText();

    setText(ctx, ctx.TOP().getText().toUpperCase() + Symbols.SPACE + top);
    analysis.setTop(top);
  }

  /*
   limitClause
  */
  @Override
  public void exitLimitClause(PQL2Parser.LimitClauseContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(ctx.LIMIT().getText().toUpperCase());
    buffer.append(Symbols.SPACE);

    List<String> integers = new ArrayList<>();

    for (int index = 0; index < ctx.INTEGER_LITERAL().size(); index++) {
      integers.add(ctx.INTEGER_LITERAL(index).getText());
    }

    String limit = StringUtils.join(integers, Symbols.COMMA + Symbols.SPACE);

    buffer.append(limit);
    analysis.setLimit(limit);

    setText(ctx, buffer.toString());
  }

  /*
   optionListClause
  */
  @Override
  public void exitOptionListClause(PQL2Parser.OptionListClauseContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(ctx.OPTION().getText().toUpperCase());
    buffer.append(Symbols.SPACE);
    buffer.append(Symbols.LEFT_PARENTHESIS);

    List<String> options = new ArrayList<>();

    for (int index = 0; index < ctx.option().size(); index++) {
      options.add(getText(ctx.option(index)));
    }

    buffer.append(StringUtils.join(options, Symbols.COMMA + Symbols.SPACE));

    buffer.append(Symbols.RIGHT_PARENTHESIS);

    setText(ctx, buffer.toString());
  }

  /*
   option
  */
  @Override
  public void exitOption(PQL2Parser.OptionContext ctx) {
    List<String> buffer = new ArrayList<>();

    for (int index = 0; index < ctx.expression().size(); index++) {
      buffer.add(getText(ctx.expression(index)));
    }

    setText(ctx, StringUtils.join(buffer, Symbols.EQUAL));
  }
}
