/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

/**
 *
 * @author jakob
 */
public interface Compiler {
    CompiledCode compile(ObjectStoreSession<? extends ObjectSession> session, String src, String[] parameterNames);
}
