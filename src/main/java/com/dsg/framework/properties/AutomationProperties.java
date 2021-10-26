package com.dsg.framework.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class reads in and holds values stored in a specified properties file. Typically, these
 * values do not change from run to run.
 */
public class AutomationProperties {

  protected String propertiesFilePath;
  protected String propertiesDirectory;
  protected String outputDirectory;
  protected String resultsDirectory;
  protected String sauceEncryptedCredential;
  protected String driverPath;
  protected String screenshotPath;
  protected String defaultMobileDevice;

  public AutomationProperties(String filePath) throws FileNotFoundException, IOException {

    this.propertiesFilePath = filePath;
    this.readPropertiesFromFile();
  }

  public String getPropertiesFilePath() {
    return propertiesFilePath;
  }

  public String getPropertiesDirectory() {
    return propertiesDirectory;
  }

  public String getOutputDirectory() {
    return outputDirectory;
  }

  public String getResultsDirectory() {
    return resultsDirectory;
  }

  public String getSauceEncryptedCredential() {
    return sauceEncryptedCredential;
  }

  public String getDriverPath() {
    return driverPath;
  }

  public String getScreenshotPath() {
    return screenshotPath;
  }

  public String getDefaultMobileDevice() {
    return defaultMobileDevice;
  }

  private void readPropertiesFromFile() throws FileNotFoundException, IOException {

    Properties prop = new Properties();
    prop.load(new FileInputStream(propertiesFilePath));

    this.outputDirectory = prop.getProperty("outputDirectory");
    this.resultsDirectory = prop.getProperty("resultsDirectory");
    this.sauceEncryptedCredential = prop.getProperty("sauceCredential");
    this.driverPath = prop.getProperty("driverPath");
    this.screenshotPath = prop.getProperty("screenshotPath");
    this.propertiesDirectory =
        System.getProperty("user.home") + prop.getProperty("propertiesDirectory");
    this.defaultMobileDevice = prop.getProperty("defaultMobileDevice");
  }
}
