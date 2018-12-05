/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore.neo4j;

import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.company.jsop.objectstore.ObjectStoreIdentity;
import com.company.jsop.objectstore.ObjectStoreSession;
import com.company.jsop.objectstore.ObjectStoreSessionIdentity;
import com.company.jsop.objectstore.SlotVisitor;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.StatementRunner;
import static org.neo4j.driver.v1.Values.parameters;
import org.neo4j.driver.v1.types.Node;

/**
 *
 * @author jakob
 */
public class Neo4JObjectStoreSessionIdentity implements ObjectStoreSessionIdentity {
    private Neo4JObjectStoreSession objectStoreSession;
    private StatementRunner session;
    private StatementGenerator statementGenerator;
    private int tags;

    public Neo4JObjectStoreSessionIdentity(Neo4JObjectStoreSession objectStoreSession, StatementRunner session, StatementGenerator statementGenerator, int tags) {
        this.objectStoreSession = objectStoreSession;
        this.session = session;
        this.statementGenerator = statementGenerator;
        this.tags = tags;
    }

    @Override
    public void setString(String slot, String str) {
        setAtomicValue(slot, str);
    }

    @Override
    public void setNumber(String slot, double d) {
        setAtomicValue(slot, d);
    }
    
    private Hashtable<String, Object> newAtomicValues = new Hashtable<>();
    
    private void setAtomicValue(String slot, Object value) {
        newAtomicValues.put(slot, value);
        objectStoreSession.identityChanged(this);
    }
    
    public void performChanges() {
        if(newAtomicValues.size() > 0) {
            String newAtomicValuesTransaction = 
                    statementGenerator.generateMatch("o") +
                    newAtomicValues.entrySet().stream()
                        .map(e -> " SET o.`" + e.getKey() + "` = $" + e.getKey())
                        .collect(Collectors.joining("\n"));
            Object[] parametersAndValues = newAtomicValues.entrySet().stream()
                    .flatMap(e -> Stream.of(e.getKey(), e.getValue()))
                    .toArray(s -> new Object[s]);
            session.run(newAtomicValuesTransaction, parameters(parametersAndValues));
        }
    }

    @Override
    public void setReference(String slot, ObjectStoreSessionIdentity identity) {
        // Prefix slot
        String transaction = statementGenerator.generateMatch("o1") + " " + ((Neo4JObjectStoreSessionIdentity) identity).statementGenerator.generateMatch("o2") + " CREATE (o1)-[:`" + slot + "`]->(o2)";
        session.run(transaction);
    }

    @Override
    public void deleteString(String slot) {
        deleteAtomicValue(slot);
    }

    @Override
    public void deleteNumber(String slot) {
        deleteAtomicValue(slot);
    }
    
    private void deleteAtomicValue(String slot) {
        if(newAtomicValues.containsKey(slot)) {
            newAtomicValues.remove(slot);
        } else {
            session.run(statementGenerator.generateMatch("o") + " REMOVE o.`" + slot + "`");
        }
    }

    @Override
    public void deleteIdentity(String slot) {
        String referencesQuery = statementGenerator.generateMatch("o") + " MATCH (o)-[r:" + slot + "]->() DELETE r";
        session.run(referencesQuery);
    }

    @Override
    public void getSlots(SlotVisitor visitor) {
        session.run(statementGenerator.generateMatch("o") + " return o");
        Node res = session.run(statementGenerator.generateMatch("o") + " return o").single().get(0).asNode();
        res.asMap().entrySet().stream()
                .filter(e -> !e.getKey().equals("flags"))
                .forEach((java.util.Map.Entry<java.lang.String, java.lang.Object> e) -> {
            Object v = e.getValue();
            if (v instanceof String) {
                visitor.visitString(e.getKey(), (String) v);
            } else if (v instanceof Number) {
                visitor.visitNumber(e.getKey(), ((Number)v).doubleValue());
            } else {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        String referencesQuery = statementGenerator.generateMatch("o") + " MATCH (o)-[r]->(other) RETURN TYPE(r), ID(other), other.flags";
        StatementResult sr = session.run(referencesQuery);
        while (sr.hasNext()) {
            Record r = sr.next();
            String name = r.get(0).asString();
             // Expect prefixed slot
            int id = r.get(1).asInt();
            int flags = r.get(2).isNull() ? 0 : r.get(2).asInt();
            visitor.visitIdentity(name, new Neo4JObjectStoreSessionIdentity(objectStoreSession, session, new IdStatementGenerator(id), flags));
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Neo4JObjectStoreSessionIdentity 
                ? statementGenerator.equals(((Neo4JObjectStoreSessionIdentity)obj).statementGenerator) 
                : false;
    }

    @Override
    public int hashCode() {
        return statementGenerator.hashCode();
    }

    @Override
    public ObjectStoreIdentity withoutSession() {
        int flags = getFlags();
            
        return new ObjectStoreIdentity() {
            @Override
            public ObjectStoreSessionIdentity forSession(ObjectStoreSession session) {
                return ((Neo4JObjectStoreSession)session).newIdentity(flags, statementGenerator);
            }
        };
    }

    @Override
    public int getFlags() {
        return tags;
    }
    
    public interface StatementGenerator {
        String generateMatch(String var);
    }
    
    public static class IdStatementGenerator implements StatementGenerator {
        private int id;

        public IdStatementGenerator(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return this.id;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof IdStatementGenerator 
                    ? id == ((IdStatementGenerator)obj).id 
                    : false;
        }

        @Override
        public String generateMatch(String var) {
            return "MATCH (" + var + ":Object) WHERE ID(" + var + ") = " + id;
        }

        @Override
        public String toString() {
            return generateMatch("?");
        }
    }
    
    public static class LabelsStatementGenerator implements StatementGenerator {
        private String labels;

        public LabelsStatementGenerator(String labels) {
            this.labels = labels;
        }
        
        private String formatLabels() {
            return labels;
        }

        @Override
        public int hashCode() {
            return labels.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof LabelsStatementGenerator 
                    ? labels.equals(((LabelsStatementGenerator)obj).labels)
                    : false;
        }

        @Override
        public String generateMatch(String var) {
            return "MATCH (" + var + formatLabels() + ")";
        }

        @Override
        public String toString() {
            return generateMatch("?");
        }
    }
}
