/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.jsop.jsonish;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author jakob
 */
public class Frame {
    private Frame callsite;
    private int ip;
    private Instruction[] instructions;
    private Stack<Object>stack = new Stack<>();
    private JSONObjectFactory factory;
    private JSONObjectBroker broker;

    public Frame(Frame callsite, Instruction[] instructions, JSONObjectFactory factory, JSONObjectBroker broker) {
        this.callsite = callsite;
        this.instructions = instructions;
        this.factory = factory;
        this.broker = broker;
    }
    
    public void evaluate(Machine machine) {
        instructions[ip].evaluate(machine);
    }
    
    public void incIP() {
        ip++;
    }

    public void setIP(int index) {
        ip = index;
    }

    public void pushBoolean(boolean b) {
        stack.push(broker.getBoolean(b));
    }

    // Could be combined with machine e.g. machine.pushString(frame, string);
    public void pushString(String str) {
        stack.push(factory.newString(str));
    }

    // Could be combined with machine e.g. machine.pushString(frame, number);
    public void pushNumber(double d) {
        stack.push(factory.newNumber(d));
    }

    // Could be combined with machine e.g. frame.push(machine.getGlobal);
    public void pushGlobal() {
        stack.push(broker.getGlobal());
    }

    // Could be combined with machine e.g. frame.push(machine.getUndefined);
    public void pushUndefined() {
        stack.push(broker.undefined());
    }

    public void pushObject(Object obj) {
        stack.push(obj);
    }

    public Object peek() {
        return stack.peek();
    }

    public void dup() {
        stack.push(stack.peek());
    }

    public void dup2() {
        stack.add(stack.size() - 2, stack.peek());
    }

    public void dup3() {
        stack.add(stack.size() - 3, stack.peek());
    }

    public void dupFrom2() {
        stack.add(stack.get(stack.size() - 2));
    }

    public Object pop() {
        return stack.pop();
    }

    public void swap() {
        Object tmp = stack.peek();
        stack.set(stack.size() - 1, stack.get(stack.size() - 2));
        stack.set(stack.size() - 2, tmp);
    }

    public void swap2() {
        Object tmp = stack.peek();
        stack.set(stack.size() - 1, stack.get(stack.size() - 3));
        stack.set(stack.size() - 3, tmp);
    }

    public Frame getCallsite() {
        return callsite;
    }

    public void load(int ordinal) {
        stack.push(stack.get(ordinal));
    }

    public void store(int ordinal) {
        stack.set(ordinal, stack.pop());
    }

    @Override
    public String toString() {
        return Arrays.toString(instructions);
    }
}
