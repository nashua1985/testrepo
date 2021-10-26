package com.dsg.cucumber.step_definitions.AS;

import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.AS.AthleteScheduler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class AS_006_Selecting_Lesson_Displays_Next_Button {
    private static final Logger logger = Logger.getLogger(AS_002_4_Digit_Zip_Not_Accepted.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @And("select a 30 minute lesson")
    public void selectLesson() throws Exception {
        commonMethods.clickWhenVisible(AthleteScheduler.lessonService, timeout);
    }

    @Then("the Next Step button becomes available")
    public void checkForNextStepButton() throws Exception {
        boolean findNextButton = commonMethods.isElementVisible(AthleteScheduler.serviceTypeNextButton,timeout);
        if (findNextButton == false) {
            Assert.fail("The Next Steps button didn't show up after selecting a store and service.");
        }
    }
}