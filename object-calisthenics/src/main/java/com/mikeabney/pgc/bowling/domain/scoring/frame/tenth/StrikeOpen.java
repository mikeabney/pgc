package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls.StrikeOpenOpen;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls.StrikeOpenSpare;

public class StrikeOpen extends Strike {
    private PinCount secondRollPinfall;

    public StrikeOpen(PinCount pinfall) {
        secondRollPinfall = pinfall;
    }

    @Override
    public TenthFrame roll(PinCount pinfall) {
        PinCount secondAndThird = pinfall.plus(secondRollPinfall);
        if (PinCount.TEN.equals(secondAndThird)) {
            return new StrikeOpenSpare(secondRollPinfall);
        }
        return new StrikeOpenOpen(secondRollPinfall, pinfall);
    }

    @Override
    public String printSecondRollPinfall() {
        return secondRollPinfall.print();
    }
}
