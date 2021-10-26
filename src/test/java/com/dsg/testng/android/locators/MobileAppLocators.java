package com.dsg.testng.android.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class MobileAppLocators {
  // New Onboarding Screens Android
  public By androidContinueAsGuest = By.id("dsgui.android:id/continue_as_guest");
  public By androidGetStarted = By.xpath("//*[@text='GET STARTED']");
  public By androidNext = By.xpath("//*[@text='NEXT']");
  public By androidCreateAccount = By.xpath("//*[@text='CREATE ACCOUNT']");
  public By androidSignIn = By.xpath("//*[@text='SIGN IN']");
  public By androidMaybeLater = By.xpath("//*[@text='MAYBE LATER']");
  public By androidSetUpMove = By.xpath("//*[@text='SET UP MOVE & GET 100 PTS']");

  // iOS Locators
  // public By iAllowNotifications = By.id("Allow");
  // public By iAccessLocation= By.id("Allow While Using App");
  public By iWelcome = By.xpath("//XCUIElementTypeOther[@name='main']/XCUIElementTypeButton");

  public By iHamburger = By.id("hamburger");
  public By iMenuScorecard = By.id("ScoreCard");
  public By iMenuShop = By.id("Shop");

  public By iEmail = By.xpath("//*[@value='Email']");
  public By iPassword = By.xpath("//*[@value='Password']");
  public By iSignIn = By.id("SIGN IN");
  public By iScorecardNumberText = By.id("SCORECARD NUMBER:");
  public By iScorecardNumber = By.id("L014B246K834");

  // public By iLocation = By.name("OK");

  // Android Locators
  public By aSearchBar = By.id("dsgui.android:id/home_search_bar");
  public By aSearchText = By.id("dsgui.android:id/search_src_text");

  // Hamburger
  public By aHamburger = MobileBy.AccessibilityId("Open navigation drawer");
  // public By aHome = By.xpath("//*[@text='Home']");
  public By aHome = By.id("dsgui.android:id/homeFragment");
  public By aShop = By.xpath("//*[@text='Shop']");
  public By aTrackYourOrder = By.xpath("//*[@text='Track and Pickup Orders']");

  // public By aScoreCard = By.xpath("//*[@text='ScoreCard']");
  public By aScoreCard = By.id("dsgui.android:id/scoreCardHome");
  public By aMove = By.xpath("//*[@text='MOVE']");
  public By aMyOffers = By.xpath("//*[@text='My Offers']");
  public By aNewOffers = By.xpath("//*[@text='New Offers']");
  public By aGiftCards = By.xpath("//*[@text='Gift Cards']");
  public By aFindAStore = By.xpath("//*[@text='Find A Store']");
  public By aWeeklyAd = By.xpath("//*[@text='Weekly Ad']");
  public By aCreditCard = By.xpath("//*[@text='Credit Card']");
  public By aSportsMatter = By.xpath("//*[@text='Sports Matter']");
  public By aLegalPrivacy = By.xpath("//*[@text='Legal & Privacy']");
  public By aSupportFeedback = By.xpath("//*[@text='Support & Feedback']");
  public By aVersion = By.id("dsgui.android:id/main_menu_footer_version_text");

  // Page Verification
  public By aVerifyHome = By.id("dsgui.android:id/personalization_title");
  public By aVerifyShop = By.id("dsgui.android:id/toolbar_title");
  public By aVerifyTrackYourOrder = By.id("track-order-heading");
  public By aVerifyScoreCard = By.id("dsgui.android:id/fragment_sc_sign_in_shout_out");

  public By aWelcomeHeader = By.id("dsgui.android:id/fragment_sc_home_welcome");
  public By aAccountNumberHeading = By.id("dsgui.android:id/accountNumberHeading");
  public By aAccountNumber = By.id("dsgui.android:id/accountNumber");

  public By aWelcome =
      By.xpath(
          "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[1]");
  public By aLocation =
      By.xpath(
          "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.ImageView");

  public By aSignInHome = By.id("dsgui.android:id/sc_signin_cta");
  public By aEmail = By.id("dsgui.android:id/fragment_sc_sign_in_email_field");
  public By aPassword = By.id("dsgui.android:id/fragment_sc_sign_in_password_field");
  public By aSignIn = By.id("dsgui.android:id/fragment_sc_sign_in_button");
  public By aSignInShoutOut = By.id("dsgui.android:id/fragment_sc_sign_in_shout_out");

  public By aSignOut = By.id("dsgui.android:id/main_menu_footer_signout_btn");

  public By aMovePopup =
      By.xpath(
          "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[1]");

  public By NavWindow = By.id("dsgui.android:id/mainMenuItemList");
}
