package be.abis.exc2.ut;

import be.abis.exc2.exception.PersonShouldBeAdultException;
import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Company;
import be.abis.exc2.model.Person;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;
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
                LocalDate.of(1978,6,6), company, 10000.0);
        Mockito.when(company.calculateTaxToPay()).thenReturn(51.0);
        try {
            assertThat(person1.calculateNetSalary(),equalTo(4900.0));
        } catch (SalaryTooLowException e) {
            e.printStackTrace();
        }
        verify(company).calculateTaxToPay();
    }

    @Test(expected = SalaryTooLowException.class)
    public void salaryOfPersonShouldThrowException() throws SalaryTooLowException {
        Person personWithLowSalary = new Person(2,"Patrick","Roulet",
                LocalDate.of(2006,6,6), company, 1000.0);
        double salary = personWithLowSalary.calculateNetSalary();
    }

}
