package com.calisthenics.ioModules;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class FakeInputFactory implements InputModuleFactory {

    @Override
    public InputModule create() {
        return new FakeInput();
    }
}
