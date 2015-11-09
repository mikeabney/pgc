package com.mikeabney.pgc.bowling.domain;

import com.mikeabney.pgc.bowling.domain.scoring.ScoreRow;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mikeabney.pgc.bowling.domain.mothers.NameObjectMother.adam;
import static com.mikeabney.pgc.bowling.domain.mothers.NameObjectMother.beth;

public class ScoresheetTest {
    private Scoresheet scoresheet;

    @Before
    public void setUp() {
        scoresheet = new ScoresheetFactory().BuildScoresheet();
    }
    
    @Test
    public void withNoNamesShouldBeEmpty() {
        Assert.assertFalse(scoresheet.hasBowlers());
    }

    @Test
    public void withOneNameShouldNotBeEmpty() {
        scoresheet = scoresheet.add(adam);
        Assert.assertTrue(scoresheet.hasBowlers());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldDisallowDuplicateName() {
        scoresheet = scoresheet.add(adam);
        scoresheet = scoresheet.add(adam);
    }
    
    @Test
    public void bowlerShouldHaveFrames() {
        scoresheet = scoresheet.add(adam);
        ScoresheetRow scoreRow = scoresheet.rowFor(adam);
        Assert.assertNotNull(scoreRow);
    }

    @Test
    public void secondBowlerShouldHaveFrames() {
        scoresheet = scoresheet.add(adam);
        scoresheet = scoresheet.add(beth);
        ScoresheetRow scoreRow = scoresheet.rowFor(beth);
        Assert.assertNotNull(scoreRow);
    }
}
