package com.mikeabney.pgc.tdd.calculator;

import org.junit.Test;
<<<<<<< HEAD

import static org.junit.Assert.assertEquals;
=======
import org.junit.Assert;
>>>>>>> Adding CurrencyConverter.

public class AddTest {
    @Test
    public void shouldAddTwoNumbersAndReturnCorrectResult() {
        Calculator calculator = new Calculator();
        calculator.push(4);
        calculator.push(5);
        calculator.add();
<<<<<<< HEAD
        assertEquals(9d, calculator.value(), 0.000001d);
    }
=======

        Assert.assertEquals(9d, calculator.value(), 0.000001);
    }

>>>>>>> Adding CurrencyConverter.
}
