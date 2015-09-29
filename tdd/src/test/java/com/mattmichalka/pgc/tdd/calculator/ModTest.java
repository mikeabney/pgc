package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mattmichalka.pgc.tdd.calculator.ThrowableCaptor.captureThrowable;
import static org.hamcrest.CoreMatchers.instanceOf;

public class ModTest {
    Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void shouldModuloTwoNumbersAndReturnCorrectResult(){
        calc.push(4);
        calc.push(5);
        calc.mod();

        Assert.assertEquals(4, calc.value(), 0.000001d);
    }

    @Test
    public void shouldModuloThreeNumbersTogetherCorrectly(){
        calc.push(4);
        calc.push(5);
        calc.push(20);
        calc.mod();
        calc.mod();

        Assert.assertEquals(4, calc.value(), 0.000001d);
    }

    @Test
    public void shouldModuloNegativeDividendCorrectly(){
        calc.push(-4);
        calc.push(5);
        calc.mod();

        Assert.assertEquals(-4, calc.value(), 0.000001d);
    }

    @Test
    public void shouldModuloNegativeDivisorNumbersCorrectly(){
        calc.push(4);
        calc.push(-5);
        calc.mod();

        Assert.assertEquals(4, calc.value(), 0.000001d);
    }

    @Test
    public void shouldThrowExceptionWhenOnlyOneValueOnStack(){
        calc.push(20);
        Throwable modulo = captureThrowable(calc::mod);

        Assert.assertThat(modulo, instanceOf(NotEnoughValuesInStackException.class));
    }
}
