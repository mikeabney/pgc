package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threeballs;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.OpenSpare;

public class OpenSpareStrike extends OpenSpare {

    public OpenSpareStrike(PinCount firstRollPinfall) {
        super(firstRollPinfall);
    }

    @Override
    public TenthFrame roll(PinCount pinfall) {
        throw new IllegalStateException("Tenth frame is full.");
    }

    @Override
    public boolean isFull() {
        return true;
    }
}
