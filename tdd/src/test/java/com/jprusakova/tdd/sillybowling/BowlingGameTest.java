package com.jprusakova.tdd.sillybowling;

import com.jprusakova.tdd.sillybowling.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class BowlingGameTest {
    OutputStream outputStream = new ByteArrayOutputStream();
    BowlingGame game = new BowlingGame();
    SillyBowlingConsole console;

    @Test
    public void startGameNoPlayers() throws IOException {
        setUpBowlingGameConsole("\n");

        game.createPlayers(console);
        Assert.assertEquals("Provide a Bowler Name (use a blank line to start bowling)\n> ", outputStream.toString());
    }

    private void setUpBowlingGameConsole(String inputString) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        console = new SillyBowlingConsole(inputStream, outputStream);
    }

    @Test
    public void startGameOnePlayer() throws IOException {
        setUpBowlingGameConsole("Beth\n\n");

        game.createPlayers(console);
        String expectedOutput =
                "Provide a Bowler Name (use a blank line to start bowling)\n> " +
                        "Bowlers so far: Beth\n" +
                        "Provide a Bowler Name (use a blank line to start bowling)\n> " ;
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void collectFrameResults() {
        setUpBowlingGameConsole(("9\n1\n\n"));

        Bowler beth = new Bowler(new Person("Beth"));

        beth.collectNextFrame(console);
        Frame frame = beth.getFrame().iterator().next();
        Assert.assertTrue(frame.isSpare());
        Assert.assertFalse(frame.isStrike());
        Assert.assertEquals("Enter Beth's first ball (X for strike)\n> Enter Beth's second ball (/ for spare)\n> ", outputStream.toString());
    }

    @Test
    public void collectStrikeFrameResults() {
        setUpBowlingGameConsole(("X\n"));

        Bowler beth = new Bowler(new Person("Beth"));

        beth.collectNextFrame(console);
        Frame frame = beth.getFrame().iterator().next();
        Assert.assertFalse(frame.isSpare());
        Assert.assertTrue(frame.isStrike());
        Assert.assertEquals("Enter Beth's first ball (X for strike)\n> ", outputStream.toString());
    }

    @Test
    public void collectSpareFrameResults() {
        setUpBowlingGameConsole(("4\n/\n"));

        Bowler beth = new Bowler(new Person("Beth"));

        beth.collectNextFrame(console);
        Frame frame = beth.getFrame().iterator().next();
        Assert.assertFalse(frame.isStrike());
        Assert.assertTrue(frame.isSpare());
        Assert.assertEquals("Enter Beth's first ball (X for strike)\n> Enter Beth's second ball (/ for spare)\n> ", outputStream.toString());
    }
}
