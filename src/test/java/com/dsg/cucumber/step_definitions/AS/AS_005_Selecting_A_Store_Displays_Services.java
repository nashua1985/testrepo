package com.dsg.cucumber.step_definitions.AS;

import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.AS.AthleteScheduler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.internal.junit.ArrayAsserts;

public class AS_005_Selecting_A_Store_Displays_Services {
    private static final Logger logger = Logger.getLogger(AS_002_4_Digit_Zip_Not_Accepted.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @And("select the Robinson store")
    public void selectRobinsonStore() throws Exception {
        commonMethods.clickWhenVisible(AthleteScheduler.robinsonStore,timeout);
    }

    @Then("the page displays the Golf Lessons service")
    public void availableServices() throws Exception {
        boolean golfLessons = commonMethods.isElementVisible(AthleteScheduler.lessonService,timeout);
        if (golfLessons == false) {
            Assert.fail("The Golf Lessons service was not available to select.");
        }
    }

    @And("the page displays the Club Fitting service")
    public void clubFittingService() throws Exception {
        boolean clubFittings = commonMethods.isElementVisible(AthleteScheduler.fittingService, timeout);
        if (clubFittings == false) {
            Assert.fail("The Club Fitting service was not available to select.");
        }
    }

}