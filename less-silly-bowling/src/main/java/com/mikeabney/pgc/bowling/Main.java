package com.mikeabney.pgc.bowling;

import com.mikeabney.pgc.bowling.console.ScoresheetPrinter;
import com.mikeabney.pgc.bowling.domain.Name;
import com.mikeabney.pgc.bowling.domain.Scoresheet;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    PrintWriter writer;
    Scanner scanner;

    public static void main (String... args) {
        Main main = new Main();
        main.run();
    }

    public Main() {
        writer = new PrintWriter(new OutputStreamWriter(System.out));
        scanner = new Scanner(System.in);
    }

    private void run() {
        String continueString = "";
        do {
            System.out.println("--- Welcome to Silly Bowling ---\n");
            Scoresheet scoresheet = Scoresheet.EMPTY;
            scoresheet = addBowlers(scoresheet);

            System.out.println("Ready to bowl!");
            printScoresheet(scoresheet);
            scoresheet = bowl(scoresheet);

            System.out.println("--- Final score ---");
            printScoresheet(scoresheet);
            continueString = prompt("\nAnother game? (y/n)");
        } while ("y".equalsIgnoreCase(continueString));
    }

    private Scoresheet bowl(Scoresheet scoresheet) {
        String pinfallString = "";
        do {
            pinfallString = prompt("Enter " + scoresheet.currentBowler().print() + "'s roll or XX to end this game.");
            PinCount pinfall = translatePinfall(pinfallString);
            scoresheet = processPinfall(scoresheet, pinfall);
        } while (!"XX".equals(pinfallString));
        return scoresheet;
    }

    private Scoresheet processPinfall(Scoresheet scoresheet, PinCount pinfall) {
        if (!PinCount.EMPTY.equals(pinfall)) {
            try {
                scoresheet = scoresheet.roll(pinfall);
                printScoresheet(scoresheet);
            }
            catch (IllegalStateException | IllegalArgumentException badData) {
                System.out.println(badData.getMessage());
            }
        }
        return scoresheet;
    }

    private void printScoresheet(Scoresheet scoresheet) {
        ScoresheetPrinter printer = new ScoresheetPrinter(scoresheet);
        printer.print(writer);
        writer.flush();
    }

    private PinCount translatePinfall(String pinfallString) {
        switch(pinfallString) {
            case "X" :
            case "/" :
            case "10" :
                return PinCount.TEN;
        }
        try {
            return new PinCount(Integer.valueOf(pinfallString));
        }
        catch (NumberFormatException numberFormatException) {
            System.out.println("Sorry, I don't understand that input.");
            return PinCount.EMPTY;
        }
    }

    private Scoresheet addBowlers(Scoresheet scoresheet) {
        String name = prompt("Provide a Bowler Name");
        do {
            scoresheet = scoresheet.add(new Name(name));
            String names = scoresheet.printNames().collect(Collectors.joining(", "));
            System.out.println("Bowlers so far: " + names);
            name = prompt("Provide a Bowler Name (use a blank name to start bowling)");
        } while (!"".equals(name));
        return scoresheet;
    }

    private String prompt(String message) {
        System.out.println(message);
        System.out.print("> ");
        String input = scanner.nextLine();
        return input.trim();
    }
}
