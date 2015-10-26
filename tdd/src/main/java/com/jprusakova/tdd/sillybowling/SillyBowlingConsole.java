package com.jprusakova.tdd.sillybowling;

import java.io.*;

public class SillyBowlingConsole {
    private BufferedReader consoleInput;
    private OutputStream consoleOutput;

    public SillyBowlingConsole() {
        this(System.in, System.out);
    }

    public SillyBowlingConsole(InputStream in, OutputStream out) {
        this.consoleOutput = out;
        this.consoleInput = new BufferedReader(new InputStreamReader(in));
    }

    public Reader getInputReader() {
        return consoleInput;
    }

    public void write(String output) throws IOException {
        consoleOutput.write(output.getBytes());
    }

    public String readLine() throws IOException {
        return consoleInput.readLine();
    }

    public String readInput(String message) {
        try {
            write(message);
            String input = readLine();
            return input;
        } catch (IOException e) {
            return "";
        }
    }
}
