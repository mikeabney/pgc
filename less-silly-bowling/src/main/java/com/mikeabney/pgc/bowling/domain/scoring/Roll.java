package com.mikeabney.pgc.bowling.domain.scoring;

public class Roll {
    private static RollValidator validator = new RollValidator();
    private final PinCount startingPins;
    private final PinCount pinfall;

    public static Roll withPinfall(PinCount startingPins, PinCount pinfall) {
        validator.validateStartingPins(startingPins);
        validator.validatePinfall(startingPins, pinfall);
        return new Roll(startingPins, pinfall);
    }

    private Roll(PinCount startingPins, PinCount pinfall) {
        this.startingPins = startingPins;
        this.pinfall = pinfall;
        if (standingPins().lessThan(PinCount.ZERO)) {
            throw new IllegalArgumentException("Can't knock over more pins than remain.");
        }
    }

    public PinCount standingPins() {
        return startingPins.minus(pinfall);
    }

    public PinCount fallenPins() {
        return pinfall;
    }

    public String printFallenPins() {
        return pinfall.print();
    }

    public boolean leftPinsStanding() {
        return PinCount.ZERO.lessThan(standingPins());
    }
}
