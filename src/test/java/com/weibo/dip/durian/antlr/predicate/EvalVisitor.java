package com.weibo.dip.durian.antlr.predicate;

import com.weibo.dip.durian.antlr.predicate.PredicateParser.AndContext;
import com.weibo.dip.durian.antlr.predicate.PredicateParser.ComparisonContext;
import com.weibo.dip.durian.antlr.predicate.PredicateParser.OrContext;
import com.weibo.dip.durian.antlr.predicate.PredicateParser.ParensContext;
import com.weibo.dip.durian.antlr.predicate.PredicateParser.StatementContext;

public class EvalVisitor extends PredicateBaseVisitor<Boolean> {

  @Override
  public Boolean visitStatement(StatementContext ctx) {
    return visit(ctx.predicate());
  }

  @Override
  public Boolean visitParens(ParensContext ctx) {
    return visit(ctx.predicate());
  }

  @Override
  public Boolean visitAnd(AndContext ctx) {
    return visit(ctx.predicate(0)) && visit(ctx.predicate(1));
  }

  @Override
  public Boolean visitOr(OrContext ctx) {
    return visit(ctx.predicate(0)) || visit(ctx.predicate(1));
  }

  @Override
  public Boolean visitComparison(ComparisonContext ctx) {
    double left = Double.valueOf(ctx.number(0).getText());
    double right = Double.valueOf(ctx.number(1).getText());

    if (Double.isNaN(left) || Double.isNaN(right)) {
      return false;
    }

    switch (ctx.op.getType()) {
      case PredicateLexer.LT:
        return left < right;
      case PredicateLexer.GT:
        return left > right;
      case PredicateLexer.ELT:
        return left <= right;
      case PredicateLexer.EGT:
        return left >= right;
      case PredicateLexer.EQ:
        return left == right;
      case PredicateLexer.NEQ:
        return left != right;
      default:
        return false;
    }
  }
}
