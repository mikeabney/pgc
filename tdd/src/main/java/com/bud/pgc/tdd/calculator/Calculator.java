package com.bud.pgc.tdd.calculator;

import java.util.Stack;

/**
 * Created by Bud on 9/28/2015.
 */
public class Calculator {
    private interface Operation {
        public Double operate(Double operand1, Double operand2);
    }

    private Stack<Double> numberStack;

    public Calculator(){
        this.numberStack = new Stack<Double>();
    }

    public Calculator push(double operand) {
        this.numberStack.push(operand);
        return this;
    }

    public Calculator add() {
        this.operate((first, second) -> first + second);
        return this;
    }

    public Calculator multiply() {
        this.operate((first, second) -> first * second);
        return this;
    }

    public Calculator subtract(){
        this.operate((first, second) -> first - second);
        return this;
    }

    public Calculator divide() {
        this.operate((first, second) -> first / second);
        return this;
    }

    public void operate(Operation operation) {
        Double second = this.rpnPop();
        Double first = this.rpnPop();
        Double result = operation.operate(first, second);
        this.pushValuesBack(first, second, result);
    }

    public double value() {
        return (this.numberStack.isEmpty()) ? 0 : this.numberStack.peek();
    }

    public Calculator clear(){
        this.rpnPop();
        return this;
    }

    public Calculator clearAll(){
        this.numberStack = new Stack<Double>();
        return this;
    }

    private Double rpnPop() {
        return (this.numberStack.isEmpty()) ? 0d : this.numberStack.pop();
    }

    private void pushValuesBack(Double first, Double second, Double result){
        this.numberStack.push(first);
        this.numberStack.push(second);
        this.numberStack.push(result);
    }
}
