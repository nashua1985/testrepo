package com.dsg.framework.entities;

// May be missing variable for ios
// May need more variables for sauce devices

public class MobileDevice {

  private String id;
  private String type;
  private String deviceName;
  private String platformName;
  private String platformVersion;
  private String appPackage;
  private String appActivity;
  private String url;

  public MobileDevice(
      String id,
      String type,
      String deviceName,
      String platformName,
      String platformVersion,
      String appPackage,
      String appActivity,
      String url) {
    this.id = id;
    this.type = type;
    this.deviceName = deviceName;
    this.platformName = platformName;
    this.platformVersion = platformVersion;
    this.appPackage = appPackage;
    this.appActivity = appActivity;
    this.url = url;
  }

  public MobileDevice(MobileDevice parentDevice) {

    this(
        parentDevice.getId(),
        parentDevice.getType(),
        parentDevice.getDeviceName(),
        parentDevice.getPlatformName(),
        parentDevice.getPlatformVersion(),
        parentDevice.getAppPackage(),
        parentDevice.getAppActivity(),
        parentDevice.getUrl());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getPlatformName() {
    return platformName;
  }

  public void setPlatformName(String platformName) {
    this.platformName = platformName;
  }

  public String getPlatformVersion() {
    return platformVersion;
  }

  public void setPlatformVersion(String platformVersion) {
    this.platformVersion = platformVersion;
  }

  public String getAppPackage() {
    return appPackage;
  }

  public void setAppPackage(String appPackage) {
    this.appPackage = appPackage;
  }

  public String getAppActivity() {
    return appActivity;
  }

  public void setAppActivity(String appActivity) {
    this.appActivity = appActivity;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "MobileDevice{"
        + "id='"
        + id
        + '\''
        + ", type='"
        + type
        + '\''
        + ", deviceName='"
        + deviceName
        + '\''
        + ", platformName='"
        + platformName
        + '\''
        + ", platformVersion='"
        + platformVersion
        + '\''
        + ", appPackage='"
        + appPackage
        + '\''
        + ", appActivity='"
        + appActivity
        + '\''
        + ", url='"
        + url
        + '\''
        + '}';
  }
}
