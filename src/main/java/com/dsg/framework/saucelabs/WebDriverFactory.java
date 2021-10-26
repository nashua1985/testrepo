package com.dsg.framework.saucelabs;

import com.dsg.framework.enums.Browser;
import com.dsg.framework.properties.AutomationProperties;
import com.dsg.framework.properties.ConfigReader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

  private final Browser browser;
  private final AutomationProperties properties;
  private String methodName;
  private String buildName;
  private boolean sauceTunnel;

  public WebDriverFactory(Browser browser, AutomationProperties properties) {
    this.browser = browser;
    this.properties = properties;
  }

  public WebDriverFactory(
          Browser browser, AutomationProperties properties, String methodName, String buildName, boolean sauceTunnel) {
    this.browser = browser;
    this.properties = properties;
    this.methodName = methodName;
    this.buildName = buildName;
    this.sauceTunnel = sauceTunnel;
  }

  public synchronized WebDriver getWebDriver() throws Exception {
    switch (browser) {
        // local
      case CHROME_LOCAL:
        return getLocalChromeDriver();
      case FIREFOX_LOCAL:
        return getLocalFirefoxDriver();

        // sauce
      case CHROME_WIN:
      case CHROME_WIN_OLD:
        return getSauceLabsChromeDriver();
      case FIREFOX_WIN:
      case FIREFOX_WIN_OLD:
        return getSauceLabsFirefoxDriver();
      case EDGE_WIN:
      case EDGE_WIN_OLD:
        return getSauceLabsEdgeDriver();
      case SAFARI_MAC:
        return getSauceLabsSafariDriver();
      default:
        return getLocalChromeDriver();
    }
  }

  private WebDriver getSauceLabsChromeDriver() throws Exception {

    SauceBrowser sauceBrowser = browser.getSauceBrowser();

    MutableCapabilities sauceOpts = new MutableCapabilities();
    sauceOpts.setCapability("name", methodName);
    sauceOpts.setCapability("build", buildName);
    sauceOpts.setCapability("screenResolution", "2560x1600");

    sauceOpts.merge(useSauceTunnel());

    ChromeOptions browserOptions = new ChromeOptions();
    browserOptions.setExperimentalOption("w3c", true);
    browserOptions.setCapability("browserVersion", sauceBrowser.getSauceBrowserVersion());
    browserOptions.setCapability("platformName", sauceBrowser.getSaucePlatform());
    browserOptions.setCapability("sauce:options", sauceOpts);

    return createSauceDriver(browserOptions);

  }

  private WebDriver getSauceLabsSafariDriver() throws Exception {
    SauceBrowser sauceBrowser = browser.getSauceBrowser();

    // set true to always use tunnel for this driver
    //sauceTunnel = true;

    MutableCapabilities sauceOpts = new MutableCapabilities();
    sauceOpts.setCapability("name", methodName);
    sauceOpts.setCapability("build", buildName);
    sauceOpts.setCapability("screenResolution", "2048x1536");
    //sauceOpts.setCapability("tunnelIdentifier", sauceBrowser.getTunnelIdentifier());
    //sauceOpts.setCapability("parentTunnel", sauceBrowser.getParentTunnel());

    sauceOpts.merge(useSauceTunnel());

    SafariOptions browserOptions = new SafariOptions();
    browserOptions.setCapability("platformName", sauceBrowser.getSaucePlatform());
    browserOptions.setCapability("browserVersion", sauceBrowser.getSauceBrowserVersion());
    browserOptions.setCapability("sauce:options", sauceOpts);

    return createSauceDriver(browserOptions);
  }

  private WebDriver getSauceLabsEdgeDriver() throws Exception {
    SauceBrowser sauceBrowser = browser.getSauceBrowser();

    MutableCapabilities sauceOpts = new MutableCapabilities();
    sauceOpts.setCapability("name", methodName);
    sauceOpts.setCapability("build", buildName);
    sauceOpts.setCapability("screenResolution", "2560x1600");

    sauceOpts.merge(useSauceTunnel());

    EdgeOptions browserOptions = new EdgeOptions();
    browserOptions.setCapability("platformName", sauceBrowser.getSaucePlatform());
    browserOptions.setCapability("browserVersion", sauceBrowser.getSauceBrowserVersion());
    browserOptions.setCapability("sauce:options", sauceOpts);

    return createSauceDriver(browserOptions);
  }

  private WebDriver getSauceLabsFirefoxDriver() throws Exception {
    SauceBrowser sauceBrowser = browser.getSauceBrowser();

    MutableCapabilities sauceOpts = new MutableCapabilities();
    sauceOpts.setCapability("screenResolution", "2560x1600");
    sauceOpts.setCapability("name", methodName);
    sauceOpts.setCapability("build", buildName);

    sauceOpts.merge(useSauceTunnel());

    FirefoxOptions browserOptions = new FirefoxOptions();
    browserOptions.setCapability("browserVersion", sauceBrowser.getSauceBrowserVersion());
    browserOptions.setCapability("platformName", sauceBrowser.getSaucePlatform());
    browserOptions.setCapability("sauce:options", sauceOpts);

    return createSauceDriver(browserOptions);
  }

  private WebDriver getLocalChromeDriver() {
    ChromeOptions options = new ChromeOptions();

    return _getChromeDriver(options);
  }

  private WebDriver _getChromeDriver(ChromeOptions options) {

    String osName = System.getProperty("os.name");
    String chromedriverName = "chromedriver.exe";

    if (osName.equals("Mac OS X")) {
      chromedriverName = "chromedriver";
    }

    System.setProperty("webdriver.chrome.driver", properties.getDriverPath() + chromedriverName);
    // options.addArguments("test-type");
    // options.addArguments("disable-extensions");
    // options.addArguments();

    ChromeDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().setScriptTimeout(75, TimeUnit.SECONDS);
    driver.manage().window().maximize();

    return driver;
  }

  private WebDriver getLocalFirefoxDriver() {
    FirefoxOptions myProfile = new FirefoxOptions();

    String driverName = "geckodriver";
    if (!System.getProperty("os.name").equals("Mac OS X")) {
      driverName += ".exe";
    }

    System.setProperty("webdriver.gecko.driver", properties.getDriverPath() + driverName);

    myProfile.addPreference("xpinstall.signatures.required", false);
    myProfile.addPreference("toolkit.startup.max_resumed_crashes", "-1");
    // myProfile.setEnableNativeEvents(false);
    // myProfile.setPreference("dom.ipc.plugins.enabled", false);

    WebDriver firefox = new FirefoxDriver(myProfile);
    firefox.manage().deleteAllCookies();
    firefox.manage().window().maximize();
    ;

    firefox.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    return firefox;
  }

  private WebDriver createSauceDriver(Capabilities capabilities) throws Exception {
    WebDriver driver = null;

    try {
      String url = SauceMethods.getSauceURLString(properties.getSauceEncryptedCredential());
      driver = new RemoteWebDriver(new URL(url), capabilities);
    } catch (Exception e) {
      throw new Exception("Error connecting to saucelabs: " + e.getMessage());
    }

    return driver;
  }

  private MutableCapabilities useSauceTunnel() {

    MutableCapabilities sauceOpts = new MutableCapabilities();

    if (sauceTunnel) {
      sauceOpts.setCapability("tunnelIdentifier", ConfigReader.getProperty("tunnelIdentifier"));
      sauceOpts.setCapability("parentTunnel", ConfigReader.getProperty("parentTunnel"));

      return sauceOpts;
    }
    return sauceOpts;
  }
}
