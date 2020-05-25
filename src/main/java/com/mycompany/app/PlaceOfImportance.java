package com.mycompany.app;

public class PlaceOfImportance extends Place {
    // potential to be Optional type Optional<String>
    private String alias;

    public PlaceOfImportance(String address){
        super(address);
    }

    // No Description
    public PlaceOfImportance(String address, String alias){
        this(address, alias, "");
    }

    public PlaceOfImportance(String address, String alias, String description){
        super(address, description);
        this.alias = alias;
    }

    // Update alias

    public void updateAlias(String alias){
        this.alias = alias;
    }

    @Override
    public String toString(){
        return address + "also known as --" + alias +  "-- " + this.appendAllDescriptions();
    }

}