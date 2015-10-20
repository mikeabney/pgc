package com.mikeabney.pgc.bowling.domain.scoring;

public class Roll {
    private PinCount startingPins;
    private PinCount pinfall;


    public static Roll withPinfall(PinCount startingPins, PinCount pinfall) {
        return new Roll(startingPins, pinfall);
    }

    private Roll(PinCount startingPins, PinCount pinfall) {
        this.startingPins = startingPins;
        this.pinfall = pinfall;
        if (standingPins().lessThan(PinCount.ZERO)) {
            throw new IllegalArgumentException("Can't knock over more pins than remain.");
        }
    }

    public boolean leftPinsStanding() {
        return standingPins().greaterThan(PinCount.ZERO);
    }

    public PinCount standingPins() {
        return startingPins.minus(pinfall);
    }

    public PinCount fallenPins() {
        return pinfall;
    }
}
