package com.dsg.testng.web.projects.primo.tests;

/*
This Primo Script will update the Style for different flags: PACK, HUNIT, HCASE
Created for a specific excel file list - will need updates for future use.
One off script for Carol Estok.
-jdj
 */

import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.framework.enums.Browser;
import com.dsg.framework.loggers.TestNGLogMethods;
import com.dsg.testng.web.projects.primo.resources.FlagStyleSet;
import com.dsg.testng.web.projects.primo.resources.PrimoLocators;
import com.dsg.testng.web.projects.primo.resources.ReadExcelFile;
import com.dsg.testng.web.resources.WebNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Primo_UpdateStyleFlags extends WebDriverBaseTest {

  boolean header = true;

  String URL = "http://primoqa/primo/login.aspx";
  String userName = "";
  String passWord = "";

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void updateStyleFlags(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "updateStyleFlags", runType);

    WebNavigation nav = getWebNavigation();

    try {
      TestNGLogMethods.logStep("Go to URL: " + URL);
      nav.goToURL(URL);
      // nav.Sleep(3);

      TestNGLogMethods.logStep("Login to Primo");
      primoLogin();

      TestNGLogMethods.logStep("Go To Product Flag Admin");
      nav.Click(PrimoLocators.productFlagsMenuLink);
      nav.Click(PrimoLocators.productFlagMaintenanceLink);

    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail("Unable to log into Primo or navigate to Product Flag Admin");
    }

    ArrayList<FlagStyleSet> flagStyleSetArrayList =
        new ArrayList<>(ReadExcelFile.readExcelFileFlagStyleSet());

    /*ArrayList<FlagStyleSet> flagStyleSetArrayList = new ArrayList<>();
    FlagStyleSet styleSet = new FlagStyleSet("DSGM00001", "Apparel", "Small in size, Lightweight (SS)", "Small in size, Lightweight (SS)");
    //FlagStyleSet styleSet2 = new FlagStyleSet("LG KRAFT PAPER", "Semi Bulk", "Medium in size, lightweight (MS)", "Medium in size, lightweight (MS)");

    flagStyleSetArrayList.add(styleSet);
    flagStyleSetArrayList.add(styleSet);*/

    int i = 0;
    for (FlagStyleSet set : flagStyleSetArrayList) {

      if (header && i == 0) {
        TestNGLogMethods.logInfo("File Contains Header: " + set.headerToString());
        // System.out.println("File Contains Header: " + set.headerToString());
      } else {

        // PACK
        nav.Click(PrimoLocators.listPack);
        nav.Click(PrimoLocators.levelListStyle);
        nav.Click(PrimoLocators.updateSingleStyleRadioButton);
        nav.EnterText(PrimoLocators.enterStyleTextLookup, set.getStyle());
        nav.Click(PrimoLocators.continueButton);

        if (set.getPack().equals("Apparel")) {
          nav.Click(PrimoLocators.valueListPackApparel);
        } else {
          nav.Click(PrimoLocators.valueListPackSemiBulk);
        }

        nav.Click(PrimoLocators.setButton);
        String result = nav.GetTextValue(PrimoLocators.flagSetLabelResult);
        if (result.equals("1 of 1 records were updated.")) {
          TestNGLogMethods.logInfo(
              "ROW: "
                  + (i + 1)
                  + ": COMPLETE: "
                  + "PACK"
                  + " : "
                  + set.getStyle()
                  + " : "
                  + set.getPack());
        } else {
          TestNGLogMethods.logInfo(
              "ROW: "
                  + (i + 1)
                  + ": FAILED: "
                  + "PACK"
                  + " : "
                  + set.getStyle()
                  + " : "
                  + set.getPack());
        }
        nav.Click(PrimoLocators.okButton);

        // HCASE
        nav.Click(PrimoLocators.listHCase);
        nav.Click(PrimoLocators.levelListStyle);
        nav.Click(PrimoLocators.updateSingleStyleRadioButton);
        nav.EnterText(PrimoLocators.enterStyleTextLookup, set.getStyle());
        nav.Click(PrimoLocators.continueButton);

        if (set.gethCase().equals("Small in size, Lightweight (SS)")) {
          nav.Click(PrimoLocators.valueListHcaseSmall);
        } else {
          nav.Click(PrimoLocators.valueListHcaseMedium);
        }

        nav.Click(PrimoLocators.setButton);
        String result2 = nav.GetTextValue(PrimoLocators.flagSetLabelResult);
        if (result2.equals("1 of 1 records were updated.")) {
          TestNGLogMethods.logInfo(
              "ROW: "
                  + (i + 1)
                  + ": COMPLETE: "
                  + "HCASE"
                  + " : "
                  + set.getStyle()
                  + " : "
                  + set.gethCase());
        } else {
          TestNGLogMethods.logInfo(
              "ROW: "
                  + (i + 1)
                  + ": FAILED: "
                  + "HCASE"
                  + " : "
                  + set.getStyle()
                  + " : "
                  + set.gethCase());
        }
        nav.Click(PrimoLocators.okButton);

        // HUNIT
        nav.Click(PrimoLocators.listHUnit);
        nav.Click(PrimoLocators.levelListStyle);
        nav.Click(PrimoLocators.updateSingleStyleRadioButton);
        nav.EnterText(PrimoLocators.enterStyleTextLookup, set.getStyle());
        nav.Click(PrimoLocators.continueButton);

        if (set.gethUnit().equals("Small in size, Lightweight (SS)")) {
          nav.Click(PrimoLocators.valueListHunitSmall);
        } else {
          nav.Click(PrimoLocators.valueListHunitMedium);
        }

        nav.Click(PrimoLocators.setButton);
        String result3 = nav.GetTextValue(PrimoLocators.flagSetLabelResult);
        if (result3.equals("1 of 1 records were updated.")) {
          TestNGLogMethods.logInfo(
              "ROW: "
                  + (i + 1)
                  + ": COMPLETE: "
                  + "HUNIT"
                  + " : "
                  + set.getStyle()
                  + " : "
                  + set.gethUnit());
        } else {
          TestNGLogMethods.logInfo(
              "ROW: "
                  + (i + 1)
                  + ": FAILED: "
                  + "HUNIT"
                  + " : "
                  + set.getStyle()
                  + " : "
                  + set.gethUnit());
        }
        nav.Click(PrimoLocators.okButton);
      }
      i++;
    }
    TestNGLogMethods.logInfo("End of File");

    // Assert.fail();
    // 1 of 1 records were updated.
  }

  public void primoLogin() {

    WebNavigation nav = getWebNavigation();

    nav.EnterText(PrimoLocators.userName, userName);
    // nav.Sleep(3);

    nav.EnterText(PrimoLocators.passWord, passWord);
    // nav.Sleep(3);

    nav.Click(PrimoLocators.loginButton);
    // nav.Sleep(3);
  }
}
