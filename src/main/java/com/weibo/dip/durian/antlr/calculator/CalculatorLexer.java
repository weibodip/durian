package com.weibo.dip.durian.antlr.calculator;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorLexer extends Lexer {
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
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  public static final String[] ruleNames = {
    "T__0", "T__1", "INT", "FLOAT", "DIGIT", "WS", "MUL", "DIV", "ADD", "SUB"
  };

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

  public CalculatorLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
  public String[] getChannelNames() {
    return channelNames;
  }

  @Override
  public String[] getModeNames() {
    return modeNames;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }

  public static final String _serializedATN =
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f<\b\1\4\2\t\2\4"
          + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"
          + "\13\3\2\3\2\3\3\3\3\3\4\6\4\35\n\4\r\4\16\4\36\3\5\6\5\"\n\5\r\5\16\5"
          + "#\3\5\3\5\6\5(\n\5\r\5\16\5)\3\6\3\6\3\7\6\7/\n\7\r\7\16\7\60\3\7\3\7"
          + "\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t"
          + "\21\n\23\13\25\f\3\2\4\3\2\62;\3\2\"\"\2?\2\3\3\2\2\2\2\5\3\2\2\2\2\7"
          + "\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"
          + "\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\31\3\2\2\2\7\34\3\2\2\2\t"
          + "!\3\2\2\2\13+\3\2\2\2\r.\3\2\2\2\17\64\3\2\2\2\21\66\3\2\2\2\238\3\2\2"
          + "\2\25:\3\2\2\2\27\30\7*\2\2\30\4\3\2\2\2\31\32\7+\2\2\32\6\3\2\2\2\33"
          + "\35\5\13\6\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37"
          + "\b\3\2\2\2 \"\5\13\6\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$%\3\2"
          + "\2\2%\'\7\60\2\2&(\5\13\6\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2"
          + "*\n\3\2\2\2+,\t\2\2\2,\f\3\2\2\2-/\t\3\2\2.-\3\2\2\2/\60\3\2\2\2\60.\3"
          + "\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\b\7\2\2\63\16\3\2\2\2\64\65\7"
          + ",\2\2\65\20\3\2\2\2\66\67\7\61\2\2\67\22\3\2\2\289\7-\2\29\24\3\2\2\2"
          + ":;\7/\2\2;\26\3\2\2\2\7\2\36#)\60\3\b\2\2";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
