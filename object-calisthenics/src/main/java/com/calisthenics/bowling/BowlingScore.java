package com.calisthenics.bowling;

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
}
