package com.mikeabney.pgc.bowling.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Names {
    private final List<Name> list;

    public Names() {
        list = new ArrayList<>();
    }

    public Names(Names other) {
        list = new ArrayList<>(other.list);
    }

    public void add(Name bowler) {
        list.add(bowler);
    }

    public boolean contains(Name name) {
        return list.contains(name);
    }

    public Stream<Name> stream() {
        return list.stream();
    }
}
