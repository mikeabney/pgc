package com.mikeabney.pgc.bowling.domain.scoring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameWithOneRollAndNoStrike {
    private Frame frame;
    private PinCount firstRollPinfall;

    @Before
    public void setUp() {
        frame = Frame.emptyFrame();
        firstRollPinfall = new PinCount(1);
        frame = frame.roll(firstRollPinfall);
    }

    @Test
    public void shouldAllowARoll() {
        frame.roll(new PinCount(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectRollThatMakesTotalOverTen() {
        frame.roll(new PinCount(10));
    }

    @Test
    public void shouldRememberFirstRollCount() {
        Assert.assertEquals(firstRollPinfall, frame.firstRollPinfall());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotHaveSecondRollCount() {
        frame.secondRollPinfall();
    }

    @Test
    public void shouldHavePinfallSameAsFirstRoll() {
        Assert.assertEquals(firstRollPinfall, frame.fallenPins());
    }

    @Test
    public void shouldHavePinsStandingOfTenMinusFirstRollPinfall() {
        Assert.assertEquals(PinCount.TEN.minus(firstRollPinfall), frame.standingPins());
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
