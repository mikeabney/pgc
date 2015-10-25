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
public class RollRowPrinterTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {ScoresheetRowObjectMother.allSpares(), "| Adam       | 3  / | 3  / | 3  / | 3  / | 3  / | 3  / | 3  / | 3  / | 3  / | 3  /  3 |\n"},
                {ScoresheetRowObjectMother.allStrikes(), "| Adam       | X    | X    | X    | X    | X    | X    | X    | X    | X    | X  X  X |\n"},
                {ScoresheetRowObjectMother.incompleteSpare(), "| Adam       | X    | 5  3 | 7  / |      |      |      |      |      |      |         |\n"},
                {ScoresheetRowObjectMother.incompleteStrike(), "| Adam       | X    | 5  3 | X    |      |      |      |      |      |      |         |\n"},
                {ScoresheetRowObjectMother.incompleteStrikePlusOneRoll(), "| Adam       | X    | 5  3 | X    | 7    |      |      |      |      |      |         |\n"},
                {ScoresheetRowObjectMother.incompletePartialOpen(), "| Adam       | X    | 5  3 | 7    |      |      |      |      |      |      |         |\n"},
                {ScoresheetRowObjectMother.incomplete(), "| Adam       | X    | 5  3 |      |      |      |      |      |      |      |         |\n"}
        });
    }

    private ScoresheetRow row;
    private String expectedOutput;

    public RollRowPrinterTest(ScoresheetRow row, String expectedOutput) {
        this.row = row;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void shouldPrintAppropriateRow() {
        int maxNameLength = 10;
        RollRowPrinter printer = new RollRowPrinter(maxNameLength);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        printer.print(writer, row);
        Assert.assertEquals(expectedOutput, stringWriter.toString());
    }
}
