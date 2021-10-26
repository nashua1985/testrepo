package com.dsg.testng.web.resources;

import com.dsg.framework.loggers.TestNGLogMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommonElementMethods extends ElementReadyStatus {
  Actions actions = new Actions(driver);

  public CommonElementMethods(WebDriver driver) {
    super(driver);
  }
  /**
   * Enters String value by locator //* @param locator by Locator object //* @param timeout value
   * when time expires when no locator found //* @param string text value to be entered
   */
  public void enterValueWhenVisible(By locator, String inputValue, int timeout) throws IOException {
    try {
      TestNGLogMethods.logStep("checking if element is visible");
      if (elementVisibleAndEnabled(locator, timeout)) {
        driver.findElement(locator).sendKeys(inputValue);
      }
    } catch (Exception e) {
      if (e.toString().contains("NullPointerException")) {
        TestNGLogMethods.logStep(locator + " cannot be FOUND");
      }
      /// not finished, screenCaptureOnFailure
    }
  }

  /**
   * Sends Keys event used in Keyboard
   *
   * @param locator by Locator object
   * @param timeout value when time expires when no locator found
   * @param keys keyboard event
   */
  public void enterValueWhenVisible(By locator, Keys keys, int timeout) throws IOException {
    try {
      TestNGLogMethods.logStep("checking if element is visible");
      if (elementVisibleAndEnabled(locator, timeout)) {
        driver.findElement(locator).sendKeys(keys);
      }
    } catch (Exception e) {
      if (e.toString().contains("NullPointerException")) {
        TestNGLogMethods.logStep(locator + " cannot be FOUND");
      }
      /// not finished, screenCaptureOnFailure
    }
  }

  public void clearWhenVisible(By locator) throws IOException {
    try {
      TestNGLogMethods.logStep("checking if element is visible");
      if (elementVisibleAndEnabled(locator, 5)) {
        driver.findElement(locator).clear();
      }
    } catch (Exception e) {
      // screen
    }
  }

  /**
   * Clicks on element by locator when visible
   *
   * @param locator by Locator object
   * @param timeout value when time expires when no locator found
   */
  public void clickWhenVisible(By locator, int timeout) throws IOException {
    try {
      TestNGLogMethods.logStep(" searching for element: " + locator);
      if (elementVisibleAndEnabled(locator, timeout)) {
        driver.findElement(locator).click();
      }
    } catch (Exception e) {
      if (e.toString().contains("NullPointerException")) {
        System.out.println("NullPointer at enterValueWhenVisible");
      }
      TestNGLogMethods.logStep(locator + " cannot be FOUND");
      Assert.fail(e.getMessage());
    }
  }
  /**
   * Validates if locator is visible and enabled. Returns true/false
   *
   * @param locator by Locator object
   * @param timeout value when time expires when no locator found
   * @return boolean
   */
  public boolean isElementVisible(By locator, int timeout) {
    if (new WebDriverWait(driver, timeout)
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator))
        != null) {
      return true;
    } else {
      return false;
    }
  }

  public boolean elementShouldNotExsist(By locator, int timeout) {
    boolean elementExsists = elementDoesNotExsist(locator, timeout);
    if (!elementExsists) {
      return true;

    } else {
      Assert.fail("Element FOUND - " + locator.toString());
      return false;
    }
  }
  /*
  * Returns list of Sting value from list of Elements
  //* @param locator by Locator object
  //* @param timeout value when time expires when no locator found
  //* @return boolean
  //* @throws InterruptedException
  */
  public List<String> getTextFromListOfElements(By locator, int timeout)
      throws InterruptedException {
    List<WebElement> listElement =
        new WebDriverWait(driver, timeout)
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    List<String> listArray = new ArrayList<>();
    for (int i = 0; i < listElement.size(); i++) {
      listArray.add(listElement.get(i).getText());
      TestNGLogMethods.logStep(" Found texts in the list: " + listArray.get(i));
    }
    return listArray;
  }
  /**
   * Returns text from the locator
   *
   * @param locator by Locator object
   * @param timeout value when time expires when no locator found
   * @return string
   */
  public String getTextFromLocator(By locator, int timeout) {
    return new WebDriverWait(driver, timeout)
        .until(ExpectedConditions.visibilityOfElementLocated(locator))
        .getText();
  }
  /**
   * Hover on Parent menu and clicks on child menu //* @param Parent menu by Locator object
   * //* @param Child menu by Locator object //* @return timeout times out if elements not found
   */
  public void hoverParentMenuAndClicksChild(By parentLocaor, By childLocator, int timeout) {
    try {
      TestNGLogMethods.logStep(" searching for element: " + parentLocaor);
      if (elementVisibleAndEnabled(parentLocaor, timeout)) {
        WebElement mainMenu = driver.findElement(parentLocaor);
        actions.moveToElement(mainMenu).perform();
        this.clickWhenVisible(childLocator, 10);
      }
    } catch (Exception e) {
      TestNGLogMethods.logStep(parentLocaor + " cannot be FOUND");
      Assert.fail(e.getMessage());
    }
  }
}
