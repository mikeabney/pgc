package com.mikeabney.pgc.bowling.menu;

import com.mikeabney.pgc.bowling.domain.Scoresheet;

/**
 * Created by Work on 11/18/2015.
 */
public class HelpCommand implements MenuCommand {
    @Override
    public Boolean isCorrectCommand(String reply) {
        return reply.toLowerCase().startsWith("help");
    }

    @Override
    public Scoresheet execute(Scoresheet scoresheet, String reply) {
        System.out.println("The following commands are available");
        System.out.println("Help: Displays this assistance");
        System.out.println("Add <Bowler>: Adds a bowler to the game");
        // System.out.println("Remove <Bowler>: Removes a bowler from the game");
        System.out.println("Bowl: Starts the game");
        System.out.println("Begin: Starts the game");

        return scoresheet;
    }
}
