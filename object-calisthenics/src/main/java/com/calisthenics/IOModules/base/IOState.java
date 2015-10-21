package com.calisthenics.ioModules.base;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public abstract class IOState extends IOFlow {

    protected final IOModuleFactory ioFactory;

    protected IOState(IOModule io, IOModuleFactory ioFactory) {
        super(io);
        this.ioFactory = ioFactory;
    }

    public abstract IOState process();
}
