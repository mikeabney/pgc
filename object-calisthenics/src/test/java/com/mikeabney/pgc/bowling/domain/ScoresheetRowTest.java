package com.mikeabney.pgc.bowling.domain;

import com.mikeabney.pgc.bowling.domain.scoring.ScoreRow;
import org.junit.Assert;
import org.junit.Test;

public class ScoresheetRowTest {
    @Test
    public void shouldKnowBowlerName() {
        ScoreRow scoreRow = ScoreRow.EMPTY;
        Name bowler = new Name("Adam");
        ScoresheetRow row = new ScoresheetRow(bowler);

        Assert.assertEquals(bowler.print(), row.printName());
    }

}
