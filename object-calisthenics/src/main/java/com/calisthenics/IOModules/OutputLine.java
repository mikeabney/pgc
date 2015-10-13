package com.calisthenics.ioModules;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class OutputLine {

    private final String line;

    public OutputLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return line;
    }
}
