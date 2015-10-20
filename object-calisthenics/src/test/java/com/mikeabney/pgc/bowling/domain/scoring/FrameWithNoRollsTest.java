package com.mikeabney.pgc.bowling.domain.scoring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameWithNoRollsTest {
    private Frame frame;

    @Before
    public void setUp() {
        frame = Frame.emptyFrame();
    }

    @Test
    public void shouldAllowRoll() {
        frame.roll(new PinCount(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectRollWithPinfallOverTen() {
        frame.roll(new PinCount(11));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotHaveFirstRollCount() {
        frame.firstRollPinfall();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotHaveSecondRollCount() {
        frame.secondRollPinfall();
    }

    @Test
    public void shouldHavePinfallOfZero() {
        Assert.assertEquals(PinCount.ZERO, frame.fallenPins());
    }

    @Test
    public void shouldHavePinsStandingOfTen() {
        Assert.assertEquals(PinCount.TEN, frame.standingPins());
    }

    @Test
    public void shouldNotBeFull() {
        Assert.assertFalse(frame.isFull());
    }

    @Test
    public void shouldNotBeStrike() {
        Assert.assertFalse(frame.isStrike());
   }

    @Test
    public void shouldNotBeSpare() {
        Assert.assertFalse(frame.isSpare());

    }
}
