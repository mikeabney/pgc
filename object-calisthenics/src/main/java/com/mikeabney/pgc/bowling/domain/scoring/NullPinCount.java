package com.mikeabney.pgc.bowling.domain.scoring;

/**
 * A PinCount that mathematically acts like a PinCount of zero, however from an object perspective it is an "empty"
 * value.
 */
public class NullPinCount extends PinCount {

    NullPinCount() {
        super(Integer.MIN_VALUE);
    }

    public PinCount plus(PinCount pinCount) {
        return new PinCount(pinCount.count);
    }

    public PinCount minus(PinCount pinCount) {
        return new PinCount(0 - pinCount.count);
    }

    public boolean lessThan(PinCount pinCount) {
        return 0 < pinCount.count;
    }

    public String print() {
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NullPinCount) {
            return true;
        }
        return false;
    }
}
