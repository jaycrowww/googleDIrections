package com.mycompany.app;

import java.util.Map;

/* Stores the result of the candidateHouse in relation to the pois */
public class Result {
    public Result(String pAddress, Map<String, Number> distances, Map<String, Number> durations) {
        this.pAddress = pAddress;
        this.distances = distances;
        this.durations = durations;
    }

    // Address stored as String for ease, may revise later
    private String pAddress;

    // first String is the destination address as a string
    private Map<String, Number> distances;
    private Map<String, Number> durations;

    public String getpAddress() {
        return pAddress;
    }

    public Map<String, Number> getDistances() {
        return distances;
    }

    public Map<String, Number> getDurations() {
        return durations;
    }
}
