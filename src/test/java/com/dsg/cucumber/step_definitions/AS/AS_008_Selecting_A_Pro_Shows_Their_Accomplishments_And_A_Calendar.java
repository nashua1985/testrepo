package com.dsg.cucumber.step_definitions.AS;

import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.AS.AthleteScheduler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class AS_008_Selecting_A_Pro_Shows_Their_Accomplishments_And_A_Calendar {
    private static final Logger logger = Logger.getLogger(AS_002_4_Digit_Zip_Not_Accepted.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @And("Dustin Johnson is selected")
    public void selectDJ() throws Exception {
        commonMethods.clickWhenVisible(AthleteScheduler.proDropdown, timeout);
        commonMethods.clickWhenVisible(AthleteScheduler.dustinJohnson,timeout);
    }

    @Then("his accomplishments {string} are displayed")
    public void accomplishments(String text) throws Exception {
        String accomplishmentsDJ = commonMethods.getTextFromLocator(AthleteScheduler.schedulerContent, timeout);
        if (!accomplishmentsDJ.contains(text)) {
            Assert.fail("After selecting DJ, his accomplishments were not displayed on the page.");
        }
    }

    @And("the Calendar becomes available")
    public void calendar() throws Exception {
        boolean calendarDisplayed = commonMethods.isElementVisible(AthleteScheduler.calendarIcon, timeout);
        if (calendarDisplayed == false) {
            Assert.fail("The Day Selector did not appear after selecting a professional");
        }
    }
}