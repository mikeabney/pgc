package com.mikeabney.pgc.bowling.console;

import com.mikeabney.pgc.bowling.domain.ScoresheetRow;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;

import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScoreRowPrinter {
    private final int maxNameLength;

    public ScoreRowPrinter(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public void print(PrintWriter writer, ScoresheetRow row) {
        StringBuilder builder = new StringBuilder("| ");
        builder.append(buildNameField(row));
        builder.append(" | ");
        List<PinCount> frameScores = row.frameScores();
        List<PinCount> regularFramesScores = frameScores.subList(0, 9);
        builder.append(buildRegularFramesField(regularFramesScores));
        builder.append("  |   ");
        builder.append(mapFrame(frameScores.get(9)));
        builder.append("   |");
        writer.println(builder.toString());
    }

    private String buildNameField(ScoresheetRow row) {
        return String.format("%-" + maxNameLength + "s", "");
    }

    private String buildRegularFramesField(List<PinCount> regularFramesScores) {
        Stream<PinCount> scoresStream = regularFramesScores.stream();
        Stream<String> scoresStrings = scoresStream.map(ScoreRowPrinter::mapFrame);
        return scoresStrings.collect(Collectors.joining("  | "));
    }

    private static String mapFrame(PinCount score) {
        return String.format("%3s", score.print());
    }
}
