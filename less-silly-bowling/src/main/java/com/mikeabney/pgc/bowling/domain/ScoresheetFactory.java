package com.mikeabney.pgc.bowling.domain;

/**
 * Created by Joshua Cosimo Rizzo on 11/9/2015.
 */
public class ScoresheetFactory {

    public Scoresheet BuildScoresheet() {
        ScoresheetRows rows = new ScoresheetRows();
        TurnTracker turnTracker = new TurnTracker();
        return new Scoresheet(rows, turnTracker);
    }

    public Scoresheet BuildScoresheet(Scoresheet other, Name bowler) {
        ScoresheetRows rows = new ScoresheetRows(other.rows, bowler);
        TurnTracker turnTracker = other.turnTracker.addBowler(bowler);
        return new Scoresheet(rows, turnTracker);
    }

    public Scoresheet BuildScoresheet(ScoresheetRows otherRows, TurnTracker otherTurnTracker) {
        ScoresheetRows rows = new ScoresheetRows(otherRows);
        TurnTracker turnTracker = otherTurnTracker;
        return new Scoresheet(rows, turnTracker);
    }
}
