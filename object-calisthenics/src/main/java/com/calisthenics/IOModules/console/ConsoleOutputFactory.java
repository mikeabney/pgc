package com.calisthenics.ioModules.console;

import com.calisthenics.ioModules.OutputLine;
import com.calisthenics.ioModules.OutputModule;
import com.calisthenics.ioModules.OutputModuleFactory;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class ConsoleOutputFactory implements OutputModuleFactory {

    @Override
    public OutputModule create() {
        return new ConsoleOutput();
    }

    @Override
    public OutputModule createFromPrevious(OutputModule previousOutput) {
        return new ConsoleOutput((ConsoleOutput)previousOutput);
    }

    @Override
    public OutputModule createWithNewLine(OutputModule previousOutput, OutputLine newLine) {
        return new ConsoleOutput((ConsoleOutput)previousOutput, newLine);
    }
}
