package com.mikeabney.pgc.bowling.domain.scoring;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class ScoreRowTest {
    ScoreRow scoreRow;

    @Before
    public void setUp() {
        scoreRow = ScoreRow.EMPTY;
    }

    @Test
    public void whenEmptyShouldAllowRoll() {
        scoreRow = scoreRow.roll(PinCount.ZERO);
    }

    @Test
    public void shouldAllowTwelveStrikes() {
        IntStream stream = IntStream.rangeClosed(1, 12);
        stream.forEach((frameNumber) -> {
            scoreRow = scoreRow.roll(PinCount.TEN);
        });
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotAllowARollAfterTwelveStrikes() {
        IntStream stream = IntStream.rangeClosed(1, 12);
        stream.forEach((frameNumber) -> scoreRow = scoreRow.roll(PinCount.TEN));
        scoreRow.roll(PinCount.ZERO);
    }
}
