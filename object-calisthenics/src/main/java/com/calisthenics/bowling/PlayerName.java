package com.calisthenics.bowling;

import com.calisthenics.ioModules.base.input.InputLine;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class PlayerName {

    public final String playerName;

    public PlayerName(InputLine name) {
        playerName = name.toString();
    }

    @Override
    public String toString() {
        return playerName;
    }
}
