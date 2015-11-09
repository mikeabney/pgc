package com.mikeabney.pgc.bowling.domain;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;

import java.util.stream.Stream;

public class Scoresheet {

    final ScoresheetRows rows;
    final TurnTracker turnTracker;

    protected Scoresheet(ScoresheetRows rows, TurnTracker turnTracker) {
        this.rows = rows;
        this.turnTracker = turnTracker;
    }

    public boolean hasBowlers() {
        return !rows.isEmpty();
    }

    public Scoresheet add(Name bowler) {
        if (turnTracker.containsBowler(bowler)) {
            throw new IllegalArgumentException("Name already used.");
        }
        return new ScoresheetFactory().BuildScoresheet(this, bowler);
    }

    public ScoresheetRow rowFor(Name bowler) {
        return rows.forBowler(bowler);
    }

    public Scoresheet roll(PinCount pinfall) {
        Name currentBowler = turnTracker.currentBowler();
        ScoresheetRow scoresheetRow = rows.forBowler(currentBowler);
        scoresheetRow = scoresheetRow.roll(pinfall);
        TurnTracker newTurnTracker = turnTracker;
        if (scoresheetRow.currentFrameIsEmpty() || scoresheetRow.isFull()) {
            newTurnTracker = turnTracker.next();
        }
        return new Scoresheet(rows.replace(scoresheetRow), newTurnTracker);
    }

    public Stream<String> printNames() {
        return turnTracker.printNames();
    }

    public Stream<ScoresheetRow> rows() {
        return rows.stream();
    }

    public boolean isGameComplete() {
        return false;
    }

    public Name currentBowler() {
        return turnTracker.currentBowler();
    }
}
