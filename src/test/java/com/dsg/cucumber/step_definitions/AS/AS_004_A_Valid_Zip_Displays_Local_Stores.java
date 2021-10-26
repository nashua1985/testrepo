package com.dsg.cucumber.step_definitions.AS;

import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.AS.AthleteScheduler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class AS_004_A_Valid_Zip_Displays_Local_Stores {
    private static final Logger logger = Logger.getLogger(AS_002_4_Digit_Zip_Not_Accepted.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @Then("the page displays the Akron and Robinson store radio button")
    public void akronStoreListed() throws Exception {
        boolean akronStore = commonMethods.isElementVisible(AthleteScheduler.akronStore,timeout);
        if (akronStore == false) {
            Assert.fail("The Akron store radio button did not appear.");
        }
    }

    @And("the page displays the Robinson store radio button")
    public void robinsonStoreListed() throws Exception {
        boolean robinsonStore = commonMethods.isElementVisible(AthleteScheduler.robinsonStore,timeout);
        if (robinsonStore == false) {
            Assert.fail("The Robinson store radio button did not appear.");
        }
    }

}