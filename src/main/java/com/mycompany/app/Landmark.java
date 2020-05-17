package com.mycompany.app;

// this class is for search terms like supermarkets that users will want to know what the closest one is
public class Landmark {

    private String landmarkSearchTerm;

    public Landmark(String landmarkSearchTerm) {
        this.landmarkSearchTerm = landmarkSearchTerm;
    }

    public String getLandmarkSearchTerm() {
        return landmarkSearchTerm;
    }

    public void setLandmarkSearchTerm(String landmarkSearchTerm) {
        this.landmarkSearchTerm = landmarkSearchTerm;
    }

}
