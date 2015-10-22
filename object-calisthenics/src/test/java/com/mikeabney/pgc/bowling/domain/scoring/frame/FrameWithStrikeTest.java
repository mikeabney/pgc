package com.mikeabney.pgc.bowling.domain.scoring.frame;

import com.mikeabney.pgc.bowling.domain.scoring.RegularFrame;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameWithStrikeTest {
    private RegularFrame frame;

    @Before
    public void setUp() {
        frame = RegularFrame.EMPTY;
        frame = frame.roll(PinCount.TEN);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotAllowARoll() {
        frame.roll(new PinCount(2));
    }

    @Test
    public void shouldRememberFirstRollCount() {
        Assert.assertEquals(PinCount.TEN, frame.firstRollPinfall());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotHaveSecondRollCount() {
        frame.secondRollPinfall();
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
    public void shouldBeStrike() {
        Assert.assertTrue(frame.isStrike());
    }

    @Test
    public void shouldNotBeSpare() {
        Assert.assertFalse(frame.isSpare());
    }
}
