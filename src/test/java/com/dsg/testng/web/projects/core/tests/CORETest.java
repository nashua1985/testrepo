package com.dsg.testng.web.projects.core.tests;


import com.dsg.framework.enums.Browser;
import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.testng.web.projects.core.resources.CORELocators;
import com.dsg.testng.web.resources.WebNavigation;
import org.testng.annotations.Test;

class CORETest extends WebDriverBaseTest {

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void coreTest(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "coreTest", runType);

    WebNavigation nav = getWebNavigation();

    // urls.getURL("coreQA");

    nav.goToURL(
        "https://crm.qa.dcsg.com/CORE/home/CustomerPoint.aspx?sub_account=B23W3FXZ&account_type_id=1");
    nav.Click(CORELocators.AddRewardCertificates);
    nav.EnterText(CORELocators.PromoCode, "R12345688");
    nav.EnterText(CORELocators.ExpirationDate, "12/20/2019");
    nav.EnterText(CORELocators.Denomination, "10");
    nav.EnterText(CORELocators.PointsRemoved, "500");
    nav.EnterText(CORELocators.ReasonForReward, "test");
    nav.Click(CORELocators.CreateRewardCertificate);

    int rewardNum = nav.generateRandomNumber(8);

    int i = 0;
    // HighlightElement.PrintAllElements();
    while (true) {
      if (nav.VerifyExistance(CORELocators.CreateRewardCertificate)
          && nav.VerifyClickable(CORELocators.CreateRewardCertificate)) {
        nav.ClearText(CORELocators.PromoCode);
        nav.EnterText(CORELocators.PromoCode, "R" + rewardNum);
        i++;
        nav.Print("Fail " + i);
        nav.Click(CORELocators.CreateRewardCertificate);
        rewardNum = nav.generateRandomNumber(8);
      } else {
        break;
      }
    }
    /*nav.Sleep(5);
    WebElement error = DriverManager.getDriver().findElement(By.className("ui-widget ui-state-error message"));
    nav.Print(error.getAttribute("innerText"));*/

    nav.Sleep(10);
  }
}
