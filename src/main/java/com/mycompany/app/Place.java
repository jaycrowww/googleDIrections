package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

abstract class Place {
    // these should be protected - any class in a package can access these - typically for subclasses.
    protected String address;
    protected ArrayList<String> descriptions = new ArrayList<>();

    public Place(String address, String description) {
        this.address = address;
        this.descriptions.add(description);
    }

    // No Description Constructor
    public Place(String address) {
        this(address, "");
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Return all List descriptions as String
    public String appendAllDescriptions() {
        StringBuilder outputDescriptions = new StringBuilder();
        for(String d: descriptions){
            if(outputDescriptions.length() > 0){
                outputDescriptions.append(" | ");
            }
            outputDescriptions.append(d);
        }
        return outputDescriptions.toString();
    }

    @Override
    public String toString() {
        return address + " " + this.appendAllDescriptions();
    }

    public List<String> getDescriptions() {
        return descriptions;
    }
    // add to notes ongoing notes about a place
    public void addToDescription(String additionalNotes){
        // add description to list
        this.descriptions.add(additionalNotes);
    }

    public String returnDescriptionNo(int i){
        return this.descriptions.get(i-1);
    }
}
