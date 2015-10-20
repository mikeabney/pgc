package com.dancary.pgc.tdd.calculator;

import java.lang.reflect.Array;

/**
 * Created by caryd on 9/28/2015.
 */
public class Calculator {
    private Double[] numbersToAdd;

    public void push(double value) {
        int i = numbersToAdd.length;
        i += i+1;
        numbersToAdd[i] = value;
    }

    public double add(){
        Double total = 0.0;
        /*for (Double number : this.numberToAdd){
            total += number;
        }*/
        return this.value(total);
    }

    public double value(Double value){
        return value;
    }
}
