package com.mikeabney.pgc.bowling.console;

import com.mikeabney.pgc.bowling.domain.ScoresheetRow;
import com.mikeabney.pgc.bowling.domain.scoring.RegularFrame;
import com.mikeabney.pgc.bowling.domain.scoring.TenthFrame;

import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RollRowPrinter {
    private final int maxNameLength;

    public RollRowPrinter(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public void print(PrintWriter writer, ScoresheetRow row) {
        StringBuilder builder = new StringBuilder("| ");
        builder.append(buildNameField(row));
        builder.append(" | ");
        builder.append(buildRegularFramesField(row));
        builder.append(" | ");
        builder.append(buildTenthFrameField(row));
        builder.append(" |");
        writer.println(builder.toString());
    }

    private String buildNameField(ScoresheetRow row) {
        return String.format("%-" + maxNameLength + "s", row.printName());
    }

    private String buildRegularFramesField(ScoresheetRow row) {
        Stream<RegularFrame> frames = row.regularFrames();
        Stream<String[]> rollPairs = frames.map(RollRowPrinter::mapRegularFrame);
        Stream<String> frameStrings = rollPairs.map(RollRowPrinter::printFrameRolls);
        return frameStrings.collect(Collectors.joining(" | "));
    }


    private static String printFrameRolls(String[] strings) {
        return String.format("%s  %s", strings[0], strings[1]);
    }

    private static String[] mapRegularFrame(RegularFrame regularFrame) {
        return new String[] {
            regularFrame.printFirstRollPinfall(),
            regularFrame.printSecondRollPinfall()
        };
    }

    private String buildTenthFrameField(ScoresheetRow row) {
        TenthFrame tenthFrame = row.tenthFrame();
        String firstRoll = tenthFrame.printFirstRollPinfall();
        String secondRoll = tenthFrame.printSecondRollPinfall();
        String thirdRoll = tenthFrame.printThirdRollPinfall();
        return String.format("%s  %s  %s", firstRoll, secondRoll, thirdRoll);
    }
}
