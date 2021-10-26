package com.dsg.testng.android.locators;

import org.openqa.selenium.By;

// Todo Locators need to be fixed
public class CreditCardLocators {

  public By username = By.xpath("//*[@resource-id='dsgui.android:id/usernameField']");
  public By password = By.xpath("//*[@resource-id='dsgui.android:id/passwordField']");
  public By Remember_Me_CheckBox =
      By.xpath("//*[@resource-id='dsgui.android:id/rememberCheckbox']");
  public By Use_biometrics_for_authenticationCheckBox =
      By.xpath("//*[@resource-id='dsgui.android:id/fpCheckBox']");
  public By login_Button = By.xpath("//*[@resource-id='dsgui.android:id/loginButton']");
  public By REGISTER = By.xpath("//*[@resource-id='dsgui.android:id/registerButton']");
  public By APPLY = By.xpath("//*[@resource-id='dsgui.android:id/applyButton']");
  public By Lookup_User_ID = By.xpath("//*[@resource-id='dsgui.android:id/lookupUserIdButton']");
  public By Password_Reset = By.xpath("//*[@resource-id='dsgui.android:id/resetPasswordButton']");
  public By Login_Help = By.xpath(("//*[@resource-id='dsgui.android:id/loginHelp']"));
}
