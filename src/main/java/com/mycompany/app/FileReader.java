package com.mycompany.app;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileReader {
    ReadFile readInFile() throws FileNotFoundException, IOException;
    ReadFile readInFile(String fileName) throws FileNotFoundException, IOException;
    void overwriteDefaultFile(String inputFileName);
}
