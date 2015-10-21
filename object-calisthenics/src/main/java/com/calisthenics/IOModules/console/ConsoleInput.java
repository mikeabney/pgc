package com.calisthenics.ioModules.console;

import com.calisthenics.ioModules.base.input.InputLine;
import com.calisthenics.ioModules.base.input.InputModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class ConsoleInput implements InputModule {

    private final BufferedReader input;

    public ConsoleInput() {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        input = new BufferedReader(inputReader);
    }

    public InputLine readInput() throws IOException {
        return new InputLine(input.readLine());
    }
}
