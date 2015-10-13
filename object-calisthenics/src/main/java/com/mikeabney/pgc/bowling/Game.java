package com.mikeabney.pgc.bowling;

public class Game {
    private BowlerName name;

    public Game() {
        name = null;
    }

    private Game(Game game, BowlerName name) {
        this(game);
        this.name = name;
    }

    private Game(Game game) {
        name = game.name;
    }

    public boolean hasBowlers() {
        return name != null;
    }

    public Game addBowler(BowlerName name) {
        return new Game(this, name);
    }

    public void start() {
        if (name == null) {
            throw new IllegalStateException();
        }
    }

    public String printablePlayerList() {
        return name.toString();
    }
}
