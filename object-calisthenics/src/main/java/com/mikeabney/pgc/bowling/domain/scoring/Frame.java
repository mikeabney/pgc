package com.mikeabney.pgc.bowling.domain.scoring;

import com.mikeabney.pgc.bowling.domain.scoring.frame.Empty;

public abstract class Frame {
    public static Frame emptyFrame() {
        return Empty.INSTANCE;
    }

    public Frame roll(PinCount pinfall) {
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

}
