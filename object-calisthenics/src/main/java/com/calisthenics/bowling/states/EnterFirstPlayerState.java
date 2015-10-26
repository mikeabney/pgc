package com.calisthenics.bowling.states;

import com.calisthenics.bowling.Player;
import com.calisthenics.bowling.BowlingState;
import com.calisthenics.ioModules.base.IOModule;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.base.input.InputLine;
import com.calisthenics.ioModules.base.output.OutputLine;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class EnterFirstPlayerState extends BowlingState {

    public static final OutputLine MESSAGE = new OutputLine("Please enter the first player's name.");
    public static final OutputLine NO_INPUT = new OutputLine("You must input at least one player..\n");

    public EnterFirstPlayerState(IOModule io, IOModuleFactory ioFactory) {
        super(ioFactory.buildFromExisting(io, MESSAGE), ioFactory);
    }

    @Override
    public BowlingState process() {
        InputLine parameter = readInput();
        if (parameter == null) {
            return new EnterFirstPlayerState(ioFactory.build(NO_INPUT, MESSAGE), ioFactory);
        }
        crew.add(new Player(parameter));
        return new EnterAnotherPlayerState(io, ioFactory, this);
    }
}