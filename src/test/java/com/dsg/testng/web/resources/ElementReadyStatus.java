package com.dsg.testng.web.resources;

import com.dsg.framework.loggers.TestNGLogMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementReadyStatus {
  public WebDriver driver;

  public ElementReadyStatus(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Checks in DOM if element/s is/are visible and enabled by locator and returns boolean
   *
   * @param locator By locator value
   * @param timeout times out when locator not found
   * @return boolean
   */
  protected boolean elementVisibleAndEnabled(By locator, int timeout) {
    try {
      if (new WebDriverWait(driver, timeout)
          .until(ExpectedConditions.visibilityOfElementLocated(locator))
          .isEnabled()) {
        TestNGLogMethods.logStep(" element is found: " + locator);
        return true;
      } else {
        TestNGLogMethods.logStep(locator + " is not visible and not enabled");
      }
    } catch (Exception e) {
      if (e.toString().contains("NullPointerException")) {
        TestNGLogMethods.logStep(
            locator + " is not visible and not enabled, catching NullPointerException");
      }
    }
    return false;
  }
  /**
   * Checks in DOM if element exists by locator and returns boolean
   *
   * @param locator By locator value
   * @param timeout times out when locator not found
   * @return boolean
   */
  protected boolean elementDoesNotExsist(By locator, int timeout) {
    WebElement element;
    try {
      element =
          new WebDriverWait(driver, timeout)
              .until(ExpectedConditions.presenceOfElementLocated(locator));
      if (element != null) {
        TestNGLogMethods.logStep(locator + " exsists");
        return true;
      }
    } catch (Exception e) {
      TestNGLogMethods.logStep(locator + " does not exsist");
      return false;
    }
    return false;
  }
}
