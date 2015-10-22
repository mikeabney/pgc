package com.mikeabney.pgc.bowling.domain.scoring;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    public static final Frames EMPTY = new Frames();

    private final List<Frame> list;

    private Frames() {
        list = new ArrayList<>();
        list.add(RegularFrame.EMPTY);
    }

    private Frames(List<Frame> otherList, Frame frame) {
        list = new ArrayList<>(otherList);
        list.add(frame);
        if (frame.isFull()) {
            addEmptyFrame();
        }
    }

    public Frames roll(PinCount pinfall) {
        Frame currentFrame = list.get(lastIndex());
        currentFrame = currentFrame.roll(pinfall);
        return replaceLast(currentFrame);
    }

    private Frames replaceLast(Frame newLast) {
        List<Frame> newList = new ArrayList<>(list);
        newList.remove(lastIndex());
        return new Frames(newList, newLast);
    }

    private int lastIndex() {
        return list.size() - 1;
    }

    private void addEmptyFrame() {
        if (list.size() == 9) {
            list.add(TenthFrame.EMPTY);
        }
        if (list.size() < 9) {
            list.add(RegularFrame.EMPTY);
        }
    }
}
