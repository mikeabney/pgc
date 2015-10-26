package com.mikeabney.pgc.bowling.domain.scoring;

import java.util.List;

public class ScoreRowWithTenth extends ScoreRow {

    ScoreRowWithTenth(List<RegularFrame> list) {
        this(list, TenthFrame.EMPTY);
    }

    private ScoreRowWithTenth(List<RegularFrame> list, TenthFrame tenthFrame) {
        super(list, tenthFrame);
    }

    @Override
    public ScoreRow roll(PinCount pinfall) {
        TenthFrame newTenth = tenthFrame.roll(pinfall);
        return new ScoreRowWithTenth(list, newTenth);
    }

    @Override
    public boolean isFull() {
        return tenthFrame.isFull();
    }

    @Override
    public PinCount tenthFrameFirstRollPinfall() {
        return tenthFrame.firstRollPinfall();
    }

    @Override
    public PinCount tenthFrameSecondRollPinfall() {
        return tenthFrame.secondRollPinfall();
    }

    @Override
    public boolean currentFrameIsEmpty() {
        return TenthFrame.EMPTY.equals(tenthFrame);
    }
}
