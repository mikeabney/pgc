package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mattmichalka.pgc.tdd.calculator.ThrowableCaptor.captureThrowable;
import static org.hamcrest.CoreMatchers.instanceOf;

public class PushTest {
    Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void shouldThrowExceptionWhenValueIsCheckedWithNothingPushed(){
        Throwable checkValue = captureThrowable(calc::value);

        Assert.assertThat(checkValue, instanceOf(NotEnoughValuesInStackException.class));
    }

    @Test
    public void shouldPushValueAndReturnValuePushed(){
        calc.push(3);
        Assert.assertEquals(3, calc.value(), 0.000001d);
    }
}
