package com.mycompany.app;

public class MockDistanceQuery implements DistanceQuery {

    private double testVal = 12.0;
    // Used for standard Google Look Ups
    @Override
    public double getDist(CandidateHouse candidateHouse, PlaceOfImportance placeOfImportance, Mode mode){
        return testVal;
    };
    @Override
    public double getTime(CandidateHouse candidateHouse, PlaceOfImportance placeOfImportance, Mode mode){
        return testVal;
    };
    @Override
    // Used for finding nearest 'train station' or 'bakery' - could use search terms
    public double getDist(CandidateHouse candidateHouse, String landmark, Mode mode){
        return testVal;
    };
    @Override
    public double getTime(CandidateHouse candidateHouse, String landmark, Mode mode){
        return testVal;
    };
}
