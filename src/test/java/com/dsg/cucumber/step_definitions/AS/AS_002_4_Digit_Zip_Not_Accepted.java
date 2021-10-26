package com.dsg.cucumber.step_definitions.AS;

import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.AS.AthleteScheduler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class AS_002_4_Digit_Zip_Not_Accepted {
    private static final Logger logger = Logger.getLogger(AS_002_4_Digit_Zip_Not_Accepted.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we enter {string} into the zip code field")
    public void enterZip(String zip) throws Exception {
        commonMethods.enterValueWhenVisible(AthleteScheduler.zipEntry, zip, timeout);
    }
    @And("click anywhere else on the page")
    public void clickOnSchedulerContent() throws Exception {
        commonMethods.clickWhenVisible(AthleteScheduler.schedulerContent,timeout);
    }

    @Then("the page displays a user friendly error message {string}")
    public void invalidZip(String userFriendlyErrorMessage) throws Exception {
        String errorMessage = commonMethods.getTextFromLocator(AthleteScheduler.schedulerContent, timeout);
        if (!errorMessage.contains(userFriendlyErrorMessage)) {
            Assert.fail("The page did not display the user friendly error message " + userFriendlyErrorMessage);
        }
    }

    @And("the store selectors do not appear")
    public void noStoresListed () throws Exception {
        boolean robinsonStoreShown = commonMethods.isElementVisible(AthleteScheduler.robinsonStore, timeout);
        boolean akronStoreShown = commonMethods.isElementVisible(AthleteScheduler.akronStore, timeout);
                if (robinsonStoreShown == true || akronStoreShown == true) {
                    Assert.fail("Stores were displayed when a bad zip was entered.");
                }
    }
}
