package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;

public class Open extends Empty {
    protected final PinCount firstRollPinfall;

    public Open(PinCount firstRollPinfall) {
        this.firstRollPinfall = firstRollPinfall;
    }

    @Override
    public TenthFrame roll(PinCount pinfall) {
        PinCount firstAndSecondPinfall = firstRollPinfall.plus(pinfall);
        if (PinCount.TEN.equals(firstAndSecondPinfall)) {
            return new OpenSpare(firstRollPinfall);
        }
        return new OpenOpen(firstRollPinfall, pinfall);
    }

    @Override
    public String printFirstRollPinfall() {
        return firstRollPinfall.print();
    }

    @Override
    public PinCount firstRollPinfall() {
        return firstRollPinfall;
    }
}
