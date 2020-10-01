package be.abis.exc2.ut;

import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.service.AbisPaymentService;
import be.abis.exc2.service.PaymentService;
import be.abis.exc2.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {

    @Mock
    public Person person;

    @Before
    public void setUp() {
        person = new Person();
    }

    @Test(expected = SalaryTooLowException.class)
    public void salaryOfPersonShouldThrowException() throws SalaryTooLowException {
        PaymentService paymentService = new AbisPaymentService();
        Mockito.when(person.calculateNetSalary()).thenThrow(new SalaryTooLowException());
        paymentService.paySalary(person);
    }
}
