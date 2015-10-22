package com.mikeabney.pgc.bowling.domain.scoring;

import com.mikeabney.pgc.bowling.domain.scoring.frame.Empty;

public abstract class RegularFrame implements Frame {
    public static final RegularFrame EMPTY = Empty.INSTANCE;

    public RegularFrame roll(PinCount pinfall) {
        throw new IllegalStateException();
    }

    public PinCount standingPins() {
        return PinCount.TEN;
    }

    public PinCount fallenPins() {
        return PinCount.ZERO;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isSpare() {
        return false;
    }

    public PinCount firstRollPinfall() {
        throw new IllegalStateException("First roll not recorded.");
    }

    public PinCount secondRollPinfall() {
        throw new IllegalStateException("Second roll not recorded.");
    }
}
