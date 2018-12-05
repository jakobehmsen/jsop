/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author jakob
 */
public class JavaValueObjectSession extends JavaObjectSession {
    private Object v;

    public JavaValueObjectSession(Object v) {
        this.v = v;
    }

    @Override
    public Object toJavaObject() {
        return v;
    }

    @Override
    public Class<?> getJavaValueClass() {
        return v.getClass();
    }

    @Override
    public Object getJavaValue() {
        return v;
    }

    @Override
    public ObjectSession get(String slot) {
        try {
            Field f = this.v.getClass().getField(slot);
            Object v = f.get(this.v);
            return new JavaValueObjectSession(v);
        } catch (NoSuchFieldException | SecurityException ex) {
            List<Method> methods = Arrays.asList(this.v.getClass().getMethods())
                    .stream()
                    .filter(x -> x.getName().equals(slot))
                    .collect(Collectors.toList());
            if(methods.size() > 0) {
                return new JavaMethodSetObjectSession(v, methods);
            }
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IllegalArgumentException | IllegalAccessException ex) {
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
    
}
