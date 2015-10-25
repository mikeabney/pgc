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
        return " ";
    }

    public String printSecondRollPinfall() {
        return " ";
    }

    public PinCount singleFrameScore(PinCount nextBall, PinCount secondNextBall) {
        return PinCount.EMPTY;
    }

    public PinCount secondRollPinfall() {
        return PinCount.EMPTY;
    }

    public PinCount firstRollPinfall() {
        return PinCount.EMPTY;
    }
}
