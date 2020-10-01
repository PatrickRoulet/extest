package be.abis.exc2.service;

import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Person;

public class AbisPaymentService implements PaymentService {

    @Override
    public void paySalary(Person person) throws SalaryTooLowException {
        System.out.println("Paying "+person.calculateNetSalary()+" euros to "+person.getFirstName());
    }
}
