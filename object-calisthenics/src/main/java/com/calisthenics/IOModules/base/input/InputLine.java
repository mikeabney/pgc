package com.calisthenics.ioModules.base.input;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class InputLine {

    private final String param;

    public InputLine(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return param;
    }
}
