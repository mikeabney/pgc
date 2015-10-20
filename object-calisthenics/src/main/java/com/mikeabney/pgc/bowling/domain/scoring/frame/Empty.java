package com.mikeabney.pgc.bowling.domain.scoring.frame;

import com.mikeabney.pgc.bowling.domain.scoring.Frame;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.Roll;

public class Empty extends Frame {
    public static final Frame INSTANCE = new Empty();

    @Override
    public Frame roll(PinCount pinfall) {
        if (PinCount.TEN.equals(pinfall)) {
            return new Strike();
        }
        return new OneRoll(Roll.withPinfall(PinCount.TEN, pinfall));
    }

    private Empty() {
    }
}
