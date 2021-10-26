package com.dsg.testng.web.resources;

import com.dsg.testng.basetest.WebDriverBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebHighlightElement {

  public static void highlightPermanent(WebElement element) {
    // WebElement element_node = DriverManager.getDriver().findElement(locator);
    JavascriptExecutor jse = WebDriverBaseTest.getRemoteWebDriver();
    jse.executeScript("arguments[0].style.border='3px solid green'", element);
  }

  public static void highlightQuick(WebElement element) {
    // WebElement element_node = DriverManager.getDriver().findElement(locator);
    JavascriptExecutor jse = WebDriverBaseTest.getRemoteWebDriver();
    // jse.executeScript("arguments[0].style.border='3px solid red'", element);
    // System.out.println("JS: " + highlight);
    String lastBorder = (String) jse.executeScript(highlight, element);
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // System.out.println("JS: " + unhighlight);
    jse.executeScript(unhighlight, element, lastBorder);
    // jse.executeScript("arguments[0].style.border='null'", element);
  }

  public static void HighlightAllElements() {
    List<WebElement> el = WebDriverBaseTest.getRemoteWebDriver().findElements(By.cssSelector("*"));

    for (WebElement e : el) {
      highlightQuick(e);
    }
  }

  public static void PrintAllElements() {
    List<WebElement> el = WebDriverBaseTest.getRemoteWebDriver().findElements(By.cssSelector("*"));

    for (WebElement e : el) {
      if (!e.getAttribute("id").equals("")) System.out.println(e.getAttribute("id"));
    }
  }

  public static void PrintAllElementsText() {
    List<WebElement> el = WebDriverBaseTest.getRemoteWebDriver().findElements(By.cssSelector("*"));

    for (WebElement e : el) {
      if (!e.getAttribute("innerText").equals("")) System.out.println(e.getAttribute("innerText"));
    }
  }

  public static String highlight =
      "var elem = arguments[0];"
          + "var style = document.defaultView.getComputedStyle(elem);"
          + "  var border = style.getPropertyValue('border-top-width')"
          + "    + ' ' + style.getPropertyValue('border-top-style')"
          + "    + ' ' + style.getPropertyValue('border-top-color')"
          + "    + ';' + style.getPropertyValue('border-right-width')"
          + "    + ' ' + style.getPropertyValue('border-right-style')"
          + "    + ' ' + style.getPropertyValue('border-right-color')"
          + "    + ';' + style.getPropertyValue('border-bottom-width')"
          + "    + ' ' + style.getPropertyValue('border-bottom-style')"
          + "    + ' ' + style.getPropertyValue('border-bottom-color')"
          + "    + ';' + style.getPropertyValue('border-left-width')"
          + "    + ' ' + style.getPropertyValue('border-left-style')"
          + "    + ' ' + style.getPropertyValue('border-left-color');"
          + "elem.style.border = '2px solid red';\r\n"
          + "return border;";

  public static String unhighlight =
      "var elem = arguments[0];"
          + "var borders = arguments[1].split(';');"
          + "elem.style.borderTop = borders[0];"
          + "elem.style.borderRight = borders[1];"
          + "elem.style.borderBottom = borders[2];"
          + "elem.style.borderLeft = borders[3];";
}
