package com.mikeabney.pgc.bowling.domain.mothers;

import com.mikeabney.pgc.bowling.domain.ScoresheetRow;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;

import static com.mikeabney.pgc.bowling.domain.mothers.NameObjectMother.adam;

public class ScoresheetRowObjectMother {

    public static ScoresheetRow allSpares() {
        ScoresheetRow row = new ScoresheetRow(adam);
        for (int index = 0 ; index < 10 ; index++ ) {
            row = rollSpare(row);
        }
        return row.roll(new PinCount(3));
    }

    private static ScoresheetRow rollSpare(ScoresheetRow row) {
        ScoresheetRow newRow = row.roll(new PinCount(3));
        return newRow.roll(new PinCount(7));
    }

    public static ScoresheetRow allStrikes() {
        ScoresheetRow row = new ScoresheetRow(adam);
        for (int index = 0 ; index < 12 ; index++ ) {
            row = rollStrike(row);
        }
        return row;
    }

    public static ScoresheetRow allGutter() {
        ScoresheetRow row = new ScoresheetRow(adam);
        for (int index = 0 ; index < 20 ; index++ ) {
            row = rollGutterball(row);
        }
        return row;
    }

    private static ScoresheetRow rollGutterball(ScoresheetRow row) {
        return row.roll(PinCount.ZERO);
    }

    private static ScoresheetRow rollStrike(ScoresheetRow row) {
        return row.roll(PinCount.TEN);
    }

    public static ScoresheetRow incompleteSpare() {
        ScoresheetRow row = incomplete();

        row = row.roll(new PinCount(7));
        return row.roll(new PinCount(3));
    }

    public static ScoresheetRow incomplete() {
        ScoresheetRow row = new ScoresheetRow(adam);
        row = rollStrike(row);

        row = row.roll(new PinCount(5));
        return row.roll(new PinCount(3));
    }

    public static ScoresheetRow incompleteStrike() {
        ScoresheetRow row = incomplete();
        return row.roll(PinCount.TEN);
    }

    public static ScoresheetRow incompleteStrikePlusOneRoll() {
        ScoresheetRow row = incompleteStrike();
        return row.roll(new PinCount(7));
    }

    public static ScoresheetRow incompletePartialOpen() {
        ScoresheetRow row = incomplete();
        return row.roll(new PinCount(7));
    }

    public static ScoresheetRow allOnePinRolls() {
        ScoresheetRow row = new ScoresheetRow(adam);
        for (int index = 0 ; index < 20 ; index++ ) {
            row = row.roll(new PinCount(1));
        }
        return row;
    }
}
