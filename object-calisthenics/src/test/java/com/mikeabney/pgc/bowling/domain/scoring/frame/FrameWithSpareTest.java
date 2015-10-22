package com.mikeabney.pgc.bowling.domain.scoring.frame;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.RegularFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameWithSpareTest {
    private RegularFrame frame;
    private PinCount firstRollPinfall;
    private PinCount secondRollPinfall;

    @Before
    public void setUp() {
        frame = RegularFrame.EMPTY;
        firstRollPinfall = new PinCount(2);
        secondRollPinfall = new PinCount(8);
        frame = frame.roll(firstRollPinfall);
        frame = frame.roll(secondRollPinfall);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldRejectExtraBall() {
        frame = frame.roll(new PinCount(1));
    }

    @Test
    public void shouldRememberFirstRollCount() {
        Assert.assertEquals(firstRollPinfall, frame.firstRollPinfall());
    }

    @Test
    public void shouldRememberSecondBallCount() {
        Assert.assertEquals(secondRollPinfall, frame.secondRollPinfall());
    }

    @Test
    public void shouldHavePinfallOfTen() {
        Assert.assertEquals(PinCount.TEN, frame.fallenPins());
    }

    @Test
    public void shouldHavePinsStandingOfZero() {
        Assert.assertEquals(PinCount.ZERO, frame.standingPins());
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
    public void shouldBeSpare() {
        Assert.assertTrue(frame.isSpare());

    }
}
