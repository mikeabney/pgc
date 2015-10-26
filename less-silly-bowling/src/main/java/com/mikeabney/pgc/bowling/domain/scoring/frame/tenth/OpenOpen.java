package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;

public class OpenOpen extends Open {
    private final PinCount secondRollPinfall;

    public OpenOpen(PinCount firstRollPinfall, PinCount secondRollPinfall) {
        super(firstRollPinfall);
        this.secondRollPinfall = secondRollPinfall;
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
    public String printSecondRollPinfall() {
        return secondRollPinfall.print();
    }

    @Override
    public PinCount secondRollPinfall() {
        return secondRollPinfall;
    }

    @Override
    public PinCount singleFrameScore() {
        return firstRollPinfall().plus(secondRollPinfall);
    }
}
