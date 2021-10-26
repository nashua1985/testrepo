package com.dsg.framework.saucelabs;

import com.dsg.framework.entities.MobileDevice;
import com.dsg.framework.enums.Browser;
import com.dsg.framework.properties.AutomationProperties;
import com.dsg.framework.properties.ConfigReader;
import com.dsg.framework.xml.XMLMobileDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriverFactory {

  private Browser browser;
  private AutomationProperties properties;
  private String methodName;
  private String buildName;
  private boolean sauceTunnel;

  private static final String username = System.getenv("SAUCE_USERNAME");
  private static final String accessKey = System.getenv("SAUCE_ACCESS_KEY");
  private static final String tunnel = System.getenv("SAUCE_TUNNEL_ID");

  public MobileDriverFactory(Browser browser, AutomationProperties properties) {
    this.browser = browser;
    this.properties = properties;
  }

  public MobileDriverFactory(
          Browser browser, AutomationProperties properties, String methodName, String buildName, boolean sauceTunnel) {
    this.browser = browser;
    this.properties = properties;
    this.methodName = methodName;
    this.buildName = buildName;
    this.sauceTunnel = sauceTunnel;
  }

  public synchronized WebDriver getMobileDriver() throws Exception {
    switch (browser) {
      case ANDROID_LOCAL:
        return getLocalAndroidDefaultDriver();
      case ANDROID_PIXEL3_PROD:
      case ANDROID_PIXEL3_QA:
        return getSauceAndroidDriver();
      case ANDROID_PIXEL3_11_CHROME:
      case ANDROID_S9_PLUS_CHROME:
        return getSauceAndroidDriverWeb();
      case IPHONE_12_PRO_SAFARI:
        return getSauceIOSDriverWeb();
      default:
        return getLocalAndroidDefaultDriver();
    }
  }

  private WebDriver getLocalAndroidDefaultDriver() throws Exception {
    XMLMobileDevice devices = new XMLMobileDevice(XMLMobileDevice.MOBILE_DEVICE_PATH);
    MobileDevice device =
        new MobileDevice(devices.getMobileDevice(properties.getDefaultMobileDevice()));

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("deviceName", device.getDeviceName());
    caps.setCapability("platformName", device.getPlatformName());
    caps.setCapability("platformVersion", device.getPlatformVersion());
    caps.setCapability("appPackage", device.getAppPackage());
    caps.setCapability("appActivity", device.getAppActivity());

    URL url = null;
    try {
      url = new URL(device.getUrl());
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return new AndroidDriver(url, caps);
  }

  private WebDriver getSauceAndroidDriver() throws MalformedURLException {

    MobileSauceBrowser mobileBrowser = browser.getMobileBrowser();

    DesiredCapabilities caps = DesiredCapabilities.android();
    caps.setCapability("name", methodName);
    caps.setCapability("build", buildName);
    caps.setCapability("appiumVersion", mobileBrowser.getAppiumVersion());
    caps.setCapability("deviceName", mobileBrowser.getDeviceName());
    caps.setCapability("deviceOrientation", mobileBrowser.getDeviceOrientation());
    caps.setCapability("browserName", mobileBrowser.getBrowserName());
    caps.setCapability("platformVersion", mobileBrowser.getPlatformVersion());
    caps.setCapability("platformName", mobileBrowser.getPlatformName());
    caps.setCapability("app", mobileBrowser.getApp());
    caps.setCapability("appPackage", mobileBrowser.getAppPackage());
    caps.setCapability("appActivity", mobileBrowser.getAppActivity());

    caps.merge(useSauceTunnel());

    String url = SauceMethods.getSauceURLString(properties.getSauceEncryptedCredential());

    return new AndroidDriver(new URL(url), caps);
  }

  private WebDriver getSauceAndroidDriverWeb() throws MalformedURLException {

    MobileSauceBrowser mobileBrowser = browser.getMobileBrowser();

    DesiredCapabilities caps = DesiredCapabilities.android();
    caps.setCapability("name", methodName);
    caps.setCapability("build", buildName);
    caps.setCapability("appiumVersion", mobileBrowser.getAppiumVersion());
    caps.setCapability("deviceName", mobileBrowser.getDeviceName());
    caps.setCapability("deviceOrientation", mobileBrowser.getDeviceOrientation());
    caps.setCapability("browserName", mobileBrowser.getBrowserName());
    caps.setCapability("platformVersion", mobileBrowser.getPlatformVersion());
    caps.setCapability("platformName", mobileBrowser.getPlatformName());
    caps.setCapability("gpsEnabled", false);

    caps.merge(useSauceTunnel());

    String url = SauceMethods.getSauceURLString(properties.getSauceEncryptedCredential());

    return new AndroidDriver(new URL(url), caps);
  }
  private WebDriver getSauceIOSDriverWeb() throws MalformedURLException {

    MobileSauceBrowser mobileBrowser = browser.getMobileBrowser();

    // set true to always use tunnel for this driver
    //sauceTunnel = true;

    DesiredCapabilities caps = DesiredCapabilities.iphone();
    caps.setCapability("name", methodName);
    caps.setCapability("build", buildName);
    caps.setCapability("appiumVersion", mobileBrowser.getAppiumVersion());
    caps.setCapability("deviceName", mobileBrowser.getDeviceName());
    caps.setCapability("deviceOrientation", mobileBrowser.getDeviceOrientation());
    caps.setCapability("browserName", mobileBrowser.getBrowserName());
    caps.setCapability("platformVersion", mobileBrowser.getPlatformVersion());
    caps.setCapability("platformName", mobileBrowser.getPlatformName());
//    caps.setCapability("autoAcceptAlerts", true);
    caps.setCapability("locationServicesEnabled", false);

    caps.merge(useSauceTunnel());

    String url = SauceMethods.getSauceURLString(properties.getSauceEncryptedCredential());

    return new IOSDriver(new URL(url), caps);
  }

  private DesiredCapabilities useSauceTunnel() {

    DesiredCapabilities caps = new DesiredCapabilities();

    if (sauceTunnel) {
      caps.setCapability("tunnelIdentifier", ConfigReader.getProperty("tunnelIdentifier"));
      caps.setCapability("parentTunnel", ConfigReader.getProperty("parentTunnel"));

      return caps;
    }
    return caps;
  }
}
