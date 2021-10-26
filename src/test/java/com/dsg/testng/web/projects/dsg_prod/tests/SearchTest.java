package com.dsg.testng.web.projects.dsg_prod.tests;

import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.framework.enums.Browser;
import com.dsg.testng.web.locators.DSGLocators;
import com.dsg.testng.web.projects.dsg_prod.resources.DSGMethods;
import com.dsg.testng.web.resources.WebNavigation;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends WebDriverBaseTest {

  static Boolean testStatus = true;

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void searchTest(Browser browser, RunType runType, String searchTerm) throws Exception {

    this.createDriver(browser, "searchTest", runType);

    WebNavigation nav = getWebNavigation();

    DSGMethods dsg = new DSGMethods();

    nav.goToURL(urls.getURL("DSGProd"));
    nav.MyWait(By.id("survey_tab"));

    // close promo
    dsg.checkForAndClosePromo();

    nav.EnterText(DSGLocators.PROD_SkuSearchBar, searchTerm);
    nav.Click(DSGLocators.PROD_SkuSearchButton);

    /*for(int i =0; i < 20; i++)
    {
        DriverManager.getDriver().switchTo().parentFrame();
    }*/

    nav.MyWait(By.id("survey_tab"));
    // HighlightElement.PrintAllElementsText();

    // if(!nav.VerifyExistance(By.xpath("//*[contains(innerText, 'results for \"" + searchTerm +
    // ".\"')]")));

    // if(!nav.VerifyExistance(By.xpath("//*[@class='rs-search-text']")));
    if (!nav.VerifyExistance(
            By.xpath(
                "//*[@class='rs-search-text' and contains(.,'results for \""
                    + searchTerm
                    + ".\"')]"))
        && !nav.VerifyExistance(
            By.xpath(
                "//*[@class='rs-page-title-wrapper' and contains(., 'results for \""
                    + searchTerm
                    + "\"')]"))) {
      Assert.fail("Search term " + searchTerm + " not found");
    } else {
      nav.Print("Search term " + searchTerm + " found");
    }

    nav.cleanup();
  }
}
