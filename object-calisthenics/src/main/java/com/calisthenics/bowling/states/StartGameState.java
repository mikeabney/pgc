package com.calisthenics.bowling.states;

import com.calisthenics.bowling.BowlingState;
import com.calisthenics.ioModules.base.IOModule;
import com.calisthenics.ioModules.base.IOModuleFactory;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class StartGameState extends BowlingState {

    protected StartGameState(IOModule io, IOModuleFactory ioFactory) {
        super(io, ioFactory);
    }

    @Override
    public BowlingState process() {
        return null;
    }
}
