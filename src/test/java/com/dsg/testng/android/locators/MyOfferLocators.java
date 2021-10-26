package com.dsg.testng.android.locators;

import org.openqa.selenium.By;

public class MyOfferLocators {
  public By PERSONALIZE_YOUR_OFFERS =
      By.xpath("//*[@resource-id='dsgui.android:id/myoffers_onboarding_title']");
  public By WHO_DO_YOU_SHOP_FOR =
      By.xpath("//*[@resource-id='dsgui.android:id/myoffers_onboarding_subtitle']");
  public By MenTextView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Men']");
  public By WomenTextView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Women']");
  public By BoysTextView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Boys']");
  public By GirlsTextView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Girls']");
  public By TeamSportsTextView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Team Sports']");
  public By FootWearTextView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Footwear']");
  public By ApparelTextView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Apparel']");
  public By HuntingAndFishingView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Hunting & Fishing']");
  public By FanShopView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Fan Shop']");
  public By GolfView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Golf']");
  public By OutDoorRecView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Outdoor Rec']");
  public By FitnessView =
      By.xpath("//*[@resource-id='dsgui.android:id/category_name' and @text='Fitness']");
  public By HalfTextView = By.xpath("//*[@resource-id='dsgui.android:id/page_indicator_footer']");
  public By NEXT_Button =
      By.xpath("//*[@resource-id='dsgui.android:id/myoffers_onboarding_next_button']");
  public By Offer_Content =
      By.xpath("//*[@resource-id='dsgui.android:id/offers_onboarding_content']");
  public By JUST_FOR_YOU_TEXT =
      By.xpath("//*[@resource-id='dsgui.android:id/my_offers_list_header_textview']");

  // public By Exit_Out = MobileBy.AccessibilityId("Navigate up");
  public By Exit_Out = By.id("dsgui.android:id/offers_onboarding_exit");
  public By Offer_Card_Text = By.id("dsgui.android:id/offer_card_text");
  public By Offer_CardView =
      By.xpath("//*[@resource-id='dsgui.android:id/my_offers_cardview' and @index=2]");
  // public By offer2 = By.xpath("//android.widget.FrameLayout[1]//android.widget.TextView");
  public By Second_Offer_Card_Text =
      By.xpath(
          "//android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView");
  public By MyOffers_Title = By.id("dsgui.android:id/toolbar_title");
  public By Shop_Now = By.xpath("//*[@text='SHOP NOW']");
}
