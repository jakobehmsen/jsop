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
public interface ObjectSessionFactory<T> {
    T newMap(ObjectStoreSession<T> session);
    T newArray(ObjectStoreSession<T> session);
    T newFunction(ObjectStoreSession<T> session, String src, String[] parameterNames);
    T newMap(ObjectStoreSession<T> session, ObjectStoreSessionIdentity identity);
    T newString(String str);
    T newNumber(double d);
}
