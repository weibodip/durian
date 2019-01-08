package com.weibo.dip.durian.antlr.predicate;

public class EvalVisitor extends PredicateBaseVisitor<Boolean> {
  @Override
  public Boolean visitStatement(PredicateParser.StatementContext ctx) {
    return visitPredicateList(ctx.predicateList());
  }

  @Override
  public Boolean visitPredicateList(PredicateParser.PredicateListContext ctx) {
    return super.visitPredicateList(ctx);
  }
}
