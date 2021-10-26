package com.dsg.testng.web.projects.hr.tests;

import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.framework.credentials.EagleCredential;
import com.dsg.framework.credentials.EagleEncryption;
import com.dsg.framework.enums.Browser;
import com.dsg.testng.web.projects.hr.resources.HRHelperMethods;
import com.dsg.testng.web.projects.hr.resources.PeopleSoftLocators;
import com.dsg.testng.web.resources.WebNavigation;
import org.testng.annotations.Test;

// Need to add property file creds for PeopleSoft - setup for sauce now

public class NewHire extends WebDriverBaseTest {

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void newHire(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "newHire", runType);

    WebNavigation nav = getWebNavigation();
    // CARL CODE
    // Navigation nav = new Navigation(true);
    HRHelperMethods hrm = new HRHelperMethods();
    nav.goToURL("https://myhruat.dcsg.com/psp/hr92u/EMPLOYEE/?cmd=login&languageCd=ENG&");
    String encyrptedCreds = properties.getSauceEncryptedCredential();
    EagleCredential creds = EagleEncryption.decryptCredential(encyrptedCreds);

    // CredentialsDTO PSHRCreds = CredentialsManager.GetCredentails("PSHR");
    nav.EnterText(PeopleSoftLocators.Loginuser, creds.getUserName());
    nav.EnterText(PeopleSoftLocators.Loginpword, creds.getPassword());
    nav.Click(PeopleSoftLocators.Signon);

    /*List<WebElement> tiles = DriverManager.getDriver().findElements(By.xpath("//*[contains(@id, 'PTNUI_LAND_REC_GROUPLET_LBL')]"));

    HashMap<String, WebElement> tileMap = new HashMap<String, WebElement>();

    for(WebElement tile : tiles)
    {
    	//nav.Print("ID " + tile.getAttribute("id") + " Text: " + tile.getText());
    	nav.Print("ID " + tile.getAttribute("id") + " Text: " + tile.getAttribute("innerText"));
    	tileMap.put(tile.getAttribute("innerText"), tile);
    }

    nav.ClickElement(tileMap.get("Approvals"));*/
    nav.Sleep(2);
    hrm.clickTile("Classic Home");

    // nav.ClickLoopScroll(PeopleSoftLocators.Homebox);
    hrm.clickTile("Classic Home");
    // nav.Click(PeopleSoftLocators.Homebox2);
    nav.Click(PeopleSoftLocators.Main);
    nav.Click(PeopleSoftLocators.Wkfcadmin);
    nav.Click(PeopleSoftLocators.Perinfo);
    nav.Click(PeopleSoftLocators.Addpersn);

    // DriverManager.getDriver().switchTo().frame(0);

    nav.ClickiFrameIgnore(PeopleSoftLocators.Add);
    nav.Click(PeopleSoftLocators.Addname);

    /*for(int i =0; i < 20; i++)
    {
    	DriverManager.getDriver().switchTo().parentFrame();
    }*/

    // DriverManager.getDriver().switchTo().defaultContent();

    // DriverManager.getDriver().switchTo().frame("ptModFrame_0");
    // DriverManager.getDriver().switchTo().frame(1);
    /*nav.EnterTextiFrameIgnore(PeopleSoftLocators.First, "Joe");
    nav.EnterTextiFrameIgnore(PeopleSoftLocators.Last, "Test");
    nav.ClickiFrameIgnore(PeopleSoftLocators.Savname);*/

    nav.EnterText(PeopleSoftLocators.First, "Joe");
    nav.EnterText(PeopleSoftLocators.Last, "Test");
    nav.Click(PeopleSoftLocators.Savname);
    /*for(int i =0; i < 20; i++)
    {
    	DriverManager.getDriver().switchTo().parentFrame();
    }
    //nav.getDriver().switchTo().frame("ptifrmtgtframe");
    DriverManager.getDriver().switchTo().frame(0);*/
    nav.EnterTextiFrameIgnore(PeopleSoftLocators.Birthdt, "01/01/1966");
    nav.SelectDropDown(PeopleSoftLocators.Gender, "M");
    // nav.Sleep(3);
    nav.EnterTextLoop(PeopleSoftLocators.SSN, "122-55-1111");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    nav.cleanup();
  }
}

/*package com.hr;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dsg.utilities.CredentialsManager;
import com.dsg.utilities.DriverManager;
import com.dsg.utilities.Navigation;
import com.dsg.utilities.dto.CredentialsDTO;

public class NewHire {

	@Test
	public void newhire()

	{

		Navigation nav = new Navigation(true);

		HRHelperMethods.readIDsFromFile("C:/testIDs.txt");

		nav.goToURL("https://myhruat.dcsg.com/psp/hr92u/EMPLOYEE/?cmd=login&languageCd=ENG&");
		CredentialsDTO PSHRCreds = CredentialsManager.GetCredentails("PSHR");
		nav.EnterText(PeopleSoftLocators.Loginuser, PSHRCreds.getUser());
		nav.EnterText(PeopleSoftLocators.Loginpword,PSHRCreds.getPassword());
		//HighlightElement.HighlightAllElements();
		nav.Click(PeopleSoftLocators.Signon);
		//nav.Sleep(2);
		//nav.Click(By.id("win0divPTNUI_LP_PAGE_row$2"));
		WebElement element = DriverManager.getDriver().findElement(By.id("win0divPTNUI_LP_PAGE_row$2"));
		new Actions(DriverManager.getDriver()).moveToElement(element).perform();
		nav.ClickLoopScroll(PeopleSoftLocators.Homebox);
		nav.Click(PeopleSoftLocators.Homebox2);
		nav.Click(PeopleSoftLocators.Main);
		nav.Click(PeopleSoftLocators.Wkfcadmin);
		nav.Click(PeopleSoftLocators.Perinfo);
		nav.Click(PeopleSoftLocators.Addpersn);
		//nav.getDriver().switchTo().frame(0);
		DriverManager.getDriver().switchTo().frame(0);
		nav.Click(PeopleSoftLocators.Add);


		//nav.Click(PeopleSoftLocators.Addname);
		ClickSubmit();

		nav.Sleep(5);

		for(int i =0; i < 4; i++)
		{
			DriverManager.getDriver().switchTo().parentFrame();
		}



		//Assume driver is initialized properly.
	    List<WebElement> ele = DriverManager.getDriver().findElements(By.tagName("iframe"));
	    System.out.println("Number of frames in a page :" + ele.size());
	    for(WebElement el : ele){
	      //Returns the Id of a frame.
	        System.out.println("Frame Id :" + el.getAttribute("id"));
	      //Returns the Name of a frame.
	        System.out.println("Frame name :" + el.getAttribute("name"));
	    }
		//DriverManager.getDriver().switchTo().frame("ptifrmtgtframe");
		DriverManager.getDriver().switchTo().frame("ptModFrame_0");
		Set<String> windows = DriverManager.getDriver().getWindowHandles();
		for(String temp : windows)
	    {
			nav.Print(temp);
			windowHandles.add(temp);
	    }

		driver1.switchTo().window(windowHandles.get(0));
		DriverManager.setDriver(driver1);
		for(String temp : windows)
	    {
			nav.Print("window");
			DriverManager.getDriver().switchTo().window(temp);
	    }




		//nav.getDriver().switchTo().frame("ptModFrame_0");
		for(int i =0; i < 10; i++)
		{
			DriverManager.getDriver().switchTo().frame(i);

			System.out.println("Frame: " + i);
		}
		//DriverManager.getDriver().switchTo().frame("ptModFrame_0");
		WebElement element1 = DriverManager.getDriver().switchTo().activeElement();
		System.out.println("Element: " + element1.getAttribute("name"));
		Robot r;
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement element1 = DriverManager.getDriver().switchTo().activeElement();
		System.out.println("Element: " + element1.getAttribute("name"));


		nav.EnterTextElement(element1, "Joe");
		//nav.Click(By.id("ptModTitle_0"));
		//DriverManager.getDriver().switchTo().frame(0);
		//HighlightElement.HighlightAllElements();
		//HighlightElement.PrintAllElements();


		//nav.EnterText(By.id("PERSON_BIRTHPLACE"), "test");
		nav.EnterText(PeopleSoftLocators.First, "Joe");
		//nav.Click(PeopleSoftLocators.Cancel);


		try
		{
			Thread.sleep(10000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		nav.cleanup();

	}


	public static void ClickSubmit()
	  {
		  JavascriptExecutor jsExec;

		  WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);

		  jsExec = (JavascriptExecutor) DriverManager.getDriver();

		  try {
				WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DERIVED_NM_LVL2_UPDATE_NAME_BTN$0")));
				jsExec.executeScript("arguments[0].click();", element);
			} catch (Exception e) {
				//throw new ElementNotClickableException("clickSubmitOrderButton()", e);
				e.printStackTrace();
			}

	  }





}*/
