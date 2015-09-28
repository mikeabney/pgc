package com.mattmichalka.pgc.tdd.calculator.exceptions;

public class NotEnoughValuesInStackException extends RuntimeException {
    private int expectedNumberOfOperands;
    public NotEnoughValuesInStackException(int i){
        expectedNumberOfOperands = i;
    }
    public int getExpectedNumberOfOperands(){
        return expectedNumberOfOperands;
    }

}