package com.mikeabney.pgc.bowling.domain.scoring.frame;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.RegularFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameWithOneRollAndNoStrikeTest {
    private RegularFrame frame;
    private PinCount firstRollPinfall;

    @Before
    public void setUp() {
        frame = RegularFrame.EMPTY;
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
        Assert.assertEquals(firstRollPinfall.print(), frame.printFirstRollPinfall());
    }

    @Test
    public void shouldNotHaveSecondRollCount() {
        Assert.assertEquals("", frame.printSecondRollPinfall());
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
