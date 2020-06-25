package ru.vorobyov;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesValue {
    private final String PATH_TO_PROPERTIES = "src\\main\\resources\\properties\\properties.properties";

    private String inputFilePath;
    private String outputFilePath;

    public PropertiesValue() throws IOException {
        FileInputStream fileInputStream;
        Properties prop = new Properties();

        fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
        prop.load(fileInputStream);

        inputFilePath = prop.getProperty("inputFile");
        outputFilePath = prop.getProperty("outputFile");
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

}
