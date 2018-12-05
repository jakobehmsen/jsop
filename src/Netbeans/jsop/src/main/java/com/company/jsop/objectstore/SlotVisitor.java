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
public interface SlotVisitor {
    void visitString(String name, String str);
    void visitNumber(String name, double d);
    void visitIdentity(String name, ObjectStoreSessionIdentity identity);
}
