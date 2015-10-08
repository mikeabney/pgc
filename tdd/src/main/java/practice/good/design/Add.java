package practice.good.design;

/**
 * Created by zacharycannon on 10/8/15.
 */
public class Add extends Operand {

    public Add() {
        super("+");
    }

    @Override
    public Integer evaluate(int input1, int input2) {
        return Math.addExact(input1, input2);
    }

}
