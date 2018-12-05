/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author jakob
 */
public class BlockCompileContext implements CompileContext {
    private HashSet<String> locals = new HashSet<>();
    private Hashtable<String, Integer> declaredVariableToOrdinalMap = new Hashtable<>();
    private boolean hasReturn;
    
    public BlockCompileContext(String[] parameterNames) {
        for(String name: parameterNames) {
            int ordinal = declaredVariableToOrdinalMap.size() + 1;
            declaredVariableToOrdinalMap.put(name, ordinal);
        }
    }
    
    @Override
    public Emitter emitVariableDeclaration(boolean asExpression, String name, Emitter emitterExpression) {
        Integer ordinalOrNull = declaredVariableToOrdinalMap.get(name);
        int ordinal;
        if(ordinalOrNull == null) {
            ordinal = declaredVariableToOrdinalMap.size() + 1;
            declaredVariableToOrdinalMap.put(name, ordinal);
            locals.add(name);
        } else {
            ordinal = ordinalOrNull;
        }

        return new Emitter() {
            @Override
            public void emit(List<Instruction> instructions) {
                if(emitterExpression != null) {
                    emitterExpression.emit(instructions);
                }

                if(asExpression) {
                    instructions.add(Instruction.Set.dup);
                }

                instructions.add(Instruction.Set.store(ordinal));
            }
        };
    }

    @Override
    public Emitter emitVariableAccess(boolean asExpression, String name) {
        Integer ordinalOrNull = declaredVariableToOrdinalMap.get(name);

        if(ordinalOrNull != null) {
            return new Emitter() {
                @Override
                public void emit(List<Instruction> instructions) {
                    instructions.add(Instruction.Set.load(ordinalOrNull));
                }
            };
        } else {
            return new GlobalCompileContext().emitVariableAccess(asExpression, name);
        }
    }

    @Override
    public Emitter emitVariableAssignment(boolean asExpression, String name, Emitter emitterExpression) {
        Integer ordinalOrNull = declaredVariableToOrdinalMap.get(name);

        if(ordinalOrNull != null) {
            return new Emitter() {
                @Override
                public void emit(List<Instruction> instructions) {
                    if(emitterExpression != null) {
                        emitterExpression.emit(instructions);
                    }

                    if(asExpression) {
                        instructions.add(Instruction.Set.dup);
                    }

                    instructions.add(Instruction.Set.store(ordinalOrNull));
                }
            };
        } else {
            return new GlobalCompileContext().emitVariableAssignment(asExpression, name, emitterExpression);
        }
    }

    @Override
    public Emitter emitReturn(Supplier<Emitter> returnEmitterSupplier) {
        hasReturn = true;
        return returnEmitterSupplier.get();
    }
    
    public boolean hasReturn() {
        return hasReturn;
    }
    
    public int getLocalCount() {
        return locals.size();
    }

    @Override
    public Emitter emitVariableIncrement(String name, boolean asExpression) {
        Integer ordinalOrNull = declaredVariableToOrdinalMap.get(name);

        if(ordinalOrNull != null) {
            return emitVariableChange(ordinalOrNull, asExpression, Instruction.Set.add);
        } else {
            return new GlobalCompileContext().emitVariableIncrement(name, asExpression);
        }
    }

    @Override
    public Emitter emitVariableDecrement(String name, boolean asExpression) {
        Integer ordinalOrNull = declaredVariableToOrdinalMap.get(name);

        if(ordinalOrNull != null) {
            return emitVariableChange(ordinalOrNull, asExpression, Instruction.Set.sub);
        } else {
            return new GlobalCompileContext().emitVariableDecrement(name, asExpression);
        }
    }
    
    private Emitter emitVariableChange(int ordinal, boolean asExpression, Instruction instr) {
        return new Emitter() {
            @Override
            public void emit(List<Instruction> instructions) {
                instructions.add(Instruction.Set.load(ordinal));
                if(asExpression) {
                    instructions.add(Instruction.Set.dup);
                }
                instructions.add(Instruction.Set.pushNumber(1));
                instructions.add(instr);
                instructions.add(Instruction.Set.store(ordinal));
            }
        };
    }
}
