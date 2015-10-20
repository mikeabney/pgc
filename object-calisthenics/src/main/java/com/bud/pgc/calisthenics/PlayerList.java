package com.bud.pgc.calisthenics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PlayerList implements Iterable<Player>{
    private final List<Player> players;

    public PlayerList(){
        players = new LinkedList<>();
    }

    public PlayerList(List<Player> players) {
        this.players = players;
    }

    public String add(Player player) {
        players.add(player);
        return player.toString() + " has been added";
    }

    public boolean isEmpty() {
        return players.isEmpty();
    }

    public String remove(Player player) {
        players.remove(player);
        return player.toString() + " has been removed";
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }

    public Player currentPlayer() {
        return players.get(0);
    }
}
