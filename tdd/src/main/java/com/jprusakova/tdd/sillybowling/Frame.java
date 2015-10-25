package com.jprusakova.tdd.sillybowling;

public class Frame {
    private Integer firstBall;
    private Integer secondBall;

    public Frame(int firstBall, int secondBall) {
        this.firstBall = firstBall;
        this.secondBall = secondBall;
        if (Score.SPARE_RESULT == secondBall) {
            this.secondBall = Score.STRIKE_RESULT - firstBall;
        }
    }

    public boolean isStrike() {
        return (Score.STRIKE_RESULT == firstBall);
    }

    public boolean isSpare() {
        return (Score.STRIKE_RESULT == firstBall + secondBall && Score.STRIKE_RESULT > firstBall);
    }

}
