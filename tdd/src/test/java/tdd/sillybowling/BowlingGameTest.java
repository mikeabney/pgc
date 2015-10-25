package tdd.sillybowling;

import com.jprusakova.tdd.sillybowling.Bowler;
import com.jprusakova.tdd.sillybowling.BowlingGame;
import com.jprusakova.tdd.sillybowling.Frame;
import com.jprusakova.tdd.sillybowling.Person;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class BowlingGameTest {
    private static final String newLine = System.getProperty("line.separator").toString();

    OutputStream outputStream = new ByteArrayOutputStream();
    BowlingGame game;

    @Test
    public void startGameNoPlayers() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("\n".getBytes());
        game = new BowlingGame(inputStream, outputStream);
        game.createPlayers();
        Assert.assertEquals("Provide a Bowler Name (use a blank line to start bowling)\n> ", outputStream.toString());
    }

    @Test
    public void startGameOnePlayer() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("Beth\n\n".getBytes());
        game = new BowlingGame(inputStream, outputStream);
        game.createPlayers();
        String expectedOutput =
                "Provide a Bowler Name (use a blank line to start bowling)\n> " +
                        "Bowlers so far: Beth\n" +
                        "Provide a Bowler Name (use a blank line to start bowling)\n> " ;
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void collectFrameResults() {
        InputStream inputStream = new ByteArrayInputStream(("9\n1\n\n").getBytes());
        game = new BowlingGame(inputStream, outputStream);
        Bowler beth = new Bowler(new Person("Beth"));

        Frame frame = game.collectNextFrame(beth);
        Assert.assertTrue(frame.isSpare());
        Assert.assertFalse(frame.isStrike());
        Assert.assertEquals("Enter Beth's first ball (X for strike)\n> Enter Beth's second ball (/ for spare)\n> ", outputStream.toString());
    }

    @Test
    public void collectStrikeFrameResults() {
        InputStream inputStream = new ByteArrayInputStream(("X\n").getBytes());
        game = new BowlingGame(inputStream, outputStream);
        Bowler beth = new Bowler(new Person("Beth"));

        Frame frame = game.collectNextFrame(beth);
        Assert.assertFalse(frame.isSpare());
        Assert.assertTrue(frame.isStrike());
        Assert.assertEquals("Enter Beth's first ball (X for strike)\n> ", outputStream.toString());
    }

    @Test
    public void collectSpareFrameResults() {
        InputStream inputStream = new ByteArrayInputStream(("4\n/\n").getBytes());
        game = new BowlingGame(inputStream, outputStream);
        Bowler beth = new Bowler(new Person("Beth"));

        Frame frame = game.collectNextFrame(beth);
        Assert.assertFalse(frame.isStrike());
        Assert.assertTrue(frame.isSpare());
        Assert.assertEquals("Enter Beth's first ball (X for strike)\n> Enter Beth's second ball (/ for spare)\n> ", outputStream.toString());
    }
}
