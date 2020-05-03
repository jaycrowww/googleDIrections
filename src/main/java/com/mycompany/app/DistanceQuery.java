package com.mycompany.app;

public interface DistanceQuery {

    // Used for standard Google Look Ups
    public double getDist(CandidateHouse candidateHouse, PlaceOfImportance placeOfImportance, Mode mode);
    public double getTime(CandidateHouse candidateHouse, PlaceOfImportance placeOfImportance, Mode mode);

    // Used for finding nearest 'train station' or 'bakery' - could use search terms
    public double getDist(CandidateHouse candidateHouse, String landmark, Mode mode);
    public double getTime(CandidateHouse candidateHouse, String landmark, Mode mode);

    enum Mode {
        WALKING, DRIVING, CYCLING, TRANSIT
    }
}
