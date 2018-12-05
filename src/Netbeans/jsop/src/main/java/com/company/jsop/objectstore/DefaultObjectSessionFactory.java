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
public class DefaultObjectSessionFactory implements ObjectSessionFactory<ObjectSession> {
    // Cache could (should?) be placed here
    
    @Override
    public ObjectSession newMap(ObjectStoreSession<ObjectSession> session) {
        return new MapObjectSession(session);
    }

    @Override
    public ObjectSession newArray(ObjectStoreSession<ObjectSession> session) {
        return new ArrayObjectSession(session);
    }
    
    @Override
    public ObjectSession newMap(ObjectStoreSession<ObjectSession> session, ObjectStoreSessionIdentity identity) {
        switch(identity.getFlags()) {
            case 0:
                return new MapObjectSession(session, identity);
            case 1:
                return new ArrayObjectSession(session, identity);
            case 2:
                return new CustomFunctionObjectSession(session, identity);
        }
        
        if(identity.getFlags() >= 100 && identity.getFlags() <= 999) {
            NativeFunctionObjectSession.Delegate d = 
                    NativeFunctions.getAll().stream().filter(f -> f.getCode() == identity.getFlags()).findFirst().get();
            return new NativeFunctionObjectSession(session, identity, d);
        }
        
        throw new IllegalArgumentException("Unknown identity flags: " + identity.getFlags());
    }

    @Override
    public ObjectSession newString(String str) {
        return new StringObjectSession(str);
    }

    @Override
    public ObjectSession newNumber(double d) {
        return new NumberObjectSession(d);
    }

    @Override
    public ObjectSession newFunction(ObjectStoreSession<ObjectSession> session, String src, String[] parameterNames) {
        return new CustomFunctionObjectSession(session, src, parameterNames);
    }
}
