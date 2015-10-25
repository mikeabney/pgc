package com.mikeabney.pgc.bowling.domain.scoring;

import java.util.ArrayList;
import java.util.List;

public class ScoreRowWithOutTenth extends ScoreRow {

    ScoreRowWithOutTenth(List<RegularFrame> list) {
        super(list, TenthFrame.EMPTY);
    }

    public ScoreRowWithOutTenth() {
        super();
    }

    @Override
    public ScoreRow roll(PinCount pinfall) {
        RegularFrame currentFrame = list.get(lastIndex());
        currentFrame = currentFrame.roll(pinfall);
        ScoreRowWithOutTenth frames = replaceLast(currentFrame);
        if (currentFrame.isFull()) {
            return frames.addEmptyFrame();
        }
        return frames;
    }

    @Override
    public PinCount tenthFrameFirstRollPinfall() {
        return PinCount.EMPTY;
    }

    @Override
    public PinCount tenthFrameSecondRollPinfall() {
        return PinCount.EMPTY;
    }

    private ScoreRowWithOutTenth replaceLast(RegularFrame newLast) {
        List<RegularFrame> newList = new ArrayList<>(list);
        newList.remove(lastIndex());
        newList.add(newLast);
        return new ScoreRowWithOutTenth(newList);
    }

    private int lastIndex() {
        return list.size() - 1;
    }

    private ScoreRow addEmptyFrame() {
        if (list.size() == 9) {
            return new ScoreRowWithTenth(list);
        }
        List<RegularFrame> newList = new ArrayList<>(list);
        newList.add(RegularFrame.EMPTY);
        return new ScoreRowWithOutTenth(newList);
    }
}
