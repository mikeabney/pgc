package com.calisthenics.bowling.states;

import com.calisthenics.bowling.BowlingState;
import com.calisthenics.bowling.Player;
import com.calisthenics.ioModules.base.IOModule;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.base.input.InputLine;
import com.calisthenics.ioModules.base.output.OutputLine;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class EnterAnotherPlayerState extends BowlingState {

    public static final OutputLine MESSAGE = new OutputLine("Enter another player or leave blank to start the game.");

    public EnterAnotherPlayerState(IOModule io, IOModuleFactory ioFactory) {
        super(ioFactory.buildFromExisting(io, MESSAGE), ioFactory);
    }

    public EnterAnotherPlayerState(IOModule io, IOModuleFactory ioFactory, BowlingState previousState) {
        super(ioFactory.buildFromExisting(io, MESSAGE), previousState);
    }

    @Override
    public BowlingState process() {
        InputLine parameter = readInput();
        if (parameter == null || parameter.isEmpty()) {
            return new StartGameState(io, ioFactory);
        }
        crew.add(new Player(parameter));
        return new EnterAnotherPlayerState(io, ioFactory, this);
    }
}
