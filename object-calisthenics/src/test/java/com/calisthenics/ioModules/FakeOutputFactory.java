package com.calisthenics.ioModules;

import com.calisthenics.ioModules.base.output.OutputLine;
import com.calisthenics.ioModules.base.output.OutputModule;
import com.calisthenics.ioModules.base.output.OutputModuleFactory;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class FakeOutputFactory implements OutputModuleFactory {

    @Override
    public OutputModule create(OutputLine... lines) {
        return new FakeOutput(lines);
    }

    @Override
    public OutputModule createFromExisting(OutputModule existingOutput, OutputLine... lines) {
        return new FakeOutput((FakeOutput) existingOutput, lines);
    }
}
