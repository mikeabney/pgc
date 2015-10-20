package com.bud.pgc.calisthenics;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Work on 10/20/2015.
 */
public class GameManagementTests {
    private Game game;
    private Player player;

    @Before
    public void beforeTests(){
        game = new Game();
        player = new Player("Fred");
    }

    @Test(expected = IllegalStateException.class)
    public void cannotStartGameWithoutPlayers(){
        game.startBowling();
    }

    @Test
    public void validGameStartPromptsForScore(){
        game.addPlayer(player);
        assertEquals("Fred is up to bowl", game.startBowling());
    }
}
