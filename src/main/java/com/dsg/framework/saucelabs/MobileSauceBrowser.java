package com.dsg.framework.saucelabs;

public class MobileSauceBrowser {

  protected final String browserName;
  protected final String platformVersion;
  protected final String platformName;
  protected final String appiumVersion;
  protected final String deviceName;
  protected final String deviceOrientation;
  protected String app;
  protected String appPackage;
  protected String appActivity;

  // File Name for android mobile apk file on sauce
  // Will need moved to new location
  public static String PROD_fileName = "storage:filename=DSG_PROD.apk";
  public static String QA_fileName = "storage:filename=DSG_QA.apk";
  // public static String QA_fileName = "storage:92a5e775-0e25-4fbe-88bd-289f4206a417";

  // Mobile App
  public MobileSauceBrowser(
      String browserName,
      String platformVersion,
      String platformName,
      String appiumVersion,
      String deviceName,
      String deviceOrientation,
      String app,
      String appPackage,
      String appActivity) {
    this.browserName = browserName;
    this.platformVersion = platformVersion;
    this.platformName = platformName;
    this.appiumVersion = appiumVersion;
    this.deviceName = deviceName;
    this.deviceOrientation = deviceOrientation;
    this.app = app;
    this.appPackage = appPackage;
    this.appActivity = appActivity;
  }

  // Mobile Web
  public MobileSauceBrowser(
          String browserName,
          String platformVersion,
          String platformName,
          String appiumVersion,
          String deviceName,
          String deviceOrientation) {
    this.browserName = browserName;
    this.platformVersion = platformVersion;
    this.platformName = platformName;
    this.appiumVersion = appiumVersion;
    this.deviceName = deviceName;
    this.deviceOrientation = deviceOrientation;
  }

  public String getBrowserName() {
    return browserName;
  }
  public String getPlatformVersion() {
    return platformVersion;
  }
  public String getPlatformName() {
    return platformName;
  }
  public String getAppiumVersion() {
    return appiumVersion;
  }
  public String getDeviceName() {
    return deviceName;
  }
  public String getDeviceOrientation() {
    return deviceOrientation;
  }
  public String getAppPackage() {
    return appPackage;
  }
  public String getAppActivity() {
    return appActivity;
  }
  public String getApp() {
    return app;
  }
  public String getQA_fileName() {
    return QA_fileName;
  }
  public String getPROD_fileName() {
    return PROD_fileName;
  }
}
