package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls.StrikeStrikeOpen;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls.StrikeStrikeStrike;

public class StrikeStrike extends Strike {
    @Override
    public TenthFrame roll(PinCount pinfall) {
        if (PinCount.TEN.equals(pinfall)) {
            return new StrikeStrikeStrike();
        }
        return new StrikeStrikeOpen(pinfall);
    }

    @Override
    public String printSecondRollPinfall() {
        return "X";
    }
}
