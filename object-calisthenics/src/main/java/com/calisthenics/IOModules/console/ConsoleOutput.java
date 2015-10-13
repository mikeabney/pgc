package com.calisthenics.ioModules.console;

import com.calisthenics.ioModules.OutputLine;
import com.calisthenics.ioModules.OutputModule;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

/**
 * Created by Joshua Cosimo Rizzo on 10/12/2015.
 */
public class ConsoleOutput implements OutputModule {

    private ArrayList<OutputLine> consoleLines;

    public ConsoleOutput(OutputLine... lines) {
        consoleLines = new ArrayList<>(Arrays.asList(lines));
    }

    public ConsoleOutput(ConsoleOutput oldOutput, OutputLine... lines) {
        consoleLines = oldOutput.consoleLines;
        ArrayList<OutputLine> lineList = new ArrayList<>(Arrays.asList(lines));
        consoleLines.addAll(lineList);
    }

    public void processToOutput() {
        consoleLines.forEach(out::println);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        consoleLines.forEach(output::append);
        return output.toString();
    }
}
