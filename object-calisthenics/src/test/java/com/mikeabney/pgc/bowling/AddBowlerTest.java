package com.mikeabney.pgc.bowling;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddBowlerTest {
    @Test
    public void newGameShouldHaveNoBowlers() {
        Game game = new Game();
        assertFalse(game.hasBowlers());
    }

    @Test
    public void newGameWithAddedBowlerShouldHaveBowlers() {
        Game game = new Game();
        BowlerName steve = new BowlerName("Steve");
        game = game.addBowler(steve);
        assertTrue(game.hasBowlers());
    }
}
