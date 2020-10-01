package be.abis.exb1.ut;

import be.abis.exb1.exception.PersonShouldBeAdultException;
import be.abis.exb1.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;

import java.time.LocalDate;

public class TestPerson {
    Person person;

    @BeforeEach
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

    @Test
    public void ageOfPersonShouldThrowException() throws PersonShouldBeAdultException {
        Person person18 = new Person(2,"Patrick","Roulet", LocalDate.of(2006,6,6));
        Exception exception = assertThrows(PersonShouldBeAdultException.class, () -> {
            int age = person18.calculateAge();
        });
    }
}
