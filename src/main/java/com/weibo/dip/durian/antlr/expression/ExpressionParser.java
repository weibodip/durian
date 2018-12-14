package com.weibo.dip.durian.antlr.expression;

import java.util.List;
import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
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
public class ExpressionParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
      new PredictionContextCache();
  public static final int
      T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9,
      T__9=10, METRIC=11, INT=12, FLOAT=13, CHAR=14, DIGIT=15, WS=16;
  public static final int
      RULE_stat = 0, RULE_expr = 1, RULE_method = 2, RULE_number = 3;
  public static final String[] ruleNames = {
      "stat", "expr", "method", "number"
  };

  private static final String[] _LITERAL_NAMES = {
      null, "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'sum'", "'avg'", "'max'",
      "'min'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
      null, null, null, null, null, null, null, null, null, null, null, "METRIC",
      "INT", "FLOAT", "CHAR", "DIGIT", "WS"
  };
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated
  public static final String[] tokenNames;
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
  public String getGrammarFileName() { return "Expression.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public ATN getATN() { return _ATN; }

  public ExpressionParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class StatContext extends ParserRuleContext {
    public StatContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_stat; }

    public StatContext() { }
    public void copyFrom(StatContext ctx) {
      super.copyFrom(ctx);
    }
  }
  public static class PrintContext extends StatContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class,0);
    }
    public PrintContext(StatContext ctx) { copyFrom(ctx); }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitPrint(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StatContext stat() throws RecognitionException {
    StatContext _localctx = new StatContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_stat);
    try {
      _localctx = new PrintContext(_localctx);
      enterOuterAlt(_localctx, 1);
      {
        setState(8);
        expr(0);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class ExprContext extends ParserRuleContext {
    public ExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_expr; }

    public ExprContext() { }
    public void copyFrom(ExprContext ctx) {
      super.copyFrom(ctx);
    }
  }
  public static class AddOrSubContext extends ExprContext {
    public Token op;
    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }
    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class,i);
    }
    public AddOrSubContext(ExprContext ctx) { copyFrom(ctx); }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAddOrSub(this);
      else return visitor.visitChildren(this);
    }
  }
  public static class ParensContext extends ExprContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class,0);
    }
    public ParensContext(ExprContext ctx) { copyFrom(ctx); }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitParens(this);
      else return visitor.visitChildren(this);
    }
  }
  public static class MulOrDivContext extends ExprContext {
    public Token op;
    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }
    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class,i);
    }
    public MulOrDivContext(ExprContext ctx) { copyFrom(ctx); }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitMulOrDiv(this);
      else return visitor.visitChildren(this);
    }
  }
  public static class IntOrFloatContext extends ExprContext {
    public NumberContext number() {
      return getRuleContext(NumberContext.class,0);
    }
    public IntOrFloatContext(ExprContext ctx) { copyFrom(ctx); }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitIntOrFloat(this);
      else return visitor.visitChildren(this);
    }
  }
  public static class AggregateContext extends ExprContext {
    public MethodContext method() {
      return getRuleContext(MethodContext.class,0);
    }
    public TerminalNode METRIC() { return getToken(ExpressionParser.METRIC, 0); }
    public AggregateContext(ExprContext ctx) { copyFrom(ctx); }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAggregate(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExprContext expr() throws RecognitionException {
    return expr(0);
  }

  private ExprContext expr(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = _ctx;
    int _parentState = getState();
    ExprContext _localctx = new ExprContext(_ctx, _parentState);
    ExprContext _prevctx = _localctx;
    int _startState = 2;
    enterRecursionRule(_localctx, 2, RULE_expr, _p);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(21);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case T__0:
          {
            _localctx = new ParensContext(_localctx);
            _ctx = _localctx;
            _prevctx = _localctx;

            setState(11);
            match(T__0);
            setState(12);
            expr(0);
            setState(13);
            match(T__1);
          }
          break;
          case T__6:
          case T__7:
          case T__8:
          case T__9:
          {
            _localctx = new AggregateContext(_localctx);
            _ctx = _localctx;
            _prevctx = _localctx;
            setState(15);
            method();
            setState(16);
            match(T__0);
            setState(17);
            match(METRIC);
            setState(18);
            match(T__1);
          }
          break;
          case INT:
          case FLOAT:
          {
            _localctx = new IntOrFloatContext(_localctx);
            _ctx = _localctx;
            _prevctx = _localctx;
            setState(20);
            number();
          }
          break;
          default:
            throw new NoViableAltException(this);
        }
        _ctx.stop = _input.LT(-1);
        setState(31);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,2,_ctx);
        while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
          if ( _alt==1 ) {
            if ( _parseListeners!=null ) triggerExitRuleEvent();
            _prevctx = _localctx;
            {
              setState(29);
              _errHandler.sync(this);
              switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
                case 1:
                {
                  _localctx = new MulOrDivContext(new ExprContext(_parentctx, _parentState));
                  pushNewRecursionContext(_localctx, _startState, RULE_expr);
                  setState(23);
                  if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                  setState(24);
                  ((MulOrDivContext)_localctx).op = _input.LT(1);
                  _la = _input.LA(1);
                  if ( !(_la==T__2 || _la==T__3) ) {
                    ((MulOrDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
                  }
                  else {
                    if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                  }
                  setState(25);
                  expr(5);
                }
                break;
                case 2:
                {
                  _localctx = new AddOrSubContext(new ExprContext(_parentctx, _parentState));
                  pushNewRecursionContext(_localctx, _startState, RULE_expr);
                  setState(26);
                  if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                  setState(27);
                  ((AddOrSubContext)_localctx).op = _input.LT(1);
                  _la = _input.LA(1);
                  if ( !(_la==T__4 || _la==T__5) ) {
                    ((AddOrSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
                  }
                  else {
                    if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                  }
                  setState(28);
                  expr(4);
                }
                break;
              }
            }
          }
          setState(33);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input,2,_ctx);
        }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  public static class MethodContext extends ParserRuleContext {
    public MethodContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_method; }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitMethod(this);
      else return visitor.visitChildren(this);
    }
  }

  public final MethodContext method() throws RecognitionException {
    MethodContext _localctx = new MethodContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_method);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(34);
        _la = _input.LA(1);
        if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
          _errHandler.recoverInline(this);
        }
        else {
          if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class NumberContext extends ParserRuleContext {
    public TerminalNode INT() { return getToken(ExpressionParser.INT, 0); }
    public TerminalNode FLOAT() { return getToken(ExpressionParser.FLOAT, 0); }
    public NumberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_number; }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitNumber(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NumberContext number() throws RecognitionException {
    NumberContext _localctx = new NumberContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_number);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(36);
        _la = _input.LA(1);
        if ( !(_la==INT || _la==FLOAT) ) {
          _errHandler.recoverInline(this);
        }
        else {
          if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
    switch (ruleIndex) {
      case 1:
        return expr_sempred((ExprContext)_localctx, predIndex);
    }
    return true;
  }
  private boolean expr_sempred(ExprContext _localctx, int predIndex) {
    switch (predIndex) {
      case 0:
        return precpred(_ctx, 4);
      case 1:
        return precpred(_ctx, 3);
    }
    return true;
  }

  public static final String _serializedATN =
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22)\4\2\t\2\4\3\t"+
          "\3\4\4\t\4\4\5\t\5\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
          "\5\3\30\n\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3\4\3\4\3"+
          "\5\3\5\3\5\2\3\4\6\2\4\6\b\2\6\3\2\5\6\3\2\7\b\3\2\t\f\3\2\16\17\2(\2"+
          "\n\3\2\2\2\4\27\3\2\2\2\6$\3\2\2\2\b&\3\2\2\2\n\13\5\4\3\2\13\3\3\2\2"+
          "\2\f\r\b\3\1\2\r\16\7\3\2\2\16\17\5\4\3\2\17\20\7\4\2\2\20\30\3\2\2\2"+
          "\21\22\5\6\4\2\22\23\7\3\2\2\23\24\7\r\2\2\24\25\7\4\2\2\25\30\3\2\2\2"+
          "\26\30\5\b\5\2\27\f\3\2\2\2\27\21\3\2\2\2\27\26\3\2\2\2\30!\3\2\2\2\31"+
          "\32\f\6\2\2\32\33\t\2\2\2\33 \5\4\3\7\34\35\f\5\2\2\35\36\t\3\2\2\36 "+
          "\5\4\3\6\37\31\3\2\2\2\37\34\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2"+
          "\"\5\3\2\2\2#!\3\2\2\2$%\t\4\2\2%\7\3\2\2\2&\'\t\5\2\2\'\t\3\2\2\2\5\27"+
          "\37!";
  public static final ATN _ATN =
      new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
