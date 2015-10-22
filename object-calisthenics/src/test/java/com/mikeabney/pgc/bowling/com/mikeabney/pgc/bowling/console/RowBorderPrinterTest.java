package com.mikeabney.pgc.bowling.com.mikeabney.pgc.bowling.console;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class RowBorderPrinterTest {
    @Test
    public void shouldPrintAppropriateBorder() {
        int maxNameLength = 10;
        RowBorderPrinter printer = new RowBorderPrinter(maxNameLength);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        printer.print(writer);
        Assert.assertEquals("+------------+------+------+------+------+------+------+------+------+------+---------+\n", stringWriter.toString());
    }
}
