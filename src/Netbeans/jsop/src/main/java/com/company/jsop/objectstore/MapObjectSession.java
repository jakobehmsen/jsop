/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author jakob
 */
public class MapObjectSession implements ObjectSession, SessionStrategyContext<ObjectSession> {
    private ObjectStoreSession<ObjectSession> session;
    private ObjectStoreSessionIdentity identity;
    private Map<String, ObjectSession> slots;

    public MapObjectSession(ObjectStoreSession<ObjectSession> session) {
        this.session = session;
    }
    
    public ObjectStoreSessionIdentity getIdentity() {
        return identity;
    }

    public ObjectStoreSession<ObjectSession> getSession() {
        return session;
    }

    public MapObjectSession(ObjectStoreSession<ObjectSession> session, ObjectStoreSessionIdentity identity) {
        this.session = session;
        this.identity = identity;
    }
    
    private void ensureInitialized() {
        if(slots == null) {
            slots = new Hashtable<>();
                
            if(identity != null) {
                getSlots(identity, new SlotVisitor() {
                    @Override
                    public void visitString(String name, String str) {
                        slots.put(name, session.getFactory().newString(str));
                    }

                    @Override
                    public void visitNumber(String name, double d) {
                        slots.put(name, session.getFactory().newNumber(d));
                    }

                    @Override
                    public void visitIdentity(String name, ObjectStoreSessionIdentity identity) {
                        // What if identity is array?
                        ObjectSession obj = session.get(identity);
                        slots.put(name, obj);
                    }
                });
            }
        }
    }
    
    protected void getSlots(ObjectStoreSessionIdentity identity, SlotVisitor visitor) {
        identity.getSlots(visitor);
    }
    
    @Override
    public void set(String slot, ObjectSession obj) {
        getSession().getStrategy().set(this, slot, obj);
        
        /*ensureInitialized();
        
        if(this.identity != null) {
            ObjectSession current = slots.get(slot);

            if(current != null) {
                current.deleteAsValueForSlot(slot, this.identity);
            }

            obj.setAsValueForSlot(slot, this.identity);
        }
        
        slots.put(slot, obj);*/
    }

    @Override
    public void deleteAsValueForSlot(String slot, ObjectStoreSessionIdentity identity) {
        identity.deleteIdentity(slot);
    }

    @Override
    public void setAsValueForSlot(String slot, ObjectStoreSessionIdentity identity) {
        //ensureInitialized();
        
        if(this.identity == null) {
            this.identity = session.newIdentity(identityFlags());
            
            writeSlots();
        }
        
        identity.setReference(slot, this.identity);
    }
    
    protected void writeSlots() {
        getSession().getStrategy().writeSlots(this);
        
        /*slots.entrySet().forEach(e -> 
            e.getValue().setAsValueForSlot(e.getKey(), this.identity));*/
    }
    
    protected int identityFlags() {
        return 0;
    }

    @Override
    public ObjectSession get(String slot) {
        ObjectSession obj = session.getStrategy().get(this, slot);
        
        /*ensureInitialized();
        
        ObjectSession obj = slots.get(slot);*/
        
        if(obj == null) {
            ObjectSession prototype = getPrototype();
            
            if(prototype != getSession().getUndefined()) {
                return prototype.get(slot);
            }
            
            return getSession().getUndefined();
        }
        
        return obj;
    }
    
    /*@Override
    public void ensureInitialized() {
        ensureInitialized();
    }*/

    @Override
    public void ensureCacheLoaded() {
        ensureInitialized();
    }

    @Override
    public ObjectSession getFromCache(String name) {
        return slots.get(name);
    }

    @Override
    public void setInCache(String name, ObjectSession obj) {
        slots.put(name, obj);
    }

    @Override
    public ObjectSession getByOrdinalFromCache(int i) {
        return getFromCache(i + "");
    }

    @Override
    public boolean hasInCache(String name) {
        return slots.containsKey(name);
    }

    @Override
    public void writeSlotsFromCache() {
        slots.entrySet().forEach(e -> 
            e.getValue().setAsValueForSlot(e.getKey(), this.identity));
    }

    @Override
    public void setByOrdinalInCache(int i, ObjectSession obj) {
        setInCache(i + "", obj);
    }

    @Override
    public ObjectSession[] getItemsFromCache() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLengthInCache(int newLength) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toStringFromCache() {
        return toString();
    }

    @Override
    public ObjectSession getPrototype() {
        ObjectSession proto = session.getStrategy().get(this, "__proto__");
        return proto != null ? proto : session.getUndefined();
        
        /*ensureInitialized();
        
        return slots.entrySet().stream()
                .filter(e -> e.getKey().equals("__proto__"))
                .map(e -> e.getValue())
                .findFirst()
                .orElseGet(() -> session.getUndefined());*/
    }

    @Override
    public String toString() {
        return "{...}";
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
        return get("" + i);
    }

    @Override
    public void setByOrdinal(int i, ObjectSession value) {
        set("" + i, value);
    }

    @Override
    public boolean has(String id) {
        return getSession().getStrategy().has(this, id);
        
        /*ensureInitialized();
        
        return slots.containsKey(id);*/
    }

    @Override
    public ObjectSession arithAdd(ObjectSession objectSession) {
        return getSession().getFactory().newString(this.toString() + objectSession.toString());
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
        return false;
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
    public ObjectSession compareIsIn(ObjectStoreSession storeSession, ObjectSession objectSession) {
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
    public ObjectSession equals(ObjectStoreSession oss, ObjectSession objectSession) {
        return objectSession.equalsObject(oss, this);
    }

    @Override
    public ObjectSession equalsObject(ObjectStoreSession oss, MapObjectSession aThis) {
        return oss.wrap(this == aThis);
    }

    @Override
    public ObjectSession equalsNumber(ObjectStoreSession<? extends ObjectSession> oss, double d) {
        return oss.wrap(false);
    }
}
