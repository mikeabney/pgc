package com.jprusakova.tdd.sillybowling;

import java.io.OutputStream;

public class Bowler {
    private Person person;
    private Score score;

    public Bowler(Person person) {
        this.person = person;
        score = new Score();
    }

    public void addFrame(Frame frame) {
        score.addFrame(frame);
    }

    public void printResults() {

    }

    public String getName() {
        return person.getFirstName();
    }

    public void showScore(OutputStream consoleOutput) {
        // | Adam | 1  / | 6  2 |      |      |      |      |      |      |      |         |
        StringBuffer buffer = new StringBuffer();
        buffer.append("| ");
        buffer.append(person.getFourLetterName());
        buffer.append(" | ");

    }
}
