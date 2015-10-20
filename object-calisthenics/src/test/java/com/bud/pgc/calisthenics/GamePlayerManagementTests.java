package com.bud.pgc.calisthenics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Work on 10/20/2015.
 */
public class GamePlayerManagementTests {
    private Game game;
    private Player player;

    @Before
    public void BeforeTests(){
        game = new Game();
        player = new Player("Fred");
    }

    @Test
    public void initialGameHasNoPlayers(){
        assertFalse(game.hasPlayers());
    }

    @Test
    public void canAddPlayer(){
        String result = game.addPlayer(player);
        assertTrue(game.hasPlayers());
        assertEquals("Fred has been added", result);
    }

    @Test
    public void canRemovePlayer(){
        game.addPlayer(player);
        assertTrue(game.hasPlayers());
        String result = game.removePlayer(player);
        assertFalse(game.hasPlayers());
        assertEquals("Fred has been removed", result);
    }

    @Test
    public void cannotAddPlayerAfterGameHasStarted(){
        game.addPlayer(player);
        game.startBowling();
        String result = game.addPlayer(player);
        assertEquals("Cannot add player once game has started", result);
    }

    @Test
    public void cannotRemovePlayerAfterGameHasStarted(){
        game.addPlayer(player);
        game.startBowling();
        assertEquals("Cannot remove player once game has started", game.removePlayer(player));
    }
}
