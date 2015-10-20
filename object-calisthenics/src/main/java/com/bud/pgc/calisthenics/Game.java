package com.bud.pgc.calisthenics;


import sun.plugin.dom.exception.InvalidStateException;

public class Game {
    private static final String SEPARATOR = "+--------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-------+\n";
    private static final String HEADER = " Player  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10   |\n";

    private PlayerList playerList;
    private ScoreKeeper scoreKeeper;

    public Game(){
        this.playerList = new PlayerList();
    }

    public boolean hasPlayers() {
        return !playerList.isEmpty();
    }

    public String addPlayer(Player player) {
        if (null != scoreKeeper){
            return "Cannot add player once game has started";
        }

        return playerList.add(player);
    }

    public String removePlayer(Player player) {
        if (null != scoreKeeper){
            return "Cannot remove player once game has started";
        }

        return playerList.remove(player);
    }

    public String displayScore(){
        if (null == scoreKeeper){
            throw new InvalidStateException("Game has not yet started");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(HEADER);
        stringBuilder.append(SEPARATOR);
        for(Player player: playerList){
            String playerScore = scoreKeeper.displayPlayerScore(player);
            stringBuilder.append(playerScore);
            stringBuilder.append(SEPARATOR);
        }
        return stringBuilder.toString();
    }

    public String startBowling(){
        if (!hasPlayers()){
            throw new IllegalStateException();
        }
        scoreKeeper = new ScoreKeeper(playerList);
        Player currentPlayer = playerList.currentPlayer();
        return currentPlayer.toString() + " is up to bowl";
    }

    public String scoreRoll(Pins pins){
        Player player = playerList.currentPlayer();
        scoreKeeper.addRoll(player, pins);
        return null;
    }
}
