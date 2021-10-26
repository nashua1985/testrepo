package com.dsg.cucumber.step_definitions.MyAccount.Summary;


import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.MyAccount.MyAccount;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class Regression_MyAccount_Summary {
    private static final Logger logger = Logger.getLogger(Regression_MyAccount_Summary.class);
    private static final Integer timeout = 3;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("verify the {string} and {string} is present under the Account Summary")
    public void we_login_to_test_account(String firstName, String lastName) throws Exception {
        logger.info("Verifying First and Last Name");
        String name = firstName + " " + lastName;
        String actualName = commonMethods.getTextFromLocator(MyAccount.fullName, timeout);
        if (!actualName.equals(name)) {
            Assert.fail("Could not find the first and last name " + "Expected:" + name + "Actual Name" + actualName);
        }
    }

    @And("verify the Scorecard member {string} is present under the Account Summary")
    public void verifyTheScorecardMemberIsDisplayableUnderTheAccountSummary(String scoreCardNumber) {
        logger.info("Verifying ScoreCard number");
        String actualScoreCardNumber = commonMethods.getTextFromLocator(MyAccount.scoreCardNumber, timeout);
        if (!actualScoreCardNumber.equals(scoreCardNumber)) {
            Assert.fail("Could not find the ScoreCard member " + "Expected Number: " + scoreCardNumber + "Actual number: " + actualScoreCardNumber);
        }
    }

    @And("verify {int} points are available for the customer")
    public void verifyPointsAreAvailableForTheCustomer(int NumberOfPoints) {
        logger.info("Verifying the Number Of Points available");
        String actualPointsAvailable = commonMethods.getTextFromLocator(MyAccount.numberOfPoints, timeout);
        String actualAvailablePoints = actualPointsAvailable.substring(0, 3);
        if (!(Integer.parseInt(actualAvailablePoints) == NumberOfPoints)) {
            Assert.fail("Could not find the ScoreCard member " + "Expected available points : " + NumberOfPoints + " Actual available points avilable: " + actualAvailablePoints);
        }
    }

    @And("verify the Text {string} under Available Rewards")
    public void verifyTheTextUnderAvailableRewards(String text) {
        logger.info("Verifying the Text");
        String actualText = commonMethods.getTextFromLocator(MyAccount.text, timeout);
        if (!actualText.equals(text)) {
            Assert.fail("Could not find the ScoreCard member " + "Expected Number: " + text + "Actual number: " + actualText);
        }
    }


//    @And("click on account summary")
//    public void clickOnAccountSummary() throws InterruptedException{
//        logger.info("Clicking on account summary");
//        commonMethods.clickWhenVisible(MyAccount.scorecard, timeout);
//        String scorecardText = commonMethods.getTextFromLocator(MyAccount.scorecard, timeout);
//        if (!scorecard.equals(scorecardText)) {
//            Assert.fail("Could not find the ScoreCard text " + "Expected r: " + scorecard + "Actual : " + scorecardText);
//        }
//    }


    @And("verify {string} header present")
    public void verifyTheScorecardAvailable(String scorecard) throws InterruptedException {
        logger.info("Verifying the scorecard");
        Thread.sleep(5000);
        String scorecardText = commonMethods.getTextFromLocator(MyAccount.scorecard, 5);
        if (!scorecard.equals(scorecardText)) {
            Assert.fail("Could not find the ScoreCard text " + "Expected r: " + scorecard + "Actual : " + scorecardText);
        }
    }

    @And("verify {string} is available under rewards")
    public void verifyMyAccountisAvilable(String myAccount) throws Exception {
        logger.info("Verify MyAccount is available under rewards");
        commonMethods.clickWhenVisible(MyAccount.manageAccountButton, timeout);
        Thread.sleep(10000);
    }

}