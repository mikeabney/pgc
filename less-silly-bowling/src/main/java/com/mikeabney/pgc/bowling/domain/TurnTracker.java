package com.mikeabney.pgc.bowling.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TurnTracker {
    private List<Name> bowlers;
    private int turnMarker;


    public TurnTracker() {
        bowlers = new ArrayList<>();
        turnMarker = 0;
    }

    private TurnTracker(TurnTracker turnTracker, Name bowler) {
        bowlers = new ArrayList<>(turnTracker.bowlers);
        bowlers.add(bowler);
        turnMarker = 0;
    }

    private TurnTracker(List<Name> bowlers, int turnMarker) {
        this.bowlers = new ArrayList<>(bowlers);
        this.turnMarker = turnMarker;
    }

    public TurnTracker addBowler(Name bowler) {
        return new TurnTracker(this, bowler);
    }

    public Name currentBowler() {
        if (bowlers.isEmpty()) {
            throw new IllegalStateException("No bowlers added.");
        }
        return bowlers.get(turnMarker);
    }

    public boolean containsBowler(Name bowler) {
        return bowlers.contains(bowler);
    }

    public Stream<String> printNames() {
        Stream<Name> nameStream = bowlers.stream();
        return nameStream.map(Name::print);
    }

    public TurnTracker next() {
        return new TurnTracker(bowlers, nextTurnMarker());
    }

    private int nextTurnMarker() {
        return (turnMarker + 1) % bowlers.size();
    }
}
