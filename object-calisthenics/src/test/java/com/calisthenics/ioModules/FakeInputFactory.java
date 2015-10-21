package com.calisthenics.ioModules;

import com.calisthenics.ioModules.base.input.InputModule;
import com.calisthenics.ioModules.base.input.InputModuleFactory;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class FakeInputFactory implements InputModuleFactory {

    @Override
    public InputModule create() {
        return new FakeInput();
    }
}
