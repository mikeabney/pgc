package com.mikeabney.pgc.bowling.domain;

import com.mikeabney.pgc.bowling.domain.scoring.ScoreRow;
import org.junit.Assert;
import org.junit.Test;

import static com.mikeabney.pgc.bowling.domain.mothers.NameObjectMother.adam;

public class ScoresheetRowTest {
    @Test
    public void shouldKnowBowlerName() {
        ScoreRow scoreRow = ScoreRow.EMPTY;
        ScoresheetRow row = new ScoresheetRow(adam);
        Assert.assertEquals(adam.print(), row.printName());
    }

}
