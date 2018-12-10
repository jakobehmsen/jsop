/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

import com.company.jsop.objectstore.ApplicationContext;

/**
 *
 * @author jakob
 */
public interface JSONObjectBroker {
    void set(Object obj, String id, Object value);
    Object get(Object obj, String slotToRead);
    Object getDynamic(Object obj, Object slotToReadObj);
    void setDynamic(Object obj, Object slotToWriteObj, Object value);
    void setByOrdinal(Object array, int i, Object item);
    void apply(ApplicationContext applicationContext, Object applicable, Object self, Object[] arguments);

    public Object getNativeObject(String name);

    public Object undefined();

    public void declareVariable(Object scope, String name, Object value);
    boolean isDeclared(Object scope, String name);

    public void setVariable(Object scope, String id, Object value);

    public Object getVariable(Object scope, String id);

    public Object add(Object lhs, Object rhs);

    public Object subtract(Object lhs, Object rhs);

    public Object mult(Object lhs, Object rhs);

    public Object div(Object lhs, Object rhs);

    public Object rem(Object lhs, Object rhs);

    public Object lessThan(Object lhs, Object rhs);

    public Object lessThanOrEqual(Object lhs, Object rhs);

    public Object greaterThan(Object lhs, Object rhs);

    public Object greaterThanOrEqual(Object lhs, Object rhs);

    public Object isIn(Object lhs, Object rhs);

    public Object isInstanceof(Object lhs, Object rhs);

    public boolean isFalse(Object obj);

    public Object getGlobal();

    public Object[] createArray(int length);

    public Object getBoolean(boolean b);

    public Object bor(Object lhs, Object rhs);

    public Object bxor(Object lhs, Object rhs);

    public Object band(Object lhs, Object rhs);

    public Object eq(Object lhs, Object rhs);

    public Object seq(Object lhs, Object rhs);

    public Object newInstance(Object constructor);
}
