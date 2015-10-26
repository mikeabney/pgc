package com.mikeabney.pgc.bowling.console;

import com.mikeabney.pgc.bowling.domain.Scoresheet;
import com.mikeabney.pgc.bowling.domain.ScoresheetRow;

import java.io.PrintWriter;
import java.util.stream.Stream;

public class ScoresheetPrinter {
    private Scoresheet scoresheet;
    private FrameHeaderPrinter headerPrinter;
    private RowBorderPrinter borderPrinter;
    private ScoresheetRowPrinter rowPrinter;

    public ScoresheetPrinter(Scoresheet scoresheet) {
        this.scoresheet = scoresheet;
        int maxNameLength = findMaxNameLenth(scoresheet);
        headerPrinter = new FrameHeaderPrinter(maxNameLength);
        borderPrinter = new RowBorderPrinter(maxNameLength);
        rowPrinter = new ScoresheetRowPrinter(maxNameLength);
    }

    public void print(PrintWriter writer) {
        borderPrinter.print(writer);
        headerPrinter.print(writer);
        borderPrinter.print(writer);
        Stream<ScoresheetRow> rowStream = scoresheet.rows();
        rowStream.forEach(row -> {
            rowPrinter.print(writer, row);
            borderPrinter.print(writer);
        });
    }

    private int findMaxNameLenth(Scoresheet scoresheet) {
        Stream<String> nameStream = scoresheet.printNames();
        String longestName = nameStream.reduce("", (name, name2) -> name.length() > name2.length() ? name : name2);
        return longestName.length();
    }
}
