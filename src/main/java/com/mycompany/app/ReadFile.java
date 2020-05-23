package com.mycompany.app;

import java.util.List;

/** Data class to return read in data from file */

public class ReadFile {

    private List<CandidateHouse> candidateHouses;
    private List<PlaceOfImportance> pois;



    public ReadFile(List<CandidateHouse> candidateHouses, List<PlaceOfImportance> pois) {
        this.candidateHouses = candidateHouses;
        this.pois = pois;
    }

    public List<CandidateHouse> getCandidateHouses() {
        return candidateHouses;
    }

    public List<PlaceOfImportance> getPois() {
        return pois;
    }



}
