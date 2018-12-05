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
public class NativeFunctionObjectSession extends FunctionObjectSession {
    public interface Delegate {
        void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments);
        int getCode(); /*[100..999]*/
        String getName();
    }
    
    private Delegate delegate;
    
    public NativeFunctionObjectSession(ObjectStoreSession session, Delegate delegate) {
        super(session);
        
        this.delegate = delegate;
    }

    public NativeFunctionObjectSession(ObjectStoreSession session, ObjectStoreSessionIdentity identity, Delegate delegate) {
        super(session, identity);
        
        this.delegate = delegate;
    }

    @Override
    public String toString() {
        return "function " + delegate.getName() + " { [native code] }";
    }

    @Override
    protected int identityFlags() {
        return delegate.getCode();
    }

    @Override
    public void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
        delegate.apply(session, applicationContext, self, arguments);
    }
}
