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
        return firstRollPinfall();
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

    @Override
    public PinCount firstRollPinfall() {
        return PinCount.TEN;
    }

    @Override
    public PinCount singleFrameScore(PinCount nextBall, PinCount secondNextBall) {
        if (PinCount.EMPTY.equals(nextBall)) {
            return PinCount.EMPTY;
        }
        if (PinCount.EMPTY.equals(secondNextBall)) {
            return PinCount.EMPTY;
        }
        PinCount plusOneBall = PinCount.TEN.plus(nextBall);
        return plusOneBall.plus(secondNextBall);
    }
}
