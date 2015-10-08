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
    public void pushingEqualsOperandWillEvaluateStackWithOneOperand() {
        calculator.pushInput(6);
        calculator.pushOperand(new Add());
        calculator.pushInput(7);

        calculator.pushOperand(new Equals());

        checkDisplay("13");
    }

    @Test
    public void pushingEqualsOperandWillEvaluateEntireStackWorthOfAddOperands() {
        calculator.pushInput(6);
        calculator.pushOperand(new Add());
        calculator.pushInput(7);
        calculator.pushOperand(new Add());
        calculator.pushInput(8);

        calculator.pushOperand(new Equals());

        checkDisplay("21");
    }

    @Test
    public void pushingEqualsOperandWillEvaluateEntireStackWorthOfAddAndSubtractOperands() {
        calculator.pushInput(12);
        calculator.pushOperand(new Subtract());
        calculator.pushInput(4);
        calculator.pushOperand(new Add());
        calculator.pushInput(5);

        calculator.pushOperand(new Equals());

        checkDisplay("3");
    }

    private void checkDisplay(String expectedDisplayValue) {
        assertEquals(expectedDisplayValue, calculator.getDisplay());
    }
}
