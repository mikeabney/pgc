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

    public int getFirstBall() {
        return firstBall;
    }

    public int getSecondBall() {
        return secondBall;
    }

    public void showResult(StringBuffer buffer) {
        if (isStrike()) {
            showStrike(buffer);
            return;
        }

        if (isSpare()) {
            showSpare(buffer);
        }

        if (!isSpare() && !isStrike()) {
            showFullFrame(buffer);
        }
        showEndOfFrame(buffer);

    }

    private void showFullFrame(StringBuffer buffer) {
        buffer.append(getFirstBall());
        buffer.append(' ');
        buffer.append(getSecondBall());
    }

    private void showSpare(StringBuffer buffer) {
        buffer.append(getFirstBall());
        buffer.append(" /");
    }

    private void showEndOfFrame(StringBuffer buffer) {
        buffer.append(" | ");
    }

    private void showStrike(StringBuffer buffer) {
        buffer.append('X');
        buffer.append("   ");
    }
}
