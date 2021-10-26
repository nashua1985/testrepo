package com.dsg.testng.web.projects.dsg_prod.tests;

import com.dsg.framework.enums.Browser;
import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.testng.web.locators.DSGLocators;
import com.dsg.testng.web.projects.dsg_prod.resources.DSGMethods;
import com.dsg.testng.web.resources.WebNavigation;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CartTest extends WebDriverBaseTest {

  public static String sku = "19531296";
  public static String cookieKey = "2147483647~rv=21~id=83342c72c95c0bf3a0c0f1db2c81fc54";

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void cartTest(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "cartTest", runType);

    WebNavigation nav = getWebNavigation();

    DSGMethods dsg = new DSGMethods();

    nav.goToURL(urls.getURL("DSGProd"));
    nav.getDriver().manage().deleteAllCookies();
    // DriverManager.setCookie("akaas_AS_Exp_Desktop_1",
    // "2147483647~rv=21~id=83342c72c95c0bf3a0c0f1db2c81fc54", "dickssportinggoods.com");
    nav.setCookie("akaas_AS_Exp_Desktop_1", cookieKey, "dickssportinggoods.com");
    nav.getDriver().navigate().refresh();
    nav.MyWait(By.id("survey_tab"));

    dsg.checkForAndClosePromo();

    nav.EnterText(DSGLocators.PROD_SkuSearchBar, sku);
    nav.Click(DSGLocators.PROD_SkuSearchButton);

    if (nav.VerifyExistance(DSGLocators.AddToCart)) {
      nav.Print("Path 1");

      nav.Click(DSGLocators.AddToCart);
      nav.Click(DSGLocators.ViewCart);
      // verify item is in cart
      nav.VerifyExistanceWithAssert(By.id(sku));
      // update quantity
      nav.ClearText(By.xpath("//*[contains(@id, 'qty_')]"));
      nav.Sleep(2);
      nav.EnterText(By.xpath("//*[contains(@id, 'qty_')]"), "2");
      nav.Click(By.xpath("//*[@title='Checkout']"));
      // guest checkout
      nav.Click(By.xpath("//*[@title = 'Guest Checkout']"));
      nav.VerifyExistanceWithAssert(By.xpath("//*[contains(@id, '_value') and text() = '2']"));
      // go back to cart
      nav.Click(By.className("cart-count"));
      nav.VerifyExistanceWithAssert(By.id(sku));
    } else {
      nav.Print("Path 2");

      nav.Click(DSGLocators.PROD_AddToCart);
      nav.Click(DSGLocators.PROD_ViewCart);
      // verify the expected SKU is in the cart
      nav.VerifyTextWithAssertPartial(
          By.className("ProductDetailsImageInfoV1_detailsList__gylcg"), sku);
      nav.Click(DSGLocators.PROD_CloseDetails);
      nav.EnterTextWithBackSpace(DSGLocators.PROD_UpdateQuantity, "2");
      // nav.Click(By.className("ProductDetailsImageInfoV1_details__1qybL"));
      dsg.JSClick(DSGLocators.PROD_CheckoutButton);
      nav.ClickLoop(DSGLocators.PROD_GuestCheckoutButton);
      nav.ClickLoop(DSGLocators.PROD_ShoppingCartButton);
    }

    // remove item from cart
    nav.Click(By.className("ProductDetailsImageInfoV1_remove__2kPsA"));
    // verify empty cart and end test
    nav.VerifyExistanceWithAssert(
        By.xpath(
            "//*[@class = 'empty-cart' and contains(text(),  'There are no products in your cart. If you were logged in, simply sign in again to view your products.')]"));
    nav.VerifyExistanceWithAssert(By.className("empty-cart"));

    nav.cleanup();
  }
}
