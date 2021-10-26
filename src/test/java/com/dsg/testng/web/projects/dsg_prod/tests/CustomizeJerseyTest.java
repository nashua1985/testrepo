package com.dsg.testng.web.projects.dsg_prod.tests;

import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.framework.enums.Browser;
import com.dsg.testng.web.locators.DSGLocators;
import com.dsg.testng.web.projects.dsg_prod.resources.DSGMethods;
import com.dsg.testng.web.resources.WebNavigation;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CustomizeJerseyTest extends WebDriverBaseTest {

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void cutomizeJerseyTest(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "customizeJerseyTest", runType);

    WebNavigation nav = getWebNavigation();

    boolean ss = false;

    DSGMethods dsg = new DSGMethods();

    nav.goToURL(urls.getURL("DSGProd"));
    nav.MyWait(By.id("survey_tab"));

    // close promo
    dsg.checkForAndClosePromo();

    nav.EnterText(DSGLocators.PROD_SkuSearchBar, "17ADIMNHLPNSHMCSTAPT");
    nav.Click(DSGLocators.PROD_SkuSearchButton);

    dsg.checkForAndClosePromo();

    nav.TakeScreenshot("01 Sku pdp", ss);

    // nav.ClickLoop(By.xpath("//*[@class='button-attribute button-text-attr ng-tns-c14-1
    // ng-star-inserted selected-block-swatch' and text()='S']"));
    nav.MyWait(By.id("survey_tab"));

    nav.Click(By.xpath("//*[contains(@class, 'ng-tns-c14-1') and contains(text(), ' 52 ')]"));

    nav.Click(By.id("customize-button"));

    for (int i = 0; i < 20; i++) {
      nav.getDriver().switchTo().parentFrame();
    }

    // click on the text field to give the right frame focus
    nav.ClickiFrameIgnore(By.xpath("//*[contains(@id, 'playerNameInput')]"));
    nav.EnterText(By.xpath("//*[contains(@id, 'playerNameInput')]"), "Shoresy");
    // nav.ClickLoop(By.id("sliderRight"));
    nav.EnterText(By.id("teamplayernumberstaticcolor-playerNumberInput"), "99");
    nav.TakeScreenshot("02 Customize fields", ss);
    nav.ClickLoop(By.id("sliderRight"));
    nav.Click(By.id("formSubmit"));

    nav.TakeScreenshot("03 Customization applied", ss);

    for (int i = 0; i < 20; i++) {
      nav.getDriver().switchTo().parentFrame();
    }

    nav.VerifyExistanceWithAssert(
        By.xpath("//*[@class='customization-att-value' and text()='SHORESY 99']"));
    nav.VerifyExistanceWithAssert(
        By.xpath("//*[@class='customization-att-value' and text()='SHORESY']"));
    nav.VerifyExistanceWithAssert(
        By.xpath("//*[@class='customization-att-value' and text()='99']"));

    // nav.Sleep(20);

    nav.cleanup();
  }
}
