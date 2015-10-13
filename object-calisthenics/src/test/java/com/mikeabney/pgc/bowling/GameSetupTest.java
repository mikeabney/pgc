package com.mikeabney.pgc.bowling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameSetupTest {
    @Test(expected = IllegalStateException.class)
    public void newEmptyGameShouldNotStart() {
        Game game = new Game();
        game.start();
    }

    @Test
    public void gameWithOneAddedPlayerShouldStart() {
        Game game = new Game();
        game = game.addBowler(new BowlerName("Steve"));
        game.start();
    }

    @Test
    public void gameWithOneAddedPlayerShouldListThatPlayer() {
        Game game = new Game();
        BowlerName bowlerName = new BowlerName("Steve");
        game = game.addBowler(bowlerName);
        String playerList = game.printablePlayerList();
        assertEquals(bowlerName.toString(), playerList);
    }

    @Test
    public void gameWithTwoAddedPlayersShouldListBoth() {
        Game game = new Game();
        BowlerName bowlerName1 = new BowlerName("Adam");
        BowlerName bowlerName2 = new BowlerName("Beth");
        game = game.addBowler(bowlerName1);
        game = game.addBowler(bowlerName2);

    }
}
