package com.mikeabney.pgc.bowling.domain;

import com.mikeabney.pgc.bowling.domain.scoring.Frames;
import org.junit.Assert;
import org.junit.Test;

public class ScoresheetRowTest {
    @Test
    public void shouldKnowBowlerName() {
        Frames frames = Frames.EMPTY;
        Name bowler = new Name("Adam");
        ScoresheetRow row = new ScoresheetRow(bowler, frames);

        Assert.assertEquals(bowler, row.name());
    }

}
