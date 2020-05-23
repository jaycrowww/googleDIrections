package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MockDistanceQueryTest {
    private double ppw = 880;
    private String description = "";
    private Address address1;
    private CandidateHouse house;

    private PlaceOfImportance poi;
    private Address address2;

    private ArrayList<PlaceOfImportance> pois;
    private ArrayList<CandidateHouse> candidateHouses;



    @Before
    public void setup(){
        // create CH
        address1 = new Address("46 Ada Place Ultimo NSW 2007");

        house = new CandidateHouse(address1, CandidateHouse.HouseType.APARTMENT, ppw, description);

        // create CH list
        candidateHouses = new ArrayList<CandidateHouse>();
        candidateHouses.add(house);

        // create POI
        address2 = new Address("367 George Street Sydney NSW 2000");

        poi = new PlaceOfImportance(address2, "work");

        // create POI list
        pois = new ArrayList<PlaceOfImportance>();
        pois.add(poi);
    }

    @Test
    public void returnJsonFromResources() throws IOException {
        // create instance of class, with interface
        DistanceQuery dq = new MockDistanceQuery();

        // return test data
        assertEquals("46 Ada Pl, Ultimo NSW 2007, Australia", dq.getResults(candidateHouses, pois).get(0).getpAddress());
        assertEquals((long)2156, dq.getResults(candidateHouses,pois).get(0).getDistances().get("66 Clarence St, Sydney NSW 2000, Australia"));


    }

}