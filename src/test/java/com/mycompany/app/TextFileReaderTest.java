package com.mycompany.app;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextFileReaderTest {

    @Test
    public void readInFile() throws IOException {
        String expectedAddress = "46 Ada Place Ultimo NSW 2007";
        int expectedNoPois = 4;
        int expectedNoCH = 2;
        List<String> expectedPOINoDescription = new ArrayList<String>();
        expectedPOINoDescription.add("");

        FileReader fileReader = new TextFileReader();
        ReadFile readFile = fileReader.readInFile("inputFile.txt");

        // Validating whether data from provided file has been read in
        // Address of CH
        assertEquals(expectedAddress, readFile.getCandidateHouses().get(0).getAddress());
        // Size of CH and POIs arrays
        assertEquals(expectedNoCH, readFile.getCandidateHouses().size());
        assertEquals(expectedNoPois, readFile.getPois().size());
        // House Type of CH
        assertEquals(CandidateHouse.HouseType.APARTMENT,readFile.getCandidateHouses().get(1).getHouseType());
        // Empty string  returned... TODO:check whether this is desirable behaviour
        assertEquals(expectedPOINoDescription.size(), readFile.getPois().get(0).getDescriptions().size());

    }
}