package com.mikeabney.pgc.bowling;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class AddBowlerTest {
    @Test
    public void newGameShouldHaveNoBowlers() {
        Game game = new Game();
        assertFalse(game.hasBowlers());
    }
}
