package com.weibo.dip.durian.antlr.predicate;

import com.weibo.dip.durian.antlr.CaseChangingCharStream;
import com.weibo.dip.durian.antlr.SyntaxErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class PredicateCalculator {
  public boolean eval(String expression) throws RuntimeException {
    CharStream input = CharStreams.fromString(expression);

    CaseChangingCharStream upper = new CaseChangingCharStream(input, true);

    PredicateLexer lexer = new PredicateLexer(upper);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    PredicateParser parser = new PredicateParser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new SyntaxErrorListener());

    ParseTree tree = parser.stat();

    EvalVisitor visitor = new EvalVisitor();

    return visitor.visit(tree);
  }
}
