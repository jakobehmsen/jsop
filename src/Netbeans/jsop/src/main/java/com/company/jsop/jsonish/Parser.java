/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

import com.company.jsop.antlr.langBaseVisitor;
import com.company.jsop.antlr.langLexer;
import com.company.jsop.antlr.langParser;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.company.jsop.objectstore.ObjectStoreSession;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

/**
 *
 * @author jakob
 */
public class Parser {
    private BiFunction<ObjectStoreSession, ParserRuleContext, Script> scriptFunction;

    public Parser(BiFunction<ObjectStoreSession, ParserRuleContext, Script> scriptFunction) {
        this.scriptFunction = scriptFunction;
    }
    
    public Script parse(ObjectStoreSession session, String src) {
        langLexer lexer = new langLexer(CharStreams.fromString(src));
        langParser parser = new langParser(new CommonTokenStream(lexer));
        
        langParser.BlockContext expressionsContext = parser.block();
        
        return scriptFunction.apply(session, expressionsContext);
    }
    
    public Expression parse2(String src) {
        langLexer lexer = new langLexer(CharStreams.fromString(src));
        langParser parser = new langParser(new CommonTokenStream(lexer));
        
        langParser.BlockContext expressionsContext = parser.block();
        
        return parse(expressionsContext);
    }

    private Expression parse(ParserRuleContext parserRuleContext) {
        return parserRuleContext.accept(new langBaseVisitor<Expression>() {
            @Override
            public Expression visitBlock(langParser.BlockContext blockContext) {
                List<Expression> elements = blockContext.programElement().stream()
                        .map(x -> parse(x))
                        .collect(Collectors.toList());
                
                return Expression.Factory.block(elements);
            }

            @Override
            public Expression visitProgramElement(langParser.ProgramElementContext ctx) {
                ParserRuleContext elementCtx = ctx.expression() != null ? 
                        ctx.expression() :
                        ctx.statement();
                
                return parse(elementCtx);
            }

            @Override
            public Expression visitStatement(langParser.StatementContext ctx) {
                return parse((ParserRuleContext)ctx.getChild(0));
            }

            @Override
            public Expression visitVariableDeclaration(langParser.VariableDeclarationContext variableDeclarationContext) {
                String name = variableDeclarationContext.ID().getText();
                Expression initialValueExprOrNull = variableDeclarationContext.expression() != null 
                        ? parse(variableDeclarationContext.expression())
                        : null;
                
                return Expression.Factory.variableDeclaration(name, initialValueExprOrNull);
            }

            @Override
            public Expression visitAssignment(langParser.AssignmentContext assignmentContext) {
                String name = assignmentContext.ID().getText();
                Expression valueExpr = parse(assignmentContext.expression());
                
                Instruction shortHandAssignmentInstruction = 
                    shortHandAssignmentInstruction(assignmentContext.assignmentOp().op.getType());
                
                if(shortHandAssignmentInstruction != null) {
                    valueExpr = Expression.Factory.binaryOperation(Expression.Factory.variableAccess(name), valueExpr, shortHandAssignmentInstruction);
                }
                
                return Expression.Factory.assignment(name, valueExpr);
            }
            
            private Instruction shortHandAssignmentInstruction(int type) {
                switch(type) {
                    case langLexer.ASSIGN_PLUS:
                        return Instruction.Set.add;
                    case langLexer.ASSIGN_MINUS:
                        return Instruction.Set.sub;
                    case langLexer.ASSIGN_MULT:
                        return Instruction.Set.mult;
                    case langLexer.ASSIGN_DIV:
                        return Instruction.Set.div;
                    case langLexer.ASSIGN_REM:
                        return Instruction.Set.rem;
                }
                
                return null;
            }

            @Override
            public Expression visitReturnStatement(langParser.ReturnStatementContext returnStatementContext) {
                Expression valueExpr = parse(returnStatementContext.expression1());
                
                return Expression.Factory.ret(valueExpr);
            }

            @Override
            public Expression visitForStatement(langParser.ForStatementContext forStatementCtx) {
                Expression initExpr = parse(forStatementCtx.init);
                Expression conditionExpr = parse(forStatementCtx.condition);
                Expression updateExpr = parse(forStatementCtx.update);
                Parser bodyBlockParser = new Parser(scriptFunction);
                Expression bodyExpr = bodyBlockParser.parse(forStatementCtx.body);
                
                return Expression.Factory.forStatement(initExpr, conditionExpr, updateExpr, bodyExpr);
            }

            @Override
            public Expression visitIfStatement(langParser.IfStatementContext ifStatementContext) {
                Expression conditionResultExpr = parse(ifStatementContext.condition);
                Parser trueBlockParser = new Parser(scriptFunction);
                Expression trueBlockExpr = trueBlockParser.parse(ifStatementContext.trueBlock.content);
                Parser falseBlockParser = new Parser(scriptFunction);
                Expression falseBlockExpr = falseBlockParser.parse(ifStatementContext.falseBlock.content);
                
                return Expression.Factory.ifStatement(conditionResultExpr, trueBlockExpr, falseBlockExpr);
            }

            @Override
            public Expression visitExpressionLogicalOr(langParser.ExpressionLogicalOrContext expressionLogicalOrContext) {
                return binaryChain(expressionLogicalOrContext.expressionLogicalAnd(), Instruction.Set.or);
            }

            @Override
            public Expression visitExpressionLogicalAnd(langParser.ExpressionLogicalAndContext expressionLogicalAndContext) {
                return binaryChain(expressionLogicalAndContext.expressionBitwiseOr(), Instruction.Set.and);
            }

            @Override
            public Expression visitExpressionBitwiseOr(langParser.ExpressionBitwiseOrContext expressionBitwiseOrContext) {
                return binaryChain(expressionBitwiseOrContext.expressionBitwiseXOr(), Instruction.Set.bor);
            }

            @Override
            public Expression visitExpressionBitwiseXOr(langParser.ExpressionBitwiseXOrContext expressionBitwiseXOrContext) {
                return binaryChain(expressionBitwiseXOrContext.expressionBitwiseAnd(), Instruction.Set.bxor);
            }

            @Override
            public Expression visitExpressionBitwiseAnd(langParser.ExpressionBitwiseAndContext expressionBitwiseAndContext) {
                return binaryChain(expressionBitwiseAndContext.expressionEquality(), Instruction.Set.band);
            }

            @Override
            public Expression visitExpressionEquality(langParser.ExpressionEqualityContext expressionEqualityContext) {
                return binaryChain(expressionEqualityContext.expressionComparison(), i -> {
                    switch(expressionEqualityContext.expressionEqualityOp(i).op.getType()) {
                        case langLexer.OP_EQ:
                            return Instruction.Set.eq;
                        case langLexer.OP_INEQ:
                            return Instruction.Set.neq;
                        case langLexer.OP_SEQ:
                            return Instruction.Set.seq;
                        case langLexer.OP_SINEQ:
                            return Instruction.Set.sneq;
                    }
                    
                    return null;
                });
            }
            
            private Expression binaryChain(List<? extends ParserRuleContext> ctxs, Instruction instr) {
                return binaryChain(ctxs, i -> instr);
            }
            
            private Expression binaryChain(List<? extends ParserRuleContext> ctxs, Function<Integer, Instruction> instrFunc) {
                Expression objExpr = parse(ctxs.get(0));
                
                for(int i = 1; i < ctxs.size(); i++) {
                    Expression lhs = objExpr;
                    Expression rhs = parse(ctxs.get(i));
                    Instruction instr = instrFunc.apply(i - 1);
                    objExpr = binaryExpression(lhs, rhs, instr);
                }
                
                return objExpr;
            }

            @Override
            public Expression visitExpressionComparison(langParser.ExpressionComparisonContext expressionComparisonContext) {
                Expression objExpr = parse(expressionComparisonContext.expression1());
                
                for(int i = 0; i < expressionComparisonContext.binaryComparisonOperand().size(); i++) {
                    Expression lhs = objExpr;
                    Expression rhs = parse(expressionComparisonContext.binaryComparisonOperand(i).expression1());
                    
                    switch(expressionComparisonContext.binaryComparisonOperand(i).op.getType()) {
                        case langLexer.OP_GT:
                            objExpr = binaryExpression(lhs, rhs, Instruction.Set.gt);
                            break;
                        case langLexer.OP_GTE:
                            objExpr = binaryExpression(lhs, rhs, Instruction.Set.gte);
                            break;
                        case langLexer.OP_LT:
                            objExpr = binaryExpression(lhs, rhs, Instruction.Set.lt);
                            break;
                        case langLexer.OP_LTE:
                            objExpr = binaryExpression(lhs, rhs, Instruction.Set.lte);
                            break;
                        case langLexer.OP_IN:
                            objExpr = binaryExpression(lhs, rhs, Instruction.Set.in);
                            break;
                        case langLexer.OP_INO:
                            objExpr = binaryExpression(lhs, rhs, Instruction.Set.ino);
                            break;
                    }
                }
                
                return objExpr;
            }

            @Override
            public Expression visitExpression1(langParser.Expression1Context expression1Context) {
                Expression objExpr = parse(expression1Context.expression2());
                
                for(int i = 0; i < expression1Context.binaryAdditionOperand().size(); i++) {
                    Expression lhs = objExpr;
                    Expression rhs = parse(expression1Context.binaryAdditionOperand(i).expression2());
                    
                    switch(expression1Context.binaryAdditionOperand(i).binaryAdditionOperator().op.getType()) {
                        case langLexer.OP_PLUS:
                            objExpr = binaryExpression(lhs, rhs, Instruction.Set.add);
                            break;
                        case langLexer.OP_MINUS:
                            objExpr = binaryExpression(lhs, rhs, Instruction.Set.sub);
                            break;
                    }
                }
                
                return objExpr;
            }

            @Override
            public Expression visitExpression2(langParser.Expression2Context expression2Context) {
                Expression objExpr = parse(expression2Context.expression3());
                
                for(int i = 0; i < expression2Context.binaryMultOperand().size(); i++) {
                    Expression lhs = objExpr;
                    Expression rhs = parse(expression2Context.binaryMultOperand(i).expression3());
                    
                    switch(expression2Context.binaryMultOperand(i).binaryMultOperator().op.getType()) {
                        case langLexer.OP_MULT:
                            objExpr = binaryExpression(lhs, rhs, Instruction.Set.mult);
                            break;
                        case langLexer.OP_DIV:
                            objExpr = binaryExpression(lhs, rhs, Instruction.Set.div);
                            break;
                        case langLexer.OP_REM:
                            objExpr = binaryExpression(lhs, rhs, Instruction.Set.rem);
                            break;
                    }
                }
                
                return objExpr;
            }
            
            private Expression binaryExpression(Expression lhs, Expression rhs, Instruction instr) {
                return Expression.Factory.binaryOperation(lhs, rhs, instr);
            }

            @Override
            public Expression visitExpression3(langParser.Expression3Context expression3Context) {
                Expression objExpr = parse(expression3Context.expression4());
                
                for(int i = 0; i < expression3Context.slotGetOrApply().size(); i++) {
                    langParser.SlotGetOrApplyContext slotGetOrApplyContext = expression3Context.slotGetOrApply(i);
                    langParser.SlotGetOrApplyContext nextSlotGetOrApplyContext = 
                            i + 1 < expression3Context.slotGetOrApply().size()
                            ? expression3Context.slotGetOrApply(i + 1)
                            : null;
                    
                    int index = i;
                    boolean nextIsApply;
                    if(nextSlotGetOrApplyContext != null) {
                        Boolean nextIsApplyObj = nextSlotGetOrApplyContext.accept(new langBaseVisitor<Boolean>() {
                            @Override
                            public Boolean visitApply(langParser.ApplyContext ctx) {
                                return Boolean.TRUE;
                            }
                        });

                        nextIsApply = Objects.equals(nextIsApplyObj, Boolean.TRUE);
                    } else {
                        nextIsApply = false;
                    }
                    
                    Expression currentObjExpr = objExpr;
                    
                    objExpr = slotGetOrApplyContext.getChild(0).accept(new langBaseVisitor<Expression>() {
                        @Override
                        public Expression visitSlotGet(langParser.SlotGetContext slotGetContext) {
                            Expression targetObjExpr = new Expression() {
                                @Override
                                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                                    Emitter currentObjEmitter = currentObjExpr.compile(compileContext, true);

                                    return new Emitter() {
                                        @Override
                                        public void emit(List<Instruction> instructions) {
                                            currentObjEmitter.emit(instructions);
                                            if(nextIsApply) {
                                                instructions.add(Instruction.Set.dup);
                                            }
                                        }
                                    };
                                }
                            };
                                
                            if(slotGetContext.slotGetByStaticId() != null) {
                                String slotToRead = slotGetContext.slotGetByStaticId().ID().getText();
                                
                                if(slotGetContext.OP_PLUS_PLUS() != null) {
                                    return Expression.Factory.incrementPropertyValue(targetObjExpr, slotToRead);
                                } else if(slotGetContext.OP_MINUS_MINUS()!= null) {
                                    return Expression.Factory.decrementPropertyValue(targetObjExpr, slotToRead);
                                }
                                
                                return Expression.Factory.getPropertyValue(targetObjExpr, slotToRead);
                            } else {
                                langParser.ExpressionContext expressionContext = 
                                        slotGetContext.slotGetByDynamicId().sqBracketIndex().expression();
                                Expression slotToReadObjExpr = parse(expressionContext);
                                
                                if(slotGetContext.OP_PLUS_PLUS() != null) {
                                    return Expression.Factory.incrementPropertyValueDynamic(targetObjExpr, slotToReadObjExpr);
                                } else if(slotGetContext.OP_MINUS_MINUS()!= null) {
                                    return Expression.Factory.decrementPropertyValueDynamic(targetObjExpr, slotToReadObjExpr);
                                }
                                
                                return Expression.Factory.getPropertyValueDynamic(targetObjExpr, slotToReadObjExpr);
                            }
                        }

                        @Override
                        public Expression visitApply(langParser.ApplyContext applyContext) {
                            List<Expression> argumentExprs = applyContext.expression().stream()
                                            .map(x -> parse(x))
                                            .collect(Collectors.toList());
                            
                            Expression targetObjExpr = new Expression() {
                                @Override
                                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                                    Emitter currentObjEmitter = currentObjExpr.compile(compileContext, true);

                                    return new Emitter() {
                                        @Override
                                        public void emit(List<Instruction> instructions) {
                                            if(nextIsApply) {
                                                instructions.add(Instruction.Set.pushGlobal);
                                            }
                                                
                                            if(index == 0) {
                                                instructions.add(Instruction.Set.pushGlobal);
                                            }
                                            
                                            currentObjEmitter.emit(instructions);
                                        }
                                    };
                                }
                            };
                            
                            return Expression.Factory.apply(targetObjExpr, argumentExprs);
                        }
                    });
                }
                
                if(expression3Context.slotSet() != null) {
                    Expression currentObjExpr = objExpr;
                    
                    // There are different kinds of operators, that can be used
                    // to set a property value. E.g. += and -=.
                    
                    if(expression3Context.slotSet().slotSetByStaticId() != null) {
                        String slotToSet = expression3Context.slotSet().slotSetByStaticId().ID().getText();
                        langParser.ExpressionContext valueCtx = expression3Context.slotSet().slotSetByStaticId().expression();
                        Expression valueExpr = parse(valueCtx);
                        
                        Instruction shortHandAssignmentInstruction = 
                            shortHandAssignmentInstruction(expression3Context.slotSet().slotSetByStaticId().assignmentOp().op.getType());

                        if(shortHandAssignmentInstruction != null) {
                            objExpr = Expression.Factory.changePropertyValue(currentObjExpr, slotToSet, valueExpr, shortHandAssignmentInstruction);
                        } else {
                            objExpr = Expression.Factory.setPropertyValue(currentObjExpr, slotToSet, valueExpr);
                        }
                    } else {
                        langParser.ExpressionContext expressionContext = 
                                expression3Context.slotSet().slotSetByDynamicId().sqBracketIndex().expression();
                        langParser.ExpressionContext valueCtx = expression3Context.slotSet().slotSetByDynamicId().expression();
                        Expression valueExpr = parse(valueCtx);
                        Expression slotToWriteObjExpr = parse(expressionContext);
                        
                        Instruction shortHandAssignmentInstruction = 
                            shortHandAssignmentInstruction(expression3Context.slotSet().slotSetByDynamicId().assignmentOp().op.getType());
                        
                        if(shortHandAssignmentInstruction != null) {
                            objExpr = Expression.Factory.changePropertyValueDynamic(currentObjExpr, slotToWriteObjExpr, valueExpr, shortHandAssignmentInstruction);
                        } else {
                            objExpr = Expression.Factory.setPropertyValueDynamic(currentObjExpr, slotToWriteObjExpr, valueExpr);
                        }
                    }
                }
                
                return objExpr;
            }

            @Override
            public Expression visitIdentifier(langParser.IdentifierContext identifierContext) {
                String name = identifierContext.ID().getText();
                
                if(identifierContext.OP_PLUS_PLUS() != null) {
                    return Expression.Factory.variableIncrement(name);
                } else if(identifierContext.OP_MINUS_MINUS()!= null) {
                    return Expression.Factory.variableDecrement(name);
                }
                
                return Expression.Factory.variableAccess(name);
            }

            @Override
            public Expression visitString(langParser.StringContext stringContext) {
                String str = parseString(stringContext);
                
                return Expression.Factory.string(str);
            }
            
            private String parseString(langParser.StringContext stringContext) {
                return stringContext.getText()
                    .substring(1, stringContext.getText().length() - 1)
                    .replace("\\r", "\r")
                    .replace("\\n", "\n");
            }

            @Override
            public Expression visitNumber(langParser.NumberContext numberContext) {
                String numberText = numberContext.NUMBER().getText();
                double d = Double.parseDouble(numberText);
                
                return Expression.Factory.number(d);
            }

            @Override
            public Expression visitBool(langParser.BoolContext boolContext) {
                boolean b = boolContext.b.getType() == langLexer.KW_TRUE;
                
                return Expression.Factory.bool(b);
            }

            @Override
            public Expression visitObjectLiteral(langParser.ObjectLiteralContext objectLiteralContext) {
                List objectProperties = objectLiteralContext.objectLiteralSlot().stream()
                        .map(objectLiteralSlotContext -> new Expression.Factory.ObjectProperty() {
                    String name = objectLiteralSlotContext.ID().getText();
                    Expression valueExpr = parse(objectLiteralSlotContext.expression());
                    
                    @Override
                    public <T> T accept(Expression.Factory.ObjectPropertyVisitor<T> visitor) {
                        return visitor.visitProperty(name, valueExpr);
                    }
                }).collect(Collectors.toList());
                
                return Expression.Factory.object(objectProperties);
            }

            @Override
            public Expression visitArrayLiteral(langParser.ArrayLiteralContext arrayLiteralContext) {
                List<Expression> itemExprs = arrayLiteralContext.expression().stream()
                        .map(x -> parse(x))
                        .collect(Collectors.toList());
                
                return Expression.Factory.array(itemExprs);
            }
            
            @Override
            public Expression visitFunctionLiteral(langParser.FunctionLiteralContext functionLiteralContext) {
                String[] parameterNames = functionLiteralContext.ID().stream()
                        .map(x -> x.getText())
                        .toArray(s -> new String[s]);
                String src = functionLiteralContext.body.getStart().getInputStream()
                        .getText(new Interval(functionLiteralContext.body.getStart().getStartIndex(), functionLiteralContext.body.getStop().getStopIndex()));
                
                return Expression.Factory.function(parameterNames, src);
            }

            @Override
            public Expression visitSelf(langParser.SelfContext selfContext) {
                return Expression.Factory.self;
            }

            @Override
            public Expression visitGroupExpression(langParser.GroupExpressionContext embeddedExpressionContext) {
                return parse(embeddedExpressionContext.expression());
            }

            @Override
            public Expression visitNewInstance(langParser.NewInstanceContext newInstanceContext) {
                Expression constructorExpr = parse(newInstanceContext.expression());
                List<Expression> argumentExprs = newInstanceContext.apply().expression().stream()
                                .map(x -> parse(x))
                                .collect(Collectors.toList());

                return Expression.Factory.newInstance(constructorExpr, argumentExprs);
            }

            @Override
            public Expression visitNativeObject(langParser.NativeObjectContext nativeObjectContext) {
                String name = nativeObjectContext.ID().getText();
                return Expression.Factory.nativeObject(name);
            }
        });
    }
}
