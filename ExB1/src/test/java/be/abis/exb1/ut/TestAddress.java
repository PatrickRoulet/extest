package be.abis.exb1.ut;

import be.abis.exb1.model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestAddress {

    Address address;

    @BeforeEach
    public void setUp() {
        address = new Address("street","12","3000","Leuven","Belgium","BE");
    }

    @Test
    public void belgianZipCodeShouldBeNumeric() {
        Assertions.assertEquals(true,address.checkBelgianZipCode()&&address.isZipCodeNumeric());
    }

    @Test
    public void addressShouldBeAddedToFile() {
        Path path = Paths.get("addressinfo.txt");
        try ( BufferedWriter bw = Files.newBufferedWriter(path)){
            bw.write(address + "\n");
            bw.write(address + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assertThat(Files.readAllLines(path).size(), equalTo(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
