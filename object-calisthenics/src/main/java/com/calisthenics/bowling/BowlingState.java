package com.calisthenics.bowling;

import com.calisthenics.ioModules.base.IOModule;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.base.IOState;

import java.util.ArrayList;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public abstract class BowlingState extends IOState{

    protected ArrayList<Player> players = new ArrayList<>();

    protected BowlingState(IOModule io, IOModuleFactory ioFactory) {
        super(io, ioFactory);
    }

    @Override
    public abstract BowlingState process();
}
