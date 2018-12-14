package com.weibo.dip.durian.antlr.expression;

import com.weibo.dip.durian.antlr.SyntaxErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Expression {
  public String[] eval(String expression) throws RuntimeException {
    CharStream input = CharStreams.fromString(expression);

    ExpressionLexer lexer = new ExpressionLexer(input);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    ExpressionParser parser = new ExpressionParser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new SyntaxErrorListener());

    ParseTree tree = parser.stat();

    EvalVisitor visitor = new EvalVisitor();
    visitor.visit(tree);

    return visitor.eval();
  }
}
