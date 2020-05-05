package com.mycompany.app;

// this class is for search terms like supermarkets that users will want to know what the closest one is
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
