package com.jprusakova.tdd.money.currency;

public class NoRateAvailableException extends RuntimeException {
    private long timestamp;

    public NoRateAvailableException(long timestamp) {
        this.timestamp = timestamp;
    }

    public NoRateAvailableException() {
        this(Long.MIN_VALUE);
    }
    public long getTimestamp() {
        return timestamp;
    }
}
