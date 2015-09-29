package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;

import java.util.Stack;

public class Calculator {
    private Stack<Double> operands = new Stack<>();

    public void push(double i) {
        operands.push(i);
    }

    public void pop() {
        checkForOperands(1);
        operands.pop();
    }

    public double value() {
        checkForOperands(1);
        return operands.peek();
    }

    public void clear() {
        operands.clear();
    }

    public void add() {
        checkForOperands(2);
        operands.push(operands.pop() + operands.pop());
    }

    public void mult() {
        checkForOperands(2);
        operands.push(operands.pop() * operands.pop());
    }

    public void sub() {
        checkForOperands(2);
        operands.push(-operands.pop() + operands.pop());
    }

    public void div() {
        checkForOperands(2);
        double divisor = operands.pop();
        operands.push(operands.pop()/divisor);
    }

    public void mod() {
        checkForOperands(2);
        double modulus = operands.pop();
        operands.push(operands.pop()%modulus);
    }

    public void swap() {
        checkForOperands(2);
        double a = operands.pop();
        double b = operands.pop();
        operands.push(a);
        operands.push(b);
    }

    public void dup() {
        checkForOperands(1);
        operands.push(operands.peek());
    }

    private void checkForOperands(int num){
        if(operands.size() < num) {
            throw new NotEnoughValuesInStackException(num);
        }
    }
}
