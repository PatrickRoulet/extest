package be.abis.exa2.ut;

import be.abis.exa2.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TestPerson {
    @Test
    public void ageOfPersonFromBirthDateShouldBe42 () {
        Person person = new Person(1,"Patrick","Roulet", LocalDate.of(1978,6,6));
        Assert.assertEquals(42,person.calculateAge());
    }
}
