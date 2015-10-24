package com.mikeabney.pgc.bowling.domain.scoring;

import com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.Empty;

public abstract class TenthFrame {
    public static final TenthFrame EMPTY = new Empty();

    public abstract TenthFrame roll(PinCount pinfall);

    public boolean isFull() {
        return false;
    }

    public String printFirstRollPinfall() {
        return "";
    }

    public String printSecondRollPinfall() {
        return "";
    }

    public String printThirdRollPinfall() {
        return "";
    }
}
