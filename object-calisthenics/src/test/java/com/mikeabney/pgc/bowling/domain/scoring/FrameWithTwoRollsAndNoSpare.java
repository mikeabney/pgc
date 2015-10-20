package com.mikeabney.pgc.bowling.domain.scoring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameWithTwoRollsAndNoSpare {
    private Frame frame;
    private PinCount firstRollPinfall;
    private PinCount secondRollPinfall;

    @Before
    public void setUp() {
        frame = Frame.emptyFrame();
        firstRollPinfall = new PinCount(2);
        secondRollPinfall = new PinCount(3);
        frame = frame.roll(firstRollPinfall);
        frame = frame.roll(secondRollPinfall);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldRejectExtraBall() {
        frame = frame.roll(new PinCount(1));
    }

    @Test
    public void shouldRememberFirstBallCount() {
        Assert.assertEquals(firstRollPinfall, frame.firstRollPinfall());
    }

    @Test
    public void shouldRememberSecondBallCount() {
        Assert.assertEquals(secondRollPinfall, frame.secondRollPinfall());
    }

    @Test
    public void shouldHavePinfallSameAsRollsCombined() {
        Assert.assertEquals(firstRollPinfall.plus(secondRollPinfall), frame.fallenPins());
    }

    @Test
    public void shouldHavePinsStandingOfTenMinusFallenPins() {
        Assert.assertEquals(PinCount.TEN.minus(frame.fallenPins()), frame.standingPins());
    }

    @Test
    public void shouldBeFull() {
        Assert.assertTrue(frame.isFull());
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
