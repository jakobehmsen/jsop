/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.objectstore;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author jakob
 */
public class CustomFunctionObjectSession extends FunctionObjectSession {
    private CompiledCode compiledCode;

    public CustomFunctionObjectSession(ObjectStoreSession<ObjectSession> session, String sourceCode, String[] parameterNames) {
        super(session);
        
        set("prototype", session.getFactory().newMap(session));
        set("sourceCode", session.getFactory().newString(sourceCode));
        set("parameterNames", session.getFactory().newString(Arrays.asList(parameterNames).stream().collect(Collectors.joining(","))));
        
        initialize();
    }

    public CustomFunctionObjectSession(ObjectStoreSession<ObjectSession> session, ObjectStoreSessionIdentity identity) {
        super(session, identity);
        
        initialize();
    }

    public String getSourceCode() {
        return ((StringObjectSession)get("sourceCode")).getValue();
    }

    public String[] getParameterNames() {
        String[] parameterNames = ((StringObjectSession)get("parameterNames")).getValue().split(",");
        
        return Arrays.asList(parameterNames).stream()
                .filter(s -> !s.equals(""))
                .toArray(s -> new String[s]);
    }
    
    private void initialize() {
        compiledCode = new CompiledCode() {
            @Override
            public void apply(ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
                String sourceCode = getSourceCode();
                compiledCode = getSession().compile(sourceCode, getParameterNames());
                
                compiledCode.apply(applicationContext, self, arguments);
            }
        };
    }

    @Override
    protected int identityFlags() {
        return 2;
    }

    @Override
    public String toString() {
        return "function(" + 
                Arrays.asList(getParameterNames()).stream().collect(Collectors.joining(", ")) +
                ") {" + getSourceCode() + "}";
    }

    @Override
    public void apply(ObjectStoreSession<ObjectSession> session, ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
        compiledCode.apply(applicationContext, self, arguments);
    }
}
