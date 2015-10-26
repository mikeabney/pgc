package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;

public class Strike extends TenthFrame {
    @Override
    public TenthFrame roll(PinCount pinfall) {
        if (PinCount.TEN.equals(pinfall)) {
            return new StrikeStrike();
        }
        return new StrikeOpen(pinfall);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String printFirstRollPinfall() {
        return "X";
    }

    @Override
    public PinCount firstRollPinfall() {
        return PinCount.TEN;
    }
}
