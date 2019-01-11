package com.weibo.dip.durian.antlr.predicate;

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
public class PredicateLexer extends Lexer {
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
      INT = 6,
      FLOAT = 7,
      DIGIT = 8,
      WS = 9,
      LT = 10,
      GT = 11,
      ELT = 12,
      GLT = 13,
      EQ = 14,
      NEQ = 15;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "T__4", "INT", "FLOAT", "DIGIT", "WS", "LT", "GT", "ELT", "GLT",
    "EQ", "NEQ"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'('", "')'", "'AND'", "'OR'", "'NaN'", null, null, null, null, "'<'", "'>'", "'<='",
    "'>='", "'='", "'!='"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, "INT", "FLOAT", "DIGIT", "WS", "LT", "GT", "ELT", "GLT",
    "EQ", "NEQ"
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

  public PredicateLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21X\b\1\4\2\t\2\4"
          + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"
          + "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4"
          + "\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\6\7\62\n\7\r\7\16\7\63\3"
          + "\b\6\b\67\n\b\r\b\16\b8\3\b\3\b\6\b=\n\b\r\b\16\b>\3\t\3\t\3\n\6\nD\n"
          + "\n\r\n\16\nE\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17"
          + "\3\17\3\20\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"
          + "\f\27\r\31\16\33\17\35\20\37\21\3\2\4\3\2\62;\3\2\"\"\2[\2\3\3\2\2\2\2"
          + "\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"
          + "\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"
          + "\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2"
          + "\t)\3\2\2\2\13,\3\2\2\2\r\61\3\2\2\2\17\66\3\2\2\2\21@\3\2\2\2\23C\3\2"
          + "\2\2\25I\3\2\2\2\27K\3\2\2\2\31M\3\2\2\2\33P\3\2\2\2\35S\3\2\2\2\37U\3"
          + "\2\2\2!\"\7*\2\2\"\4\3\2\2\2#$\7+\2\2$\6\3\2\2\2%&\7C\2\2&\'\7P\2\2\'"
          + "(\7F\2\2(\b\3\2\2\2)*\7Q\2\2*+\7T\2\2+\n\3\2\2\2,-\7P\2\2-.\7c\2\2./\7"
          + "P\2\2/\f\3\2\2\2\60\62\5\21\t\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2"
          + "\2\2\63\64\3\2\2\2\64\16\3\2\2\2\65\67\5\21\t\2\66\65\3\2\2\2\678\3\2"
          + "\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:<\7\60\2\2;=\5\21\t\2<;\3\2\2\2="
          + ">\3\2\2\2><\3\2\2\2>?\3\2\2\2?\20\3\2\2\2@A\t\2\2\2A\22\3\2\2\2BD\t\3"
          + "\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\b\n\2\2H\24\3"
          + "\2\2\2IJ\7>\2\2J\26\3\2\2\2KL\7@\2\2L\30\3\2\2\2MN\7>\2\2NO\7?\2\2O\32"
          + "\3\2\2\2PQ\7@\2\2QR\7?\2\2R\34\3\2\2\2ST\7?\2\2T\36\3\2\2\2UV\7#\2\2V"
          + "W\7?\2\2W \3\2\2\2\7\2\638>E\3\b\2\2";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
