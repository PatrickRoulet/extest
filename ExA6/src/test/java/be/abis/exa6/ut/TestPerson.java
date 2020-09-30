package be.abis.exa6.ut;

import be.abis.exa6.model.Person;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;

import org.hamcrest.core.StringStartsWith;

import java.time.LocalDate;

public class TestPerson {
    Person person;

    @Before
    public void setUp() {
        person = new Person(1,"Patrick","Roulet", LocalDate.of(1978,6,6));
    }

    @Test
    public void ageOfPersonFromBirthDateShouldBe42() {
        assertThat(person.calculateAge(), equalTo(42));
    }

    @Test
    public void toStringSentenceStartsWithPerson() {
        assertThat(person.toString(), startsWith("Person"));
    }
}
