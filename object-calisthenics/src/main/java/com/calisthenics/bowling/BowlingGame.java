package com.calisthenics.bowling;

import com.calisthenics.bowling.states.InitialState;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.console.ConsoleInputFactory;
import com.calisthenics.ioModules.console.ConsoleOutputFactory;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class BowlingGame {

    public static void main(String[] args) {

        ConsoleInputFactory inputFactory = new ConsoleInputFactory();
        ConsoleOutputFactory outputFactory = new ConsoleOutputFactory();
        IOModuleFactory ioFactory = new IOModuleFactory(inputFactory, outputFactory);
        BowlingState state = new InitialState(ioFactory);

        while (state != null) {
            state = state.process();
        }
    }
}
