package com.weibo.dip.durian.antlr.pql2;

import com.weibo.dip.durian.antlr.SyntaxErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class PinotSqlAnalyzer {
  public void analyze(String sql) throws RuntimeException {
    CharStream input = CharStreams.fromString(sql);

    PQL2Lexer lexer = new PQL2Lexer(input);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    PQL2Parser parser = new PQL2Parser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new SyntaxErrorListener());

    ParseTree tree = parser.statement();

    PinotSqlVisitor visitor = new PinotSqlVisitor();

    visitor.visit(tree);
  }
}
