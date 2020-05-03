package com.mycompany.app;

public class Landmark {

    private String nearbyLandmarkSearchTerm;

    public Landmark(String nearbyLandmarkSearchTerm) {
        this.nearbyLandmarkSearchTerm = nearbyLandmarkSearchTerm;
    }

    public String getNearbyLandmarkSearchTerm() {
        return nearbyLandmarkSearchTerm;
    }

    public void setNearbyLandmarkSearchTerm(String nearbyLandmarkSearchTerm) {
        this.nearbyLandmarkSearchTerm = nearbyLandmarkSearchTerm;
    }

}
