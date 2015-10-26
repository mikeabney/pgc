package com.calisthenics.bowling.states;

import com.calisthenics.bowling.BowlingState;
import com.calisthenics.ioModules.base.IOModule;
import com.calisthenics.ioModules.base.IOModuleFactory;

/**
 * Created by Joshua Cosimo Rizzo on 10/26/2015.
 */
public class EndGameState extends BowlingState {

    protected EndGameState(IOModule io, IOModuleFactory ioFactory) {
        super(io, ioFactory);
    }

    @Override
    public BowlingState process() {
        return null;
    }
}
