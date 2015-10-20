package com.mikeabney.pgc.bowling.domain.scoring.frame;

import com.mikeabney.pgc.bowling.domain.scoring.Frame;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.Roll;

class OneRoll extends Frame {
    Roll roll;

    OneRoll(Roll roll) {
        this.roll = roll;
    }

    @Override
    public Frame roll(PinCount pinfall) {
        Roll secondRoll = Roll.withPinfall(standingPins(), pinfall);
        if (standingPins().equals(pinfall)) {
            return new Spare(roll, secondRoll);
        }
        return new FullFrame(roll, secondRoll);
    }

    @Override
    public PinCount standingPins() {
        return roll.standingPins();
    }

    @Override
    public PinCount fallenPins() {
        return roll.fallenPins();
    }
}
