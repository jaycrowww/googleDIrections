package com.mycompany.app;

// NOTE: Alex recommends not allowing modification of Addresses. Rather delete and replace.
// possibly make them 'final'
public class AddressBuilder {
    private static final String DEFAULT_COUNTRY = "AUSTRALIA";

    private String addressL1;
    private String addressL2;
    private String suburb;
    private String state;
    private String postCode;
    private String country = DEFAULT_COUNTRY;

    public AddressBuilder setAddressL1(String addressL1) {
        this.addressL1 = addressL1;
        return this;
    }

    public AddressBuilder setAddressL2(String addressL2) {
        this.addressL2 = addressL2;
        return this;
    }

    public AddressBuilder setSuburb(String suburb) {
        this.suburb = suburb;
        return this;
    }

    public AddressBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public AddressBuilder setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public AddressBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public Address createAddress() {
        return new Address(addressL1, addressL2, suburb, state, postCode, country);
    }
}