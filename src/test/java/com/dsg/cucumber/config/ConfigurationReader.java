package com.dsg.cucumber.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties configFile;
    private static final String PATH_PROPERTY = "/src/test/java/com/dsg/cucumber/config/properties/";

    static {
        String path = System.getProperty("user.dir") + PATH_PROPERTY;
        try(FileInputStream input = new FileInputStream(path+"configuration.properties");){
            //location of properties file
            //get that file as a stream
            //create object of Properties class
            configFile = new Properties();
            //load properties file into Properties object
            configFile.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }
    /**
     * This method returns property value from configuration.properties file
     * @param keyName property name
     * @return property value
     */
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }
}
