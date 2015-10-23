package com.mikeabney.pgc.bowling.console;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class FrameHeaderPrinterTest {
    @Test
    public void shouldPrintAppropriateBorder() {
        int maxNameLength = 10;
        FrameHeaderPrinter printer = new FrameHeaderPrinter(maxNameLength);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        printer.print(writer);
        Assert.assertEquals("|            |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |\n", stringWriter.toString());
    }
}
