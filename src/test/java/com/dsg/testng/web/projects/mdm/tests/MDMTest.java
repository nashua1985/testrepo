package com.dsg.testng.web.projects.mdm.tests;

import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.framework.enums.Browser;
import com.dsg.testng.web.projects.mdm.resources.MDMCatalogPage;
import com.dsg.testng.web.projects.mdm.resources.MDMHelperMethods;
import com.dsg.testng.web.resources.WebNavigation;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MDMTest extends WebDriverBaseTest {

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void mdmTest(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "mdmTest", runType);

    WebNavigation nav = getWebNavigation();
    // Navigation nav = new Navigation(true);
    MDMHelperMethods.setNav(nav);
    MDMHelperMethods.mdmLogin("aaron.anderson@dcsg.com");
    MDMHelperMethods.selectHomeTile(MDMCatalogPage.PIM);
    String[] ColorArray = {"Blue", "Black", "Green", "AJ", "AMY", "Test"};
    ArrayList<String> colorsList = new ArrayList<String>();
    for (String color : ColorArray) {
      colorsList.add(color);
      nav.EnterText(By.id("colorInput"), color + "\n");
    }

    nav.Click(By.id("button_CheckList"));

    MDMHelperMethods.colorsFound(colorsList);

    nav.TakeScreenshot("test", false);

    // nav.Sleep(5);

    nav.cleanup();
  }
}
