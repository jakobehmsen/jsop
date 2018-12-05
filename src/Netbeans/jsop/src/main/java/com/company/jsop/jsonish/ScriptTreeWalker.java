/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

import com.company.jsop.antlr.langBaseVisitor;
import com.company.jsop.antlr.langLexer;
import com.company.jsop.antlr.langParser;
import java.util.concurrent.Executors;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

/**
 *
 * @author jakob
 */
public class ScriptTreeWalker implements Script {
    private final JSONObjectFactory objectFactory;
    private final JSONObjectBroker broker;
    private ParserRuleContext ctx;

    public ScriptTreeWalker(JSONObjectFactory objectFactory, JSONObjectBroker broker, ParserRuleContext ctx, BlockEvaluator blockEvaluator) {
        this.objectFactory = objectFactory;
        this.broker = broker;
        this.ctx = ctx;
        this.blockEvaluator = blockEvaluator;
    }

    @Override
    public Object evaluate(Object scope, Object self) {
        return evaluate(scope, self, ctx);
    }
    
    public interface Block {
        int expressionCount();
        Object evaluateExpression(int i);
    }
    
    public interface BlockEvaluator {
        Object evaluate(JSONObjectBroker broker, Block block);
        void returnValue(Object obj);
    }
    
    private BlockEvaluator blockEvaluator;
    
    private Object evaluate(Object scope, Object self, ParserRuleContext ctx) {
        return ctx.accept(new langBaseVisitor<Object>() {
            @Override
            public Object visitBlock(langParser.BlockContext blockContext) {
                return blockEvaluator.evaluate(broker, new Block() {
                    @Override
                    public int expressionCount() {
                        return blockContext.programElement().size();
                    }

                    @Override
                    public Object evaluateExpression(int i) {
                        return evaluate(scope, self, blockContext.programElement(i));
                    }
                });
            }

            @Override
            public Object visitProgramElement(langParser.ProgramElementContext ctx) {
                ParserRuleContext elementCtx = ctx.expression() != null ? 
                        ctx.expression() :
                        ctx.statement();
                
                return evaluate(scope, self, elementCtx);
            }

            @Override
            public Object visitVariableDeclaration(langParser.VariableDeclarationContext variableDeclarationContext) {
                String name = variableDeclarationContext.ID().getText();
                Object value = variableDeclarationContext.expression() != null
                        ? evaluate(scope, self, variableDeclarationContext.expression())
                        : broker.undefined();
                broker.declareVariable(scope, name, value);
                
                return value;
            }

            @Override
            public Object visitAssignment(langParser.AssignmentContext assignmentContext) {
                String id = assignmentContext.ID().getText();
                Object value = evaluate(scope, self, assignmentContext.expression());
                boolean isDeclared = broker.isDeclared(scope, id);
                
                if(isDeclared) {
                    broker.setVariable(scope, id, value);
                } else {
                    broker.set(self, id, value);
                }
                
                return value;
            }

            @Override
            public Object visitReturnStatement(langParser.ReturnStatementContext returnStatementContext) {
                Object value = evaluate(scope, self, returnStatementContext.expression1());
                
                blockEvaluator.returnValue(value);
                
                return value;
            }

            @Override
            public Object visitForStatement(langParser.ForStatementContext forStatementCtx) {
                evaluate(scope, self, forStatementCtx.init);
                
                Object conditionResult;
                
                do {
                    evaluate(scope, self, forStatementCtx.body);
                    evaluate(scope, self, forStatementCtx.update);
                    
                    conditionResult = evaluate(scope, self, forStatementCtx.condition);
                } while(!broker.isFalse(conditionResult));
                
                return broker.undefined();
            }

            @Override
            public Object visitIfStatement(langParser.IfStatementContext ifStatementContext) {
                Object conditionResult = evaluate(scope, self, ifStatementContext.condition);
                
                if(!broker.isFalse(conditionResult)) {
                    evaluate(scope, self, ifStatementContext.trueBlock.content);
                } else {
                    if(ifStatementContext.falseBlock != null) {
                        evaluate(scope, self, ifStatementContext.falseBlock.content);
                    }
                }
                
                return broker.undefined();
            }

            @Override
            public Object visitExpressionComparison(langParser.ExpressionComparisonContext expressionComparisonContext) {
                Object obj = evaluate(scope, self, expressionComparisonContext.expression1());
                
                for(int i = 0; i < expressionComparisonContext.binaryComparisonOperand().size(); i++) {
                    Object lhs = obj;
                    Object rhs = evaluate(scope, self, expressionComparisonContext.binaryComparisonOperand(i).expression1());
                    
                    switch(expressionComparisonContext.binaryComparisonOperand(i).op.getType()) {
                        case langLexer.OP_LT:
                            obj = broker.lessThan(lhs, rhs);
                            break;
                        case langLexer.OP_LTE:
                            obj = broker.lessThanOrEqual(lhs, rhs);
                            break;
                        case langLexer.OP_GT:
                            obj = broker.greaterThan(lhs, rhs);
                            break;
                        case langLexer.OP_GTE:
                            obj = broker.greaterThanOrEqual(lhs, rhs);
                            break;
                        case langLexer.OP_IN:
                            obj = broker.isIn(lhs, rhs);
                            break;
                        case langLexer.OP_INO:
                            obj = broker.isInstanceof(lhs, rhs);
                            break;
                    }
                }
                
                return obj;
            }
            
            @Override
            public Object visitExpression3(langParser.Expression3Context expression3Context) {
                langParser.Expression4Context expression4Context = expression3Context.expression4();
                Object prevObj = self;
                Object obj = evaluate(scope, self, expression4Context);
                
                for(int i = 0; i < expression3Context.slotGetOrApply().size(); i++) {
                    langParser.SlotGetOrApplyContext slotGetOrApplyContext = expression3Context.slotGetOrApply(i);
                    
                    Object currentObj = obj;
                    Object applyThis = prevObj;
                    prevObj = obj;
                    obj = slotGetOrApplyContext.getChild(0).accept(new langBaseVisitor<Object>() {
                        @Override
                        public Object visitSlotGet(langParser.SlotGetContext slotGetContext) {
                            if(slotGetContext.slotGetByStaticId() != null) {
                                String slotToRead = slotGetContext.slotGetByStaticId().ID().getText();
                                return broker.get(currentObj, slotToRead);
                            } else {
                                langParser.ExpressionContext expressionContext = 
                                        slotGetContext.slotGetByDynamicId().sqBracketIndex().expression();
                                Object slotToReadObj = evaluate(scope, self, expressionContext);
                                return broker.getDynamic(currentObj, slotToReadObj);
                            }
                        }

                        @Override
                        public Object visitApply(langParser.ApplyContext aplyContext) {
                            Object[] arguments = new Object[aplyContext.expression().size()];
                            for(int i = 0; i < arguments.length; i++) {
                                arguments[i] = evaluate(scope, self, aplyContext.expression(i));
                            }
                            Object applicable = currentObj;
                            //return broker.apply(applicable, applyThis, arguments);
                            return null;
                        }
                    });
                }
                
                if(expression3Context.slotSet() != null) {
                    if(expression3Context.slotSet().slotSetByStaticId() != null) {
                        String slotToSet = expression3Context.slotSet().slotSetByStaticId().ID().getText();
                        langParser.ExpressionContext valueCtx = expression3Context.slotSet().slotSetByStaticId().expression();
                        Object value = evaluate(scope, self, valueCtx);
                        broker.set(obj, slotToSet, value);
                        obj = value;
                    } else {
                        langParser.ExpressionContext expressionContext = 
                                expression3Context.slotSet().slotSetByDynamicId().sqBracketIndex().expression();
                        langParser.ExpressionContext valueCtx = expression3Context.slotSet().slotSetByDynamicId().expression();
                        Object value = evaluate(scope, self, valueCtx);
                        Object slotToWriteObj = evaluate(scope, obj, expressionContext);
                        broker.setDynamic(obj, slotToWriteObj, value);
                        obj = value;
                    }
                }
                
                return obj;
            }

            @Override
            public Object visitExpression1(langParser.Expression1Context expression1Context) {
                Object obj = evaluate(scope, self, expression1Context.expression2());
                
                for(int i = 0; i < expression1Context.binaryAdditionOperand().size(); i++) {
                    Object lhs = obj;
                    Object rhs = evaluate(scope, self, expression1Context.binaryAdditionOperand(i).expression2());
                    
                    switch(expression1Context.binaryAdditionOperand(i).binaryAdditionOperator().op.getType()) {
                        case langLexer.OP_PLUS:
                            obj = broker.add(lhs, rhs);
                            break;
                        case langLexer.OP_MINUS:
                            obj = broker.subtract(lhs, rhs);
                            break;
                    }
                }
                
                return obj;
            }

            @Override
            public Object visitExpression2(langParser.Expression2Context expression2Context) {
                Object obj = evaluate(scope, self, expression2Context.expression3());
                
                for(int i = 0; i < expression2Context.binaryMultOperand().size(); i++) {
                    Object lhs = obj;
                    Object rhs = evaluate(scope, self, expression2Context.binaryMultOperand(i).expression3());
                    
                    switch(expression2Context.binaryMultOperand(i).binaryMultOperator().op.getType()) {
                        case langLexer.OP_MULT:
                            obj = broker.mult(lhs, rhs);
                            break;
                        case langLexer.OP_DIV:
                            obj = broker.div(lhs, rhs);
                            break;
                        case langLexer.OP_REM:
                            obj = broker.rem(lhs, rhs);
                            break;
                    }
                }
                
                return obj;
            }

            @Override
            public Object visitIdentifier(langParser.IdentifierContext identifierContext) {
                String id = identifierContext.ID().getText();
                
                boolean isDeclared = broker.isDeclared(scope, id);
                
                if(isDeclared) {
                    return broker.getVariable(scope, id);
                } else {
                    return broker.get(self, id);
                }
            }

            @Override
            public Object visitString(langParser.StringContext stringContext) {
                return objectFactory.newString(parseString(stringContext));
            }
            
            private String parseString(langParser.StringContext stringContext) {
                return stringContext.getText()
                    .substring(1, stringContext.getText().length() - 1)
                    .replace("\\r", "\r")
                    .replace("\\n", "\n");
            }

            @Override
            public Object visitNumber(langParser.NumberContext numberContext) {
                String numberText = numberContext.NUMBER().getText();
                double d = Double.parseDouble(numberText);
                
                return objectFactory.newNumber(d);
            }

            @Override
            public Object visitObjectLiteral(langParser.ObjectLiteralContext objectLiteralContext) {
                Object map = objectFactory.newMap();
                
                for(int i = 0; i < objectLiteralContext.objectLiteralSlot().size(); i++) {
                    langParser.ObjectLiteralSlotContext objectLiteralSlotContext = 
                            objectLiteralContext.objectLiteralSlot(i);
                    String slot = objectLiteralSlotContext.ID().getText();
                    Object value = evaluate(scope, self, objectLiteralSlotContext.expression());
                    
                    broker.set(map, slot, value);
                }
                
                return map;
            }

            @Override
            public Object visitArrayLiteral(langParser.ArrayLiteralContext arrayLiteralContext) {
                Object array = objectFactory.newArray();
                
                for(int i = 0; i < arrayLiteralContext.expression().size(); i++) {
                    Object item = evaluate(scope, self, arrayLiteralContext.expression(i));
                    broker.setByOrdinal(array, i, item);
                }
                
                return array;
            }

            @Override
            public Object visitFunctionLiteral(langParser.FunctionLiteralContext functionLiteralContext) {
                String[] parameterNames = functionLiteralContext.ID().stream()
                        .map(x -> x.getText())
                        .toArray(s -> new String[s]);
                String src = functionLiteralContext.body.getStart().getInputStream()
                        .getText(new Interval(functionLiteralContext.body.getStart().getStartIndex(), functionLiteralContext.body.getStop().getStopIndex()));
                return objectFactory.newFunction("js", src, parameterNames);
            }

            @Override
            public Object visitNativeObject(langParser.NativeObjectContext nativeObjectContext) {
                String name = nativeObjectContext.ID().getText();
                return broker.getNativeObject(name);
            }

            @Override
            public Object visitSelf(langParser.SelfContext selfContext) {
                return self;
            }

            @Override
            public Object visitGroupExpression(langParser.GroupExpressionContext embeddedExpressionContext) {
                return evaluate(scope, self, embeddedExpressionContext.expression());
            }
        });
    }
}
