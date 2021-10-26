package com.dsg.testng.web.projects.primo.resources;

import org.openqa.selenium.By;

public class PrimoLocators {

  public static By userName = By.id("TxtUserName");
  public static By passWord = By.id("TxtPassword");
  public static By loginButton = By.id("BtnLogin");
  public static By productFlagsMenuLink = By.id("row2col3");
  public static By productFlagMaintenanceLink = By.id("A1");

  // Product Flag Admin
  public static By flagDropDownList = By.id("ddlAttributes");
  public static By listPack = By.cssSelector("select[id = ddlAttributes] option[value = 'PACK']");
  public static By listHCase = By.cssSelector("select[id = ddlAttributes] option[value = 'HCASE']");
  public static By listHUnit = By.cssSelector("select[id = ddlAttributes] option[value = 'HUNIT']");

  public static By levelDropDownList = By.id("ddlLevels");
  public static By levelListStyle =
      By.cssSelector("select[id = ddlLevels] option[value = 'Style']");

  public static By updateSingleStyleRadioButton = By.id("rdoActions_0");
  public static By enterStyleTextLookup = By.id("txtLookup");
  public static By continueButton = By.id("btnContinue");
  public static By setButton = By.id("btnSet");
  public static By okButton = By.id("btnOkay");

  public static By valueDropDownList = By.id("ddlValue");
  public static By valueListPackApparel =
      By.cssSelector("select[id = ddlValue] option[value = 'A']");
  public static By valueListPackSemiBulk =
      By.cssSelector("select[id = ddlValue] option[value = 'S']");

  public static By valueListHcaseMedium =
      By.cssSelector("select[id = ddlValue] option[value = 'MS']");
  public static By valueListHcaseSmall =
      By.cssSelector("select[id = ddlValue] option[value = 'SS']");

  public static By valueListHunitMedium =
      By.cssSelector("select[id = ddlValue] option[value = 'MS']");
  public static By valueListHunitSmall =
      By.cssSelector("select[id = ddlValue] option[value = 'SS']");

  public static By flagSetLabelResult = By.id("lblResult");
}
