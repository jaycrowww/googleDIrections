package com.mycompany.app;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TextFileReaderTest {

    @Test
    public void readInFile() throws IOException {
        String expectedAddress = "46 Ada Place Ultimo NSW 2007";
        int expectedNoPois = 4;
        int expectedNoCH = 2;




        FileReader fileReader = new TextFileReader();
        ReadFile readFile = fileReader.readInFile("inputFile.txt");

        assertEquals(expectedAddress, readFile.getCandidateHouses().get(0).getAddress());
        assertEquals(expectedNoCH, readFile.getCandidateHouses().size());
        assertEquals(expectedNoPois, readFile.getPois().size());
        assertEquals(CandidateHouse.HouseType.APARTMENT,readFile.getCandidateHouses().get(1).getHouseType());

    }
}