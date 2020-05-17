package com.mycompany.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public class MockDistanceQuery implements DistanceQuery {

    private static final String FILENAME = "mockedData2On4D.json";

    @Override
    public String getResults(List<CandidateHouse> candidateHouses, List<PlaceOfImportance> pois, Mode mode) throws IOException {
        return retrieveRawData(candidateHouses, pois, mode);

    }


    // Default to Driving
    @Override
    public String getResults(List<CandidateHouse> candidateHouses, List<PlaceOfImportance> pois) throws IOException {
        return getResults(candidateHouses, pois, Mode.DRIVING);
    }

    private String retrieveRawData(List<Place> CandidateHouses, List<Place> pois, Mode mode) throws IOException {
        // Method used to access files from Resource Folder
        // Source: https://howtodoinjava.com/java/io/read-file-from-resources-folder/
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        // recommended 'Objects.requireNonNull...' to avoid a Null Pointer Exception
        File file = new File(Objects.requireNonNull(classLoader.getResource(FILENAME)).getFile());

        System.out.println("File Found : " + file.exists());
        String content = new String(Files.readAllBytes(file.toPath()));
        System.out.println(content);
        return content;
    }
}



    // Used for standard Google Look Ups
//    @Override
//    public double getDistance(Address address1, Address address2, Mode mode){
//
//        // API CALL
//
//        return -1.0;
//}
//
//    @Override
//    public double getTime(Address address1, Address address2, Mode mode){
//        // API CALL
//        return -1.0;
//    }

