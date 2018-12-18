package com.weibo.dip.durian.antlr.pql2;

import com.weibo.dip.durian.antlr.pql2.PQL2Parser.FunctionCallContext;
import com.weibo.dip.durian.antlr.pql2.PQL2Parser.OutputColumnContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PinotSqlVisitor extends PQL2BaseVisitor<Void> {
  private static final Logger LOGGER = LoggerFactory.getLogger(PinotSqlVisitor.class);

  @Override
  public Void visitOutputColumn(OutputColumnContext ctx) {
    return super.visitOutputColumn(ctx);
  }

  @Override
  public Void visitFunctionCall(FunctionCallContext ctx) {
    return super.visitFunctionCall(ctx);
  }
}
