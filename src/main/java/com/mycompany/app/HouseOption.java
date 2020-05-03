package com.mycompany.app;
public class HouseOption {
    private Address address;
    private HouseType houseType;
    private double ppw;
    private String description;

    public HouseOption(Address address, HouseType houseType, double ppw, String description) {
        this.address = address;
        this.houseType = houseType;
        if(ppw > 0) {
            this.ppw = ppw;
        }
        this.description = description;
    }

    // If no description added initially
    public HouseOption(Address address, HouseType houseType, double ppw){
        this(address, houseType, ppw, "");
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public double getPpw() {
        return ppw;
    }

    public void updatePpw(double ppw) {
        if(ppw > 0){
            this.ppw = ppw;
        }
    }

    public String getDescription() {
        return description;
    }

    // add to notes ongoing notes about a place
    public void addToDescription(String additionalNotes){

        // determine if separator needed
        if(!this.description.isEmpty()){
            this.description += "; ";
        }
        this.description += additionalNotes;
        }

    enum HouseType
    {
        HOUSE, APARTMENT, UNIT, TOWNHOUSE
    }



}
