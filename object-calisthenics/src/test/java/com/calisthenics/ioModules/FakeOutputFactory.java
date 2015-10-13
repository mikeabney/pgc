package com.calisthenics.ioModules;

import com.calisthenics.StringResult;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class FakeOutputFactory implements OutputModuleFactory {

    @Override
    public OutputModule create() {
        return new FakeOutput();
    }

    @Override
    public OutputModule createFromPrevious(OutputModule previousOutput) {
        return new FakeOutput((FakeOutput)previousOutput);
    }

    @Override
    public OutputModule createWithNewLine(OutputModule previousOutput, OutputLine newLine) {
        return new FakeOutput((FakeOutput)previousOutput, newLine);
    }
}
