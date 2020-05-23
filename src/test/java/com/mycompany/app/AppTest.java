package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    private CandidateHouse option1;
    private PlaceOfImportance place1;
    @Before
    public void setUp(){

        double ppw = 880.0;
        String description = "Open space fourth story apartment with carpet";

        // Uses Address building pattern so that variables will always be structured
        // create component / dependency first and then pass to HouseOption
        Address address1 = new Address("46 Ada Place Ultimo NSW 2007");

        option1 = new CandidateHouse(address1, CandidateHouse.HouseType.APARTMENT, ppw, description);
        // testing adding notes
        option1.addToDescription("stomping heard from the 5th floor 03/05/2020");

        // Control - same address, should return zero for distance
        Address poiAddress1 = new Address("46 Ada Place Ultimo NSW 2007");

        // WORK, no AddressL2 assigned
        Address poiAddress2 = new Address("367 George Street Sydney NSW 2000");

        // Boxing Gym
        // No country set
        Address poiAddress3 = new Address("3 Allen St, Waterloo NSW 2017");


        // Create places of importance
        place1 = new PlaceOfImportance(poiAddress1, "Home");
        PlaceOfImportance place2 = new PlaceOfImportance(poiAddress2, "Work");
        PlaceOfImportance place3= new PlaceOfImportance(poiAddress3, "Boxing gym");

        // Create list of POI
        ArrayList<PlaceOfImportance> places = new ArrayList<>();
        places.add(place1);
        places.add(place2);
        places.add(place3);



        System.out.println("List of Places of Importance: ");
        for(PlaceOfImportance p: places){
            System.out.println(p + " ");
        }

        // Update Alias of POI
        places.get(2).updateAlias("FUTURE Boxing gym");
        System.out.println(places.get(2));

        // Create Landmarks
        Landmark supermarket = new Landmark("supermarket");
        Landmark petrolStation = new Landmark("petrol station");

        // Create List of Landmarks
        ArrayList<Landmark> landmarks = new ArrayList<>();
        landmarks.add(supermarket);
        landmarks.add(petrolStation);
    }

    @org.junit.Test
    public void testApp()
    {
//        assertTrue( true );
//
//        DistanceQuery distanceQuery = new MockDistanceQuery();
//        distanceQuery.getDistance(option1, place1, Mode.DRIVING);
//        System.out.println("testApp: " + distanceQuery.getDistance(option1,place1, Mode.DRIVING));
//        assertEquals(12.0, distanceQuery.getDistance(option1,place1, Mode.DRIVING));
    }
}
