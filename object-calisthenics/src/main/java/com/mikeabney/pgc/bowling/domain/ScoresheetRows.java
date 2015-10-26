package com.mikeabney.pgc.bowling.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ScoresheetRows {
    List<ScoresheetRow> rows;

    public ScoresheetRows() {
        this.rows = new ArrayList<>();
    }

    public ScoresheetRows(ScoresheetRows other, Name bowler) {
        this.rows = new ArrayList<>(other.rows);
        this.rows.add(new ScoresheetRow(bowler));
    }

    public ScoresheetRows(ScoresheetRows other) {
        this.rows = new ArrayList<>(other.rows);
    }

    private ScoresheetRows(List<ScoresheetRow> newRows) {
        this.rows = newRows;
    }

    public boolean isEmpty() {
        return rows.isEmpty();
    }

    public Stream<ScoresheetRow> stream() {
        return rows.stream();
    }

    public ScoresheetRow forBowler(final Name bowler) {
        Stream<ScoresheetRow> rowStream = rows.stream();
        Stream<ScoresheetRow> rowForBowler = rowStream.filter(row -> row.nameEquals(bowler));
        // Should only be one and shouldn't be null.
        Optional<ScoresheetRow> first = rowForBowler.findFirst();
        return first.get();
    }

    public ScoresheetRows replace(ScoresheetRow scoresheetRow) {
        ScoresheetRow originalRow = forBowler(scoresheetRow.name());
        List<ScoresheetRow> newRows = new ArrayList<>(rows);
        int index = newRows.indexOf(originalRow);
        newRows.remove(index);
        newRows.add(index, scoresheetRow);
        return new ScoresheetRows(newRows);
    }
}
