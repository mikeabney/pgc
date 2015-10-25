package com.jprusakova.tdd.sillybowling;

import com.jprusakova.tdd.InvalidInputException;

public class Person {
    private String firstName;

    public Person(String name) {
        if (null == name || name.length() < 2 ) {
            throw new InvalidInputException("Bad input for Person: " + name);
        }
        firstName = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFourLetterName() {
        if (firstName.length() < 5) {
            return String.format("%4s", firstName);
        }

        return firstName.substring(0, 4);
    }
}
