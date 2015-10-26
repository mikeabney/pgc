package com.calisthenics.bowling.states;

import com.calisthenics.bowling.BowlingState;
import com.calisthenics.bowling.FrameIndex;
import com.calisthenics.bowling.Player;
import com.calisthenics.ioModules.base.IOModule;
import com.calisthenics.ioModules.base.IOModuleFactory;
import com.calisthenics.ioModules.base.input.InputLine;
import com.calisthenics.ioModules.base.output.OutputLine;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class AskForScoreState extends BowlingState {

    public static final OutputLine MESSAGE = new OutputLine("Please enter the {0} score for frame {1} for player {2}...");

    protected AskForScoreState(IOModule io, IOModuleFactory ioFactory) {
        super(ioFactory.build(MESSAGE), ioFactory);
    }

    protected AskForScoreState(IOModule io, IOModuleFactory ioFactory, BowlingState previousState) {
        super(ioFactory.build(MESSAGE), previousState);
    }

    @Override
    public BowlingState process() {
        InputLine score = readInput();
        crew.fillScore(score);
        if (!crew.gameIsOver())
            return new AskForScoreState(io, ioFactory, this);
        return new EndGameState(io, ioFactory);
    }

    private FrameIndex findScoreToFill() {
        FrameIndex latestFrame = null;
        for (int i = 0; i < players.size(); i++) {
            Player checkPlayer = players.get(i);
            FrameIndex checkFrame = checkPlayer.getLatestFrame(i);
            latestFrame = checkFrame.isBefore(latestFrame);
        }
        return latestFrame;
    }
}
