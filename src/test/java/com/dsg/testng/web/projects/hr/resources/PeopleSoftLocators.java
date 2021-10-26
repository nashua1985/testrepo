package com.dsg.testng.web.projects.hr.resources;

import org.openqa.selenium.By;

public class PeopleSoftLocators {
  public static By User = By.id("userid");
  public static By type = By.id("text");
  public static By Loginuser = By.id("userid");
  public static By Loginpword = By.id("pwd");
  public static By Signon = By.name("Submit");
  // public static By Homebox = By.id("win0divPTNUI_LAND_REC_GROUPLET$31");
  public static By Homebox = By.xpath("//*[contains(@onclick,'CLASSIC_HOME')]");
  public static By Homebox2 = By.id("win0divPTNUI_LAND_REC_GROUPLET$1");
  public static By Main = By.id("pthnavbca_PORTAL_ROOT_OBJECT");
  public static By Peopletools = By.id("PT_PEOPLETOOLS");
  public static By Security = By.id("fldra_PT_SECURITY");
  public static By Profile = By.id("fldra_PT_USER_PROFILES");
  public static By Profile2 = By.id("crefli_PT_USERMAINT_GBL");
  public static By Operdfn = By.id("PSOPRDEFN_SRCH_OPRID");
  public static By Search1 = By.id("#ICSearch");
  public static By Acctlock = By.id("PSOPRDEFN_ACCTLOCK_LBL");
  public static By Save = By.id("#ICSave");
  public static By Cgpword = By.id("PSUSRPRFL_WRK_CHANGE_PWD_BTN_LBL");
  public static By pone = By.id("PSUSRPRFL_WRK_OPERPSWD");
  public static By ptwo = By.id("PSUSRPRFL_WRK_OPERPSWDCONF");
  // public static By retsrch = By.id("#ICList");
  public static By retsrch = By.xpath("//*[@value = 'Return to Search']");
  public static By Wkfcadmin = By.id("fldra_HC_WORKFORCE_ADMINISTRATION");
  public static By Perinfo = By.id("fldra_CO_PERSONAL_INFORMATION");
  public static By Addpersn = By.id("crefli_HC_ADD_PERSON_2");
  public static By Add = By.id("DERIVED_HCR_PER_ADD_PERSON_LINK");
  public static By Addname = By.id("DERIVED_NM_LVL2_UPDATE_NAME_BTN$0");
  public static By First = By.id("HCR_UPDNAME_DVW_FIRST_NAME$1");
  public static By Payroll = By.id("win0groupletPTNUI_LAND_REC_GROUPLET$25");
  public static By Paystmt = By.id("win7divPTGP_STEP_DVW_PTGP_STEP_BTN_GB$4");
  public static By Stub = By.id("PAY_END_DT_ALT$0");
  public static By PersDetails = By.id("win0groupletPTNUI_LAND_REC_GROUPLET$32");
  public static By Addresses = By.id("win0divSELECT1$0");
  public static By HomeAddress = By.id("win0divHOME_ADDRESS_GB04$0");
  public static By Street = By.id("ADDRESS1");
  public static By Last = By.id("HCR_UPDNAME_DVW_LAST_NAME$3");
  public static By Savname = By.id("DERIVED_NM_LVL2_OK_PB");
  public static By idfield = By.id("PSOPRDEFN_SRCH_OPRID");
  public static By Birthdt = By.id("PERSON_BIRTHDATE");
  public static By Gender = By.id("PERS_DATA_EFFDT_SEX$0");
  public static By SSN = By.id("DERIVED_HR_NID_SPECIAL_CHAR$0");
  public static By Approvals =
      By.xpath(
          "//*[contains(innerText, 'Approvals') and contains(@id, 'PTNUI_LAND_REC_GROUPLET_LBL')]");
}
