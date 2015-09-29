package com.bud.pgc.tdd.calculator;

import java.util.DoubleSummaryStatistics;
import java.util.Stack;

/**
 * Created by Bud on 9/28/2015.
 */
public class Calculator {

    private Stack<Double> numberStack;

    public Calculator(){
        this.numberStack = new Stack<Double>();
    }

    public Calculator push(double operand) {
        this.numberStack.push(operand);
        return this;
    }

    public Calculator add() {
        Double second = this.rpnPop();
        Double first = this.rpnPop();
        Double result = first + second;
        this.pushValuesBack(first, second, result);
        return this;
    }

    public Calculator multiply() {
        Double second = this.rpnPop();
        Double first = this.rpnPop();
        Double result = first * second;
        this.pushValuesBack(first, second, result);
        return this;
    }

    public Calculator subtract(){
        Double second = this.rpnPop();
        Double first = this.rpnPop();
        Double result = first - second;
        this.pushValuesBack(first, second, result);
        return this;
    }

    public Calculator divide() {
        Double second = this.rpnPop();
        Double first = this.rpnPop();
        Double result = first / second;
        this.pushValuesBack(first, second, result);
        return this;
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
        return (this.numberStack.isEmpty()) ? 0 : this.numberStack.pop();
    }

    private void pushValuesBack(Double first, Double second, Double result){
        this.numberStack.push(first);
        this.numberStack.push(second);
        this.numberStack.push(result);
    }
}
