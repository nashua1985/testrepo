package com.dsg.testng.web.projects.dsg_prod.tests;

import com.dsg.framework.entities.SKU;
import com.dsg.framework.enums.Browser;
import com.dsg.framework.enums.RunType;
import com.dsg.framework.xml.XMLSku;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.testng.web.locators.DSGLocators;
import com.dsg.testng.web.projects.dsg_prod.resources.DSGMethods;
import com.dsg.testng.web.projects.dsg_prod.resources.DSGShortcuts;
import com.dsg.testng.web.resources.WebNavigation;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CartValidation extends WebDriverBaseTest {

  // public static String sku = "19531296";
  public static String sku = "20667858";
  // public static String cookieKey = "2147483647~rv=21~id=83342c72c95c0bf3a0c0f1db2c81fc54";
  public static String cookieKey = "2147483647~rv=41~id=52b7e724d760f9446e5279b4d583212b";

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void cartValidationTest(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "cartValidationTest", runType);

    WebNavigation nav = getWebNavigation();

    // screenshots on/off (true/false)
    boolean ss = false;

    int experience = 0;

    // Navigation nav = new Navigation(true);

    DSGMethods dsg = new DSGMethods();
    DSGShortcuts shortcut = new DSGShortcuts();

    ArrayList<SKU> skus = XMLSku.getSKUListWithProperties("./Tests/CartValidationSkus.xml");

    for (int i = 0; i < skus.size(); i++) {
      System.out.println("sku " + i + ": " + skus.get(i).getSkuNumber());
    }

    // System.out.println("skus: " + skus.toString());

    for (int numSkus = 0; numSkus < skus.size(); numSkus++) {
      // shortcut.NavigateToDSGEnterSku_PROD(nav, cookieKey, skus.get(numSkus).getSkuNumber());
      shortcut.NavigateToDSGEnterSku_PROD(nav, "", skus.get(numSkus).getSkuNumber());
      nav.TakeScreenshot("01 Sku PDP", ss);

      // skip sku if it wasnt found. shorten time out to speed up script
      nav.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      if (!nav.VerifyExistance(By.xpath("//*[contains(text(), 'We could not find a match')]"))
          && !nav.VerifyExistance(By.xpath("//*[contains(text(), 'WE COULD NOT FIND A MATCH')]"))) {
        nav.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Grab price
        String price = dsg.getPricePDP();

        ArrayList<String> properties = new ArrayList<String>();

        for (String key : skus.get(numSkus).getSkuProperties().keySet()) {
          if (key.toUpperCase().contains("COLOR")) {
            properties.add("COLOR" + skus.get(numSkus).getSkuProperties().get(key));
          } else {
            properties.add(skus.get(numSkus).getSkuProperties().get(key));
          }
        }
        for (int x = 0; x < properties.size(); x++) {
          // nav.Click(By.xpath("//*[contains(text(), '"+ properties.get(x) + "') and
          // @class='button-attribute button-text-attr ng-tns-c14-1 ng-star-inserted']"));
          if (properties.get(x).contains("COLOR")) {
            // remove COLOR from beginning of property
            nav.Click(By.xpath("//*[@alt='" + properties.get(x).substring(5) + "']"));
          } else {
            nav.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            if (experience != 1
                && nav.VerifyExistance(
                    By.xpath(
                        "//*[text()=' "
                            + properties.get(x)
                            + " ' and @class='button-attribute button-text-attr ng-tns-c14-1 ng-star-inserted']"))) {
              nav.Click(
                  By.xpath(
                      "//*[text()=' "
                          + properties.get(x)
                          + " ' and @class='button-attribute button-text-attr ng-tns-c14-1 ng-star-inserted']"));
            } else {
              experience = 1;
              nav.Click(
                  By.xpath(
                      "//*[text()='" + properties.get(x) + "' and @class='ng-star-inserted']"));
            }
            nav.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // nav.Click(By.xpath("//*[text()='"+ properties.get(x) + "' and
            // @class='button-attribute button-text-attr ng-tns-c14-1 ng-star-inserted']"));
            // nav.Click(By.xpath("//*[contains(text(), '"+ properties.get(x) + "') and
            // contains(@id, 'block-swatch')]"));
          }
        }
        nav.TakeScreenshot("02 Selected attributes", ss);

        dsg.checkForAndCloseCustomerFeedback();

        nav.Click(DSGLocators.PROD_AddToCart);
        if (experience != 1) {
          nav.Click(DSGLocators.PROD_ViewCart);
        } else {
          nav.Click(DSGLocators.PROD_GoToCart);
        }

        nav.TakeScreenshot("03 Attributes in cart", ss);

        nav.Print("prodDetails: " + skus.get(numSkus).toString());

        // jj - not sure what this is doing - coming back false
        // nav.Print(dsg.checkCartDetails(skus.get(numSkus),
        // By.className("ProductDetailsImageInfoV1_detailsList__gylcg")));
        nav.Print(dsg.checkCartDetails(skus.get(numSkus), By.className("skuDetail")));

        // check that pdp price matches cart price
        nav.Print(
            "PDP and cart price match: "
                + nav.VerifyExistance(By.xpath("//*[contains(., '" + price + "')]")));

        // verify that ship to me is checked
        // jj - changed the id but it is coming up false when true
        nav.Print(
            "Is ship to me checked: "
                + nav.hasAttribute(By.xpath("//*[contains(@id, 'mat-radio-2')]"), "checked"));

        // jj-is close details not used anymore?
        // nav.Click(DSGLocators.PROD_CloseDetails);

        dsg.JSClick(DSGLocators.PROD_CheckoutButton);
        // nav.ClickLoop(DSGLocators.PROD_GuestCheckoutButton);
        nav.ClickLoop(DSGLocators.PROD_ShoppingCartButton);

        // remove item from cart
        // nav.Click(By.className("ProductDetailsImageInfoV1_remove__2kPsA"));
        // nav.Click(By.className("material-icons.position-absolute.closeIcon.ng-star-inserted"));
        nav.Click(
            By.xpath(
                "//*[@class = 'material-icons position-absolute closeIcon ng-star-inserted']"));
        // verify empty cart and end test
        // nav.VerifyExistanceWithAssert(By.xpath("//*[@class = 'empty-cart' and contains(text(),
        // 'There are no products in your cart. If you were logged in, simply sign in again to view
        // your products.')]"));
        nav.VerifyExistanceWithAssert(
            By.xpath(
                "//*[@class = 'empty-cart-message mb-4 py-2' and contains(text(),  'There are no products in your')]"));
        // nav.VerifyExistanceWithAssert(By.className("empty-cart"));
      } else {
        nav.Print("Sku " + skus.get(numSkus).getSkuNumber() + " not found! Trying next sku.");
      }
    }

    nav.cleanup();
  }
}
