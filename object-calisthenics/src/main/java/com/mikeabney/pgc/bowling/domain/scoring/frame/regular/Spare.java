package com.mikeabney.pgc.bowling.domain.scoring.frame.regular;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.Roll;

public class Spare extends Full {
    Spare(Roll firstRoll, Roll secondRoll) {
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

    @Override
    public String printSecondRollPinfall() {
        return "/";
    }
}
