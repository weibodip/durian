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
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  public static final String[] ruleNames = {
    "T__0",
    "T__1",
    "T__2",
    "T__3",
    "T__4",
    "T__5",
    "T__6",
    "T__7",
    "T__8",
    "T__9",
    "AND",
    "OR",
    "INTEGER_LITERAL",
    "FLOATING_POINT_LITERAL",
    "WHITESPACE",
    "LINE_COMMENT",
    "SIGN",
    "DIGIT",
    "A",
    "B",
    "C",
    "D",
    "E",
    "F",
    "G",
    "H",
    "I",
    "J",
    "K",
    "L",
    "M",
    "N",
    "O",
    "P",
    "Q",
    "R",
    "S",
    "T",
    "U",
    "V",
    "W",
    "X",
    "Y",
    "Z"
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
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u00ec\b\1\4\2"
          + "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"
          + "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"
          + "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"
          + "\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"
          + " \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"
          + "+\4,\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b"
          + "\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3"
          + "\r\3\16\5\16|\n\16\3\16\6\16\177\n\16\r\16\16\16\u0080\3\17\5\17\u0084"
          + "\n\17\3\17\6\17\u0087\n\17\r\17\16\17\u0088\3\17\3\17\7\17\u008d\n\17"
          + "\f\17\16\17\u0090\13\17\3\17\5\17\u0093\n\17\3\17\7\17\u0096\n\17\f\17"
          + "\16\17\u0099\13\17\3\17\3\17\6\17\u009d\n\17\r\17\16\17\u009e\5\17\u00a1"
          + "\n\17\3\20\6\20\u00a4\n\20\r\20\16\20\u00a5\3\20\3\20\3\21\3\21\3\21\3"
          + "\21\7\21\u00ae\n\21\f\21\16\21\u00b1\13\21\3\21\3\21\3\22\3\22\3\23\3"
          + "\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"
          + "\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""
          + "\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-"
          + "\3-\2\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"
          + "\35\20\37\21!\22#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2"
          + "A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2\3\2 \4\2\13\f\"\"\4\2\f\f\17\17"
          + "\4\2--//\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2I"
          + "Iii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4"
          + "\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZz"
          + "z\4\2[[{{\4\2\\\\||\2\u00da\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"
          + "\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"
          + "\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"
          + "\3\2\2\2\2!\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13c\3"
          + "\2\2\2\re\3\2\2\2\17h\3\2\2\2\21k\3\2\2\2\23n\3\2\2\2\25p\3\2\2\2\27s"
          + "\3\2\2\2\31w\3\2\2\2\33{\3\2\2\2\35\u00a0\3\2\2\2\37\u00a3\3\2\2\2!\u00a9"
          + "\3\2\2\2#\u00b4\3\2\2\2%\u00b6\3\2\2\2\'\u00b8\3\2\2\2)\u00ba\3\2\2\2"
          + "+\u00bc\3\2\2\2-\u00be\3\2\2\2/\u00c0\3\2\2\2\61\u00c2\3\2\2\2\63\u00c4"
          + "\3\2\2\2\65\u00c6\3\2\2\2\67\u00c8\3\2\2\29\u00ca\3\2\2\2;\u00cc\3\2\2"
          + "\2=\u00ce\3\2\2\2?\u00d0\3\2\2\2A\u00d2\3\2\2\2C\u00d4\3\2\2\2E\u00d6"
          + "\3\2\2\2G\u00d8\3\2\2\2I\u00da\3\2\2\2K\u00dc\3\2\2\2M\u00de\3\2\2\2O"
          + "\u00e0\3\2\2\2Q\u00e2\3\2\2\2S\u00e4\3\2\2\2U\u00e6\3\2\2\2W\u00e8\3\2"
          + "\2\2Y\u00ea\3\2\2\2[\\\7=\2\2\\\4\3\2\2\2]^\7*\2\2^\6\3\2\2\2_`\7+\2\2"
          + "`\b\3\2\2\2ab\7>\2\2b\n\3\2\2\2cd\7@\2\2d\f\3\2\2\2ef\7>\2\2fg\7@\2\2"
          + "g\16\3\2\2\2hi\7>\2\2ij\7?\2\2j\20\3\2\2\2kl\7@\2\2lm\7?\2\2m\22\3\2\2"
          + "\2no\7?\2\2o\24\3\2\2\2pq\7#\2\2qr\7?\2\2r\26\3\2\2\2st\5\'\24\2tu\5A"
          + "!\2uv\5-\27\2v\30\3\2\2\2wx\5C\"\2xy\5I%\2y\32\3\2\2\2z|\5#\22\2{z\3\2"
          + "\2\2{|\3\2\2\2|~\3\2\2\2}\177\5%\23\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080"
          + "~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\34\3\2\2\2\u0082\u0084\5#\22\2\u0083"
          + "\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0087\5%"
          + "\23\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088"
          + "\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008e\7\60\2\2\u008b\u008d\5"
          + "%\23\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"
          + "\u008f\3\2\2\2\u008f\u00a1\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0093\5#"
          + "\22\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0097\3\2\2\2\u0094"
          + "\u0096\5%\23\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2"
          + "\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a"
          + "\u009c\7\60\2\2\u009b\u009d\5%\23\2\u009c\u009b\3\2\2\2\u009d\u009e\3"
          + "\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0"
          + "\u0083\3\2\2\2\u00a0\u0092\3\2\2\2\u00a1\36\3\2\2\2\u00a2\u00a4\t\2\2"
          + "\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6"
          + "\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\b\20\2\2\u00a8 \3\2\2\2\u00a9"
          + "\u00aa\7/\2\2\u00aa\u00ab\7/\2\2\u00ab\u00af\3\2\2\2\u00ac\u00ae\n\3\2"
          + "\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"
          + "\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\b\21\3\2"
          + "\u00b3\"\3\2\2\2\u00b4\u00b5\t\4\2\2\u00b5$\3\2\2\2\u00b6\u00b7\t\5\2"
          + "\2\u00b7&\3\2\2\2\u00b8\u00b9\t\6\2\2\u00b9(\3\2\2\2\u00ba\u00bb\t\7\2"
          + "\2\u00bb*\3\2\2\2\u00bc\u00bd\t\b\2\2\u00bd,\3\2\2\2\u00be\u00bf\t\t\2"
          + "\2\u00bf.\3\2\2\2\u00c0\u00c1\t\n\2\2\u00c1\60\3\2\2\2\u00c2\u00c3\t\13"
          + "\2\2\u00c3\62\3\2\2\2\u00c4\u00c5\t\f\2\2\u00c5\64\3\2\2\2\u00c6\u00c7"
          + "\t\r\2\2\u00c7\66\3\2\2\2\u00c8\u00c9\t\16\2\2\u00c98\3\2\2\2\u00ca\u00cb"
          + "\t\17\2\2\u00cb:\3\2\2\2\u00cc\u00cd\t\20\2\2\u00cd<\3\2\2\2\u00ce\u00cf"
          + "\t\21\2\2\u00cf>\3\2\2\2\u00d0\u00d1\t\22\2\2\u00d1@\3\2\2\2\u00d2\u00d3"
          + "\t\23\2\2\u00d3B\3\2\2\2\u00d4\u00d5\t\24\2\2\u00d5D\3\2\2\2\u00d6\u00d7"
          + "\t\25\2\2\u00d7F\3\2\2\2\u00d8\u00d9\t\26\2\2\u00d9H\3\2\2\2\u00da\u00db"
          + "\t\27\2\2\u00dbJ\3\2\2\2\u00dc\u00dd\t\30\2\2\u00ddL\3\2\2\2\u00de\u00df"
          + "\t\31\2\2\u00dfN\3\2\2\2\u00e0\u00e1\t\32\2\2\u00e1P\3\2\2\2\u00e2\u00e3"
          + "\t\33\2\2\u00e3R\3\2\2\2\u00e4\u00e5\t\34\2\2\u00e5T\3\2\2\2\u00e6\u00e7"
          + "\t\35\2\2\u00e7V\3\2\2\2\u00e8\u00e9\t\36\2\2\u00e9X\3\2\2\2\u00ea\u00eb"
          + "\t\37\2\2\u00ebZ\3\2\2\2\16\2{\u0080\u0083\u0088\u008e\u0092\u0097\u009e"
          + "\u00a0\u00a5\u00af\4\b\2\2\2\3\2";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
