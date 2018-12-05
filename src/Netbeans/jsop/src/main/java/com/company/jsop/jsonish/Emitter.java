/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

import java.util.List;

/**
 *
 * @author jakob
 */
public interface Emitter {
    void emit(List<Instruction> instructions);
    
    public static class Factory {
        public static Emitter global = new Emitter() {
            @Override
            public void emit(List<Instruction> instructions) {
                instructions.add(Instruction.Set.pushGlobal);
            }
        };

        public static Emitter propertyChangeDynamicPostfix(Emitter targetObjEmitter, Emitter nameEmitter, boolean asExpression, Instruction instrDelta) {
            return new Emitter() {
                @Override
                public void emit(List<Instruction> instructions) {
                    targetObjEmitter.emit(instructions);
                    instructions.add(Instruction.Set.dup);
                    nameEmitter.emit(instructions);
                    instructions.add(Instruction.Set.dup2);
                    instructions.add(Instruction.Set.getPropertyValueDynamic);
                    if (asExpression) {
                        instructions.add(Instruction.Set.dup3);
                    }
                    instructions.add(Instruction.Set.pushNumber(1));
                    instructions.add(instrDelta);
                    instructions.add(Instruction.Set.swap);
                    instructions.add(Instruction.Set.setPropertyValueDynamic);
                }
            };
        }

        public static Emitter propertyChangeDynamic(Emitter targetObjEmitter, Emitter nameEmitter, boolean asExpression, Emitter valueEmitter, Instruction instrDelta) {
            return new Emitter() {
                @Override
                public void emit(List<Instruction> instructions) {
                    targetObjEmitter.emit(instructions);
                    instructions.add(Instruction.Set.dup);
                    nameEmitter.emit(instructions);
                    instructions.add(Instruction.Set.dup2);
                    instructions.add(Instruction.Set.getPropertyValueDynamic);
                    valueEmitter.emit(instructions);
                    instructions.add(instrDelta);
                    if (asExpression) {
                        instructions.add(Instruction.Set.dup3);
                    }
                    instructions.add(Instruction.Set.swap);
                    instructions.add(Instruction.Set.setPropertyValueDynamic);
                }
            };
        }

        public static Emitter propertyChangePostfix(Emitter targetObjEmitter, String name, boolean asExpression, Instruction instrDelta) {
            return new Emitter() {
                @Override
                public void emit(List<Instruction> instructions) {
                    targetObjEmitter.emit(instructions);
                    instructions.add(Instruction.Set.dup);
                    instructions.add(Instruction.Set.getPropertyValue(name));
                    if (asExpression) {
                        instructions.add(Instruction.Set.dup2);
                    }
                    instructions.add(Instruction.Set.pushNumber(1));
                    instructions.add(instrDelta);
                    instructions.add(Instruction.Set.setPropertyValue(name));
                }
            };
        }

        public static Emitter propertyChange(Emitter targetObjEmitter, String name, boolean asExpression, Emitter valueEmitter, Instruction instrDelta) {
            return new Emitter() {
                @Override
                public void emit(List<Instruction> instructions) {
                    targetObjEmitter.emit(instructions);
                    instructions.add(Instruction.Set.dup);
                    instructions.add(Instruction.Set.getPropertyValue(name));
                    valueEmitter.emit(instructions);
                    instructions.add(instrDelta);
                    if (asExpression) {
                        instructions.add(Instruction.Set.dup2);
                    }
                    instructions.add(Instruction.Set.setPropertyValue(name));
                }
            };
        }
    }
}
