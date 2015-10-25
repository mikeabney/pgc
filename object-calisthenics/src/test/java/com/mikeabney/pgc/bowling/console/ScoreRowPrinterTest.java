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

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {ScoresheetRowObjectMother.allSpares(),  "|            |  13  |  26  |  39  |  52  |  65  |  78  |  91  | 104  | 117  |   130   |\n"},
                {ScoresheetRowObjectMother.allStrikes(), "|            |  30  |  60  |  90  | 120  | 150  | 180  | 210  | 240  | 270  |   300   |\n"},
                {ScoresheetRowObjectMother.incompleteSpare(), "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {ScoresheetRowObjectMother.incompleteStrike(), "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {ScoresheetRowObjectMother.incompleteStrikePlusOneRoll(), "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {ScoresheetRowObjectMother.incompletePartialOpen(), "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"},
                {ScoresheetRowObjectMother.incomplete(), "|            |  18  |  26  |      |      |      |      |      |      |      |         |\n"}
        });
    }

    private ScoresheetRow row;
    private String expectedOutput;

    public ScoreRowPrinterTest(ScoresheetRow row, String expectedOutput) {
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
