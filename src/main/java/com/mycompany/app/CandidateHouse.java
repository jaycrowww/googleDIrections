package com.mycompany.app;
public class CandidateHouse extends Place {
    private HouseType houseType;
    private double ppw;

    // potential for number of bed and bathroom

    public CandidateHouse(Address address, HouseType houseType, double ppw, String description) {
        super(address, description);
        this.houseType = houseType;
        if(ppw > 0) {
            this.ppw = ppw;
        }
    }

    // If no description added initially
    public CandidateHouse(Address address, HouseType houseType, double ppw){
        this(address, houseType, ppw, "");
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

    // add to notes ongoing notes about a place
    public void addToDescription(String additionalNotes){
        // add description to list
        this.descriptions.add(additionalNotes);
    }

    enum HouseType
    {
        HOUSE, APARTMENT, UNIT, TOWNHOUSE
    }

}
