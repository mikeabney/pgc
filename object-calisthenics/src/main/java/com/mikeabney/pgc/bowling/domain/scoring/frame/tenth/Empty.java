package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;

public class Empty extends TenthFrame {
    @Override
    public TenthFrame roll(PinCount pinfall) {
        if (PinCount.TEN.equals(pinfall)) {
            return new Strike();
        }
        return new Open(pinfall);
    }
}
