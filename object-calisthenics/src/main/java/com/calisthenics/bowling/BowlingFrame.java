package com.calisthenics.bowling;

import com.calisthenics.ioModules.base.input.InputLine;

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

    public BowlingFrame fillScore(FrameIndex scoreToFill, InputLine score) {
        if (scoreToFill.rollIndex == 0)
            return new BowlingFrame(score.toInt(), secondScore);
        return new BowlingFrame(firstScore, score.toInt());
    }
}
