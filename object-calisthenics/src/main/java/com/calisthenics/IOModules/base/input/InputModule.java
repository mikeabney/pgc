package com.calisthenics.ioModules.base.input;

import java.io.IOException;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public interface InputModule {

    InputLine readInput() throws IOException;
}
