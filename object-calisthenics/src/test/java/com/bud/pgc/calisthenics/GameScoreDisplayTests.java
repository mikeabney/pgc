package com.bud.pgc.calisthenics;

import org.junit.Before;
import org.junit.Test;
import sun.plugin.dom.exception.InvalidStateException;

import static org.junit.Assert.*;

public class GameScoreDisplayTests {
    private Game game;
    private Player player;

    @Before
    public void BeforeTests(){
        game = new Game();
        player = new Player("Fred");
    }

    @Test(expected = InvalidStateException.class)
    public void displayingScoreBeforeGameStartReturnsErrorMessage(){
        game.displayScore();
    }

    @Test
    public void displayingScoreWithPlayerAndNoFramesRolledReturnsExpectedString(){
        String expected =   "+--------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-------+\n" +
                            " Player  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10   |\n" +
                            "+--------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-------+\n" +
                            " Fred    |     |     |     |     |     |     |     |     |     |       |\n" +
                            "         |     |     |     |     |     |     |     |     |     |       |\n";

        game.addPlayer(player);
        game.startBowling();
        assertEquals(expected, game.displayScore());
    }
}
