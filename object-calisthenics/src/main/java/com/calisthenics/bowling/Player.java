package com.calisthenics.bowling;

import com.calisthenics.ioModules.base.input.InputLine;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class Player {

    private final PlayerName name;
    private final BowlingScore game;

    public Player(InputLine name) {
        this.name = new PlayerName(name);
        game = new BowlingScore();
    }

    public Player(Player lastPlayerState) {
        name = new PlayerName(lastPlayerState.name);
        game = new BowlingScore(lastPlayerState.game);
    }

    public FrameIndex getLatestFrame(int playerIndex) {
        return game.getLatestFrame(playerIndex);
    }
}
