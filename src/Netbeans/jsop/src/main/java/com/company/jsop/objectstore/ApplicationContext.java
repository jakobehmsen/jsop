/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import com.company.jsop.jsonish.Instruction;

/**
 *
 * @author jakob
 */
public interface ApplicationContext {
    void returnFromNativeFunction(Object result);

    public void apply(Instruction[] instructions, ObjectSession self, ObjectSession[] arguments, int localCount);
}
