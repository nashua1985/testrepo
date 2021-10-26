package com.dsg.cucumber.step_definitions.AS;

import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.AS.AthleteScheduler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class AS_001_Page_Loads_Without_Errors {
    private static final Logger logger = Logger.getLogger(AS_001_Page_Loads_Without_Errors.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we should see zip code field")
    public void check_for_element_() throws Exception {
        boolean isElementVisible = commonMethods.isElementVisible(AthleteScheduler.zipEntry, timeout);
        if (!isElementVisible) {
            Assert.fail("Zip Code field is not VISIBLE");
        }
    }

    @And("we should see the text {string}")
    public void check_for_text(String text) throws Exception{
        String textOnPage = commonMethods.getTextFromLocator(AthleteScheduler.schedulerContent, timeout);
        if (!textOnPage.contains(text)) {
            Assert.fail("The page did not contain the text " + text);
        }
    }
}

