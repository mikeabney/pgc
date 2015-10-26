package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TenthFrameTwoStrikeTest {
    TenthFrame frame;

    @Before
    public void setUp() {
        frame = TenthFrame.EMPTY;
        frame = frame.roll(PinCount.TEN);
        frame = frame.roll(PinCount.TEN);
    }

    @Test
    public void shouldRememberFirstBall() {
        Assert.assertEquals("X", frame.printFirstRollPinfall());
    }

    @Test
    public void shouldRememberSecondBall() {
        Assert.assertEquals("X", frame.printSecondRollPinfall());
    }

    @Test
    public void shouldHaveEmptyThirdBall() {
        Assert.assertEquals(" ", frame.printThirdRollPinfall());
    }

    @Test
    public void shouldNotBeFull() {
        Assert.assertFalse(frame.isFull());
    }

    @Test
    public void shouldAllowThirdRoll() {
        frame.roll(PinCount.ZERO);
    }
}
