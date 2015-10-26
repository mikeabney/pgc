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
public class ScoreRowPrinterTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"All gutter", ScoresheetRowObjectMother.allGutter(),
                        "|            |   0  |   0  |   0  |   0  |   0  |   0  |   0  |   0  |   0  |     0   |\n"},
                {"One pin per roll", ScoresheetRowObjectMother.allOnePinRolls(),
                        "|            |   2  |   4  |   6  |   8  |  10  |  12  |  14  |  16  |  18  |    20   |\n"},
                {"All spares", ScoresheetRowObjectMother.allSpares(),
                        "|            |  13  |  26  |  39  |  52  |  65  |  78  |  91  | 104  | 117  |   130   |\n"},
                {"Perfect game", ScoresheetRowObjectMother.allStrikes(),
                        "|            |  30  |  60  |  90  | 120  | 150  | 180  | 210  | 240  | 270  |   300   |\n"},
                {"Partial game", ScoresheetRowObjectMother.incomplete(),
                        "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {"Partial with last roll spare", ScoresheetRowObjectMother.incompleteSpare(),
                        "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {"Partial with last roll strike", ScoresheetRowObjectMother.incompleteStrike(),
                        "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {"Partial with strike and one more roll", ScoresheetRowObjectMother.incompleteStrikePlusOneRoll(),
                        "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {"Partial with one roll in current frame", ScoresheetRowObjectMother.incompletePartialOpen(),
                        "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"}
        });
    }

    private ScoresheetRow row;
    private String expectedOutput;

    public ScoreRowPrinterTest(String name, ScoresheetRow row, String expectedOutput) {
        this.row = row;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void shouldPrintAppropriateRow() {
        int maxNameLength = 10;
        ScoreRowPrinter printer = new ScoreRowPrinter(maxNameLength);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        printer.print(writer, row);
        Assert.assertEquals(expectedOutput, stringWriter.toString());
    }
}
