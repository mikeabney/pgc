package com.mikeabney.pgc.bowling.domain.scoring;

import org.junit.Assert;
import org.junit.Test;

public class RegularFrameTest {
    @Test
    public void brandNewFrameScoreShouldBeNoScore() {
        Frame frame = new Frame();
        Assert.assertSame(Score.NO_SCORE, frame.score());
    }

    @Test
    public void incompleteFrameScoreShouldBeNoScore() {
        Frame frame = new Frame();
        frame = frame.addBall(1);
        Assert.assertSame(Score.NO_SCORE, frame.score());
    }
}
