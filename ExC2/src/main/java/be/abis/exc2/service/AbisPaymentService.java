package be.abis.exc2.service;

import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Person;
import be.abis.exc2.service.PaymentService;

public class AbisPaymentService implements PaymentService {

    @Override
    public void paySalary(Person person) {
        try {
            System.out.println("Paying "+person.calculateNetSalary()+" euros to "+person.getFirstName());
        } catch (SalaryTooLowException e) {
            e.printStackTrace();
        }
    }
}
