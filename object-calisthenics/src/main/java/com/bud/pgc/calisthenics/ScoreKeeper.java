package com.bud.pgc.calisthenics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Work on 10/20/2015.
 */
public class ScoreKeeper {
    private Map<Player, BowlingFrames> events;

    public ScoreKeeper(PlayerList playerList) {
        events = new HashMap<>();
        for(Player player: playerList){
            events.put(player, new BowlingFrames());
        }
    }

    public String displayPlayerScore(Player player) {
        StringBuilder builder = new StringBuilder();
        BowlingFrames frames = events.get(player);
        String namePlate = player.toString();
        builder.append(namePlate);
        String rolls = frames.displayRolls();
        builder.append(rolls);
        frames.displayRolls();
        return null;
    }
}
