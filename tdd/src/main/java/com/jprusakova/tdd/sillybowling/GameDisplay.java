package com.jprusakova.tdd.sillybowling;

import java.io.IOException;
import java.io.OutputStream;

public class GameDisplay {

    private static final String horizontalLine = "+------+------+------+------+------+------+------+------+------+------+---------+";
    private static final String frameLine = "|      |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |";

    private BowlingGame game;
    private OutputStream consoleOutput;

    public GameDisplay(BowlingGame game, OutputStream outputStream) {
        this.game = game;
        this.consoleOutput = outputStream;
    }

    public void outputGameState() throws IOException {
        outputGameStateHeader();
        for (Bowler bowler : game.getPlayers()) {
            bowler.showScore(consoleOutput);
            consoleOutput.write(horizontalLine.getBytes());
        }
    }

    private void outputGameStateHeader() throws IOException {
        consoleOutput.write("\n".getBytes());
        consoleOutput.write("Current score:\n".getBytes());
        consoleOutput.write(horizontalLine.getBytes());
        consoleOutput.write(frameLine.getBytes());
        consoleOutput.write(horizontalLine.getBytes());
    }
}
