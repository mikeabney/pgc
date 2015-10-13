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

    public PlayerList add(Player player) {
        players.add(player);
        return new PlayerList(this.players);
    }

    public boolean isEmpty() {
        return players.isEmpty();
    }

    public PlayerList remove(Player player) {
        players.remove(player);
        return new PlayerList(this.players);
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }
}
