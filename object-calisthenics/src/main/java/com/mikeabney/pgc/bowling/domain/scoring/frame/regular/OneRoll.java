package com.mikeabney.pgc.bowling.domain.scoring.frame.regular;

import com.mikeabney.pgc.bowling.domain.scoring.RegularFrame;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.Roll;

public class OneRoll extends RegularFrame {
    private final Roll roll;

    OneRoll(Roll roll) {
        this.roll = roll;
    }

    @Override
    public RegularFrame roll(PinCount pinfall) {
        Roll secondRoll = Roll.withPinfall(standingPins(), pinfall);
        if (PinCount.ZERO.equals(secondRoll.standingPins())) {
            return new Spare(roll, secondRoll);
        }
        return new Full(roll, secondRoll);
    }

    @Override
    public PinCount standingPins() {
        return roll.standingPins();
    }

    @Override
    public PinCount fallenPins() {
        return roll.fallenPins();
    }

    @Override
    public String printFirstRollPinfall() {
        return roll.printFallenPins();
    }
}
