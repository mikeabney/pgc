package com.mikeabney.pgc.bowling.domain.scoring;

import java.util.ArrayList;
import java.util.List;

public class TenthFrameRolls {
    public static final TenthFrameRolls EMPTY = new TenthFrameRolls();
    private final List<Roll> list;

    private TenthFrameRolls() {
        list = new ArrayList<>();
    }

    private TenthFrameRolls(TenthFrameRolls other, Roll roll) {
        list = new ArrayList<>(other.list);
        list.add(roll);
    }

    public TenthFrameRolls add(PinCount pinfall) {
        if (isFull()) {
            throw new IllegalStateException("Tenth frame is full.");
        }
        PinCount startingPins = determineStartingPins();
        Roll newRoll = Roll.withPinfall(startingPins, pinfall);
        return new TenthFrameRolls(this, newRoll);
    }

    private PinCount determineStartingPins() {
        if (list.isEmpty()) {
            return PinCount.TEN;
        }
        if (PinCount.ZERO.equals(lastRollStandingPins())) {
            return PinCount.TEN;
        }
        return lastRollStandingPins();
    }

    private PinCount lastRollStandingPins() {
        return lastRoll().standingPins();
    }

    private Roll lastRoll() {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public boolean isFull() {
        if (list.size() == 3) {
            return true;
        }
        if (list.size() == 2 && !(firstRollWasStrike() || secondRollWasStrikeOrSpare())) {
            return true;
        }
        return false;
    }

    private boolean secondRollWasStrikeOrSpare() {
        Roll secondRoll = list.get(1);
        return !secondRoll.leftPinsStanding();
    }

    private boolean firstRollWasStrike() {
        Roll firstRoll = list.get(0);
        return !firstRoll.leftPinsStanding();
    }
}
