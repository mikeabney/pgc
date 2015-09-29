package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;

import java.util.Stack;

public class Calculator {
    private Stack<Double> operands = new Stack<>();

    public void push(double i) {
        operands.push(i);
    }

    public double value() {
        checkForOperands(1);
        return operands.peek();
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
        double divisor = operands.pop();
        operands.push(operands.pop()/divisor);
    }

    private void checkForOperands(int num){
        if(operands.size() < num) {
            throw new NotEnoughValuesInStackException(num);
        }
    }
}
