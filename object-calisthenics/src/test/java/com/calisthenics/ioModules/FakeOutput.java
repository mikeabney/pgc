package com.calisthenics.ioModules;

import com.calisthenics.StringResult;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class FakeOutput implements OutputModule {

    public static StringResult output;
    public StringBuilder outputQueue;

    public FakeOutput() {
        outputQueue = new StringBuilder();
    }

    public FakeOutput(FakeOutput previousOutput) {
        outputQueue = previousOutput.outputQueue;
    }

    public FakeOutput(FakeOutput previousOutput, OutputLine newLine) {
        outputQueue = previousOutput.outputQueue;
        outputQueue.append(newLine);
    }

    @Override
    public void processToOutput() {
        output = new StringResult(outputQueue.toString());
    }
}
