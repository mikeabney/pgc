package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mattmichalka.pgc.tdd.calculator.ThrowableCaptor.captureThrowable;
import static org.hamcrest.CoreMatchers.instanceOf;

public class PopTest {
    Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void shouldThrowExceptionWhenNoValueIsOnStack(){
        Throwable pop = captureThrowable(calc::pop);

        Assert.assertThat(pop, instanceOf(NotEnoughValuesInStackException.class));
    }

    @Test
    public void shouldRemoveTopValueFromStack(){
        calc.push(3);
        calc.push(4);
        calc. pop();

        Assert.assertEquals(3, calc.value(), 0.000001d);
    }
}
