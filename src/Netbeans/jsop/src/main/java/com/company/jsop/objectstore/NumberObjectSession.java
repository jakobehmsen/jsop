/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author jakob
 */
public class NumberObjectSession implements ObjectSession {
    private double d;

    public NumberObjectSession(double d) {
        this.d = d;
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
        identity.deleteNumber(slot);
    }

    @Override
    public void setAsValueForSlot(String slot, ObjectStoreSessionIdentity identity) {
        identity.setNumber(slot, d);
    }
    
    private static final DecimalFormat df = new DecimalFormat("#.#");
    
    static {
        DecimalFormatSymbols s = df.getDecimalFormatSymbols();
        s.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(s);
    }

    @Override
    public String toString() {
        return df.format(d);
    }

    public double getValue() {
        return d;
    }

    @Override
    public ObjectSession getAsSlotIn(ObjectSession objectSession) {
        return objectSession.getByOrdinal((int)d);
    }

    @Override
    public void setAsSlotIn(ObjectSession objectSession, ObjectSession value) {
        objectSession.setByOrdinal((int)d, value);
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
        return objectSession.arithAddToNumber(getValue());
    }

    @Override
    public ObjectSession arithAddToNumber(double value) {
        return new NumberObjectSession(value + this.d);
    }

    @Override
    public ObjectSession arithSubtract(ObjectSession objectSession) {
        return objectSession.arithSubtractFromNumber(getValue());
    }

    @Override
    public ObjectSession arithSubtractFromNumber(double value) {
        return new NumberObjectSession(value - this.d);
    }

    @Override
    public ObjectSession arithMult(ObjectSession objectSession) {
        return objectSession.arithMultByNumber(getValue());
    }

    @Override
    public ObjectSession arithMultByNumber(double value) {
        return new NumberObjectSession(value * this.d);
    }

    @Override
    public ObjectSession arithDiv(ObjectSession objectSession) {
        return objectSession.arithDivByNumber(getValue());
    }

    @Override
    public ObjectSession arithDivByNumber(double value) {
        return new NumberObjectSession(value / this.d);
    }

    @Override
    public ObjectSession arithRem(ObjectSession objectSession) {
        return objectSession.arithRemByNumber(getValue());
    }

    @Override
    public ObjectSession arithRemByNumber(double value) {
        return new NumberObjectSession(value % this.d);
    }

    @Override
    public boolean isFalsy() {
        return d == 0.0 || d == Double.NaN;
    }

    @Override
    public ObjectSession compareLessThan(ObjectStoreSession storeSession, ObjectSession objectSession) {
        return objectSession.compareNumberLessThanYou(storeSession, d);
    }

    @Override
    public ObjectSession compareNumberLessThanYou(ObjectStoreSession storeSession, double d) {
        return storeSession.wrap(d < this.d);
    }

    @Override
    public ObjectSession compareLessThanOrEqual(ObjectStoreSession storeSession, ObjectSession objectSession) {
        return objectSession.compareNumberLessThanOrEqualYou(storeSession, d);
    }

    @Override
    public ObjectSession compareNumberLessThanOrEqualYou(ObjectStoreSession storeSession, double d) {
        return storeSession.wrap(d <= this.d);
    }

    @Override
    public ObjectSession compareGreaterThan(ObjectStoreSession storeSession, ObjectSession objectSession) {
        return objectSession.compareNumberGreaterThanYou(storeSession, d);
    }

    @Override
    public ObjectSession compareNumberGreaterThanYou(ObjectStoreSession storeSession, double d) {
        return storeSession.wrap(d > this.d);
    }

    @Override
    public ObjectSession compareGreaterThanOrEqual(ObjectStoreSession storeSession, ObjectSession objectSession) {
        return objectSession.compareNumberGreaterThanOrEqual(storeSession, d);
    }
    @Override
    public ObjectSession compareNumberGreaterThanOrEqual(ObjectStoreSession storeSession, double d) {
        return storeSession.wrap(d >= this.d);
    }

    @Override
    public ObjectSession bor(ObjectStoreSession oss, ObjectSession objectSession) {
        return objectSession.borNumber(oss, d);
    }

    @Override
    public ObjectSession borNumber(ObjectStoreSession<? extends ObjectSession> oss, double d) {
        return oss.getFactory().newNumber((int)d | (int)this.d);
    }

    @Override
    public ObjectSession bxor(ObjectStoreSession<? extends ObjectSession> oss, ObjectSession objectSession) {
        return objectSession.bxorNumber(oss, d);
    }

    @Override
    public ObjectSession bxorNumber(ObjectStoreSession<? extends ObjectSession> oss, double d) {
        return oss.getFactory().newNumber((int)d ^ (int)this.d);
    }

    @Override
    public ObjectSession band(ObjectStoreSession<? extends ObjectSession> oss, ObjectSession objectSession) {
        return objectSession.bandNumber(oss, d);
    }

    @Override
    public ObjectSession bandNumber(ObjectStoreSession<? extends ObjectSession> oss, double d) {
        return oss.getFactory().newNumber((int)d & (int)this.d);
    }

    @Override
    public ObjectSession equals(ObjectStoreSession oss, ObjectSession objectSession) {
        return objectSession.equalsNumber(oss, d);
    }

    @Override
    public ObjectSession equalsNumber(ObjectStoreSession oss, double d) {
        return oss.wrap(d == this.d);
    }

    @Override
    public ObjectSession equalsString(ObjectStoreSession<? extends ObjectSession> oss, String str) {
        return oss.toNumber(str).equals(oss, this);
    }

    @Override
    public ObjectSession equalsStrict(ObjectStoreSession oss, ObjectSession objectSession) {
        return oss.wrap(objectSession instanceof NumberObjectSession && 
                this.d == ((NumberObjectSession)objectSession).d);
    }
}
