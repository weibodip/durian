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
      AND = 6,
      OR = 7,
      INT = 8,
      FLOAT = 9,
      A = 10,
      D = 11,
      N = 12,
      O = 13,
      R = 14,
      DIGIT = 15,
      WS = 16,
      LT = 17,
      GT = 18,
      ELT = 19,
      EGT = 20,
      EQ = 21,
      NEQ = 22;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "T__4", "AND", "OR", "INT", "FLOAT", "A", "D", "N", "O", "R",
    "DIGIT", "WS", "LT", "GT", "ELT", "EGT", "EQ", "NEQ"
  };

  private static final String[] _LITERAL_NAMES = {
    null,
    "'('",
    "')'",
    "'NaN'",
    "'Infinity'",
    "'-Infinity'",
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
    "'<'",
    "'>'",
    "'<='",
    "'>='",
    "'='",
    "'!='"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, "AND", "OR", "INT", "FLOAT", "A", "D", "N", "O", "R",
    "DIGIT", "WS", "LT", "GT", "ELT", "EGT", "EQ", "NEQ"
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
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0083\b\1\4\2"
          + "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"
          + "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"
          + "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"
          + "\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"
          + "\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\6\tS\n\t\r\t"
          + "\16\tT\3\n\6\nX\n\n\r\n\16\nY\3\n\3\n\6\n^\n\n\r\n\16\n_\3\13\3\13\3\f"
          + "\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\6\21o\n\21\r\21\16\21"
          + "p\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26"
          + "\3\27\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"
          + "\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30\3\2\t\4\2CCcc"
          + "\4\2FFff\4\2PPpp\4\2QQqq\4\2TTtt\3\2\62;\3\2\"\"\2\u0086\2\3\3\2\2\2\2"
          + "\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"
          + "\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"
          + "\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"
          + "\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\61\3\2\2\2"
          + "\7\63\3\2\2\2\t\67\3\2\2\2\13@\3\2\2\2\rJ\3\2\2\2\17N\3\2\2\2\21R\3\2"
          + "\2\2\23W\3\2\2\2\25a\3\2\2\2\27c\3\2\2\2\31e\3\2\2\2\33g\3\2\2\2\35i\3"
          + "\2\2\2\37k\3\2\2\2!n\3\2\2\2#t\3\2\2\2%v\3\2\2\2\'x\3\2\2\2){\3\2\2\2"
          + "+~\3\2\2\2-\u0080\3\2\2\2/\60\7*\2\2\60\4\3\2\2\2\61\62\7+\2\2\62\6\3"
          + "\2\2\2\63\64\7P\2\2\64\65\7c\2\2\65\66\7P\2\2\66\b\3\2\2\2\678\7K\2\2"
          + "89\7p\2\29:\7h\2\2:;\7k\2\2;<\7p\2\2<=\7k\2\2=>\7v\2\2>?\7{\2\2?\n\3\2"
          + "\2\2@A\7/\2\2AB\7K\2\2BC\7p\2\2CD\7h\2\2DE\7k\2\2EF\7p\2\2FG\7k\2\2GH"
          + "\7v\2\2HI\7{\2\2I\f\3\2\2\2JK\5\25\13\2KL\5\31\r\2LM\5\27\f\2M\16\3\2"
          + "\2\2NO\5\33\16\2OP\5\35\17\2P\20\3\2\2\2QS\5\37\20\2RQ\3\2\2\2ST\3\2\2"
          + "\2TR\3\2\2\2TU\3\2\2\2U\22\3\2\2\2VX\5\37\20\2WV\3\2\2\2XY\3\2\2\2YW\3"
          + "\2\2\2YZ\3\2\2\2Z[\3\2\2\2[]\7\60\2\2\\^\5\37\20\2]\\\3\2\2\2^_\3\2\2"
          + "\2_]\3\2\2\2_`\3\2\2\2`\24\3\2\2\2ab\t\2\2\2b\26\3\2\2\2cd\t\3\2\2d\30"
          + "\3\2\2\2ef\t\4\2\2f\32\3\2\2\2gh\t\5\2\2h\34\3\2\2\2ij\t\6\2\2j\36\3\2"
          + "\2\2kl\t\7\2\2l \3\2\2\2mo\t\b\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2"
          + "\2\2qr\3\2\2\2rs\b\21\2\2s\"\3\2\2\2tu\7>\2\2u$\3\2\2\2vw\7@\2\2w&\3\2"
          + "\2\2xy\7>\2\2yz\7?\2\2z(\3\2\2\2{|\7@\2\2|}\7?\2\2}*\3\2\2\2~\177\7?\2"
          + "\2\177,\3\2\2\2\u0080\u0081\7#\2\2\u0081\u0082\7?\2\2\u0082.\3\2\2\2\7"
          + "\2TY_p\3\b\2\2";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
