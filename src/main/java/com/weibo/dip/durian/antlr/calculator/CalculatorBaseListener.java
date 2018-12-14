package com.weibo.dip.durian.antlr.calculator;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link CalculatorListener}, which can be extended
 * to create a listener which only needs to handle a subset of the available methods.
 */
public class CalculatorBaseListener implements CalculatorListener {
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterPrint(CalculatorParser.PrintContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitPrint(CalculatorParser.PrintContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterAddOrSub(CalculatorParser.AddOrSubContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitAddOrSub(CalculatorParser.AddOrSubContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterParens(CalculatorParser.ParensContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitParens(CalculatorParser.ParensContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterMulOrDiv(CalculatorParser.MulOrDivContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitMulOrDiv(CalculatorParser.MulOrDivContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterIntOrFloat(CalculatorParser.IntOrFloatContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitIntOrFloat(CalculatorParser.IntOrFloatContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterNumber(CalculatorParser.NumberContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitNumber(CalculatorParser.NumberContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterEveryRule(ParserRuleContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitEveryRule(ParserRuleContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void visitTerminal(TerminalNode node) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void visitErrorNode(ErrorNode node) {}
}
