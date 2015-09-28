package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mattmichalka.pgc.tdd.calculator.ThrowableCaptor.captureThrowable;
import static org.hamcrest.CoreMatchers.instanceOf;

public class AddTest {
    private Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void shouldAddTwoNumbersAndReturnCorrectResult(){
        calc.push(4);
        calc.push(5);
        calc.add();

        Assert.assertEquals(9, calc.value(), 0.000001d);
    }

    @Test
     public void shouldThrowExceptionWhenOnlyOneValueOnStack(){
        calc.push(20);
        Throwable add = captureThrowable(calc::add);

        Assert.assertThat(add,instanceOf(NotEnoughValuesInStackException.class));
    }

    @Test
    public void shouldAddThreeNumbersTogetherCorrectly(){
        calc.push(4);
        calc.push(5);
        calc.push(20);
        calc.add();
        calc.add();

        Assert.assertEquals(29, calc.value(), 0.000001d);
    }

    @Test
    public void shouldAddNegativeNumbersCorrectly(){
        calc.push(-4);
        calc.push(-5);
        calc.add();

        Assert.assertEquals(-9, calc.value(), 0.000001d);
    }

}
