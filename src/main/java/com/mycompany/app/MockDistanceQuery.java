package com.mycompany.app;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

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
        JSONArray rows = (JSONArray) rawData.get("rows");

        // Number of origin_addresses returned from Google
        JSONArray origins = (JSONArray) rawData.get("origin_addresses");
        int numOrigins = origins.size();

        // Number of destinations
        JSONArray destinations = (JSONArray)rawData.get("destination_addresses");
        int numDestinations = destinations.size();

        // JSON PARSING
        // Initialise Result Lists
        List<Result> results = new ArrayList<Result>();

        // CH loop
        for(int i = 0; i < numOrigins; i++){
            JSONObject row = (JSONObject)rows.get(i);
            String address = (String)origins.get(i);

            Map<String, Number> mapDistance = new HashMap<>();
            Map<String, Number> mapDuration = new HashMap<>();

            for(int j=0; j<numDestinations; j++){
                //Destination address
                String poiName = (String) destinations.get(j);

                // Traversing nested data
                JSONArray elements = (JSONArray)row.get("elements");
                JSONObject element = (JSONObject)elements.get(j);

                // distance
                JSONObject distance = (JSONObject) element.get("distance");
                long metres = (long) distance.get("value");

                // duration
                JSONObject duration = (JSONObject) element.get("duration");
                long seconds = (long) duration.get("value");


                // Map values
                mapDistance.put(poiName, metres);
                mapDuration.put(poiName, seconds);
            }

            // Create result in one line
            Result result = new Result(address, mapDistance, mapDuration);

            results.add(result);
        }
        return results;
    }
}


