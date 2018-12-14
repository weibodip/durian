package com.weibo.dip.durian.antlr.expression;

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
public class ExpressionLexer extends Lexer {
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
      METRIC = 11,
      INT = 12,
      FLOAT = 13,
      CHAR = 14,
      DIGIT = 15,
      WS = 16;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", "T__9", "METRIC", "INT",
    "FLOAT", "CHAR", "DIGIT", "WS"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'sum'", "'avg'", "'max'", "'min'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, null, null, null, null, "METRIC", "INT", "FLOAT",
    "CHAR", "DIGIT", "WS"
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

  public ExpressionLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @Override
  public String getGrammarFileName() {
    return "Expression.g4";
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
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22f\b\1\4\2\t\2\4"
          + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"
          + "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"
          + "\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"
          + "\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\6\fA\n\f\r\f\16\fB\3\f\3\f\7"
          + "\fG\n\f\f\f\16\fJ\13\f\3\r\6\rM\n\r\r\r\16\rN\3\16\6\16R\n\16\r\16\16"
          + "\16S\3\16\3\16\6\16X\n\16\r\16\16\16Y\3\17\3\17\3\20\3\20\3\21\6\21a\n"
          + "\21\r\21\16\21b\3\21\3\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"
          + "\13\25\f\27\r\31\16\33\17\35\20\37\21!\22\3\2\5\5\2C\\aac|\3\2\62;\3\2"
          + "\"\"\2l\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"
          + "\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"
          + "\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"
          + "\3#\3\2\2\2\5%\3\2\2\2\7\'\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r-\3\2\2\2\17"
          + "/\3\2\2\2\21\63\3\2\2\2\23\67\3\2\2\2\25;\3\2\2\2\27@\3\2\2\2\31L\3\2"
          + "\2\2\33Q\3\2\2\2\35[\3\2\2\2\37]\3\2\2\2!`\3\2\2\2#$\7*\2\2$\4\3\2\2\2"
          + "%&\7+\2\2&\6\3\2\2\2\'(\7,\2\2(\b\3\2\2\2)*\7\61\2\2*\n\3\2\2\2+,\7-\2"
          + "\2,\f\3\2\2\2-.\7/\2\2.\16\3\2\2\2/\60\7u\2\2\60\61\7w\2\2\61\62\7o\2"
          + "\2\62\20\3\2\2\2\63\64\7c\2\2\64\65\7x\2\2\65\66\7i\2\2\66\22\3\2\2\2"
          + "\678\7o\2\289\7c\2\29:\7z\2\2:\24\3\2\2\2;<\7o\2\2<=\7k\2\2=>\7p\2\2>"
          + "\26\3\2\2\2?A\5\35\17\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CH\3\2"
          + "\2\2DG\5\37\20\2EG\5\35\17\2FD\3\2\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2H"
          + "I\3\2\2\2I\30\3\2\2\2JH\3\2\2\2KM\5\37\20\2LK\3\2\2\2MN\3\2\2\2NL\3\2"
          + "\2\2NO\3\2\2\2O\32\3\2\2\2PR\5\37\20\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2S"
          + "T\3\2\2\2TU\3\2\2\2UW\7\60\2\2VX\5\37\20\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2"
          + "\2YZ\3\2\2\2Z\34\3\2\2\2[\\\t\2\2\2\\\36\3\2\2\2]^\t\3\2\2^ \3\2\2\2_"
          + "a\t\4\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\b\21\2\2"
          + "e\"\3\2\2\2\n\2BFHNSYb\3\b\2\2";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
