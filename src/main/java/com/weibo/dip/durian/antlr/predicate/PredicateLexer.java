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
      INT = 5,
      FLOAT = 6,
      DIGIT = 7,
      WS = 8,
      LT = 9,
      GT = 10,
      ELT = 11,
      EGT = 12,
      EQ = 13,
      NEQ = 14;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "INT", "FLOAT", "DIGIT", "WS", "LT", "GT", "ELT", "EGT", "EQ",
    "NEQ"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'('", "')'", "'AND'", "'OR'", null, null, null, null, "'<'", "'>'", "'<='", "'>='",
    "'='", "'!='"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, "INT", "FLOAT", "DIGIT", "WS", "LT", "GT", "ELT", "EGT", "EQ",
    "NEQ"
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
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20R\b\1\4\2\t\2\4"
          + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"
          + "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3"
          + "\4\3\5\3\5\3\5\3\6\6\6,\n\6\r\6\16\6-\3\7\6\7\61\n\7\r\7\16\7\62\3\7\3"
          + "\7\6\7\67\n\7\r\7\16\78\3\b\3\b\3\t\6\t>\n\t\r\t\16\t?\3\t\3\t\3\n\3\n"
          + "\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\2\2\20\3\3"
          + "\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2"
          + "\4\3\2\62;\3\2\"\"\2U\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"
          + "\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"
          + "\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2"
          + "\2\2\5!\3\2\2\2\7#\3\2\2\2\t\'\3\2\2\2\13+\3\2\2\2\r\60\3\2\2\2\17:\3"
          + "\2\2\2\21=\3\2\2\2\23C\3\2\2\2\25E\3\2\2\2\27G\3\2\2\2\31J\3\2\2\2\33"
          + "M\3\2\2\2\35O\3\2\2\2\37 \7*\2\2 \4\3\2\2\2!\"\7+\2\2\"\6\3\2\2\2#$\7"
          + "C\2\2$%\7P\2\2%&\7F\2\2&\b\3\2\2\2\'(\7Q\2\2()\7T\2\2)\n\3\2\2\2*,\5\17"
          + "\b\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\f\3\2\2\2/\61\5\17\b\2\60"
          + "/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\66"
          + "\7\60\2\2\65\67\5\17\b\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2"
          + "\29\16\3\2\2\2:;\t\2\2\2;\20\3\2\2\2<>\t\3\2\2=<\3\2\2\2>?\3\2\2\2?=\3"
          + "\2\2\2?@\3\2\2\2@A\3\2\2\2AB\b\t\2\2B\22\3\2\2\2CD\7>\2\2D\24\3\2\2\2"
          + "EF\7@\2\2F\26\3\2\2\2GH\7>\2\2HI\7?\2\2I\30\3\2\2\2JK\7@\2\2KL\7?\2\2"
          + "L\32\3\2\2\2MN\7?\2\2N\34\3\2\2\2OP\7#\2\2PQ\7?\2\2Q\36\3\2\2\2\7\2-\62"
          + "8?\3\b\2\2";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
