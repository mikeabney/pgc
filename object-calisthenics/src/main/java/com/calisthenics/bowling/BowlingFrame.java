package com.calisthenics.bowling;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class BowlingFrame {

    private final int firstScore;
    private final int secondScore;

    public BowlingFrame() {
        firstScore = 0;
        secondScore = 0;
    }

    public BowlingFrame(BowlingFrame previousFrame) {
        firstScore = previousFrame.firstScore;
        secondScore = previousFrame.secondScore;
    }

    public BowlingFrame(int firstScore, int secondScore) {
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }
}
