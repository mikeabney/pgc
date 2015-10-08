package practice.good.design;

/**
 * Created by zacharycannon on 10/8/15.
 */
public class Multiply extends Operand {

    public Multiply() {
        super("*");
    }

    @Override
    public Integer evaluate(int input1, int input2) {
        return Math.multiplyExact(input1, input2);
    }
}
