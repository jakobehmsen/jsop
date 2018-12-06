/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop;

import com.company.jsop.objectstore.ObjectStoreSession;
import com.company.jsop.objectstore.ObjectStoreDriver;
import com.company.jsop.objectstore.ObjectSession;
import com.company.jsop.objectstore.neo4j.Neo4JObjectStoreDriver;
import com.company.jsop.objectstore.neo4j.Neo4JObjectStoreSessionIdentity;
import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.RootPaneContainer;
import javax.swing.SwingWorker;
import com.company.jsop.jsonish.BlockCompileContext;
import com.company.jsop.jsonish.CompileContext;
import com.company.jsop.jsonish.Expression;
import com.company.jsop.jsonish.Frame;
import com.company.jsop.jsonish.GlobalCompileContext;
import com.company.jsop.jsonish.Instruction;
import com.company.jsop.jsonish.JSONObjectBroker;
import com.company.jsop.jsonish.JSONObjectFactory;
import com.company.jsop.jsonish.Machine;
import com.company.jsop.jsonish.Parser;
import com.company.jsop.jsonish.Script;
import com.company.jsop.jsonish.ScriptTreeWalker;
import com.company.jsop.objectstore.ApplicationContext;
import com.company.jsop.objectstore.CompiledCode;
import com.company.jsop.objectstore.DefaultObjectSessionFactory;
import com.company.jsop.objectstore.FunctionObjectSession;
import com.company.jsop.objectstore.FunctionObjectSessionInterface;
import com.company.jsop.objectstore.NativeFunctionObjectSession;
import com.company.jsop.objectstore.NativeFunctions;
import com.company.jsop.objectstore.ObjectSessionFactory;
import com.company.jsop.objectstore.Scope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Config;
import org.neo4j.driver.v1.GraphDatabase;

/**
 *
 * @author jakob
 */
public class Main {
    private static JSONObjectFactory createFactory(ObjectStoreSession oss) {
        return new JSONObjectFactory() {
            @Override
            public Object newMap() {
                return oss.getFactory().newMap(oss);
            }

            @Override
            public Object newString(String str) {
                return oss.getFactory().newString(str);
            }

            @Override
            public Object newNumber(double d) {
                return oss.getFactory().newNumber(d);
            }

            @Override
            public Object newArray() {
                ObjectSession arr = (ObjectSession) oss.getFactory().newArray(oss);
                ObjectSession arrPrototype = oss.getNativeFunction(NativeFunctions.Array.getCode()).get("prototype");

                arr.set("__proto__", arrPrototype);

                return arr;
            }

            @Override
            public Object newFunction(String type, String src, String[] parameterNames) {
                return oss.getFactory().newFunction(oss, src, parameterNames);
            }
        };
    }
    
    private static JSONObjectBroker createBroker(ObjectStoreSession oss) {
        return new JSONObjectBroker() {
            @Override
            public void set(Object obj, String id, Object value) {
                ((ObjectSession)obj).set(id, (ObjectSession) value);
            }

            @Override
            public Object get(Object obj, String slotToRead) {
                return ((ObjectSession)obj).get(slotToRead);
            }

            @Override
            public Object getDynamic(Object obj, Object slotToReadObj) {
                return ((ObjectSession)slotToReadObj).getAsSlotIn((ObjectSession)obj);
            }

            @Override
            public void setDynamic(Object obj, Object slotToWriteObj, Object value) {
                ((ObjectSession)slotToWriteObj).setAsSlotIn((ObjectSession)obj, (ObjectSession)value);
            }

            @Override
            public void setByOrdinal(Object obj, int i, Object item) {
                ((ObjectSession)obj).setByOrdinal(i, (ObjectSession)item);
            }

            @Override
            public Object getNativeObject(String name) {
                NativeFunctionObjectSession.Delegate f = NativeFunctions.getNativeObject(name);

                NativeFunctionObjectSession nativeFunction = oss.getNativeFunction(f.getCode());

                // "MERGE (:Object:NativeFunction {flags: " + f.getCode() + "})"

                return nativeFunction;
            }

            @Override
            public Object undefined() {
                return oss.getUndefined();
            }

            @Override
            public void declareVariable(Object scope, String name, Object value) {
                ((Scope)scope).declareVariable(name, (ObjectSession) value);
            }

            @Override
            public boolean isDeclared(Object scope, String name) {
                return ((Scope)scope).isDeclared(name);
            }

            @Override
            public void setVariable(Object scope, String id, Object value) {
                ((Scope)scope).setVariable(id, (ObjectSession) value);
            }

            @Override
            public Object getVariable(Object scope, String id) {
                return ((Scope)scope).getVariable(id);
            }

            @Override
            public Object add(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).arithAdd((ObjectSession)rhs);
            }

            @Override
            public Object subtract(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).arithSubtract((ObjectSession)rhs);
            }

            @Override
            public Object mult(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).arithMult((ObjectSession)rhs);
            }

            @Override
            public Object div(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).arithDiv((ObjectSession)rhs);
            }

            @Override
            public Object rem(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).arithRem((ObjectSession)rhs);
            }

            @Override
            public Object eq(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).equals(oss, (ObjectSession)rhs);
            }

            @Override
            public Object seq(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).equalsStrict(oss, (ObjectSession)rhs);
            }

            @Override
            public Object lessThan(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).compareLessThan(oss, (ObjectSession)rhs);
            }

            @Override
            public Object lessThanOrEqual(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).compareLessThanOrEqual(oss, (ObjectSession)rhs);
            }

            @Override
            public Object greaterThan(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).compareGreaterThan(oss, (ObjectSession)rhs);
            }

            @Override
            public Object greaterThanOrEqual(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).compareGreaterThanOrEqual(oss, (ObjectSession)rhs);
            }

            @Override
            public Object isIn(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).compareIsIn(oss, (ObjectSession)rhs);
            }

            @Override
            public Object isInstanceof(Object lhs, Object rhs) {
                //return ((ObjectSession)lhs).compareIsInstanceof((ObjectSession)rhs);
                throw new UnsupportedOperationException();
            }

            @Override
            public Object bor(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).bor(oss, (ObjectSession)rhs);
            }

            @Override
            public Object bxor(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).bxor(oss, (ObjectSession)rhs);
            }

            @Override
            public Object band(Object lhs, Object rhs) {
                return ((ObjectSession)lhs).band(oss, (ObjectSession)rhs);
            }

            @Override
            public boolean isFalse(Object obj) {
                return ((ObjectSession)obj).isFalsy();
            }

            @Override
            public Object getGlobal() {
                return oss.getRoot();
            }

            @Override
            public void apply(ApplicationContext applicationContext, Object applicable, Object self, Object[] arguments) {
                ((FunctionObjectSessionInterface)applicable).apply(oss, applicationContext, (ObjectSession)self, (ObjectSession[])arguments);
            }

            @Override
            public Object[] createArray(int length) {
                return new ObjectSession[length];
            }

            @Override
            public Object getBoolean(boolean b) {
                return oss.wrap(b);
            }
        };
    }
    
    private static BiFunction<ObjectStoreSession, ParserRuleContext, Script> createScriptFunction(Supplier<ScriptTreeWalker.BlockEvaluator> blockEvaluator) {
        return (oss, ctx) -> new ScriptTreeWalker(
                createFactory(oss), createBroker(oss),
                ctx,
                blockEvaluator.get()
        );
    }
    
    public static void main(String[] args) throws Exception { 
        Configuration configuration = new Configuration();       
        String uri = configuration.getUri();
        String user = configuration.getUser();
        String password = configuration.getPassword();
        
        ExecutorService executorService = Executors.newWorkStealingPool();
        
        BiFunction<ObjectStoreSession, ParserRuleContext, Script> evalScriptFunction = createScriptFunction(() -> new ScriptTreeWalker.BlockEvaluator() {
            @Override
            public Object evaluate(JSONObjectBroker broker, ScriptTreeWalker.Block block) {
                if(block.expressionCount() > 0) {
                    for(int i = 0; i < block.expressionCount() - 1; i++) {
                        block.evaluateExpression(i);
                    }

                    return block.evaluateExpression(block.expressionCount() - 1);
                } else {
                    return broker.undefined();
                }
            }

            @Override
            public void returnValue(Object obj) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        BiFunction<ObjectStoreSession, ParserRuleContext, Script> functionBodyScriptFunction = createScriptFunction(() -> new ScriptTreeWalker.BlockEvaluator() {
            private Object returnedValue;
            private boolean hasReturnedValue;
            
            @Override
            public Object evaluate(JSONObjectBroker broker, ScriptTreeWalker.Block block) {
                for(int i = 0; i < block.expressionCount(); i++) {
                    block.evaluateExpression(i);
                    
                    if(hasReturnedValue) {
                        return returnedValue;
                    }
                }

                return broker.undefined();
            }

            @Override
            public void returnValue(Object obj) {
                returnedValue = obj;
                hasReturnedValue = true;
            }
        });
        
        com.company.jsop.objectstore.Compiler compiler = new com.company.jsop.objectstore.Compiler() {
            @Override
            public CompiledCode compile(ObjectStoreSession<? extends ObjectSession> session, String src, String[] parameterNames) {
                Parser parser = new Parser(functionBodyScriptFunction);
                
                ArrayList<Instruction> instructionList = new ArrayList<>();
                
                BlockCompileContext blockCompileContext = new BlockCompileContext(parameterNames);
                Expression blockExpression = parser.parse2(src);
                blockExpression.compile(blockCompileContext, false).emit(instructionList);
                if(!blockExpression.hasReturn()) {
                    // Emit implicit return
                    instructionList.add(Instruction.Set.pushUndefined);
                    instructionList.add(Instruction.Set.ret);
                }
                Instruction[] instructions = instructionList.toArray(new Instruction[instructionList.size()]);
                
                return new CompiledCode() {
                    @Override
                    public void apply(ApplicationContext applicationContext, ObjectSession self, ObjectSession[] arguments) {
                        applicationContext.apply(instructions, self, arguments, blockCompileContext.getLocalCount());
                    }
                };
            }
        };
        
        final ObjectSessionFactory objectSessionFactory = new DefaultObjectSessionFactory();
        
        // MERGE (:Object:Root)
        // MERGE (:Object:ArrayPrototype)
        // MERGE (:Object:NativeFunction {flags: [100..999]})
        
        Future<ObjectStoreDriver<ObjectSession>> driverFuture = executorService.submit(() -> {
            Config config = Config.build()
                .withConnectionTimeout(10, TimeUnit.SECONDS)
                .toConfig();
            
            return new Neo4JObjectStoreDriver<>(
                GraphDatabase.driver(uri, AuthTokens.basic(user, password), config), 
                new Neo4JObjectStoreSessionIdentity.LabelsStatementGenerator(":Object:Root"),
                new Neo4JObjectStoreSessionIdentity.LabelsStatementGenerator(":Object:ArrayPrototype"),
                objectSessionFactory,
                compiler);
        });
        
        String mergeAllNativeFunctions = NativeFunctions.getAll().stream()
                .map(f -> "MERGE (:Object:NativeFunction {flags: " + f.getCode() + "})")
                .collect(Collectors.joining("\n"));
        System.out.println(mergeAllNativeFunctions);
        
        /*
        // Set all prototype properties for native functions
        try (ObjectStoreSession<ObjectSession> objectStoreSession = driverFuture.get().newSession()) {
            NativeFunctions.getAll().forEach(f -> {
                NativeFunctionObjectSession fo = objectStoreSession.getNativeFunction(f.getCode());
                System.out.println("f.getCode()=" + f.getCode());
                ObjectSession prototype = fo.get("prototype");
                if(prototype == objectStoreSession.getUndefined()) {
                    fo.set("prototype", objectStoreSession.getFactory().newMap(objectStoreSession));
                }
            });
            
            objectStoreSession.commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
        */
        
        /*try {
            try (ObjectStoreSession objectStoreSession = driverFuture.get().newSession()) {
                JSONObjectBroker broker = createBroker(objectStoreSession);
                JSONObjectFactory factory = createFactory(objectStoreSession);
                    
                Machine machine = new Machine(new Frame(new Instruction[] {
                    Instruction.Set.pushNumber(5),
                    Instruction.Set.halt
                }, factory, broker));
                machine.evaluate();

                objectStoreSession.commit();
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }*/
        
        JFrame frame = new JFrame();
        
        JTextPane sourceCodeTextPane = new JTextPane();
        JScrollPane sourceCodeScrollPane = new JScrollPane(sourceCodeTextPane);
        DefaultListModel<String> outcomesListModel = new DefaultListModel<>();
        JList<String> outcomesList = new JList(outcomesListModel);
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sourceCodeScrollPane, outcomesList);
        splitPane.setResizeWeight(0.5);
        
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(splitPane, BorderLayout.CENTER);
        
        sourceCodeTextPane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, Event.ALT_MASK), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RootPaneContainer root = (RootPaneContainer) frame.getRootPane().getTopLevelAncestor();
                root.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                root.getGlassPane().setVisible(true);
                
                try {
                    String src = sourceCodeTextPane.getText();
                    
                    try (ObjectStoreSession objectStoreSession = driverFuture.get().newSession()) {
                        CompileContext globalCompileContext = new GlobalCompileContext();
                        
                        Parser parser = new Parser(evalScriptFunction);
                        List<Instruction> instructions = new ArrayList<>();
                        parser.parse2(src).compile(globalCompileContext, true).emit(instructions);
                        // Add implicit return:
                        instructions.add(Instruction.Set.ret);
                        JSONObjectBroker broker = createBroker(objectStoreSession);
                        JSONObjectFactory factory = createFactory(objectStoreSession);

                        Frame haltingFrame = new Frame(null, new Instruction[]{null, Instruction.Set.halt}, factory, broker);
                        Frame initialFrame = new Frame(haltingFrame, instructions.stream().toArray(s -> new Instruction[s]), factory, broker);
                        initialFrame.pushObject(broker.getGlobal());
                        Machine machine = new Machine(initialFrame, factory, broker);
                        System.out.println("Before evaluate " + LocalTime.now());
                        machine.evaluate();
                        System.out.println("After evaluate " + LocalTime.now());
                        //PObject o =  objectStoreSessionFuture.get().getRoot();
                        ObjectSession result = (ObjectSession)machine.getFrame().peek();
                        outcomesListModel.insertElementAt(result.toString(), 0);
                        
                        System.out.println("Before commit " + LocalTime.now());
                        objectStoreSession.commit();
                        System.out.println("After commit " + LocalTime.now());
                    }
                    
                    /*try (ObjectStoreSession objectStoreSession = driverFuture.get().newSession()) {
                        Parser parser = new Parser(evalScriptFunction);
                        Script script = parser.parse(objectStoreSession, src);
                        Object o = objectStoreSession.getRoot();
                        //PObject o =  objectStoreSessionFuture.get().getRoot();
                        Object result = script.evaluate(Scope.wrap((ObjectSession) o), o);
                        outcomesListModel.insertElementAt(result.toString(), 0);
                        
                        objectStoreSession.commit();
                    }*/
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    root.getGlassPane().setCursor(null);
                    root.getGlassPane().setVisible(false);
                }
            }
        });
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new SwingWorker<String, Object>() {
                    @Override
                    protected String doInBackground() throws Exception {
                        RootPaneContainer root = (RootPaneContainer) frame.getRootPane().getTopLevelAncestor();
                        root.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        root.getGlassPane().setVisible(true);

                        try {
                            //sessionFuture.get().close();
                            driverFuture.get().close();
                        } catch (InterruptedException | ExecutionException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            ((JComponent)frame.getContentPane()).setCursor(null);
                            frame.dispose();
                        }

                        root.getGlassPane().setCursor(null);
                        root.getGlassPane().setVisible(false);
                        return null;
                    }
                }.execute();
            }
            
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
