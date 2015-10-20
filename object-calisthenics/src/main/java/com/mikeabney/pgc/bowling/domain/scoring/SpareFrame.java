package com.mikeabney.pgc.bowling.domain.scoring;

public class SpareFrame extends FullFrame {
    public SpareFrame(Roll firstRoll, Roll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public PinCount standingPins() {
        return PinCount.ZERO;
    }

    @Override
    public PinCount fallenPins() {
        return PinCount.TEN;
    }

    @Override
    public boolean isSpare() {
        return true;
    }
}
