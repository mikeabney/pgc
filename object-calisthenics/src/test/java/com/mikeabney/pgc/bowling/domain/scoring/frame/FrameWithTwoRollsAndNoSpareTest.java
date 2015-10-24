package com.mikeabney.pgc.bowling.domain.scoring.frame;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.RegularFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameWithTwoRollsAndNoSpareTest {
    private RegularFrame frame;
    private PinCount firstRollPinfall;
    private PinCount secondRollPinfall;

    @Before
    public void setUp() {
        frame = RegularFrame.EMPTY;
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
        Assert.assertEquals(firstRollPinfall.print(), frame.printFirstRollPinfall());
    }

    @Test
    public void shouldRememberSecondRollCount() {
        Assert.assertEquals(secondRollPinfall.print(), frame.printSecondRollPinfall());
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
