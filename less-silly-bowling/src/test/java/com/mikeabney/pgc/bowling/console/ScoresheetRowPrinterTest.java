package com.mikeabney.pgc.bowling.console;

import com.mikeabney.pgc.bowling.domain.ScoresheetRow;
import com.mikeabney.pgc.bowling.domain.mothers.ScoresheetRowObjectMother;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ScoresheetRowPrinterTest {
    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"All gutter", ScoresheetRowObjectMother.allGutter(),
                        "| Adam       | 0  0 | 0  0 | 0  0 | 0  0 | 0  0 | 0  0 | 0  0 | 0  0 | 0  0 | 0  0    |\n" +
                        "|            |   0  |   0  |   0  |   0  |   0  |   0  |   0  |   0  |   0  |     0   |\n"},
                {"All spares", ScoresheetRowObjectMother.allSpares(),
                        "| Adam       | 3  / | 3  / | 3  / | 3  / | 3  / | 3  / | 3  / | 3  / | 3  / | 3  /  3 |\n" +
                        "|            |  13  |  26  |  39  |  52  |  65  |  78  |  91  | 104  | 117  |   130   |\n"},
                {"Perfect game", ScoresheetRowObjectMother.allStrikes(),
                        "| Adam       | X    | X    | X    | X    | X    | X    | X    | X    | X    | X  X  X |\n" +
                        "|            |  30  |  60  |  90  | 120  | 150  | 180  | 210  | 240  | 270  |   300   |\n"},
                {"Partial game", ScoresheetRowObjectMother.incomplete(),
                        "| Adam       | X    | 5  3 |      |      |      |      |      |      |      |         |\n" +
                        "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {"Partial with last roll spare", ScoresheetRowObjectMother.incompleteSpare(),
                        "| Adam       | X    | 5  3 | 7  / |      |      |      |      |      |      |         |\n" +
                        "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {"Partial with last roll strike", ScoresheetRowObjectMother.incompleteStrike(),
                        "| Adam       | X    | 5  3 | X    |      |      |      |      |      |      |         |\n" +
                        "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {"Partial with strike and one more roll", ScoresheetRowObjectMother.incompleteStrikePlusOneRoll(),
                        "| Adam       | X    | 5  3 | X    | 7    |      |      |      |      |      |         |\n" +
                        "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {"Partial with one roll in current rame", ScoresheetRowObjectMother.incompletePartialOpen(),
                        "| Adam       | X    | 5  3 | 7    |      |      |      |      |      |      |         |\n" +
                        "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"}
        });
    }

    private ScoresheetRow row;
    private String expectedOutput;

    public ScoresheetRowPrinterTest(String name, ScoresheetRow row, String expectedOutput) {
        this.row = row;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void shouldPrintAppropriateRow() {
        int maxNameLength = 10;
        ScoresheetRowPrinter printer = new ScoresheetRowPrinter(maxNameLength);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        printer.print(writer, row);
        Assert.assertEquals(expectedOutput, stringWriter.toString());
    }
}
