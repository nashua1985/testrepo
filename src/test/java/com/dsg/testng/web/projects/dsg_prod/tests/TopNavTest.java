package com.dsg.testng.web.projects.dsg_prod.tests;

import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.framework.enums.Browser;
import com.dsg.testng.web.locators.DSGLocators;
import com.dsg.testng.web.projects.dsg_prod.resources.DSGMethods;
import com.dsg.testng.web.resources.WebNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

// import com.dsg.utilities.HighlightElement;

public class TopNavTest extends WebDriverBaseTest {

  static Boolean testStatus = true;

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void topNavTest(Browser browser, RunType runType, String sport) throws Exception {

    this.createDriver(browser, "topNavTest", runType);

    WebNavigation nav = getWebNavigation();
    int topNavType = 0;

    DSGMethods dsg = new DSGMethods();

    nav.goToURL(urls.getURL("DSGProd"));
    nav.MyWait(By.id("survey_tab"));

    dsg.checkForAndClosePromo();

    if (nav.VerifyExistance(DSGLocators.TopNavButton)) {
      nav.Hover(DSGLocators.TopNavButton);
    } else {
      nav.Click(DSGLocators.TopNavButtonClick);

      nav.Sleep(2);
      nav.Click(By.className("category-name"));

      nav.Sleep(2);

      topNavType = 1;
    }

    if (topNavType == 0) {
      nav.Click(By.xpath("//*[contains(text(), '" + sport + "')]"));
    } else {
      nav.Click(
          By.xpath("//*[@class = 'sub-category-name' and contains(text(), '" + sport + "')]"));
    }

    // if modal exists close it
    dsg.checkForAndClosePromo();

    // because top nav is always present category name must appear more than once
    List<WebElement> elements =
        nav.getDriver().findElements(By.xpath("//*[contains(text(), '" + sport + "')]"));
    assertTrue(elements.size() > 0);

    nav.Sleep(5);

    nav.cleanup();
  }
}
