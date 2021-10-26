package com.dsg.cucumber.step_definitions.sp;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.pages.sp.SolePanelHomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class Smoke_SP_004_Verify_Users_can_view_click_submit_close_Submit_Feedback_link {

	
private static final Logger logger = Logger.getLogger(Smoke_SP_004_Verify_Users_can_view_click_submit_close_Submit_Feedback_link.class);
	
	CommonElementMethods commonMethods= new CommonElementMethods();
	private static final String feedbackCategory = "SolePanel Suggestion";
	private static final String feedback_Text = "TEST TEST TEST";
	private static final Integer timeout = 10;
	
	@And("users click on Submit Feedback link in Solepanel")
	public void verify_Submit_Feedback() throws Exception {

		commonMethods.switch_windows(timeout);
		commonMethods.clickWhenVisible(SolePanelHomePage.closeWelcomeMessage, 5);
		commonMethods.switchToDefault(timeout);
		commonMethods.clickWhenVisible(SolePanelHomePage.headerUserInfo,10);

          boolean isVisible = commonMethods.isElementVisible(SolePanelHomePage.submitFeedBack,10);
          if(!isVisible){
              Assert.fail("Submit FeedBack Link is not visible");
          }
	}

	@Then("users should be able to view,click,submit feedback and close Submit Feedback link.")
	public void click_close_Submit_Feedback_link() throws Exception {
	
		
//		  	commonMethods.clickWhenVisible(SolePanelHomePage.headerUserInfo,10);
			System.out.println("Clicked User info");
		  	commonMethods.hoverParentMenuAndClicksChild(SolePanelHomePage.headerUserInfo,SolePanelHomePage.submitFeedBack,10);
//					.clickWhenVisible(SolePanelHomePage.submitFeedBack,10);
			System.out.println("Clicked submit Feedback");
			Thread.sleep(1000);
			commonMethods.clickWhenVisible(SolePanelHomePage.feedBackBodyCategory,10);
			commonMethods.clickWhenVisible(SolePanelHomePage.categoryselection,10);
			System.out.println("Selected category");
          	commonMethods.enterValueWhenVisible(SolePanelHomePage.submitFeedBackTextBox, feedback_Text, 10);
			System.out.println("Entered Notes");
          	commonMethods.clickWhenVisible(SolePanelHomePage.clearTextBox, 10);
			System.out.println("Cleared Election");
			commonMethods.clickWhenVisible(SolePanelHomePage.feedBackBodyCategory,10);
			commonMethods.clickWhenVisible(SolePanelHomePage.categoryselection,10);
			System.out.println("Selected category");
			Thread.sleep(1000);
			commonMethods.enterValueWhenVisible(SolePanelHomePage.submitFeedBackTextBox, feedback_Text, 10);
			System.out.println("Entered Notes");
			assertTrue(commonMethods.isElementVisible(SolePanelHomePage.submitFeedBackButton,timeout));
			commonMethods.clickWhenVisible(SolePanelHomePage.submitFeedBackButton, 10);

	}
	

}
