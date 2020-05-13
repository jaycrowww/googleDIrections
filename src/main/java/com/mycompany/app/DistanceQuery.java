package com.mycompany.app;

public interface DistanceQuery {

    // Used for standard Google Look Ups
    double getDistance(Address address1, Address address2, Mode mode);
    double getTime(Address address1, Address address2, Mode mode);
}
