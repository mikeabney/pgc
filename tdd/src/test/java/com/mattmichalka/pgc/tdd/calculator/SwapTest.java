package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mattmichalka.pgc.tdd.calculator.ThrowableCaptor.captureThrowable;
import static org.hamcrest.CoreMatchers.instanceOf;

public class SwapTest {
    Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void shouldThrowExceptionWhenValueIsCheckedWithLessThanTwoValuesPushed(){
        calc.push(1);

        Throwable swap = captureThrowable(calc::swap);

        Assert.assertThat(swap, instanceOf(NotEnoughValuesInStackException.class));
    }

    @Test
    public void shouldSwapLastTwoValuesOnStack(){
        calc.push(3);
        calc.push(4);
        calc.swap();

        Assert.assertEquals(3, calc.value(), 0.000001d);
    }
}
