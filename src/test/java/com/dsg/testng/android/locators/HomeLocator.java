package com.dsg.testng.android.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class HomeLocator {
  // public By
  // Sign_in_to_your_account_to_earn_points,_track_rewards,_experience_faster_checkout,_and_more.TextView
  // = By.xpath("//*[@resource-id='dsgui.android:id/sc_signedout_text']");
  public By WELCOME_TextView =
      By.xpath("//*[@resource-id='dsgui.android:id/personalization_title']");
  public By SHOP_BY_TextView = By.xpath("//*[@resource-id='dsgui.android:id/shop_card_title']");
  public By Toolbar_title_TextView = By.xpath("//*[@resource-id='dsgui.android:id/toolbar_title']");
  public By Shopping_cart_TextView = By.xpath("//*[@resource-id='dsgui.android:id/shopping_cart']");
  public By What_can_we_help_you_find_TextView =
      By.xpath("//*[@resource-id='dsgui.android:id/search_hint_text']");
  public By Your_location_is_needed_for_personalizing_your_app_experience_TextView =
      By.xpath("//*[@resource-id='dsgui.android:id/snackbar_text']");
  public By SIGN_UP_Button = By.xpath("//*[@resource-id='dsgui.android:id/sc_signup_cta']");
  public By SIGN_IN_Button = By.xpath("//*[@resource-id='dsgui.android:id/sc_signin_cta']");
  public By SHOP_ALL_Button = By.xpath("//*[@text='SHOP ALL']");
  public By OK_Button = By.xpath("//*[@resource-id='dsgui.android:id/snackbar_action']");
  public By toolbar = By.xpath("//*[@resource-id='dsgui.android:id/toolbar']");
  public By home_search_bar = By.xpath("//*[@resource-id='dsgui.android:id/home_search_bar']");
  public By marketing_image = By.xpath("//*[@resource-id='dsgui.android:id/marketing_image']");
  public By Shop_By_Sports =
      By.xpath("//*[@resource-id='dsgui.android:id/shop_card_cat_txt'][@text='Sports']");
  public By Shop_By_Footwear =
      By.xpath("//*[@resource-id='dsgui.android:id/shop_card_cat_txt'][@text='Footwear']");
  public By Shop_By_Apparel =
      By.xpath("//*[@resource-id='dsgui.android:id/shop_card_cat_txt'][@text='Apparel']");
  public By Shop_By_Accessories =
      By.xpath("//*[@resource-id='dsgui.android:id/shop_card_cat_txt'][@text='Accessories']");
  public By Shop_By_Outdoor =
      By.xpath("//*[@resource-id='dsgui.android:id/shop_card_cat_txt'][@text='Outdoor']");
  public By Shop_By_Outwear =
      By.xpath("//*[@resource-id='dsgui.android:id/shop_card_cat_txt'][@text='Outerwear']");
  public By Shop_By_Fan_Shop =
      By.xpath("//*[@resource-id='dsgui.android:id/shop_card_cat_txt'][@text='Fan Shop']");
  public By Shop_By_Sneaker_Releases =
      By.xpath("//*[@resource-id='dsgui.android:id/shop_card_cat_txt'][@text='Sneaker Releases']");
  public By Shop_By_Shoe_Release_Calendar =
      By.xpath(
          "//*[@resource-id='dsgui.android:id/shop_card_cat_txt'][@text='Shoe Release Calendar']");
  public By Shop_By_Clearance =
      By.xpath("//*[@resource-id='dsgui.android:id/shop_card_cat_txt'][@text='Clearance']");
  public By scan_bar_code_icon =
      By.xpath("//*[@resource-id='dsgui.android:id/scan_bar_code_icon']");
  public By Shop_Special_Promotion =
      By.xpath("//*[@resource-id='dsgui.android:id/marketing_image']");

  public By My_Offers_See_More = By.id("dsgui.android:id/my_offers_button");
  public By SHOP_NOW = By.xpath("//*[@class='android.widget.Button'][@text='SHOP NOW']");
  // public By Picked_For_You = By.xpath("//*[@resource-id='dsgui.android:id/my_offers_button']");
  // TODO: NEED A UNIQUE IDENTIFIER FOR THIS ELEMENT

  public By SEARCH = MobileBy.AccessibilityId("Search");
  public By Marketing_Card = MobileBy.AccessibilityId("Shop Special Promotion");
  public By MyOffer_Card_Text = By.id("dsgui.android:id/offer_card_text");

  // Home screen when logged in
  public By Personalization_Title = By.id("dsgui.android:id/personalization_title");
  public By Progress_Box = By.id("dsgui.android:id/mainBoxProgress");

  // Home screen My Store
  public By Weekly_Ad = By.xpath("//*[@class='android.widget.TextView'][@text='WEEKLY AD']");
  public By SET_STORE = By.xpath("//*[@resource-id='dsgui.android:id/home_screen_set_store_text']");
  public By My_Store_Call_Store =
      By.xpath("//*[@resource-id='dsgui.android:id/store_call_button']");
  public By My_Store_Directions =
      By.xpath("//*[@resource-id='dsgui.android:id/storelist_directions_icon']");
  public By My_Store_Services =
      By.xpath("//*[resource-id='dsgui.android:id/mystore_weekly_ad_icon']");
  public By Store_Title = By.xpath("//*[@resource-id='dsgui.android:id/store_title']");
  public By HomePage = By.xpath("//*[@resource-id='dsgui.android:id/drawer_layout']");
  public By My_Store = By.xpath("//*[@resource-id='dsgui.android:id/home_my_store_view']");
  public By My_Store_Text = By.xpath("//*[resource-id='dsgui.android:id/home_screen_store_text']");
}
