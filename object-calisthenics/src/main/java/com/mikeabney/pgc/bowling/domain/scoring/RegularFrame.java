package com.mikeabney.pgc.bowling.domain.scoring;

import com.mikeabney.pgc.bowling.domain.scoring.frame.regular.Empty;

public abstract class RegularFrame {
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

    public String printFirstRollPinfall() {
        return "";
    }

    public String printSecondRollPinfall() {
        return "";
    }
}
