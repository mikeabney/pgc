package com.calisthenics.ioModules.base;

import com.calisthenics.ioModules.base.input.InputLine;
import com.calisthenics.ioModules.base.input.InputModule;
import com.calisthenics.ioModules.base.output.OutputModule;

import java.io.IOException;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public abstract class IOFlow {

    protected final IOModule io;

    protected IOFlow(IOModule io) {
        this.io = io;

        OutputModule output = io.output;

        output.processToOutput();
    }

    protected InputLine readInput() {
        InputModule input = io.input;
        try {
            return input.readInput();
        } catch (IOException inputException) {
            inputException.printStackTrace();
            return null;
        }
    }
}
