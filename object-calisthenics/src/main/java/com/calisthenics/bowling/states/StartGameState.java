package com.calisthenics.bowling.states;

import com.calisthenics.bowling.BowlingState;
import com.calisthenics.ioModules.base.IOModule;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.base.output.OutputLine;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class StartGameState extends BowlingState {

    public static final OutputLine MESSAGE = new OutputLine("Starting bowling game...");

    public StartGameState(IOModule io, IOModuleFactory ioFactory) {
        super(ioFactory.build(MESSAGE), ioFactory);
    }

    @Override
    public BowlingState process() {
        return new AskForScoreState(io, ioFactory);
    }
}