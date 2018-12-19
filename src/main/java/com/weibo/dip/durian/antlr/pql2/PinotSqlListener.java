package com.weibo.dip.durian.antlr.pql2;

import com.weibo.dip.durian.Symbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.antlr.v4.runtime.RuleContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PinotSqlListener extends PQL2BaseListener {
  private static final Logger LOGGER = LoggerFactory.getLogger(PinotSqlListener.class);

  private static final Set<String> FUNCTIONS = new HashSet<>();

  static {
    FUNCTIONS.add("SUM");
    FUNCTIONS.add("MAX");
    FUNCTIONS.add("MIN");
    FUNCTIONS.add("AVG");
  }

  private Map<RuleContext, String> texts = new HashMap<>();

  private void setText(RuleContext context, String text) {
    texts.put(context, text);
  }

  private String getText(RuleContext context) {
    return texts.get(context);
  }

  /*
   selectStatement
  */
  @Override
  public void exitSelect(PQL2Parser.SelectContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(ctx.SELECT().getText());

    if (ctx.topClause() != null) {
      buffer.append(Symbols.SPACE);
      buffer.append(getText(ctx.topClause()));
    }

    buffer.append(Symbols.SPACE);
    buffer.append(getText(ctx.outputColumns()));

    buffer.append(Symbols.SPACE);
    buffer.append(ctx.FROM().getText());

    buffer.append(Symbols.SPACE);
    buffer.append(getText(ctx.tableName()));

    for (int index = 0; index < ctx.optionalClause().size(); index++) {
      buffer.append(Symbols.SPACE);
      buffer.append(getText(ctx.optionalClause(index)));
    }

    LOGGER.info(buffer.toString());
  }

  /*
   outputColumns
  */
  @Override
  public void exitStarColumnList(PQL2Parser.StarColumnListContext ctx) {
    setText(ctx, Symbols.ASTERISK);
  }

  @Override
  public void exitOutputColumnList(PQL2Parser.OutputColumnListContext ctx) {
    List<String> buffer = new ArrayList<>();

    for (int index = 0; index < ctx.outputColumnProjection().size(); index++) {
      buffer.add(getText(ctx.outputColumnProjection(index)));
    }

    setText(ctx, StringUtils.join(buffer, Symbols.COMMA + Symbols.SPACE));
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
    buffer.append(ctx.AS().getText());
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

    if (!(ctx.expression() instanceof PQL2Parser.BinaryMathOpContext)) {
      throw new RuntimeException(
          expression + ": parenthesis isn't supported in a single expression");
    }

    setText(ctx, expression);
  }

  @Override
  public void exitFunctionCall(PQL2Parser.FunctionCallContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(getText(ctx.function()));
    buffer.append("(");
    if (ctx.expressions() != null) {
      buffer.append(getText(ctx.expressions()));
    }
    buffer.append(")");

    String funcCall = buffer.toString();

    if (!(ctx.expressions().getChildCount() == 1
        && ctx.expressions().getChild(0) instanceof PQL2Parser.IdentifierContext)) {
      throw new RuntimeException(funcCall + ": parameters must be a metric field");
    }

    setText(ctx, funcCall);
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
  public void exitFunction(PQL2Parser.FunctionContext ctx) {
    String funcName = ctx.IDENTIFIER().getText();
    if (!FUNCTIONS.contains(funcName.toUpperCase())) {
      throw new RuntimeException(funcName + ": function not supported");
    }

    setText(ctx, funcName);
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
  }

  /*
   optionalClause
  */
  @Override
  public void exitWhere(PQL2Parser.WhereContext ctx) {
    setText(ctx, getText(ctx.whereClause()));
  }

  @Override
  public void exitGroupBy(PQL2Parser.GroupByContext ctx) {
    setText(ctx, getText(ctx.groupByClause()));
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
  public void exitWhereClause(PQL2Parser.WhereClauseContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(ctx.WHERE().getText());
    buffer.append(Symbols.SPACE);
    buffer.append(getText(ctx.predicateList()));

    setText(ctx, buffer.toString());
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
      buffer.append(ctx.NOT().getText());
    }

    buffer.append(Symbols.SPACE);
    buffer.append(ctx.IN().getText());

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
    buffer.add(ctx.IS().getText());
    if (ctx.NOT() != null) {
      buffer.add(ctx.NOT().getText());
    }
    buffer.add(ctx.NULL().getText());

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

    buffer.add(getText(ctx.expression(0)));
    buffer.add(ctx.BETWEEN().getText());
    buffer.add(getText(ctx.expression(1)));
    buffer.add(ctx.AND().getText());
    buffer.add(getText(ctx.expression(2)));

    setText(ctx, StringUtils.join(buffer, Symbols.SPACE));
  }

  /*
   regexpLikeClause
  */
  @Override
  public void exitRegexpLikeClause(PQL2Parser.RegexpLikeClauseContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(ctx.REGEXP_LIKE().getText());
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
  public void exitGroupByClause(PQL2Parser.GroupByClauseContext ctx) {
    List<String> buffer = new ArrayList<>();

    buffer.add(ctx.GROUP().getText());
    buffer.add(ctx.BY().getText());
    buffer.add(getText(ctx.groupByList()));

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
    setText(ctx, ctx.HAVING().getText() + Symbols.SPACE + getText(ctx.predicateList()));
  }

  /*
   orderByClause
  */
  @Override
  public void exitOrderByClause(PQL2Parser.OrderByClauseContext ctx) {
    List<String> buffer = new ArrayList<>();

    buffer.add(ctx.ORDER().getText());
    buffer.add(ctx.BY().getText());
    buffer.add(getText(ctx.orderByList()));

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
    setText(ctx, ctx.TOP().getText() + Symbols.SPACE + ctx.INTEGER_LITERAL().getText());
  }

  /*
   limitClause
  */
  @Override
  public void exitLimitClause(PQL2Parser.LimitClauseContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(ctx.LIMIT().getText());
    buffer.append(Symbols.SPACE);

    List<String> integers = new ArrayList<>();

    for (int index = 0; index < ctx.INTEGER_LITERAL().size(); index++) {
      integers.add(ctx.INTEGER_LITERAL(index).getText());
    }

    buffer.append(StringUtils.join(integers, Symbols.COMMA + Symbols.SPACE));

    setText(ctx, buffer.toString());
  }

  /*
   optionListClause
  */
  @Override
  public void exitOptionListClause(PQL2Parser.OptionListClauseContext ctx) {
    StringBuilder buffer = new StringBuilder();

    buffer.append(ctx.OPTION().getText());
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
