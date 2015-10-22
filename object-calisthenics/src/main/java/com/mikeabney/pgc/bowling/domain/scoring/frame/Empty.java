package com.mikeabney.pgc.bowling.domain.scoring.frame;

import com.mikeabney.pgc.bowling.domain.scoring.RegularFrame;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.Roll;

public class Empty extends RegularFrame {
    public static final RegularFrame INSTANCE = new Empty();

    @Override
    public RegularFrame roll(PinCount pinfall) {
        if (PinCount.TEN.equals(pinfall)) {
            return new Strike();
        }
        return new OneRoll(Roll.withPinfall(PinCount.TEN, pinfall));
    }

    private Empty() {
    }
}
