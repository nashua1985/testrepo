package com.dsg.testng.web.resources;


import com.dsg.framework.entities.SKU;
import com.dsg.framework.xml.XMLUrl;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.testng.web.locators.DSGLocators;
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

public class DSGWebMethods extends WebDriverBaseTest {

  // WebNavigation nav;
  // RemoteWebDriver driver;

  public void addToCart() {

    WebNavigation nav = getWebNavigation();

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

    WebNavigation nav = getWebNavigation();
    RemoteWebDriver driver = getRemoteWebDriver();

    By closeButton = By.className("btn cancel-btn form-close-btn ng-binding ng-scope");
    // By.cssSelector("button.btn.cancel-btn.form-close-btn.ng-binding.ng-scope");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    if (nav.VerifyExistance(closeButton)) {
      if (nav.VerifyClickable(closeButton)) {
        nav.Click(closeButton);
      }
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  public void clickSubmit() {

    RemoteWebDriver driver = getRemoteWebDriver();

    JavascriptExecutor jsExec;

    WebDriverWait wait = new WebDriverWait(driver, 30);

    jsExec = driver;

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

    RemoteWebDriver driver = getRemoteWebDriver();

    JavascriptExecutor jsExec;

    WebDriverWait wait = new WebDriverWait(driver, 30);

    jsExec = (JavascriptExecutor) driver;

    try {
      WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(object));
      jsExec.executeScript("arguments[0].click();", element);
    } catch (Exception e) {
      // throw new ElementNotClickableException("clickSubmitOrderButton()", e);
      e.printStackTrace();
    }
  }

  public void continueFromDelivery() {

    WebNavigation nav = getWebNavigation();
    RemoteWebDriver driver = getRemoteWebDriver();

    WebDriverWait wait = new WebDriverWait(driver, 30);
    WebElement element =
        wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".-primary.cont-button.delivery-continue.-btn-large")));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    nav.Sleep(5);
    element.click();
  }

  public void checkForAndClosePromo() {

    WebNavigation nav = getWebNavigation();
    RemoteWebDriver driver = getRemoteWebDriver();

    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    if (nav.VerifyExistance(By.className("close"))) {
      if (nav.VerifyClickable(By.className("close"))) {
        nav.Click(By.className("close"));
      }
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    List<String> list = new ArrayList<>();
    list.add(expectedResults);
    return jsScriptResultIs(script, list);
  }

  public void waitForAjaxCompletionFlag() throws InterruptedException {

    RemoteWebDriver driver = getRemoteWebDriver();

    WebDriverWait wait = new WebDriverWait(driver, 10);
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

    WebNavigation nav = getWebNavigation();
    RemoteWebDriver driver = getRemoteWebDriver();

    boolean results = false;

    // need to add the sku to the properties
    sku.getSkuProperties().put("SKU", sku.getSkuNumber());

    // assemble a hashmap of the results pulled from the page
    HashMap<String, String> pageSkuDetails = new HashMap<String, String>();
    WebElement ul = driver.findElement(actual);
    List<WebElement> links = ul.findElements(By.tagName("li"));
    for (WebElement link : links) {
      String detail = link.getText();
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

    WebNavigation nav = getWebNavigation();
    RemoteWebDriver driver = getRemoteWebDriver();

    By invisiblePrice = By.xpath("//*[@itemprop='price']");

    // RemoteWebDriver driver = DriverManager.getDriver();
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

  /** Leave swimlane blank "" to not set swimlane */
  public void NavigateToDSGEnterSku_PROD(WebNavigation nav, String Swimlane, String Sku)
      throws Exception {

    // nav = getWebNavigation();
    RemoteWebDriver driver = getRemoteWebDriver();

    XMLUrl url = new XMLUrl(XMLUrl.URLS_PATH);

    nav.goToURL(url.getURL("DSGProd"));

    if (!Swimlane.equals("")) {
      // Set Swimlane
      driver.manage().deleteAllCookies();
      // DriverManager.setCookie("akaas_AS_Exp_Desktop_1", Swimlane,
      // "dickssportinggoods.com");
      nav.setCookie("akaas_AS_EXP_DSG", Swimlane, "dickssportinggoods.com");
      driver.navigate().refresh();
    }

    nav.MyWait(By.id("survey_tab"));

    checkForAndClosePromo();

    // nav.EnterText(DSGLocators.PROD_SkuSearchBar, sku);
    nav.EnterText(DSGLocators.PROD_SkuSearchBar, Sku);
    nav.Click(DSGLocators.PROD_SkuSearchButton);

    checkForAndClosePromo();
  }
}
