package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mattmichalka.pgc.tdd.calculator.ThrowableCaptor.captureThrowable;
import static org.hamcrest.CoreMatchers.instanceOf;

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

    @Test
    public void shouldSubtractThreeNumbersFromEachOtherCorrectly(){
        calc.push(4);
        calc.push(5);
        calc.push(20);
        calc.sub();
        calc.sub();

        Assert.assertEquals(19, calc.value(), 0.000001d);
    }

    @Test
    public void shouldThrowExceptionWhenOnlyOneValueOnStack(){
        calc.push(20);
        Throwable subtract = captureThrowable(calc::sub);

        Assert.assertThat(subtract, instanceOf(NotEnoughValuesInStackException.class));
    }
}
