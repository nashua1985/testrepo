package com.dsg.testng.android.locators;

import org.openqa.selenium.By;

public class LegalAndPrivacyLocators {
  public By Legacy_Privacy_Intro =
      By.xpath("//*[@resource-id='dsgui.android:id/legal_privacy_intro']");
  public By License_Agreement =
      By.xpath("//*[@resource-id='dsgui.android:id/sc_menu_title' and @text='LICENSE AGREEMENT']");
  public By Terms_Of_Use =
      By.xpath("//*[@resource-id='dsgui.android:id/sc_menu_title' and @text='TERMS OF USE']");
  public By Scorecard_Terms =
      By.xpath("//*[@resource-id='dsgui.android:id/sc_menu_title' and @text='SCORECARD TERMS']");
  public By Promo_Exclusions =
      By.xpath("//*[@resource-id='dsgui.android:id/sc_menu_title' and @text='PROMO EXCLUSIONS']");
  public By California_Disclosures =
      By.xpath(
          "//*[@resource-id='dsgui.android:id/sc_menu_title' and @text='CALIFORNIA DISCLOSURES']");
  public By Product_Availability_And_Price =
      By.xpath(
          "//*[@resource-id='dsgui.android:id/sc_menu_title' and @text='PRODUCT AVAILABILITY & PRICE']");
  public By Recalls =
      By.xpath("//*[@resource-id='dsgui.android:id/sc_menu_title' and @text='RECALLS']");
}
