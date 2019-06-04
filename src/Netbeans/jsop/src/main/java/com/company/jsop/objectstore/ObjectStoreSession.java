/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.util.function.Supplier;

/**
 *
 * @author jakob
 */
public interface ObjectStoreSession<T> extends AutoCloseable {
    T get(ObjectStoreSessionIdentity identity);
    T get(ObjectStoreSessionIdentity identity, Supplier<T> supplier);
    T getRoot();
    ObjectStoreSessionIdentity newIdentity(int flags);
    ObjectSessionFactory<T> getFactory();
    void commit();
    void rollback();
    T getUndefined();
    T getArrayPrototype();
    NativeFunctionObjectSession getNativeFunction(int code);
    CompiledCode compile(String src, String[] parameterNames);

    default ObjectSession wrap(boolean b) {
        return b ? getTrue() : getFalse();
    }
    ObjectSession getTrue();
    ObjectSession getFalse();

    public ObjectSession toNumber(boolean b);
    public ObjectSession toNumber(String str);
    
    SessionStrategy<T> getStrategy();

    public Console getConsole();
}
