package com.calisthenics.bowling;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class BowlingFrame {

    private final Integer firstScore;
    private final Integer secondScore;

    public BowlingFrame() {
        firstScore = null;
        secondScore = null;
    }

    public BowlingFrame(BowlingFrame previousFrame) {
        firstScore = previousFrame.firstScore;
        secondScore = previousFrame.secondScore;
    }

    public BowlingFrame(Integer firstScore, Integer secondScore) {
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    public Integer missingScore() {
        if (firstScore == null) return 0;
        if (secondScore == null) return 1;
        return null;
    }
}
