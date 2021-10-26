package com.dsg.testng.web.projects.mdm.resources;

import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.testng.web.resources.WebNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MDMHelperMethods extends WebDriverBaseTest {

  private static WebNavigation nav;

  public static void setNav(WebNavigation nav) {
    MDMHelperMethods.nav = getWebNavigation();
  }

  public static void mdmLogin(String username) {
    Set<String> windows = nav.getDriver().getWindowHandles();
    ArrayList<String> windowIDs = new ArrayList<String>();
    for (String temp : windows) {
      windowIDs.add(temp);
      nav.Print(temp);
    }
    // System.out.println("switching to: " + windowIDs.get(windowIDs.size()-1));

    nav.getDriver().switchTo().window(windowIDs.get(windowIDs.size() - 1));
    nav.EnterText(By.name("loginfmt"), username);
    nav.Click(By.id("idSIButton9"));

    nav.getDriver().switchTo().window(windowIDs.get(0));
  }

  public static void selectHomeTile(String tile) {
    nav.Click(By.xpath("//*[text()='" + tile + "']"));
  }

  // public static String [] colorsFound()
  public static void colorsFound(ArrayList<String> inputColors) {
    By object1 = By.xpath(".//*[@class = 'col-md-2']");
    By object2 = By.xpath("//*[@class = 'row ng-star-inserted']");
    By object3 = By.xpath(".//*[@class = 'ng-star-inserted']");
    // get row with labels and colors found/not found
    List<WebElement> elements = nav.getDriver().findElements(object2);
    WebDriverWait wait = new WebDriverWait(nav.getDriver(), 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(object2));
    // 0- labels 1 - colors not found/found
    List<WebElement> foundNotFound = elements.get(1).findElements(object1);
    // colors found - list colors
    List<WebElement> found = foundNotFound.get(0).findElements(object3);
    // this variable stores all the colors under the "Colors Found!" label in the application
    ArrayList<String> colorValuesFound = new ArrayList<String>();
    // this variable stores all the colors under the "Colors Not Found!" label in the application
    ArrayList<String> colorValuesNotFound = new ArrayList<String>();
    System.out.println("Found:");
    for (WebElement color : found) {
      System.out.println(color.getText());
      colorValuesFound.add(color.getText().trim());
    }

    System.out.println("Not Found:");
    List<WebElement> notFound = foundNotFound.get(1).findElements(object3);
    for (WebElement color : notFound) {
      System.out.println(color.getText());
      colorValuesNotFound.add(color.getText().trim());
    }

    // this loop checks which colors were found
    int foundCount = 0;
    ArrayList<String> removeIndexes = new ArrayList<String>();
    for (int i = 0; i < inputColors.size(); i++) {
      if (colorValuesFound.contains(inputColors.get(i))) {
        System.out.println("Color found: " + inputColors.get(i));
        // inputColors.remove(i);
        removeIndexes.add(inputColors.get(i));
        foundCount++;
        continue;
      } else if (colorValuesFound.contains(inputColors.get(i).toUpperCase())) {
        System.out.println("Color found: " + inputColors.get(i));
        // inputColors.remove(i);
        removeIndexes.add(inputColors.get(i));
        foundCount++;
      }
    }
    // remove colors that were found then clean out the container holding which values are to be
    // removed
    inputColors.removeAll(removeIndexes);
    removeIndexes.removeAll(removeIndexes);

    int notFoundCount = 0;
    for (int i = 0; i < inputColors.size(); i++) {
      if (colorValuesNotFound.contains(inputColors.get(i))) {
        System.out.println("Color not found: " + inputColors.get(i));
        // inputColors.remove(i);
        removeIndexes.add(inputColors.get(i));
        notFoundCount++;
        // continue;
      }
      /*else if(colorValuesNotFound.contains(inputColors.get(i).toUpperCase()))
      {
      	System.out.println("Color not found: " + inputColors.get(i));
      	//inputColors.remove(i);
      	removeIndexes.add(inputColors.get(i));
      	notFoundCount++;
      }*/
    }

    inputColors.removeAll(removeIndexes);

    int errorCount = 0;
    // print colors left under "Error"
    if (inputColors.size() > 0) {
      System.out.println("Colors in error:");
      for (String color : inputColors) {
        System.out.println(color);
        errorCount++;
      }
    }

    System.out.println("Summary: ");
    System.out.println("Colors found: " + foundCount);
    System.out.println("Colors not found: " + notFoundCount);
    System.out.println("Errors: " + errorCount);
  }
}
