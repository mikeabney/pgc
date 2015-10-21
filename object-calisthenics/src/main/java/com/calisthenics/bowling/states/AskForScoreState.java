package com.calisthenics.bowling.states;

import com.calisthenics.bowling.BowlingState;
import com.calisthenics.ioModules.base.IOModule;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.base.input.InputLine;
import com.calisthenics.ioModules.base.output.OutputLine;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class AskForScoreState extends BowlingState {

    public static final OutputLine MESSAGE = new OutputLine("Please enter the {0} score for frame {1} for player {2}...");

    protected AskForScoreState(IOModule io, IOModuleFactory ioFactory) {
        super(io, ioFactory);
    }

    @Override
    public BowlingState process() {
        InputLine score = readInput();
        return new AskForScoreState(io, ioFactory);
    }
}
