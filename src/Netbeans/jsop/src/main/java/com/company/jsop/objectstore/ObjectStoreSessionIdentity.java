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
public interface ObjectStoreSessionIdentity {
    void setString(String slot, String str);
    void setNumber(String slot, double d);
    void setReference(String slot, ObjectStoreSessionIdentity identity);
    void deleteString(String slot);
    void deleteNumber(String slot);
    void deleteIdentity(String slot);
    void getSlots(SlotVisitor visitor);
    ObjectStoreIdentity withoutSession();
    int getFlags();
}
