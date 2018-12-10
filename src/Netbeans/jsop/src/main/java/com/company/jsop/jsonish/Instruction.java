/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

import java.util.Arrays;
import java.util.List;
import com.company.jsop.objectstore.NativeFunctionObjectSession;

/**
 *
 * @author jakob
 */
public interface Instruction {
    void evaluate(Machine machine);
    
    public class Set {
        public static Instruction halt = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                throw new HaltException();
            }

            @Override
            public String toString() {
                return "halt";
            }
        };
        
        public static Instruction pushGlobal = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                machine.getFrame().pushGlobal();
                machine.getFrame().incIP();
            }

            @Override
            public String toString() {
                return "pushGlobal";
            }
        };
        
        public static Instruction pushUndefined = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                machine.getFrame().pushUndefined();
                machine.getFrame().incIP();
            }

            @Override
            public String toString() {
                return "pushUndefined";
            }
        };
        
        public static Instruction ret = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                Frame callsite = machine.getFrame().getCallsite();
                callsite.pushObject(machine.getFrame().pop());
                callsite.incIP();
                machine.setFrame(callsite);
            }

            @Override
            public String toString() {
                return "ret";
            }
        };
        
        public static Instruction pop = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                machine.getFrame().pop();
                machine.getFrame().incIP();
            }

            @Override
            public String toString() {
                return "pop";
            }
        };
        
        public static Instruction swap = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                machine.getFrame().swap();
                machine.getFrame().incIP();
            }

            @Override
            public String toString() {
                return "swap";
            }
        };
        
        public static Instruction swap2 = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                machine.getFrame().swap2();
                machine.getFrame().incIP();
            }

            @Override
            public String toString() {
                return "swap2";
            }
        };
        
        public static Instruction newInstance = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                Object instance = machine.newInstance();
                machine.getFrame().pushObject(instance);
                machine.getFrame().incIP();
            }
        };

        public static Instruction apply(int arity) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    Object[] arguments = machine.createArray(arity);
                    
                    for(int i = arity - 1; i >= 0; i--) {
                        arguments[i] = machine.getFrame().pop();
                    }
                    
                    Object applicable = machine.getFrame().pop();
                    Object self = machine.getFrame().pop();
                    
                    machine.apply(applicable, self, arguments);
                }

                @Override
                public String toString() {
                    return "apply";
                }
            };
        }

        public static Instruction pushNativeFunction(String name) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    Object nativeFunction = machine.getNativeFunction(name);
                    machine.getFrame().pushObject(nativeFunction);
                    machine.getFrame().incIP();
                }

                @Override
                public String toString() {
                    return "pushNativeFunction(" + name + ")";
                }
            };
        }

        public static Instruction pushCustomFunction(String type, String src, String[] parameterNames) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    Object customFunction = machine.createCustomFunction(type, src, parameterNames);
                    machine.getFrame().pushObject(customFunction);
                    machine.getFrame().incIP();
                }

                @Override
                public String toString() {
                    return "pushCustomFunction(" + type + ", " + src + ", " + Arrays.toString(parameterNames) + ")";
                }
            };
        }

        public static Instruction load(int ordinal) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    machine.getFrame().load(ordinal);
                    machine.getFrame().incIP();
                }

                @Override
                public String toString() {
                    return "load(" + ordinal + ")";
                }
            };
        }

        public static Instruction store(int ordinal) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    machine.getFrame().store(ordinal);
                    machine.getFrame().incIP();
                }

                @Override
                public String toString() {
                    return "store(" + ordinal + ")";
                }
            };
        }

        public static Instruction jumpIfFalsy(int index) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    Object obj = machine.getFrame().pop();
                    if(machine.isFalsy(obj)) {
                        machine.getFrame().setIP(index);
                    } else {
                        machine.getFrame().incIP();
                    }
                }

                @Override
                public String toString() {
                    return "jumpIfFalsy(" + index + ")";
                }
            };
        }

        public static Instruction jump(int index) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    machine.getFrame().setIP(index);
                }

                @Override
                public String toString() {
                    return "jump(" + index + ")";
                }
            };
        }

        public static Instruction pushBoolean(boolean b) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    machine.getFrame().pushBoolean(b);
                    machine.getFrame().incIP();
                }
            };
        }
        
        private static abstract class Binary implements Instruction {
            @Override
            public void evaluate(Machine machine) {
                Object rhs = machine.getFrame().pop();
                Object lhs = machine.getFrame().pop();
                Object result = evaluate(machine, lhs, rhs);
                machine.getFrame().pushObject(result);
                machine.getFrame().incIP();
            }
            
            protected abstract Object evaluate(Machine machine, Object lhs, Object rhs);
        }
        
        public static Instruction mult = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.mult(lhs, rhs);
            }

            @Override
            public String toString() {
                return "mult";
            }
        };
        
        public static Instruction div = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.div(lhs, rhs);
            }

            @Override
            public String toString() {
                return "div";
            }
        };
        
        public static Instruction rem = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.rem(lhs, rhs);
            }

            @Override
            public String toString() {
                return "rem";
            }
        };
        
        public static Instruction add = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.add(lhs, rhs);
            }

            @Override
            public String toString() {
                return "add";
            }
        };
        
        public static Instruction sub = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.sub(lhs, rhs);
            }

            @Override
            public String toString() {
                return "sub";
            }
        };
        
        public static Instruction eq = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.eq(lhs, rhs);
            }

            @Override
            public String toString() {
                return "eq";
            }
        };
        
        public static Instruction neq = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.neq(lhs, rhs);
            }

            @Override
            public String toString() {
                return "neq";
            }
        };
        
        public static Instruction seq = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.seq(lhs, rhs);
            }

            @Override
            public String toString() {
                return "seq";
            }
        };
        
        public static Instruction sneq = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.sneq(lhs, rhs);
            }

            @Override
            public String toString() {
                return "sneq";
            }
        };
        
        public static Instruction gt = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.gt(lhs, rhs);
            }

            @Override
            public String toString() {
                return "gt";
            }
        };
        
        public static Instruction gte = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.gte(lhs, rhs);
            }

            @Override
            public String toString() {
                return "gte";
            }
        };
        
        public static Instruction lt = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.lt(lhs, rhs);
            }

            @Override
            public String toString() {
                return "lt";
            }
        };
        
        public static Instruction lte = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.lte(lhs, rhs);
            }

            @Override
            public String toString() {
                return "lte";
            }
        };
        
        public static Instruction in = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.in(lhs, rhs);
            }

            @Override
            public String toString() {
                return "in";
            }
        };
        
        public static Instruction ino = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.ino(lhs, rhs);
            }

            @Override
            public String toString() {
                return "ino";
            }
        };
        
        public static Instruction or = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.or(lhs, rhs);
            }

            @Override
            public String toString() {
                return "or";
            }
        };
        
        public static Instruction and = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.and(lhs, rhs);
            }

            @Override
            public String toString() {
                return "and";
            }
        };
        
        public static Instruction bor = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.bor(lhs, rhs);
            }

            @Override
            public String toString() {
                return "bor";
            }
        };
        
        public static Instruction bxor = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.bxor(lhs, rhs);
            }

            @Override
            public String toString() {
                return "bxor";
            }
        };
        
        public static Instruction band = new Binary() {
            @Override
            protected Object evaluate(Machine machine, Object lhs, Object rhs) {
                return machine.band(lhs, rhs);
            }

            @Override
            public String toString() {
                return "band";
            }
        };

        public static Instruction pushString(String str) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    machine.getFrame().pushString(str);
                    machine.getFrame().incIP();
                }

                @Override
                public String toString() {
                    return "pushString(" + str + ")";
                }
            };
        }

        public static Instruction pushNumber(double d) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    machine.getFrame().pushNumber(d);
                    machine.getFrame().incIP();
                }

                @Override
                public String toString() {
                    return "pushNumber(" + d + ")";
                }
            };
        }
        
        public static Instruction dup = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                machine.getFrame().dup();
                machine.getFrame().incIP();
            }

            @Override
            public String toString() {
                return "dup";
            }
        };
        
        public static Instruction dup2 = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                machine.getFrame().dup2();
                machine.getFrame().incIP();
            }

            @Override
            public String toString() {
                return "dup2";
            }
        };
        
        public static Instruction dup3 = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                machine.getFrame().dup3();
                machine.getFrame().incIP();
            }

            @Override
            public String toString() {
                return "dup3";
            }
        };
        
        public static Instruction dupFrom2 = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                machine.getFrame().dupFrom2();
                machine.getFrame().incIP();
            }

            @Override
            public String toString() {
                return "dupFrom2";
            }
        };

        public static Instruction setPropertyValue(String name) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    Object value = machine.getFrame().pop();
                    Object obj = machine.getFrame().pop();
                    machine.setPropertyValue(obj, name, value);
                    machine.getFrame().incIP();
                }

                @Override
                public String toString() {
                    return "setPropertyValue(" + name + ")";
                }
            };
        }

        public static Instruction setPropertyValue(int ordinal) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    Object value = machine.getFrame().pop();
                    Object obj = machine.getFrame().pop();
                    machine.setPropertyValue(obj, ordinal, value);
                    machine.getFrame().incIP();
                }

                @Override
                public String toString() {
                    return "setPropertyValue(" + ordinal + ")";
                }
            };
        }
        
        public static Instruction setPropertyValueDynamic = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                Object name = machine.getFrame().pop();
                Object value = machine.getFrame().pop();
                Object obj = machine.getFrame().pop();
                machine.setPropertyValueDynamic(obj, name, value);
                machine.getFrame().incIP();
            }

            @Override
            public String toString() {
                return "setPropertyValueDynamic";
            }
        };

        public static Instruction getPropertyValue(String name) {
            return new Instruction() {
                @Override
                public void evaluate(Machine machine) {
                    Object obj = machine.getFrame().pop();
                    Object value = machine.getPropertyValue(obj, name);
                    machine.getFrame().pushObject(value);
                    machine.getFrame().incIP();
                }

                @Override
                public String toString() {
                    return "getPropertyValue(" + name + ")";
                }
            };
        }
        
        public static Instruction getPropertyValueDynamic = new Instruction() {
            @Override
            public void evaluate(Machine machine) {
                Object name = machine.getFrame().pop();
                Object obj = machine.getFrame().pop();
                Object value = machine.getPropertyValueDynamic(obj, name);
                machine.getFrame().pushObject(value);
                machine.getFrame().incIP();
            }

            @Override
            public String toString() {
                return "getPropertyValueDynamic";
            }
        };
    }
}
