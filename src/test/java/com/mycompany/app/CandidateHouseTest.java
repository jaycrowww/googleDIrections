package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CandidateHouseTest {

    private double ppw;
    private String description;
    private Address address;
    private CandidateHouse house;


    @Before
    public void setUp() {
        // Uses Address building pattern so that variables will always be structured
        // create component / dependency first and then pass to HouseOption
        address = new Address("46 Ada Place Ultimo NSW 2007");

       description = "Open space fourth story apartment with carpet";
       ppw = 880.0;

       house = new CandidateHouse(address, CandidateHouse.HouseType.APARTMENT, ppw, description);
    }

    @Test
    public void updatePpw() {
        house.updatePpw(890.0);
        assertEquals(890.0, house.getPpw(), 0.0001);
    }


}