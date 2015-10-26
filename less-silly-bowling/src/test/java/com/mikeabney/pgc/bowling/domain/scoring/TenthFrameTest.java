package com.mikeabney.pgc.bowling.domain.scoring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TenthFrameTest {
    TenthFrame frame;

    @Before
    public void setUp() {
        frame = TenthFrame.EMPTY;
    }

    @Test
    public void shouldAllowThreeStrikes() {
        frame = frame.roll(PinCount.TEN);
        frame = frame.roll(PinCount.TEN);
        frame.roll(PinCount.TEN);
    }

    @Test
    public void shouldBeFullAfterThreeStrikes() {
        frame = frame.roll(PinCount.TEN);
        frame = frame.roll(PinCount.TEN);
        frame = frame.roll(PinCount.TEN);
        Assert.assertTrue(frame.isFull());
    }

    @Test
    public void shouldAllowStrikeFollowedByTwoMore() {
        frame = frame.roll(PinCount.TEN);
        frame = frame.roll(PinCount.ZERO);
        frame.roll(PinCount.TEN);
    }

    @Test
    public void shouldAllowSpareAndOneMore() {
        frame = frame.roll(PinCount.ZERO);
        frame = frame.roll(PinCount.TEN);
        frame.roll(PinCount.TEN);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotAllowAnotherRollAfterThreeStrikes() {
        frame = frame.roll(PinCount.TEN);
        frame = frame.roll(PinCount.TEN);
        frame = frame.roll(PinCount.TEN);
        frame.roll(PinCount.TEN);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotAllowAnotherRollAfterTwoWithPinsStanding() {
        frame = frame.roll(PinCount.ZERO);
        frame = frame.roll(PinCount.ZERO);
        frame.roll(PinCount.TEN);
    }
}
