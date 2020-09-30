package be.abis.exa4.ut;

import be.abis.exa4.model.Address;
import be.abis.exa4.model.Company;
import be.abis.exa4.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TestAddress {
    @Test
    public void belgianZipCodeShouldBeNumeric() {
        Address address = new Address("street","12","3000","Leuven","Belgium","BE");
        Assert.assertEquals(true,address.checkBelgianZipCode()&&address.isZipCodeNumeric());
    }
}
