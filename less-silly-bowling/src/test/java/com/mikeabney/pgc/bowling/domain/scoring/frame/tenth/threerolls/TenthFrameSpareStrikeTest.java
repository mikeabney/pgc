package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth.threerolls;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TenthFrameSpareStrikeTest {
    TenthFrame frame;

    @Before
    public void setUp() {
        frame = TenthFrame.EMPTY;
        frame = frame.roll(new PinCount(1));
        frame = frame.roll(new PinCount(9));
        frame = frame.roll(PinCount.TEN);
    }

    @Test
    public void shouldRememberFirstBall() {
        Assert.assertEquals("1", frame.printFirstRollPinfall());
    }

    @Test
    public void shouldRememberSecondBall() {
        Assert.assertEquals("/", frame.printSecondRollPinfall());
    }

    @Test
    public void shouldRememberThirdBall() {
        Assert.assertEquals("X", frame.printThirdRollPinfall());
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
