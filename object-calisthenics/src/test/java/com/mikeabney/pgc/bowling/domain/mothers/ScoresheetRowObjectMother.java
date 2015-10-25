package com.mikeabney.pgc.bowling.domain.mothers;

import com.mikeabney.pgc.bowling.domain.Name;
import com.mikeabney.pgc.bowling.domain.ScoresheetRow;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;

public class ScoresheetRowObjectMother {
    private static Name name1 = new Name("Adam");

    public static ScoresheetRow allSpares() {
        ScoresheetRow row = new ScoresheetRow(name1);
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
        ScoresheetRow row = new ScoresheetRow(name1);
        for (int index = 0 ; index < 12 ; index++ ) {
            row = rollStrike(row);
        }
        return row;
    }

    private static ScoresheetRow rollStrike(ScoresheetRow row) {
        return row.roll(PinCount.TEN);
    }

    public static ScoresheetRow incomplete() {
        // | X    | 5  3 | 7 / |
        ScoresheetRow row = new ScoresheetRow(name1);
        row = rollStrike(row);

        row = row.roll(new PinCount(5));
        row = row.roll(new PinCount(3));

        row = row.roll(new PinCount(7));
        return row.roll(new PinCount(3));
    }
}