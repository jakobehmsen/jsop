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
public class StringObjectSession implements ObjectSession {
    private String str;

    public StringObjectSession(String str) {
        this.str = str;
    }

    @Override
    public Class<?> getJavaValueClass() {
        return String.class;
    }

    @Override
    public Object getJavaValue() {
        return str;
    }

    @Override
    public void set(String slot, ObjectSession obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAsValueForSlot(String slot, ObjectStoreSessionIdentity identity) {
        identity.deleteString(slot);
    }

    @Override
    public void setAsValueForSlot(String slot, ObjectStoreSessionIdentity identity) {
        identity.setString(slot, str);
    }

    @Override
    public ObjectSession get(String slot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return str;
    }

    @Override
    public ObjectSession getAsSlotIn(ObjectSession objectSession) {
        return objectSession.get(str);
    }

    @Override
    public void setAsSlotIn(ObjectSession objectSession, ObjectSession value) {
        objectSession.set(str, value);
    }

    @Override
    public ObjectSession getByOrdinal(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setByOrdinal(int i, ObjectSession value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getValue() {
        return str;
    }

    @Override
    public ObjectSession arithAdd(ObjectSession objectSession) {
        return new StringObjectSession(this.toString() + objectSession.toString());
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
        return str.length() == 0;
    }

    @Override
    public ObjectSession compareLessThan(ObjectStoreSession storeSession, ObjectSession objectSession) {
        return storeSession.getFalse();
    }

    @Override
    public ObjectSession compareLessThanOrEqual(ObjectStoreSession storeSession, ObjectSession objectSession) {
        return storeSession.getFalse();
    }

    @Override
    public ObjectSession compareGreaterThan(ObjectStoreSession storeSession, ObjectSession objectSession) {
        return storeSession.getFalse();
    }

    @Override
    public ObjectSession compareGreaterThanOrEqual(ObjectStoreSession storeSession, ObjectSession objectSession) {
        return storeSession.getFalse();
    }

    @Override
    public ObjectSession compareNumberLessThanYou(ObjectStoreSession storeSession, double d) {
        return storeSession.getFalse();
    }

    @Override
    public ObjectSession compareNumberLessThanOrEqualYou(ObjectStoreSession storeSession, double d) {
        return storeSession.getFalse();
    }

    @Override
    public ObjectSession compareNumberGreaterThanYou(ObjectStoreSession storeSession, double d) {
        return storeSession.getFalse();
    }

    @Override
    public ObjectSession compareNumberGreaterThanOrEqual(ObjectStoreSession storeSession, double d) {
        return storeSession.getFalse();
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
        return objectSession.equalsString(oss, str);
    }

    @Override
    public ObjectSession equalsNumber(ObjectStoreSession<? extends ObjectSession> oss, double d) {
        return oss.getFactory().newNumber(d).equals(oss, oss.toNumber(str));
    }

    @Override
    public ObjectSession equalsString(ObjectStoreSession<? extends ObjectSession> oss, String str) {
        return oss.wrap(str.equals(this.str));
    }

    @Override
    public ObjectSession equalsStrict(ObjectStoreSession oss, ObjectSession objectSession) {
        return oss.wrap(objectSession instanceof StringObjectSession && 
                this.str.equals(((StringObjectSession)objectSession).str));
    }
}
