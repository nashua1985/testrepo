package com.dsg.testng.android.locators;

import org.openqa.selenium.By;

public class LocationAllowLocators {
  public By Your_location_is_needed_for_personalizing_your_app_experience =
      By.xpath("//*[@resource-id='dsgui.android:id/snackbar_action']");
  public By Allow_all_the_time_Button =
      By.xpath(
          "//*[@resource-id='com.android.permissioncontroller:id/permission_allow_always_button']");
  public By Allow_only_while_using_the_app_Button =
      By.xpath(
          "//*[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']");
  public By Deny_Button =
      By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_deny_button']");
  public By Allow_DICKs_to_access_this_devices_location =
      By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_message']");
}
