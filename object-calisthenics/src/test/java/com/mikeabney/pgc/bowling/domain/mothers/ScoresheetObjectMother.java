package com.mikeabney.pgc.bowling.domain.mothers;

import com.mikeabney.pgc.bowling.domain.Scoresheet;
import com.mikeabney.pgc.bowling.domain.scoring.PinCount;

import static com.mikeabney.pgc.bowling.domain.mothers.NameObjectMother.*;

public class ScoresheetObjectMother {
    public static Scoresheet partialGame() {
        Scoresheet scoresheet = Scoresheet.EMPTY;
        scoresheet = addThreeBowlers(scoresheet);
        for (int index = 0 ; index < 7 ; index++){
            scoresheet = rollStrike(scoresheet);
            scoresheet = rollGutterSpare(scoresheet);
            scoresheet = rollOneSeven(scoresheet);
        }
        return scoresheet;
    }

    public static Scoresheet completeGame() {
        Scoresheet scoresheet = Scoresheet.EMPTY;
        scoresheet = addThreeBowlers(scoresheet);
        for (int index = 0 ; index < 9 ; index++){
            scoresheet = rollStrike(scoresheet);
            scoresheet = rollGutterSpare(scoresheet);
            scoresheet = rollOneSeven(scoresheet);
        }
        scoresheet = rollStrike(scoresheet);
        scoresheet = rollStrike(scoresheet);
        scoresheet = rollStrike(scoresheet);
        scoresheet = rollGutterSpare(scoresheet);
        scoresheet = rollGutter(scoresheet);
        scoresheet = rollOneSeven(scoresheet);
        return scoresheet;
    }

    private static Scoresheet rollStrike(Scoresheet scoresheet) {
        return scoresheet.roll(PinCount.TEN);
    }

    private static Scoresheet rollGutter(Scoresheet scoresheet) {
        return scoresheet.roll(PinCount.ZERO);
    }

    private static Scoresheet rollGutterSpare(Scoresheet scoresheet) {
        Scoresheet returnScoresheet = rollGutter(scoresheet);
        return returnScoresheet.roll(PinCount.TEN);
    }

    private static Scoresheet rollOneSeven(Scoresheet scoresheet) {
        Scoresheet returnScoresheet = scoresheet.roll(new PinCount(1));
        return returnScoresheet.roll(new PinCount(7));
    }
    private static Scoresheet addThreeBowlers(Scoresheet scoresheet) {
        Scoresheet returnScoresheet = scoresheet.add(adam);
        returnScoresheet = returnScoresheet.add(beth);
        return returnScoresheet.add(charles);
    }
}
