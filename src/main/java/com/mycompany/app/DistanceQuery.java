package com.mycompany.app;

import java.io.IOException;
import java.util.List;

public interface DistanceQuery {
    //TODO: pass two lists of candidateHouse addresses, and of PlaceOfImportance Addresses
    // Because, GOOGLE distance api matrix takes multiples origins & destinations. Looks to be the one API Call

    // Used for standard Google Look Ups
    // Parsing as Places because only Addresses are important in this case - which a attribute of parent class Place
    String getResults(List<CandidateHouse> candidateHouses, List<PlaceOfImportance> pois, Mode mode) throws IOException;
    String getResults(List<CandidateHouse> candidateHouses, List<PlaceOfImportance> pois) throws IOException;

    // Not needed because API call returns distance and duration together - singular call.
//    double getDistance(Address address1, Address address2, Mode mode);
//    double getTime(Address address1, Address address2, Mode mode);
}
