package com.mikeabney.pgc.bowling.domain.scoring;

public class Frame {

    public Score score() {
        return Score.NO_SCORE;
    }

    public Frame addBall(int ball) {
        return this;
    }
}
