package com.mikeabney.pgc.bowling.menu;

import com.mikeabney.pgc.bowling.domain.Scoresheet;

/**
 * Created by Work on 11/18/2015.
 */
public class BowlCommand implements MenuCommand {
    @Override
    public Boolean isCorrectCommand(String reply) {
        String lowerReply = reply.toLowerCase();
        return lowerReply.startsWith("bowl") || lowerReply.startsWith("begin");
    }

    @Override
    public Scoresheet execute(Scoresheet scoresheet, String reply) {
        System.out.println("Begin Bowling!");
        return scoresheet;
    }
}
