package com.dsg.testng.basetest;

import com.dsg.framework.enums.Browser;
import com.dsg.framework.enums.BrowserSet;
import com.dsg.framework.enums.RunType;
import com.dsg.framework.loggers.ReportUtilities;
import com.dsg.framework.loggers.TestNGLogMethods;
import com.dsg.framework.properties.AutomationProperties;
import com.dsg.framework.properties.InitProperties;
import com.dsg.framework.saucelabs.SauceMethods;
import com.dsg.framework.saucelabs.WebDriverFactory;
import com.dsg.framework.xml.XMLUrl;
import com.dsg.testng.web.resources.WebNavigation;
import com.saucelabs.saucerest.SauceREST;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class WebDriverBaseTest {

  protected static AutomationProperties properties;
  protected static XMLUrl urls;
  protected static Browser sauceBrowserInput;
  protected static Browser localBrowserInput;
  protected static BrowserSet browserSetInput;
  protected static String buildName;
  protected static boolean sauceTunnelInput;

  private RunType runType;
  // protected boolean screenshotEnabled = false;

  private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<>();
  private final ThreadLocal<String> sessionId = new ThreadLocal<>();

  protected ThreadLocal<String> methodName = new ThreadLocal<>();

  protected static ThreadLocal<WebNavigation> navigation = new ThreadLocal<>();



  /** @return the {@link WebDriver} for the current thread */
  public static RemoteWebDriver getRemoteWebDriver() {
    return remoteWebDriver.get();
  }

  protected static WebNavigation getWebNavigation() {
    return navigation.get();
  }

  protected String getMethodName() {
    return methodName.get();
  }

  protected String getSessionId() {
    return sessionId.get();
  }

  protected String getJobURL() {
    return "http://saucelabs.com/jobs/" + this.getSessionId();
  }

  private void createSauceDriver(WebDriver driver) {

    remoteWebDriver.set((RemoteWebDriver) driver);
    sessionId.set(remoteWebDriver.get().getSessionId().toString());

    // set current sessionId
    String id = getRemoteWebDriver().getSessionId().toString();
    sessionId.set(id);
  }

  private void createLocalDriver(WebDriver driver) {

    remoteWebDriver.set((RemoteWebDriver) driver);
  }

  @DataProvider(name = "sauceBrowsers", parallel = true)
  public static Object[][] sauceBrowserDataProvider(Method beforeMethod) {
    RunType runType = RunType.SAUCE;

    if (browserSetInput != null) {

      return browserSetInput.getBrowserObject();

    } else {

      return new Object[][] {new Object[] {sauceBrowserInput, runType}};
    }
  }

  @DataProvider(name = "localBrowsers")
  public static Object[][] localBrowserDataProvider(Method beforeMethod) {
    RunType runType = RunType.LOCAL;

    return new Object[][] {new Object[] {localBrowserInput, runType}};
  }

  protected void createDriver(Browser browser, String methodName, RunType runType)
      throws Exception {

    this.runType = runType;

    WebDriverFactory factory = new WebDriverFactory(browser, properties, methodName, buildName, sauceTunnelInput);

    switch (runType) {
      case LOCAL:
        createLocalDriver(factory.getWebDriver());
        break;
      case SAUCE:
        createSauceDriver(factory.getWebDriver());
        break;
    }

    navigation.set(new WebNavigation(getRemoteWebDriver()));
  }

  @Parameters({"jenkins", "sauceBrowser", "localBrowser", "browserSet", "sauceTunnel"})
  @BeforeClass
  public void initProperties(
          @Optional("false") String jenkins,
      @Optional("CHROME_WIN") String sauceBrowser,
      @Optional("CHROME_LOCAL") String localBrowser,
      @Optional("") String browserSet,
          @Optional("false") String sauceTunnel)
      throws Exception {

    if (jenkins.equals("false")) {
      properties = InitProperties.setProperties();
      System.out.println("Properties initialized");

    } else if (jenkins.equals("true")) {
      properties = InitProperties.setPropertiesJenkins();
      System.out.println("Properties initialized - jenkins");
    }

    if (sauceTunnel.equals("true")) {
      sauceTunnelInput = true;
    }

    // Initialize properties
    //properties = InitProperties.setProperties();
    //System.out.println("Properties initialized");

    // Set Browser
    try {
      sauceBrowserInput = Browser.valueOf(sauceBrowser);
    } catch (IllegalArgumentException e) {
      System.out.println("sauceBrowser input not valid - check Browser class");
      e.printStackTrace();
    }

    try {
      localBrowserInput = Browser.valueOf(localBrowser);
    } catch (IllegalArgumentException e) {
      System.out.println("LocalBrowser input not valid - check Browser class");
      e.printStackTrace();
    }

    if (!browserSet.equals("")) {

      try {
        browserSetInput = BrowserSet.valueOf(browserSet);
      } catch (IllegalArgumentException e) {
        Assert.fail("BrowserSet input not valid - check BrowserSet class");
        e.printStackTrace();
      }
    }

    // Set url path
    urls = new XMLUrl(XMLUrl.URLS_PATH);

    // Set buildName
    String className = this.getClass().getSimpleName();
    buildName = className + "_" + ReportUtilities.formattedDateTime();

    // Start SauceRest
    SauceREST sauceREST = SauceMethods.getSauceRest(properties.getSauceEncryptedCredential());
    new SauceMethods(sauceREST);
  }

  @BeforeMethod
  public void setMethod(Method method) {
    methodName.set(method.getName());
  }

  // Method that gets invoked after test
  @AfterMethod
  public void tearDown(ITestResult result) {
    try {
      if (runType.equals(RunType.SAUCE)) {

        SauceMethods.updateResults(result.isSuccess(), getSessionId());
        // ((JavascriptExecutor) remoteWebDriver.get())
        // .executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
      }
    } finally {
      TestNGLogMethods.clearLogStepCount();
      remoteWebDriver.get().quit();
    }
  }

  void annotate(String text) {
    if (runType.equals(RunType.SAUCE)) {
      ((JavascriptExecutor) remoteWebDriver.get()).executeScript("sauce:context=" + text);
    }
  }

  public static String getBuildName() {
    return buildName;
  }
}
