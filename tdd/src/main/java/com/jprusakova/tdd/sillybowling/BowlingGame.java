package com.jprusakova.tdd.sillybowling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private static final int TOTAL_FRAME_COUNT = 10;

    private List<Bowler> players = new ArrayList<>();
    private BufferedReader consoleInput;
    private OutputStream consoleOutput;

    public BowlingGame(InputStream in, OutputStream out) {
        this.consoleInput = new BufferedReader(new InputStreamReader(in));
        this.consoleOutput = out;
    }

    public BowlingGame() {
        this(System.in, System.out);
    }

    public static void main(String [ ] args) throws IOException {
        BowlingGame game = new BowlingGame();

        game.createPlayers();
        for (int i = 0; i < TOTAL_FRAME_COUNT; i++) {
            game.playFrame();
        }
    }

    private void playFrame() {
        for (Bowler bowler : players) {
            Frame frame = collectNextFrame(bowler);
            bowler.addFrame(frame);
        }
    }

    public void createPlayers() throws IOException {
        boolean addPlayer = true;
        while (addPlayer) {
            addPlayer = addPlayer();
            listPlayers(addPlayer);
        }
    }

    private void listPlayers(boolean addedPlayer) throws IOException {
        if (!addedPlayer || players.isEmpty()) {
            return;
        }
        consoleOutput.write("Bowlers so far: ".getBytes());
        for (Bowler b : players) {
            consoleOutput.write(b.getName().getBytes());
        }
        consoleOutput.write("\n".getBytes());
    }

    private boolean addPlayer() {
        String input = readInput("Provide a Bowler Name (use a blank line to start bowling)\n> ");
        if (BowlingGame.isEmptyLine(input)) {
            return false;
        }

        players.add(new Bowler(new Person(input)));
        return true;
    }

    private String readInput(String message) {
        try {
            consoleOutput.write(message.getBytes());
            String consoleInput = this.consoleInput.readLine();
            return consoleInput;
        } catch (IOException e) {
            return "";
        }
    }

    public Frame collectNextFrame(Bowler bowler) {
        String promptMessage = "Enter " + bowler.getName() + "'s ";
        int firstBall = collectBallResult(promptMessage + "first ball (X for strike)\n> ");
        int secondBall = 0;
        if (Score.STRIKE_RESULT != firstBall) {
            secondBall = collectBallResult(promptMessage + "second ball (/ for spare)\n> ");
        }

        Frame frame = new Frame(firstBall, secondBall);
        return frame;
    }

    private int collectBallResult(String promptMessage) {
        String ballResult = "";

        while (!Score.isValidBall(ballResult)) {
            ballResult = readInput(promptMessage);
        }
        return Score.calculateBallResult(ballResult);
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
}
