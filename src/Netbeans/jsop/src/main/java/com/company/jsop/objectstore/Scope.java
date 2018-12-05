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
public interface Scope {
    void declareVariable(String id, ObjectSession value);
    ObjectSession getVariable(String id);
    void setVariable(String id, ObjectSession value);
    boolean isDeclared(String id);
    
    public static Scope wrap(ObjectSession obj) {
        return new Scope() {
            @Override
            public void declareVariable(String id, ObjectSession value) {
                obj.set(id, value);
            }

            @Override
            public ObjectSession getVariable(String id) {
                return obj.get(id);
            }

            @Override
            public void setVariable(String id, ObjectSession value) {
                obj.set(id, value);
            }

            @Override
            public boolean isDeclared(String id) {
                return obj.has(id);
            }
        };
    }
}
