/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.company.jsop.objectstore.NativeFunctionObjectSession;
import com.company.jsop.objectstore.NativeFunctions;

/**
 *
 * @author jakob
 */
public interface Expression {
    Emitter compile(CompileContext compileContext, boolean asExpression);
    default boolean hasReturn() {
        return false;
    }
    
    public static class Factory {
        public static Expression self = new Expression() {
            @Override
            public Emitter compile(CompileContext compileContext, boolean asExpression) {
                return new Emitter() {
                    @Override
                    public void emit(List<Instruction> instructions) {
                        instructions.add(Instruction.Set.load(0));
                    }
                };
            }
        };
        
        public static Expression global = new Expression() {
            @Override
            public Emitter compile(CompileContext compileContext, boolean asExpression) {
                return Emitter.Factory.global;
            }
        };
        
        public static Expression variableDeclaration(String name, Expression initialValueExprOrNull) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter emitterExpression = initialValueExprOrNull.compile(compileContext, true);

                    return compileContext.emitVariableDeclaration(asExpression, name, emitterExpression);
                }
            };
        }

        public static Expression variableAccess(String name) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    return compileContext.emitVariableAccess(asExpression, name);
                }
            };
        }
        
        public static Expression assignment(String name, Expression valueExpr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter emitterExpression = valueExpr.compile(compileContext, true);

                    return compileContext.emitVariableAssignment(asExpression, name, emitterExpression);
                }
            };
        }

        public static Expression variableIncrement(String name) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    return compileContext.emitVariableIncrement(name, asExpression);
                }
            };
        }

        static Expression variableDecrement(String name) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    return compileContext.emitVariableDecrement(name, asExpression);
                }
            };
        }
        
        public static Expression ret(Expression valueExpr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    if(asExpression) {
                        throw new IllegalArgumentException("A return statement cannot be an expression.");
                    }
                    
                    return compileContext.emitReturn(() -> {
                        Emitter valueEmitter = valueExpr.compile(compileContext, true);

                        return new Emitter() {
                            @Override
                            public void emit(List<Instruction> instructions) {
                                valueEmitter.emit(instructions);
                                instructions.add(Instruction.Set.ret);
                            }
                        };
                    });
                }

                @Override
                public boolean hasReturn() {
                    return true;
                }
            };
        }
        
        public static Expression binaryOperation(Expression lhs, Expression rhs, Instruction instr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter lhsEmitter = lhs.compile(compileContext, true);
                    Emitter rhsEmitter = rhs.compile(compileContext, true);

                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            lhsEmitter.emit(instructions);
                            rhsEmitter.emit(instructions);
                            instructions.add(instr);

                            if(!asExpression) {
                                instructions.add(Instruction.Set.pop);
                            }
                        }
                    };
                }
            };
        }

        public static Expression string(String str) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            if(asExpression) {
                                instructions.add(Instruction.Set.pushString(str));
                            }
                        }
                    };
                }
            };
        }

        public static Expression number(double d) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            if(asExpression) {
                                instructions.add(Instruction.Set.pushNumber(d));
                            }
                        }
                    };
                }
            };
        }

        public static Expression bool(boolean b) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            instructions.add(Instruction.Set.pushBoolean(b));
                        }
                    };
                }
            };
        }

        public static Expression function(String[] parameterNames, String src) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            if(asExpression) {
                                instructions.add(Instruction.Set.pushCustomFunction("js", src, parameterNames));
                            }
                        }
                    };
                }
            };
        }

        public static Expression array(List<Expression> itemExprs) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    List<Emitter> itemEmitters = itemExprs.stream()
                            .map(x -> x.compile(compileContext, true))
                            .collect(Collectors.toList());

                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            instructions.add(Instruction.Set.pushNativeFunction("Array"));
                            instructions.add(Instruction.Set.dup);
                            instructions.add(Instruction.Set.apply(0));

                            for(int i = 0; i < itemExprs.size(); i++) {
                                instructions.add(Instruction.Set.dup);
                                itemEmitters.get(i).emit(instructions);
                                instructions.add(Instruction.Set.setPropertyValue(i));
                            }

                            if(!asExpression) {
                                instructions.add(Instruction.Set.pop);
                            }
                        }
                    };
                }
            };
        }

        public static Expression ifStatement(Expression conditionResultExpr, Expression trueBlockExpr, Expression falseBlockExpr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter conditionResultEmitter = conditionResultExpr.compile(compileContext, true);
                    Emitter trueBlockEmitter = trueBlockExpr.compile(compileContext, true);
                    Emitter falseBlockEmitter = falseBlockExpr.compile(compileContext, true);

                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            conditionResultEmitter.emit(instructions);
                            instructions.add(null); // Reserve room for jump-if-false instruction
                            int jumpIfFalseInstructionIndex = instructions.size() - 1;
                            trueBlockEmitter.emit(instructions);
                            instructions.add(null); // Reserve room for jump instruction
                            int jumpInstructionIndex = instructions.size() - 1;
                            int falseBlockStartIndex = instructions.size();
                            falseBlockEmitter.emit(instructions);
                            int falseBlockEndExclIndex = instructions.size();

                            instructions.set(jumpIfFalseInstructionIndex, Instruction.Set.jumpIfFalsy(falseBlockStartIndex));
                            instructions.set(jumpInstructionIndex, Instruction.Set.jump(falseBlockEndExclIndex));

                            if(asExpression) {
                                instructions.add(Instruction.Set.pushUndefined);
                            }
                        }
                    };
                }

                @Override
                public boolean hasReturn() {
                    return trueBlockExpr.hasReturn() && falseBlockExpr.hasReturn();
                }
            };
        }

        public static Expression forStatement(Expression initExpr, Expression conditionExpr, Expression updateExpr, Expression bodyExpr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter initEmitter = initExpr.compile(compileContext, false);
                    Emitter conditionEmitter = conditionExpr.compile(compileContext, true);
                    Emitter updateEmitter = updateExpr.compile(compileContext, false);
                    Emitter bodyEmitter = bodyExpr.compile(compileContext, false);

                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            initEmitter.emit(instructions);
                            int bodyStartIndex = instructions.size();
                            conditionEmitter.emit(instructions);
                            instructions.add(null); // Reserve room for implicit break instruction
                            int breakInstructionIndex = instructions.size() - 1;
                            bodyEmitter.emit(instructions);
                            updateEmitter.emit(instructions);
                            instructions.add(Instruction.Set.jump(bodyStartIndex)); // Reserve room for loop instruction
                            int forLoopEndExclIndex = instructions.size();
                            instructions.set(breakInstructionIndex, Instruction.Set.jumpIfFalsy(forLoopEndExclIndex));

                            if(asExpression) {
                                instructions.add(Instruction.Set.pushUndefined);
                            }
                        }
                    };
                }
            };
        }
        
        public static Expression object(List<ObjectProperty> properties) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    List<Emitter> propertyAssignmentEmitters = properties.stream()
                            .map(x -> propertyAssignment(x).compile(compileContext, true))
                            .collect(Collectors.toList());

                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            instructions.add(Instruction.Set.pushNativeFunction("Object"));
                            instructions.add(Instruction.Set.dup);
                            instructions.add(Instruction.Set.apply(0));

                            propertyAssignmentEmitters.forEach(x -> x.emit(instructions));

                            if(!asExpression) {
                                instructions.add(Instruction.Set.pop);
                            }
                        }
                    };
                }
            };
        }
        
        private static Expression propertyAssignment(ObjectProperty property) {
            return property.accept(new ObjectPropertyVisitor<Expression>() {
                @Override
                public Expression visitProperty(String name, Expression valueExpr) {
                    return new Expression() {
                        @Override
                        public Emitter compile(CompileContext compileContext, boolean asExpression) {
                            Emitter valueEmitter = valueExpr.compile(compileContext, true);

                            return new Emitter() {
                                @Override
                                public void emit(List<Instruction> instructions) {
                                    instructions.add(Instruction.Set.dup);

                                    valueEmitter.emit(instructions);

                                    instructions.add(Instruction.Set.setPropertyValue(name));
                                }
                            };
                        }
                    };
                }
            });
        }
        
        public static interface ObjectProperty {
            <T> T accept(ObjectPropertyVisitor<T> visitor);
        }
        
        public static interface ObjectPropertyVisitor<T> {
            T visitProperty(String name, Expression valueExpr);
        }

        public static Expression apply(Expression targetObjExpr, List<Expression> argumentExprs) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter currentObjEmitter = targetObjExpr.compile(compileContext, true);
                    List<Emitter> argumentEmitters = argumentExprs.stream()
                            .map(x -> x.compile(compileContext, true))
                            .collect(Collectors.toList());

                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            currentObjEmitter.emit(instructions);
                            argumentEmitters.forEach(x -> x.emit(instructions));
                            instructions.add(Instruction.Set.apply(argumentExprs.size()));
                        }
                    };
                }
            };
        }

        public static Expression newInstance(Expression constructorExpr, List<Expression> argumentExprs) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter constructorEmitter = constructorExpr.compile(compileContext, true);
                    List<Emitter> argumentEmitters = argumentExprs.stream()
                            .map(x -> x.compile(compileContext, true))
                            .collect(Collectors.toList());

                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            instructions.add(Instruction.Set.pushGlobal);
                            instructions.add(Instruction.Set.pushNativeFunction("objectCreate"));
                            constructorEmitter.emit(instructions);
                            instructions.add(Instruction.Set.dup3);
                            instructions.add(Instruction.Set.getPropertyValue("prototype"));
                            instructions.add(Instruction.Set.apply(1));
                            instructions.add(Instruction.Set.dup);
                            instructions.add(Instruction.Set.swap2);
                            
                            argumentEmitters.forEach(x -> x.emit(instructions));
                            instructions.add(Instruction.Set.apply(argumentExprs.size()));
                            instructions.add(Instruction.Set.pop);
                        }
                    };
                }
            };
        }
        
        public static Expression getPropertyValue(Expression targetExpr, String name) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    return new Emitter() {
                        Emitter currentObjEmitter = targetExpr.compile(compileContext, true);

                        @Override
                        public void emit(List<Instruction> instructions) {
                            currentObjEmitter.emit(instructions);

                            instructions.add(Instruction.Set.getPropertyValue(name));
                        }
                    };
                }
            };
        }

        // Also known as computed member access (https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Operator_Precedence)
        public static Expression getPropertyValueDynamic(Expression targetObjExpr, Expression slotToReadObjExpr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter currentObjEmitter = targetObjExpr.compile(compileContext, true);
                    Emitter slotToReadObjEmitter = slotToReadObjExpr.compile(compileContext, true);

                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            currentObjEmitter.emit(instructions);

                            slotToReadObjEmitter.emit(instructions);
                            instructions.add(Instruction.Set.getPropertyValueDynamic);
                        }
                    };
                }
            };
        }

        public static Expression setPropertyValue(Expression targetExpr, String name, Expression valueExpr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter currentObjEmitter = targetExpr.compile(compileContext, true);
                    Emitter valueEmitter = valueExpr.compile(compileContext, true);

                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            currentObjEmitter.emit(instructions);
                            valueEmitter.emit(instructions);

                            if(asExpression) {
                                instructions.add(Instruction.Set.dup2);
                            }

                            instructions.add(Instruction.Set.setPropertyValue(name));
                        }
                    };
                };
            };
        }

        public static Expression incrementPropertyValue(Expression targetObjExpr, String name) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter targetObjEmitter = targetObjExpr.compile(compileContext, true);
                    return Emitter.Factory.propertyChangePostfix(targetObjEmitter, name, asExpression, Instruction.Set.add);
                }
            };
        }

        public static Expression decrementPropertyValue(Expression targetObjExpr, String name) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter targetObjEmitter = targetObjExpr.compile(compileContext, true);
                    return Emitter.Factory.propertyChangePostfix(targetObjEmitter, name, asExpression, Instruction.Set.sub);
                }
            };
        }
        
        public static Expression setPropertyValueDynamic(Expression targetExpr, Expression nameExpr, Expression valueExpr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter currentObjEmitter = targetExpr.compile(compileContext, true);
                    Emitter valueEmitter = valueExpr.compile(compileContext, true);
                    Emitter slotToWriteObjEmitter = nameExpr.compile(compileContext, true);

                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            currentObjEmitter.emit(instructions);
                            valueEmitter.emit(instructions);

                            if(asExpression) {
                                instructions.add(Instruction.Set.dup2);
                            }
                            
                            slotToWriteObjEmitter.emit(instructions);

                            instructions.add(Instruction.Set.setPropertyValueDynamic);
                        }
                    };
                };
            };
        }

        public static Expression incrementPropertyValueDynamic(Expression targetObjExpr, Expression nameExpr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter targetObjEmitter = targetObjExpr.compile(compileContext, true);
                    Emitter nameEmitter = nameExpr.compile(compileContext, true);
                    return Emitter.Factory.propertyChangeDynamicPostfix(targetObjEmitter, nameEmitter, asExpression, Instruction.Set.add);
                }
            };
        }

        public static Expression decrementPropertyValueDynamic(Expression targetObjExpr, Expression nameExpr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter targetObjEmitter = targetObjExpr.compile(compileContext, true);
                    Emitter nameEmitter = nameExpr.compile(compileContext, true);
                    return Emitter.Factory.propertyChangeDynamicPostfix(targetObjEmitter, nameEmitter, asExpression, Instruction.Set.sub);
                }
            };
        }

        public static Expression changePropertyValueDynamic(Expression targetObjExpr, Expression nameExpr, Expression valueExpr, Instruction instr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter targetObjEmitter = targetObjExpr.compile(compileContext, true);
                    Emitter nameEmitter = nameExpr.compile(compileContext, true);
                    Emitter valueEmitter = valueExpr.compile(compileContext, true);
                    return Emitter.Factory.propertyChangeDynamic(targetObjEmitter, nameEmitter, asExpression, valueEmitter, instr);
                }
            };
        }

        public static Expression changePropertyValue(Expression targetObjExpr, String name, Expression valueExpr, Instruction instr) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    Emitter targetObjEmitter = targetObjExpr.compile(compileContext, true);
                    Emitter valueEmitter = valueExpr.compile(compileContext, true);
                    return Emitter.Factory.propertyChange(targetObjEmitter, name, asExpression, valueEmitter, instr);
                }
            };
        }

        public static Expression block(List<Expression> elements) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    if(asExpression) {
                        if(elements.size() > 0) {
                            ArrayList<Emitter> emitterElements = new ArrayList<>();

                            for(int i = 0; i < elements.size() - 1; i++) {
                                emitterElements.add(elements.get(i).compile(compileContext, false));
                            }

                            emitterElements.add(elements.get(elements.size() - 1).compile(compileContext, true));

                            return new Emitter() {
                                @Override
                                public void emit(List<Instruction> instructions) {
                                    emitterElements.forEach(e -> e.emit(instructions));
                                }
                            };
                        } else {
                            return new Emitter() {
                                @Override
                                public void emit(List<Instruction> instructions) {
                                    instructions.add(Instruction.Set.pushUndefined);
                                }
                            };
                        }
                    } else {
                        List<Emitter> emitterElements = elements.stream().map(e -> e.compile(compileContext, asExpression)).collect(Collectors.toList());

                        return new Emitter() {
                            @Override
                            public void emit(List<Instruction> instructions) {
                                emitterElements.forEach(e -> e.emit(instructions));
                            }
                        };
                    }
                }

                @Override
                public boolean hasReturn() {
                    return elements.size() > 0 && elements.get(elements.size() - 1).hasReturn();
                }
            };
        }

        public static Expression nativeObject(String name) {
            return new Expression() {
                @Override
                public Emitter compile(CompileContext compileContext, boolean asExpression) {
                    return new Emitter() {
                        @Override
                        public void emit(List<Instruction> instructions) {
                            instructions.add(Instruction.Set.pushNativeFunction(name));
                        }
                    };
                }
            };
        }
    }
}
