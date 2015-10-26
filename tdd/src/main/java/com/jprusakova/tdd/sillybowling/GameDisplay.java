package com.jprusakova.tdd.sillybowling;

import java.io.*;

public class GameDisplay {

    private static final String horizontalLine = "+------+------+------+------+------+------+------+------+------+------+---------+\n";
    private static final String frameLine = "|      |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |\n";

    private BowlingGame game;
    private SillyBowlingConsole console;

    public GameDisplay(BowlingGame game, SillyBowlingConsole console) {
        this.game = game;
        this.console = console;
    }

    public GameDisplay(BowlingGame game, InputStream in, OutputStream out) {
        this(game, new SillyBowlingConsole(in, out));
    }

    public void outputGameState() throws IOException {
        outputGameStateHeader();
        for (Bowler bowler : game.getPlayers()) {
            console.write(bowler.showScore());
            console.write(game.showUnplayedFrames());
            console.write(horizontalLine);
        }
    }

    private void outputGameStateHeader() throws IOException {
        console.write("\n");
        console.write("Current score:\n");
        console.write(horizontalLine);
        console.write(frameLine);
        console.write(horizontalLine);
    }
}
