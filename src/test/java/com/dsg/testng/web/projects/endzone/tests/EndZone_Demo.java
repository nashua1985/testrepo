package com.dsg.testng.web.projects.endzone.tests;

import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.framework.enums.Browser;
import com.dsg.framework.loggers.TestNGLogMethods;
import com.dsg.testng.web.projects.endzone.resources.EndZoneLocators;
import com.dsg.testng.web.resources.WebNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndZone_Demo extends WebDriverBaseTest {

  String url = "https://pointofsale-stg.dcsg.com/";
  String itemUPC = "092389122572";

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void placeCashOrder(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "placeCashOrder", runType);

    // RemoteWebDriver driver = getRemoteWebDriver();
    WebNavigation nav = getWebNavigation();
    // EndZoneLocators ez = new EndZoneLocators();

    try {
      TestNGLogMethods.logStep("Go to URL: " + url);
      nav.goToURL(url);

      TestNGLogMethods.logStep("Sign in");
      nav.Click(EndZoneLocators.associateNumber);
      nav.Sleep(1);
      nav.EnterText(EndZoneLocators.associateNumber, "1234567");
      nav.Sleep(1);
      nav.EnterText(EndZoneLocators.associatePin, "111111");
      nav.Sleep(1);
      nav.Click(EndZoneLocators.loginSubmit);

      TestNGLogMethods.logStep("Scan item: " + itemUPC);
      nav.EnterText(EndZoneLocators.scanItem, itemUPC);
      nav.Sleep(1);
      nav.Click(EndZoneLocators.itemSubmit);

      TestNGLogMethods.logStep("Get Order Total");
      String orderTotal = nav.GetTextValue(EndZoneLocators.orderTotal);
      nav.Sleep(1);

      TestNGLogMethods.logStep("Click Complete Transaction button");
      nav.Click(EndZoneLocators.completeTransaction);
      nav.Sleep(1);

      TestNGLogMethods.logStep("Click Cash button");
      nav.Click(EndZoneLocators.cashButton);
      nav.Sleep(1);

      TestNGLogMethods.logStep("Enter Cash Amount");
      nav.EnterText(EndZoneLocators.cashInput, orderTotal);
      nav.Sleep(1);

      TestNGLogMethods.logStep("Click Cash Enter button");
      nav.Click(EndZoneLocators.cashEnterButton);
      nav.Sleep(1);

      TestNGLogMethods.logStep("Click New Transaction button");
      nav.Click(EndZoneLocators.newTransactionButton);
      nav.Sleep(1);

      TestNGLogMethods.logStep("Click Close Register button");
      nav.Click(EndZoneLocators.closeRegisterButton);
      nav.Sleep(1);

      nav.Sleep(3);

    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail("Unable to complete order");
    }
  }
}
