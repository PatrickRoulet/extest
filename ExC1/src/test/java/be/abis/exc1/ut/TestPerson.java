package be.abis.exc1.ut;

import be.abis.exc1.exception.PersonShouldBeAdultException;
import be.abis.exc1.model.Address;
import be.abis.exc1.model.Company;
import be.abis.exc1.model.Person;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class TestPerson {
    Person person;

    @Mock
    public Company company;

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

    @Test
    public void calculateNetSalaryOfBelgianPersonUsingMockCompany() {
        Person person1 = new Person(1,"Patrick","Roulet",
                LocalDate.of(1978,6,6), company, 1000.0);
        Mockito.when(company.calculateTaxToPay()).thenReturn(51.0);
        assertThat(person1.calculateNetSalary(),equalTo(490.0));
        verify(company).calculateTaxToPay();
    }

}
