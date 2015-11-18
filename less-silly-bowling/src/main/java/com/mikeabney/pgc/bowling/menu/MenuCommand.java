package com.mikeabney.pgc.bowling.menu;

import com.mikeabney.pgc.bowling.domain.Scoresheet;

/**
 * Created by Work on 11/18/2015.
 */
public interface MenuCommand {
    Boolean isCorrectCommand(String reply);

    Scoresheet execute(Scoresheet scoresheet, String reply);
}
