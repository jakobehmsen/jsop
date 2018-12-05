/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 * @author jakob
 * @param <T>
 */
public abstract class AbstractObjectStoreSession<T extends ObjectSession> implements ObjectStoreSession<T> {
    private ObjectStoreSessionIdentity arrayPrototypeIdentity;
    private final Map<ObjectStoreSessionIdentity, T> objectCache;
    private ObjectSessionFactory<T> factory;
    private Compiler compiler;
    private SessionStrategy<T> sessionStrategy;

    public AbstractObjectStoreSession(ObjectStoreSessionIdentity arrayPrototypeIdentity, ObjectSessionFactory<T> factory, Compiler compiler, SessionStrategy<T> sessionStrategy) {
        this.arrayPrototypeIdentity = arrayPrototypeIdentity;
        this.factory = factory;
        this.compiler = compiler;
        this.sessionStrategy = sessionStrategy;
        objectCache = new Hashtable<>();
    }

    @Override
    public SessionStrategy<T> getStrategy() {
        return sessionStrategy;
    }

    @Override
    public T get(ObjectStoreSessionIdentity identity) {
        return get(identity, () -> factory.newMap(this, identity));
    }
    
    protected T getAndInitialize(ObjectStoreSessionIdentity identity, Consumer<T> initializer) {
        return get(identity, () -> {
            T o = factory.newMap(this, identity);
            initializer.accept(o);
            return o;
        });
    }
    
    @Override
    public T get(ObjectStoreSessionIdentity identity, Supplier<T> supplier) {
        synchronized(objectCache) {
            return objectCache.computeIfAbsent(identity, k -> supplier.get());
        }
    }

    @Override
    public T getArrayPrototype() {
        // Ensure that default builtin slots are set up, if not overwritten
        return getAndInitialize(arrayPrototypeIdentity, o -> {
            /*ObjectSession push = o.get("push");
            if(push == null) {
                o.set("push", NativeFunctions.arrayPush.toObjectSession(this));
            }*/
        });
    }

    @Override
    public ObjectSessionFactory<T> getFactory() {
        return factory;
    }

    @Override
    public CompiledCode compile(String src, String[] parameterNames) {
        return compiler.compile(this, src, parameterNames);
    }
}
