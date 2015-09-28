package com.mattmichalka.pgc.tdd.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InterOperatorTest {
    Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void shouldRespectOrderOperationsAddThenMultiply(){
        calc.push(3);
        calc.push(10);
        calc.push(2);
        calc.add();
        calc.mult();

        Assert.assertEquals(36, calc.value(), 0.000001d);
    }

    @Test
    public void shouldRespectOrderOfOperationsMultiplyThenAdd(){
        calc.push(3);
        calc.push(10);
        calc.push(2);
        calc.mult();
        calc.add();

        Assert.assertEquals(23, calc.value(), 0.000001d);
    }

}
