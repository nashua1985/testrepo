package com.dsg.cucumber.step_definitions;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.config.ConfigurationReader;
import com.dsg.cucumber.utilities.ReportUtilities;
import com.dsg.framework.saucelabs.SauceMethods;
import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.Location;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;

public class Hooks {
    private static final Logger logger = Logger.getLogger(Hooks.class);
    public static final StringBuilder teamsReport = new StringBuilder();

    @Before(order = 1)
    public static void getScenario(Scenario scenario) throws Exception {
        logger.info("::: STARTING AUTOMATION :::");
        logger.info("Test setup");
        Base.initProperties();
        if(ConfigurationReader.getProperty("browser").toLowerCase().contains("sauce")){
            Base.buildName=getBuildName(scenario);
            String scenarioName = scenario.getName();
            if(!scenarioName.contains("_api")){
                Base.createSauceDriverNew(scenarioName);
                //Base.createSauceDriver(scenarioName);
                logger.info("SauceLabs URL: " + Base.getSauceJobURL());
                scenario.log("SauceLabs URL: " + Base.getSauceJobURL());
            }else{
                logger.info("::: Using headless mode for api calls :::");
                System.out.println("_______________________________________________________");
                //skipping browser setup
            }

        }
    }

    @Before(value = "@driver", order = 3)
    public void specialSetup() {
        logger.info("Setup for driver only");
    }

    @After("@driver")
    public void specialTearDown() {
        logger.info("Tear down for driver only");
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
//        Thread.sleep(10000);
        //how to check if scenario failed
        String scenarioName = scenario.getName();
        if (scenario.isFailed() && !scenarioName.contains("_api")) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Base.getDriver();
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //attach screenshot to the report
//            scenario.embed(image, "image/png", scenario.getName());
            scenario.attach(image, "image/png", screenshotName);
            teamsReport.append("FAILED :: ").append(getFeatureFileNameFromScenarioId(scenario)).append(scenario.getName()).append("\n");;
        } else {
            teamsReport.append("PASSED :: ").append(getFeatureFileNameFromScenarioId(scenario)).append(scenario.getName()).append("\n");
        }
        System.out.println("_______________________________________________________");
        logger.info("Test clean up");
        if(!scenarioName.contains("_api")) {
            Base.closeDriver();
            if (ConfigurationReader.getProperty("browser").toLowerCase().contains("sauce")) {
                SauceMethods.updateResults(!scenario.isFailed(), Base.getSessionId());
            }
        }else{
                logger.info("::: Tearing down headless mode for api calls :::");
                //skipping browser/sauce tear down
        }
    }
    private static String getBuildName(Scenario scenario) {
        String[] splitter = scenario.getId().split("/");
        int featureNameLength = splitter.length;
        String featureName = splitter[featureNameLength - 1].split(":")[0];
        featureName = featureName + "_" + ReportUtilities.formattedDateTime();
        System.out.println("featureName: " + featureName);
        return featureName;
    }

    public static String getFeatureFileNameFromScenarioId(Scenario scenario) {
        return scenario.getId().split("feature")[1].replace("s/", "").replace(".", "");
    }
}
