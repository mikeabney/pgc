package com.calisthenics.ioModules;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public interface OutputModuleFactory {
    OutputModule create();
    OutputModule createFromPrevious(OutputModule previousOutput);
    OutputModule createWithNewLine(OutputModule previousOutput, OutputLine newLine);
}
