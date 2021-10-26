package com.dsg.cucumber.step_definitions.sp;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.pages.sp.SolePanelHomePage;

import io.cucumber.java.en.And;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;


public class Smoke_SP_003_Verify_Users_can_view_click_close_Whats_new_link {
    
	private static final Logger logger = Logger.getLogger(Smoke_SP_003_Verify_Users_can_view_click_close_Whats_new_link.class);
	
	CommonElementMethods commonMethods= new CommonElementMethods();
	private static final Integer timeout = 10;
	
	@And("user click on Whats_new link in Solepanel")
	public void verify_Whats_new_link() throws Exception {

		commonMethods.switch_windows(timeout);
		commonMethods.clickWhenVisible(SolePanelHomePage.closeWelcomeMessage, 5);
		commonMethods.switchToDefault(timeout);

          boolean isVisible = commonMethods.isElementVisible(SolePanelHomePage.headerWhatsNew,10);
          if(!isVisible){
              Assert.fail("Whats-New Link is not visible");
          }
		 
	}

	@And("user should be able to view,click and close Whats-new link")
	public void click_close_Whatsnew_link() throws Exception {
	
		  commonMethods.clickWhenVisible(SolePanelHomePage.headerWhatsNew,10);
          commonMethods.clickWhenVisible(SolePanelHomePage.gotItButtonWhatsNew,10);
          commonMethods.clickWhenVisible(SolePanelHomePage.headerWhatsNew,10);
          commonMethods.clickWhenVisible(SolePanelHomePage.closeWhatsNew,10);
          
	}
	
	}

