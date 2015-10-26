package com.mikeabney.pgc.bowling.domain.scoring.frame;

import com.mikeabney.pgc.bowling.domain.scoring.RegularFrame;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameWithNoRollsTest {
    private RegularFrame frame;

    @Before
    public void setUp() {
        frame = RegularFrame.EMPTY;
    }

    @Test
    public void shouldAllowRoll() {
        frame.roll(new PinCount(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectRollWithPinfallOverTen() {
        frame.roll(new PinCount(11));
    }

    @Test
    public void shouldHaveEmptyFirstRollCount() {
        Assert.assertEquals(" ", frame.printFirstRollPinfall());
    }

    @Test
    public void shouldtHaveEmptySecondRollCount() {
        Assert.assertEquals(" ", frame.printSecondRollPinfall());
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
