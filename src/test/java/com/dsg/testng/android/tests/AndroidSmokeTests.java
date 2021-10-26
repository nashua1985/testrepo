package com.dsg.testng.android.tests;

import com.dsg.framework.enums.RunType;
import com.dsg.testng.android.locators.*;
import com.dsg.testng.android.resources.AndroidMobileActions;
import com.dsg.testng.android.resources.AndroidMobileAppMethods;
import com.dsg.testng.basetest.AndroidBaseTest;
import com.dsg.framework.enums.Browser;
import com.dsg.framework.loggers.TestNGLogMethods;
import com.dsg.framework.tools.MailosaurEmailGenerator;
import com.dsg.framework.tools.RandomNameGenerator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AndroidSmokeTests extends AndroidBaseTest {

  static MobileAppLocators mobile = new MobileAppLocators();
  static ShopLocator shop = new ShopLocator();
  static HomeLocator homeLocator = new HomeLocator();
  static SignUpLocators signUpLocator = new SignUpLocators();
  static TrackOrderLocators trackOrderLocator = new TrackOrderLocators();
  static ScoreCardLocator scoreCardLocator = new ScoreCardLocator();
  static MyOfferLocators myOfferLocators = new MyOfferLocators();
  static GiftCardLocators giftCardLocators = new GiftCardLocators();
  static MoveLocators moveLocators = new MoveLocators();
  static FindAStoreLocators findAStoreLocators = new FindAStoreLocators();
  static CreditCardLocators creditCardLocators = new CreditCardLocators();
  static SportsMatterLocator sportsMatterLocator = new SportsMatterLocator();
  static LegalAndPrivacyLocators legalAndPrivacyLocators = new LegalAndPrivacyLocators();
  static SupportAndFeedbackLocators supportAndFeedbackLocators = new SupportAndFeedbackLocators();

  @Test(dataProvider = "sauceBrowsers")
  public void searchTest(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    String searchTerm = "golf shirt";

    try {
      TestNGLogMethods.logStep("Click on search bar");
      action.tapByElement(mobile.aSearchBar);
      action.sleep(2);

      // System.out.println("Enter search text");
      TestNGLogMethods.logStep("Enter search text");
      action.enterText(mobile.aSearchText, searchTerm);

      // System.out.println("Hit Enter");
      TestNGLogMethods.logStep("Hit Enter");
      action.androidEnter();
      action.sleep(1);

      TestNGLogMethods.logStep("Verify search page displays for: " + searchTerm);
      action.myWait(By.xpath("//*[contains(@text,'Search: " + searchTerm + "')]"));

      TestNGLogMethods.logStep("Verify results display for: " + searchTerm);

      if (!action.verifyExistanceWithWait(
          By.xpath("//*[contains(@text,'RESULTS FOR \"" + searchTerm.toUpperCase() + "\"')]"))) {

        TestNGLogMethods.logStep("FAIL:  Search term " + searchTerm + " not found");
      }

    } catch (Exception e) {

      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL:  Unable to search for product", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(enabled = false, dataProvider = "sauceBrowsers")
  public void registeredAccountLogin(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    String emailLogin = "newaccountone@gmail.com";
    String emailPassword = "Password1!";
    String accountNumber = "L014B246K834";

    TestNGLogMethods.logStep("Email: " + emailLogin);
    TestNGLogMethods.logStep("Password: " + emailPassword);
    TestNGLogMethods.logStep("Account Number: " + accountNumber);

    try {
      TestNGLogMethods.logStep("Click Sign in button on home screen");
      action.tapByElement(mobile.aSignInHome);

      TestNGLogMethods.logStep("Enter Email account");
      action.enterText(scoreCardLocator.EmailAddress, emailLogin);

      TestNGLogMethods.logStep("Enter Password");
      action.enterText(scoreCardLocator.Password, emailPassword);
      action.sleep(3);

      TestNGLogMethods.logStep("Click Sign in");
      action.tapByElement(scoreCardLocator.SignIn);

      // TestNGLogMethods.logStep("Exit out of move msg");
      // action.tapByElement(mobile.aMovePopup);

      TestNGLogMethods.logStep("Check for alert msg");
      AndroidMobileAppMethods.checkAlert();

      TestNGLogMethods.logStep("Verify ScoreCard Welcome Page");
      action.myWait(mobile.aWelcomeHeader);

      TestNGLogMethods.logStep("Verify ScoreCard Header and Account Number are correct");

      if (!action.verifyExistanceWithWait(mobile.aAccountNumberHeading)
          && action.getTextValue(mobile.aAccountNumber).equals(accountNumber)) {
        TestNGLogMethods.logStep(
            "FAILED - Account Number: "
                + action.getTextValue(mobile.aAccountNumber)
                + " displayed incorrectly");
      }

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Unable to login as registered account", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(enabled = false, dataProvider = "sauceBrowsers")
  public void registeredAccountLoginLogout(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    // registeredAccountLogin();
    AndroidMobileAppMethods.accountLogin();

    action.sleep(3);

    try {

      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      action.sleep(3);

      TestNGLogMethods.logStep("Scroll down and click Sign Out");
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);
      // action.verticalSwipe(mobile.NavWindow);
      action.tapByElement(mobile.aSignOut);
      // action.Sleep(2);

      TestNGLogMethods.logStep("Verify account sign in screen displays");
      action.verifyExistanceWithWait(scoreCardLocator.SignIntoYourAccountTitle);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL - Unable to log out", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  /***************
   * NOTES:
   *  Not all elements are displayed in UI. You have to scroll and wait till UI elements load to interact with them
   *  Get Page source was used during this experiment to come to this assumption.
   * @throws Exception
   */

  @Test(dataProvider = "sauceBrowsers")
  // public void homepage_Should_Have_Links() {
  public void navigationCheck_Home(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to Home");
      action.tapByElement(mobile.aHome);

      TestNGLogMethods.logStep("Verify Sign Up button is Clickable");
      action.verifyClickable(homeLocator.SIGN_UP_Button);
      TestNGLogMethods.logStep("Verify Sign In button is Clickable");
      action.verifyClickable(homeLocator.SIGN_IN_Button);
      TestNGLogMethods.logStep("Verify Shop Special Promotion is Clickable");
      action.verifyClickable(homeLocator.Shop_Special_Promotion);
      TestNGLogMethods.logStep("Verify Shop All is Clickable");
      action.verifyClickable(homeLocator.SHOP_ALL_Button);
      TestNGLogMethods.logStep("Verify Shop By Sports link is Clickable");
      action.verifyClickable(homeLocator.Shop_By_Sports);
      TestNGLogMethods.logStep("Verify Shop By Footwear link is Clickable");
      action.verifyClickable(homeLocator.Shop_By_Footwear);
      TestNGLogMethods.logStep("Verify Shop By Apparel is Clickable");
      action.verifyClickable(homeLocator.Shop_By_Apparel);

      TestNGLogMethods.logStep("Perform a vertical Swipe");
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);
      // action.verticalSwipe(homeLocator.HomePage);

      // No more outdoor
      // TestNGLogMethods.logStep("Verify Shop By Outdoor is Clickable");
      // action.VerifyClickable(homeLocator.Shop_By_Outdoor);

      // TestNGLogMethods.logStep("Verify Shop By Outwear is Clickable");
      // action.VerifyClickable(homeLocator.Shop_By_Outwear);
      TestNGLogMethods.logStep("Verify Shop By Fanshop is Clickable");
      action.verifyClickable(homeLocator.Shop_By_Fan_Shop);
      TestNGLogMethods.logStep("Verify Shop By Clearance is Clickable");
      action.verifyClickable(homeLocator.Shop_By_Clearance);

      // TODO: Unable to access no unique identifiers
      // 'My Store'
      // 'Picked For You - see more'

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Home page does not have link(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  // Disabled due to create acct locators changing - test is covered in regression
  @Test(enabled = false, dataProvider = "sauceBrowsers")
  public void homepageCheck_SignUp(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);
    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to home");
      action.tapByElement(mobile.aHome);
      TestNGLogMethods.logStep("Click on Sign Up Button");
      action.tapByElement(homeLocator.SIGN_UP_Button);

      TestNGLogMethods.logStep("Verify existence of First name box");
      action.verifyExistanceWithWait(signUpLocator.firstNameEditText);
      TestNGLogMethods.logStep("Verify existence of Last name box");
      action.verifyExistanceWithWait(signUpLocator.lastNameEditText);
      TestNGLogMethods.logStep("Verify existence of email box");
      action.verifyExistanceWithWait(signUpLocator.create_account_emailEditText);
      TestNGLogMethods.logStep("Verify existence of password box");
      action.verifyExistanceWithWait(signUpLocator.passwordEditText);
      TestNGLogMethods.logStep("Verify existence of country drop down");
      action.verifyExistanceWithWait(signUpLocator.countrySpinner);
      TestNGLogMethods.logStep("Verify existence of state drop down");
      action.verifyExistanceWithWait(signUpLocator.stateSpinner);
      TestNGLogMethods.logStep("Verify existence of Address 1 box");
      action.verifyExistanceWithWait(signUpLocator.address_1_edit_textEditText);
      TestNGLogMethods.logStep("Verify existence of Address 2 box");
      action.verifyExistanceWithWait(signUpLocator.address_2_etEditText);
      TestNGLogMethods.logStep("Verify existence of City box");
      action.verifyExistanceWithWait(signUpLocator.city_edit_textEditText);
      TestNGLogMethods.logStep("Verify existence of Zip Code box");
      action.verifyExistanceWithWait(signUpLocator.zip_edit_textEditText);
      TestNGLogMethods.logStep("Verify existence of Phone number box");
      action.verifyExistanceWithWait(signUpLocator.phone_edit_textEditText);
      TestNGLogMethods.logStep("Perform a Vertical Swipe");
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);
      // action.verticalSwipe(signUpLocator.Create_Account_Page);

      TestNGLogMethods.logStep("Verify Create Account button is not clickable");
      Assert.assertEquals(action.verifyClickable(signUpLocator.Create_Account_Button), false);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Sign Up Page does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers", enabled = false)
  public void homepageCheck_ShopBy_Sports(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {

      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to Home");
      action.tapByElement(mobile.aHome);
      TestNGLogMethods.logStep("Click on Shop By Sports");
      action.tapByElement(homeLocator.Shop_By_Sports);
      TestNGLogMethods.logStep("Verify existence of Shop By View");
      action.verifyExistanceWithWait(shop.Shop_By_Sport_View);
      TestNGLogMethods.logStep("Verify Shop By Baseball link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Baseball), "Baseball");
      TestNGLogMethods.logStep("Verify Shop By Basketball link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Basketball), "Basketball");
      TestNGLogMethods.logStep("Verify Shop By Bikes & Cycling link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Bikes_And_Cycling), "Bikes & Cycling");
      TestNGLogMethods.logStep("Verify Shop By Bowling exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Bowling), "Bowling");
      TestNGLogMethods.logStep("Verify Shop By Boxing & MMA link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Boxing_And_MMA), "Boxing & MMA");
      TestNGLogMethods.logStep("Verify Shop By Camping & Hiking link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Camping_And_Hiking), "Camping & Hiking");
      TestNGLogMethods.logStep("Verify Shop By Cheerleading link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Cheerleading), "Cheerleading");
      TestNGLogMethods.logStep("Verify Shop By Climbing link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Climbing), "Climbing");
      TestNGLogMethods.logStep("Verify Shop By Cricket link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Cricket), "Cricket");
      TestNGLogMethods.logStep("Verify Shop By Exercise & Fitnesslink exists");
      Assert.assertEquals(
          action.getTextValue(shop.Shop_By_Exercise_And_Fitness), "Exercise & Fitness");
      TestNGLogMethods.logStep("Verify Shop By Field Hockey link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Field_Hockey), "Field Hockey");
      TestNGLogMethods.logStep("Verify Shop By Fishing link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Fishing), "Fishing");
      TestNGLogMethods.logStep("Verify Shop By Football link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Football), "Football");
      TestNGLogMethods.logStep("Verify Shop By Golf link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Golf), "Golf");
      TestNGLogMethods.logStep("Verify Shop By Gymnastics link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Gymnastics), "Gymnastics");
      TestNGLogMethods.logStep("Verify Shop By Handball link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Handball), "Handball");
      TestNGLogMethods.logStep("Verify Shop By Hockey link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Hockey), "Hockey");
      TestNGLogMethods.logStep("Verify Shop By Hunting & Shooting link exists");
      Assert.assertEquals(
          action.getTextValue(shop.Shop_By_Hunting_And_Shooting), "Hunting & Shooting");
      TestNGLogMethods.logStep("Verify Shop By Ice Skating link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Ice_Skating), "Ice Skating");
      TestNGLogMethods.logStep("Verify Shop By Kayak & Paddle link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Kayak_And_Paddle), "Kayak & Paddle");
      TestNGLogMethods.logStep("Verify Shop By Lacrosse link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Lacrosse), "Lacrosse");
      TestNGLogMethods.logStep("Verify Shop By Outdoor living link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Outdoor_Living), "Outdoor Living");
      TestNGLogMethods.logStep("Verify Shop By Rec Room Games link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Rec_Room_Games), "Rec Room Games");
      TestNGLogMethods.logStep("Verify Shop By Rugby link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Rugby), "Rugby");
      TestNGLogMethods.logStep("Verify Shop By Running link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Running), "Running");
      TestNGLogMethods.logStep("Verify Shop By Skates & Scooters link exists");
      Assert.assertEquals(
          action.getTextValue(shop.Shop_By_Skates_And_Scooters), "Skates & Scooters");
      TestNGLogMethods.logStep("Verify Shop By Soccer link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Soccer), "Soccer");
      TestNGLogMethods.logStep("Verify Shop By Softball link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Softball), "Softball");
      TestNGLogMethods.logStep("Verify Shop By Swimming link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Swimming), "Swimming");
      TestNGLogMethods.logStep("Verify Shop By Table Tennis link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Table_Tennis), "Table Tennis");
      TestNGLogMethods.logStep("Verify Shop By Track & Field link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Track_And_Field), "Track & Field");
      TestNGLogMethods.logStep("Verify Shop By Volleyball link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Volleyball), "Volleyball");
      TestNGLogMethods.logStep("Verify Shop By Water Sports link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Water_Sports), "Water Sports");
      TestNGLogMethods.logStep("Verify Shop By Water Wellness link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Wellness), "Wellness");
      TestNGLogMethods.logStep("Verify Shop By Winter Sports link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Winter_Sports), "Winter Sports");
      TestNGLogMethods.logStep("Verify Shop By Wrestling link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Wrestling), "Wrestling");
      TestNGLogMethods.logStep("Verify Shop By Yard Games link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Yard_Games), "Yard Games");
      TestNGLogMethods.logStep("Verify Shop By Yoga & Studio link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Yoga_And_Studio), "Yoga & Studio");
      TestNGLogMethods.logStep("Verify Shop By Clearance link exists");
      Assert.assertEquals(action.getTextValue(shop.Shop_By_Clearance), "Clearance");

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Shop By does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void navigationCheck_TrackYourOrder(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {

      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to Track Your Order");
      action.tapByElement(mobile.aTrackYourOrder);
      TestNGLogMethods.logStep("Verify Order Number box exists");
      action.verifyExistanceWithWait(trackOrderLocator.Order_number);
      TestNGLogMethods.logStep("Verify Zip Code box exists");
      action.verifyExistanceWithWait(trackOrderLocator.Zip_code);
      TestNGLogMethods.logStep("Verify Track Order Button exists");
      action.verifyExistanceWithWait(trackOrderLocator.TRACK_ORDER_Button);
      TestNGLogMethods.logStep("Verify Email Address box exists");
      action.verifyExistanceWithWait(trackOrderLocator.EmailAddress);
      TestNGLogMethods.logStep("Verify Sign Up Button exists");
      action.verifyExistanceWithWait(trackOrderLocator.SIGN_UP_Button);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Track Order Page does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void navigationCheck_ScoreCard(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to Score Card");
      action.tapByElement(mobile.aScoreCard);
      TestNGLogMethods.logStep("Verify Sign into Scorecard text element is available");
      action.verifyExistanceWithWait(scoreCardLocator.SignIntoYourAccountTitle);
      TestNGLogMethods.logStep("Verify Email text box exists");
      action.verifyExistanceWithWait(scoreCardLocator.EmailAddress);
      TestNGLogMethods.logStep("Verify Password text box exists");
      action.verifyExistanceWithWait(scoreCardLocator.Password);
      TestNGLogMethods.logStep("Verify Remember check box exists");
      action.verifyExistanceWithWait(scoreCardLocator.RememberMe);
      TestNGLogMethods.logStep("Verify Sign In Button exists");
      action.verifyExistanceWithWait(scoreCardLocator.SignIn);
      TestNGLogMethods.logStep("Verify Password Text View exists");
      action.verifyExistanceWithWait(scoreCardLocator.ShowPassword);
      TestNGLogMethods.logStep("Verify Forgot Password Button exists");
      action.verifyExistanceWithWait(scoreCardLocator.ForgotPW);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Score Card does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void navigationCheck_Move(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to Move");
      action.tapByElement(mobile.aMove);
      TestNGLogMethods.logStep("Verify Sign Into Scorecard text exists");
      action.verifyExistanceWithWait(scoreCardLocator.SignIntoYourAccountTitle);
      TestNGLogMethods.logStep("Verify email text box exists");
      action.verifyExistanceWithWait(scoreCardLocator.EmailAddress);
      TestNGLogMethods.logStep("Verify password text box exists");
      action.verifyExistanceWithWait(scoreCardLocator.Password);
      TestNGLogMethods.logStep("Verify Remember Me Check box exists");
      action.verifyExistanceWithWait(scoreCardLocator.RememberMe);
      TestNGLogMethods.logStep("Verify Sign In button exists");
      action.verifyExistanceWithWait(scoreCardLocator.SignIn);
      TestNGLogMethods.logStep("Verify Password Text View exists");
      action.verifyExistanceWithWait(scoreCardLocator.ShowPassword);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Move Page does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void navigationCheck_MyOffers(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to My Offers");
      action.tapByElement(mobile.aMyOffers);
      TestNGLogMethods.logStep("Verify Men Category exists");
      action.verifyExistanceWithWait(myOfferLocators.MenTextView);
      TestNGLogMethods.logStep("Verify Womens Category exists");
      action.verifyExistanceWithWait(myOfferLocators.WomenTextView);
      TestNGLogMethods.logStep("Verify Boys Category exists");
      action.verifyExistanceWithWait(myOfferLocators.BoysTextView);
      TestNGLogMethods.logStep("Verify Girls Category exists");
      action.verifyExistanceWithWait(myOfferLocators.GirlsTextView);
      TestNGLogMethods.logStep("Verify Next Button exists");
      action.verifyExistanceWithWait(myOfferLocators.NEXT_Button);
      TestNGLogMethods.logStep("Click Next button");
      action.tapByElement(myOfferLocators.NEXT_Button);
      TestNGLogMethods.logStep("Verify Team Sports View exists");
      action.verifyExistanceWithWait(myOfferLocators.TeamSportsTextView);
      TestNGLogMethods.logStep("Verify Foot Wear View exists");
      action.verifyExistanceWithWait(myOfferLocators.FootWearTextView);
      TestNGLogMethods.logStep("Verify Apparel View exists");
      action.verifyExistanceWithWait(myOfferLocators.ApparelTextView);
      TestNGLogMethods.logStep("Verify Hunting and Fishing View exists");
      action.verifyExistanceWithWait(myOfferLocators.HuntingAndFishingView);
      TestNGLogMethods.logStep("Verify Fanshop View exists");
      action.verifyExistanceWithWait(myOfferLocators.FanShopView);
      TestNGLogMethods.logStep("Verify Golf View exists");
      action.verifyExistanceWithWait(myOfferLocators.GolfView);
      /*TestNGLogMethods.logStep("Verify Offer Content exists");
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);
      //action.verticalSwipe(myOfferLocators.Offer_Content);
      TestNGLogMethods.logStep("Verify Outdoorrec View exists");
      action.verifyExistanceWithWait(myOfferLocators.OutDoorRecView);
      TestNGLogMethods.logStep("Verify Fitness View exists");
      action.verifyExistanceWithWait(myOfferLocators.FitnessView);*/

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: My Offers Page does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(enabled = false, dataProvider = "sauceBrowsers")
  public void navigationCheck_NewOffers(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to New Offers");
      action.tapByElement(mobile.aNewOffers);
      TestNGLogMethods.logStep("Verify Men View exists");
      action.verifyExistanceWithWait(myOfferLocators.MenTextView);
      TestNGLogMethods.logStep("Verify Women View exists");
      action.verifyExistanceWithWait(myOfferLocators.WomenTextView);
      TestNGLogMethods.logStep("Verify Boys View exists");
      action.verifyExistanceWithWait(myOfferLocators.BoysTextView);
      TestNGLogMethods.logStep("Verify Girls View exists");
      action.verifyExistanceWithWait(myOfferLocators.GirlsTextView);
      TestNGLogMethods.logStep("Verify Next Button exists");
      action.verifyExistanceWithWait(myOfferLocators.NEXT_Button);
      TestNGLogMethods.logStep("Click Next Button");
      action.tapByElement(myOfferLocators.NEXT_Button);
      TestNGLogMethods.logStep("Verify Team Sports View exists");
      action.verifyExistanceWithWait(myOfferLocators.TeamSportsTextView);
      TestNGLogMethods.logStep("Verify Footwear View exists");
      action.verifyExistanceWithWait(myOfferLocators.FootWearTextView);
      TestNGLogMethods.logStep("Verify Apparel View exists");
      action.verifyExistanceWithWait(myOfferLocators.ApparelTextView);
      TestNGLogMethods.logStep("Verify Hunting and Fishing View exists");
      action.verifyExistanceWithWait(myOfferLocators.HuntingAndFishingView);
      TestNGLogMethods.logStep("Verify Fan Shop View exists");
      action.verifyExistanceWithWait(myOfferLocators.FanShopView);
      TestNGLogMethods.logStep("Verify Golf View exists");
      action.verifyExistanceWithWait(myOfferLocators.GolfView);
      TestNGLogMethods.logStep("Verify Offer Content View exists");
      action.verticalSwipeByPercentages(0.9, 0.1, 0.5);
      // action.verticalSwipe(myOfferLocators.Offer_Content);
      TestNGLogMethods.logStep("Verify Outdoor Rec View exists");
      action.verifyExistanceWithWait(myOfferLocators.OutDoorRecView);
      TestNGLogMethods.logStep("Verify Fitness View exists");
      action.verifyExistanceWithWait(myOfferLocators.FitnessView);
      TestNGLogMethods.logStep("Verify Next Button exists");
      action.tapByElement(myOfferLocators.NEXT_Button);
      // Assert.assertEquals(action.GetTextValue(myOfferLocators.JUST_FOR_YOU_TEXT),"JUST FOR YOU");

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: New Offers Page does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void navigationCheck_GiftCards(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to Gift Cards");
      action.tapByElement(mobile.aGiftCards);
      TestNGLogMethods.logStep("Verify Sign into scorecard button exists");
      action.verifyExistanceWithWait(giftCardLocators.SIGN_IN_TO_SCORECARD_Button);
      TestNGLogMethods.logStep("Verify Gift Card button exists");
      action.verifyExistanceWithWait(giftCardLocators.BUY_A_GIFT_CARD_Button);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Gift Cards Page does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void navigationCheck_FindAStore(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to Find A Store");
      action.tapByElement(mobile.aFindAStore);
      TestNGLogMethods.logStep("Verify Tool Bar title exists");
      action.verifyExistanceWithWait(findAStoreLocators.ToolBar_Title);
      TestNGLogMethods.logStep("Verify Search Icon exists");
      action.verifyExistanceWithWait(findAStoreLocators.Search_Icon);
      TestNGLogMethods.logStep("Verify Find A Store text exists");
      Assert.assertEquals(action.getTextValue(findAStoreLocators.ToolBar_Title), "Find A Store");

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Find A Store Page does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  // TODO: Check Weekly Add - CAN'T ACCESS Weekly Ad
  //    @Test
  //    public void Check_Weekly_Ad_Elements() {
  //
  //      try
  //        {
  //
  //            action.tapByElement(mobile.aHamburger);
  //            action.tapByElement(mobile.aWeeklyAd);
  //
  //
  //        } catch (Exception e)
  //        {
  //            testStatus = false;
  //            Assert.fail(e.getMessage());
  //        }
  //
  //    }

  @Test(dataProvider = "sauceBrowsers")
  public void navigationCheck_CreditCard(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to Credit Card page");
      action.tapByElement(mobile.aCreditCard);
      TestNGLogMethods.logStep("Verify username exists");
      action.verifyExistanceWithWait(creditCardLocators.username);
      TestNGLogMethods.logStep("Verify password exists");
      action.verifyExistanceWithWait(creditCardLocators.password);
      TestNGLogMethods.logStep("Verify Remember Me Check Box exists");
      action.verifyExistanceWithWait(creditCardLocators.Remember_Me_CheckBox);
      TestNGLogMethods.logStep("Verify Use Biometrics for authentication exists");
      action.verifyExistanceWithWait(creditCardLocators.Use_biometrics_for_authenticationCheckBox);
      TestNGLogMethods.logStep("Verify login button exists");
      action.verifyExistanceWithWait(creditCardLocators.login_Button);
      TestNGLogMethods.logStep("Verify Register button exists");
      action.verifyExistanceWithWait(creditCardLocators.REGISTER);
      TestNGLogMethods.logStep("Verify Apply exists");
      action.verifyExistanceWithWait(creditCardLocators.APPLY);

      // Removed 11/18/2020 jdj
      // TestNGLogMethods.logStep("Verify Lookup User ID exists");
      // action.verifyExistanceWithWait(creditCardLocators.Lookup_User_ID);

      TestNGLogMethods.logStep("Verify Having issues logging in? exists");
      action.verifyExistanceWithWait(creditCardLocators.Login_Help);

      // Removed 11/18/2020 jdj
      // TestNGLogMethods.logStep("Verify Password reset exists");
      // action.verifyExistanceWithWait(creditCardLocators.Password_Reset);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Credit Card Page does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void navigationCheck_SportsMatter(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to Sports page");
      action.tapByElement(mobile.aSportsMatter);
      TestNGLogMethods.logStep("Verify Make A Donation button exists");
      action.verifyExistanceWithWait(sportsMatterLocator.MAKE_A_DONATION_Button);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Sports Matter Page does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void navigationCheck_LegalAndPrivacy(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to Legal & Privacy page");
      action.tapByElement(mobile.aLegalPrivacy);
      TestNGLogMethods.logStep("Verify legal and privacy text exists");
      action.verifyExistanceWithWait(legalAndPrivacyLocators.Legacy_Privacy_Intro);
      Assert.assertEquals(
          action.getTextValue(legalAndPrivacyLocators.Legacy_Privacy_Intro),
          "Visit DICKS.com for complete details regarding our policies.");
      TestNGLogMethods.logStep("Verify License Agreement link exists");
      action.verifyExistanceWithWait(legalAndPrivacyLocators.License_Agreement);
      TestNGLogMethods.logStep("Verify Terms Of Use link exists");
      action.verifyExistanceWithWait(legalAndPrivacyLocators.Terms_Of_Use);
      TestNGLogMethods.logStep("Verify Scorecard terms link exists");
      action.verifyExistanceWithWait(legalAndPrivacyLocators.Scorecard_Terms);
      TestNGLogMethods.logStep("Verify Promo Exclusions exists");
      action.verifyExistanceWithWait(legalAndPrivacyLocators.Promo_Exclusions);
      TestNGLogMethods.logStep("Verify California Disclosures link exists");
      action.verifyExistanceWithWait(legalAndPrivacyLocators.California_Disclosures);
      TestNGLogMethods.logStep("Verify Product Availability And Price link exists");
      action.verifyExistanceWithWait(legalAndPrivacyLocators.Product_Availability_And_Price);
      TestNGLogMethods.logStep("Verify Recalls link exists");
      action.verifyExistanceWithWait(legalAndPrivacyLocators.Recalls);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Legal and Privacy Page does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }

  @Test(dataProvider = "sauceBrowsers")
  public void navigationCheck_SupportAndFeedback(Browser browser, RunType runType)
      throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("----------------------------------------------");

    AndroidMobileAppMethods.onBoarding(true);

    // TestNGLogMethods.logInfo(jobURL);
    // TestNGLogMethods.logInfo("");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Perform vertical swipe");
      action.verticalSwipeByPercentages(0.7, 0.4, 0.4);
      TestNGLogMethods.logStep("Navigate to Support and Feedback page");
      action.tapByElement(mobile.aSupportFeedback);
      TestNGLogMethods.logStep("Verify Provide Feedback button exists");
      action.verifyExistanceWithWait(supportAndFeedbackLocators.Provide_Feedback_Button);
      TestNGLogMethods.logStep("Verify Report Feedback button exists");
      action.verifyExistanceWithWait(supportAndFeedbackLocators.Report_Problem_Button);

    } catch (Exception e) {
      AndroidMobileAppMethods.TakeScreenShotForTest(
          "FAIL: Support and Feedback Page does not have element(s)", method, screenshotEnabled);
      Assert.fail(e.getMessage());
    }
  }
  // Disabled because there is a new create acct test in regression and they use different locators
  @Test(enabled = false, dataProvider = "sauceBrowsers")
  public void createNewAccount(Browser browser, RunType runType) throws Exception {
    String method = getMethodName();
    this.createDriver(method, runType, browser);
    AndroidMobileActions action = getAndroidMobileActions();

    AndroidMobileAppMethods.onBoarding(true);

    String firstName = RandomNameGenerator.getFirstName();
    String lastName = RandomNameGenerator.getLastName();
    String emailAddress = MailosaurEmailGenerator.getEmail();
    String password = "Password@123";

    TestNGLogMethods.logInfo(this.getJobURL());
    TestNGLogMethods.logInfo("First Name: " + firstName);
    TestNGLogMethods.logInfo("Last Name: " + lastName);
    TestNGLogMethods.logInfo("Email Address: " + emailAddress);
    TestNGLogMethods.logInfo("Password: " + password);
    TestNGLogMethods.logInfo("----------------------------------------------");

    try {
      TestNGLogMethods.logStep("Open Navigation");
      action.tapByElement(mobile.aHamburger);
      TestNGLogMethods.logStep("Navigate to home");
      action.tapByElement(mobile.aHome);
      TestNGLogMethods.logStep("Click on Sign Up Button");
      action.tapByElement(homeLocator.SIGN_UP_Button);

      TestNGLogMethods.logStep("Enter first name");
      action.tapByElement(signUpLocator.firstNameEditText);
      action.enterTextWithEnter(signUpLocator.firstNameEditText, firstName);

      TestNGLogMethods.logStep("Enter last name");
      action.enterTextWithEnter(signUpLocator.lastNameEditText, lastName);

      TestNGLogMethods.logStep("Enter email address");
      action.enterTextWithEnter(signUpLocator.create_account_emailEditText, emailAddress);

      TestNGLogMethods.logStep("Enter password");
      action.enterTextWithEnter(signUpLocator.passwordEditText, password);

      TestNGLogMethods.logStep("Select country");
      action.selectAndroidDropDown(
          signUpLocator.countrySpinner, "United States", "android.widget.CheckedTextView");

      TestNGLogMethods.logStep("Enter address1");
      action.enterTextWithEnter(signUpLocator.address_1_edit_textEditText, "345 Court Street");

      TestNGLogMethods.logStep("Enter address2");
      action.enterTextWithEnter(signUpLocator.address_2_etEditText, "Floor 2A");

      TestNGLogMethods.logStep("Enter city");
      action.enterTextWithEnter(signUpLocator.city_edit_textEditText, "Coraopolis");

      TestNGLogMethods.logStep("Select state");
      action.selectAndroidDropDown(
          signUpLocator.stateSpinner, "Pennsylvania (PA)", "android.widget.CheckedTextView");

      TestNGLogMethods.logStep("Enter zip code");
      action.tapByElement(signUpLocator.zip_edit_textEditText);
      action.enterTextWithEnter(signUpLocator.zip_edit_textEditText, "15108");

      TestNGLogMethods.logStep("Enter phone number");
      action.enterTextWithEnter(signUpLocator.phone_edit_textEditText, "9013243217");

      action.verticalSwipeByPercentages(0.6, 0.4, 0.5);
      // action.verticalSwipe(signUpLocator.Create_Account_Page);

      TestNGLogMethods.logStep("Verify create account button is enabled");
      // action.VerifyExistanceWithAssert(signUpLocator.Create_Account_Button);
      assertEquals(true, action.verifyClickable(signUpLocator.Create_Account_Button));

      TestNGLogMethods.logStep("Click on Create Account");
      action.tapByElement(signUpLocator.Create_Account_Button);

      // No more move msg
      // TestNGLogMethods.logStep("Exit out of move msg");
      // action.tapByElement(mobile.aMovePopup);

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
}
