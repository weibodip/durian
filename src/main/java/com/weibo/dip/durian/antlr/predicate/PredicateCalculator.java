package com.weibo.dip.durian.antlr.predicate;

import com.weibo.dip.durian.antlr.SyntaxErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class PredicateCalculator {
  public boolean eval(String expression) throws RuntimeException {
    CharStream input = CharStreams.fromString(expression);

    PredicateLexer lexer = new PredicateLexer(input);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    PredicateParser parser = new PredicateParser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new SyntaxErrorListener());

    ParseTree tree = parser.statement();

    EvalVisitor visitor = new EvalVisitor();

    return visitor.visit(tree);
  }
}
