package com.mikeabney.pgc.bowling.domain.scoring;

public class StrikeFrame extends Frame {
    @Override
    public PinCount standingPins() {
        return PinCount.ZERO;
    }

    @Override
    public PinCount fallenPins() {
        return PinCount.TEN;
    }

    @Override
    public boolean isFull() {
        return true;
    }

    @Override
    public boolean isStrike() {
        return true;
    }
}
