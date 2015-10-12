package com.mikeabney.pgc.lambda;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;

    public Sex getGender() {
        return gender;
    }

    public int getAge() {
        Period timeSinceBirth = Period.between(birthday, LocalDate.now());
        return timeSinceBirth.getYears();
    }

    public void printPerson() {
        System.out.println(name);
    }

    private static void printPersons(
        List<Person> roster, CheckPerson tester) { // Takes the func interface
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsEligibleForSelectiveService(List<Person> roster) {
        printPersons(
                roster,
                (Person p) -> p.getGender() == Person.Sex.MALE // Inline lambda
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );
    }

    public static boolean checkIfMale(Person person) {
        return Sex.MALE == person.gender;
    }

    public static void printMales(List<Person> roster) {
        printPersons(roster, Person::checkIfMale); // References method with same signature
    }
}