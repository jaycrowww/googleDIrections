package com.mycompany.app;



public class Address {

    private String addressL1;
    private String addressL2;
    private String suburb;
    private String state;
    private String postCode;
    private  String country;

    // Address Constructor with arguments
    public Address(String addressL1, String addressL2, String suburb, String state, String postCode, String country) {
        this.addressL1 = addressL1;
        this.addressL2 = addressL2;
        this.suburb = suburb;
        this.state = state;
        this.postCode = postCode;
        this.country = country;
    }

    public String getAddressL1() {
        return addressL1;
    }

    public String getAddressL2() {
        return addressL2;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getState() {
        return state;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString(){
        return addressL1 + " " +  addressL2 + " " +  suburb +  " " +  state + " " +  postCode + " " + country;
    }
}
