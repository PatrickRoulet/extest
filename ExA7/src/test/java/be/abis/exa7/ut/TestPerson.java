package be.abis.exa7.ut;

import be.abis.exa7.exception.PersonShouldBeAdultException;
import be.abis.exa7.model.Person;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;

import java.time.LocalDate;

public class TestPerson {
    Person person;

    @Before
    public void setUp() {
        person = new Person(1,"Patrick","Roulet", LocalDate.of(1978,6,6));
    }

    @Test
    public void ageOfPersonFromBirthDateShouldBe42() {
        try {
            assertThat(person.calculateAge(), equalTo(42));
        } catch (PersonShouldBeAdultException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void toStringSentenceStartsWithPerson() {
        assertThat(person.toString(), startsWith("Person"));
    }

    @Test(expected = PersonShouldBeAdultException.class)
    public void ageOfPersonShouldThrowException() throws PersonShouldBeAdultException {
        Person person18 = new Person(2,"Patrick","Roulet", LocalDate.of(2006,6,6));
        int age = person18.calculateAge();
    }
}
