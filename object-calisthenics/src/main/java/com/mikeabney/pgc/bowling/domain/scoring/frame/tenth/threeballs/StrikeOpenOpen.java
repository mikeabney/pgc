package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threeballs;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.StrikeOpen;

public class StrikeOpenOpen extends StrikeOpen {
    private final PinCount thirdRollPinfall;

    public StrikeOpenOpen(PinCount secondRollPinfall, PinCount thirdRollPinfall) {
        super(secondRollPinfall);
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
}
