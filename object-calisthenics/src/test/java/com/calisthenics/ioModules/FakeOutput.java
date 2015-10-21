package com.calisthenics.ioModules;

import com.calisthenics.StringResult;
import com.calisthenics.ioModules.base.output.OutputLine;
import com.calisthenics.ioModules.base.output.OutputModule;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class FakeOutput implements OutputModule {

    public static StringResult output;
    public StringBuilder outputQueue;

    public FakeOutput(OutputLine... newLines) {
        outputQueue = new StringBuilder();
        appendListToOutput(newLines);
    }

    public FakeOutput(FakeOutput previousOutput, OutputLine... newLines) {
        outputQueue = previousOutput.outputQueue;
        appendListToOutput(newLines);
    }

    private void appendListToOutput(OutputLine[] newLines) {
        for (OutputLine line : newLines) {
            outputQueue.append(line);
        }
    }

    @Override
    public void processToOutput() {
        output = new StringResult(outputQueue.toString());
    }
}
