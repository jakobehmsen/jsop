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
public class BooleanObjectSession implements ObjectSession {
    private boolean b;

    public BooleanObjectSession(boolean b) {
        this.b = b;
    }

    @Override
    public ObjectSession get(String slot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set(String slot, ObjectSession obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAsValueForSlot(String slot, ObjectStoreSessionIdentity identity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAsValueForSlot(String slot, ObjectStoreSessionIdentity identity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession getAsSlotIn(ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAsSlotIn(ObjectSession objectSession, ObjectSession value) {
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
    public ObjectSession arithAdd(ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession arithSubtract(ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession arithAddToNumber(double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession arithSubtractFromNumber(double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession arithMult(ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession arithDiv(ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession arithRem(ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession arithMultByNumber(double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession arithDivByNumber(double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession arithRemByNumber(double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFalsy() {
        return !b;
    }

    @Override
    public ObjectSession compareLessThan(ObjectStoreSession storeSession, ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession compareLessThanOrEqual(ObjectStoreSession storeSession, ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession compareGreaterThan(ObjectStoreSession storeSession, ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession compareGreaterThanOrEqual(ObjectStoreSession storeSession, ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession compareNumberLessThanYou(ObjectStoreSession storeSession, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession compareNumberLessThanOrEqualYou(ObjectStoreSession storeSession, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession compareNumberGreaterThanYou(ObjectStoreSession storeSession, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession compareNumberGreaterThanOrEqual(ObjectStoreSession storeSession, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "" + b;
    }

    @Override
    public ObjectSession bor(ObjectStoreSession oss, ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession borNumber(ObjectStoreSession<? extends ObjectSession> oss, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession bxor(ObjectStoreSession<? extends ObjectSession> oss, ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession bxorNumber(ObjectStoreSession<? extends ObjectSession> oss, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession band(ObjectStoreSession<? extends ObjectSession> oss, ObjectSession objectSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession bandNumber(ObjectStoreSession<? extends ObjectSession> oss, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession equals(ObjectStoreSession<? extends ObjectSession> oss, ObjectSession objectSession) {
        return objectSession.equalsBoolean(oss, b);
    }

    @Override
    public ObjectSession equalsBoolean(ObjectStoreSession<? extends ObjectSession> oss, boolean b) {
        return oss.wrap(b == this.b);
    }

    @Override
    public ObjectSession equalsNumber(ObjectStoreSession<? extends ObjectSession> oss, double d) {
        return oss.getFactory().newNumber(d).equals(oss, oss.toNumber(b));
    }

    @Override
    public ObjectSession equalsString(ObjectStoreSession<? extends ObjectSession> oss, String str) {
        return oss.getFactory().newString(str).equals(oss, oss.toNumber(b));
    }

    @Override
    public ObjectSession equalsStrict(ObjectStoreSession oss, ObjectSession objectSession) {
        return oss.wrap(objectSession instanceof BooleanObjectSession && 
                this.b == ((BooleanObjectSession)objectSession).b);
    }
}
