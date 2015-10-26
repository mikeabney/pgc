package com.mikeabney.pgc.bowling.domain.scoring.frame.regular;

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
    public String printFirstRollPinfall() {
        return firstRoll.printFallenPins();
    }

    @Override
    public PinCount firstRollPinfall() {
        return firstRoll.fallenPins();
    }

    @Override
    public String printSecondRollPinfall() {
        return secondRoll.printFallenPins();
    }

    @Override
    public PinCount secondRollPinfall() {
        return secondRoll.fallenPins();
    }

    @Override
    public PinCount singleFrameScore(PinCount nextBall, PinCount secondNextBall) {
        PinCount standingPins = secondRoll.standingPins();
        return PinCount.TEN.minus(standingPins);
    }
}
