package com.dsg.testng.android.resources;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class AndroidMobileActions {

  private AndroidDriver driver;

  // private WebDriver driver;

  public AndroidMobileActions(AndroidDriver driver) {
    this.driver = driver;
  }

  // Tap to an element for 250 milliseconds
  public void tapByElement(By object) {

    // driver = DriverManager.getAndroidDriver();

    WebDriverWait wait = new WebDriverWait(driver, 30);
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(object));
    wait.until(ExpectedConditions.elementToBeClickable(object));

    new TouchAction(driver)
        .tap(tapOptions().withElement(element(element)))
        .waitAction(waitOptions(Duration.ofMillis(250)))
        .perform();
  }

  // Tap by coordinates
  public void tapByCoordinates(int x, int y) {
    // driver = DriverManager.getAndroidDriver();
    new TouchAction(driver)
        .tap(point(x, y))
        .waitAction(waitOptions(Duration.ofMillis(250)))
        .perform();
  }

  // Press by element
  public void pressByElement(By object, long seconds) {
    // driver = DriverManager.getAndroidDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(object));
    wait.until(ExpectedConditions.elementToBeClickable(object));

    new TouchAction(driver)
        .press(element(element))
        .waitAction(waitOptions(ofSeconds(seconds)))
        .release()
        .perform();
  }

  // Press by coordinates
  public void pressByCoordinates(int x, int y, long seconds) {
    // driver = DriverManager.getAndroidDriver();
    new TouchAction(driver)
        .press(point(x, y))
        .waitAction(waitOptions(ofSeconds(seconds)))
        .release()
        .perform();
  }

  // Horizontal Swipe by percentages
  public void horizontalSwipeByPercentage(
      double startPercentage, double endPercentage, double anchorPercentage) {
    // driver = DriverManager.getAndroidDriver();
    Dimension size = driver.manage().window().getSize();
    int anchor = (int) (size.height * anchorPercentage);
    int startPoint = (int) (size.width * startPercentage);
    int endPoint = (int) (size.width * endPercentage);

    new TouchAction(driver)
        .press(point(startPoint, anchor))
        .waitAction(waitOptions(ofMillis(1000)))
        .moveTo(point(endPoint, anchor))
        .release()
        .perform();
  }

  // Vertical Swipe by percentages
  public void verticalSwipeByPercentages(
      double startPercentage, double endPercentage, double anchorPercentage) {
    // driver = DriverManager.getAndroidDriver();
    Dimension size = driver.manage().window().getSize();
    int anchor = (int) (size.width * anchorPercentage);
    int startPoint = (int) (size.height * startPercentage);
    int endPoint = (int) (size.height * endPercentage);

    new TouchAction(driver)
        .press(point(anchor, startPoint))
        .waitAction(waitOptions(ofMillis(1000)))
        .moveTo(point(anchor, endPoint))
        .release()
        .perform();
  }

  // Swipe by elements
  public void swipeByElements(By startObject, By endObject) {
    // driver = DriverManager.getAndroidDriver();

    WebDriverWait wait = new WebDriverWait(driver, 30);
    WebElement startElement = wait.until(ExpectedConditions.presenceOfElementLocated(startObject));
    wait.until(ExpectedConditions.elementToBeClickable(startObject));

    WebElement endElement = wait.until(ExpectedConditions.presenceOfElementLocated(endObject));
    wait.until(ExpectedConditions.elementToBeClickable(endObject));

    int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
    int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

    int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
    int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

    new TouchAction(driver)
        .press(point(startX, startY))
        .waitAction(waitOptions(ofMillis(1000)))
        .moveTo(point(endX, endY))
        .release()
        .perform();
  }

  // Multitouch action by using an android element
  public void multiTouchByElement(By object) {
    // driver = DriverManager.getAndroidDriver();

    WebDriverWait wait = new WebDriverWait(driver, 30);
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(object));
    wait.until(ExpectedConditions.elementToBeClickable(object));

    TouchAction press =
        new TouchAction(driver)
            .press(element(element))
            .waitAction(waitOptions(ofSeconds(1)))
            .release();

    new MultiTouchAction(driver).add(press).perform();
  }

  public void sleep(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void myWait(By object) {

    // driver = DriverManager.getAndroidDriver();
    // WebElement element = driver.findElement(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    wait.until(ExpectedConditions.elementToBeClickable(object));
  }

  public boolean verifyExistance(By object) {
    // driver = DriverManager.getAndroidDriver();

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

  public boolean verifyExistanceWithWait(By object) {
    // driver = DriverManager.getAndroidDriver();

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

  public boolean verifyClickable(By object) {
    // driver = DriverManager.getAndroidDriver();

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

  public void enterTextWithEnter(By object, String text) {
    // driver = DriverManager.getAndroidDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    WebElement element = driver.findElement(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    element.sendKeys(text);
    // element.sendKeys(Keys.ENTER);
    androidEnter();
  }

  public void enterText(By object, String text) {
    // driver = DriverManager.getAndroidDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    WebElement element = driver.findElement(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    element.sendKeys(text);
  }

  public String getTextValue(By object) {
    // driver = DriverManager.getAndroidDriver();
    WebElement element = driver.findElement(object);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object));
    return element.getText();
  }

  public void selectAndroidDropDown(By object, String value, String childClassName)
      throws Exception {

    boolean success = false;

    try {
      // driver = DriverManager.getAndroidDriver();
      WebDriverWait wait = new WebDriverWait(driver, 30);
      tapByElement(object);

      // Thread.sleep(5000);

      while (!success) {

        @SuppressWarnings("unchecked")
        List<WebElement> webElements = driver.findElements(By.className(childClassName));

        for (WebElement _webElement : webElements) {
          wait.until(ExpectedConditions.elementToBeClickable(_webElement));
          String selection = _webElement.getText();
          System.out.println("Selection-->" + selection);
          if (selection.equals(value)) {
            success = true;

            new TouchAction(driver)
                .tap(tapOptions().withElement(element(_webElement)))
                .waitAction(waitOptions(Duration.ofMillis(250)))
                .perform();

            System.out.println("Performed Click..");

            break;
          }
        }
        if (!success) {
          // verticalSwipe(By.id("dsgui.android:id/parentPanel"));
          verticalSwipeByPercentages(0.8, 0.2, 0.5);
        }
      }

    } catch (Exception ex) {
      throw ex;
    }
  }

  /*public void verticalSwipe(By object) throws InterruptedException
  {
      Thread.sleep(5000);
      driver = DriverManager.getAndroidDriver();
      WebElement slider = driver.findElement(object);
      Point source = ((MobileElement) slider).getCenter();
      PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
      Sequence dragNDrop = new Sequence(finger, 1);
      dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),
              PointerInput.Origin.viewport(), source.x / 2, source.y + 400));
      dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
      dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(600),
              PointerInput.Origin.viewport(), source.getX() / 2, source.y / 2));
      dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
      driver.perform(Arrays.asList(dragNDrop));
  }*/

  public void androidEnter() {
    driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "Search"));
  }

  public void mobileClick(By object) {
    // make sure we have the most up to date driver
    // driver = DriverManager.getAndroidDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);

    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(object));
    wait.until(ExpectedConditions.elementToBeClickable(object));
    element.click();
  }

  public void takeScreenshot(String name, String path, boolean enabled) {
    if (path.equals("")) {
      path = "./ScreenShots/";
    }

    if (enabled) {
      try {
        // driver = DriverManager.getAndroidDriver();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(path + name + ".png"));
        System.out.println("Screenshot: " + path + name + ".png");
      } catch (Exception e) {
        // ErrorLog.printErrors(e.toString());
        e.printStackTrace();
      }
    }
  }

  public void mobileCleanup() {

    System.out.println("Cleaning up...");
    // driver = DriverManager.getAndroidDriver();
    driver.quit();
    // DriverManager.getDriver().quit();
  }

  public void extractSource() {
    System.out.println(driver.getPageSource());
  }
}
