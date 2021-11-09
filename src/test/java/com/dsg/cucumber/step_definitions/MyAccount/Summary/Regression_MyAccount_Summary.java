package com.dsg.cucumber.step_definitions.MyAccount.Summary;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.MyAccount.MyAccount;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

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
			Assert.fail("Could not find the ScoreCard member " + "Expected Number: " + scoreCardNumber
					+ "Actual number: " + actualScoreCardNumber);
		}
	}

	@And("verify {int} points are available for the customer")
	public void verifyPointsAreAvailableForTheCustomer(int NumberOfPoints) {
		logger.info("Verifying the Number Of Points available");
		String actualPointsAvailable = commonMethods.getTextFromLocator(MyAccount.numberOfPoints, timeout);
		String actualAvailablePoints = actualPointsAvailable.replaceAll("[^0-9]", "");
		if (!(Integer.parseInt(actualAvailablePoints) == NumberOfPoints)) {
			Assert.fail("Could not find the ScoreCard member " + "Expected available points : " + NumberOfPoints
					+ " Actual available points avilable: " + actualAvailablePoints);
		}
	}

	@And("verify the Text {string} under Available Rewards")
	public void verifyTheTextUnderAvailableRewards(String text) {
		logger.info("Verifying the Text");
		String actualText = commonMethods.getTextFromLocator(MyAccount.text, timeout);
		if (!actualText.equals(text)) {
			Assert.fail("Could not find the ScoreCard member " + "Expected Number: " + text + "Actual number: "
					+ actualText);
		}
	}

	@Given("verify account sign in page on clicking manage account")
	public void verify_account_sign_in_page_on_clicking_manage_account(String title) throws Exception {
		System.out.println(Base.getDriver().getTitle());
		commonMethods.clickWhenVisible(MyAccount.manageAccount, timeout);
		System.out.println(Base.getDriver().getTitle());
		commonMethods.switch_windows(timeout);
		Assert.assertEquals(Base.getDriver().getTitle(), title);
        ArrayList<String> tabs2 = new ArrayList<String>(Base.getDriver().getWindowHandles());
		Base.getDriver().switchTo().window(tabs2.get(0));
		System.out.println(Base.getDriver().getTitle());

	}

	@Given("verify recent purchanse displayed correctly")
	public void verify_recent_purchanse_displayed_correctly() {
		System.out.println(commonMethods.getListSize(MyAccount.purchase_orders, timeout));
		Assert.assertTrue(commonMethods.getListSize(MyAccount.purchase_orders, timeout) > 0);
	}

	@Given("verify user is able to navigate to order details from recent purchase")
	public void verify_user_is_able_to_navigate_to_order_details_from_recent_purchase() throws InterruptedException {
		Base.getDriver().findElements(MyAccount.purchase_orders).get(0).findElement(By.cssSelector("td a")).click();

		Assert.assertEquals(commonMethods.getTextFromLocator(MyAccount.order_header, timeout).trim(),
				"Online Order Details");
		logger.info("Order Details Page opened correctly");

	}

	@Given("verify order details displayed correctly")
	public void verify_order_details_displayed_correctly() {
		System.out.println(Base.getDriver().findElement(MyAccount.order_header).getText());
		Assert.assertEquals(commonMethods.getTextFromLocator(MyAccount.order_header, timeout).trim(),
				"Online Order Details");
		logger.info("Order Details Page opened correctly");

		Assert.assertTrue(Base.getDriver().findElement(MyAccount.order_status).isDisplayed());
		Assert.assertTrue(Base.getDriver().findElement(MyAccount.order_total).isDisplayed());
	}

	@Given("user want to navigate to {string} tab")
	public void user_want_to_navigate_to_tab(String tabName) throws Exception {
		switch (tabName) {
		case "rewards":
			commonMethods.clickWhenVisible(MyAccount.rewardsTab, timeout);
			break;

		case "purchase":
			commonMethods.clickWhenVisible(MyAccount.purchaseTab, timeout);
			break;

		case "account setting":
			commonMethods.clickWhenVisible(MyAccount.accountSettingTab, timeout);
			break;

		case "faq":
			commonMethods.clickWhenVisible(MyAccount.faqTab, timeout);
			break;
		default:
			logger.info("Tab not available");
		}
	}

	@Given("user clicks on sign out link")
	public void user_click_on_sign_out_link() throws Exception {
		commonMethods.clickWhenVisible(MyAccount.signOutButton, timeout);
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
			Assert.fail(
					"Could not find the ScoreCard text " + "Expected r: " + scorecard + "Actual : " + scorecardText);
		}
	}

	@And("verify {string} is available under rewards")
	public void verifyMyAccountisAvilable(String myAccount) throws Exception {
		logger.info("Verify MyAccount is available under rewards");
		commonMethods.clickWhenVisible(MyAccount.manageAccountButton, timeout);
		Thread.sleep(10000);
	}

	@Given("verify the expected text under active Rewards")
	public void verify_the_expected_text_under_active_Rewards(List<String> expectedMsg) {
		Assert.assertEquals(commonMethods.getTextFromLocator(MyAccount.rewards_activeRewards, timeout),
				expectedMsg.get(0));
		logger.info("Active rewards is validated");
	}

	@Given("verify point balance is {int} points")
	public void verify_point_balance_is_points(int expectedPointBalace) {
		int actualPointBalance = Integer.parseInt(
				commonMethods.getTextFromLocator(MyAccount.rewards_PointBalance, timeout).replaceAll("[^0-9]", ""));
		Assert.assertEquals(actualPointBalance, expectedPointBalace);
		logger.info("point balance is validated");
	}

	@Given("verify credit account side bar opened on click credit my account link")
	public void verify_credit_account_side_bar_opened_on_click_credit_my_account_link() throws Exception {
		commonMethods.clickWhenVisible(MyAccount.credit_my_account_link, timeout);
		Assert.assertTrue(commonMethods.isElementVisible(MyAccount.credit_my_account_sideBar, timeout));
		commonMethods.clickWhenVisible(MyAccount.close_sidebar, timeout);
		logger.info("credit my account sidebar was open close successfully");
	}

	@Given("verify all related settings are available")
	public void verify_all_related_settings_are_available() throws Exception {

		Assert.assertTrue(commonMethods.getWebElement(MyAccount.setting_rewards, timeout).isDisplayed());
		Assert.assertTrue(commonMethods.getWebElement(MyAccount.setting_subscription, timeout).isDisplayed());
		Assert.assertTrue(commonMethods.getWebElement(MyAccount.setting_addressbook, timeout).isDisplayed());
		Assert.assertTrue(commonMethods.getWebElement(MyAccount.setting_login, timeout).isDisplayed());
		Assert.assertTrue(commonMethods.getWebElement(MyAccount.setting_phonebook, timeout).isDisplayed());

	}

}