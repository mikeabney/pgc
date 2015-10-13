package com.calisthenics.bowling.states;

import com.calisthenics.ioModules.InputModuleFactory;
import com.calisthenics.ioModules.OutputLine;
import com.calisthenics.ioModules.OutputModuleFactory;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class InitialState extends BowlingState {

    public static final String MESSAGE = "Please enter the first player's name.";

    public InitialState(InputModuleFactory inputFactory, OutputModuleFactory outputFactory) {
        super(inputFactory, outputFactory);
    }

    @Override
    protected void setup() {
        addLine(new OutputLine(MESSAGE));
    }

    @Override
    public BowlingState process() {
        return null;
    }
}
