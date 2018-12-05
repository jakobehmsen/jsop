/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jakob
 */
public class JavaClassObjectSession extends JavaObjectSession {
    // How to invoke constructor of class?
    private Class<?> c;

    public JavaClassObjectSession(Class<?> c) {
        this.c = c;
    }

    @Override
    public Object toJavaObject() {
        return c;
    }

    @Override
    public ObjectSession get(String slot) {
        try {
            Field f = c.getField(slot);
            Object v = f.get(null);
            return new JavaValueObjectSession(v);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            // Attempt to get method
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void set(String slot, ObjectSession obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession getByOrdinal(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setByOrdinal(int i, ObjectSession value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFalsy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession equals(ObjectStoreSession<? extends ObjectSession> oss, ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return c.getName();
    }
}
