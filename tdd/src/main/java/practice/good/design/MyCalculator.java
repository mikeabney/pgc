package practice.good.design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zacharycannon on 10/8/15.
 */
public class MyCalculator {

    private String displayValue;
    private List<String> numberStack;
    private List<Operands> operandStack;

    public MyCalculator() {
        displayValue = "0";
        numberStack = new ArrayList<String>();
        operandStack = new ArrayList<Operands>();
    }

    public String getDisplay() {
        return displayValue;
    }

    public void pushInput(String input) {
        numberStack.add(input);
        displayValue = input;
    }

    public void pushOperand(Operands operand) {
        operandStack.add(operand);
        displayValue = operand.toString();
        if (operand.equals(Operands.EQUALS)) {
            evaluateStacks();
        }
    }

    private void evaluateStacks() {
        displayValue = "12";
    }
}

