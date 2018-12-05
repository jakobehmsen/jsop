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
public abstract class FunctionObjectSession extends MapObjectSession {
    public FunctionObjectSession(ObjectStoreSession<ObjectSession> session) {
        super(session);
    }

    public FunctionObjectSession(ObjectStoreSession<ObjectSession> session, ObjectStoreSessionIdentity identity) {
        super(session, identity);
    }
    
    public abstract void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments);
}
