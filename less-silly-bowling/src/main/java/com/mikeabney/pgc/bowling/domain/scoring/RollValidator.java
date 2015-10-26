package com.mikeabney.pgc.bowling.domain.scoring;

class RollValidator {

    void validateStartingPins(PinCount startingPins) {
        if (startingPins.lessThan(new PinCount(1))) {
            throw new IllegalArgumentException("Cannot roll when no pins are standing.");
        }
        if (PinCount.TEN.lessThan(startingPins)) {
            throw new IllegalArgumentException("Cannot have more than ten pins standing.");
        }
    }

    void validatePinfall(PinCount startingPins, PinCount pinfall) {
        if (pinfall.lessThan(PinCount.ZERO)) {
            throw new IllegalArgumentException("Cannot knock down fewer than zero pins.");
        }
        if (startingPins.lessThan(pinfall)) {
            throw new IllegalArgumentException("Cannot knock down more pins than were standing.");
        }
    }
}
