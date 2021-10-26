package com.dsg.testng.android.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FindAStoreLocators {
  public By ToolBar_Title = By.xpath("//*[@resource-id='dsgui.android:id/toolbar_title']");
  public By Search_Icon = MobileBy.AccessibilityId("Search");
  public By Zip_Code_or_City_StateEditText =
      By.xpath("//*[@resource-id='dsgui.android:id/search_src_text']");
  public By searchview = By.xpath("//*[@resource-id='dsgui.android:id/searchview_grayoverlay']");
  public By searchListItem1 =
      By.xpath("//*[@resource-id='dsgui.android:id/store_list_item'] [@index=0]");
  public By searchListItem2 =
      By.xpath("//*[@resource-id='dsgui.android:id/store_list_item'] [@index=1]");
  public By firstStoreTitle = By.xpath("//*[@resource-id='dsgui.android:id/store_title']");
  public By firstStoreCheckbox = By.xpath("//*['dsgui.android:id/my_store_checkbox']");
  public By setStoreText = By.xpath("//*[@resource-id='dsgui.android:id/set_my_store_text']");
}
