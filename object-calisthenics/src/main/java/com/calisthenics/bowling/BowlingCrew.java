package com.calisthenics.bowling;

import com.calisthenics.ioModules.base.input.InputLine;

import java.util.ArrayList;

/**
 * Created by Joshua Cosimo Rizzo on 10/26/2015.
 */
public class BowlingCrew {

    private ArrayList<Player> players = new ArrayList<>();

    public void fillScore(InputLine score) {
        FrameIndex scoreToFill = findScoreToFill();
        Player player = players.get(scoreToFill.playerIndex);
        player.fillScore(scoreToFill, score);
    }

    private FrameIndex findScoreToFill() {
        FrameIndex latestFrame = null;
        for (int i = 0; i < players.size(); i++) {
            Player checkPlayer = players.get(i);
            FrameIndex checkFrame = checkPlayer.getLatestFrame(i);
            latestFrame = checkFrame.isBefore(latestFrame);
        }
        return latestFrame;
    }

    public boolean gameIsOver() {
        return false;
    }

    public void add(Player player) {
        players.add(player);
    }

    public int size() {
        return players.size();
    }
}
