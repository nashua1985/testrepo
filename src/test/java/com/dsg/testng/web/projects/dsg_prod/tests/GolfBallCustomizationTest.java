package com.dsg.testng.web.projects.dsg_prod.tests;

import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.framework.entities.SKU;
import com.dsg.framework.enums.Browser;
import com.dsg.framework.xml.XMLSku;
import com.dsg.testng.web.locators.DSGLocators;
import com.dsg.testng.web.projects.dsg_prod.resources.DSGMethods;
import com.dsg.testng.web.projects.dsg_prod.resources.DSGShortcuts;
import com.dsg.testng.web.resources.WebNavigation;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GolfBallCustomizationTest extends WebDriverBaseTest {

  public static String cookieKey = "2147483647~rv=21~id=83342c72c95c0bf3a0c0f1db2c81fc54";

  // final static Logger logger = Logger.getLogger(com.dsg.prod.GolfBallCustomizationTest.class);

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void golfTest(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "golfTest", runType);

    WebNavigation nav = getWebNavigation();
    // logger.debug("Starting test");

    boolean ss = false;

    DSGMethods dsg = new DSGMethods();
    DSGShortcuts shortcut = new DSGShortcuts();

    ArrayList<SKU> skus = XMLSku.getSKUListWithProperties("./Tests/GolfCustomizationSkus.xml");

    // REPO TEST
    /*nav.Click(By.xpath("//*[@aria-label='Green']"));
    nav.EnterText(By.id("textLine1"), "Test1");
    nav.EnterText(By.id("textLine2"), "Test2");
    nav.EnterText(By.id("textLine3"), "Test3");

    nav.TakeScreenshot("02 Selected attributes", ss);

    nav.Click(DSGLocators.PROD_AddToCart);
    nav.Click(DSGLocators.PROD_ViewCart);*/

    for (int numSkus = 0; numSkus < skus.size(); numSkus++) {
      // logger.debug("Go to DSG");

      shortcut.NavigateToDSGEnterSku_PROD(nav, cookieKey, skus.get(numSkus).getSkuNumber());
      nav.TakeScreenshot("01 Sku PDP", ss);

      ArrayList<String> properties = new ArrayList<String>();

      for (String key : skus.get(numSkus).getSkuProperties().keySet()) {
        properties.add(skus.get(numSkus).getSkuProperties().get(key));
      }

      nav.Click(
          By.xpath(
              "//*[@aria-label='" + skus.get(numSkus).getSkuProperties().get("TextColor") + "']"));
      nav.EnterText(By.id("textLine1"), skus.get(numSkus).getSkuProperties().get("Line1"));
      nav.EnterText(By.id("textLine2"), skus.get(numSkus).getSkuProperties().get("Line2"));
      nav.EnterText(By.id("textLine3"), skus.get(numSkus).getSkuProperties().get("Line3"));

      nav.TakeScreenshot("02 Selected attributes", ss);

      nav.Click(DSGLocators.PROD_AddToCart);
      nav.Click(DSGLocators.PROD_ViewCart);

      nav.TakeScreenshot("03 Attributes in cart", ss);

      // replace TextColor key with Text Color to make validating easier
      skus.get(numSkus)
          .getSkuProperties()
          .put("Text Color", skus.get(numSkus).getSkuProperties().get("TextColor"));
      skus.get(numSkus).getSkuProperties().remove("TextColor");

      // logger.debug("Checking sku...");

      if (dsg.checkCartDetails(
          skus.get(numSkus), By.className("ProductDetailsImageInfoV1_detailsList__gylcg"))) {
        // logger.debug("Sku " + skus.get(numSkus).getSkuNumber() + " Passed");
      } else {
        // logger.debug("Sku " + skus.get(numSkus).getSkuNumber() + " Failed");
      }

      nav.Click(DSGLocators.PROD_CloseDetails);

      dsg.JSClick(DSGLocators.PROD_CheckoutButton);
      nav.ClickLoop(DSGLocators.PROD_GuestCheckoutButton);
      nav.ClickLoop(DSGLocators.PROD_ShoppingCartButton);

      // remove item from cart
      nav.Click(By.className("ProductDetailsImageInfoV1_remove__2kPsA"));
      // verify empty cart and end test
      // nav.VerifyExistanceWithAssert(By.xpath("//*[@class = 'empty-cart' and contains(text(),
      // 'There are no products in your cart. If you were logged in, simply sign in again to view
      // your products.')]"));
      nav.VerifyExistanceWithAssert(
          By.xpath(
              "//*[@class = 'empty-cart' and contains(text(),  'There are no products in your')]"));
      // nav.VerifyExistanceWithAssert(By.className("empty-cart"));
    }

    nav.cleanup();

    // logger.debug("Ending test");
  }
}
