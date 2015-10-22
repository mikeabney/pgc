package com.mikeabney.pgc.bowling.domain.bowler;

import com.mikeabney.pgc.bowling.domain.Name;
import com.mikeabney.pgc.bowling.domain.Names;
import com.mikeabney.pgc.bowling.domain.scoring.Frames;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Bowlers {
    public static final Bowlers EMPTY = new Bowlers();

    private final Names names;
    private final Map<Name, Frames> namesToScoresheets;

    private Bowlers() {
        names = new Names();
        namesToScoresheets = new HashMap<>();
    }

    private Bowlers(Bowlers other, Name bowler) {
        names = new Names(other.names);
        names.add(bowler);
        namesToScoresheets = new HashMap<>(other.namesToScoresheets);
        namesToScoresheets.put(bowler, Frames.EMPTY);
    }

    public boolean hasBowlers() {
        return !namesToScoresheets.isEmpty();
    }

    public Bowlers add(Name bowler) {
        if (names.contains(bowler)) {
            throw new IllegalArgumentException("Name already used.");
        }
        return new Bowlers(this, bowler);
    }

    public Stream<Name> stream() {
        return names.stream();
    }

    public Frames framesFor(Name bowler) {
        return namesToScoresheets.get(bowler);
    }
}
