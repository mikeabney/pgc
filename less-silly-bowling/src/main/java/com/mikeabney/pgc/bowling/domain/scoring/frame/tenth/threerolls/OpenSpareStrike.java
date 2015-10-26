package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls;

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

    @Override
    public String printThirdRollPinfall() {
        return "X";
    }

    @Override
    public PinCount singleFrameScore() {
        return new PinCount(20);
    }
}
