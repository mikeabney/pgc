package com.calisthenics.ioModules.base;

import com.calisthenics.ioModules.base.input.InputModule;
import com.calisthenics.ioModules.base.input.InputModuleFactory;
import com.calisthenics.ioModules.base.output.OutputLine;
import com.calisthenics.ioModules.base.output.OutputModule;
import com.calisthenics.ioModules.base.output.OutputModuleFactory;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class IOModuleFactory {

    private final InputModuleFactory inputFactory;
    private final OutputModuleFactory outputFactory;

    public IOModuleFactory(InputModuleFactory inputFactory, OutputModuleFactory outputFactory) {
        this.inputFactory = inputFactory;
        this.outputFactory = outputFactory;
    }

    public IOModule build() {
        OutputModule output = outputFactory.create();
        return makeIOModule(output);
    }

    public IOModule build(OutputLine... messages) {
        OutputModule output = outputFactory.create(messages);
        return makeIOModule(output);
    }

    public IOModule buildFromExisting(IOModule io, OutputLine... lines) {
        OutputModule existingOutput = io.output;
        OutputModule output = outputFactory.createFromExisting(existingOutput, lines);
        return makeIOModule(output);
    }

    private IOModule makeIOModule(OutputModule output) {
        InputModule input = inputFactory.create();
        return new IOModule(input, output);
    }
}
