// Generated from /home/jakob/github/ideas/classpoolmod/src/NetBeans/neo4jtest/src/main/java/com/company/neo4jtest/antlr/lang.g4 by ANTLR 4.7.1
package com.company.jsop.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KW_THIS=1, KW_VAR=2, KW_FUNCTION=3, KW_NATIVE=4, KW_RETURN=5, KW_FOR=6, 
		KW_IF=7, KW_ELSE=8, KW_TRUE=9, KW_FALSE=10, KW_NEW=11, OP_PLUS=12, OP_PLUS_PLUS=13, 
		OP_MINUS=14, OP_MINUS_MINUS=15, OP_MULT=16, OP_DIV=17, OP_REM=18, OP_LT=19, 
		OP_LTE=20, OP_GT=21, OP_GTE=22, OP_IN=23, OP_INO=24, OP_OR=25, OP_AND=26, 
		OP_BOR=27, OP_BXOR=28, OP_BAND=29, OP_EQ=30, OP_INEQ=31, OP_SEQ=32, OP_SINEQ=33, 
		DOT=34, COLON=35, SEMI_COLON=36, COMMA=37, ASSIGN=38, ASSIGN_PLUS=39, 
		ASSIGN_MINUS=40, ASSIGN_MULT=41, ASSIGN_DIV=42, ASSIGN_REM=43, OPEN_PAR=44, 
		CLOSE_PAR=45, OPEN_BRACKET=46, CLOSE_BRACKET=47, OPEN_SQ_BRACKET=48, CLOSE_SQ_BRACKET=49, 
		ID=50, STRING=51, NUMBER=52, WS=53, SINGLE_LINE_COMMENT=54, MULTI_LINE_COMMENT=55;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KW_THIS", "KW_VAR", "KW_FUNCTION", "KW_NATIVE", "KW_RETURN", "KW_FOR", 
		"KW_IF", "KW_ELSE", "KW_TRUE", "KW_FALSE", "KW_NEW", "OP_PLUS", "OP_PLUS_PLUS", 
		"OP_MINUS", "OP_MINUS_MINUS", "OP_MULT", "OP_DIV", "OP_REM", "OP_LT", 
		"OP_LTE", "OP_GT", "OP_GTE", "OP_IN", "OP_INO", "OP_OR", "OP_AND", "OP_BOR", 
		"OP_BXOR", "OP_BAND", "OP_EQ", "OP_INEQ", "OP_SEQ", "OP_SINEQ", "DOT", 
		"COLON", "SEMI_COLON", "COMMA", "ASSIGN", "ASSIGN_PLUS", "ASSIGN_MINUS", 
		"ASSIGN_MULT", "ASSIGN_DIV", "ASSIGN_REM", "OPEN_PAR", "CLOSE_PAR", "OPEN_BRACKET", 
		"CLOSE_BRACKET", "OPEN_SQ_BRACKET", "CLOSE_SQ_BRACKET", "DIGIT", "LETTER", 
		"ID", "STRING", "ESC", "UNICODE", "HEX", "NUMBER", "INT", "EXP", "WS", 
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'this'", "'var'", "'function'", "'native'", "'return'", "'for'", 
		"'if'", "'else'", "'true'", "'false'", "'new'", "'+'", "'++'", "'-'", 
		"'--'", "'*'", "'/'", "'%'", "'<'", "'<='", "'>'", "'>='", "'in'", "'instanceof'", 
		"'||'", "'&&'", "'|'", "'^'", "'&'", "'=='", "'!='", "'==='", "'!=='", 
		"'.'", "':'", "';'", "','", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", 
		"'('", "')'", "'{'", "'}'", "'['", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KW_THIS", "KW_VAR", "KW_FUNCTION", "KW_NATIVE", "KW_RETURN", "KW_FOR", 
		"KW_IF", "KW_ELSE", "KW_TRUE", "KW_FALSE", "KW_NEW", "OP_PLUS", "OP_PLUS_PLUS", 
		"OP_MINUS", "OP_MINUS_MINUS", "OP_MULT", "OP_DIV", "OP_REM", "OP_LT", 
		"OP_LTE", "OP_GT", "OP_GTE", "OP_IN", "OP_INO", "OP_OR", "OP_AND", "OP_BOR", 
		"OP_BXOR", "OP_BAND", "OP_EQ", "OP_INEQ", "OP_SEQ", "OP_SINEQ", "DOT", 
		"COLON", "SEMI_COLON", "COMMA", "ASSIGN", "ASSIGN_PLUS", "ASSIGN_MINUS", 
		"ASSIGN_MULT", "ASSIGN_DIV", "ASSIGN_REM", "OPEN_PAR", "CLOSE_PAR", "OPEN_BRACKET", 
		"CLOSE_BRACKET", "OPEN_SQ_BRACKET", "CLOSE_SQ_BRACKET", "ID", "STRING", 
		"NUMBER", "WS", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
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


	public langLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\29\u0192\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3"+
		"+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63"+
		"\3\64\5\64\u0125\n\64\3\65\3\65\5\65\u0129\n\65\3\65\3\65\3\65\7\65\u012e"+
		"\n\65\f\65\16\65\u0131\13\65\3\66\3\66\3\66\7\66\u0136\n\66\f\66\16\66"+
		"\u0139\13\66\3\66\3\66\3\67\3\67\3\67\5\67\u0140\n\67\38\38\38\38\38\3"+
		"8\39\39\3:\5:\u014b\n:\3:\3:\3:\6:\u0150\n:\r:\16:\u0151\3:\5:\u0155\n"+
		":\3:\5:\u0158\n:\3:\3:\3:\3:\5:\u015e\n:\3:\5:\u0161\n:\3;\3;\3;\7;\u0166"+
		"\n;\f;\16;\u0169\13;\5;\u016b\n;\3<\3<\5<\u016f\n<\3<\3<\3=\6=\u0174\n"+
		"=\r=\16=\u0175\3=\3=\3>\3>\3>\3>\7>\u017e\n>\f>\16>\u0181\13>\3>\3>\3"+
		"?\3?\3?\3?\7?\u0189\n?\f?\16?\u018c\13?\3?\3?\3?\3?\3?\3\u018a\2@\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\2g\2i\64k\65m\2o\2q\2"+
		"s\66u\2w\2y\67{8}9\3\2\f\3\2\62;\4\2C\\c|\4\2$$^^\n\2$$\61\61^^ddhhpp"+
		"ttvv\5\2\62;CHch\3\2\63;\4\2GGgg\4\2--//\5\2\13\f\17\17\"\"\4\2\f\f\17"+
		"\17\2\u019e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2s\3\2\2\2\2y\3\2\2\2"+
		"\2{\3\2\2\2\2}\3\2\2\2\3\177\3\2\2\2\5\u0084\3\2\2\2\7\u0088\3\2\2\2\t"+
		"\u0091\3\2\2\2\13\u0098\3\2\2\2\r\u009f\3\2\2\2\17\u00a3\3\2\2\2\21\u00a6"+
		"\3\2\2\2\23\u00ab\3\2\2\2\25\u00b0\3\2\2\2\27\u00b6\3\2\2\2\31\u00ba\3"+
		"\2\2\2\33\u00bc\3\2\2\2\35\u00bf\3\2\2\2\37\u00c1\3\2\2\2!\u00c4\3\2\2"+
		"\2#\u00c6\3\2\2\2%\u00c8\3\2\2\2\'\u00ca\3\2\2\2)\u00cc\3\2\2\2+\u00cf"+
		"\3\2\2\2-\u00d1\3\2\2\2/\u00d4\3\2\2\2\61\u00d7\3\2\2\2\63\u00e2\3\2\2"+
		"\2\65\u00e5\3\2\2\2\67\u00e8\3\2\2\29\u00ea\3\2\2\2;\u00ec\3\2\2\2=\u00ee"+
		"\3\2\2\2?\u00f1\3\2\2\2A\u00f4\3\2\2\2C\u00f8\3\2\2\2E\u00fc\3\2\2\2G"+
		"\u00fe\3\2\2\2I\u0100\3\2\2\2K\u0102\3\2\2\2M\u0104\3\2\2\2O\u0106\3\2"+
		"\2\2Q\u0109\3\2\2\2S\u010c\3\2\2\2U\u010f\3\2\2\2W\u0112\3\2\2\2Y\u0115"+
		"\3\2\2\2[\u0117\3\2\2\2]\u0119\3\2\2\2_\u011b\3\2\2\2a\u011d\3\2\2\2c"+
		"\u011f\3\2\2\2e\u0121\3\2\2\2g\u0124\3\2\2\2i\u0128\3\2\2\2k\u0132\3\2"+
		"\2\2m\u013c\3\2\2\2o\u0141\3\2\2\2q\u0147\3\2\2\2s\u0160\3\2\2\2u\u016a"+
		"\3\2\2\2w\u016c\3\2\2\2y\u0173\3\2\2\2{\u0179\3\2\2\2}\u0184\3\2\2\2\177"+
		"\u0080\7v\2\2\u0080\u0081\7j\2\2\u0081\u0082\7k\2\2\u0082\u0083\7u\2\2"+
		"\u0083\4\3\2\2\2\u0084\u0085\7x\2\2\u0085\u0086\7c\2\2\u0086\u0087\7t"+
		"\2\2\u0087\6\3\2\2\2\u0088\u0089\7h\2\2\u0089\u008a\7w\2\2\u008a\u008b"+
		"\7p\2\2\u008b\u008c\7e\2\2\u008c\u008d\7v\2\2\u008d\u008e\7k\2\2\u008e"+
		"\u008f\7q\2\2\u008f\u0090\7p\2\2\u0090\b\3\2\2\2\u0091\u0092\7p\2\2\u0092"+
		"\u0093\7c\2\2\u0093\u0094\7v\2\2\u0094\u0095\7k\2\2\u0095\u0096\7x\2\2"+
		"\u0096\u0097\7g\2\2\u0097\n\3\2\2\2\u0098\u0099\7t\2\2\u0099\u009a\7g"+
		"\2\2\u009a\u009b\7v\2\2\u009b\u009c\7w\2\2\u009c\u009d\7t\2\2\u009d\u009e"+
		"\7p\2\2\u009e\f\3\2\2\2\u009f\u00a0\7h\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2"+
		"\7t\2\2\u00a2\16\3\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7h\2\2\u00a5\20"+
		"\3\2\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7u\2\2\u00a9"+
		"\u00aa\7g\2\2\u00aa\22\3\2\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7t\2\2\u00ad"+
		"\u00ae\7w\2\2\u00ae\u00af\7g\2\2\u00af\24\3\2\2\2\u00b0\u00b1\7h\2\2\u00b1"+
		"\u00b2\7c\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7u\2\2\u00b4\u00b5\7g\2\2"+
		"\u00b5\26\3\2\2\2\u00b6\u00b7\7p\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7"+
		"y\2\2\u00b9\30\3\2\2\2\u00ba\u00bb\7-\2\2\u00bb\32\3\2\2\2\u00bc\u00bd"+
		"\7-\2\2\u00bd\u00be\7-\2\2\u00be\34\3\2\2\2\u00bf\u00c0\7/\2\2\u00c0\36"+
		"\3\2\2\2\u00c1\u00c2\7/\2\2\u00c2\u00c3\7/\2\2\u00c3 \3\2\2\2\u00c4\u00c5"+
		"\7,\2\2\u00c5\"\3\2\2\2\u00c6\u00c7\7\61\2\2\u00c7$\3\2\2\2\u00c8\u00c9"+
		"\7\'\2\2\u00c9&\3\2\2\2\u00ca\u00cb\7>\2\2\u00cb(\3\2\2\2\u00cc\u00cd"+
		"\7>\2\2\u00cd\u00ce\7?\2\2\u00ce*\3\2\2\2\u00cf\u00d0\7@\2\2\u00d0,\3"+
		"\2\2\2\u00d1\u00d2\7@\2\2\u00d2\u00d3\7?\2\2\u00d3.\3\2\2\2\u00d4\u00d5"+
		"\7k\2\2\u00d5\u00d6\7p\2\2\u00d6\60\3\2\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9"+
		"\7p\2\2\u00d9\u00da\7u\2\2\u00da\u00db\7v\2\2\u00db\u00dc\7c\2\2\u00dc"+
		"\u00dd\7p\2\2\u00dd\u00de\7e\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7q\2\2"+
		"\u00e0\u00e1\7h\2\2\u00e1\62\3\2\2\2\u00e2\u00e3\7~\2\2\u00e3\u00e4\7"+
		"~\2\2\u00e4\64\3\2\2\2\u00e5\u00e6\7(\2\2\u00e6\u00e7\7(\2\2\u00e7\66"+
		"\3\2\2\2\u00e8\u00e9\7~\2\2\u00e98\3\2\2\2\u00ea\u00eb\7`\2\2\u00eb:\3"+
		"\2\2\2\u00ec\u00ed\7(\2\2\u00ed<\3\2\2\2\u00ee\u00ef\7?\2\2\u00ef\u00f0"+
		"\7?\2\2\u00f0>\3\2\2\2\u00f1\u00f2\7#\2\2\u00f2\u00f3\7?\2\2\u00f3@\3"+
		"\2\2\2\u00f4\u00f5\7?\2\2\u00f5\u00f6\7?\2\2\u00f6\u00f7\7?\2\2\u00f7"+
		"B\3\2\2\2\u00f8\u00f9\7#\2\2\u00f9\u00fa\7?\2\2\u00fa\u00fb\7?\2\2\u00fb"+
		"D\3\2\2\2\u00fc\u00fd\7\60\2\2\u00fdF\3\2\2\2\u00fe\u00ff\7<\2\2\u00ff"+
		"H\3\2\2\2\u0100\u0101\7=\2\2\u0101J\3\2\2\2\u0102\u0103\7.\2\2\u0103L"+
		"\3\2\2\2\u0104\u0105\7?\2\2\u0105N\3\2\2\2\u0106\u0107\7-\2\2\u0107\u0108"+
		"\7?\2\2\u0108P\3\2\2\2\u0109\u010a\7/\2\2\u010a\u010b\7?\2\2\u010bR\3"+
		"\2\2\2\u010c\u010d\7,\2\2\u010d\u010e\7?\2\2\u010eT\3\2\2\2\u010f\u0110"+
		"\7\61\2\2\u0110\u0111\7?\2\2\u0111V\3\2\2\2\u0112\u0113\7\'\2\2\u0113"+
		"\u0114\7?\2\2\u0114X\3\2\2\2\u0115\u0116\7*\2\2\u0116Z\3\2\2\2\u0117\u0118"+
		"\7+\2\2\u0118\\\3\2\2\2\u0119\u011a\7}\2\2\u011a^\3\2\2\2\u011b\u011c"+
		"\7\177\2\2\u011c`\3\2\2\2\u011d\u011e\7]\2\2\u011eb\3\2\2\2\u011f\u0120"+
		"\7_\2\2\u0120d\3\2\2\2\u0121\u0122\t\2\2\2\u0122f\3\2\2\2\u0123\u0125"+
		"\t\3\2\2\u0124\u0123\3\2\2\2\u0125h\3\2\2\2\u0126\u0129\5g\64\2\u0127"+
		"\u0129\7a\2\2\u0128\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129\u012f\3\2"+
		"\2\2\u012a\u012e\5g\64\2\u012b\u012e\7a\2\2\u012c\u012e\5e\63\2\u012d"+
		"\u012a\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2"+
		"\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130j\3\2\2\2\u0131\u012f"+
		"\3\2\2\2\u0132\u0137\7$\2\2\u0133\u0136\5m\67\2\u0134\u0136\n\4\2\2\u0135"+
		"\u0133\3\2\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2"+
		"\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013b\7$\2\2\u013bl\3\2\2\2\u013c\u013f\7^\2\2\u013d\u0140\t\5\2\2\u013e"+
		"\u0140\5o8\2\u013f\u013d\3\2\2\2\u013f\u013e\3\2\2\2\u0140n\3\2\2\2\u0141"+
		"\u0142\7w\2\2\u0142\u0143\5q9\2\u0143\u0144\5q9\2\u0144\u0145\5q9\2\u0145"+
		"\u0146\5q9\2\u0146p\3\2\2\2\u0147\u0148\t\6\2\2\u0148r\3\2\2\2\u0149\u014b"+
		"\7/\2\2\u014a\u0149\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014d\5u;\2\u014d\u014f\7\60\2\2\u014e\u0150\t\2\2\2\u014f\u014e\3\2"+
		"\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0154\3\2\2\2\u0153\u0155\5w<\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2"+
		"\2\u0155\u0161\3\2\2\2\u0156\u0158\7/\2\2\u0157\u0156\3\2\2\2\u0157\u0158"+
		"\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\5u;\2\u015a\u015b\5w<\2\u015b"+
		"\u0161\3\2\2\2\u015c\u015e\7/\2\2\u015d\u015c\3\2\2\2\u015d\u015e\3\2"+
		"\2\2\u015e\u015f\3\2\2\2\u015f\u0161\5u;\2\u0160\u014a\3\2\2\2\u0160\u0157"+
		"\3\2\2\2\u0160\u015d\3\2\2\2\u0161t\3\2\2\2\u0162\u016b\7\62\2\2\u0163"+
		"\u0167\t\7\2\2\u0164\u0166\t\2\2\2\u0165\u0164\3\2\2\2\u0166\u0169\3\2"+
		"\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016b\3\2\2\2\u0169"+
		"\u0167\3\2\2\2\u016a\u0162\3\2\2\2\u016a\u0163\3\2\2\2\u016bv\3\2\2\2"+
		"\u016c\u016e\t\b\2\2\u016d\u016f\t\t\2\2\u016e\u016d\3\2\2\2\u016e\u016f"+
		"\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\5u;\2\u0171x\3\2\2\2\u0172\u0174"+
		"\t\n\2\2\u0173\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0173\3\2\2\2\u0175"+
		"\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\b=\2\2\u0178z\3\2\2\2\u0179"+
		"\u017a\7\61\2\2\u017a\u017b\7\61\2\2\u017b\u017f\3\2\2\2\u017c\u017e\n"+
		"\13\2\2\u017d\u017c\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\b>"+
		"\3\2\u0183|\3\2\2\2\u0184\u0185\7\61\2\2\u0185\u0186\7,\2\2\u0186\u018a"+
		"\3\2\2\2\u0187\u0189\13\2\2\2\u0188\u0187\3\2\2\2\u0189\u018c\3\2\2\2"+
		"\u018a\u018b\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u018a"+
		"\3\2\2\2\u018d\u018e\7,\2\2\u018e\u018f\7\61\2\2\u018f\u0190\3\2\2\2\u0190"+
		"\u0191\b?\3\2\u0191~\3\2\2\2\26\2\u0124\u0128\u012d\u012f\u0135\u0137"+
		"\u013f\u014a\u0151\u0154\u0157\u015d\u0160\u0167\u016a\u016e\u0175\u017f"+
		"\u018a\4\2\4\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}