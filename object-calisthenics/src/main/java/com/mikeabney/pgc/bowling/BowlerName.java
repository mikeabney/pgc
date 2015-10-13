package com.mikeabney.pgc.bowling;

public class BowlerName {
    private final String value;

    public BowlerName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BowlerName) {
            String otherValue = ((BowlerName)obj).value;
            return otherValue.equals(value);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
