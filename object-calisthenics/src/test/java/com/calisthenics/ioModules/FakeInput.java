package com.calisthenics.ioModules;

import java.io.IOException;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class FakeInput implements InputModule {

    public static InputLine fakeInput;

    @Override
    public InputLine readInput() throws IOException {
        return fakeInput;
    }
}
