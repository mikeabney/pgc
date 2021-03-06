package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.StrikeOpen;

public class StrikeOpenSpare extends StrikeOpen {
    public StrikeOpenSpare(PinCount secondRollPinfall) {
        super(secondRollPinfall);
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
        return "/";
    }

    @Override
    public PinCount singleFrameScore() {
        PinCount firstAndLastRolls = new PinCount(20);
        return firstAndLastRolls.plus(secondRollPinfall());
    }
}
