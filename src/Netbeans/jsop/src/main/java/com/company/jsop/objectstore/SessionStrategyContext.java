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
public interface SessionStrategyContext<T> {
    void ensureCacheLoaded();
    T getFromCache(String name);
    void setInCache(String name, T obj);
    T getByOrdinalFromCache(int i);
    void setByOrdinalInCache(int i, T obj);
    boolean hasInCache(String name);
    void writeSlotsFromCache();

    public String toStringFromCache();

    public ObjectSession[] getItemsFromCache();

    public void setLengthInCache(int newLength);
}
