package com.mikeabney.pgc.bowling.domain.scoring.frame;

import com.mikeabney.pgc.bowling.domain.scoring.Frame;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;

class Strike extends Frame {
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
    public PinCount firstRollPinfall() {
        return fallenPins();
    }
}
