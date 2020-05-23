package com.mycompany.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class TextFileReader implements FileReader {
    private String fileName = "Addresses.txt";


    public ReadFile readInFile() throws FileNotFoundException {
        return this.readInFile(fileName);
    }

    @Override
    public ReadFile readInFile(String inputFileName) throws FileNotFoundException {
        // ClassLoader is used to retrieve file from Resource folder
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // recommended 'Objects.requireNonNull...' to avoid a Null Pointer Exception
        File file = new File(Objects.requireNonNull(classLoader.getResource(inputFileName)).getFile());
        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void overwriteDefaultFile(String inputFileName) {
        this.fileName = inputFileName;
        System.out.println("Default file is now: " + inputFileName);
    }



    public TextFileReader() throws FileNotFoundException {
    }
}
