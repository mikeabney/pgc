package com.calisthenics.bowling.states;

import com.calisthenics.bowling.BowlingState;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.base.output.OutputLine;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class InitialState extends BowlingState {

    public static final OutputLine MESSAGE = new OutputLine("Welcome to BALL SMASHER!\nWe will knock your pins over with our balls!\n\n");

    public InitialState(IOModuleFactory ioFactory) {
        super(ioFactory.build(MESSAGE), ioFactory);
    }

    @Override
    public BowlingState process() {
        return new EnterFirstPlayerState(ioFactory.build(), ioFactory);
    }
}
