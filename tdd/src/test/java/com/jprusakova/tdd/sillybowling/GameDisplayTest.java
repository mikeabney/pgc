package com.jprusakova.tdd.sillybowling;

import com.jprusakova.tdd.sillybowling.BowlingGame;
import com.jprusakova.tdd.sillybowling.GameDisplay;
import com.jprusakova.tdd.sillybowling.SillyBowlingConsole;
import org.junit.Test;

import java.io.*;

public class GameDisplayTest {
    private BowlingGame game = new BowlingGame();
    private GameDisplay gameDisplay;
    private SillyBowlingConsole console;
    private OutputStream outputStream = new ByteArrayOutputStream();

    @Test
    public void displayNoPlayersNoFrames() throws IOException {
        setUpSillyBowling("");

        gameDisplay.outputGameState();
        System.out.println(outputStream.toString());
    }

    @Test
    public void displayOnePlayerNoFrames() throws IOException {
        setUpSillyBowling("Beth\n\n");
        game.createPlayers(console);

        gameDisplay.outputGameState();
        System.out.println(outputStream.toString());
    }

    @Test
    public void displayTwoPlayerNoFrames() throws IOException {
        setUpSillyBowling("Beth\nAdam\n");
        game.createPlayers(console);

        gameDisplay.outputGameState();
        System.out.println(outputStream.toString());
    }

    private void setUpSillyBowling(String inputString) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        console = new SillyBowlingConsole(inputStream, outputStream);
        gameDisplay = new GameDisplay(game, console);
    }
}
