package com.weibo.dip.durian.antlr.calculator;

public class EvalVisitor extends CalculatorBaseVisitor<Double> {
  @Override
  public Double visitPrint(CalculatorParser.PrintContext ctx) {
    return visit(ctx.expr());
  }

  @Override
  public Double visitAddOrSub(CalculatorParser.AddOrSubContext ctx) {
    double left = visit(ctx.expr(0));
    double right = visit(ctx.expr(1));

    return ctx.op.getType() == CalculatorLexer.ADD ? left + right : left - right;
  }

  @Override
  public Double visitParens(CalculatorParser.ParensContext ctx) {
    return visit(ctx.expr());
  }

  @Override
  public Double visitMulOrDiv(CalculatorParser.MulOrDivContext ctx) {
    double left = visit(ctx.expr(0));
    double right = visit(ctx.expr(1));

    return ctx.op.getType() == CalculatorLexer.MUL ? left * right : left / right;
  }

  @Override
  public Double visitIntOrFloat(CalculatorParser.IntOrFloatContext ctx) {
    return visit(ctx.number());
  }

  @Override
  public Double visitNumber(CalculatorParser.NumberContext ctx) {
    return Double.valueOf(ctx.getText());
  }
}
