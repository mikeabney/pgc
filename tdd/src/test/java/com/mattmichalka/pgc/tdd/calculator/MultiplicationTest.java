package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mattmichalka.pgc.tdd.calculator.ThrowableCaptor.captureThrowable;
import static org.hamcrest.CoreMatchers.instanceOf;

public class MultiplicationTest {
    Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void shouldMultiplyTwoNumbersAndReturnCorrectResult(){
        calc.push(4);
        calc.push(5);
        calc.mult();

        Assert.assertEquals(20, calc.value(), 0.000001d);
    }

    @Test
    public void shouldThrowExceptionWhenOnlyOneValueOnStack(){
        calc.push(20);
        Throwable multiply = captureThrowable(calc::mult);

        Assert.assertThat(multiply, instanceOf(NotEnoughValuesInStackException.class));
    }

    @Test
    public void shouldMultiplyThreeNumbersTogetherCorrectly(){
        calc.push(4);
        calc.push(5);
        calc.push(20);
        calc.mult();
        calc.mult();

        Assert.assertEquals(400, calc.value(), 0.000001d);
    }

    @Test
    public void shouldMultiplyNegativeNumbersCorrectly(){
        calc.push(-4);
        calc.push(-5);
        calc.mult();

        Assert.assertEquals(20, calc.value(), 0.000001d);
    }
}
