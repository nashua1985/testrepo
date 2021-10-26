package com.dsg.cucumber.step_definitions.AS;

import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.AS.AthleteScheduler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class AS_007_Clicking_Next_Displays_Drop_Down_List_Of_Pros {
    private static final Logger logger = Logger.getLogger(AS_002_4_Digit_Zip_Not_Accepted.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @And("the Selected Service Next Step button is clicked")
    public void clickSelectedServiceNextStep() throws Exception {
        commonMethods.clickWhenVisible(AthleteScheduler.serviceTypeNextButton, timeout);
    }

    @Then("a drop down list of professionals {string} and {string} is displayed")
    public void listOfProsDisplayed(String BD, String DJ) throws Exception {
        commonMethods.clickWhenVisible(AthleteScheduler.proDropdown, timeout);
        boolean bryson = commonMethods.isElementVisible(AthleteScheduler.brysonDechambeau, timeout);
        boolean dustin = commonMethods.isElementVisible(AthleteScheduler.dustinJohnson,timeout);
        if (bryson == false || dustin == false) {
            Assert.fail("The list of pros did not contain Bryson DeChambeau, or Dustin Johnson.");
        }
    }
}