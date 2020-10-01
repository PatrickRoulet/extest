package be.abis.exc2.ut;

import be.abis.exc2.model.Address;
import be.abis.exc2.model.Company;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestCompany {

    @Test
    public void taxForBelgianCompanyShouldBe51() {
        Company company = new Company("Abis",
                new Address("street","2","3000","Leuven","Belgium","BE"));
        assertThat(company.calculateTaxToPay(),equalTo(51.0));
    }

}
