package com.calisthenics.bowling;

import com.calisthenics.ioModules.base.IOModule;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.base.IOState;

import java.util.ArrayList;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public abstract class BowlingState extends IOState{

    protected BowlingCrew crew = new BowlingCrew();

    protected BowlingState(IOModule io, IOModuleFactory ioFactory) {
        super(io, ioFactory);
    }

    protected BowlingState(IOModule io, BowlingState previousState) {
        super(io, previousState.ioFactory);
        crew = previousState.crew;
    }

    @Override
    public abstract BowlingState process();
}
