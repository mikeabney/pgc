package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls.OpenSpareOpen;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls.OpenSpareStrike;

public class OpenSpare extends Open {
    public OpenSpare(PinCount firstRollPinfall) {
        super(firstRollPinfall);
    }

    @Override
    public TenthFrame roll(PinCount pinfall) {
        if (PinCount.TEN.equals(pinfall)) {
            return new OpenSpareStrike(firstRollPinfall);
        }
        return new OpenSpareOpen(firstRollPinfall, pinfall);
    }

    @Override
    public String printSecondRollPinfall() {
        return "/";
    }
}
