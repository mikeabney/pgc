package com.mikeabney.pgc.bowling.domain.scoring.frame.tenth;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TenthFrameOneRollStrikeTest {
    TenthFrame frame;

    @Before
    public void setUp() {
        frame = TenthFrame.EMPTY;
        frame = frame.roll(PinCount.TEN);
    }

    @Test
    public void shouldRememberFirstBall() {
        Assert.assertEquals("X", frame.printFirstRollPinfall());
    }

    @Test
    public void shouldHaveEmptySecondBall() {
        Assert.assertEquals("", frame.printSecondRollPinfall());
    }

    @Test
    public void shouldHaveEmptyThirdBall() {
        Assert.assertEquals("", frame.printThirdRollPinfall());
    }

    @Test
    public void shouldNotBeFull() {
        Assert.assertFalse(frame.isFull());
    }
}
