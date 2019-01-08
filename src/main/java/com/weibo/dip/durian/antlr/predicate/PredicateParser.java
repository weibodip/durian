package com.weibo.dip.durian.antlr.predicate;

import java.util.List;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PredicateParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int T__0 = 1,
      T__1 = 2,
      T__2 = 3,
      T__3 = 4,
      T__4 = 5,
      T__5 = 6,
      T__6 = 7,
      T__7 = 8,
      T__8 = 9,
      T__9 = 10,
      AND = 11,
      OR = 12,
      INTEGER_LITERAL = 13,
      FLOATING_POINT_LITERAL = 14,
      WHITESPACE = 15,
      LINE_COMMENT = 16;
  public static final int RULE_root = 0,
      RULE_statement = 1,
      RULE_predicateList = 2,
      RULE_predicate = 3,
      RULE_booleanOperator = 4,
      RULE_comparisonClause = 5,
      RULE_literal = 6,
      RULE_comparisonOperator = 7;
  public static final String[] ruleNames = {
    "root",
    "statement",
    "predicateList",
    "predicate",
    "booleanOperator",
    "comparisonClause",
    "literal",
    "comparisonOperator"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "';'", "'('", "')'", "'<'", "'>'", "'<>'", "'<='", "'>='", "'='", "'!='"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    "AND",
    "OR",
    "INTEGER_LITERAL",
    "FLOATING_POINT_LITERAL",
    "WHITESPACE",
    "LINE_COMMENT"
  };
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /** @deprecated Use {@link #VOCABULARY} instead. */
  @Deprecated public static final String[] tokenNames;

  static {
    tokenNames = new String[_SYMBOLIC_NAMES.length];
    for (int i = 0; i < tokenNames.length; i++) {
      tokenNames[i] = VOCABULARY.getLiteralName(i);
      if (tokenNames[i] == null) {
        tokenNames[i] = VOCABULARY.getSymbolicName(i);
      }

      if (tokenNames[i] == null) {
        tokenNames[i] = "<INVALID>";
      }
    }
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override
  public Vocabulary getVocabulary() {
    return VOCABULARY;
  }

  @Override
  public String getGrammarFileName() {
    return "Predicate.g4";
  }

  @Override
  public String[] getRuleNames() {
    return ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return _serializedATN;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }

  public PredicateParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  public static class RootContext extends ParserRuleContext {
    public StatementContext statement() {
      return getRuleContext(StatementContext.class, 0);
    }

    public TerminalNode EOF() {
      return getToken(PredicateParser.EOF, 0);
    }

    public RootContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_root;
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof PredicateVisitor)
        return ((PredicateVisitor<? extends T>) visitor).visitRoot(this);
      else return visitor.visitChildren(this);
    }
  }

  public final RootContext root() throws RecognitionException {
    RootContext _localctx = new RootContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_root);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(16);
        statement();
        setState(18);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__0) {
          {
            setState(17);
            match(T__0);
          }
        }

        setState(20);
        match(EOF);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static class StatementContext extends ParserRuleContext {
    public PredicateListContext predicateList() {
      return getRuleContext(PredicateListContext.class, 0);
    }

    public StatementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_statement;
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof PredicateVisitor)
        return ((PredicateVisitor<? extends T>) visitor).visitStatement(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StatementContext statement() throws RecognitionException {
    StatementContext _localctx = new StatementContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_statement);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(22);
        predicateList();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static class PredicateListContext extends ParserRuleContext {
    public List<PredicateContext> predicate() {
      return getRuleContexts(PredicateContext.class);
    }

    public PredicateContext predicate(int i) {
      return getRuleContext(PredicateContext.class, i);
    }

    public List<BooleanOperatorContext> booleanOperator() {
      return getRuleContexts(BooleanOperatorContext.class);
    }

    public BooleanOperatorContext booleanOperator(int i) {
      return getRuleContext(BooleanOperatorContext.class, i);
    }

    public PredicateListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_predicateList;
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof PredicateVisitor)
        return ((PredicateVisitor<? extends T>) visitor).visitPredicateList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PredicateListContext predicateList() throws RecognitionException {
    PredicateListContext _localctx = new PredicateListContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_predicateList);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(24);
        predicate();
        setState(30);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == AND || _la == OR) {
          {
            {
              setState(25);
              booleanOperator();
              setState(26);
              predicate();
            }
          }
          setState(32);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static class PredicateContext extends ParserRuleContext {
    public PredicateContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_predicate;
    }

    public PredicateContext() {}

    public void copyFrom(PredicateContext ctx) {
      super.copyFrom(ctx);
    }
  }

  public static class PredicateParenthesisGroupContext extends PredicateContext {
    public PredicateListContext predicateList() {
      return getRuleContext(PredicateListContext.class, 0);
    }

    public PredicateParenthesisGroupContext(PredicateContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof PredicateVisitor)
        return ((PredicateVisitor<? extends T>) visitor).visitPredicateParenthesisGroup(this);
      else return visitor.visitChildren(this);
    }
  }

  public static class ComparisonPredicateContext extends PredicateContext {
    public ComparisonClauseContext comparisonClause() {
      return getRuleContext(ComparisonClauseContext.class, 0);
    }

    public ComparisonPredicateContext(PredicateContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof PredicateVisitor)
        return ((PredicateVisitor<? extends T>) visitor).visitComparisonPredicate(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PredicateContext predicate() throws RecognitionException {
    PredicateContext _localctx = new PredicateContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_predicate);
    try {
      setState(38);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case T__1:
          _localctx = new PredicateParenthesisGroupContext(_localctx);
          enterOuterAlt(_localctx, 1);
          {
            setState(33);
            match(T__1);
            setState(34);
            predicateList();
            setState(35);
            match(T__2);
          }
          break;
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
          _localctx = new ComparisonPredicateContext(_localctx);
          enterOuterAlt(_localctx, 2);
          {
            setState(37);
            comparisonClause();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static class BooleanOperatorContext extends ParserRuleContext {
    public TerminalNode OR() {
      return getToken(PredicateParser.OR, 0);
    }

    public TerminalNode AND() {
      return getToken(PredicateParser.AND, 0);
    }

    public BooleanOperatorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_booleanOperator;
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof PredicateVisitor)
        return ((PredicateVisitor<? extends T>) visitor).visitBooleanOperator(this);
      else return visitor.visitChildren(this);
    }
  }

  public final BooleanOperatorContext booleanOperator() throws RecognitionException {
    BooleanOperatorContext _localctx = new BooleanOperatorContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_booleanOperator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(40);
        _la = _input.LA(1);
        if (!(_la == AND || _la == OR)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static class ComparisonClauseContext extends ParserRuleContext {
    public List<LiteralContext> literal() {
      return getRuleContexts(LiteralContext.class);
    }

    public LiteralContext literal(int i) {
      return getRuleContext(LiteralContext.class, i);
    }

    public ComparisonOperatorContext comparisonOperator() {
      return getRuleContext(ComparisonOperatorContext.class, 0);
    }

    public ComparisonClauseContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_comparisonClause;
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof PredicateVisitor)
        return ((PredicateVisitor<? extends T>) visitor).visitComparisonClause(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ComparisonClauseContext comparisonClause() throws RecognitionException {
    ComparisonClauseContext _localctx = new ComparisonClauseContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_comparisonClause);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(42);
        literal();
        setState(43);
        comparisonOperator();
        setState(44);
        literal();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static class LiteralContext extends ParserRuleContext {
    public LiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_literal;
    }

    public LiteralContext() {}

    public void copyFrom(LiteralContext ctx) {
      super.copyFrom(ctx);
    }
  }

  public static class FloatingPointLiteralContext extends LiteralContext {
    public TerminalNode FLOATING_POINT_LITERAL() {
      return getToken(PredicateParser.FLOATING_POINT_LITERAL, 0);
    }

    public FloatingPointLiteralContext(LiteralContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof PredicateVisitor)
        return ((PredicateVisitor<? extends T>) visitor).visitFloatingPointLiteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public static class IntegerLiteralContext extends LiteralContext {
    public TerminalNode INTEGER_LITERAL() {
      return getToken(PredicateParser.INTEGER_LITERAL, 0);
    }

    public IntegerLiteralContext(LiteralContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof PredicateVisitor)
        return ((PredicateVisitor<? extends T>) visitor).visitIntegerLiteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public final LiteralContext literal() throws RecognitionException {
    LiteralContext _localctx = new LiteralContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_literal);
    try {
      setState(48);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case INTEGER_LITERAL:
          _localctx = new IntegerLiteralContext(_localctx);
          enterOuterAlt(_localctx, 1);
          {
            setState(46);
            match(INTEGER_LITERAL);
          }
          break;
        case FLOATING_POINT_LITERAL:
          _localctx = new FloatingPointLiteralContext(_localctx);
          enterOuterAlt(_localctx, 2);
          {
            setState(47);
            match(FLOATING_POINT_LITERAL);
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static class ComparisonOperatorContext extends ParserRuleContext {
    public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_comparisonOperator;
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof PredicateVisitor)
        return ((PredicateVisitor<? extends T>) visitor).visitComparisonOperator(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
    ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_comparisonOperator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(50);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0
            && ((1L << _la)
                    & ((1L << T__3)
                        | (1L << T__4)
                        | (1L << T__5)
                        | (1L << T__6)
                        | (1L << T__7)
                        | (1L << T__8)
                        | (1L << T__9)))
                != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static final String _serializedATN =
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22\67\4\2\t\2\4\3"
          + "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\5\2\25\n"
          + "\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\7\4\37\n\4\f\4\16\4\"\13\4\3\5\3\5"
          + "\3\5\3\5\3\5\5\5)\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\5\b\63\n\b\3\t\3"
          + "\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\4\3\2\r\16\3\2\6\f\2\62\2\22\3\2\2\2"
          + "\4\30\3\2\2\2\6\32\3\2\2\2\b(\3\2\2\2\n*\3\2\2\2\f,\3\2\2\2\16\62\3\2"
          + "\2\2\20\64\3\2\2\2\22\24\5\4\3\2\23\25\7\3\2\2\24\23\3\2\2\2\24\25\3\2"
          + "\2\2\25\26\3\2\2\2\26\27\7\2\2\3\27\3\3\2\2\2\30\31\5\6\4\2\31\5\3\2\2"
          + "\2\32 \5\b\5\2\33\34\5\n\6\2\34\35\5\b\5\2\35\37\3\2\2\2\36\33\3\2\2\2"
          + "\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\7\3\2\2\2\" \3\2\2\2#$\7\4\2\2$%"
          + "\5\6\4\2%&\7\5\2\2&)\3\2\2\2\')\5\f\7\2(#\3\2\2\2(\'\3\2\2\2)\t\3\2\2"
          + "\2*+\t\2\2\2+\13\3\2\2\2,-\5\16\b\2-.\5\20\t\2./\5\16\b\2/\r\3\2\2\2\60"
          + "\63\7\17\2\2\61\63\7\20\2\2\62\60\3\2\2\2\62\61\3\2\2\2\63\17\3\2\2\2"
          + "\64\65\t\3\2\2\65\21\3\2\2\2\6\24 (\62";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
