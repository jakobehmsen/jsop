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
public class JavaPackageObjectSession extends JavaObjectSession {
    private ObjectStoreSession<ObjectSession> session;
    private String name;

    public JavaPackageObjectSession(ObjectStoreSession<ObjectSession> session, String name) {
        this.session = session;
        this.name = name;
    }

    @Override
    public Object toJavaObject() {
        return Package.getPackage(name);
    }

    @Override
    public ObjectSession get(String slot) {
        String newName = name.length() > 0 ? name + "." + slot : slot;
        try {
            Class<?> c = Class.forName(newName);
            return new JavaClassObjectSession(session, c);
        } catch (ClassNotFoundException ex) {
            return new JavaPackageObjectSession(session, newName);
        }
    }

    @Override
    public void set(String slot, ObjectSession obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSession getByOrdinal(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setByOrdinal(int i, ObjectSession value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFalsy() {
        return false;
    }

    @Override
    public ObjectSession equals(ObjectStoreSession<? extends ObjectSession> oss, ObjectSession objectSession) {
        return oss.wrap(objectSession instanceof JavaClassObjectSession && 
                this.name.equals(((JavaPackageObjectSession)objectSession).name));
    }

    @Override
    public String toString() {
        return name;
    }
}
