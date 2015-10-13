package com.calisthenics.bowling;

import com.calisthenics.bowling.states.BowlingState;
import com.calisthenics.bowling.states.InitialState;
import com.calisthenics.ioModules.console.ConsoleInputFactory;
import com.calisthenics.ioModules.console.ConsoleOutputFactory;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class BowlingGame {

    public static void main() {

        BowlingState state = new InitialState(new ConsoleInputFactory(), new ConsoleOutputFactory());

        while (state != null) {
            state = state.process();
        }
    }
}
