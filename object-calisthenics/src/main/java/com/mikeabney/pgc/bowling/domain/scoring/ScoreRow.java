package com.mikeabney.pgc.bowling.domain.scoring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    public Stream<RegularFrame> regularFrames() {
        List<RegularFrame> returnList = new ArrayList<>(list);
        while (returnList.size() < 9) {
            returnList.add(RegularFrame.EMPTY);
        }
        return returnList.stream();
    }

    public TenthFrame tenthFrame() {
        return tenthFrame;
    }

    public List<PinCount> frameScores() {
        ScoreVisitor visitor = new ScoreVisitor(this);
        List<PinCount> pinCounts = visitor.scoreList();
        return pinCounts;
    }

    public abstract boolean isFull();

    public abstract PinCount tenthFrameFirstRollPinfall();

    public abstract PinCount tenthFrameSecondRollPinfall();

    public abstract boolean currentFrameIsEmpty();
}
