package com.mycompany.app;

/**
 * Hello world!
 *
 */

/**KEY = AIzaSyAhxpRrpkyhXxG-QlhqlEWXjaBJp-LEphQ*/
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
                .setAddressL1("82 Mary Ann")
                .setAddressL2("Apartment 52")
                .setCountry("Australia")
                .setPostCode("2007")
                .setState("NSW")
                .setSuburb("Ultimo")
                .createAddress();

        HouseOption option1 = new HouseOption(address1, HouseOption.HouseType.APARTMENT, ppw, description);

        System.out.println("House Option 1 Address: " + option1.getAddress());
        System.out.println("House Option 1 House TYpe: " + option1.getHouseType());
        System.out.println("House Option 1 PPW: " + option1.getPpw());
        System.out.println("House Option 1 Description: " + option1.getDescription());

        // testing adding notes
        option1.addToDescription("stomping heard from the 5th floor 03/05/2020");
        System.out.println("House Option 1 Updated Description: " + option1.getDescription());





    }
}
