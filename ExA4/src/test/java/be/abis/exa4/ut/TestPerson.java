package be.abis.exa4.ut;

import be.abis.exa4.model.Person;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;

public class TestPerson {
    @Test
    public void ageOfPersonFromBirthDateShouldBe42 () {
        Person person = new Person(1,"Patrick","Roulet", LocalDate.of(1978,6,6));
        assertThat(person.calculateAge(), new IsEqual(42));
    }
}
