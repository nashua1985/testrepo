package com.dsg.testng.web.projects.dsg_prod.resources;

import com.dsg.testng.web.locators.DSGLocators;
import com.dsg.testng.web.resources.WebNavigation;
import org.openqa.selenium.By;

public class DSGShortcuts extends DSGMethods {

  /** Leave swimlane blank "" to not set swimlane */
  public void NavigateToDSGEnterSku_PROD(WebNavigation nav, String Swimlane, String Sku) {
    nav.goToURL(urls.getURL("DSGProd"));

    if (!Swimlane.equals("")) {
      // Set Swimlane
      nav.getDriver().manage().deleteAllCookies();
      // DriverManager.setCookie("akaas_AS_Exp_Desktop_1", Swimlane, "dickssportinggoods.com");
      nav.setCookie("akaas_AS_EXP_DSG", Swimlane, "dickssportinggoods.com");
      nav.getDriver().navigate().refresh();
    }

    nav.MyWait(By.id("survey_tab"));

    checkForAndClosePromo();

    // nav.EnterText(DSGLocators.PROD_SkuSearchBar, sku);
    nav.EnterText(DSGLocators.PROD_SkuSearchBar, Sku);
    nav.Click(DSGLocators.PROD_SkuSearchButton);

    checkForAndClosePromo();
  }
}
