package com.bud.pgc.tdd.calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Bud on 9/28/2015.
 */
public class CalculatorTest {
    @Test
    public void sholdBeAbleToAddNumbers(){
        Calculator calculator = new Calculator();
        calculator.push(4);
        calculator.push(5);
        calculator.add();
        Assert.assertEquals(9d, calculator.value(), 0.000001d);
    }
}

