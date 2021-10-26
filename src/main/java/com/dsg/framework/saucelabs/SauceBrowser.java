package com.dsg.framework.saucelabs;

public class SauceBrowser {

  protected final String sauceBrowser;
  protected final String sauceBrowserVersion;
  protected final String saucePlatform;

  public SauceBrowser(String sauceBrowser,
                      String sauceBrowserVersion,
                      String saucePlatform){
    this.sauceBrowser = sauceBrowser;
    this.sauceBrowserVersion = sauceBrowserVersion;
    this.saucePlatform = saucePlatform;
  }

  public String getSauceBrowser() {
    return sauceBrowser;
  }
  public String getSauceBrowserVersion() {
    return sauceBrowserVersion;
  }
  public String getSaucePlatform() {
    return saucePlatform;
  }
}
