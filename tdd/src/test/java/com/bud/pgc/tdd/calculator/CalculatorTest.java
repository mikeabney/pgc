package com.bud.pgc.tdd.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.DoubleSummaryStatistics;

/**
 * Created by Bud on 9/28/2015.
 */
public class CalculatorTest {
    private Calculator calculator;
    private Double errorMargin = 0.00000d;

    @Before
    public void Before(){
        this.calculator = new Calculator();
    }

    //region Operand Tests

    @Test
    public void valueWithNoOperandsReturns0(){
        Assert.assertEquals(0, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void valueWithOperandReturnsOperand(){
        this.calculator.push(4);
        Assert.assertEquals(4, this.calculator.value(), this.errorMargin);
    }

    public void valueWithTwoOperandsReturnsLastOperand(){
        this.calculator.push(4);
        this.calculator.push(7);
        Assert.assertEquals(7, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void valueDoesNotPop(){
        this.calculator.push(1).push(2);
        Double firstValue = this.calculator.value();
        Double secondValue = this.calculator.value();
        Assert.assertEquals(secondValue, firstValue, this.errorMargin);
        Assert.assertEquals(2, secondValue, this.errorMargin);
    }

    //endregion

    //region Addition Tests

    @Test
    public void addWithNoOperandsReturns0(){
        this.calculator.add();
        Assert.assertEquals(0, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void addWithOneOperandReturnsOperand(){
        this.calculator.push(5);
        this.calculator.add();
        Assert.assertEquals(5, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void addWithTwoOperandsReturnsAdditionValue(){
        this.calculator.push(4);
        this.calculator.push(5);
        this.calculator.add();
        Assert.assertEquals(9, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void addWithThreeValuesAddsLastTwo(){
        this.calculator.push(1);
        this.calculator.push(2);
        this.calculator.push(3);
        this.calculator.add();
        Assert.assertEquals(5, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void canAddNonIntegerValues(){
        this.calculator.push(4.5);
        this.calculator.push(3.25);
        this.calculator.add();
        Assert.assertEquals(7.75, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void multipleAddsKeepsAddingValues(){
        this.calculator.push(3);
        this.calculator.push(4);
        this.calculator.add();
        this.calculator.add();
        Assert.assertEquals(11, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void multipleAddsWithOneOperandKeepsAddingValues(){
        this.calculator.push(2);
        this.calculator.add();
        this.calculator.add();
        this.calculator.add();
        this.calculator.add();
        Assert.assertEquals(10, this.calculator.value(), this.errorMargin);
    }

    //endregion

    //region multiplication tests

    @Test
    public void multiplicationWithNoOperandsReturns0(){
        this.calculator.multiply();
        Assert.assertEquals(0, this.calculator.value(), this.errorMargin);
    }

    public void multiplicationWithOneOpperandReturns0(){
        this.calculator.push(4);
        this.calculator.multiply();
        Assert.assertEquals(0, this.calculator.value(), this.errorMargin);
    }

    public void multiplicationWithTwoOperandsReturnsMath(){
        this.calculator.push(4);
        this.calculator.push(5);
        this.calculator.multiply();
        Assert.assertEquals(20, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void multiplicationKeepsGoingAsWell(){
        this.calculator.push(5);
        this.calculator.push(4);
        this.calculator.multiply();
        this.calculator.multiply();
        Assert.assertEquals(80, this.calculator.value(), this.errorMargin);
    }

    //endregion

    //region fluent testing

    @Test
    public void FluentWorksOnPush(){
        this.calculator.push(4).push(11);
        Assert.assertEquals(11, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void FluentWorksOnAddAndMultiply(){
        this.calculator.push(1).push(2).add().multiply().add();
        Assert.assertEquals(9, this.calculator.value(), this.errorMargin);
    }

    //endregion

    //region clear testing

    @Test
    public void canClearLastValue(){
        this.calculator.push(4).push(5).clear();
        Assert.assertEquals(4, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void canClearMoreThanOne(){
        this.calculator.push(4).push(5).push(11).clear().clear();
        Assert.assertEquals(4, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void canClearAll(){
        this.calculator.push(4).push(5).push(7).push(9);
        this.calculator.clearAll();
        Assert.assertEquals(0, this.calculator.value(), this.errorMargin);
    }

    //endregion

    //region Subtraction testing

    @Test
    public void subtractionWithNoOperandsReturns0(){
        this.calculator.subtract();
        Assert.assertEquals(0, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void subtractWithOneOperandReturnsNegativeOperand(){
        this.calculator.push(4).subtract();
        Assert.assertEquals(-4, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void subtractWithTwoOperandsReturnsDifference(){
        this.calculator.push(11).push(4).subtract();
        Assert.assertEquals(7, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void subtractionKeepsGoingToo(){
        this.calculator.push(11).push(4).subtract().subtract();
        Assert.assertEquals(-3, this.calculator.value(), this.errorMargin);
    }

    //endregion

    //region division testing

    @Test
    public void divisionWithNoOperandReturnsNaN(){
        this.calculator.divide();
        Assert.assertEquals(Double.NaN, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void divisionWithOneOperandReturns0(){
        this.calculator.push(4).divide();
        Assert.assertEquals(0, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void divisionWithTwoOperandsDoesDivision(){
        this.calculator.push(8).push(4).divide();
        Assert.assertEquals(2, this.calculator.value(), this.errorMargin);
    }

    @Test
    public void divisionKeepsGoingToo(){
        this.calculator.push(16).push(8).divide().divide();
        Assert.assertEquals(4, this.calculator.value(), this.errorMargin);
    }

    //endregion teting
}

