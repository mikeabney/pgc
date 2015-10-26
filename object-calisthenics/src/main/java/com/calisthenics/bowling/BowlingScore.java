package com.calisthenics.bowling;

import com.calisthenics.ioModules.base.input.InputLine;

import java.util.ArrayList;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class BowlingScore {

    private final ArrayList<BowlingFrame> frames;
    private final int totalFrames = 10;

    public BowlingScore() {
        frames = new ArrayList<>();
        for (int i = 0; i < totalFrames; i++) {
            frames.add(new BowlingFrame());
        }
    }

    public BowlingScore(BowlingScore previousGameState) {
        frames = previousGameState.frames;
    }

    public FrameIndex getLatestFrame(int playerIndex) {
        FrameIndex retVal = new FrameIndex(0, 0, playerIndex);
        for (int i = 0; i < totalFrames; i++) {
            retVal = frames.get(i).missingScore() != null ? new FrameIndex(i, frames.get(i).missingScore(), playerIndex) : retVal;
        }
        return retVal;
    }

    public void fillScore(FrameIndex scoreToFill, InputLine score) {
        BowlingFrame frame = frames.get(scoreToFill.frameIndex);
        frame = frame.fillScore(scoreToFill, score);
        frames.set(scoreToFill.frameIndex, frame);
    }
}
