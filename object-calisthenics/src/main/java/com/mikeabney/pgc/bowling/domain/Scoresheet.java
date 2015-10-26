package com.mikeabney.pgc.bowling.domain;

import com.mikeabney.pgc.bowling.domain.scoring.PinCount;

import java.util.stream.Stream;

public class Scoresheet {
    public static final Scoresheet EMPTY = new Scoresheet();

    private final ScoresheetRows rows;
    private final TurnTracker turnTracker;

    private Scoresheet() {
        rows = new ScoresheetRows();
        turnTracker = new TurnTracker();
    }

    private Scoresheet(Scoresheet other, Name bowler) {
        rows = new ScoresheetRows(other.rows, bowler);
        turnTracker = other.turnTracker.addBowler(bowler);
    }

    public Scoresheet(ScoresheetRows otherRows, TurnTracker otherTurnTracker) {
        rows = new ScoresheetRows(otherRows);
        turnTracker = otherTurnTracker;
    }

    public boolean hasBowlers() {
        return !rows.isEmpty();
    }

    public Scoresheet add(Name bowler) {
        if (turnTracker.containsBowler(bowler)) {
            throw new IllegalArgumentException("Name already used.");
        }
        return new Scoresheet(this, bowler);
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
}
