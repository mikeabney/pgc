package practice.good.design.operands;

/**
 * Created by zacharycannon on 10/8/15.
 */
public abstract class Operand {

    private String displayValue;

    public Operand(String displayValue) {
        this.displayValue = displayValue;
    }

    public String toString() {
        return this.displayValue;
    }

    public abstract Integer evaluate(int input1, int input2);

}
