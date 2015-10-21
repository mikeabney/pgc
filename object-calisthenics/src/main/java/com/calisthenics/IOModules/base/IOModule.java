package com.calisthenics.ioModules.base;

import com.calisthenics.ioModules.base.input.InputModule;
import com.calisthenics.ioModules.base.output.OutputModule;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class IOModule {

    public InputModule input;
    public OutputModule output;

    public IOModule(InputModule input, OutputModule output) {
        this.input = input;
        this.output = output;
    }
}
