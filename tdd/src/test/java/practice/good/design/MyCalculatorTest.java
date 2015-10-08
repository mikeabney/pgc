package practice.good.design;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zacharycannon on 10/8/15.
 */
public class MyCalculatorTest {

    private MyCalculator calculator;

    @Before
    public void setup() {
        calculator = new MyCalculator();
    }

    @Test
    public void initialDisplayShouldShowZero() {
        checkDisplay("0");
    }

    @Test
    public void pushingNumberOnToStackWillShowNumber() {
        calculator.pushInput(5);

        checkDisplay("5");
    }

    @Test
    public void pushingNumberAndOperandOnStackWillShowOperand() {
        calculator.pushInput(6);
        calculator.pushOperand(new Add());

        checkDisplay("+");
    }

    @Test
    public void pushingNumberAfterOperandAndNumberWillShowNumber() {
        calculator.pushInput(6);
        calculator.pushOperand(new Add());
        calculator.pushInput(6);

        checkDisplay("6");
    }

    @Test
    public void pushingEqualsOperandWillEvaluateStacks() {
        calculator.pushInput(6);
        calculator.pushOperand(new Add());
        calculator.pushInput(6);

        calculator.pushOperand(new Equals());

        checkDisplay("12");
    }

    private void checkDisplay(String expectedDisplayValue) {
        assertEquals(expectedDisplayValue, calculator.getDisplay());
    }
}
