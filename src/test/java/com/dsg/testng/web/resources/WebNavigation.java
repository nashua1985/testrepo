package com.dsg.testng.web.resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class WebNavigation {

  private RemoteWebDriver driver;

  public WebNavigation(RemoteWebDriver driver) {
    this.driver = driver;
  }

  public RemoteWebDriver getDriver() {
    return driver;
  }

  public void MyWait(By object) {

    // WebElement element = driver.findElement(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    wait.until(ExpectedConditions.elementToBeClickable(object));
  }

  public void Click(By object) {

    WebDriverWait wait = new WebDriverWait(driver, 30);

    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(object));
    wait.until(ExpectedConditions.elementToBeClickable(object));
    WebHighlightElement.highlightPermanent(element);
    element.click();
  }

  public void ClickIndex(By object, int index) {

    WebDriverWait wait = new WebDriverWait(driver, 30);

    // WebElement element = driver.findElement(object);

    List<WebElement> elements = driver.findElements(object);

    WebElement element = elements.get(index);

    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    wait.until(ExpectedConditions.elementToBeClickable(object));
    WebHighlightElement.highlightPermanent(element);
    element.click();
  }

  public void ClickiFrameIgnore(By object) {
    boolean framesLeft = true;

    int frame = 0;

    for (int i = 0; i < 20; i++) {
      driver.switchTo().parentFrame();
      // DriverManager.getDriver().switchTo().parentFrame();
    }

    while (framesLeft) {
      try {
        driver.switchTo().frame(frame);

        Click(object);

        break;
      } catch (NoSuchFrameException e) {
        framesLeft = false;
        System.out.println("End of frames reached. Click unsuccessful.");
      } catch (Exception e) {
        frame++;
        System.out.println("Click unsuccessful. Trying another frame.");
      }
    }
  }

  public void switchFrame(String text) {

    // Switch to different iFrame to view locators
    driver.switchTo().frame(text);
  }

  public void ClickElement(WebElement element) {
    WebHighlightElement.highlightPermanent(element);
    element.click();
  }

  public void ClickLoop(By object) {

    boolean wasSuccessful = false;

    Exception error = null;

    for (int i = 0; i < 10; i++) {
      try {
        WebElement element = driver.findElement(object);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(object));
        wait.until(ExpectedConditions.elementToBeClickable(object));
        element.click();
        wasSuccessful = true;
        break;
      } catch (Exception e) {
        System.out.println("Exception while trying to click element " + object);
        error = e;
      }

      System.out.println("Trying again.");
    }

    if (!wasSuccessful) {
      System.out.println("Click Unsuccessful");
      error.printStackTrace();
    } else {
      System.out.println("Click Successful.");
    }
  }

  public void ClickLoopScroll(By object) {
    try {

      Robot r = new Robot();

      boolean wasSuccessful = false;

      Exception error = null;

      for (int i = 0; i < 30; i++) {
        try {
          WebElement element = driver.findElement(object);
          WebDriverWait wait = new WebDriverWait(driver, 1);
          wait.until(ExpectedConditions.presenceOfElementLocated(object));
          wait.until(ExpectedConditions.elementToBeClickable(object));
          WebHighlightElement.highlightPermanent(element);
          element.click();
          wasSuccessful = true;
          break;
        } catch (Exception e) {

          System.out.println("Exception while trying to click element " + object);
          error = e;
        }

        System.out.println("Paging down and trying again.");
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        // r.mouseWheel(2);
      }

      if (!wasSuccessful) {
        System.out.println("Click Unsuccessful");
        error.printStackTrace();
      } else {
        System.out.println("Click Successful.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void Hover(By object) {

    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 30);

    // WebElement element = driver.findElement(object);

    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(object));
    wait.until(ExpectedConditions.elementToBeClickable(object));
    WebHighlightElement.highlightPermanent(element);
    action.moveToElement(element).build().perform();
  }

  public void EnterText(By object, String text) {

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    WebElement element = driver.findElement(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    element.sendKeys(text);
  }

  public void EnterTextiFrameIgnore(By object, String text) {
    boolean framesLeft = true;

    int frame = 0;

    for (int i = 0; i < 20; i++) {
      driver.switchTo().parentFrame();
    }

    while (framesLeft) {
      try {
        driver.switchTo().frame(frame);

        EnterText(object, text);

        break;
      } catch (NoSuchFrameException e) {
        framesLeft = false;
        System.out.println("End of frames reached. Text entry unsuccessful.");
        e.printStackTrace();
      } catch (Exception e) {
        frame++;
        System.out.println("Text entry unsuccessful. Trying another frame.");
      }
    }
  }

  public void EnterTextWithBackSpace(By object, String text) {

    WebElement element = driver.findElement(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    element.sendKeys(Keys.BACK_SPACE);
    element.sendKeys(text);
  }

  public void EnterTextLoop(By object, String text) {

    boolean wasSuccessful = false;

    Exception error = null;

    for (int i = 0; i < 10; i++) {
      try {

        WebElement element = driver.findElement(object);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(object));
        element.sendKeys(text);

        wasSuccessful = true;
        break;
      } catch (Exception e) {
        System.out.println("Exception while trying to enter text in element " + object);
        error = e;
      }

      System.out.println("Trying again.");
    }

    if (!wasSuccessful) {
      System.out.println("Text Entry Unsuccessful");
      error.printStackTrace();
    } else {
      System.out.println("Text Entry Successful.");
    }
  }

  public void EnterTextElement(WebElement element, String text) {
    // driver = DriverManager.getDriver();
    // WebElement element = driver.findElement(object);
    // WebDriverWait wait = new WebDriverWait(driver, 30);
    // wait.until(ExpectedConditions.presenceOfElementLocated(element));
    element.sendKeys(text);
  }

  public void ClearText(By object) {

    WebElement element = driver.findElement(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    element.clear();
  }

  public void EnterTextWithEnter(By object, String text) {

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    WebElement element = driver.findElement(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    element.sendKeys(text);
    element.sendKeys(Keys.ENTER);
  }

  public void EnterTextWithTab(By object, String text) {

    WebElement element = driver.findElement(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    element.sendKeys(text);
    element.sendKeys(Keys.TAB);
  }

  public void SelectDropDown(By ddName, String ddOption) {

    WebElement dropdown = driver.findElement(ddName);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(ddName));
    Select select = new Select(dropdown);
    select.selectByValue(ddOption);
  }

  public void SelectDropDownLoop(By ddName, String ddOption) {
    boolean wasSuccessful = false;

    Exception error = null;

    for (int i = 0; i < 10; i++) {
      try {

        WebElement dropdown = driver.findElement(ddName);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(ddName));
        Select select = new Select(dropdown);

        select.selectByValue(ddOption);

        wasSuccessful = true;
        break;
      } catch (Exception e) {
        System.out.println(
            "Exception while trying to select value " + ddOption + " in dropdown " + ddName);
        error = e;
      }

      System.out.println("Trying again.");
    }

    if (!wasSuccessful) {
      System.out.println("Dropdown selection Unsuccessful");
      error.printStackTrace();
    } else {
      System.out.println("Dropdown selection Successful.");
    }
  }

  public boolean VerifyExistance(By object) {

    boolean doesExist = false;
    try {
      @SuppressWarnings("unused")
      WebElement element = driver.findElement(object);

      doesExist = true;
    }
    // if the element isnt found catch the exception so executing can continue
    catch (NoSuchElementException e) {
      return doesExist;
    }

    return doesExist;
  }

  public boolean VerifyExistanceWithWait(By object) {

    boolean doesExist = false;
    try {

      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(object));

      doesExist = true;
    }
    // if the element isnt found catch the exception so executing can continue
    catch (NoSuchElementException e) {
      return doesExist;
    }

    return doesExist;
  }

  public boolean VerifyExistanceWithAssertiFrame(By object) {

    boolean framesLeft = true;

    boolean doesExist = false;

    int frame = 0;

    for (int i = 0; i < 20; i++) {
      driver.switchTo().parentFrame();
    }

    while (framesLeft) {
      try {
        driver.switchTo().frame(frame);

        @SuppressWarnings("unused")
        WebElement element = driver.findElement(object);

        doesExist = true;
      } catch (NoSuchFrameException e) {
        framesLeft = false;
        System.out.println("End of frames reached. Verify unsuccessful.");
      } catch (Exception e) {
        frame++;
        System.out.println("Verify unsuccessful. Trying another frame.");
      }
    }

    return doesExist;
  }

  public boolean VerifyExistanceWithAssert(By object) {

    boolean doesExist = false;
    try {
      @SuppressWarnings("unused")
      WebElement element = driver.findElement(object);

      doesExist = true;
    }
    // if the element isnt found catch the exception so executing can continue
    catch (NoSuchElementException e) {
      fail(object + " does not exist!");
      return doesExist;
    }

    return doesExist;
  }

  public boolean VerifyTextWithAssertPartial(By object, String verifyText) {

    boolean doesMatch = false;

    WebElement element = driver.findElement(object);
    if (element.getAttribute("innerText").contains(verifyText)) {
      doesMatch = true;
      assertTrue(doesMatch);
    } else {
      fail(object + " does not contain text " + verifyText);
    }

    return doesMatch;
  }

  public boolean findInnerTextOnPage(String findText) {
    List<WebElement> el = driver.findElements(By.cssSelector("*"));
    List<String> text = new ArrayList<>();

    // el.removeAll(c)

    for (WebElement e : el) {
      /*
       * if (e.getAttribute("innerText").contains(findText)) { //
       * System.out.println(e.getAttribute("innerText")); return true; }
       */
      if (e != null) {
        if (e.getAttribute("innerText") != null) {
          if (!e.getAttribute("innerText").equals("")) {
            if (e.getAttribute("innerText").contains("COMPARE")
                || e.getAttribute("innerText").contains("TOP BRANDS")) {
              break;
            }
            if (!text.contains(e.getAttribute("innerText"))) {

              Print(e.getAttribute("innerText"));
              text.add(e.getAttribute("innerText"));
            }
          }
        }
      }

      // System.out.println(e.getAttribute("innerText"));
    }

    if (text.contains(findText)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean VerifyClickable(By object) {

    boolean doesExist = false;
    try {
      @SuppressWarnings("unused")
      WebElement element = driver.findElement(object);
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.elementToBeClickable(object));
      doesExist = true;
    }
    // if the element isnt clickable catch the exception so executing can continue
    catch (TimeoutException e) {
      return doesExist;
    }

    return doesExist;
  }

  public boolean VerifyNonExistance(By object) {

    boolean doesNotExist = true;
    try {
      @SuppressWarnings("unused")
      WebElement element = driver.findElement(object);
      doesNotExist = false;
    }
    // if the element isnt found catch the exception so executing can continue
    catch (NoSuchElementException e) {
      return doesNotExist;
    }

    return doesNotExist;
  }

  public boolean VerifyNonExistanceWithAssert(By object) {

    boolean doesNotExist = true;
    try {
      @SuppressWarnings("unused")
      WebElement element = driver.findElement(object);
      doesNotExist = false;
      fail(object + " does exist!");
    }
    // if the element isnt found catch the exception so executing can continue
    catch (NoSuchElementException e) {
      return doesNotExist;
    }

    return doesNotExist;
  }

  public String GetTextValue(By object) {
    WebElement element = driver.findElement(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    return element.getText();
  }

  public String GetTextValueIndex(By object, int index) {
    List<WebElement> element = driver.findElements(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    return element.get(index).getText();
  }

  public boolean hasAttribute(By object, String attribute) {
    boolean result = false;

    WebElement element = driver.findElement(object);
    String value = element.getAttribute(attribute);
    if (value != null) {
      result = true;
    }

    return result;
  }

  /*
   * public void TakeScreenshotFromProperties(String name) { if
   * (screenShotsEnabled) { try { driver = DriverManager.getDriver(); File
   * screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   * FileUtils.copyFile(screenshotFile, new File("./ScreenShots/" + name +
   * ".png")); System.out.println("Screenshot: " + "./ScreenShots/" + name +
   * ".png"); } catch (Exception e) { ErrorLog.printErrors(e.toString());
   * e.printStackTrace(); } }
   *
   * }
   */

  public void TakeScreenshot(String name, boolean enabled) {

    if (enabled) {
      try {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("./ScreenShots/" + name + ".png"));
        System.out.println("Screenshot: " + "./ScreenShots/" + name + ".png");
      } catch (Exception e) {
        // ErrorLog.printErrors(e.toString());
        e.printStackTrace();
      }
    }
  }

  /** default path = screenshot folder */
  public void TakeScreenshot(String name, String path, boolean enabled) {
    if (path.equals("")) {
      path = "./ScreenShots/";
    }

    if (enabled) {
      try {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(path + name + ".png"));
        System.out.println("Screenshot: " + path + name + ".png");
      } catch (Exception e) {
        // ErrorLog.printErrors(e.toString());
        e.printStackTrace();
      }
    }
  }

  public void goToURL(String URL) {
    // driver.manage().window().maximize();
    // System.out.println(driver.getSessionId());
    driver.get(URL);
  }

  public int generateRandomNumber(int numDigits) {
    String buildMultiplyer = "1";
    for (int i = 0; i < numDigits; i++) {
      buildMultiplyer = buildMultiplyer + 0;
    }
    int multiplyer = Integer.parseInt(buildMultiplyer);
    double randomNum = Math.random() * multiplyer;
    int returnNum = (int) randomNum;
    System.out.println("Random number: " + returnNum);

    return returnNum;
  }

  /**
   * This method reads a file with the expectation that each item in the file the user wants to read
   * is on a different line
   *
   * @param filePath - path to the file to be read
   */
  public String[] readFromFileSequnetial(String filePath) {
    ArrayList<String> ids = new ArrayList<>();

    System.out.println("Retreiving IDs...");

    try {

      BufferedReader br = new BufferedReader(new FileReader(filePath));
      String line = br.readLine();
      while (line != null) {
        if (line.lastIndexOf(',') != -1) {
          line = line.substring(0, line.length() - 1);
        }
        ids.add(line);
        line = br.readLine();
      }

      br.close();

    } catch (IOException e) {

      e.printStackTrace();
    }

    String[] idArray = new String[ids.size()];

    System.out.println("IDs:");

    for (int i = 0; i < ids.size(); i++) {
      System.out.println(ids.get(i));
      idArray[i] = ids.get(i);
    }
    return idArray;
  }

  public void Sleep(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public ArrayList<String[]> readFromFileWithSeperator(String filePath, String seperator) {
    ArrayList<String[]> lines = new ArrayList<>();

    System.out.println("Retreiving Data...");

    try {

      BufferedReader br = new BufferedReader(new FileReader(filePath));
      String line = br.readLine();
      while (line != null) {
        String[] temp = line.split(seperator);
        lines.add(temp);
        line = br.readLine();
      }

      br.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return lines;
  }

  public void setCookie(String name, String value, String domain) {
    Cookie ck = new Cookie.Builder(name, value).domain(domain).build();
    driver.manage().addCookie(ck);
  }

  public void Print(Object obj) {
    System.out.println(obj);
  }

  public void cleanup() {
    System.out.println("Cleaning up...");
    /*
     * driver.close(); driver.quit();
     */
    driver.close();
    driver.quit();
  }
}
