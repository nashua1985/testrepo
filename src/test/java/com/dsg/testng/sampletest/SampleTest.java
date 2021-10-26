package com.dsg.testng.sampletest;

import com.dsg.framework.enums.Browser;
import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.testng.web.locators.DSGLocators;
import com.dsg.testng.web.projects.dsg_prod.resources.DSGMethods;
import com.dsg.testng.web.resources.WebNavigation;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

//import com.dsg.framework.enums.Browser;

public class SampleTest extends WebDriverBaseTest {

  String searchTerm = "golf clubs";

  @Test(dataProvider = "sauceBrowsers") // "localBrowsers")
  public void sampleSearchTest(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "sampleSearchTest", runType);

    WebNavigation nav = getWebNavigation();

    DSGMethods dsg = new DSGMethods();

    nav.goToURL(urls.getURL("DSGProd"));
    nav.MyWait(By.id("survey_tab"));

    // close promo
    dsg.checkForAndClosePromo();

    nav.EnterText(DSGLocators.PROD_SkuSearchBar, searchTerm);
    nav.Click(DSGLocators.PROD_SkuSearchButton);

    nav.Sleep(2);
  }

  @Test(dataProvider = "sauceBrowsers") // "localBrowsers")
  public void sampleSearchTest2(
          // String browser,
          // String browserVersion,
          // String platformName,
          Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "sampleSearchTest2", runType);

    WebNavigation nav = getWebNavigation();

    DSGMethods dsg = new DSGMethods();

    nav.goToURL(urls.getURL("DSGProd"));
    nav.MyWait(By.id("survey_tab"));

    // close promo
    dsg.checkForAndClosePromo();

    nav.EnterText(DSGLocators.PROD_SkuSearchBar, searchTerm);
    nav.Click(DSGLocators.PROD_SkuSearchButton);

    nav.Sleep(2);
  }
}
