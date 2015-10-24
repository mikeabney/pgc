package com.mikeabney.pgc.bowling.domain.scoring.frame.regular;

import com.mikeabney.pgc.bowling.domain.scoring.RegularFrame;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;

public class Strike extends RegularFrame {
    Strike() {}

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

    @Override
    public String printFirstRollPinfall() {
        return "X";
    }
}
