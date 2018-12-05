/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

import com.company.jsop.objectstore.ApplicationContext;
import com.company.jsop.objectstore.FunctionObjectSession;
import com.company.jsop.objectstore.ObjectSession;

/**
 *
 * @author jakob
 */
public class Machine implements ApplicationContext {
    private Frame frame;
    private JSONObjectFactory factory;
    private JSONObjectBroker broker;

    public Machine(Frame frame, JSONObjectFactory factory, JSONObjectBroker broker) {
        this.frame = frame;
        this.factory = factory;
        this.broker = broker;
    }

    public Frame getFrame() {
        return frame;
    }
    
    public void setFrame(Frame frame) {
        this.frame = frame;
    }
    
    public void evaluate() {
        try {
            while(true) {
                frame.evaluate(this);
            }
        } catch (HaltException ex) {
            
        }
    }

    public void setPropertyValue(Object obj, String name, Object value) {
        broker.set(obj, name, value);
    }

    public void setPropertyValueDynamic(Object obj, Object name, Object value) {
        broker.setDynamic(obj, name, value);
    }

    public void setPropertyValue(Object obj, int ordinal, Object value) {
        broker.setByOrdinal(obj, ordinal, value);
    }

    public Object getPropertyValue(Object obj, String name) {
        return broker.get(obj, name);
    }

    public Object getPropertyValueDynamic(Object obj, Object name) {
        return broker.getDynamic(obj, name);
    }

    public Object mult(Object lhs, Object rhs) {
        return broker.mult(lhs, rhs);
    }

    public Object div(Object lhs, Object rhs) {
        return broker.div(lhs, rhs);
    }

    public Object rem(Object lhs, Object rhs) {
        return broker.rem(lhs, rhs);
    }

    public Object add(Object lhs, Object rhs) {
        return broker.add(lhs, rhs);
    }

    public Object sub(Object lhs, Object rhs) {
        return broker.subtract(lhs, rhs);
    }

    public Object eq(Object lhs, Object rhs) {
        return broker.eq(lhs, rhs);
    }

    public Object neq(Object lhs, Object rhs) {
        return broker.getBoolean(broker.isFalse(eq(lhs, rhs)));
    }

    public Object seq(Object lhs, Object rhs) {
        return broker.seq(lhs, rhs);
    }

    public Object sneq(Object lhs, Object rhs) {
        return broker.getBoolean(broker.isFalse(seq(lhs, rhs)));
    }

    public Object gt(Object lhs, Object rhs) {
        return broker.greaterThan(lhs, rhs);
    }

    public Object gte(Object lhs, Object rhs) {
        return broker.greaterThanOrEqual(lhs, rhs);
    }

    public Object lt(Object lhs, Object rhs) {
        return broker.lessThan(lhs, rhs);
    }

    public Object lte(Object lhs, Object rhs) {
        return broker.lessThanOrEqual(lhs, rhs);
    }

    public Object in(Object lhs, Object rhs) {
        return broker.isIn(lhs, rhs);
    }

    public Object ino(Object lhs, Object rhs) {
        return broker.isInstanceof(lhs, rhs);
    }

    public Object or(Object lhs, Object rhs) {
        boolean lhsIsFalse = broker.isFalse(lhs);
        boolean rhsIsFalse = broker.isFalse(rhs);
        return broker.getBoolean(!lhsIsFalse || !rhsIsFalse);
    }

    public Object and(Object lhs, Object rhs) {
        boolean lhsIsFalse = broker.isFalse(lhs);
        boolean rhsIsFalse = broker.isFalse(rhs);
        return broker.getBoolean(!lhsIsFalse && !rhsIsFalse);
    }

    public Object bor(Object lhs, Object rhs) {
        return broker.bor(lhs, rhs);
    }

    public Object bxor(Object lhs, Object rhs) {
        return broker.bxor(lhs, rhs);
    }

    public Object band(Object lhs, Object rhs) {
        return broker.band(lhs, rhs);
    }

    public void apply(Object applicable, Object self, Object[] arguments) {
        broker.apply(this, applicable, self, arguments);
    }

    public Object getNativeFunction(String name) {
        return broker.getNativeObject(name);
    }

    /*public void newInstance(Object constructor, Object[] arguments) {
        Object prototype = broker.get(constructor, "prototype");
        Object obj = factory.newMap();
        broker.set(obj, "__proto__", prototype);
        apply(constructor, obj, arguments);
    }*/

    public Object[] createArray(int length) {
        return broker.createArray(length);
    }

    @Override
    public void returnFromNativeFunction(Object result) {
        frame.pushObject(result);
        frame.incIP();
    }

    public Object createCustomFunction(String type, String src, String[] parameterNames) {
        return factory.newFunction(type, src, parameterNames);
    }

    @Override
    public void apply(Instruction[] instructions, ObjectSession self, ObjectSession[] arguments, int localCount) {
        Frame applyFrame = new Frame(frame, instructions, factory, broker);
        applyFrame.pushObject(self);
        for (ObjectSession argument: arguments) {
            applyFrame.pushObject(argument);
        }
        for(int i = 0; i < localCount; i++) {
            applyFrame.pushUndefined();
        }
        frame = applyFrame;
    }

    public boolean isFalsy(Object obj) {
        return broker.isFalse(obj);
    }
}