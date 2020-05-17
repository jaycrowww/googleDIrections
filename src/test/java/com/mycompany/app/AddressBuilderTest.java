package com.mycompany.app;

import org.junit.Assert;
import org.junit.Test;

public class AddressBuilderTest {

    @Test
    public void testToString(){
        Address address = new AddressBuilder()
                .setAddressL1("46 Ada Place")
                .setPostCode("2007")
                .setState("NSW")
                .setSuburb("Ultimo")
                .createAddress();

        Assert.assertEquals("46 Ada Place Ultimo NSW 2007 Australia", address.toString());
    }

}