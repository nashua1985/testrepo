package com.dsg.testng.android.resources;

import com.dsg.framework.loggers.ReportUtilities;
import com.dsg.framework.loggers.TestNGLogMethods;
import com.dsg.testng.android.locators.LocationAllowLocators;
import com.dsg.testng.android.locators.MobileAppLocators;
import com.dsg.testng.android.locators.ScoreCardLocator;
import com.dsg.testng.basetest.AndroidBaseTest;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.junit.Assert.fail;

public class AndroidMobileAppMethods extends AndroidBaseTest {

  static MobileAppLocators mobile = new MobileAppLocators();
  // static HomeLocator hl = new HomeLocator();
  static LocationAllowLocators location = new LocationAllowLocators();
  static ScoreCardLocator scoreCardLocator = new ScoreCardLocator();
  static Boolean testStatus = true;
  static String buildName;

  static AndroidRegisteredUsers customer = new AndroidRegisteredUsers();

  // static String screenshotPath = PropertiesDTO.getTestNGScreenshotPath();
  static String screenshotPath = properties.getScreenshotPath();

  // static final Boolean sauceEnabled = false;

  public static void scorecardLogin(String emailLogin, String emailPassword) {
    AndroidMobileActions actions = getAndroidMobileActions();
    // AndroidMobileActions actions = getAndroidMobileActions();

    TestNGLogMethods.logStep("Enter Email account");
    actions.enterText(scoreCardLocator.EmailAddress, emailLogin);

    TestNGLogMethods.logStep("Enter Password");
    actions.enterText(scoreCardLocator.Password, emailPassword);
    actions.sleep(3);

    TestNGLogMethods.logStep("Click Sign in");
    actions.tapByElement(mobile.androidSignIn);
  }

  public static void accountLogin() throws MalformedURLException {
    AndroidMobileActions actions = getAndroidMobileActions();

    String emailLogin = "newaccountone@gmail.com";
    String emailPassword = "Password1!";
    String accountNumber = "L014B246K834";

    TestNGLogMethods.logStep("Email: " + emailLogin);
    TestNGLogMethods.logStep("Password: " + emailPassword);
    TestNGLogMethods.logStep("Account Number: " + accountNumber);

    try {
      TestNGLogMethods.logStep("Click Sign in button on home screen");
      actions.tapByElement(mobile.aSignInHome);

      TestNGLogMethods.logStep("Enter Email account");
      actions.enterText(scoreCardLocator.EmailAddress, emailLogin);

      TestNGLogMethods.logStep("Enter Password");
      actions.enterText(scoreCardLocator.Password, emailPassword);
      actions.sleep(3);

      TestNGLogMethods.logStep("Click Sign in");
      actions.tapByElement(mobile.androidSignIn);

      // TestNGLogMethods.logStep("Exit out of move msg");
      // actions.tapByElement(mobile.aMovePopup);

      TestNGLogMethods.logStep("Check for alert msg");
      checkAlert();

      TestNGLogMethods.logStep("Verify ScoreCard Welcome Page");
      actions.myWait(mobile.aWelcomeHeader);

    } catch (Exception e) {
      testStatus = false;
      TestNGLogMethods.logStep("Unable to login as registered user");
      fail(e.getMessage());
    }
  }

  public static void onBoarding(boolean guest) {

    AndroidMobileActions actions = getAndroidMobileActions();

    actions.tapByElement(mobile.androidGetStarted);
    actions.sleep(1);

    actions.tapByElement(mobile.androidNext);
    actions.sleep(1);

    actions.tapByElement(mobile.androidNext);
    actions.sleep(1);

    AndroidMobileAppMethods.allowOnlyWhileUsingApp();
    actions.sleep(1);

    if (guest) {

      actions.tapByElement(mobile.androidContinueAsGuest);
      actions.sleep(1);
    }
  }

  public static void openNav() {
    AndroidMobileActions actions = getAndroidMobileActions();
    System.out.println("Open Navigation");
    actions.tapByElement(mobile.aHamburger);
    actions.sleep(2);
  }

  public static void allowAllTheTime() {
    AndroidMobileActions actions = getAndroidMobileActions();

    boolean locationPrompt =
        actions.verifyExistance(location.Allow_DICKs_to_access_this_devices_location);
    // System.out.println(locationPrompt);
    if (locationPrompt) {

      try {
        // actions.tapByElement(
        // location.Your_location_is_needed_for_personalizing_your_app_experience);

        actions.tapByElement(location.Allow_all_the_time_Button);

      } catch (Exception e) {

        System.out.println("Unable to select allow location");
      }
    }
  }

  public static void allowOnlyWhileUsingApp() {
    AndroidMobileActions actions = getAndroidMobileActions();

    boolean locationPrompt =
        actions.verifyExistance(location.Allow_DICKs_to_access_this_devices_location);
    // System.out.println(locationPrompt);
    if (locationPrompt) {

      try {
        // actions.tapByElement(
        // location.Your_location_is_needed_for_personalizing_your_app_experience);

        actions.tapByElement(location.Allow_only_while_using_the_app_Button);

      } catch (Exception e) {

        System.out.println("Unable to select allow while using app");
      }
    }
  }

  public static void alwaysAllowLocation() {

    AndroidMobileActions actions = getAndroidMobileActions();
    boolean locationPrompt =
        actions.verifyExistance(
            location.Your_location_is_needed_for_personalizing_your_app_experience);
    // System.out.println(locationPrompt);
    if (locationPrompt) {

      try {
        actions.tapByElement(
            location.Your_location_is_needed_for_personalizing_your_app_experience);

        actions.tapByElement(location.Allow_all_the_time_Button);

      } catch (Exception e) {

        System.out.println("Unable to select allow location");
      }
    }
  }

  public static void goHome() {
    AndroidMobileActions actions = getAndroidMobileActions();
    actions.tapByElement(mobile.aHamburger);
    actions.sleep(2);

    actions.tapByElement(mobile.aHome);
    actions.sleep(2);
  }

  public static void checkAlert() {
    AndroidMobileActions actions = getAndroidMobileActions();
    boolean alert = actions.verifyExistance(By.id("android:id/alertTitle"));
    if (alert) {
      TestNGLogMethods.logStep("Alert displayed - Select OK");
      actions.sleep(2);
      actions.tapByElement(By.id("android:id/button2"));
    }
  }

  public static void checkAlertChooseYES() {
    AndroidMobileActions actions = getAndroidMobileActions();
    boolean alert = actions.verifyExistance(By.id("dsgui.android:id/alertTitle"));
    if (alert) {
      TestNGLogMethods.logStep("Alert displayed - Select YES");
      actions.sleep(2);
      actions.tapByElement(By.id("android:id/button1"));
    }
  }

  public static void TakeScreenShotForTest(
      String failureMessage, String screenShotFileName, boolean screenshotEnabled)
      throws Exception {

    AndroidMobileActions actions = getAndroidMobileActions();

    try {

      if (screenshotEnabled) {

        screenShotFileName = screenShotFileName + "_" + ReportUtilities.formattedDateTime();
        actions.takeScreenshot(screenShotFileName, screenshotPath, screenshotEnabled);

        TestNGLogMethods.logStepAddScreenShotLink(
            failureMessage, screenshotPath + screenShotFileName + ".png");

      } else {

        TestNGLogMethods.logStep(failureMessage);
      }

    } catch (Exception ex) {
      throw ex;
    }
  }
}
