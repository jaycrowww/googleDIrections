package com.mycompany.app;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MockDistanceQuery implements DistanceQuery {

    private static final String FILENAME = "mockedData2On4D.json";
    private static final int ROWS = 2;

    private List<Result> results;

    @Override
    public List<Result> getResults(List<CandidateHouse> candidateHouses, List<PlaceOfImportance> pois, Mode mode) throws IOException {
        JSONObject rawData = retrieveRawData(candidateHouses, pois, mode);
        return parseRawJSONIntoFormattedResults(rawData);
    }


    // Default to Driving - start with driving and then refactor data type to hold modes
    @Override
    public List<Result> getResults(List<CandidateHouse> candidateHouses, List<PlaceOfImportance> pois) throws IOException {
        return getResults(candidateHouses, pois, Mode.DRIVING);
    }

    /* Mock solution to the Google API Call */
    private JSONObject retrieveRawData(List<CandidateHouse> CandidateHouses, List<PlaceOfImportance> pois, Mode mode) throws IOException {
        // Method used to access files from Resource Folder
        JSONParser parser = new JSONParser();

        // ClassLoader is used to retrieve file from Resource folder
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // recommended 'Objects.requireNonNull...' to avoid a Null Pointer Exception
        File file = new File(Objects.requireNonNull(classLoader.getResource(FILENAME)).getFile());

        try (Reader reader = new FileReader(file)) {
            JSONObject resultsJsonObject = (JSONObject) parser.parse(reader);
            return resultsJsonObject;
        } catch (ParseException e) {
            throw new IOException("Mock data parse failed, simulating IO exception", e);
        }
    }

    private List<Result> parseRawJSONIntoFormattedResults(JSONObject rawData) {
        JSONArray destinations = (JSONArray)rawData.get("destination_addresses");

        for (Object d: destinations) {
        }


        // JSON PARSING
        System.out.println(rawData.size());
        // testing accessing nested data
        JSONArray rows = (JSONArray) rawData.get("rows");
        JSONObject row = (JSONObject)rows.get(0);
        JSONArray elements = (JSONArray)row.get("elements");
        JSONObject element = (JSONObject)elements.get(0);
        JSONObject duration = (JSONObject) element.get("duration");
        long seconds = (long) duration.get("value");

        System.out.println("seconds: " + seconds);

//        // NOTE: this brings nothing back at the top layer.
//        JSONArray elements = (JSONArray) rawData.get("elements");
//        System.out.println(elements);
//        System.out.println("size of elements: " + rows.size());



        List<Result> temp = new ArrayList<Result>();

        return temp;
    }
}


