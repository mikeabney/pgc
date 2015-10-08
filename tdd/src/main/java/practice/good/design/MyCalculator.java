package practice.good.design;

import practice.good.design.operands.Equals;
import practice.good.design.operands.Operand;

import java.util.Stack;

/**
 * Created by zacharycannon on 10/8/15.
 */
public class MyCalculator {

    private String displayValue;
    private Stack<Integer> numberStack;
    private Stack<Operand> operandStack;

    public MyCalculator() {
        displayValue = "0";
        numberStack = new Stack<Integer>();
        operandStack = new Stack<Operand>();
    }

    public String getDisplay() {
        return displayValue;
    }

    public void pushInput(Integer input) {
        numberStack.push(input);
        displayValue = input.toString();
    }

    public void pushOperand(Operand operand) {
        operandStack.push(operand);
        displayValue = operand.toString();
        if (operand instanceof Equals) {
            operandStack.pop();
            evaluateStacks();
        }
    }

    private void evaluateStacks() {
        int numberOfOperands = operandStack.size();
        for (int i=0; i<numberOfOperands; i++) {
            int input2 = numberStack.pop();
            int input1 = numberStack.pop();
            Operand operand = operandStack.pop();

            Integer result = operand.evaluate(input1, input2);

            numberStack.push(result);
            displayValue = result.toString();
        }
    }

}

