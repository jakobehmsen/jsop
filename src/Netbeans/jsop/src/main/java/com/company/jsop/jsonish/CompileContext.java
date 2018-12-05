/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

import java.util.function.Supplier;

/**
 *
 * @author jakob
 */
public interface CompileContext {

    public Emitter emitVariableDeclaration(boolean asExpression, String name, Emitter emitterExpression);

    public Emitter emitVariableAccess(boolean asExpression, String name);

    public Emitter emitVariableAssignment(boolean asExpression, String name, Emitter emitterExpression);
    Emitter emitReturn(Supplier<Emitter> returnEmitterSupplier);

    public Emitter emitVariableIncrement(String name, boolean asExpression);

    public Emitter emitVariableDecrement(String name, boolean asExpression);
}
