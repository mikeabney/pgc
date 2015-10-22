package com.mikeabney.pgc.bowling.domain.scoring;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class FramesTest {
    Frames frames;

    @Before
    public void setUp() {
        frames = Frames.EMPTY;
    }

    @Test
    public void whenEmptyShouldAllowRoll() {
        frames = frames.roll(PinCount.ZERO);
    }

    @Test
    public void shouldAllowTwelveStrikes() {
        IntStream stream = IntStream.rangeClosed(1, 12);
        stream.forEach((frameNumber) -> {
            frames = frames.roll(PinCount.TEN);
        });
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotAllowARollAfterTwelveStrikes() {
        IntStream stream = IntStream.rangeClosed(1, 12);
        stream.forEach((frameNumber) -> frames = frames.roll(PinCount.TEN));
        frames.roll(PinCount.ZERO);
    }
}
