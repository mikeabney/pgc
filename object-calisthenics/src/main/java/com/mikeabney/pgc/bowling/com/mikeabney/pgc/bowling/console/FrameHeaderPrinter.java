package com.mikeabney.pgc.bowling.com.mikeabney.pgc.bowling.console;

import java.io.PrintWriter;
import java.util.stream.IntStream;

public class FrameHeaderPrinter {
    private final int maxNameLength;

    public FrameHeaderPrinter(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public void print(PrintWriter writer) {
        StringBuilder builder = new StringBuilder("| ");
        generateNamePadding(builder);
        builder.append(" |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |");
        writer.println(builder.toString());
    }

    private void generateNamePadding(StringBuilder builder) {
        IntStream stream = IntStream.rangeClosed(1, maxNameLength);
        stream.forEach(index -> builder.append(" "));
    }
}
