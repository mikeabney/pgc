package com.joshrizzo.pgc.tdd.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joshua Cosimo Rizzo on 9/28/2015.
 */
public class addTest {

    @Test
    public void add4And5ShouldReturn9() {
        Calculator calc = new Calculator();
        calc.add(4);
        calc.add(5);
        assertEquals(9, calc.value(), 0.000001);
    }

    @Test
    public void add3And3ShouldReturn6() {
        Calculator calc = new Calculator();
        calc.add(3);
        calc.add(3);
        assertEquals(6, calc.value(), 0.000001);
    }

    @Test
    public void subtract3and2ShouldReturn1() {
        Calculator calc = new Calculator();
        calc.add(3);
        calc.subtract(2);
        assertEquals(1, calc.value(), 0.000001);
    }

    @Test
    public void subtract1and4ShouldReturnNegative3() {
        Calculator calc = new Calculator();
        calc.add(1);
        calc.subtract(4);
        assertEquals(-3, calc.value(), 0.000001);
    }

    @Test
    public void multiply3and2ShouldReturn6() {
        Calculator calc = new Calculator();
        calc.add(3);
        calc.multiply(2);
        assertEquals(6, calc.value(), 0.000001);
    }

    @Test
    public void multiply2and4ShouldReturn8() {
        Calculator calc = new Calculator();
        calc.add(2);
        calc.multiply(4);
        assertEquals(8, calc.value(), 0.000001);
    }

    @Test
    public void divide1and4ShouldReturnOneQuarter() {
        Calculator calc = new Calculator();
        calc.add(1);
        calc.divide(4);
        assertEquals(.25, calc.value(), 0.000001);
    }

    @Test
    public void chainsShouldWork() {
        Calculator calc = new Calculator();
        calc.add(2);
        calc.multiply(3);
        calc.divide(12);
        calc.subtract(1);
        assertEquals(-.5, calc.value(), 0.000001);
    }

    @Test
    public void repetitionsShouldWork() {
        Calculator calc = new Calculator();
        calc.add(2);                //2
        calc.add(3);                //3
        calc.multiply(4);           //20
        calc.multiply(2);           //40
        calc.add(1);                //41
        calc.subtract(2);           //39
        calc.subtract(3);           //36
        calc.divide(9);             //4
        calc.divide(2);             //2
        assertEquals(2, calc.value(), 0.000001);
    }
}
