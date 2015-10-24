package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threeballs.StrikeStrikeOpen;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threeballs.StrikeStrikeStrike;

public class StrikeStrike extends Strike {
    @Override
    public TenthFrame roll(PinCount pinfall) {
        if (PinCount.TEN.equals(pinfall)) {
            return new StrikeStrikeStrike();
        }
        return new StrikeStrikeOpen(pinfall);
    }
}
