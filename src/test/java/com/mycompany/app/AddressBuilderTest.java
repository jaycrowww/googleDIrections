package com.mycompany.app;

import org.junit.Assert;
import org.junit.Test;

public class AddressBuilderTest {

    @Test
    public void testToString(){
        Address address1 = new AddressBuilder()
            .setAddressL1("82 Mary Ann Street")
            .setAddressL2("Apartment 52")
            .setCountry("Australia")
            .setPostCode("2007")
            .setState("NSW")
            .setSuburb("Ultimo")
            .createAddress();

        Assert.assertEquals("82 Mary Ann Street Apartment 52 Ultimo NSW 2007 Australia", address1.toString());
    }

}