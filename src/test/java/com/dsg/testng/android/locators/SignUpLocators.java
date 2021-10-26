package com.dsg.testng.android.locators;

import org.openqa.selenium.By;

public class SignUpLocators {
  public By Create_AccountTextView = By.xpath("//*[@resource-id='dsgui.android:id/toolbar_title']");
  public By Sign_In_InformationTextView =
      By.xpath("//*[@resource-id='dsgui.android:id/firstline_signinInfo']");
  public By Personal_InformationTextView =
      By.xpath("//*[@resource-id='dsgui.android:id/header_2']");
  public By Country_TextView = By.xpath("//*[@resource-id='dsgui.android:id/country_header']");
  // public By United_StatesTextView = By.xpath("//*[@text='United States']");
  // public By State*TextView = By.xpath("//*[@text='State*']");
  public By firstNameEditText = By.xpath("//*[@resource-id='dsgui.android:id/firstName']");
  public By lastNameEditText = By.xpath("//*[@resource-id='dsgui.android:id/lastName']");
  public By create_account_emailEditText =
      By.xpath("//*[@resource-id='dsgui.android:id/create_account_email']");
  public By passwordEditText = By.xpath("//*[@resource-id='dsgui.android:id/password']");
  public By address_1_edit_textEditText =
      By.xpath("//*[@resource-id='dsgui.android:id/address_1_edit_text']");
  public By address_2_etEditText = By.xpath("//*[@resource-id='dsgui.android:id/address_2_et']");
  public By city_edit_textEditText =
      By.xpath("//*[@resource-id='dsgui.android:id/city_edit_text']");
  public By zip_edit_textEditText = By.xpath("//*[@resource-id='dsgui.android:id/zip_edit_text']");
  public By phone_edit_textEditText =
      By.xpath("//*[@resource-id='dsgui.android:id/phone_edit_text']");
  public By text_input_password_toggleImageButton =
      By.xpath("//*[@resource-id='dsgui.android:id/text_input_password_toggle']");
  public By toolbar = By.xpath("//*[@resource-id='dsgui.android:id/toolbar']");
  public By fragment_score_card_create_account =
      By.xpath("//*[@resource-id='dsgui.android:id/fragment_score_card_create_account']");
  public By countrySpinner = By.xpath("//*[@resource-id='dsgui.android:id/ca_countrySpinner']");
  public By stateSpinner = By.xpath("//*[@resource-id='dsgui.android:id/stateSpinner']");
  public By Create_Account_Button =
      By.xpath("//*[@resource-id='dsgui.android:id/create_account_button']");
  public By Create_Account_Page =
      By.xpath("//*[@resource-id='dsgui.android:id/fragment_score_card_create_account']");

  // New Create Account Locators
  public By createAccountDisplay = By.xpath("//*[@text='Create Account']");
  public By firstNameTextBox = By.xpath("//*[@text='First Name*']");
  public By createAccountButton = By.xpath("//*[@resource-id='dsgui.android:id/button']");
  public By lastNameTextBox = By.xpath("//*[@text='Last Name*']");
  public By emailTextBox = By.xpath("//*[@text='Email Address*']");
  public By passwordTextBox = By.xpath("//*[@text='Password*']");
  public By countryTextBox = By.xpath("//*[@text='United States']");
  public By addressTextBox = By.xpath("//*[@text='Street Address*']");
  public By address2TextBox = By.xpath("//*[@text='Apartment, Suite, Building']");
  public By cityTextBox = By.xpath("//*[@text='City*']");
  public By stateTextBox = By.xpath("//*[@text='State*']");
  public By zipCodeTextBox = By.xpath("//*[@text='Zip Code*']");
  public By phoneTextBox = By.xpath("//*[@text='Phone Number*']");
  public By existingAccountMsg = By.id("dsgui.android:id/alert_text_view");
}
