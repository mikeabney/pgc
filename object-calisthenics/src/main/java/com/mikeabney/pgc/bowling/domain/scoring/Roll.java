package com.mikeabney.pgc.bowling.domain.scoring;

public class Roll {
    private PinCount startingPins;
    private PinCount pinfall;

    public static Roll withPinfall(PinCount startingPins, PinCount pinfall) {
        validateStartingPins(startingPins);
        validatePinfall(startingPins, pinfall);
        return new Roll(startingPins, pinfall);
    }

    private static void validateStartingPins(PinCount startingPins) {
        if (startingPins.lessThan(new PinCount(1))) {
            throw new IllegalArgumentException("Cannot roll when no pins are standing.");
        }
        if (PinCount.TEN.lessThan(startingPins)) {
            throw new IllegalArgumentException("Cannot have more than ten pins standing.");
        }
    }

    private static void validatePinfall(PinCount startingPins, PinCount pinfall) {
        if (pinfall.lessThan(PinCount.ZERO)) {
            throw new IllegalArgumentException("Cannot knock down fewer than zero pins.");
        }
        if (startingPins.lessThan(pinfall)) {
            throw new IllegalArgumentException("Cannot knock down more pins than were standing.");
        }
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
}
