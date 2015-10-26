package com.calisthenics.bowling;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class FrameIndex {

    private final int playerIndex;
    private final int frameIndex;
    private final int rollIndex;

    public FrameIndex(int frameIndex, int rollIndex, int playerIndex) {
        this.frameIndex = frameIndex;
        this.rollIndex = rollIndex;
        this.playerIndex = playerIndex;
    }

    public FrameIndex isBefore(FrameIndex latestFrame) {
        if (latestFrame == null)
            return this;

        // Earliest frame wins.
        if (latestFrame.frameIndex > frameIndex)
            return this;
        if (latestFrame.frameIndex < frameIndex)
            return latestFrame;

        // If frames are equal, check roll #.
        if (latestFrame.rollIndex > rollIndex)
            return this;
        if (latestFrame.rollIndex < rollIndex)
            return latestFrame;

        // If frames are equal, check player order.
        if (latestFrame.playerIndex > playerIndex)
            return this;
        if (latestFrame.playerIndex < playerIndex)
            return latestFrame;

        // If we got here, its the same obj.
        return this;
    }
}
