package com.mikeabney.pgc.bowling.domain;

import com.mikeabney.pgc.bowling.domain.scoring.Frames;

public class ScoresheetRow {
    private final Name name;
    private final Frames frames;

    public ScoresheetRow(Name name, Frames frames) {
        this.name = name;
        this.frames = frames;
    }

    public Name name() {
        return name;
    }
}
