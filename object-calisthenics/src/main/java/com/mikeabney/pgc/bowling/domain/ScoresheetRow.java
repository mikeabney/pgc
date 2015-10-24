package com.mikeabney.pgc.bowling.domain;

import com.mikeabney.pgc.bowling.domain.scoring.ScoreRow;

public class ScoresheetRow {
    private final Name name;
    private final ScoreRow scoreRow;

    public ScoresheetRow(Name name, ScoreRow scoreRow) {
        this.name = name;
        this.scoreRow = scoreRow;
    }

    public Name name() {
        return name;
    }
}
