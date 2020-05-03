package com.mycompany.app;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        double ppw = 880.0;
        String description = "Open space fourth story apartment with carpet";

        // Uses Address building pattern so that variables will always be structured
        // create component / dependency first and then pass to HouseOption
        Address address1 = new AddressBuilder()
                .setAddressL1("82 Mary Ann Street")
                .setAddressL2("Apartment 52")
                .setCountry("Australia")
                .setPostCode("2007")
                .setState("NSW")
                .setSuburb("Ultimo")
                .createAddress();

        CandidateHouse option1 = new CandidateHouse(address1, CandidateHouse.HouseType.APARTMENT, ppw, description);

        System.out.println("House Option 1 Address: " + option1.getAddress());
        System.out.println("House Option 1 House TYpe: " + option1.getHouseType());
        System.out.println("House Option 1 PPW: " + option1.getPpw());
        System.out.println("House Option 1 Description: " + option1.getDescriptions());

        // testing adding notes
        option1.addToDescription("stomping heard from the 5th floor 03/05/2020");
        System.out.println("House Option 1 Updated Description: " + option1.getDescriptions());

        // Control - same address, should return zero for distance
        Address poiAddress1 = new AddressBuilder()
                .setAddressL1("82 Mary Ann Street")
                .setAddressL2("Apartment 52")
                .setCountry("Australia")
                .setPostCode("2007")
                .setState("NSW")
                .setSuburb("Ultimo")
                .createAddress();

        // WORK, no AddressL2 assigned
        Address poiAddress2 = new AddressBuilder()
                .setAddressL1("400 George Street")
                .setCountry("Australia")
                .setPostCode("2000")
                .setState("NSW")
                .setSuburb("Sydney")
                .createAddress();

        // Boxing Gym
        // No country set
        Address poiAddress3 = new AddressBuilder()
                .setAddressL1("3 Allen Street")
                .setPostCode("2017")
                .setState("NSW")
                .setSuburb("Waterloo")
                .createAddress();

        PlaceOfImportance place1 = new PlaceOfImportance(poiAddress1, "Home");
        PlaceOfImportance place2 = new PlaceOfImportance(poiAddress2, "Work");
        PlaceOfImportance place3= new PlaceOfImportance(poiAddress3, "Boxing gym");

        ArrayList<PlaceOfImportance> places = new ArrayList<>();
        places.add(place1);
        places.add(place2);
        places.add(place3);



        System.out.println("List of Places of Importance: ");
        for(PlaceOfImportance p: places){
            System.out.println(p + " ");
        }

        places.get(2).updateAlias("FUTURE Boxing gym");
        System.out.println(places.get(2));


        Landmark supermarket = new Landmark("supermarket");
        Landmark petrolStation = new Landmark("petrol station");

        ArrayList<Landmark> landmarks = new ArrayList<>();
        landmarks.add(supermarket);
        landmarks.add(petrolStation);

        System.out.println(landmarks.get(0).getNearbyLandmarkSearchTerm());

        // How to store the distances
        // could do a list for a single a HouseOption object to its neighbours
        // store in a matrix? list of lists.
        //

    }
}
