// Generated from /home/jakob/github/ideas/classpoolmod/src/NetBeans/neo4jtest/src/main/java/com/company/neo4jtest/antlr/lang.g4 by ANTLR 4.7.1
package com.company.jsop.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langParser extends Parser {
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
	public static final int
		RULE_block = 0, RULE_programElement = 1, RULE_expression = 2, RULE_statement = 3, 
		RULE_variableDeclaration = 4, RULE_assignment = 5, RULE_assignmentOp = 6, 
		RULE_returnStatement = 7, RULE_forStatement = 8, RULE_ifStatement = 9, 
		RULE_blockOrSingle = 10, RULE_expressionLogicalOr = 11, RULE_expressionLogicalAnd = 12, 
		RULE_expressionBitwiseOr = 13, RULE_expressionBitwiseXOr = 14, RULE_expressionBitwiseAnd = 15, 
		RULE_expressionEquality = 16, RULE_expressionEqualityOp = 17, RULE_expressionComparison = 18, 
		RULE_binaryComparisonOperand = 19, RULE_expression1 = 20, RULE_binaryAdditionOperand = 21, 
		RULE_binaryAdditionOperator = 22, RULE_expression2 = 23, RULE_binaryMultOperand = 24, 
		RULE_binaryMultOperator = 25, RULE_expression3 = 26, RULE_slotGetOrApply = 27, 
		RULE_slotGet = 28, RULE_slotGetByStaticId = 29, RULE_slotGetByDynamicId = 30, 
		RULE_slotSet = 31, RULE_slotSetByStaticId = 32, RULE_slotSetByDynamicId = 33, 
		RULE_sqBracketIndex = 34, RULE_expression4 = 35, RULE_identifier = 36, 
		RULE_string = 37, RULE_number = 38, RULE_bool = 39, RULE_objectLiteral = 40, 
		RULE_objectLiteralSlot = 41, RULE_arrayLiteral = 42, RULE_apply = 43, 
		RULE_functionLiteral = 44, RULE_nativeObject = 45, RULE_self = 46, RULE_groupExpression = 47, 
		RULE_newInstance = 48;
	public static final String[] ruleNames = {
		"block", "programElement", "expression", "statement", "variableDeclaration", 
		"assignment", "assignmentOp", "returnStatement", "forStatement", "ifStatement", 
		"blockOrSingle", "expressionLogicalOr", "expressionLogicalAnd", "expressionBitwiseOr", 
		"expressionBitwiseXOr", "expressionBitwiseAnd", "expressionEquality", 
		"expressionEqualityOp", "expressionComparison", "binaryComparisonOperand", 
		"expression1", "binaryAdditionOperand", "binaryAdditionOperator", "expression2", 
		"binaryMultOperand", "binaryMultOperator", "expression3", "slotGetOrApply", 
		"slotGet", "slotGetByStaticId", "slotGetByDynamicId", "slotSet", "slotSetByStaticId", 
		"slotSetByDynamicId", "sqBracketIndex", "expression4", "identifier", "string", 
		"number", "bool", "objectLiteral", "objectLiteralSlot", "arrayLiteral", 
		"apply", "functionLiteral", "nativeObject", "self", "groupExpression", 
		"newInstance"
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

	@Override
	public String getGrammarFileName() { return "lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public langParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class BlockContext extends ParserRuleContext {
		public List<ProgramElementContext> programElement() {
			return getRuleContexts(ProgramElementContext.class);
		}
		public ProgramElementContext programElement(int i) {
			return getRuleContext(ProgramElementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(98);
					programElement();
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class ProgramElementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(langParser.SEMI_COLON, 0); }
		public ProgramElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitProgramElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramElementContext programElement() throws RecognitionException {
		ProgramElementContext _localctx = new ProgramElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programElement);
		int _la;
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_VAR:
			case KW_RETURN:
			case KW_FOR:
			case KW_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				statement();
				}
				break;
			case KW_THIS:
			case KW_FUNCTION:
			case KW_NATIVE:
			case KW_TRUE:
			case KW_FALSE:
			case KW_NEW:
			case OPEN_PAR:
			case OPEN_BRACKET:
			case OPEN_SQ_BRACKET:
			case ID:
			case STRING:
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(105);
				expression();
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(106);
					match(SEMI_COLON);
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionLogicalOrContext expressionLogicalOr() {
			return getRuleContext(ExpressionLogicalOrContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expression);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				expressionLogicalOr();
				}
				break;
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

	public static class StatementContext extends ParserRuleContext {
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(langParser.SEMI_COLON, 0); }
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_VAR:
			case KW_RETURN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(117);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case KW_RETURN:
					{
					setState(115);
					returnStatement();
					}
					break;
				case KW_VAR:
					{
					setState(116);
					variableDeclaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(119);
					match(SEMI_COLON);
					}
				}

				}
				}
				break;
			case KW_FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				forStatement();
				}
				break;
			case KW_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				ifStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode KW_VAR() { return getToken(langParser.KW_VAR, 0); }
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(langParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(KW_VAR);
			setState(127);
			match(ID);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(128);
				match(ASSIGN);
				setState(129);
				expression();
				}
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public AssignmentOpContext assignmentOp() {
			return getRuleContext(AssignmentOpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(ID);
			setState(133);
			assignmentOp();
			setState(134);
			expression();
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

	public static class AssignmentOpContext extends ParserRuleContext {
		public Token op;
		public TerminalNode ASSIGN() { return getToken(langParser.ASSIGN, 0); }
		public TerminalNode ASSIGN_PLUS() { return getToken(langParser.ASSIGN_PLUS, 0); }
		public TerminalNode ASSIGN_MINUS() { return getToken(langParser.ASSIGN_MINUS, 0); }
		public TerminalNode ASSIGN_MULT() { return getToken(langParser.ASSIGN_MULT, 0); }
		public TerminalNode ASSIGN_DIV() { return getToken(langParser.ASSIGN_DIV, 0); }
		public TerminalNode ASSIGN_REM() { return getToken(langParser.ASSIGN_REM, 0); }
		public AssignmentOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitAssignmentOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOpContext assignmentOp() throws RecognitionException {
		AssignmentOpContext _localctx = new AssignmentOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignmentOp);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				((AssignmentOpContext)_localctx).op = match(ASSIGN);
				}
				break;
			case ASSIGN_PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				((AssignmentOpContext)_localctx).op = match(ASSIGN_PLUS);
				}
				break;
			case ASSIGN_MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				((AssignmentOpContext)_localctx).op = match(ASSIGN_MINUS);
				}
				break;
			case ASSIGN_MULT:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				((AssignmentOpContext)_localctx).op = match(ASSIGN_MULT);
				}
				break;
			case ASSIGN_DIV:
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				((AssignmentOpContext)_localctx).op = match(ASSIGN_DIV);
				}
				break;
			case ASSIGN_REM:
				enterOuterAlt(_localctx, 6);
				{
				setState(141);
				((AssignmentOpContext)_localctx).op = match(ASSIGN_REM);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode KW_RETURN() { return getToken(langParser.KW_RETURN, 0); }
		public Expression1Context expression1() {
			return getRuleContext(Expression1Context.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(KW_RETURN);
			setState(145);
			expression1();
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

	public static class ForStatementContext extends ParserRuleContext {
		public ExpressionContext init;
		public ExpressionContext condition;
		public ExpressionContext update;
		public BlockContext body;
		public TerminalNode KW_FOR() { return getToken(langParser.KW_FOR, 0); }
		public TerminalNode OPEN_PAR() { return getToken(langParser.OPEN_PAR, 0); }
		public List<TerminalNode> SEMI_COLON() { return getTokens(langParser.SEMI_COLON); }
		public TerminalNode SEMI_COLON(int i) {
			return getToken(langParser.SEMI_COLON, i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(langParser.CLOSE_PAR, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(langParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(langParser.CLOSE_BRACKET, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(KW_FOR);
			setState(148);
			match(OPEN_PAR);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_THIS) | (1L << KW_FUNCTION) | (1L << KW_NATIVE) | (1L << KW_TRUE) | (1L << KW_FALSE) | (1L << KW_NEW) | (1L << OPEN_PAR) | (1L << OPEN_BRACKET) | (1L << OPEN_SQ_BRACKET) | (1L << ID) | (1L << STRING) | (1L << NUMBER))) != 0)) {
				{
				setState(149);
				((ForStatementContext)_localctx).init = expression();
				}
			}

			setState(152);
			match(SEMI_COLON);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_THIS) | (1L << KW_FUNCTION) | (1L << KW_NATIVE) | (1L << KW_TRUE) | (1L << KW_FALSE) | (1L << KW_NEW) | (1L << OPEN_PAR) | (1L << OPEN_BRACKET) | (1L << OPEN_SQ_BRACKET) | (1L << ID) | (1L << STRING) | (1L << NUMBER))) != 0)) {
				{
				setState(153);
				((ForStatementContext)_localctx).condition = expression();
				}
			}

			setState(156);
			match(SEMI_COLON);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_THIS) | (1L << KW_FUNCTION) | (1L << KW_NATIVE) | (1L << KW_TRUE) | (1L << KW_FALSE) | (1L << KW_NEW) | (1L << OPEN_PAR) | (1L << OPEN_BRACKET) | (1L << OPEN_SQ_BRACKET) | (1L << ID) | (1L << STRING) | (1L << NUMBER))) != 0)) {
				{
				setState(157);
				((ForStatementContext)_localctx).update = expression();
				}
			}

			setState(160);
			match(CLOSE_PAR);
			setState(161);
			match(OPEN_BRACKET);
			setState(162);
			((ForStatementContext)_localctx).body = block();
			setState(163);
			match(CLOSE_BRACKET);
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

	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionContext condition;
		public BlockOrSingleContext trueBlock;
		public BlockOrSingleContext falseBlock;
		public TerminalNode KW_IF() { return getToken(langParser.KW_IF, 0); }
		public TerminalNode OPEN_PAR() { return getToken(langParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(langParser.CLOSE_PAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockOrSingleContext> blockOrSingle() {
			return getRuleContexts(BlockOrSingleContext.class);
		}
		public BlockOrSingleContext blockOrSingle(int i) {
			return getRuleContext(BlockOrSingleContext.class,i);
		}
		public TerminalNode KW_ELSE() { return getToken(langParser.KW_ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(KW_IF);
			setState(166);
			match(OPEN_PAR);
			setState(167);
			((IfStatementContext)_localctx).condition = expression();
			setState(168);
			match(CLOSE_PAR);
			setState(169);
			((IfStatementContext)_localctx).trueBlock = blockOrSingle();
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(170);
				match(KW_ELSE);
				setState(171);
				((IfStatementContext)_localctx).falseBlock = blockOrSingle();
				}
				break;
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

	public static class BlockOrSingleContext extends ParserRuleContext {
		public BlockContext content;
		public TerminalNode OPEN_BRACKET() { return getToken(langParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(langParser.CLOSE_BRACKET, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockOrSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockOrSingle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitBlockOrSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockOrSingleContext blockOrSingle() throws RecognitionException {
		BlockOrSingleContext _localctx = new BlockOrSingleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_blockOrSingle);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(174);
				match(OPEN_BRACKET);
				setState(175);
				((BlockOrSingleContext)_localctx).content = block();
				setState(176);
				match(CLOSE_BRACKET);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				((BlockOrSingleContext)_localctx).content = block();
				}
				break;
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

	public static class ExpressionLogicalOrContext extends ParserRuleContext {
		public List<ExpressionLogicalAndContext> expressionLogicalAnd() {
			return getRuleContexts(ExpressionLogicalAndContext.class);
		}
		public ExpressionLogicalAndContext expressionLogicalAnd(int i) {
			return getRuleContext(ExpressionLogicalAndContext.class,i);
		}
		public List<TerminalNode> OP_OR() { return getTokens(langParser.OP_OR); }
		public TerminalNode OP_OR(int i) {
			return getToken(langParser.OP_OR, i);
		}
		public ExpressionLogicalOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionLogicalOr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpressionLogicalOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionLogicalOrContext expressionLogicalOr() throws RecognitionException {
		ExpressionLogicalOrContext _localctx = new ExpressionLogicalOrContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expressionLogicalOr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			expressionLogicalAnd();
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(182);
					match(OP_OR);
					setState(183);
					expressionLogicalAnd();
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class ExpressionLogicalAndContext extends ParserRuleContext {
		public List<ExpressionBitwiseOrContext> expressionBitwiseOr() {
			return getRuleContexts(ExpressionBitwiseOrContext.class);
		}
		public ExpressionBitwiseOrContext expressionBitwiseOr(int i) {
			return getRuleContext(ExpressionBitwiseOrContext.class,i);
		}
		public List<TerminalNode> OP_AND() { return getTokens(langParser.OP_AND); }
		public TerminalNode OP_AND(int i) {
			return getToken(langParser.OP_AND, i);
		}
		public ExpressionLogicalAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionLogicalAnd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpressionLogicalAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionLogicalAndContext expressionLogicalAnd() throws RecognitionException {
		ExpressionLogicalAndContext _localctx = new ExpressionLogicalAndContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expressionLogicalAnd);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			expressionBitwiseOr();
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(190);
					match(OP_AND);
					setState(191);
					expressionBitwiseOr();
					}
					} 
				}
				setState(196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class ExpressionBitwiseOrContext extends ParserRuleContext {
		public List<ExpressionBitwiseXOrContext> expressionBitwiseXOr() {
			return getRuleContexts(ExpressionBitwiseXOrContext.class);
		}
		public ExpressionBitwiseXOrContext expressionBitwiseXOr(int i) {
			return getRuleContext(ExpressionBitwiseXOrContext.class,i);
		}
		public List<TerminalNode> OP_BOR() { return getTokens(langParser.OP_BOR); }
		public TerminalNode OP_BOR(int i) {
			return getToken(langParser.OP_BOR, i);
		}
		public ExpressionBitwiseOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionBitwiseOr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpressionBitwiseOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionBitwiseOrContext expressionBitwiseOr() throws RecognitionException {
		ExpressionBitwiseOrContext _localctx = new ExpressionBitwiseOrContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressionBitwiseOr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			expressionBitwiseXOr();
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(198);
					match(OP_BOR);
					setState(199);
					expressionBitwiseXOr();
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class ExpressionBitwiseXOrContext extends ParserRuleContext {
		public List<ExpressionBitwiseAndContext> expressionBitwiseAnd() {
			return getRuleContexts(ExpressionBitwiseAndContext.class);
		}
		public ExpressionBitwiseAndContext expressionBitwiseAnd(int i) {
			return getRuleContext(ExpressionBitwiseAndContext.class,i);
		}
		public List<TerminalNode> OP_BXOR() { return getTokens(langParser.OP_BXOR); }
		public TerminalNode OP_BXOR(int i) {
			return getToken(langParser.OP_BXOR, i);
		}
		public ExpressionBitwiseXOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionBitwiseXOr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpressionBitwiseXOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionBitwiseXOrContext expressionBitwiseXOr() throws RecognitionException {
		ExpressionBitwiseXOrContext _localctx = new ExpressionBitwiseXOrContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressionBitwiseXOr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			expressionBitwiseAnd();
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(206);
					match(OP_BXOR);
					setState(207);
					expressionBitwiseAnd();
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class ExpressionBitwiseAndContext extends ParserRuleContext {
		public List<ExpressionEqualityContext> expressionEquality() {
			return getRuleContexts(ExpressionEqualityContext.class);
		}
		public ExpressionEqualityContext expressionEquality(int i) {
			return getRuleContext(ExpressionEqualityContext.class,i);
		}
		public List<TerminalNode> OP_BAND() { return getTokens(langParser.OP_BAND); }
		public TerminalNode OP_BAND(int i) {
			return getToken(langParser.OP_BAND, i);
		}
		public ExpressionBitwiseAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionBitwiseAnd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpressionBitwiseAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionBitwiseAndContext expressionBitwiseAnd() throws RecognitionException {
		ExpressionBitwiseAndContext _localctx = new ExpressionBitwiseAndContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expressionBitwiseAnd);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			expressionEquality();
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(214);
					match(OP_BAND);
					setState(215);
					expressionEquality();
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class ExpressionEqualityContext extends ParserRuleContext {
		public List<ExpressionComparisonContext> expressionComparison() {
			return getRuleContexts(ExpressionComparisonContext.class);
		}
		public ExpressionComparisonContext expressionComparison(int i) {
			return getRuleContext(ExpressionComparisonContext.class,i);
		}
		public List<ExpressionEqualityOpContext> expressionEqualityOp() {
			return getRuleContexts(ExpressionEqualityOpContext.class);
		}
		public ExpressionEqualityOpContext expressionEqualityOp(int i) {
			return getRuleContext(ExpressionEqualityOpContext.class,i);
		}
		public ExpressionEqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionEquality; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpressionEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionEqualityContext expressionEquality() throws RecognitionException {
		ExpressionEqualityContext _localctx = new ExpressionEqualityContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expressionEquality);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			expressionComparison();
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(222);
					expressionEqualityOp();
					setState(223);
					expressionComparison();
					}
					} 
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class ExpressionEqualityOpContext extends ParserRuleContext {
		public Token op;
		public TerminalNode OP_EQ() { return getToken(langParser.OP_EQ, 0); }
		public TerminalNode OP_INEQ() { return getToken(langParser.OP_INEQ, 0); }
		public TerminalNode OP_SEQ() { return getToken(langParser.OP_SEQ, 0); }
		public TerminalNode OP_SINEQ() { return getToken(langParser.OP_SINEQ, 0); }
		public ExpressionEqualityOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionEqualityOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpressionEqualityOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionEqualityOpContext expressionEqualityOp() throws RecognitionException {
		ExpressionEqualityOpContext _localctx = new ExpressionEqualityOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionEqualityOp);
		try {
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_EQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				((ExpressionEqualityOpContext)_localctx).op = match(OP_EQ);
				}
				break;
			case OP_INEQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				((ExpressionEqualityOpContext)_localctx).op = match(OP_INEQ);
				}
				break;
			case OP_SEQ:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				((ExpressionEqualityOpContext)_localctx).op = match(OP_SEQ);
				}
				break;
			case OP_SINEQ:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				((ExpressionEqualityOpContext)_localctx).op = match(OP_SINEQ);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpressionComparisonContext extends ParserRuleContext {
		public Expression1Context expression1() {
			return getRuleContext(Expression1Context.class,0);
		}
		public List<BinaryComparisonOperandContext> binaryComparisonOperand() {
			return getRuleContexts(BinaryComparisonOperandContext.class);
		}
		public BinaryComparisonOperandContext binaryComparisonOperand(int i) {
			return getRuleContext(BinaryComparisonOperandContext.class,i);
		}
		public ExpressionComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionComparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpressionComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionComparisonContext expressionComparison() throws RecognitionException {
		ExpressionComparisonContext _localctx = new ExpressionComparisonContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressionComparison);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			expression1();
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(237);
					binaryComparisonOperand();
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class BinaryComparisonOperandContext extends ParserRuleContext {
		public Token op;
		public Expression1Context expression1() {
			return getRuleContext(Expression1Context.class,0);
		}
		public TerminalNode OP_LT() { return getToken(langParser.OP_LT, 0); }
		public TerminalNode OP_LTE() { return getToken(langParser.OP_LTE, 0); }
		public TerminalNode OP_GT() { return getToken(langParser.OP_GT, 0); }
		public TerminalNode OP_GTE() { return getToken(langParser.OP_GTE, 0); }
		public TerminalNode OP_IN() { return getToken(langParser.OP_IN, 0); }
		public TerminalNode OP_INO() { return getToken(langParser.OP_INO, 0); }
		public BinaryComparisonOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryComparisonOperand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitBinaryComparisonOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryComparisonOperandContext binaryComparisonOperand() throws RecognitionException {
		BinaryComparisonOperandContext _localctx = new BinaryComparisonOperandContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_binaryComparisonOperand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_LT:
				{
				setState(243);
				((BinaryComparisonOperandContext)_localctx).op = match(OP_LT);
				}
				break;
			case OP_LTE:
				{
				setState(244);
				((BinaryComparisonOperandContext)_localctx).op = match(OP_LTE);
				}
				break;
			case OP_GT:
				{
				setState(245);
				((BinaryComparisonOperandContext)_localctx).op = match(OP_GT);
				}
				break;
			case OP_GTE:
				{
				setState(246);
				((BinaryComparisonOperandContext)_localctx).op = match(OP_GTE);
				}
				break;
			case OP_IN:
				{
				setState(247);
				((BinaryComparisonOperandContext)_localctx).op = match(OP_IN);
				}
				break;
			case OP_INO:
				{
				setState(248);
				((BinaryComparisonOperandContext)_localctx).op = match(OP_INO);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(251);
			expression1();
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

	public static class Expression1Context extends ParserRuleContext {
		public Expression2Context expression2() {
			return getRuleContext(Expression2Context.class,0);
		}
		public List<BinaryAdditionOperandContext> binaryAdditionOperand() {
			return getRuleContexts(BinaryAdditionOperandContext.class);
		}
		public BinaryAdditionOperandContext binaryAdditionOperand(int i) {
			return getRuleContext(BinaryAdditionOperandContext.class,i);
		}
		public Expression1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpression1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression1Context expression1() throws RecognitionException {
		Expression1Context _localctx = new Expression1Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_expression1);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			expression2();
			setState(257);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(254);
					binaryAdditionOperand();
					}
					} 
				}
				setState(259);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class BinaryAdditionOperandContext extends ParserRuleContext {
		public BinaryAdditionOperatorContext binaryAdditionOperator() {
			return getRuleContext(BinaryAdditionOperatorContext.class,0);
		}
		public Expression2Context expression2() {
			return getRuleContext(Expression2Context.class,0);
		}
		public BinaryAdditionOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryAdditionOperand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitBinaryAdditionOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryAdditionOperandContext binaryAdditionOperand() throws RecognitionException {
		BinaryAdditionOperandContext _localctx = new BinaryAdditionOperandContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_binaryAdditionOperand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			binaryAdditionOperator();
			setState(261);
			expression2();
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

	public static class BinaryAdditionOperatorContext extends ParserRuleContext {
		public Token op;
		public TerminalNode OP_PLUS() { return getToken(langParser.OP_PLUS, 0); }
		public TerminalNode OP_MINUS() { return getToken(langParser.OP_MINUS, 0); }
		public BinaryAdditionOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryAdditionOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitBinaryAdditionOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryAdditionOperatorContext binaryAdditionOperator() throws RecognitionException {
		BinaryAdditionOperatorContext _localctx = new BinaryAdditionOperatorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_binaryAdditionOperator);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				((BinaryAdditionOperatorContext)_localctx).op = match(OP_PLUS);
				}
				break;
			case OP_MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				((BinaryAdditionOperatorContext)_localctx).op = match(OP_MINUS);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Expression2Context extends ParserRuleContext {
		public Expression3Context expression3() {
			return getRuleContext(Expression3Context.class,0);
		}
		public List<BinaryMultOperandContext> binaryMultOperand() {
			return getRuleContexts(BinaryMultOperandContext.class);
		}
		public BinaryMultOperandContext binaryMultOperand(int i) {
			return getRuleContext(BinaryMultOperandContext.class,i);
		}
		public Expression2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpression2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression2Context expression2() throws RecognitionException {
		Expression2Context _localctx = new Expression2Context(_ctx, getState());
		enterRule(_localctx, 46, RULE_expression2);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			expression3();
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(268);
					binaryMultOperand();
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class BinaryMultOperandContext extends ParserRuleContext {
		public BinaryMultOperatorContext binaryMultOperator() {
			return getRuleContext(BinaryMultOperatorContext.class,0);
		}
		public Expression3Context expression3() {
			return getRuleContext(Expression3Context.class,0);
		}
		public BinaryMultOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryMultOperand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitBinaryMultOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryMultOperandContext binaryMultOperand() throws RecognitionException {
		BinaryMultOperandContext _localctx = new BinaryMultOperandContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_binaryMultOperand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			binaryMultOperator();
			setState(275);
			expression3();
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

	public static class BinaryMultOperatorContext extends ParserRuleContext {
		public Token op;
		public TerminalNode OP_MULT() { return getToken(langParser.OP_MULT, 0); }
		public TerminalNode OP_DIV() { return getToken(langParser.OP_DIV, 0); }
		public TerminalNode OP_REM() { return getToken(langParser.OP_REM, 0); }
		public BinaryMultOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryMultOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitBinaryMultOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryMultOperatorContext binaryMultOperator() throws RecognitionException {
		BinaryMultOperatorContext _localctx = new BinaryMultOperatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_binaryMultOperator);
		try {
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_MULT:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				((BinaryMultOperatorContext)_localctx).op = match(OP_MULT);
				}
				break;
			case OP_DIV:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				((BinaryMultOperatorContext)_localctx).op = match(OP_DIV);
				}
				break;
			case OP_REM:
				enterOuterAlt(_localctx, 3);
				{
				setState(279);
				((BinaryMultOperatorContext)_localctx).op = match(OP_REM);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Expression3Context extends ParserRuleContext {
		public Expression4Context expression4() {
			return getRuleContext(Expression4Context.class,0);
		}
		public List<SlotGetOrApplyContext> slotGetOrApply() {
			return getRuleContexts(SlotGetOrApplyContext.class);
		}
		public SlotGetOrApplyContext slotGetOrApply(int i) {
			return getRuleContext(SlotGetOrApplyContext.class,i);
		}
		public SlotSetContext slotSet() {
			return getRuleContext(SlotSetContext.class,0);
		}
		public Expression3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpression3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression3Context expression3() throws RecognitionException {
		Expression3Context _localctx = new Expression3Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_expression3);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			expression4();
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(283);
					slotGetOrApply();
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(289);
				slotSet();
				}
				break;
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

	public static class SlotGetOrApplyContext extends ParserRuleContext {
		public SlotGetContext slotGet() {
			return getRuleContext(SlotGetContext.class,0);
		}
		public ApplyContext apply() {
			return getRuleContext(ApplyContext.class,0);
		}
		public SlotGetOrApplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotGetOrApply; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitSlotGetOrApply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotGetOrApplyContext slotGetOrApply() throws RecognitionException {
		SlotGetOrApplyContext _localctx = new SlotGetOrApplyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_slotGetOrApply);
		try {
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
			case OPEN_SQ_BRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				slotGet();
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				apply();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SlotGetContext extends ParserRuleContext {
		public SlotGetByStaticIdContext slotGetByStaticId() {
			return getRuleContext(SlotGetByStaticIdContext.class,0);
		}
		public SlotGetByDynamicIdContext slotGetByDynamicId() {
			return getRuleContext(SlotGetByDynamicIdContext.class,0);
		}
		public TerminalNode OP_PLUS_PLUS() { return getToken(langParser.OP_PLUS_PLUS, 0); }
		public TerminalNode OP_MINUS_MINUS() { return getToken(langParser.OP_MINUS_MINUS, 0); }
		public SlotGetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotGet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitSlotGet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotGetContext slotGet() throws RecognitionException {
		SlotGetContext _localctx = new SlotGetContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_slotGet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				{
				setState(296);
				slotGetByStaticId();
				}
				break;
			case OPEN_SQ_BRACKET:
				{
				setState(297);
				slotGetByDynamicId();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_PLUS_PLUS || _la==OP_MINUS_MINUS) {
				{
				setState(300);
				_la = _input.LA(1);
				if ( !(_la==OP_PLUS_PLUS || _la==OP_MINUS_MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
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

	public static class SlotGetByStaticIdContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(langParser.DOT, 0); }
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public SlotGetByStaticIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotGetByStaticId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitSlotGetByStaticId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotGetByStaticIdContext slotGetByStaticId() throws RecognitionException {
		SlotGetByStaticIdContext _localctx = new SlotGetByStaticIdContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_slotGetByStaticId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(DOT);
			setState(304);
			match(ID);
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

	public static class SlotGetByDynamicIdContext extends ParserRuleContext {
		public SqBracketIndexContext sqBracketIndex() {
			return getRuleContext(SqBracketIndexContext.class,0);
		}
		public SlotGetByDynamicIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotGetByDynamicId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitSlotGetByDynamicId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotGetByDynamicIdContext slotGetByDynamicId() throws RecognitionException {
		SlotGetByDynamicIdContext _localctx = new SlotGetByDynamicIdContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_slotGetByDynamicId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			sqBracketIndex();
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

	public static class SlotSetContext extends ParserRuleContext {
		public SlotSetByStaticIdContext slotSetByStaticId() {
			return getRuleContext(SlotSetByStaticIdContext.class,0);
		}
		public SlotSetByDynamicIdContext slotSetByDynamicId() {
			return getRuleContext(SlotSetByDynamicIdContext.class,0);
		}
		public SlotSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitSlotSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotSetContext slotSet() throws RecognitionException {
		SlotSetContext _localctx = new SlotSetContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_slotSet);
		try {
			setState(310);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				slotSetByStaticId();
				}
				break;
			case OPEN_SQ_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				slotSetByDynamicId();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SlotSetByStaticIdContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(langParser.DOT, 0); }
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public AssignmentOpContext assignmentOp() {
			return getRuleContext(AssignmentOpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SlotSetByStaticIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotSetByStaticId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitSlotSetByStaticId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotSetByStaticIdContext slotSetByStaticId() throws RecognitionException {
		SlotSetByStaticIdContext _localctx = new SlotSetByStaticIdContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_slotSetByStaticId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(DOT);
			setState(313);
			match(ID);
			setState(314);
			assignmentOp();
			setState(315);
			expression();
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

	public static class SlotSetByDynamicIdContext extends ParserRuleContext {
		public SqBracketIndexContext sqBracketIndex() {
			return getRuleContext(SqBracketIndexContext.class,0);
		}
		public AssignmentOpContext assignmentOp() {
			return getRuleContext(AssignmentOpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SlotSetByDynamicIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotSetByDynamicId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitSlotSetByDynamicId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotSetByDynamicIdContext slotSetByDynamicId() throws RecognitionException {
		SlotSetByDynamicIdContext _localctx = new SlotSetByDynamicIdContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_slotSetByDynamicId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			sqBracketIndex();
			setState(318);
			assignmentOp();
			setState(319);
			expression();
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

	public static class SqBracketIndexContext extends ParserRuleContext {
		public TerminalNode OPEN_SQ_BRACKET() { return getToken(langParser.OPEN_SQ_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_SQ_BRACKET() { return getToken(langParser.CLOSE_SQ_BRACKET, 0); }
		public SqBracketIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqBracketIndex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitSqBracketIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqBracketIndexContext sqBracketIndex() throws RecognitionException {
		SqBracketIndexContext _localctx = new SqBracketIndexContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_sqBracketIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(OPEN_SQ_BRACKET);
			setState(322);
			expression();
			setState(323);
			match(CLOSE_SQ_BRACKET);
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

	public static class Expression4Context extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public FunctionLiteralContext functionLiteral() {
			return getRuleContext(FunctionLiteralContext.class,0);
		}
		public NativeObjectContext nativeObject() {
			return getRuleContext(NativeObjectContext.class,0);
		}
		public SelfContext self() {
			return getRuleContext(SelfContext.class,0);
		}
		public GroupExpressionContext groupExpression() {
			return getRuleContext(GroupExpressionContext.class,0);
		}
		public NewInstanceContext newInstance() {
			return getRuleContext(NewInstanceContext.class,0);
		}
		public Expression4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression4; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpression4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression4Context expression4() throws RecognitionException {
		Expression4Context _localctx = new Expression4Context(_ctx, getState());
		enterRule(_localctx, 70, RULE_expression4);
		try {
			setState(336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(325);
				identifier();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(326);
				string();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(327);
				number();
				}
				break;
			case KW_TRUE:
			case KW_FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(328);
				bool();
				}
				break;
			case OPEN_BRACKET:
				enterOuterAlt(_localctx, 5);
				{
				setState(329);
				objectLiteral();
				}
				break;
			case OPEN_SQ_BRACKET:
				enterOuterAlt(_localctx, 6);
				{
				setState(330);
				arrayLiteral();
				}
				break;
			case KW_FUNCTION:
				enterOuterAlt(_localctx, 7);
				{
				setState(331);
				functionLiteral();
				}
				break;
			case KW_NATIVE:
				enterOuterAlt(_localctx, 8);
				{
				setState(332);
				nativeObject();
				}
				break;
			case KW_THIS:
				enterOuterAlt(_localctx, 9);
				{
				setState(333);
				self();
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 10);
				{
				setState(334);
				groupExpression();
				}
				break;
			case KW_NEW:
				enterOuterAlt(_localctx, 11);
				{
				setState(335);
				newInstance();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode OP_PLUS_PLUS() { return getToken(langParser.OP_PLUS_PLUS, 0); }
		public TerminalNode OP_MINUS_MINUS() { return getToken(langParser.OP_MINUS_MINUS, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(ID);
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_PLUS_PLUS || _la==OP_MINUS_MINUS) {
				{
				setState(339);
				_la = _input.LA(1);
				if ( !(_la==OP_PLUS_PLUS || _la==OP_MINUS_MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(langParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(STRING);
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
		public TerminalNode NUMBER() { return getToken(langParser.NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(NUMBER);
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

	public static class BoolContext extends ParserRuleContext {
		public Token b;
		public TerminalNode KW_TRUE() { return getToken(langParser.KW_TRUE, 0); }
		public TerminalNode KW_FALSE() { return getToken(langParser.KW_FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_bool);
		try {
			setState(348);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				((BoolContext)_localctx).b = match(KW_TRUE);
				}
				break;
			case KW_FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				((BoolContext)_localctx).b = match(KW_FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ObjectLiteralContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACKET() { return getToken(langParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(langParser.CLOSE_BRACKET, 0); }
		public List<ObjectLiteralSlotContext> objectLiteralSlot() {
			return getRuleContexts(ObjectLiteralSlotContext.class);
		}
		public ObjectLiteralSlotContext objectLiteralSlot(int i) {
			return getRuleContext(ObjectLiteralSlotContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(langParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(langParser.COMMA, i);
		}
		public ObjectLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitObjectLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectLiteralContext objectLiteral() throws RecognitionException {
		ObjectLiteralContext _localctx = new ObjectLiteralContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_objectLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(OPEN_BRACKET);
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(351);
				objectLiteralSlot();
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(352);
					match(COMMA);
					setState(353);
					objectLiteralSlot();
					}
					}
					setState(358);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(361);
			match(CLOSE_BRACKET);
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

	public static class ObjectLiteralSlotContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode COLON() { return getToken(langParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ObjectLiteralSlotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectLiteralSlot; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitObjectLiteralSlot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectLiteralSlotContext objectLiteralSlot() throws RecognitionException {
		ObjectLiteralSlotContext _localctx = new ObjectLiteralSlotContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_objectLiteralSlot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(ID);
			setState(364);
			match(COLON);
			setState(365);
			expression();
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

	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode OPEN_SQ_BRACKET() { return getToken(langParser.OPEN_SQ_BRACKET, 0); }
		public TerminalNode CLOSE_SQ_BRACKET() { return getToken(langParser.CLOSE_SQ_BRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(langParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(langParser.COMMA, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(OPEN_SQ_BRACKET);
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_THIS) | (1L << KW_FUNCTION) | (1L << KW_NATIVE) | (1L << KW_TRUE) | (1L << KW_FALSE) | (1L << KW_NEW) | (1L << OPEN_PAR) | (1L << OPEN_BRACKET) | (1L << OPEN_SQ_BRACKET) | (1L << ID) | (1L << STRING) | (1L << NUMBER))) != 0)) {
				{
				setState(368);
				expression();
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(369);
					match(COMMA);
					setState(370);
					expression();
					}
					}
					setState(375);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(378);
			match(CLOSE_SQ_BRACKET);
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

	public static class ApplyContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(langParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(langParser.CLOSE_PAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(langParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(langParser.COMMA, i);
		}
		public ApplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apply; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitApply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplyContext apply() throws RecognitionException {
		ApplyContext _localctx = new ApplyContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_apply);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(OPEN_PAR);
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_THIS) | (1L << KW_FUNCTION) | (1L << KW_NATIVE) | (1L << KW_TRUE) | (1L << KW_FALSE) | (1L << KW_NEW) | (1L << OPEN_PAR) | (1L << OPEN_BRACKET) | (1L << OPEN_SQ_BRACKET) | (1L << ID) | (1L << STRING) | (1L << NUMBER))) != 0)) {
				{
				setState(381);
				expression();
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(382);
					match(COMMA);
					setState(383);
					expression();
					}
					}
					setState(388);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(391);
			match(CLOSE_PAR);
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

	public static class FunctionLiteralContext extends ParserRuleContext {
		public BlockContext body;
		public TerminalNode KW_FUNCTION() { return getToken(langParser.KW_FUNCTION, 0); }
		public TerminalNode OPEN_PAR() { return getToken(langParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(langParser.CLOSE_PAR, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(langParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(langParser.CLOSE_BRACKET, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(langParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(langParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(langParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(langParser.COMMA, i);
		}
		public FunctionLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitFunctionLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionLiteralContext functionLiteral() throws RecognitionException {
		FunctionLiteralContext _localctx = new FunctionLiteralContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_functionLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(KW_FUNCTION);
			setState(394);
			match(OPEN_PAR);
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(395);
				match(ID);
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(396);
					match(COMMA);
					setState(397);
					match(ID);
					}
					}
					setState(402);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(405);
			match(CLOSE_PAR);
			setState(406);
			match(OPEN_BRACKET);
			setState(407);
			((FunctionLiteralContext)_localctx).body = block();
			setState(408);
			match(CLOSE_BRACKET);
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

	public static class NativeObjectContext extends ParserRuleContext {
		public TerminalNode KW_NATIVE() { return getToken(langParser.KW_NATIVE, 0); }
		public TerminalNode DOT() { return getToken(langParser.DOT, 0); }
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public NativeObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativeObject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitNativeObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NativeObjectContext nativeObject() throws RecognitionException {
		NativeObjectContext _localctx = new NativeObjectContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_nativeObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(KW_NATIVE);
			setState(411);
			match(DOT);
			setState(412);
			match(ID);
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

	public static class SelfContext extends ParserRuleContext {
		public TerminalNode KW_THIS() { return getToken(langParser.KW_THIS, 0); }
		public SelfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_self; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitSelf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfContext self() throws RecognitionException {
		SelfContext _localctx = new SelfContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_self);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			match(KW_THIS);
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

	public static class GroupExpressionContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(langParser.OPEN_PAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(langParser.CLOSE_PAR, 0); }
		public GroupExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitGroupExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupExpressionContext groupExpression() throws RecognitionException {
		GroupExpressionContext _localctx = new GroupExpressionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_groupExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(OPEN_PAR);
			setState(417);
			expression();
			setState(418);
			match(CLOSE_PAR);
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

	public static class NewInstanceContext extends ParserRuleContext {
		public TerminalNode KW_NEW() { return getToken(langParser.KW_NEW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ApplyContext apply() {
			return getRuleContext(ApplyContext.class,0);
		}
		public NewInstanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newInstance; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitNewInstance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewInstanceContext newInstance() throws RecognitionException {
		NewInstanceContext _localctx = new NewInstanceContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_newInstance);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			match(KW_NEW);
			setState(421);
			expression();
			setState(422);
			apply();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u01ab\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\7\2f\n\2\f\2"+
		"\16\2i\13\2\3\3\3\3\3\3\5\3n\n\3\5\3p\n\3\3\4\3\4\5\4t\n\4\3\5\3\5\5\5"+
		"x\n\5\3\5\5\5{\n\5\3\5\3\5\5\5\177\n\5\3\6\3\6\3\6\3\6\5\6\u0085\n\6\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0091\n\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\5\n\u0099\n\n\3\n\3\n\5\n\u009d\n\n\3\n\3\n\5\n\u00a1\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00af\n\13\3\f"+
		"\3\f\3\f\3\f\3\f\5\f\u00b6\n\f\3\r\3\r\3\r\7\r\u00bb\n\r\f\r\16\r\u00be"+
		"\13\r\3\16\3\16\3\16\7\16\u00c3\n\16\f\16\16\16\u00c6\13\16\3\17\3\17"+
		"\3\17\7\17\u00cb\n\17\f\17\16\17\u00ce\13\17\3\20\3\20\3\20\7\20\u00d3"+
		"\n\20\f\20\16\20\u00d6\13\20\3\21\3\21\3\21\7\21\u00db\n\21\f\21\16\21"+
		"\u00de\13\21\3\22\3\22\3\22\3\22\7\22\u00e4\n\22\f\22\16\22\u00e7\13\22"+
		"\3\23\3\23\3\23\3\23\5\23\u00ed\n\23\3\24\3\24\7\24\u00f1\n\24\f\24\16"+
		"\24\u00f4\13\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00fc\n\25\3\25\3\25"+
		"\3\26\3\26\7\26\u0102\n\26\f\26\16\26\u0105\13\26\3\27\3\27\3\27\3\30"+
		"\3\30\5\30\u010c\n\30\3\31\3\31\7\31\u0110\n\31\f\31\16\31\u0113\13\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\5\33\u011b\n\33\3\34\3\34\7\34\u011f\n"+
		"\34\f\34\16\34\u0122\13\34\3\34\5\34\u0125\n\34\3\35\3\35\5\35\u0129\n"+
		"\35\3\36\3\36\5\36\u012d\n\36\3\36\5\36\u0130\n\36\3\37\3\37\3\37\3 \3"+
		" \3!\3!\5!\u0139\n!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0153\n%\3&\3&\5&\u0157\n&\3\'\3\'\3(\3"+
		"(\3)\3)\5)\u015f\n)\3*\3*\3*\3*\7*\u0165\n*\f*\16*\u0168\13*\5*\u016a"+
		"\n*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\7,\u0176\n,\f,\16,\u0179\13,\5,\u017b"+
		"\n,\3,\3,\3-\3-\3-\3-\7-\u0183\n-\f-\16-\u0186\13-\5-\u0188\n-\3-\3-\3"+
		".\3.\3.\3.\3.\7.\u0191\n.\f.\16.\u0194\13.\5.\u0196\n.\3.\3.\3.\3.\3."+
		"\3/\3/\3/\3/\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\2"+
		"\2\63\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>"+
		"@BDFHJLNPRTVXZ\\^`b\2\3\4\2\17\17\21\21\2\u01ba\2g\3\2\2\2\4o\3\2\2\2"+
		"\6s\3\2\2\2\b~\3\2\2\2\n\u0080\3\2\2\2\f\u0086\3\2\2\2\16\u0090\3\2\2"+
		"\2\20\u0092\3\2\2\2\22\u0095\3\2\2\2\24\u00a7\3\2\2\2\26\u00b5\3\2\2\2"+
		"\30\u00b7\3\2\2\2\32\u00bf\3\2\2\2\34\u00c7\3\2\2\2\36\u00cf\3\2\2\2 "+
		"\u00d7\3\2\2\2\"\u00df\3\2\2\2$\u00ec\3\2\2\2&\u00ee\3\2\2\2(\u00fb\3"+
		"\2\2\2*\u00ff\3\2\2\2,\u0106\3\2\2\2.\u010b\3\2\2\2\60\u010d\3\2\2\2\62"+
		"\u0114\3\2\2\2\64\u011a\3\2\2\2\66\u011c\3\2\2\28\u0128\3\2\2\2:\u012c"+
		"\3\2\2\2<\u0131\3\2\2\2>\u0134\3\2\2\2@\u0138\3\2\2\2B\u013a\3\2\2\2D"+
		"\u013f\3\2\2\2F\u0143\3\2\2\2H\u0152\3\2\2\2J\u0154\3\2\2\2L\u0158\3\2"+
		"\2\2N\u015a\3\2\2\2P\u015e\3\2\2\2R\u0160\3\2\2\2T\u016d\3\2\2\2V\u0171"+
		"\3\2\2\2X\u017e\3\2\2\2Z\u018b\3\2\2\2\\\u019c\3\2\2\2^\u01a0\3\2\2\2"+
		"`\u01a2\3\2\2\2b\u01a6\3\2\2\2df\5\4\3\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2"+
		"gh\3\2\2\2h\3\3\2\2\2ig\3\2\2\2jp\5\b\5\2km\5\6\4\2ln\7&\2\2ml\3\2\2\2"+
		"mn\3\2\2\2np\3\2\2\2oj\3\2\2\2ok\3\2\2\2p\5\3\2\2\2qt\5\f\7\2rt\5\30\r"+
		"\2sq\3\2\2\2sr\3\2\2\2t\7\3\2\2\2ux\5\20\t\2vx\5\n\6\2wu\3\2\2\2wv\3\2"+
		"\2\2xz\3\2\2\2y{\7&\2\2zy\3\2\2\2z{\3\2\2\2{\177\3\2\2\2|\177\5\22\n\2"+
		"}\177\5\24\13\2~w\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177\t\3\2\2\2\u0080\u0081"+
		"\7\4\2\2\u0081\u0084\7\64\2\2\u0082\u0083\7(\2\2\u0083\u0085\5\6\4\2\u0084"+
		"\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\13\3\2\2\2\u0086\u0087\7\64\2"+
		"\2\u0087\u0088\5\16\b\2\u0088\u0089\5\6\4\2\u0089\r\3\2\2\2\u008a\u0091"+
		"\7(\2\2\u008b\u0091\7)\2\2\u008c\u0091\7*\2\2\u008d\u0091\7+\2\2\u008e"+
		"\u0091\7,\2\2\u008f\u0091\7-\2\2\u0090\u008a\3\2\2\2\u0090\u008b\3\2\2"+
		"\2\u0090\u008c\3\2\2\2\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f"+
		"\3\2\2\2\u0091\17\3\2\2\2\u0092\u0093\7\7\2\2\u0093\u0094\5*\26\2\u0094"+
		"\21\3\2\2\2\u0095\u0096\7\b\2\2\u0096\u0098\7.\2\2\u0097\u0099\5\6\4\2"+
		"\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c"+
		"\7&\2\2\u009b\u009d\5\6\4\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u00a0\7&\2\2\u009f\u00a1\5\6\4\2\u00a0\u009f\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7/\2\2\u00a3"+
		"\u00a4\7\60\2\2\u00a4\u00a5\5\2\2\2\u00a5\u00a6\7\61\2\2\u00a6\23\3\2"+
		"\2\2\u00a7\u00a8\7\t\2\2\u00a8\u00a9\7.\2\2\u00a9\u00aa\5\6\4\2\u00aa"+
		"\u00ab\7/\2\2\u00ab\u00ae\5\26\f\2\u00ac\u00ad\7\n\2\2\u00ad\u00af\5\26"+
		"\f\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\25\3\2\2\2\u00b0\u00b1"+
		"\7\60\2\2\u00b1\u00b2\5\2\2\2\u00b2\u00b3\7\61\2\2\u00b3\u00b6\3\2\2\2"+
		"\u00b4\u00b6\5\2\2\2\u00b5\u00b0\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\27"+
		"\3\2\2\2\u00b7\u00bc\5\32\16\2\u00b8\u00b9\7\33\2\2\u00b9\u00bb\5\32\16"+
		"\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd"+
		"\3\2\2\2\u00bd\31\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c4\5\34\17\2\u00c0"+
		"\u00c1\7\34\2\2\u00c1\u00c3\5\34\17\2\u00c2\u00c0\3\2\2\2\u00c3\u00c6"+
		"\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\33\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c7\u00cc\5\36\20\2\u00c8\u00c9\7\35\2\2\u00c9\u00cb"+
		"\5\36\20\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2"+
		"\u00cc\u00cd\3\2\2\2\u00cd\35\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d4"+
		"\5 \21\2\u00d0\u00d1\7\36\2\2\u00d1\u00d3\5 \21\2\u00d2\u00d0\3\2\2\2"+
		"\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\37"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00dc\5\"\22\2\u00d8\u00d9\7\37\2\2"+
		"\u00d9\u00db\5\"\22\2\u00da\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da"+
		"\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd!\3\2\2\2\u00de\u00dc\3\2\2\2\u00df"+
		"\u00e5\5&\24\2\u00e0\u00e1\5$\23\2\u00e1\u00e2\5&\24\2\u00e2\u00e4\3\2"+
		"\2\2\u00e3\u00e0\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6#\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00ed\7 \2\2\u00e9"+
		"\u00ed\7!\2\2\u00ea\u00ed\7\"\2\2\u00eb\u00ed\7#\2\2\u00ec\u00e8\3\2\2"+
		"\2\u00ec\u00e9\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed%"+
		"\3\2\2\2\u00ee\u00f2\5*\26\2\u00ef\u00f1\5(\25\2\u00f0\u00ef\3\2\2\2\u00f1"+
		"\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\'\3\2\2\2"+
		"\u00f4\u00f2\3\2\2\2\u00f5\u00fc\7\25\2\2\u00f6\u00fc\7\26\2\2\u00f7\u00fc"+
		"\7\27\2\2\u00f8\u00fc\7\30\2\2\u00f9\u00fc\7\31\2\2\u00fa\u00fc\7\32\2"+
		"\2\u00fb\u00f5\3\2\2\2\u00fb\u00f6\3\2\2\2\u00fb\u00f7\3\2\2\2\u00fb\u00f8"+
		"\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\5*\26\2\u00fe)\3\2\2\2\u00ff\u0103\5\60\31\2\u0100\u0102\5,\27"+
		"\2\u0101\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104"+
		"\3\2\2\2\u0104+\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\5.\30\2\u0107"+
		"\u0108\5\60\31\2\u0108-\3\2\2\2\u0109\u010c\7\16\2\2\u010a\u010c\7\20"+
		"\2\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c/\3\2\2\2\u010d\u0111"+
		"\5\66\34\2\u010e\u0110\5\62\32\2\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2"+
		"\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\61\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0114\u0115\5\64\33\2\u0115\u0116\5\66\34\2\u0116\63\3\2\2\2"+
		"\u0117\u011b\7\22\2\2\u0118\u011b\7\23\2\2\u0119\u011b\7\24\2\2\u011a"+
		"\u0117\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u0119\3\2\2\2\u011b\65\3\2\2"+
		"\2\u011c\u0120\5H%\2\u011d\u011f\58\35\2\u011e\u011d\3\2\2\2\u011f\u0122"+
		"\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0124\3\2\2\2\u0122"+
		"\u0120\3\2\2\2\u0123\u0125\5@!\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2"+
		"\2\u0125\67\3\2\2\2\u0126\u0129\5:\36\2\u0127\u0129\5X-\2\u0128\u0126"+
		"\3\2\2\2\u0128\u0127\3\2\2\2\u01299\3\2\2\2\u012a\u012d\5<\37\2\u012b"+
		"\u012d\5> \2\u012c\u012a\3\2\2\2\u012c\u012b\3\2\2\2\u012d\u012f\3\2\2"+
		"\2\u012e\u0130\t\2\2\2\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130;"+
		"\3\2\2\2\u0131\u0132\7$\2\2\u0132\u0133\7\64\2\2\u0133=\3\2\2\2\u0134"+
		"\u0135\5F$\2\u0135?\3\2\2\2\u0136\u0139\5B\"\2\u0137\u0139\5D#\2\u0138"+
		"\u0136\3\2\2\2\u0138\u0137\3\2\2\2\u0139A\3\2\2\2\u013a\u013b\7$\2\2\u013b"+
		"\u013c\7\64\2\2\u013c\u013d\5\16\b\2\u013d\u013e\5\6\4\2\u013eC\3\2\2"+
		"\2\u013f\u0140\5F$\2\u0140\u0141\5\16\b\2\u0141\u0142\5\6\4\2\u0142E\3"+
		"\2\2\2\u0143\u0144\7\62\2\2\u0144\u0145\5\6\4\2\u0145\u0146\7\63\2\2\u0146"+
		"G\3\2\2\2\u0147\u0153\5J&\2\u0148\u0153\5L\'\2\u0149\u0153\5N(\2\u014a"+
		"\u0153\5P)\2\u014b\u0153\5R*\2\u014c\u0153\5V,\2\u014d\u0153\5Z.\2\u014e"+
		"\u0153\5\\/\2\u014f\u0153\5^\60\2\u0150\u0153\5`\61\2\u0151\u0153\5b\62"+
		"\2\u0152\u0147\3\2\2\2\u0152\u0148\3\2\2\2\u0152\u0149\3\2\2\2\u0152\u014a"+
		"\3\2\2\2\u0152\u014b\3\2\2\2\u0152\u014c\3\2\2\2\u0152\u014d\3\2\2\2\u0152"+
		"\u014e\3\2\2\2\u0152\u014f\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0151\3\2"+
		"\2\2\u0153I\3\2\2\2\u0154\u0156\7\64\2\2\u0155\u0157\t\2\2\2\u0156\u0155"+
		"\3\2\2\2\u0156\u0157\3\2\2\2\u0157K\3\2\2\2\u0158\u0159\7\65\2\2\u0159"+
		"M\3\2\2\2\u015a\u015b\7\66\2\2\u015bO\3\2\2\2\u015c\u015f\7\13\2\2\u015d"+
		"\u015f\7\f\2\2\u015e\u015c\3\2\2\2\u015e\u015d\3\2\2\2\u015fQ\3\2\2\2"+
		"\u0160\u0169\7\60\2\2\u0161\u0166\5T+\2\u0162\u0163\7\'\2\2\u0163\u0165"+
		"\5T+\2\u0164\u0162\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u0161\3\2"+
		"\2\2\u0169\u016a\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\7\61\2\2\u016c"+
		"S\3\2\2\2\u016d\u016e\7\64\2\2\u016e\u016f\7%\2\2\u016f\u0170\5\6\4\2"+
		"\u0170U\3\2\2\2\u0171\u017a\7\62\2\2\u0172\u0177\5\6\4\2\u0173\u0174\7"+
		"\'\2\2\u0174\u0176\5\6\4\2\u0175\u0173\3\2\2\2\u0176\u0179\3\2\2\2\u0177"+
		"\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2"+
		"\2\2\u017a\u0172\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c\3\2\2\2\u017c"+
		"\u017d\7\63\2\2\u017dW\3\2\2\2\u017e\u0187\7.\2\2\u017f\u0184\5\6\4\2"+
		"\u0180\u0181\7\'\2\2\u0181\u0183\5\6\4\2\u0182\u0180\3\2\2\2\u0183\u0186"+
		"\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0188\3\2\2\2\u0186"+
		"\u0184\3\2\2\2\u0187\u017f\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\3\2"+
		"\2\2\u0189\u018a\7/\2\2\u018aY\3\2\2\2\u018b\u018c\7\5\2\2\u018c\u0195"+
		"\7.\2\2\u018d\u0192\7\64\2\2\u018e\u018f\7\'\2\2\u018f\u0191\7\64\2\2"+
		"\u0190\u018e\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193"+
		"\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u018d\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\7/\2\2\u0198\u0199\7\60"+
		"\2\2\u0199\u019a\5\2\2\2\u019a\u019b\7\61\2\2\u019b[\3\2\2\2\u019c\u019d"+
		"\7\6\2\2\u019d\u019e\7$\2\2\u019e\u019f\7\64\2\2\u019f]\3\2\2\2\u01a0"+
		"\u01a1\7\3\2\2\u01a1_\3\2\2\2\u01a2\u01a3\7.\2\2\u01a3\u01a4\5\6\4\2\u01a4"+
		"\u01a5\7/\2\2\u01a5a\3\2\2\2\u01a6\u01a7\7\r\2\2\u01a7\u01a8\5\6\4\2\u01a8"+
		"\u01a9\5X-\2\u01a9c\3\2\2\2.gmoswz~\u0084\u0090\u0098\u009c\u00a0\u00ae"+
		"\u00b5\u00bc\u00c4\u00cc\u00d4\u00dc\u00e5\u00ec\u00f2\u00fb\u0103\u010b"+
		"\u0111\u011a\u0120\u0124\u0128\u012c\u012f\u0138\u0152\u0156\u015e\u0166"+
		"\u0169\u0177\u017a\u0184\u0187\u0192\u0195";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}