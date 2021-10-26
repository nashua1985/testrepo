package com.dsg.testng.web.projects.dsg_prod.resources;

import com.dsg.framework.entities.SKU;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.testng.web.locators.DSGLocators;
import com.dsg.testng.web.resources.WebNavigation;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DSGMethods extends WebDriverBaseTest {

  // Navigation nav = new Navigation(false);
  WebNavigation nav = getWebNavigation();

  public void addToCart() {
    try {
      waitForAjaxCompletionFlag();
      nav.Click(DSGLocators.AddToCart);
      waitForAjaxCompletionFlag();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  // goddamn customer feedback popup(NOT WORKING)
  public void checkForAndCloseCustomerFeedback() {
    By closeButton = By.className("btn cancel-btn form-close-btn ng-binding ng-scope");
    // By.cssSelector("button.btn.cancel-btn.form-close-btn.ng-binding.ng-scope");
    nav.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    if (nav.VerifyExistance(closeButton)) {
      if (nav.VerifyClickable(closeButton)) {
        nav.Click(closeButton);
      }
    }
    nav.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  public void clickSubmit() {
    JavascriptExecutor jsExec;

    WebDriverWait wait = new WebDriverWait(nav.getDriver(), 30);

    jsExec = (JavascriptExecutor) nav.getDriver();

    try {
      WebElement element =
          wait.until(ExpectedConditions.presenceOfElementLocated(By.id("singleOrderSummary")));
      jsExec.executeScript("arguments[0].click();", element);
    } catch (Exception e) {
      // throw new ElementNotClickableException("clickSubmitOrderButton()", e);
      e.printStackTrace();
    }
  }

  public void JSClick(By object) {
    JavascriptExecutor jsExec;

    WebDriverWait wait = new WebDriverWait(nav.getDriver(), 30);

    jsExec = (JavascriptExecutor) nav.getDriver();

    try {
      WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(object));
      jsExec.executeScript("arguments[0].click();", element);
    } catch (Exception e) {
      // throw new ElementNotClickableException("clickSubmitOrderButton()", e);
      e.printStackTrace();
    }
  }

  public void continueFromDelivery() {
    WebDriverWait wait = new WebDriverWait(nav.getDriver(), 30);
    WebElement element =
        wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".-primary.cont-button.delivery-continue.-btn-large")));
    ((JavascriptExecutor) nav.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
    nav.Sleep(5);
    element.click();
  }

  public void checkForAndClosePromo() {
    nav.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    if (nav.VerifyExistance(By.className("close"))) {
      if (nav.VerifyClickable(By.className("close"))) {
        nav.Click(By.className("close"));
      }
    }
    nav.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  public static ExpectedCondition<Boolean> jsScriptResultIs(
      final String script, final List<String> expectedResults) {
    return new ExpectedCondition<Boolean>() {

      private String actualResult = "";

      @Override
      public Boolean apply(WebDriver driver) {

        try {
          Object value = ((JavascriptExecutor) driver).executeScript(script);
          if (value != null) {

            actualResult = value.toString();

            for (String expectedResult : expectedResults) {
              if (actualResult != null && (actualResult.equals(expectedResult))) {
                return true;
              }
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        return false;
      }

      @Override
      public String toString() {
        return String.format(
            "javascript to be \"%s\". Current javascript: \"%s\"",
            expectedResults.get(0), actualResult);
      }
    };
  }

  public static ExpectedCondition<Boolean> jsScriptResultIs(
      final String script, String expectedResults) {

    List<String> list = new ArrayList<String>();
    list.add(expectedResults);
    return jsScriptResultIs(script, list);
  }

  public void waitForAjaxCompletionFlag() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(nav.getDriver(), 10);
    try {
      wait.until(jsScriptResultIs("return DSGMain.UTILITIES.automationAjaxCompletionFlag", "true"));
    } catch (Exception e) {
      Thread.sleep(12000);
    }
    return;
  }

  /**
   * method to compare sku details pulled from sku file to a UL grabbed from the page
   *
   * <p>expecting By to be UL expecting sku details to be formatted as (category): (value)
   */
  public boolean checkCartDetails(SKU sku, By actual) {
    boolean results = false;

    // need to add the sku to the properties
    sku.getSkuProperties().put("SKU", sku.getSkuNumber());

    // assemble a hashmap of the results pulled from the page
    HashMap<String, String> pageSkuDetails = new HashMap<String, String>();
    WebElement ul = nav.getDriver().findElement(actual);
    List<WebElement> links = ul.findElements(By.tagName("li"));
    for (int i = 0; i < links.size(); i++) {
      String detail = links.get(i).getText();
      if (detail.contains(":")) {
        System.out.println(detail);
        String detailSplit[] = detail.split(":");
        pageSkuDetails.put(detailSplit[0].trim(), detailSplit[1].trim());
      } else {
        nav.Print("Promo line. Skipping");
      }
    }

    HashMap<String, String> skuProps = sku.getSkuProperties();

    if (skuProps.equals(pageSkuDetails))
    // if(pageSkuDetails.equals(pageSkuDetails))
    {
      nav.Print("Sku " + sku.getSkuNumber() + " Passed");
      results = true;
    } else {
      nav.Print("Sku " + sku.getSkuNumber() + " Failed");
      MapDifference<String, String> diff = Maps.difference(skuProps, pageSkuDetails);

      nav.Print("Failed on " + diff.entriesDiffering());
    }

    return results;
  }

  /**
   * This method retrieves the price from the PDP. There is an element on the page that is not
   * visible that contains the price. This method grabs that value then looks for it on the PDP to
   * validate that it appears.
   */
  public String getPricePDP() {
    By invisiblePrice = By.xpath("//*[@itemprop='price']");

    RemoteWebDriver driver = nav.getDriver();
    WebElement element = driver.findElement(invisiblePrice);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(invisiblePrice));
    String price = element.getAttribute("content");

    nav.Print(
        "Price matches display "
            + nav.VerifyExistance(By.xpath("//*[contains(., '" + price + "')]")));

    nav.Print(price);

    return price;
  }
}
