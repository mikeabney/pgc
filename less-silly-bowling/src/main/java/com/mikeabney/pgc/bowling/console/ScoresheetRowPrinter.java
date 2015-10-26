package com.mikeabney.pgc.bowling.console;

import com.mikeabney.pgc.bowling.domain.ScoresheetRow;

import java.io.PrintWriter;

public class ScoresheetRowPrinter {
    private RollRowPrinter rollPrinter;
    private ScoreRowPrinter scorePrinter;

    public ScoresheetRowPrinter(int maxNameLength) {
        rollPrinter = new RollRowPrinter(maxNameLength);
        scorePrinter = new ScoreRowPrinter(maxNameLength);
    }

    public void print(PrintWriter writer, ScoresheetRow row) {
        rollPrinter.print(writer, row);
        scorePrinter.print(writer, row);
    }
}
