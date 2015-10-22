package com.mikeabney.pgc.bowling.domain.scoring.frame;

import com.mikeabney.pgc.bowling.domain.scoring.RegularFrame;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.Roll;

public class Full extends RegularFrame {
    private final Roll firstRoll;
    private final Roll secondRoll;

    Full(Roll firstRoll, Roll secondRoll) {
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

    @Override
    public PinCount firstRollPinfall() {
        return firstRoll.fallenPins();
    }

    @Override
    public PinCount secondRollPinfall() {
        return secondRoll.fallenPins();
    }
}
