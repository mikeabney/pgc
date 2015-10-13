package com.calisthenics.ioModules.console;

import com.calisthenics.ioModules.InputModuleFactory;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class ConsoleInputFactory implements InputModuleFactory {

    @Override
    public ConsoleInput create() {
        return new ConsoleInput();
    }
}
