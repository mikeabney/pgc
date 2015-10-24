package com.mikeabney.pgc.bowling.domain.scoring;

import java.util.ArrayList;
import java.util.List;

public abstract class ScoreRow {
    public static final ScoreRow EMPTY = new ScoreRowWithOutTenth();

    protected final List<RegularFrame> list;
    protected final TenthFrame tenthFrame;

    protected ScoreRow() {
        List<RegularFrame> initialList = new ArrayList<>();
        initialList.add(RegularFrame.EMPTY);
        list = initialList;
        tenthFrame = TenthFrame.EMPTY;
    }

    protected ScoreRow(List<RegularFrame> list, TenthFrame tenthFrame) {
        this.list = list;
        this.tenthFrame = tenthFrame;
    }

    public abstract ScoreRow roll(PinCount pinfall);
}
