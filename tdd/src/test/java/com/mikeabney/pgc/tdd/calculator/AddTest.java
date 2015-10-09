package com.mikeabney.pgc.tdd.calculator;

import org.junit.Test;
import org.junit.Assert;

public class AddTest {
    @Test
    public void shouldAddTwoNumbersAndReturnCorrectResult() {
        Calculator calculator = new Calculator();
        calculator.push(4);
        calculator.push(5);
        calculator.add();

        Assert.assertEquals(9d, calculator.value(), 0.000001);
    }

}
