package com.mikeabney.pgc.bowling.domain;

public class Name {
    private final String value;

    public Name(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Name) {
            String otherValue = ((Name)obj).value;
            return otherValue.equals(value);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
