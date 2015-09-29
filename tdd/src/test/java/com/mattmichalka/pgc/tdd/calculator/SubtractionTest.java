package com.mattmichalka.pgc.tdd.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubtractionTest {
    private Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void shouldSubtractTwoNumbersAndReturnCorrectResult(){
        calc.push(4);
        calc.push(5);
        calc.sub();

        Assert.assertEquals(-1, calc.value(), 0.000001d);
    }
}
