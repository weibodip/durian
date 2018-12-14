package com.weibo.dip.durian.antlr.calculator;

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
public class CalculatorParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int T__0 = 1,
      T__1 = 2,
      INT = 3,
      FLOAT = 4,
      DIGIT = 5,
      WS = 6,
      MUL = 7,
      DIV = 8,
      ADD = 9,
      SUB = 10;
  public static final int RULE_stat = 0, RULE_expr = 1, RULE_number = 2;
  public static final String[] ruleNames = {"stat", "expr", "number"};

  private static final String[] _LITERAL_NAMES = {
    null, "'('", "')'", null, null, null, null, "'*'", "'/'", "'+'", "'-'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, "INT", "FLOAT", "DIGIT", "WS", "MUL", "DIV", "ADD", "SUB"
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
    return "Calculator.g4";
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

  public CalculatorParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  public static class StatContext extends ParserRuleContext {
    public StatContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_stat;
    }

    public StatContext() {}

    public void copyFrom(StatContext ctx) {
      super.copyFrom(ctx);
    }
  }

  public static class PrintContext extends StatContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public PrintContext(StatContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CalculatorVisitor)
        return ((CalculatorVisitor<? extends T>) visitor).visitPrint(this);
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
        setState(6);
        expr(0);
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

  public static class ExprContext extends ParserRuleContext {
    public ExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expr;
    }

    public ExprContext() {}

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
      return getRuleContext(ExprContext.class, i);
    }

    public AddOrSubContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CalculatorVisitor)
        return ((CalculatorVisitor<? extends T>) visitor).visitAddOrSub(this);
      else return visitor.visitChildren(this);
    }
  }

  public static class ParensContext extends ExprContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public ParensContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CalculatorVisitor)
        return ((CalculatorVisitor<? extends T>) visitor).visitParens(this);
      else return visitor.visitChildren(this);
    }
  }

  public static class MulOrDivContext extends ExprContext {
    public Token op;

    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class, i);
    }

    public MulOrDivContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CalculatorVisitor)
        return ((CalculatorVisitor<? extends T>) visitor).visitMulOrDiv(this);
      else return visitor.visitChildren(this);
    }
  }

  public static class IntOrFloatContext extends ExprContext {
    public NumberContext number() {
      return getRuleContext(NumberContext.class, 0);
    }

    public IntOrFloatContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CalculatorVisitor)
        return ((CalculatorVisitor<? extends T>) visitor).visitIntOrFloat(this);
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
        setState(14);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case T__0:
            {
              _localctx = new ParensContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;

              setState(9);
              match(T__0);
              setState(10);
              expr(0);
              setState(11);
              match(T__1);
            }
            break;
          case INT:
          case FLOAT:
            {
              _localctx = new IntOrFloatContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(13);
              number();
            }
            break;
          default:
            throw new NoViableAltException(this);
        }
        _ctx.stop = _input.LT(-1);
        setState(24);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 2, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (_parseListeners != null) triggerExitRuleEvent();
            _prevctx = _localctx;
            {
              setState(22);
              _errHandler.sync(this);
              switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                  {
                    _localctx = new MulOrDivContext(new ExprContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                    setState(16);
                    if (!(precpred(_ctx, 3)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                    setState(17);
                    ((MulOrDivContext) _localctx).op = _input.LT(1);
                    _la = _input.LA(1);
                    if (!(_la == MUL || _la == DIV)) {
                      ((MulOrDivContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(18);
                    expr(4);
                  }
                  break;
                case 2:
                  {
                    _localctx = new AddOrSubContext(new ExprContext(_parentctx, _parentState));
                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                    setState(19);
                    if (!(precpred(_ctx, 2)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                    setState(20);
                    ((AddOrSubContext) _localctx).op = _input.LT(1);
                    _la = _input.LA(1);
                    if (!(_la == ADD || _la == SUB)) {
                      ((AddOrSubContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(21);
                    expr(3);
                  }
                  break;
              }
            }
          }
          setState(26);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 2, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  public static class NumberContext extends ParserRuleContext {
    public TerminalNode INT() {
      return getToken(CalculatorParser.INT, 0);
    }

    public TerminalNode FLOAT() {
      return getToken(CalculatorParser.FLOAT, 0);
    }

    public NumberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_number;
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CalculatorVisitor)
        return ((CalculatorVisitor<? extends T>) visitor).visitNumber(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NumberContext number() throws RecognitionException {
    NumberContext _localctx = new NumberContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_number);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(27);
        _la = _input.LA(1);
        if (!(_la == INT || _la == FLOAT)) {
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

  public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
    switch (ruleIndex) {
      case 1:
        return expr_sempred((ExprContext) _localctx, predIndex);
    }
    return true;
  }

  private boolean expr_sempred(ExprContext _localctx, int predIndex) {
    switch (predIndex) {
      case 0:
        return precpred(_ctx, 3);
      case 1:
        return precpred(_ctx, 2);
    }
    return true;
  }

  public static final String _serializedATN =
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f \4\2\t\2\4\3\t"
          + "\3\4\4\t\4\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\21\n\3\3\3\3\3\3\3\3\3"
          + "\3\3\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\4\3\4\3\4\2\3\4\5\2\4\6\2\5\3\2"
          + "\t\n\3\2\13\f\3\2\5\6\2\37\2\b\3\2\2\2\4\20\3\2\2\2\6\35\3\2\2\2\b\t\5"
          + "\4\3\2\t\3\3\2\2\2\n\13\b\3\1\2\13\f\7\3\2\2\f\r\5\4\3\2\r\16\7\4\2\2"
          + "\16\21\3\2\2\2\17\21\5\6\4\2\20\n\3\2\2\2\20\17\3\2\2\2\21\32\3\2\2\2"
          + "\22\23\f\5\2\2\23\24\t\2\2\2\24\31\5\4\3\6\25\26\f\4\2\2\26\27\t\3\2\2"
          + "\27\31\5\4\3\5\30\22\3\2\2\2\30\25\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2"
          + "\32\33\3\2\2\2\33\5\3\2\2\2\34\32\3\2\2\2\35\36\t\4\2\2\36\7\3\2\2\2\5"
          + "\20\30\32";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
