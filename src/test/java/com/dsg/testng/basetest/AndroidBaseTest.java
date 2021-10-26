package com.dsg.testng.basetest;

import com.dsg.framework.enums.Browser;
import com.dsg.framework.enums.RunType;
import com.dsg.framework.loggers.ReportUtilities;
import com.dsg.framework.loggers.TestNGLogMethods;
import com.dsg.framework.properties.AutomationProperties;
import com.dsg.framework.properties.InitProperties;
import com.dsg.framework.saucelabs.MobileDriverFactory;
import com.dsg.framework.saucelabs.SauceMethods;
import com.dsg.testng.android.resources.AndroidMobileActions;
import com.saucelabs.saucerest.SauceREST;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

// Every android test should extend this BaseTest

public class AndroidBaseTest {

  protected static AutomationProperties properties;
  protected static Browser sauceBrowserInput;
  protected static Browser localBrowserInput;
  private RunType runType;

  protected static String buildName;
  protected boolean screenshotEnabled = false;
  protected static boolean sauceTunnelInput;

  private final ThreadLocal<AndroidDriver> androidDriver = new ThreadLocal<>();
  private ThreadLocal<String> sessionId = new ThreadLocal<>();
  protected ThreadLocal<String> methodName = new ThreadLocal<>();
  protected static ThreadLocal<AndroidMobileActions> actions = new ThreadLocal<>();


  protected AndroidDriver getAndroidWebDriver() {
    return androidDriver.get();
  }

  protected static AndroidMobileActions getAndroidMobileActions() {
    return actions.get();
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

  private void createSauceDriver(AndroidDriver driver) {

    androidDriver.set(driver);

    // set current sessionId
    String id = getAndroidWebDriver().getSessionId().toString();
    sessionId.set(id);
  }

  private void createLocalDriver(AndroidDriver driver) {

    androidDriver.set(driver);
  }

  @DataProvider(name = "sauceBrowsers", parallel = true)
  public static Object[][] sauceBrowserDataProvider(Method beforeMethod) {

    RunType runType = RunType.SAUCE;
    return new Object[][] {new Object[] {sauceBrowserInput, runType}};
  }

  @DataProvider(name = "localBrowsers")
  public static Object[][] localBrowserDataProvider(Method beforeMethod) {

    RunType runType = RunType.LOCAL;
    return new Object[][] {new Object[] {localBrowserInput, runType}};
  }

  protected void createDriver(String methodName, RunType runType, Browser browser)
      throws Exception {
    this.runType = runType;

    MobileDriverFactory factory =
        new MobileDriverFactory(browser, properties, methodName, buildName, sauceTunnelInput);

    switch (runType) {
      case LOCAL:
        createLocalDriver((AndroidDriver) factory.getMobileDriver());
        break;
      case SAUCE:
        createSauceDriver((AndroidDriver) factory.getMobileDriver());
        break;
    }

    actions.set(new AndroidMobileActions(getAndroidWebDriver()));
  }

  @BeforeClass
  @Parameters({"jenkins", "sauceBrowser", "localBrowser", "sauceTunnel"})
  public void initProperties(
      @Optional("false") String jenkins,
      @Optional("ANDROID_PIXEL3_QA") String sauceBrowser,
      @Optional("ANDROID_LOCAL") String localBrowser,
      @Optional("false") String sauceTunnel)
      throws IOException {

    if (jenkins.equals("false")) {
      properties = InitProperties.setProperties();
      System.out.println("Properties initialized");

    } else if (jenkins.equals("true")) {
      properties = InitProperties.setPropertiesJenkins();
      System.out.println("Properties initialized - jenkins");
    }

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

    if (sauceTunnel.equals("true")) {
      sauceTunnelInput = true;
    }

    SauceREST sauceREST = SauceMethods.getSauceRest(properties.getSauceEncryptedCredential());
    new SauceMethods(sauceREST);

    String className = this.getClass().getSimpleName();

    buildName = className + "_" + ReportUtilities.formattedDateTime();
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
      }
    } finally {
      TestNGLogMethods.clearLogStepCount();
      androidDriver.get().quit();
    }
  }

  void annotate(String text) {
    if (runType.equals(RunType.SAUCE)) {
      ((JavascriptExecutor) androidDriver.get()).executeScript("sauce:context=" + text);
    }
  }

  public static String getBuildName() {
    return buildName;
  }
}
