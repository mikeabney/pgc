package com.mikeabney.pgc.bowling.domain.scoring;

public class PinCount {
    public static final PinCount TEN = new PinCount(10);
    public static final PinCount ZERO = new PinCount(0);

    private final int count;

    public PinCount(int count) {
        this.count = count;
    }

    public PinCount plus(PinCount pinCount) {
        return new PinCount(count + pinCount.count);
    }

    public PinCount minus(PinCount pinCount) {
        return new PinCount(count - pinCount.count);
    }

    public boolean lessThan(PinCount pinCount) {
        return count < pinCount.count;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PinCount) {
            return count == ((PinCount)obj).count;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return count;
    }
}
