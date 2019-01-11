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
      AND = 4,
      OR = 5,
      INT = 6,
      FLOAT = 7,
      A = 8,
      D = 9,
      N = 10,
      O = 11,
      R = 12,
      DIGIT = 13,
      WS = 14,
      LT = 15,
      GT = 16,
      ELT = 17,
      EGT = 18,
      EQ = 19,
      NEQ = 20;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "AND", "OR", "INT", "FLOAT", "A", "D", "N", "O", "R", "DIGIT", "WS",
    "LT", "GT", "ELT", "EGT", "EQ", "NEQ"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'('", "')'", "'NaN'", null, null, null, null, null, null, null, null, null, null, null,
    "'<'", "'>'", "'<='", "'>='", "'='", "'!='"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, "AND", "OR", "INT", "FLOAT", "A", "D", "N", "O", "R", "DIGIT", "WS",
    "LT", "GT", "ELT", "EGT", "EQ", "NEQ"
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
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26l\b\1\4\2\t\2\4"
          + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"
          + "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
          + "\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5"
          + "\3\5\3\5\3\6\3\6\3\6\3\7\6\7<\n\7\r\7\16\7=\3\b\6\bA\n\b\r\b\16\bB\3\b"
          + "\3\b\6\bG\n\b\r\b\16\bH\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"
          + "\3\16\3\17\6\17X\n\17\r\17\16\17Y\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3"
          + "\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\2\2\26\3\3\5\4\7\5\t"
          + "\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"
          + "%\24\'\25)\26\3\2\t\4\2CCcc\4\2FFff\4\2PPpp\4\2QQqq\4\2TTtt\3\2\62;\3"
          + "\2\"\"\2o\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"
          + "\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"
          + "\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"
          + "\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2\2\2"
          + "\7/\3\2\2\2\t\63\3\2\2\2\13\67\3\2\2\2\r;\3\2\2\2\17@\3\2\2\2\21J\3\2"
          + "\2\2\23L\3\2\2\2\25N\3\2\2\2\27P\3\2\2\2\31R\3\2\2\2\33T\3\2\2\2\35W\3"
          + "\2\2\2\37]\3\2\2\2!_\3\2\2\2#a\3\2\2\2%d\3\2\2\2\'g\3\2\2\2)i\3\2\2\2"
          + "+,\7*\2\2,\4\3\2\2\2-.\7+\2\2.\6\3\2\2\2/\60\7P\2\2\60\61\7c\2\2\61\62"
          + "\7P\2\2\62\b\3\2\2\2\63\64\5\21\t\2\64\65\5\25\13\2\65\66\5\23\n\2\66"
          + "\n\3\2\2\2\678\5\27\f\289\5\31\r\29\f\3\2\2\2:<\5\33\16\2;:\3\2\2\2<="
          + "\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\16\3\2\2\2?A\5\33\16\2@?\3\2\2\2AB\3\2\2"
          + "\2B@\3\2\2\2BC\3\2\2\2CD\3\2\2\2DF\7\60\2\2EG\5\33\16\2FE\3\2\2\2GH\3"
          + "\2\2\2HF\3\2\2\2HI\3\2\2\2I\20\3\2\2\2JK\t\2\2\2K\22\3\2\2\2LM\t\3\2\2"
          + "M\24\3\2\2\2NO\t\4\2\2O\26\3\2\2\2PQ\t\5\2\2Q\30\3\2\2\2RS\t\6\2\2S\32"
          + "\3\2\2\2TU\t\7\2\2U\34\3\2\2\2VX\t\b\2\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2"
          + "YZ\3\2\2\2Z[\3\2\2\2[\\\b\17\2\2\\\36\3\2\2\2]^\7>\2\2^ \3\2\2\2_`\7@"
          + "\2\2`\"\3\2\2\2ab\7>\2\2bc\7?\2\2c$\3\2\2\2de\7@\2\2ef\7?\2\2f&\3\2\2"
          + "\2gh\7?\2\2h(\3\2\2\2ij\7#\2\2jk\7?\2\2k*\3\2\2\2\7\2=BHY\3\b\2\2";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
