/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.util.stream.Stream;

/**
 *
 * @author jakob
 */
public interface ObjectSession {
    ObjectSession get(String slot);
    void set(String slot, ObjectSession obj);
    void deleteAsValueForSlot(String slot, ObjectStoreSessionIdentity identity);
    void setAsValueForSlot(String slot, ObjectStoreSessionIdentity identity);
    ObjectSession getAsSlotIn(ObjectSession objectSession);
    void setAsSlotIn(ObjectSession objectSession, ObjectSession value);
    ObjectSession getByOrdinal(int i);
    void setByOrdinal(int i, ObjectSession value);
    default ObjectSession getPrototype() {
        return null;
    }

    default boolean has(String id) {
        return false;
    }

    public ObjectSession arithAdd(ObjectSession objectSession);

    public ObjectSession arithSubtract(ObjectSession objectSession);

    public ObjectSession arithAddToNumber(double value);

    public ObjectSession arithSubtractFromNumber(double value);

    public ObjectSession arithMult(ObjectSession objectSession);

    public ObjectSession arithDiv(ObjectSession objectSession);

    public ObjectSession arithRem(ObjectSession objectSession);

    public ObjectSession arithMultByNumber(double value);

    public ObjectSession arithDivByNumber(double value);

    public ObjectSession arithRemByNumber(double value);
    
    boolean isFalsy();

    public ObjectSession compareLessThan(ObjectStoreSession storeSession, ObjectSession objectSession);

    public ObjectSession compareLessThanOrEqual(ObjectStoreSession storeSession, ObjectSession objectSession);

    public ObjectSession compareGreaterThan(ObjectStoreSession storeSession, ObjectSession objectSession);

    public ObjectSession compareGreaterThanOrEqual(ObjectStoreSession storeSession, ObjectSession objectSession);
    
    default ObjectSession compareIsIn(ObjectStoreSession storeSession, ObjectSession objectSession) {
        boolean isIn = has(((StringObjectSession)objectSession).getValue());
        
        return storeSession.wrap(isIn);
    }

    public ObjectSession compareNumberLessThanYou(ObjectStoreSession storeSession, double d);

    public ObjectSession compareNumberLessThanOrEqualYou(ObjectStoreSession storeSession, double d);

    public ObjectSession compareNumberGreaterThanYou(ObjectStoreSession storeSession, double d);

    public ObjectSession compareNumberGreaterThanOrEqual(ObjectStoreSession storeSession, double d);

    public ObjectSession bor(ObjectStoreSession oss, ObjectSession objectSession);

    public ObjectSession borNumber(ObjectStoreSession<? extends ObjectSession> oss, double d);

    public ObjectSession bxor(ObjectStoreSession<? extends ObjectSession> oss, ObjectSession objectSession);

    public ObjectSession bxorNumber(ObjectStoreSession<? extends ObjectSession> oss, double d);

    public ObjectSession band(ObjectStoreSession<? extends ObjectSession> oss, ObjectSession objectSession);

    public ObjectSession bandNumber(ObjectStoreSession<? extends ObjectSession> oss, double d);

    public ObjectSession equals(ObjectStoreSession<? extends ObjectSession> oss, ObjectSession objectSession);

    public default ObjectSession equalsBoolean(ObjectStoreSession<? extends ObjectSession> oss, boolean b) {
        ObjectSession bAsNumber = oss.toNumber(b);
        return bAsNumber.equals(oss, this);
    }

    public default ObjectSession equalsObject(ObjectStoreSession<? extends ObjectSession> oss, MapObjectSession aThis) {
        return oss.getFalse();
    }

    public default ObjectSession equalsNumber(ObjectStoreSession<? extends ObjectSession> oss, double d) {
        return oss.getFalse();
    }

    public default ObjectSession equalsString(ObjectStoreSession<? extends ObjectSession> oss, String str) {
        return oss.getFalse();
    }

    public default ObjectSession equalsUndefined(ObjectStoreSession<? extends ObjectSession> oss) {
        return oss.getFalse();
    }

    public default ObjectSession equalsStrict(ObjectStoreSession oss, ObjectSession objectSession) {
        return oss.wrap(this == objectSession);
    }

    public default Class<?> getJavaValueClass() {
        throw new UnsupportedOperationException();
    }

    public default Object getJavaValue() {
        throw new UnsupportedOperationException();
    }
}
