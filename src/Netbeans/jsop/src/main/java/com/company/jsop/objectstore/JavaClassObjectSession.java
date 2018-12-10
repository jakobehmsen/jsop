/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author jakob
 */
public class JavaClassObjectSession extends JavaObjectSession implements FunctionObjectSessionInterface {
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

    @Override
    public void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
        List<Constructor> methodsOfArity = Arrays.asList(c.getConstructors())
                .stream()
                .filter(x -> x.getParameterCount() == arguments.length)
                .collect(Collectors.toList());
        
        if(methodsOfArity.size() > 0) {
            List<Class<?>> parameterTypes = Arrays.asList(arguments)
                    .stream()
                    .map(x -> x.getJavaValueClass())
                    .collect(Collectors.toList());
            int bestD = Integer.MAX_VALUE;
            Constructor bestCandidate = null;
            for (Constructor m : methodsOfArity) {
                int d = JavaMethodSetObjectSession.isCompatible(m.getParameterTypes(), parameterTypes);
                if (d != -1 && d < bestD) {
                    bestD = d;
                    bestCandidate = m;
                }
            }
            
            if(bestCandidate != null) {
                Object[] javaArgs = new Object[arguments.length];
                for(int i = 0; i < arguments.length; i++) {
                    javaArgs[i] = arguments[i].getJavaValue();
                }
                Constructor m = bestCandidate;
                try {
                    Object obj = m.newInstance(javaArgs);
                    // Convert to respective ObjectSession type
                    // java.lang.String => StringObjectSession
                    // and so on
                    // There could be several special implementations of
                    // JavaClassObjectSession, that does this.
                    // E.g. StringJavaClassObjectSession, that convert to
                    // StringObjectSession.
                    JavaValueObjectSession res = new JavaValueObjectSession(obj);
                    applicationContext.returnFromNativeFunction(res);
                    
                } catch (IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(JavaMethodSetObjectSession.class.getName()).log(Level.SEVERE, null, ex);
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } catch (InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(JavaClassObjectSession.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public ObjectSession newInstance(ObjectStoreSession<ObjectSession> session) {
        return session.getUndefined();
    }
}
