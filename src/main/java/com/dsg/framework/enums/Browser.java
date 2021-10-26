package com.dsg.framework.enums;

import com.dsg.framework.saucelabs.MobileSauceBrowser;
import com.dsg.framework.saucelabs.SauceBrowser;

public enum Browser {

  // Sauce
  CHROME_WIN("Chrome-Win-Latest", constants.SAUCE_CHROME_LATEST, null),
  CHROME_WIN_OLD("Chrome-Win-Latest(-1)", constants.SAUCE_CHROME_LATEST_OLD, null),
  FIREFOX_WIN("Firefox-Win-Latest", constants.SAUCE_FIREFOX_LATEST, null),
  FIREFOX_WIN_OLD("Firefox-Win-Latest(-1)", constants.SAUCE_FIREFOX_LATEST_OLD, null),
  EDGE_WIN("Edge-Win-Latest", constants.SAUCE_EDGE_LATEST, null),
  EDGE_WIN_OLD("Edge-Win-Latest", constants.SAUCE_EDGE_LATEST_OLD, null),
  SAFARI_MAC("Safari-Mac-Latest", constants.SAUCE_SAFARI_LATEST, null),

  // Local
  CHROME_LOCAL("Chrome-Local", null, null),
  FIREFOX_LOCAL("Firefox-Local", null, null),

  // Mobile App
  ANDROID_LOCAL("Android-Local", null, null),
  ANDROID_PIXEL3_PROD("Android-Pixel3-Prod", null, constants.SAUCE_ANDROID_PIXEL3_10_PROD),
  ANDROID_PIXEL3_QA("Android-Pixel3-QA", null, constants.SAUCE_ANDROID_PIXEL3_10_QA),

  // Mobile Web
  ANDROID_PIXEL3_11_CHROME("Android-Pixel3-Chrome", null, constants.SAUCE_ANDROID_PIXEL3_11_CHROME),
  ANDROID_S9_PLUS_CHROME("Android_S9_Plus_Chrome", null, constants.SAUCE_ANDROID_SAMSUNG_GALAXY_S9_PLUS_CHROME),
  IPHONE_12_PRO_SAFARI("iOS-Iphone_12_Pro-Safari", null, constants.SAUCE_IOS_IPHONE_12_PRO_SAFARI);


  protected final String displayName;
  protected final SauceBrowser sauceBrowser;
  protected final MobileSauceBrowser mobileBrowser;

  Browser(String displayName, SauceBrowser sauceBrowser, MobileSauceBrowser mobileBrowser) {
    this.displayName = displayName;
    this.sauceBrowser = sauceBrowser;
    this.mobileBrowser = mobileBrowser;
  }

  public String getDisplayName() {
    return displayName;
  }

  public SauceBrowser getSauceBrowser() {
    return sauceBrowser;
  }

  public MobileSauceBrowser getMobileBrowser() {
    return mobileBrowser;
  }

  protected static class constants {

    // Web
    public static final SauceBrowser SAUCE_CHROME_LATEST =
            new SauceBrowser("chrome", "latest", "Windows 10");
    public static final SauceBrowser SAUCE_CHROME_LATEST_OLD =
            new SauceBrowser("chrome", "latest-1", "Windows 10");
    public static final SauceBrowser SAUCE_FIREFOX_LATEST =
            new SauceBrowser("firefox", "latest", "Windows 10");
    public static final SauceBrowser SAUCE_FIREFOX_LATEST_OLD =
            new SauceBrowser("firefox", "latest-1", "Windows 10");
    public static final SauceBrowser SAUCE_EDGE_LATEST =
            new SauceBrowser("edge", "latest", "Windows 10");
    public static final SauceBrowser SAUCE_EDGE_LATEST_OLD =
            new SauceBrowser("edge", "latest-1", "Windows 10");
    public static final SauceBrowser SAUCE_SAFARI_LATEST =
            new SauceBrowser("safari", "latest", "macOS 10.15");


    // Mobile
    public static final MobileSauceBrowser SAUCE_ANDROID_PIXEL3_10_PROD =
            new MobileSauceBrowser(
                    "",
                    "10.0",
                    "Android",
                    "1.17.1",
                    "Google Pixel 3 GoogleAPI Emulator",
                    "portrait",
                    MobileSauceBrowser.PROD_fileName,
                    "dsgui.android",
                    "dsgui.android.activity.MainActivity");

    public static final MobileSauceBrowser SAUCE_ANDROID_PIXEL3_10_QA =
            new MobileSauceBrowser(
                    "",
                    "10.0",
                    "Android",
                    "1.17.1",
                    "Google Pixel 3 GoogleAPI Emulator",
                    "portrait",
                    MobileSauceBrowser.QA_fileName,
                    "dsgui.android",
                    "dsgui.android.activity.MainActivity");


    public static final MobileSauceBrowser SAUCE_ANDROID_PIXEL3_11_CHROME =
            new MobileSauceBrowser(
                    "Chrome",
                    "11.0",
                    "Android",
                    "1.20.2",
                    "Google Pixel 3 GoogleAPI Emulator",
                    "portrait");

    public static final MobileSauceBrowser SAUCE_IOS_IPHONE_12_PRO_SAFARI =
            new MobileSauceBrowser(
                    "Safari",
                    "14.3",
                    "iOS",
                    "1.20.1",
                    "iPhone 12 Pro Simulator",
                    "portrait");
    public static final MobileSauceBrowser SAUCE_ANDROID_SAMSUNG_GALAXY_S9_PLUS_CHROME=
            new MobileSauceBrowser(
                    "Chrome",
                    "8.1",
                    "Android",
                    "1.9.1",
                    "Samsung Galaxy S9 Plus WQHD GoogleAPI Emulator",
                    "portrait"
            );
  }
}

