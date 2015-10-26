package tdd.sillybowling;

import com.jprusakova.tdd.sillybowling.BowlingGame;
import com.jprusakova.tdd.sillybowling.GameDisplay;
import com.jprusakova.tdd.sillybowling.SillyBowlingConsole;
import org.junit.Test;

import java.io.*;

public class GameDisplayTest {
    BowlingGame game;
    GameDisplay gameDisplay;
    SillyBowlingConsole console;

    @Test
    public void displayNoPlayersNoFrames() throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        console = new SillyBowlingConsole(inputStream, outputStream);
        game = new BowlingGame();
        gameDisplay = new GameDisplay(game, console);

        gameDisplay.outputGameState();
        System.out.println(outputStream.toString());
    }

    @Test
    public void displayOnePlayerNoFrames() throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = new ByteArrayInputStream("Beth\n\n".getBytes());
        console = new SillyBowlingConsole(inputStream, outputStream);
        game = new BowlingGame();

        game.createPlayers(console);
        gameDisplay = new GameDisplay(game, console);

        gameDisplay.outputGameState();
        System.out.println(outputStream.toString());
    }

    @Test
    public void displayTwoPlayerNoFrames() throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = new ByteArrayInputStream("Beth\nAdam\n".getBytes());
        console = new SillyBowlingConsole(inputStream, outputStream);
        game = new BowlingGame();

        game.createPlayers(console);
        gameDisplay = new GameDisplay(game, console);

        gameDisplay.outputGameState();
        System.out.println(outputStream.toString());
    }
}
