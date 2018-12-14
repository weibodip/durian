package com.weibo.dip.durian.antlr.calculator;

import com.weibo.dip.durian.antlr.SyntaxErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calculator {
  public double eval(String expression) throws RuntimeException {
    CharStream input = CharStreams.fromString(expression);

    CalculatorLexer lexer = new CalculatorLexer(input);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    CalculatorParser parser = new CalculatorParser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new SyntaxErrorListener());

    ParseTree tree = parser.stat();

    EvalVisitor visitor = new EvalVisitor();

    return visitor.visit(tree);
  }
}
