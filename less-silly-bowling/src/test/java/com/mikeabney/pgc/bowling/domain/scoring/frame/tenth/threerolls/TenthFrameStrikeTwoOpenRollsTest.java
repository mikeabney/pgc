package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TenthFrameStrikeTwoOpenRollsTest {
    TenthFrame frame;

    @Before
    public void setUp() {
        frame = TenthFrame.EMPTY;
        frame = frame.roll(PinCount.TEN);
        frame = frame.roll(new PinCount(1));
        frame = frame.roll(new PinCount(7));
    }

    @Test
    public void shouldRememberFirstBall() {
        Assert.assertEquals("X", frame.printFirstRollPinfall());
    }

    @Test
    public void shouldRememberSecondBall() {
        Assert.assertEquals("1", frame.printSecondRollPinfall());
    }

    @Test
    public void shouldRememberThirdBall() {
        Assert.assertEquals("7", frame.printThirdRollPinfall());
    }

    @Test
    public void shouldBeFull() {
        Assert.assertTrue(frame.isFull());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotAllowFourthRoll() {
        frame.roll(PinCount.ZERO);
    }
}
