/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 *
 * @author jakob
 */
public class ArrayObjectSession extends MapObjectSession {
    private ObjectSession[] items;
    private int length;

    public ArrayObjectSession(ObjectStoreSession<ObjectSession> session) {
        super(session);
        length = 0;
        items = new ObjectSession[10];
    }

    public ArrayObjectSession(ObjectStoreSession<ObjectSession> session, ObjectStoreSessionIdentity identity) {
        super(session, identity);
    }

    @Override
    protected int identityFlags() {
        return 1;
    }

    @Override
    protected void getSlots(ObjectStoreSessionIdentity identity, SlotVisitor visitor) {
        Hashtable<Integer, ObjectSession> itemBuilder = new Hashtable<>();
        
        identity.getSlots(new SlotVisitor() {
            @Override
            public void visitString(String name, String str) {
                visitMaybe(name, 
                        () -> getSession().getFactory().newString(str), 
                        () -> visitor.visitString(name, str));
            }

            @Override
            public void visitNumber(String name, double d) {
                visitMaybe(name, 
                        () -> getSession().getFactory().newNumber(d), 
                        () -> visitor.visitNumber(name, d));
            }

            @Override
            public void visitIdentity(String name, ObjectStoreSessionIdentity identity) {
                visitMaybe(name, 
                        () -> getSession().getFactory().newMap(getSession(), identity), 
                        () -> visitor.visitIdentity(name, identity));
            }
            
            private void visitMaybe(String name, Supplier<ObjectSession> r1, Runnable r2) {
                try {
                    int i = Integer.parseInt(name);
                    length = Math.max(length, i + 1);
                    ObjectSession item = r1.get();
                    itemBuilder.put(i, item);
                } catch(NumberFormatException e) {
                    r2.run();
                }
            }
        });
        
        items = new ObjectSession[length];
        itemBuilder.forEach((i, item) -> items[i] = item);
    }

    /*@Override
    protected void writeSlots() {
        super.writeSlots();
        
        for(int i = 0; i < length; i++) {
            if(items[i] != null) {
                items[i].setAsValueForSlot("" + i, getIdentity());
            }
        }
    };*/

    @Override
    public void writeSlotsFromCache() {
        super.writeSlotsFromCache();
        
        for(int i = 0; i < length; i++) {
            if(items[i] != null) {
                items[i].setAsValueForSlot("" + i, getIdentity());
            }
        }
    }

    @Override
    public void setByOrdinal(int i, ObjectSession value) {
        getSession().getStrategy().setByOrdinal(this, i, value);
        
        /*ensureInitialized();
        
        ensureCapacity(i + 1);
        
        items[i] = value;
        length = Math.max(length, i + 1);
        
        if(getIdentity() != null) {
            value.setAsValueForSlot("" + i, getIdentity());
        }*/
    }

    @Override
    public void setByOrdinalInCache(int i, ObjectSession obj) {
        ensureCapacity(i + 1);
        
        items[i] = obj;
        length = Math.max(length, i + 1);
        
        if(getIdentity() != null) {
            obj.setAsValueForSlot("" + i, getIdentity());
        }
    }

    @Override
    public ObjectSession getByOrdinal(int i) {
        return getSession().getStrategy().getByOrdinal(this, i);
        
        /*ensureInitialized();
        
        if(i >= items.length || items[i] == null) {
            return getSession().getUndefined();
        }
        
        return items[i];*/
    }

    @Override
    public ObjectSession getByOrdinalFromCache(int i) {
        return items[i];
    }

    @Override
    public String toString() {
        return getSession().getStrategy().toString(this);
        
        /*ensureInitialized();
        
        return "[" + 
                Arrays.asList(items).stream()
                        .limit(length)
                        .map(item -> item.toString())
                        .collect(Collectors.joining(", ")) +
                "]";*/
    }

    @Override
    public String toStringFromCache() {
        return "[" + 
                Arrays.asList(items).stream()
                        .limit(length)
                        .map(item -> item.toString())
                        .collect(Collectors.joining(", ")) +
                "]";
    }

    public int length() {
        return length;
    }

    public void push(ObjectSession[] items) {
        for(ObjectSession item: items) {
            setByOrdinal(length, item);
        }
    }
/*
    @Override
    public ObjectSession getPrototype() {
        return getSession().getArrayPrototype();
    }
*/
    public ObjectSession[] getItems() {
        return getSession().getStrategy().getItems(this);
        
        /*ensureInitialized();
        
        return Arrays.asList(items).stream()
                .limit(length)
                .toArray(s -> new ObjectSession[s]);*/
    }

    @Override
    public ObjectSession[] getItemsFromCache() {
        return items;
    }

    public void setLength(int newLength) {
        getSession().getStrategy().setLength(this, newLength);
        
        /*ensureInitialized();
        
        if(length > newLength) {
            for(int i = length; i < newLength; i++) {
                items[i] = null;
            }
            
            length = newLength;
        } else {
            ensureCapacity(newLength);
        }*/
    }

    @Override
    public void setLengthInCache(int newLength) {
        if(length > newLength) {
            for(int i = length; i < newLength; i++) {
                items[i] = null;
            }
            
            length = newLength;
        } else {
            ensureCapacity(newLength);
        }
    }
    
    private void ensureCapacity(int newLength) {
        if(items.length < newLength) {
            ObjectSession[] newItems = new ObjectSession[newLength * 2];
            System.arraycopy(items, 0, newItems, 0, length);
            items = newItems;
        }
    }
}
