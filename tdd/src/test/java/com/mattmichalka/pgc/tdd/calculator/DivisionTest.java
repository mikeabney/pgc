package com.mattmichalka.pgc.tdd.calculator;

import com.mattmichalka.pgc.tdd.calculator.exceptions.NotEnoughValuesInStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mattmichalka.pgc.tdd.calculator.ThrowableCaptor.captureThrowable;
import static org.hamcrest.CoreMatchers.instanceOf;

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

    @Test
    public void shouldDivideThreeNumbersTogetherCorrectly(){
        calc.push(8);
        calc.push(20);
        calc.push(5);
        calc.div();
        calc.div();

        Assert.assertEquals(2, calc.value(), 0.000001d);
    }

    @Test
    public void shouldDivideNegativeNumbersCorrectly(){
        calc.push(-4);
        calc.push(-5);
        calc.div();

        Assert.assertEquals(.80, calc.value(), 0.000001d);
    }

    @Test
    public void shouldThrowExceptionWhenOnlyOneValueOnStack(){
        calc.push(20);
        Throwable divide = captureThrowable(calc::div);

        Assert.assertThat(divide, instanceOf(NotEnoughValuesInStackException.class));
    }
}
