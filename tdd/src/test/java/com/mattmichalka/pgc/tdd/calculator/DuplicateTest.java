package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mattmichalka.pgc.tdd.calculator.ThrowableCaptor.captureThrowable;
import static org.hamcrest.CoreMatchers.instanceOf;

public class DuplicateTest {
    Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void shouldThrowExceptionWhenNoValueIsOnStack(){
        Throwable duplicate = captureThrowable(calc::dup);

        Assert.assertThat(duplicate, instanceOf(NotEnoughValuesInStackException.class));
    }

    @Test
    public void shouldDuplicateTopValue(){
        calc.push(3);
        calc.dup();
        Assert.assertEquals(3, calc.value(), 0.000001d);
        calc.pop();
        Assert.assertEquals(3, calc.value(), 0.000001d);
    }
}
