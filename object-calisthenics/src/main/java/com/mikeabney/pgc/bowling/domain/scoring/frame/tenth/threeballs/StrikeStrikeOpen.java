package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threeballs;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.StrikeStrike;

public class StrikeStrikeOpen extends StrikeStrike {
    private final PinCount thirdBallPinfall;

    public StrikeStrikeOpen(PinCount pinfall) {
        thirdBallPinfall = pinfall;
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
