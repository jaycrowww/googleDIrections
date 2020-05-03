package com.mycompany.app;

import java.util.ArrayList;

abstract class Place {
    // these should be protected - any class in a package can access these - typically for subclasses.
    protected Address address;
    protected ArrayList<String> descriptions = new ArrayList<>();

    public Place(Address address, String description) {
        this.address = address;
        this.descriptions.add(description);
    }

    // No Description Constructor
    public Place(Address address) {
        this(address, "");
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Return all List descriptions as String
    public String getDescriptions() {
        String outputDescriptions = "";
        for(String d: descriptions){
            outputDescriptions += " | " +  d;
        }
        return outputDescriptions;
    }

    @Override
    public String toString() {
        return address.toString() + " " + this.getDescriptions();
    }
}
