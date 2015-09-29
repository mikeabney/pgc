package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mattmichalka.pgc.tdd.calculator.ThrowableCaptor.captureThrowable;
import static org.hamcrest.CoreMatchers.instanceOf;

public class ClearTest {
    Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void shouldEmptyStackWhenCleared(){
        calc.push(1);
        calc.push(2);
        calc.clear();

        Throwable empty = captureThrowable(calc::value);

        Assert.assertThat(empty, instanceOf(NotEnoughValuesInStackException.class));
    }
}
