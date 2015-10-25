package com.jprusakova.tdd.sillybowling;

import java.util.ArrayList;
import java.util.List;

public class Score {
    public static final int STRIKE_RESULT = 10;
    public static final int SPARE_RESULT = -1;

    private List<Frame> frameList = new ArrayList<>();

    public static boolean isValidBall(String result) {
        if (null == result || 1 != result.length()) {
            return false;
        }

        if ("0123456789X/".contains(result)) {
            return true;
        }

        return false;
    }

    public void addFrame(Frame frame) {
        if (null == frame) {
            return;
        }
        frameList.add(frame);
    }

    public Iterable<Frame> getFrames() {
        return frameList;
    }

    public static int calculateBallResult(String ballResult) {
        if ("0123456789".contains(ballResult)) {
            return Integer.valueOf(ballResult);
        }

        if ("X".equalsIgnoreCase(ballResult)) {
            return STRIKE_RESULT;
        }

        if ("/".equalsIgnoreCase(ballResult)) {
            return SPARE_RESULT;
        }

        return 0;
    }
}
