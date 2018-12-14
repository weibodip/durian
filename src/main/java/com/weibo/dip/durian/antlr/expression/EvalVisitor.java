package com.weibo.dip.durian.antlr.expression;

import java.util.HashSet;
import java.util.Set;

public class EvalVisitor extends ExpressionBaseVisitor<String> {
  private Set<String> aggregates = new HashSet<>();

  @Override
  public String visitAggregate(ExpressionParser.AggregateContext ctx) {
    aggregates.add(ctx.getText());

    return super.visitAggregate(ctx);
  }

  public String[] eval() {
    return aggregates.toArray(new String[0]);
  }
}
