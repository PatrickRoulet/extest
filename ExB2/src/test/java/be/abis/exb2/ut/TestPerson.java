package be.abis.exb2.ut;

import be.abis.exb2.exception.PersonShouldBeAdultException;
import be.abis.exb2.model.Person;
import org.junit.*;
import org.junit.experimental.categories.Category;

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
    @Category(Categories.CalculateAgeTests.class)
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
    @Category(Categories.CalculateAgeTests.class)
    public void ageOfPersonShouldThrowException() throws PersonShouldBeAdultException {
        Person person18 = new Person(2,"Patrick","Roulet", LocalDate.of(2006,6,6));
        int age = person18.calculateAge();
    }
}
