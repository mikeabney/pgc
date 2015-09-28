package com.joshrizzo.pgc.tdd.calculator;

/**
 * Created by Joshua Cosimo Rizzo on 9/28/2015.
 */
public class Calculator {

    private double value = 0;

    public double value() {
        return value;
    }

    public void add(double operand) {
        value += operand;
    }

    public void subtract(int operand) {
        value -= operand;
    }

    public void multiply(int operand) {
        value *= operand;
    }

    public void divide(int operand) {
        value /= operand;
    }
}
