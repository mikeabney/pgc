package com.bud.pgc.calisthenics;


public class Game {
    private PlayerList playerList;
    private static final String SEPARATOR = "+--------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-------+-------+\n";
    private static final String HEADER = " Player  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10   | Total |\n";

    public Game(){
        this.playerList = new PlayerList();
    }

    public boolean hasPlayers() {
        return !playerList.isEmpty();
    }

    public void addPlayer(Player player) {
        playerList = playerList.add(player);
    }

    public void removePlayer(Player player) {
        playerList = playerList.remove(player);
    }

    public String gameScore(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(HEADER);
        stringBuilder.append(SEPARATOR);
        for(Player player: playerList){
            String playerScore = player.score();
            stringBuilder.append(playerScore);
            stringBuilder.append(SEPARATOR);
        }

        return stringBuilder.toString();
    }
}
