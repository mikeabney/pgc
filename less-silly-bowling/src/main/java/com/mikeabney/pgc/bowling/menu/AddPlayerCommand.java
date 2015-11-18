package com.mikeabney.pgc.bowling.menu;

import com.mikeabney.pgc.bowling.domain.Name;
import com.mikeabney.pgc.bowling.domain.Scoresheet;

/**
 * Created by Work on 11/18/2015.
 */
public class AddPlayerCommand implements MenuCommand {
    @Override
    public Boolean isCorrectCommand(String reply) {
        return reply.toLowerCase().startsWith("add ");
    }

    @Override
    public Scoresheet execute(Scoresheet scoresheet, String reply) {
        String name = reply.substring(4);
        return scoresheet.add(new Name(name));
    }
}
