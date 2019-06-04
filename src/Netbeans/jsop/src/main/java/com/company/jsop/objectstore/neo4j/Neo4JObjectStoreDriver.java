/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore.neo4j;

import com.company.jsop.objectstore.ComposedSessionStrategy;
import com.company.jsop.objectstore.Console;
import com.company.jsop.objectstore.ObjectSessionFactory;
import com.company.jsop.objectstore.ObjectStoreDriver;
import com.company.jsop.objectstore.ObjectStoreSession;
import com.company.jsop.objectstore.SessionStrategy;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

/**
 *
 * @author jakob
 */
public class Neo4JObjectStoreDriver<T> implements ObjectStoreDriver {
    private Driver driver;
    private Neo4JObjectStoreSessionIdentity.StatementGenerator rootIdentityStatementGenerator;
    private Neo4JObjectStoreSessionIdentity.StatementGenerator arrayPrototypeIdentityStatementGenerator;
    private ObjectSessionFactory<T> factory;
    private com.company.jsop.objectstore.Compiler compiler;
    private Console console;

    public Neo4JObjectStoreDriver(Driver driver, 
            Neo4JObjectStoreSessionIdentity.StatementGenerator rootIdentityStatementGenerator, 
            Neo4JObjectStoreSessionIdentity.StatementGenerator arrayPrototypeIdentityStatementGenerator, 
            ObjectSessionFactory<T> factory,
            com.company.jsop.objectstore.Compiler compiler,
            Console console) {
        this.driver = driver;
        this.rootIdentityStatementGenerator = rootIdentityStatementGenerator;
        this.arrayPrototypeIdentityStatementGenerator = arrayPrototypeIdentityStatementGenerator;
        this.factory = factory;
        this.compiler = compiler;
        this.console = console;
    }

    @Override
    public ObjectStoreSession<T> newSession() {
        Session session = driver.session();
        Transaction transaction = session.beginTransaction();
        Neo4JObjectStoreSessionIdentity arrayPrototypeIdentity = new Neo4JObjectStoreSessionIdentity(null, transaction, arrayPrototypeIdentityStatementGenerator, 0);
        SessionStrategy<T> sessionStrategy = new ComposedSessionStrategy<>();
        
        return new Neo4JObjectStoreSession(rootIdentityStatementGenerator, arrayPrototypeIdentity, factory, compiler, sessionStrategy, session, transaction, console);
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }
}
