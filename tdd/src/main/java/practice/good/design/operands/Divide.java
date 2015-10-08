package practice.good.design.operands;

/**
 * Created by zacharycannon on 10/8/15.
 */
public class Divide extends Operand {

    public Divide() {
        super("/");
    }

    @Override
    public Integer evaluate(int input1, int input2) {
        return Math.floorDiv(input1, input2);
    }
}
