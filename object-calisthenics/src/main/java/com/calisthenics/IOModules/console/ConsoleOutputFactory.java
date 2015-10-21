package com.calisthenics.ioModules.console;

import com.calisthenics.ioModules.base.IOModule;
import com.calisthenics.ioModules.base.output.OutputLine;
import com.calisthenics.ioModules.base.output.OutputModule;
import com.calisthenics.ioModules.base.output.OutputModuleFactory;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class ConsoleOutputFactory implements OutputModuleFactory {

    @Override
    public OutputModule create(OutputLine... newLines) {
        return new ConsoleOutput(newLines);
    }

    @Override
    public OutputModule createFromExisting(OutputModule existingOutput, OutputLine... lines) {
        return new ConsoleOutput((ConsoleOutput) existingOutput, lines);
    }
}
