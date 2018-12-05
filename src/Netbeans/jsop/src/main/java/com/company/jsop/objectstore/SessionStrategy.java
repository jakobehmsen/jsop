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
public interface SessionStrategy<T> {
    T get(SessionStrategyContext<T> ctx, String name);
    void set(SessionStrategyContext<T> ctx, String name, T obj);
    T getByOrdinal(SessionStrategyContext<T> ctx, int i);
    boolean has(SessionStrategyContext<T> ctx, String name);
    void writeSlots(SessionStrategyContext<T> ctx);
    void setByOrdinal(SessionStrategyContext<T> ctx, int i, T obj);
    String toString(SessionStrategyContext<T> ctx);
    ObjectSession[] getItems(SessionStrategyContext<T> ctx);
    void setLength(SessionStrategyContext<T> ctx, int newLength);
}
