package com.dancary.pgc.tdd.calculator;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by caryd on 9/28/2015.
 */
public class AddTest {
    @Test
    public void ShouldAddTwoNumbersAndReturnCorrectResult(){
        Calculator calculator = new Calculator();
        calculator.push(4);
        calculator.push(5);
        calculator.add();
        Assert.assertEquals(9, calculator.value(), 0.000001d);
    }

    //hamcrest???? look up.

    //Make homework from tdd, commit locally and push to branch. Due Friday October 9th.
}
