package com.weibo.dip.durian.antlr.sparksql;

import com.weibo.dip.durian.antlr.CaseChangingCharStream;
import com.weibo.dip.durian.antlr.SyntaxErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/** @author yurun */
public class SparkSqlAnalyzer {
  public Analysis analyze(String sql) throws RuntimeException {
    CharStream input = CharStreams.fromString(sql);

    CaseChangingCharStream upper = new CaseChangingCharStream(input, true);

    SqlBaseLexer lexer = new SqlBaseLexer(upper);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    SqlBaseParser parser = new SqlBaseParser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new SyntaxErrorListener());

    ParseTree tree = parser.singleStatement();

    SparkSqlVisitor visitor = new SparkSqlVisitor();

    visitor.visit(tree);

    return visitor.getAnalysis();
  }
}
