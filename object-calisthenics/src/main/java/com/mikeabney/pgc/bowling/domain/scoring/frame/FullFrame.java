package com.mikeabney.pgc.bowling.domain.scoring.frame;

import com.mikeabney.pgc.bowling.domain.scoring.Frame;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.Roll;

class FullFrame extends Frame {
    private final Roll firstRoll;
    private final Roll secondRoll;

    public FullFrame(Roll firstRoll, Roll secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    @Override
    public PinCount standingPins() {
        return secondRoll.standingPins();
    }

    @Override
    public PinCount fallenPins() {
        PinCount firstRowFalls = firstRoll.fallenPins();
        PinCount secondRollFalls = secondRoll.fallenPins();
        return firstRowFalls.plus(secondRollFalls);
    }

    @Override
    public boolean isFull() {
        return true;
    }
}
