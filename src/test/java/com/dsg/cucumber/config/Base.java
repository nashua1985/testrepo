package com.dsg.cucumber.config;
import com.dsg.framework.enums.Browser;
import com.dsg.framework.properties.AutomationProperties;
import com.dsg.framework.properties.InitProperties;
import com.dsg.framework.saucelabs.MobileDriverFactory;
import com.dsg.framework.saucelabs.SauceMethods;
import com.dsg.framework.saucelabs.WebDriverFactory;
import com.saucelabs.saucerest.SauceREST;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    //so no one can create object of Driver class
    //everyone should call static getter method instead
    private Base() {
    }
    private static final Logger logger = Logger.getLogger(Base.class);
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<String> sessionId = new ThreadLocal<>();
    public static String buildName;
    private static String scenarioName;
    private static AutomationProperties properties;
    private static Browser broswerInput;
    private static boolean sauceTunnel;

    public static String getSessionId() {
        return sessionId.get();
    }

    public static String getSauceJobURL() {
        return "http://saucelabs.com/jobs/" + getSessionId();
    }

    /**
     * synchronized makes method thread safe. It ensures that only 1 thread can use it at the time.
     * <p>
     * Thread safety reduces performance but it makes everything safe.
     *
     * @return
     */
    public synchronized static WebDriver getDriver() {
        //if webdriver object doesn't exist
        //create it
        if (driver.get() == null) {
            //specify browser type in configuration.properties file
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            // -Dbrowser=firefox
            if (System.getProperty("browser") != null) {
                browser = System.getProperty("browser");
            }

            logger.info("Browser :: " + browser);
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver.set(new ChromeDriver(chromeOptions));
                    break;
                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driver.set(new ChromeDriver(options));
                    break;
//                case "chrome-remote":
//                    try {
//                        //we create object of URL and specify
//                        //selenium grid hub as a parameter
//                        //make sure it ends with /wd/hub
//                        URL url = new URL(GRID_URL);
//                        //desiredCapabilities used to specify what kind of node
//                        //is required for testing
//                        //such as: OS type, browser, version, etc...
//                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//                        desiredCapabilities.setBrowserName(BrowserType.CHROME);
//                        desiredCapabilities.setPlatform(Platform.ANY);
//
//                        driver.set(new RemoteWebDriver(url, desiredCapabilities));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
                case "sauce":
                    try {
                        Base.createSauceDriver(scenarioName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "firefox-remote":
                    try {
                        //we create object of URL and specify
                        //selenium grid hub as a parameter
                        //make sure it ends with /wd/hub
//                        URL url = new URL(GRID_URL);
                        //desiredCapabilities used to specify what kind of node
                        //is required for testing
                        //such as: OS type, browser, version, etc...
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName(BrowserType.FIREFOX);
                        desiredCapabilities.setPlatform(Platform.ANY);
//                        driver.set(new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                default:
                    logger.error("Wrong browser name :: " + browser);
                    throw new RuntimeException("Wrong browser name :: " + browser);
            }
        }
//        System.out.println("driver.get returs: "+driver.get());
        return driver.get();

    }

    public static void createSauceDriverNew(String testName) throws Exception {

        Browser browser = null;
        //boolean sauceTunnel;

        // Unless sauceBrowser is specified as a system property, use CHROME_WIN
        if (System.getProperty("sauceBrowser") == null) {
            browser = Browser.CHROME_WIN;
            logger.info("sauceBrowser: " + browser.getDisplayName());
        } else {
            try {
                browser = Browser.valueOf(System.getProperty("sauceBrowser"));
                logger.info("sauceBrowser: " + browser.getDisplayName());
            } catch (IllegalArgumentException e) {
                logger.info("sauceBrowser is not valid - check browser options in enums/Browser class");
                e.printStackTrace();
            }
        }

        if (System.getProperty("sauceTunnel") == null) {
            sauceTunnel = Boolean.parseBoolean(ConfigurationReader.getProperty("sauceTunnel"));
            logger.info("sauceTunnel: " + sauceTunnel);
        } else {
            try {
                sauceTunnel = Boolean.parseBoolean(System.getProperty("sauceTunnel"));
                logger.info("sauceTunnel: " + sauceTunnel);
            } catch (IllegalArgumentException e) {
                logger.info("sauceTunnel is not valid - must be true or false");
                e.printStackTrace();
            }
        }

        if (browser.getSauceBrowser() != null) {
            WebDriverFactory factory = new WebDriverFactory(browser, properties, testName, buildName, sauceTunnel);
            driver.set(factory.getWebDriver());
        } else {
            MobileDriverFactory factory = new MobileDriverFactory(browser, properties, testName, buildName, sauceTunnel);
            driver.set(factory.getMobileDriver());
        }

        sessionId.set(((RemoteWebDriver)driver.get()).getSessionId().toString());

        // set current sessionId
        String id = ((RemoteWebDriver) getDriver()).getSessionId().toString();
        sessionId.set(id);

        // Start SauceRest
        SauceREST sauceREST = SauceMethods.getSauceRest(properties.getSauceEncryptedCredential());
        new SauceMethods(sauceREST);

    }

    public static void createSauceDriver(String testName) {
        try
        {

            //String sauceURL = SauceMethods.getSauceURLString();
            String sauceURL = SauceMethods.getSauceURLString(properties.getSauceEncryptedCredential());

            MutableCapabilities sauceOpts = new MutableCapabilities();
            sauceOpts.setCapability("screenResolution", "2560x1600");

            sauceOpts.setCapability("name", testName);

            sauceOpts.setCapability("build", buildName);

            /** Required to set w3c protocol **/
            ChromeOptions chromeOpts = new ChromeOptions();
            chromeOpts.setExperimentalOption("w3c", true);

            /** Set a second MutableCapabilities object to pass Sauce Options and Chrome Options **/
            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("sauce:options", sauceOpts);
            capabilities.setCapability("goog:chromeOptions", chromeOpts);
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("platformName", "Windows 10");
            //capabilities.setCapability("platformVersion", "10");
            capabilities.setCapability("browserVersion", "latest");

            /*
             * try { driver.set(new RemoteWebDriver(new URL(sauceURL), capabilities)); }
             * catch (MalformedURLException e) { throw new RuntimeException(e); }
             */



            /*
             * sessionId.set(((RemoteWebDriver)driver.get()).getSessionId().toString());
             *
             * // set current sessionId String id = ((RemoteWebDriver)
             * getDriver()).getSessionId().toString(); sessionId.set(id);
             */

            try {
                driver.set(new RemoteWebDriver(new URL(sauceURL), capabilities));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            sessionId.set(((RemoteWebDriver)driver.get()).getSessionId().toString());

            // set current sessionId
            String id = ((RemoteWebDriver) getDriver()).getSessionId().toString();
            sessionId.set(id);


        }
        catch
        (Exception e)
        {
            e.printStackTrace();
        }

        SauceREST sauceREST = SauceMethods.getSauceRest(properties.getSauceEncryptedCredential());
        new SauceMethods(sauceREST);

        //return (WebDriver) driver;

    }
    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static void initProperties() throws IOException {

        String jenkins = "false";

        if (System.getProperty("jenkins") != null) {
            jenkins = System.getProperty("jenkins");
        }

        if (jenkins.equals("true")) {
            try {
                properties = InitProperties.setPropertiesJenkins();
                logger.info("Jenkins Properties Initialized");
            } catch (IOException e) {
                logger.info("Error initializing Jenkins properties");
                e.printStackTrace();
            }
        }else if (jenkins.equals("jenkinsProd")) {
            try {
                properties = InitProperties.setPropertiesJenkinsProd();
                logger.info("jenkinsProd Properties Initialized");
            } catch (IOException e) {
                logger.info("Error initializing jenkinsProd properties");
                e.printStackTrace();
            }
        } else {
            try {
                properties = InitProperties.setProperties();
                logger.info("Properties Initialized");
            } catch (IOException e) {
                logger.info("Error initializing properties");
                e.printStackTrace();
            }
        }
    }


}
