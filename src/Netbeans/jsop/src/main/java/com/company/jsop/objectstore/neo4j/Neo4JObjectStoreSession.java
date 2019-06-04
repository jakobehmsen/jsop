/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore.neo4j;

import java.util.HashSet;
import com.company.jsop.objectstore.AbstractObjectStoreSession;
import com.company.jsop.objectstore.BooleanObjectSession;
import com.company.jsop.objectstore.Console;
import com.company.jsop.objectstore.NativeFunctionObjectSession;
import com.company.jsop.objectstore.ObjectSession;
import com.company.jsop.objectstore.ObjectSessionFactory;
import com.company.jsop.objectstore.ObjectStoreSessionIdentity;
import com.company.jsop.objectstore.SessionStrategy;
import com.company.jsop.objectstore.UndefinedObjectSession;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

/**
 *
 * @author jakob
 */
public class Neo4JObjectStoreSession extends AbstractObjectStoreSession {
    private Session session;
    private Transaction transaction;
    private ObjectSession undefined;
    private ObjectSession trueObj;
    private ObjectSession falseObj;
    private ObjectStoreSessionIdentity rootIdentity;

    public Neo4JObjectStoreSession(Neo4JObjectStoreSessionIdentity.StatementGenerator rootIdentityStatementGenerator, ObjectStoreSessionIdentity arrayPrototypeIdentity, ObjectSessionFactory factory, com.company.jsop.objectstore.Compiler compiler, SessionStrategy sessionStrategy, Session session, Transaction transaction, Console console) {
        super(arrayPrototypeIdentity, factory, compiler, sessionStrategy, console);
        
        this.session = session;
        this.transaction = transaction;
        undefined = new UndefinedObjectSession();
        trueObj = new BooleanObjectSession(true);
        falseObj = new BooleanObjectSession(false);
        
        rootIdentity = new Neo4JObjectStoreSessionIdentity(this, transaction, rootIdentityStatementGenerator, 0);
    }

    @Override
    public Object getRoot() {
        return get(rootIdentity);
    }

    @Override
    public void close() throws Exception {
        transaction.close();
        session.close();
    }

    @Override
    public void commit() {
        changedIdenties.forEach(i -> i.performChanges());
        
        transaction.success();
    }

    @Override
    public void rollback() {
        transaction.failure();
    }

    public ObjectStoreSessionIdentity newIdentity(int flags, Neo4JObjectStoreSessionIdentity.StatementGenerator statementGenerator) {
        return new Neo4JObjectStoreSessionIdentity(this, transaction, statementGenerator, flags);
    }

    @Override
    public ObjectStoreSessionIdentity newIdentity(int flags) {
        int id = transaction.run("CREATE (o:Object {flags: " + flags + "}) return id(o)").single().get(0).asInt();
        return new Neo4JObjectStoreSessionIdentity(this, transaction, new Neo4JObjectStoreSessionIdentity.IdStatementGenerator(id), flags);
    }

    @Override
    public ObjectSession getUndefined() {
        return undefined;
    }

    @Override
    public NativeFunctionObjectSession getNativeFunction(int code) {
        ObjectStoreSessionIdentity id = newIdentity(code, new Neo4JObjectStoreSessionIdentity.LabelsStatementGenerator(":Object:NativeFunction {flags: " + code + "}"));
        return (NativeFunctionObjectSession) get(id, () -> getFactory().newMap(this, id));
    }
    
    private HashSet<Neo4JObjectStoreSessionIdentity> changedIdenties = new HashSet<>();

    public void identityChanged(Neo4JObjectStoreSessionIdentity identity) {
        changedIdenties.add(identity);
    }

    @Override
    public ObjectSession getTrue() {
        return trueObj;
    }

    @Override
    public ObjectSession getFalse() {
        return falseObj;
    }

    @Override
    public ObjectSession toNumber(boolean b) {
        return (ObjectSession)(b ? getFactory().newNumber(1) : getFactory().newNumber(0));
    }

    @Override
    public ObjectSession toNumber(String str) {
        return (ObjectSession) getFactory().newNumber(Double.parseDouble(str));
    }
}
