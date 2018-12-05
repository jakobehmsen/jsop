/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author jakob
 */
public class NativeFunctions {
    public static final NativeFunctionObjectSession.Delegate arrayPush = new NativeFunctionObjectSession.Delegate() {
        @Override
        public void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
            ArrayObjectSession arraySelf = (ArrayObjectSession) self;
            
            arraySelf.push(arguments);
            
            Object result = session.getFactory().newNumber(arraySelf.length());
            applicationContext.returnFromNativeFunction(result);
        }

        @Override
        public int getCode() {
            return 100;
        }

        @Override
        public String getName() {
            return "push";
        }
    };
    
    public static final NativeFunctionObjectSession.Delegate functionApply = new NativeFunctionObjectSession.Delegate() {
        @Override
        public void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
            FunctionObjectSession functionSelf = (FunctionObjectSession) self;
            ObjectSession selfArgument = arguments[0];
            ArrayObjectSession argumentsArgument = (ArrayObjectSession) arguments[1];
            
            functionSelf.apply(session, applicationContext, selfArgument, argumentsArgument.getItems());
        }

        @Override
        public int getCode() {
            return 101;
        }

        @Override
        public String getName() {
            return "apply";
        }
    };
    
    public static final NativeFunctionObjectSession.Delegate Array = new NativeFunctionObjectSession.Delegate() {
        @Override
        public void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
            ArrayObjectSession arr = (ArrayObjectSession) session.getFactory().newArray(session);
                
            if(arguments.length == 1 && arguments[0] instanceof NumberObjectSession) {
                NumberObjectSession lengthArg = (NumberObjectSession) arguments[0];
                arr.setLength((int) lengthArg.getValue());
            } else {
                for(int i = 0; i < arguments.length; i++) {
                    arr.setByOrdinal(i, arguments[i]);
                }
            }
            
            applicationContext.returnFromNativeFunction(arr);
        }

        @Override
        public int getCode() {
            return 102;
        }

        @Override
        public String getName() {
            return "Array";
        }
    };
    
    public static final NativeFunctionObjectSession.Delegate Object = new NativeFunctionObjectSession.Delegate() {
        @Override
        public void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
            ObjectSession newMap = session.getFactory().newMap(session);
            
            ObjectSession objectPrototype = session.getNativeFunction(getCode()).get("prototype");
            newMap.set("__proto__", objectPrototype);
            
            applicationContext.returnFromNativeFunction(newMap);
        }

        @Override
        public int getCode() {
            return 103;
        }

        @Override
        public String getName() {
            return "Object";
        }
    };
    
    public static final NativeFunctionObjectSession.Delegate objectCreate = new NativeFunctionObjectSession.Delegate() {
        @Override
        public void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
            ObjectSession newMap = session.getFactory().newMap(session);
            
            newMap.set("__proto__", arguments[0]);
            
            applicationContext.returnFromNativeFunction(newMap);
        }

        @Override
        public int getCode() {
            return 104;
        }

        @Override
        public String getName() {
            return "objectCreate";
        }
    };
    
    public static final NativeFunctionObjectSession.Delegate javaPackage = new NativeFunctionObjectSession.Delegate() {
        @Override
        public void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
            String name = arguments[0].toString();
            JavaPackageObjectSession javaPackageObjectSession = new JavaPackageObjectSession(name);
            applicationContext.returnFromNativeFunction(javaPackageObjectSession);
        }

        @Override
        public int getCode() {
            return 105;
        }

        @Override
        public String getName() {
            return "javaPackage";
        }
    };
    
    public static List<NativeFunctionObjectSession.Delegate> getAll() {
        return Arrays.asList(NativeFunctions.class.getFields()).stream()
                .filter(f -> NativeFunctionObjectSession.Delegate.class.isAssignableFrom(f.getType()))
                .map(f -> {
                    try {
                        return (NativeFunctionObjectSession.Delegate)f.get(null);
                    } catch (IllegalArgumentException | IllegalAccessException ex) {
                        Logger.getLogger(NativeFunctions.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    return null;
                })
                .collect(Collectors.toList());
    }
    
    public static NativeFunctionObjectSession.Delegate getNativeObject(String name) {
        try {
            return (NativeFunctionObjectSession.Delegate) Arrays.asList(NativeFunctions.class.getFields()).stream()
                    .filter(f -> f.getName().equals(name))
                    .findFirst().get().get(null);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(NativeFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
