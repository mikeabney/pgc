package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.StrikeStrike;

public class StrikeStrikeOpen extends StrikeStrike {
    private final PinCount thirdRollPinfall;

    public StrikeStrikeOpen(PinCount pinfall) {
        thirdRollPinfall = pinfall;
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
        return thirdRollPinfall.print();
    }

    @Override
    public PinCount singleFrameScore() {
        PinCount firstTwoRolls = new PinCount(20);
        return firstTwoRolls.plus(thirdRollPinfall);
    }
}
