package com.calisthenics.ioModules.base.output;

import com.calisthenics.ioModules.base.IOModule;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public interface OutputModuleFactory {
    OutputModule create(OutputLine... newLines);
    OutputModule createFromExisting(OutputModule existingOutput, OutputLine... lines);
}
