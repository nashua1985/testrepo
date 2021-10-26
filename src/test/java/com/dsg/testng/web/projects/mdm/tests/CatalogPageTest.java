package com.dsg.testng.web.projects.mdm.tests;

import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.framework.enums.Browser;
import com.dsg.testng.web.projects.mdm.resources.MDMCatalogPage;
import com.dsg.testng.web.projects.mdm.resources.MDMHelperMethods;
import com.dsg.testng.web.resources.WebNavigation;
import org.testng.annotations.Test;

public class CatalogPageTest extends WebDriverBaseTest {

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void catalogPageTest(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "catalogPageTest", runType);

    WebNavigation nav = getWebNavigation();
    nav.goToURL("http://mdmqa/");
    MDMHelperMethods.setNav(nav);
    MDMHelperMethods.selectHomeTile(MDMCatalogPage.StyleSearch);

    // enter style into search bar (nav.entertext("searchbar", "style");
    // click go button

    // select catalog

    // nav.Sleep(10);
    nav.cleanup();
  }
}
