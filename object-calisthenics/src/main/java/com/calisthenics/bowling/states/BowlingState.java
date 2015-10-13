package com.calisthenics.bowling.states;

import com.calisthenics.ioModules.*;

import java.io.IOException;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public abstract class BowlingState {

    private static final String ERROR_MESSAGE = "Ooops... you fat fingered the keyboard!";
    private OutputModuleFactory outputFactory;
    private InputModuleFactory inputFactory;
    private InputModule input;
    private OutputModule output;
    protected InputLine parameter;

    public BowlingState(InputModuleFactory inputFactory, OutputModuleFactory outputFactory) {
        output = outputFactory.create();
        initialize(inputFactory, outputFactory);
    }

    public BowlingState(InputModuleFactory inputFactory, OutputModuleFactory outputFactory, BowlingState previousState) {
        OutputModule previousOutput = previousState.output;
        output = outputFactory.createFromPrevious(previousOutput);
        initialize(inputFactory, outputFactory);
    }

    private void initialize(InputModuleFactory inputFactory, OutputModuleFactory outputFactory) {
        this.outputFactory = outputFactory;
        this.inputFactory = inputFactory;
        input = inputFactory.create();
        setup();
        display();
        readInput();
    }

    private void readInput() {
        try {
            parameter = input.readInput();
        } catch (IOException fatFinger) {
            parameter = null;
            OutputLine errorLine = new OutputLine(ERROR_MESSAGE);
            output = outputFactory.createWithNewLine(output, errorLine);
        }
    }

    private void display() {
        output.processToOutput();
    }

    protected void addLine(OutputLine line) {
        output = outputFactory.createWithNewLine(output, line);
    }

    protected abstract void setup();

    public abstract BowlingState process();
}
