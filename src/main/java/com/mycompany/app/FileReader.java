package com.mycompany.app;

import java.io.FileNotFoundException;

public interface FileReader {
    ReadFile readInFile() throws FileNotFoundException;
    ReadFile readInFile(String fileName) throws FileNotFoundException;
    void overwriteDefaultFile(String inputFileName);
}
