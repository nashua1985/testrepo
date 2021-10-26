package com.dsg.testng.android.tests;

import com.dsg.framework.enums.Browser;
import com.dsg.framework.enums.RunType;
import com.dsg.framework.loggers.TestNGLogMethods;
import com.dsg.framework.tools.MailosaurEmailGenerator;
import com.dsg.framework.tools.RandomNameGenerator;
import com.dsg.testng.android.locators.*;
import com.dsg.testng.android.resources.AndroidMobileActions;
import com.dsg.testng.android.resources.AndroidMobileAppMethods;
import com.dsg.testng.android.resources.AndroidRegisteredUsers;
import com.dsg.testng.basetest.AndroidBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class AndroidRegressionTests extends AndroidBaseTest {

  static MobileAppLocators mobile = new MobileAppLocators();
  static ScoreCardLocator scoreCardLocator = new ScoreCardLocator();
  static HomeLocator homeLocator = new HomeLocator();
  static SignUpLocators signUpLocator = new SignUpLocators();
  static ShopLocator shopLocator = new ShopLocator();
  static FindAStoreLocators findStoreLocator = new FindAStoreLocators();
  static WeeklyAddLocators weeklyLocator = new WeeklyAddLocators();
  static MyOfferLocators offerLocator = new MyOfferLocators();

  @Test(dataProvider = "sauceBrowsers")
  public void onboarding_SignIn(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    AndroidRegisteredUsers customer = new AndroidRegisteredUsers();

    String emailLogin = customer.getEmailLogin();
    String emailPassword = customer.getEmailPassword();
    String accountNumber = customer.getAccountNumber();
    String firstName = customer.getFirstName();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("Email: " + emailLogin);
    TestNGLogMethods.logInfo("Password: " + emailPassword);
    TestNGLogMethods.logInfo("Account Number: " + accountNumber);
    TestNGLogMethods.logInfo("----------------------------------------------");

    try {
      TestNGLogMethods.logStep("Click through onboarding screens");
      AndroidMobileAppMethods.onBoarding(false);

      TestNGLogMethods.logStep("Select Sign In");
      action.tapByElement(mobile.androidSignIn);

      TestNGLogMethods.logStep("Sign into Scorecard");
      AndroidMobileAppMethods.scorecardLogin(emailLogin, emailPassword);

      TestNGLogMethods.logStep("Click Maybe Later");
      action.tapByElement(mobile.androidMaybeLater);

      TestNGLogMethods.logStep("Check for alert msg");
      AndroidMobileAppMethods.checkAlert();

      TestNGLogMethods.logStep(
          "Verify Welcome Page for account - Personalization msg = HI, "
              + firstName.toUpperCase()
              + "!");
      action.verifyExistanceWithWait(homeLocator.Personalization_Title);

      String personalizationText = action.getTextValue(homeLocator.Personalization_Title);
      assertEquals(personalizationText, "HI, " + firstName.toUpperCase() + "!");

      TestNGLogMethods.logStep("Verify progress bar exists");
      action.verifyExistanceWithWait(homeLocator.Progress_Box);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Unable to login as registered account", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  // Locators are different with sign up onboarding vs sign up from home. missing
  // id's. ask mobile team about this.
  // test currently using sign up home locators
  @Test(enabled = true, dataProvider = "sauceBrowsers")
  public void onboarding_CreateAccount(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    String firstName = RandomNameGenerator.getFirstName();
    String lastName = RandomNameGenerator.getLastName();
    String emailAddress = MailosaurEmailGenerator.getEmail();
    String password = "testPW135!";

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("First Name: " + firstName);
    TestNGLogMethods.logInfo("Last Name: " + lastName);
    TestNGLogMethods.logInfo("Email Address: " + emailAddress);
    TestNGLogMethods.logInfo("Password: " + password);
    TestNGLogMethods.logInfo("----------------------------------------------");

    try {
      TestNGLogMethods.logStep("Click through onboarding screens");
      AndroidMobileAppMethods.onBoarding(false);

      TestNGLogMethods.logStep("Select Sign In");
      action.tapByElement(mobile.androidCreateAccount);

      TestNGLogMethods.logStep("Enter first name");
      // action.tapByElement(signUpLocator.firstNameTextBox);
      action.enterTextWithEnter(signUpLocator.firstNameTextBox, firstName);

      TestNGLogMethods.logStep("Enter last name");
      action.enterTextWithEnter(signUpLocator.lastNameTextBox, lastName);

      TestNGLogMethods.logStep("Enter email address");
      action.tapByElement(signUpLocator.emailTextBox);
      action.enterTextWithEnter(signUpLocator.emailTextBox, emailAddress);

      action.sleep(2);

      TestNGLogMethods.logStep("Enter password");
      action.enterTextWithEnter(signUpLocator.passwordTextBox, password);

      /*
       * TestNGLogMethods.logStep("Select country");
       * action.selectAndroidDropDown(signUpLocator.countryTextBox, "United States",
       * "android.widget.TextView");
       */

      TestNGLogMethods.logStep("Enter address1");
      action.enterTextWithEnter(signUpLocator.addressTextBox, "345 Court Street");

      TestNGLogMethods.logStep("Enter address2");
      action.enterTextWithEnter(signUpLocator.address2TextBox, "Floor 2A");

      TestNGLogMethods.logStep("Enter city");
      action.enterTextWithEnter(signUpLocator.cityTextBox, "Coraopolis");

      TestNGLogMethods.logStep("Select state");
      action.selectAndroidDropDown(
          signUpLocator.stateTextBox, "Pennsylvania (PA)", "android.widget.TextView");

      TestNGLogMethods.logStep("Enter zip code");
      action.tapByElement(signUpLocator.zipCodeTextBox);
      action.enterTextWithEnter(signUpLocator.zipCodeTextBox, "15108");

      TestNGLogMethods.logStep("Enter phone number");
      action.tapByElement(signUpLocator.phoneTextBox);
      action.enterTextWithEnter(signUpLocator.phoneTextBox, "9013243217");

      action.verticalSwipeByPercentages(0.6, 0.4, 0.5);
      // action.verticalSwipe(signUpLocator.Create_Account_Page);

      TestNGLogMethods.logStep("Verify create account button is enabled");
      // action.VerifyExistanceWithAssert(signUpLocator.Create_Account_Button);
      assertEquals(true, action.verifyClickable(signUpLocator.createAccountButton));

      TestNGLogMethods.logStep("Click on Create Account");
      action.tapByElement(signUpLocator.createAccountButton);

      TestNGLogMethods.logStep("Click Maybe Later");
      action.tapByElement(mobile.androidMaybeLater);

      TestNGLogMethods.logStep(
          "Verify Welcome Page for new account - Personalization msg = HI, "
              + firstName.toUpperCase()
              + "!");
      action.verifyExistanceWithWait(homeLocator.Personalization_Title);

      String personalizationText = action.getTextValue(homeLocator.Personalization_Title);
      assertEquals(personalizationText, "HI, " + firstName.toUpperCase() + "!");

      TestNGLogMethods.logStep("Verify progress bar exists");
      action.verifyExistanceWithWait(homeLocator.Progress_Box);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Unable to create account", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(enabled = true, dataProvider = "sauceBrowsers")
  public void onboarding_CreateAccountUsingExistingAccount(Browser browser, RunType runType)
      throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    AndroidRegisteredUsers customer = new AndroidRegisteredUsers();

    String firstName = RandomNameGenerator.getFirstName();
    String lastName = RandomNameGenerator.getLastName();
    String emailAddress = customer.getEmailLogin();
    String password = "testPW135!";

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("First Name: " + firstName);
    TestNGLogMethods.logInfo("Last Name: " + lastName);
    TestNGLogMethods.logInfo("Email Address: " + emailAddress);
    TestNGLogMethods.logInfo("Password: " + password);
    TestNGLogMethods.logInfo("----------------------------------------------");

    try {
      TestNGLogMethods.logStep("Click through onboarding screens");
      AndroidMobileAppMethods.onBoarding(false);

      TestNGLogMethods.logStep("Select Sign In");
      action.tapByElement(mobile.androidCreateAccount);

      TestNGLogMethods.logStep("Enter first name");
      // action.tapByElement(signUpLocator.firstNameTextBox);
      action.enterTextWithEnter(signUpLocator.firstNameTextBox, firstName);

      TestNGLogMethods.logStep("Enter last name");
      action.enterTextWithEnter(signUpLocator.lastNameTextBox, lastName);

      TestNGLogMethods.logStep("Enter email address");
      action.tapByElement(signUpLocator.emailTextBox);
      action.enterTextWithEnter(signUpLocator.emailTextBox, emailAddress);

      action.sleep(2);

      TestNGLogMethods.logStep("Verify existing account msg displays correctly");
      action.verifyExistanceWithWait(signUpLocator.existingAccountMsg);

      String expectedText =
          "An existing account was found for this email. Would you like to Sign In or Reset Your Password?";
      String actualText = action.getTextValue(signUpLocator.existingAccountMsg);

      assertEquals(expectedText, actualText);

      TestNGLogMethods.logStep("Enter password");
      action.enterTextWithEnter(signUpLocator.passwordTextBox, password);

      /*
       * TestNGLogMethods.logStep("Select country");
       * action.selectAndroidDropDown(signUpLocator.countryTextBox, "United States",
       * "android.widget.TextView");
       */

      TestNGLogMethods.logStep("Enter address1");
      action.enterTextWithEnter(signUpLocator.addressTextBox, "345 Court Street");

      TestNGLogMethods.logStep("Enter address2");
      action.enterTextWithEnter(signUpLocator.address2TextBox, "Floor 2A");

      TestNGLogMethods.logStep("Enter city");
      action.enterTextWithEnter(signUpLocator.cityTextBox, "Coraopolis");

      TestNGLogMethods.logStep("Select state");
      action.selectAndroidDropDown(
          signUpLocator.stateTextBox, "Pennsylvania (PA)", "android.widget.TextView");

      TestNGLogMethods.logStep("Enter zip code");
      action.tapByElement(signUpLocator.zipCodeTextBox);
      action.enterTextWithEnter(signUpLocator.zipCodeTextBox, "15108");

      TestNGLogMethods.logStep("Enter phone number");
      action.tapByElement(signUpLocator.phoneTextBox);
      action.enterTextWithEnter(signUpLocator.phoneTextBox, "9013243217");

      action.verticalSwipeByPercentages(0.6, 0.4, 0.5);
      // action.verticalSwipe(signUpLocator.Create_Account_Page);

      TestNGLogMethods.logStep("Verify create account button is disabled");
      // action.VerifyExistanceWithAssert(signUpLocator.Create_Account_Button);
      assertEquals(false, action.verifyClickable(signUpLocator.createAccountButton));

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Error with existing account", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void scorecard_LogInVerifyAndLogOut(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    AndroidRegisteredUsers customer = new AndroidRegisteredUsers();

    String emailLogin = customer.getEmailLogin();
    String emailPassword = customer.getEmailPassword();
    String accountNumber = customer.getAccountNumber();
    // String firstName = customer.getFirstName();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("Email: " + emailLogin);
    TestNGLogMethods.logInfo("Password: " + emailPassword);
    TestNGLogMethods.logInfo("Account Number: " + accountNumber);
    TestNGLogMethods.logInfo("----------------------------------------------");

    try {
      TestNGLogMethods.logStep("Click through onboarding screens as guest");
      AndroidMobileAppMethods.onBoarding(true);

      TestNGLogMethods.logStep("Click Sign in button on home screen");
      action.tapByElement(mobile.aSignInHome);

      TestNGLogMethods.logStep("Sign into Scorecard");
      AndroidMobileAppMethods.scorecardLogin(emailLogin, emailPassword);

      TestNGLogMethods.logStep("Check for alert msg");
      AndroidMobileAppMethods.checkAlert();

      TestNGLogMethods.logStep("Navigate to scorecard");
      action.tapByElement(mobile.aHamburger);
      action.tapByElement(mobile.aScoreCard);

      TestNGLogMethods.logStep("Verify ScoreCard Welcome Page");
      action.myWait(mobile.aWelcomeHeader);

      TestNGLogMethods.logStep("Scroll to bottom of screen");
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);

      TestNGLogMethods.logStep("Click My Points");
      action.tapByElement(scoreCardLocator.myPoints);

      TestNGLogMethods.logStep("Verify Points Card");
      action.verifyExistanceWithWait(scoreCardLocator.myPointsCardView);

      TestNGLogMethods.logStep("Click Back Button");
      action.tapByElement(scoreCardLocator.navigateUp);

      TestNGLogMethods.logStep("Click My Rewards");
      action.tapByElement(scoreCardLocator.myRewards);

      TestNGLogMethods.logStep("Verify if Rewards exist or not");
      action.verifyExistanceWithWait(scoreCardLocator.noRewardsText);
      // do stuff to check if there are any rewards
      // need locator for a reward

      TestNGLogMethods.logStep("Click Back Button");
      action.tapByElement(scoreCardLocator.navigateUp);

      TestNGLogMethods.logStep("Click My Preferences");
      action.tapByElement(scoreCardLocator.myPreferences);

      TestNGLogMethods.logStep("Verify first name box displays");
      action.verifyExistanceWithWait(scoreCardLocator.preferencesFirstName);

      TestNGLogMethods.logStep("Click Back Button");
      action.tapByElement(scoreCardLocator.navigateUp);

      TestNGLogMethods.logStep("Check alert - Click YES for unsaved changes");
      AndroidMobileAppMethods.checkAlertChooseYES();
      // action.tapByElement(scoreCardLocator.unsavedChangesYES);

      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      action.sleep(3);

      TestNGLogMethods.logStep("Scroll down and click Sign Out");
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);
      action.tapByElement(mobile.aSignOut);
      // action.Sleep(2);

      TestNGLogMethods.logStep("Verify account sign in screen displays");
      action.verifyExistanceWithWait(scoreCardLocator.signInHome);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Error verifying scorecard actions", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void homepage_VerifySignUPLink(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    try {

      TestNGLogMethods.logStep("Click on Sign Up Button");
      action.tapByElement(homeLocator.SIGN_UP_Button);

      TestNGLogMethods.logStep("Verify New Account screen displays");
      action.verifyExistanceWithWait(signUpLocator.createAccountDisplay);

      TestNGLogMethods.logStep("Verify existence of First name box");
      action.verifyExistanceWithWait(signUpLocator.firstNameTextBox);

      TestNGLogMethods.logStep("Perform a Vertical Swipe");
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);

      TestNGLogMethods.logStep("Verify Create Account button is not clickable");
      Assert.assertEquals(action.verifyClickable(signUpLocator.createAccountButton), false);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Sign Up Page did not display correctly", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void homepage_VerifySignINLink(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    try {

      TestNGLogMethods.logStep("Click on Sign In Button");
      action.tapByElement(homeLocator.SIGN_IN_Button);

      TestNGLogMethods.logStep("Verify ScoreCard screen displays");
      action.verifyExistanceWithWait(scoreCardLocator.SignIntoYourAccountTitle);

      TestNGLogMethods.logStep("Verify existence of email address");
      action.verifyExistanceWithWait(scoreCardLocator.EmailAddress);

      TestNGLogMethods.logStep("Verify existence of password field");
      action.verifyExistanceWithWait(scoreCardLocator.Password);

      TestNGLogMethods.logStep("Verify Sign In button is not clickable");
      Assert.assertEquals(action.verifyClickable(scoreCardLocator.SignIn), false);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: ScoreCard Page did not display", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void homepage_ShopBy(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // outdoor removed 8/18/20 jdj
    // These must be kept in order
    By[] categories = {
      homeLocator.Shop_By_Sports,
      homeLocator.Shop_By_Footwear,
      homeLocator.Shop_By_Apparel,
      /*homeLocator.Shop_By_Outdoor,*/ homeLocator.Shop_By_Accessories,
      homeLocator.Shop_By_Fan_Shop,
      homeLocator.Shop_By_Shoe_Release_Calendar,
      homeLocator.Shop_By_Clearance
    };
    String[] text = {
      "Sports Equipment",
      "Footwear",
      "Athletic Apparel", /* "Outdoor",*/
      "Accessories",
      "Fan Shop Gear",
      "SNEAKER RELEASE CALENDAR",
      "Clearance Shop by Sport"
    };

    int index = 0;

    for (By category : categories) {

      String categoryText = text[index];

      try {
        TestNGLogMethods.logStep("Perform a Vertical Swipe");
        action.verticalSwipeByPercentages(0.6, 0.1, 0.5);

        TestNGLogMethods.logStep("Click on " + categoryText);
        action.tapByElement(category);

        action.sleep(2);

        TestNGLogMethods.logStep("Perform a Vertical Swipe");
        action.verticalSwipeByPercentages(0.7, 0.5, 0.5);

        TestNGLogMethods.logStep("Verify " + categoryText + " screen displays");
        action.verifyExistanceWithWait(By.xpath("//*[@text='" + categoryText + "']"));

        TestNGLogMethods.logStep("Navigate to home page");
        AndroidMobileAppMethods.goHome();

      } catch (Exception e) {
        AndroidMobileAppMethods.TakeScreenShotForTest(
            "FAIL: " + categoryText + " screen did not display", method, screenshotEnabled);
        Assert.fail(e.getMessage());
      }

      index++;
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void homepage_SetAndValidateStore(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // Will eventually need to add more to verify on weekly ad

    try {

      TestNGLogMethods.logStep("Scroll down to My Store section");
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);
      action.verticalSwipeByPercentages(0.9, 0.5, 0.5);

      TestNGLogMethods.logStep("Click on Set Store");
      action.tapByElement(homeLocator.SET_STORE);

      TestNGLogMethods.logStep("Click on Search");
      action.tapByElement(findStoreLocator.Search_Icon);

      TestNGLogMethods.logStep("Enter Zip Code");
      action.enterText(findStoreLocator.Zip_Code_or_City_StateEditText, "15108");

      TestNGLogMethods.logStep("Hit Enter");
      action.androidEnter();
      action.sleep(1);

      TestNGLogMethods.logStep("Verify more than 1 stores are listed");
      action.verifyExistanceWithWait(findStoreLocator.searchListItem2);

      TestNGLogMethods.logStep("Set Robinson as store");
      action.tapByElement(findStoreLocator.setStoreText);

      TestNGLogMethods.logStep("Go to homescreen");
      AndroidMobileAppMethods.goHome();

      TestNGLogMethods.logStep("Scroll down to My Store section");
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);
      action.verticalSwipeByPercentages(0.9, 0.5, 0.5);

      TestNGLogMethods.logStep("Verify Robinson is set as store");
      String store = action.getTextValue(homeLocator.Store_Title);
      assertEquals(store, "ROBINSON");

      TestNGLogMethods.logStep("Click on Weekly Ad");
      action.tapByElement(homeLocator.Weekly_Ad);

      TestNGLogMethods.logStep("Verify Weekly Ad page displays");
      action.verifyExistanceWithWait(weeklyLocator.Weekly_AdView);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Error setting or validating store", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void homepage_MarketingCards(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    try {

      // Only checks first 2 cards and verifies shop page only - not exact text

      TestNGLogMethods.logStep("Click on first Marketing Card");
      action.tapByElement(homeLocator.Marketing_Card);

      action.sleep(3);

      TestNGLogMethods.logStep("Verify Shop Page displays");
      action.verifyExistanceWithWait(shopLocator.ShopTextView);

      TestNGLogMethods.logStep("Go home");
      AndroidMobileAppMethods.goHome();

      TestNGLogMethods.logStep("Swipe to 2nd Marketing Card");
      action.horizontalSwipeByPercentage(0.9, 0.1, 0.6);

      TestNGLogMethods.logStep("Click on 2nd Marketing Card");
      action.tapByElement(homeLocator.Marketing_Card);

      action.sleep(3);

      TestNGLogMethods.logStep("Verify Shop Page displays");
      action.verifyExistanceWithWait(shopLocator.ShopTextView);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Marketing Promo card displayed incorrectly", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void homepage_MyOffers(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    try {

      TestNGLogMethods.logStep("Scroll down to My Offers");
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);
      // action.verticalSwipeByPercentages(0.6, 0.4, 0.5);

      TestNGLogMethods.logStep("Verify an offer is loaded");
      action.verifyExistanceWithWait(homeLocator.MyOffer_Card_Text);

      String offerText = action.getTextValue(homeLocator.MyOffer_Card_Text);
      TestNGLogMethods.logStep("Offer Text: " + offerText);

      TestNGLogMethods.logStep("Select See More");
      action.tapByElement(homeLocator.My_Offers_See_More);

      TestNGLogMethods.logStep("Exit out of personalization");
      action.tapByElement(offerLocator.Exit_Out);

      swipeAndGetText(8);

      action.sleep(2);

      TestNGLogMethods.logStep("Navigate to Home Page");
      AndroidMobileAppMethods.goHome();

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: My Offers displayed incorrectly", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(enabled = false, dataProvider = "sauceBrowsers")
  public void homepage_CardDisplay(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    try {

      // This was all copied/pasted and needs updated for the new test

      TestNGLogMethods.logStep("Scroll down to My Offers");

      TestNGLogMethods.logStep("Verify an offer is loaded");

      String offerText = action.getTextValue(homeLocator.MyOffer_Card_Text);
      TestNGLogMethods.logStep("Offer Text: " + offerText);

      TestNGLogMethods.logStep("Select See More");
      action.tapByElement(homeLocator.My_Offers_See_More);

      TestNGLogMethods.logStep("Exit out of personalization");
      action.tapByElement(offerLocator.Exit_Out);

      swipeAndGetText(8);

      action.sleep(2);

      TestNGLogMethods.logStep("Navigate to Home Page");
      AndroidMobileAppMethods.goHome();

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Add text here", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  private void swipeAndGetText(int count) {

    // Use Set to check for dups
    Set<String> offers = new HashSet<>();

    AndroidMobileActions action = getAndroidMobileActions();

    int i = 1;

    String offerText = action.getTextValue(offerLocator.Offer_Card_Text);
    TestNGLogMethods.logStep("Offer Text " + i + ": " + offerText);
    offers.add(offerText);

    for (i = 2; i <= count; i++) {

      if (i == count) {

        offerText = action.getTextValue(offerLocator.Second_Offer_Card_Text);
        TestNGLogMethods.logStep("Offer Text " + i + ": " + offerText);

        if (!offers.add(offerText)) {
          Assert.fail("Duplicate offer exists: " + offerText);
        }

      } else {

        action.swipeByElements(offerLocator.Shop_Now, offerLocator.MyOffers_Title);
        action.verticalSwipeByPercentages(0.6, 0.5, 0.5);
        offerText = action.getTextValue(offerLocator.Offer_Card_Text);
        TestNGLogMethods.logStep("Offer Text " + i + ": " + offerText);

        if (!offers.add(offerText)) {
          Assert.fail("Duplicate offer exists: " + offerText);
        }
      }
    }
  }
}
