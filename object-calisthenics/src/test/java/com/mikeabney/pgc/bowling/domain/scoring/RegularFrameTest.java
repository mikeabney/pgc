package com.mikeabney.pgc.bowling.domain.scoring;

import org.junit.Before;
import org.junit.Test;

public class RegularFrameTest {
    private Frame frame;

    @Before
    public void setUp() {
        frame = Frame.emptyFrame();
    }

    @Test
    public void incompleteFrameShouldAllowAnotherBall() {
        frame = frame.roll(new PinCount(1));
        frame.roll(new PinCount(2));
    }

    @Test(expected = IllegalStateException.class)
    public void completeFrameShouldRejectExtraBall() {
        frame = frame.roll(new PinCount(1));
        frame = frame.roll(new PinCount(2));
        frame.roll(new PinCount(3));
    }

    @Test(expected = IllegalStateException.class)
    public void strikeFrameShouldRejectSecondBall() {
        frame = frame.roll(new PinCount(10));
        frame.roll(new PinCount(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void frameShouldNotAllowMoreThanTenPins() {
        frame = frame.roll(new PinCount(9));
        frame.roll(new PinCount(2));
    }
}
