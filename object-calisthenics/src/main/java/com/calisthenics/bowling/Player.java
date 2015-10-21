package com.calisthenics.bowling;

import com.calisthenics.ioModules.base.input.InputLine;

/**
 * Created by Joshua Cosimo Rizzo on 10/20/2015.
 */
public class Player {

    private final PlayerName name;

    public Player(InputLine name) {
        this.name = new PlayerName(name);
    }
}
