/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.lang.reflect.InvocationTargetException;
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
public class JavaMethodSetObjectSession extends FunctionObjectSession {
    private Object instance;
    private List<Method> methods;

    public JavaMethodSetObjectSession(Object instance, List<Method> methods) {
        super(null);
        
        this.instance = instance;
        this.methods = methods;
    }

    @Override
    public void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
        List<Method> methodsOfArity = methods
                .stream()
                .filter(x -> x.getParameterCount() == arguments.length)
                .collect(Collectors.toList());
        
        if(methodsOfArity.size() > 0) {
            List<Class<?>> parameterTypes = Arrays.asList(arguments)
                    .stream()
                    .map(x -> x.getJavaValueClass())
                    .collect(Collectors.toList());
            int bestD = Integer.MAX_VALUE;
            Method bestCandidate = null;
            for (Method m : methodsOfArity) {
                int d = isCompatible(m.getParameterTypes(), parameterTypes);
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
                Method m = bestCandidate;
                try {
                    Object obj = m.invoke(instance, javaArgs);
                    JavaValueObjectSession res = new JavaValueObjectSession(obj);
                    applicationContext.returnFromNativeFunction(res);
                    
                    return;
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(JavaMethodSetObjectSession.class.getName()).log(Level.SEVERE, null, ex);
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static int isCompatible(Class<?>[] methodParameterTypes, List<Class<?>> parameterTypes) {
        int distance = 0;
        
        for(int i = 0; i < parameterTypes.size(); i++) {
            int d = isCompatible(methodParameterTypes, parameterTypes, i);
            if(d == -1) {
                return -1;
            }
            distance += d;
        }
        
        return distance;
    }
    
    public static int isCompatible(Class<?>[] methodParameterTypes, List<Class<?>> parameterTypes, int i) {
        Class<?> argParameterType = parameterTypes.get(i);
        Class<?> methodParameterType = methodParameterTypes[i];
        
        int distance = 0;
        
        while(argParameterType != null) {
            if(methodParameterType.equals(argParameterType)) {
                return distance;
            }
            
            argParameterType = argParameterType.getSuperclass();
            distance++;
        }
        
        return -1;
    }
}
