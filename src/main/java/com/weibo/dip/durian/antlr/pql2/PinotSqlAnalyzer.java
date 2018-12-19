package com.weibo.dip.durian.antlr.pql2;

import com.weibo.dip.durian.antlr.SyntaxErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/** @author yurun */
public class PinotSqlAnalyzer {
  public void analyze(String sql) throws RuntimeException {
    CharStream input = CharStreams.fromString(sql);

    PQL2Lexer lexer = new PQL2Lexer(input);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    PQL2Parser parser = new PQL2Parser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new SyntaxErrorListener());

    ParseTree tree = parser.root();

    ParseTreeWalker walker = new ParseTreeWalker();

    PinotSqlListener listener = new PinotSqlListener();

    walker.walk(listener, tree);
  }
}
