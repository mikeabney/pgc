package com.mikeabney.pgc.bowling.domain.bowler;

import com.mikeabney.pgc.bowling.domain.Name;
import com.mikeabney.pgc.bowling.domain.scoring.ScoreRow;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

public class BowlersTest {
    private Bowlers bowlers;
    private Name adam;

    @Before
    public void setUp() {
        bowlers = Bowlers.EMPTY;
        adam = new Name("Adam");
    }
    
    @Test
    public void withNoNamesShouldBeEmpty() {
        Assert.assertFalse(bowlers.hasBowlers());
    }

    @Test
    public void withOneNameShouldNotBeEmpty() {
        bowlers = bowlers.add(adam);
        Assert.assertTrue(bowlers.hasBowlers());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldDisallowDuplicateName() {
        bowlers = bowlers.add(adam);
        bowlers = bowlers.add(adam);
    }
    
    @Test
    public void bowlerShouldHaveFrames() {
        bowlers = bowlers.add(adam);
        ScoreRow scoreRow = bowlers.framesFor(adam);
        Assert.assertNotNull(scoreRow);
    }

    @Test
    public void shouldHaveAddedBowlers() {
        Name bowler1 = adam;
        Name bowler2 = new Name("Beth");
        Name bowler3 = new Name("Chuck");
        Name bowler4 = new Name("Doris");

        bowlers = bowlers.add(bowler1);
        bowlers = bowlers.add(bowler2);
        bowlers = bowlers.add(bowler3);
        bowlers = bowlers.add(bowler4);

        Stream<Name> bowlersStream = bowlers.stream();

        Assert.assertTrue(bowlersStream.anyMatch(name -> name.equals(bowler2)));
    }
}
