package com.dsg.cucumber.step_definitions.athlete;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;
import java.util.Random;

public class Regression_ATHLETE_008_Validate_Athlete_is_able_to_successfully_sign_up {
    private static final Logger logger = Logger.getLogger(Regression_ATHLETE_008_Validate_Athlete_is_able_to_successfully_sign_up.class);
    private static final Integer timeout = 10;
    protected static final By searchAddressField = By.id("search_address");
    protected static final By searchAddressBtn = By.id("search_button");
    protected static final By googleMapIframe = By.id("dsg_stores");
    protected static final By getDirectionFirstOccur =
            By.xpath("(//div[@id='panel']//span[text()='Get Directions'])[1]");
    protected static final By googleMapSubmitBnt =
            By.xpath("(//div[@id='map']//input[@data-gaact='Click_to_BubbleDirectionsGo'])[2]");
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we enter our email to sign up at DSG")
    public void we_enter_our_email_to_sign_up_at_dsg() throws Exception {
        String start = "test_";
        String end = "@gmail.com";
        String validationText = "Your 10% off is on its way to";
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        String finalRandomEmail = start+generatedString+end;
        commonMethods.enterValueWhenVisible(HomePage.emailSignUpBox,finalRandomEmail, timeout);
        commonMethods.clickWhenVisible(HomePage.emailSignUpBtn, timeout);
//        Thread.sleep(10000);
        boolean isSuccessfulText = commonMethods.isElementVisible(
                By.xpath("//p[contains(text(), '"+validationText+" "+finalRandomEmail+"."+"')]"), timeout);
        if(isSuccessfulText){
            logger.info("Sign Up was successful");
        }else{
            Assert.fail("Sign Up maybe not successful");
        }
    }
}