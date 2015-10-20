package com.mikeabney.pgc.bowling.domain.scoring;

public class OneRollFrame extends Frame {
    Roll roll;

    OneRollFrame(Roll roll) {
        this.roll = roll;
    }

    @Override
    public Frame roll(PinCount pinfall) {
        Roll secondRoll = Roll.withPinfall(standingPins(), pinfall);
        if (standingPins().equals(pinfall)) {
            return new SpareFrame(roll, secondRoll);
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
