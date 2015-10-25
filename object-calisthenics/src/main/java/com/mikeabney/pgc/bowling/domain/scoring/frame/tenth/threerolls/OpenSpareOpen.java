package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.OpenSpare;

public class OpenSpareOpen extends OpenSpare {
    private final PinCount thirdRollPinfall;

    public OpenSpareOpen(PinCount firstRollPinfall, PinCount thirdRollPinfall) {
        super(firstRollPinfall);
        this.thirdRollPinfall = thirdRollPinfall;
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
        return PinCount.TEN.plus(thirdRollPinfall);
    }
}
