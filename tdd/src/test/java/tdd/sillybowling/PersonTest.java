package tdd.sillybowling;

import com.jprusakova.tdd.InvalidInputException;
import com.jprusakova.tdd.sillybowling.Person;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    private Person person;

    @Test(expected = InvalidInputException.class)
    public void nullNameShouldThrowException() {
        person = new Person(null);
    }

    @Test(expected = InvalidInputException.class)
    public void shortNameShouldThrowException() {
        person = new Person("A");
    }

    @Test
    public void createPersonWithGoodName() {
        String goodName = "Ada";
        person = new Person(goodName);
        Assert.assertEquals(goodName, person.getFirstName());
    }

    @Test
    public void checkFourLetterName() {
        String goodName = "Ada";
        person = new Person(goodName);
        Assert.assertEquals(4, person.getFourLetterName().length());
    }

    @Test
    public void checkFourLetterNameForPersonWithLongName() {
        String goodName = "Adamson";
        person = new Person(goodName);
        Assert.assertEquals(4, person.getFourLetterName().length());
    }
}
