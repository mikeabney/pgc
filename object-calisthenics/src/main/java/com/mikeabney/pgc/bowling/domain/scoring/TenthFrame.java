package com.mikeabney.pgc.bowling.domain.scoring;

public class TenthFrame implements Frame {
    public static final TenthFrame EMPTY = new TenthFrame(TenthFrameRolls.EMPTY);

    private final TenthFrameRolls rolls;

    private TenthFrame(TenthFrameRolls rolls) {
        this.rolls = rolls;
    }

    public TenthFrame roll(PinCount pinfall) {
        TenthFrameRolls newRolls = rolls.add(pinfall);
        return new TenthFrame(newRolls);
    }

    @Override
    public boolean isFull() {
        return rolls.isFull();
    }
}
