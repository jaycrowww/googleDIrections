package com.mycompany.app;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Objects;

public class MockDistanceQuery implements DistanceQuery {

    private static final String FILENAME = "mockedData2On4D.json";

    @Override
    public String getResults(List<CandidateHouse> candidateHouses, List<PlaceOfImportance> pois, Mode mode) throws IOException {
        JSONObject jo = retrieveRawData(candidateHouses, pois, mode);
        System.out.println(jo);
        return null;

    }


    // Default to Driving
    @Override
    public String getResults(List<CandidateHouse> candidateHouses, List<PlaceOfImportance> pois) throws IOException {
        return getResults(candidateHouses, pois, Mode.DRIVING);
    }

    private JSONObject retrieveRawData(List<CandidateHouse> CandidateHouses, List<PlaceOfImportance> pois, Mode mode) throws IOException {
        // Method used to access files from Resource Folder
        JSONParser parser = new JSONParser();

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // recommended 'Objects.requireNonNull...' to avoid a Null Pointer Exception
        File file = new File(Objects.requireNonNull(classLoader.getResource(FILENAME)).getFile());

        try(Reader reader = new FileReader(file)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return jsonObject;
        } catch (ParseException e) {
            throw new IOException("Mock data parse failed, simulating IO exception", e);
        }
    }

//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//
//        // recommended 'Objects.requireNonNull...' to avoid a Null Pointer Exception
//        File file = new File(Objects.requireNonNull(classLoader.getResource(FILENAME)).getFile());
//
//        System.out.println("File Found : " + file.exists());
//        String content = new String(Files.readAllBytes(file.toPath()));
//        System.out.println(content);
//        return content;
//    }
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

