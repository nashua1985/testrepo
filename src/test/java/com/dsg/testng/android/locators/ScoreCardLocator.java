package com.dsg.testng.android.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class ScoreCardLocator {

  public By OK_Button = By.xpath("//*[@resource-id='dsgui.android:id/snackbar_action']");
  public By Remember_MeCheckBox =
      By.xpath("//*[@resource-id='dsgui.android:id/fragment_sc_rememberme_checkbox']");
  public By Forgot_your =
      By.xpath("//*[@resource-id='dsgui.android:id/fragment_sc_sign_in_forget_your']");
  public By passwordTextView =
      By.xpath("//*[@resource-id='dsgui.android:id/fragment_sc_sign_in_forgot_password']");
  public By Question_Mark =
      By.xpath("//*[@resource-id='dsgui.android:id/fragment_sc_sign_in_forgot_questionmark']");
  public By REGISTER_NOW =
      By.xpath("//*[@resource-id='dsgui.android:id/fragment_sc_sign_in_register_now']");

  // New Sign into your account screen Android
  public By EmailAddress = By.xpath("//*[@text='Email Address']");
  public By Password = By.xpath("//*[@text='Password']");
  public By SignIntoYourAccountTitle = By.id("dsgui.android:id/title");
  public By CreateAccount = By.xpath("//*[@text='CREATE ACCOUNT']");
  public By SignIn = By.xpath("//*[@text='SIGN IN']");
  public By ForgotPW = By.id("dsgui.android:id/textView");
  public By RememberMe = By.id("dsgui.android:id/checkbox");
  public By ShowPassword = By.id("dsgui.android:id/option_text_view");
  public By signInHome = By.id("dsgui.android:id/sc_signin_cta");

  // Scorecard screen
  public By myPoints = By.xpath("//*[@text='MY POINTS']");
  public By myRewards = By.xpath("//*[@text='MY REWARDS']");
  public By myPreferences = By.xpath("//*[@text='MY PREFERENCES']");
  public By navigateUp = MobileBy.AccessibilityId("Navigate up");
  public By noRewardsText = By.id("dsgui.android:id/no_rewards_text");
  public By myPointsCardView = By.id("dsgui.android:id/mypoints_cardview");
  public By preferencesFirstName = By.id("dsgui.android:id/firstName");

  public By unsavedChangesNO = By.id("android:id/button2");
  public By unsavedChangesYES = By.id("android:id/button1");
}
