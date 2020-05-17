package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaceTest {

    private double ppw;
    private String description;
    private Address address;
    private Place house;


    @Before
    public void setUp() {
        // Uses Address building pattern so that variables will always be structured
        // create component / dependency first and then pass to HouseOption
        address = new AddressBuilder()
                .setAddressL1("46 Ada Place")
                .setPostCode("2007")
                .setState("NSW")
                .setSuburb("Ultimo")
                .createAddress();

        description = "Open space fourth story apartment with carpet";
        ppw = 880.0;

        house = new CandidateHouse(address, CandidateHouse.HouseType.APARTMENT, ppw, description);
    }

    @Test
    public void appendAllDescriptions() {
        // Update Description
        house.addToDescription("stomping heard from the 5th floor 03/05/2020");
        assertEquals(description + " | stomping heard from the 5th floor 03/05/2020", house.appendAllDescriptions());
    }

    @Test
    public void addToDescription() {
        assertEquals(description, house.appendAllDescriptions());

        // Update Description
        house.addToDescription("stomping heard from the 5th floor 03/05/2020");
        house.addToDescription("colder than expected in winter");

        assertEquals(3, house.getDescriptions().size());
        assertEquals("stomping heard from the 5th floor 03/05/2020", house.returnDescriptionNo(2));
    }
}

