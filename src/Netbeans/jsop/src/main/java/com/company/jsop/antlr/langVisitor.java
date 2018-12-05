// Generated from /home/jakob/github/ideas/classpoolmod/src/NetBeans/neo4jtest/src/main/java/com/company/neo4jtest/antlr/lang.g4 by ANTLR 4.7.1
package com.company.jsop.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link langParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface langVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link langParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(langParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#programElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramElement(langParser.ProgramElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(langParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(langParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(langParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(langParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#assignmentOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOp(langParser.AssignmentOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(langParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(langParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(langParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#blockOrSingle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockOrSingle(langParser.BlockOrSingleContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expressionLogicalOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionLogicalOr(langParser.ExpressionLogicalOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expressionLogicalAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionLogicalAnd(langParser.ExpressionLogicalAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expressionBitwiseOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBitwiseOr(langParser.ExpressionBitwiseOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expressionBitwiseXOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBitwiseXOr(langParser.ExpressionBitwiseXOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expressionBitwiseAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBitwiseAnd(langParser.ExpressionBitwiseAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expressionEquality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEquality(langParser.ExpressionEqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expressionEqualityOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEqualityOp(langParser.ExpressionEqualityOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expressionComparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionComparison(langParser.ExpressionComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#binaryComparisonOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryComparisonOperand(langParser.BinaryComparisonOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expression1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression1(langParser.Expression1Context ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#binaryAdditionOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryAdditionOperand(langParser.BinaryAdditionOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#binaryAdditionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryAdditionOperator(langParser.BinaryAdditionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression2(langParser.Expression2Context ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#binaryMultOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryMultOperand(langParser.BinaryMultOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#binaryMultOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryMultOperator(langParser.BinaryMultOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expression3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression3(langParser.Expression3Context ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#slotGetOrApply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlotGetOrApply(langParser.SlotGetOrApplyContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#slotGet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlotGet(langParser.SlotGetContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#slotGetByStaticId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlotGetByStaticId(langParser.SlotGetByStaticIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#slotGetByDynamicId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlotGetByDynamicId(langParser.SlotGetByDynamicIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#slotSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlotSet(langParser.SlotSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#slotSetByStaticId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlotSetByStaticId(langParser.SlotSetByStaticIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#slotSetByDynamicId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlotSetByDynamicId(langParser.SlotSetByDynamicIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#sqBracketIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqBracketIndex(langParser.SqBracketIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expression4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression4(langParser.Expression4Context ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(langParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(langParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(langParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(langParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(langParser.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#objectLiteralSlot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteralSlot(langParser.ObjectLiteralSlotContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(langParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApply(langParser.ApplyContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#functionLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionLiteral(langParser.FunctionLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#nativeObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeObject(langParser.NativeObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#self}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf(langParser.SelfContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#groupExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupExpression(langParser.GroupExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#newInstance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewInstance(langParser.NewInstanceContext ctx);
}