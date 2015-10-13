package com.bud.pgc.calisthenics;

import com.bud.pgc.calisthenics.Game;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameManagementTests {
    @Test
    public void initialGameHasNoPlayers(){
        Game game = new Game();
        assertFalse(game.hasPlayers());
    }

    @Test
    public void canAddPlayer(){
        Game game = new Game();
        game.addPlayer(new Player());
        assertTrue(game.hasPlayers());
    }

    @Test
    public void canRemovePlayer(){
        Game game = new Game();
        assertFalse(game.hasPlayers());
        Player player = new Player();
        game.addPlayer(player);
        assertTrue(game.hasPlayers());
        game.removePlayer(player);
        assertFalse(game.hasPlayers());
    }

    @Test
    public void displayingScoreWithNoPlayersReturnsExpectedString(){
        Game game = new Game();
        String expected = "+--------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-------+-------+\n" +
                " Player  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10   | Total |\n" +
                "+--------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-------+-------+\n";

        assertEquals(expected, game.gameScore());
    }
}
