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
public class ComposedSessionStrategy<T> implements SessionStrategy<T> {
    @Override
    public T get(SessionStrategyContext<T> ctx, String name) {
        ctx.ensureCacheLoaded();
        
        return ctx.getFromCache(name);
    }

    @Override
    public T getByOrdinal(SessionStrategyContext<T> ctx, int i) {
        ctx.ensureCacheLoaded();
        
        return ctx.getByOrdinalFromCache(i);
    }

    @Override
    public void set(SessionStrategyContext<T> ctx, String name, T obj) {
        ctx.ensureCacheLoaded();
        
        ctx.setInCache(name, obj);
    }

    @Override
    public boolean has(SessionStrategyContext<T> ctx, String name) {
        ctx.ensureCacheLoaded();
        
        return ctx.hasInCache(name);
    }

    @Override
    public void writeSlots(SessionStrategyContext<T> ctx) {
        ctx.ensureCacheLoaded();
        
        ctx.writeSlotsFromCache();
    }

    @Override
    public void setByOrdinal(SessionStrategyContext<T> ctx, int i, T obj) {
        ctx.ensureCacheLoaded();
        
        ctx.setByOrdinalInCache(i, obj);
    }

    @Override
    public String toString(SessionStrategyContext<T> ctx) {
        ctx.ensureCacheLoaded();
        
        return ctx.toStringFromCache();
    }

    @Override
    public ObjectSession[] getItems(SessionStrategyContext<T> ctx) {
        ctx.ensureCacheLoaded();
        
        return ctx.getItemsFromCache();
    }

    @Override
    public void setLength(SessionStrategyContext<T> ctx, int newLength) {
        ctx.ensureCacheLoaded();
        
        ctx.setLengthInCache(newLength);
    }
}
