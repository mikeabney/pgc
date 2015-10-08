package practice.good.design.operands;

/**
 * Created by zacharycannon on 10/8/15.
 */
public class Subtract extends Operand {

    public Subtract() {
        super("-");
    }

    @Override
    public Integer evaluate(int input1, int input2) {
        return Math.subtractExact(input1, input2);
    }
}
