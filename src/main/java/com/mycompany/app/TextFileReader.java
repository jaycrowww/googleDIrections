package com.mycompany.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TextFileReader implements FileReader {
    private static final java.lang.String DELIMITER = "\\|";
    private  static final java.lang.String IDENTIFIER_CANDIDATE_HOUSE = "CH";
    private static final java.lang.String IDENTIFIER_PLACE_OF_INTEREST = "POI";

    private java.lang.String fileName = "inputFile.txt";

    public ReadFile readInFile() throws IOException {
        return this.readInFile(fileName);
    }

    @Override
    public ReadFile readInFile(String inputFileName) throws FileNotFoundException, IOException {

        // Read in items into lists from file input
        List<CandidateHouse> candidateHouses = new ArrayList<CandidateHouse>();
        List<PlaceOfImportance> placeOfImportances = new ArrayList<PlaceOfImportance>();


        // ClassLoader is used to retrieve file from Resource folder
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // recommended 'Objects.requireNonNull...' to avoid a Null Pointer Exception
        File file = new File(Objects.requireNonNull(classLoader.getResource(inputFileName)).getFile());

        // To store line items from File IO
        String[] tokens;

        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                // Read in line and separate out by field value
                tokens = myReader.nextLine().split(DELIMITER);

                // Do shared stuff for Places first
                String address = tokens[1];
                String description = tokens[2];

                // check first value - which says whether it is a Candidate House (CH) or Place of Interest (POI)
                if(tokens[0].equals(IDENTIFIER_CANDIDATE_HOUSE)){

                    // Check if the houseType is one of the available enums, else assign undefined type
                    CandidateHouse.HouseType houseType;
                    try {
                        houseType = CandidateHouse.HouseType.valueOf(tokens[3]);
                    }catch(IllegalArgumentException e){
                        houseType = CandidateHouse.HouseType.UNDEFINED;
                    }
                    double ppw = Double.parseDouble(tokens[4]);

                    CandidateHouse candidateHouse = new CandidateHouse(address, houseType, ppw, description);
                    candidateHouses.add(candidateHouse);

                } else if(tokens[0].equals(IDENTIFIER_PLACE_OF_INTEREST)){
                    String alias = tokens[3];
                    PlaceOfImportance placeOfImportance = new PlaceOfImportance(address, alias, description);
                    placeOfImportances.add(placeOfImportance);

                } else{
                    // If invalid identifier - do nothing.
                }
            }
        } catch (IOException e) {
            System.out.println("An IO error occurred.");
            e.printStackTrace();
        }

        return new ReadFile(candidateHouses, placeOfImportances);
    }

    @Override
    public void overwriteDefaultFile(String inputFileName) {
        this.fileName = inputFileName;
        System.out.println("Default file is now: " + inputFileName);
    }



    public TextFileReader() throws IOException {}
}
