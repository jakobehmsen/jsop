/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author jakob
 */
public class GlobalCompileContext implements CompileContext {
    @Override
    public Emitter emitVariableDeclaration(boolean asExpression, String name, Emitter emitterExpression) {
        return new Emitter() {
            @Override
            public void emit(List<Instruction> instructions) {
                instructions.add(Instruction.Set.pushGlobal);

                if(emitterExpression != null) {
                    emitterExpression.emit(instructions);
                } else {
                    instructions.add(Instruction.Set.pushUndefined);
                }

                if(asExpression) {
                    instructions.add(Instruction.Set.dup2);
                }

                instructions.add(Instruction.Set.setPropertyValue(name));
            }
        };
    };

    @Override
    public Emitter emitVariableAccess(boolean asExpression, String name) {
        return new Emitter() {
            @Override
            public void emit(List<Instruction> instructions) {
                if(asExpression) {
                    instructions.add(Instruction.Set.pushGlobal);
                    instructions.add(Instruction.Set.getPropertyValue(name));
                }
            }
        };
    };

    @Override
    public Emitter emitVariableAssignment(boolean asExpression, String name, Emitter emitterExpression) {
        return new Emitter() {
            @Override
            public void emit(List<Instruction> instructions) {
                instructions.add(Instruction.Set.pushGlobal);

                emitterExpression.emit(instructions);

                if(asExpression) {
                    instructions.add(Instruction.Set.dup2);
                }

                instructions.add(Instruction.Set.setPropertyValue(name));
            }
        };
    }

    @Override
    public Emitter emitReturn(Supplier<Emitter> returnEmitterSupplier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Emitter emitVariableIncrement(String name, boolean asExpression) {
        return emitVariableChange(name, asExpression, Instruction.Set.add);
    }

    @Override
    public Emitter emitVariableDecrement(String name, boolean asExpression) {
        return emitVariableChange(name, asExpression, Instruction.Set.sub);
    }
    
    private Emitter emitVariableChange(String name, boolean asExpression, Instruction instr) {
        return Emitter.Factory.propertyChangePostfix(Emitter.Factory.global, name, asExpression, instr);
    }
}
