package com.mycompany.app;

import org.junit.Test;

import java.io.IOException;

public class TextFileReaderTest {

    @Test
    public void readInFile() throws IOException {
        FileReader fileReader = new TextFileReader();
        fileReader.readInFile();
    }
}