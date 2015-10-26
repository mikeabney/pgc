package com.jprusakova.tdd.sillybowling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private static final int TOTAL_FRAME_COUNT = 10;

    private List<Bowler> players = new ArrayList<>();
    private int frameCount = 0;

    public int getFrameCount() {
        return frameCount;
    }

    private void playFrame() {
        for (Bowler bowler : players) {
            bowler.collectNextFrame(null);
        }
        frameCount++;
    }

    public void createPlayers(SillyBowlingConsole console) throws IOException {
        boolean addPlayer = true;
        while (addPlayer) {
            addPlayer = collectPlayerInfo(console);
            listPlayers(addPlayer, console);
        }
    }


    private void listPlayers(boolean addedPlayer, SillyBowlingConsole console) throws IOException {
        if (!addedPlayer || players.isEmpty()) {
            return;
        }
        console.write("Bowlers so far: ");
        for (Bowler b : players) {
            console.write(b.getName());
        }
        console.write("\n");
    }


    private boolean collectPlayerInfo(SillyBowlingConsole console) {
        String input = console.readInput("Provide a Bowler Name (use a blank line to start bowling)\n> ");
        if (BowlingGame.isEmptyLine(input)) {
            return false;
        }

        players.add(new Bowler(new Person(input)));
        return true;
    }

    public static boolean isEmptyLine(String text) {
        if (null == text || "\n".equals(text) || text.length() < 1) {
            return true;
        }
        return false;
    }

    public Iterable<Bowler> getPlayers() {
        return players;
    }

    public String showUnplayedFrames() {
        StringBuffer buffer = new StringBuffer();
        for (int currentFrame = frameCount; currentFrame < TOTAL_FRAME_COUNT; currentFrame++) {
            buffer.append("     | ");
        }
        buffer.append('\n');
        return buffer.toString();
    }
}
