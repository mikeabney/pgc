package com.mikeabney.pgc.bowling.console;

import com.mikeabney.pgc.bowling.domain.Scoresheet;
import com.mikeabney.pgc.bowling.domain.mothers.ScoresheetObjectMother;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ScoresheetPrinterTest {
    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Complete game", ScoresheetObjectMother.completeGame(),
                        "+---------+------+------+------+------+------+------+------+------+------+---------+\n" +
                        "|         |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |\n" +
                        "+---------+------+------+------+------+------+------+------+------+------+---------+\n" +
                        "| Adam    | X    | X    | X    | X    | X    | X    | X    | X    | X    | X  X  X |\n" +
                        "|         |  30  |  60  |  90  | 120  | 150  | 180  | 210  | 240  | 270  |   300   |\n" +
                        "+---------+------+------+------+------+------+------+------+------+------+---------+\n" +
                        "| Beth    | 0  / | 0  / | 0  / | 0  / | 0  / | 0  / | 0  / | 0  / | 0  / | 0  /  0 |\n" +
                        "|         |  10  |  20  |  30  |  40  |  50  |  60  |  70  |  80  |  90  |   100   |\n" +
                        "+---------+------+------+------+------+------+------+------+------+------+---------+\n" +
                        "| Charles | 1  7 | 1  7 | 1  7 | 1  7 | 1  7 | 1  7 | 1  7 | 1  7 | 1  7 | 1  7    |\n" +
                        "|         |   8  |  16  |  24  |  32  |  40  |  48  |  56  |  64  |  72  |    80   |\n" +
                        "+---------+------+------+------+------+------+------+------+------+------+---------+\n"},
                {"Partial game", ScoresheetObjectMother.partialGame(),
                        "+---------+------+------+------+------+------+------+------+------+------+---------+\n" +
                        "|         |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |\n" +
                        "+---------+------+------+------+------+------+------+------+------+------+---------+\n" +
                        "| Adam    | X    | X    | X    | X    | X    | X    | X    |      |      |         |\n" +
                        "|         |  30  |  60  |  90  | 120  | 150  |      |      |      |      |         |\n" +
                        "+---------+------+------+------+------+------+------+------+------+------+---------+\n" +
                        "| Beth    | 0  / | 0  / | 0  / | 0  / | 0  / | 0  / | 0  / |      |      |         |\n" +
                        "|         |  10  |  20  |  30  |  40  |  50  |  60  |      |      |      |         |\n" +
                        "+---------+------+------+------+------+------+------+------+------+------+---------+\n" +
                        "| Charles | 1  7 | 1  7 | 1  7 | 1  7 | 1  7 | 1  7 | 1  7 |      |      |         |\n" +
                        "|         |   8  |  16  |  24  |  32  |  40  |  48  |  56  |      |      |         |\n" +
                        "+---------+------+------+------+------+------+------+------+------+------+---------+\n"}
        });
    }

    private Scoresheet scoresheet;
    private String expectedOutput;

    public ScoresheetPrinterTest(String name, Scoresheet scoresheet, String expectedOutput) {
        this.scoresheet = scoresheet;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void shouldPrintAppropriateRow() {
        ScoresheetPrinter printer = new ScoresheetPrinter(scoresheet);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        printer.print(writer);
        Assert.assertEquals(expectedOutput, stringWriter.toString());
    }
}
