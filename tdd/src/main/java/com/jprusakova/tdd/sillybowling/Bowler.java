package com.jprusakova.tdd.sillybowling;

import java.util.Iterator;

public class Bowler {
    private Person person;
    private Score score;

    public Bowler(Person person) {
        this.person = person;
        score = new Score();
    }

    public Iterable<Frame> getFrame()
    {
        return score.getFrames();
    }

    public String getName() {
        return person.getFirstName();
    }

    public String showScore() {
        // | Adam | 1  / | 6  2 |      |      |      |      |      |      |      |         |
        StringBuffer buffer = new StringBuffer();
        showPlayerName(buffer);

        Iterator<Frame> frameIterator = score.getFrames().iterator();
        while (frameIterator.hasNext()) {
            Frame currentFrame = frameIterator.next();
            currentFrame.showResult(buffer);
        }
        return buffer.toString();
    }

    private void showPlayerName(StringBuffer buffer) {
        buffer.append("| ");
        buffer.append(person.getFourLetterName());
        buffer.append(" | ");
    }

    public void collectNextFrame(SillyBowlingConsole console) {
        String promptMessage = "Enter " + getName() + "'s ";
        int firstBall = collectBallResult(console, promptMessage + "first ball (X for strike)\n> ");
        int secondBall = 0;
        if (Score.STRIKE_RESULT != firstBall) {
            secondBall = collectBallResult(console, promptMessage + "second ball (/ for spare)\n> ");
        }

        score.addFrame(new Frame(firstBall, secondBall));
    }

    public int collectBallResult(SillyBowlingConsole console, String promptMessage) {
        String ballResult = "";

        while (!Score.isValidBall(ballResult)) {
            ballResult = console.readInput(promptMessage);
        }
        return Score.calculateBallResult(ballResult);
    }
}
