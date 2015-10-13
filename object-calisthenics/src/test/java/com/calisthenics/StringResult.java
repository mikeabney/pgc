package com.calisthenics;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class StringResult {

    private String string;

    public StringResult(String string) {
        this.string = string;
    }

    public boolean equals(String stringComparison) {
        return string.equals(stringComparison);
    }

    @Override
    public String toString() {
        return string;
    }
}
