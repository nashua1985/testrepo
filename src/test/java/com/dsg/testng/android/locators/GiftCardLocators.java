package com.dsg.testng.android.locators;

import org.openqa.selenium.By;

public class GiftCardLocators {
  public By SIGN_IN_TO_SCORECARD_Button =
      By.xpath("//*[@resource-id='dsgui.android:id/giftcards_sign_in_button']");
  public By BUY_A_GIFT_CARD_Button =
      By.xpath("//*[@resource-id='dsgui.android:id/button_buy_giftcard']");
  public By OK_Button = By.xpath("//*[@resource-id='dsgui.android:id/snackbar_action']");
  // public By Gift_CardsTextView = By.xpath("//*[@resource-id='dsgui.android:id/toolbar_title']");
  public By to_View_or_Add_a_Gift_CardTextView =
      By.xpath("//*[@text='to View or Add a Gift Card']");
  // public By Your_location_is_needed_for_personalizing_your_app_experience.TextView =
  // By.xpath("//*[@resource-id='dsgui.android:id/snackbar_text']");
}
