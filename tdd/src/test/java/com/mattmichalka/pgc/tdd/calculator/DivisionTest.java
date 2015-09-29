package com.mattmichalka.pgc.tdd.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivisionTest {
    Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void shouldDivideFirstNumberBySecondNumberAndReturnCorrectResult(){
        calc.push(4);
        calc.push(5);
        calc.div();

        Assert.assertEquals(.80, calc.value(), 0.000001d);
    }
}
