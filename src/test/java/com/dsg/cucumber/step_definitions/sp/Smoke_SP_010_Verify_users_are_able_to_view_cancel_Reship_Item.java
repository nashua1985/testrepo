package com.dsg.cucumber.step_definitions.sp;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.pages.sp.AthleteSummaryPage;
import com.dsg.pages.sp.OrderDetailsPage;
import com.dsg.pages.sp.ReshipPage;
import com.dsg.pages.sp.SolePanelHomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class Smoke_SP_010_Verify_users_are_able_to_view_cancel_Reship_Item {

	private static final Logger logger = Logger.getLogger(Smoke_SP_010_Verify_users_are_able_to_view_cancel_Reship_Item.class);
	
	CommonElementMethods commonMethods= new CommonElementMethods();
	private static final String reshipCategoryOption = "Damaged or Used";
	private static final String reshipNotes = "TEST TEST TEST";
	private static final String reship_header ="Select Items For Reship";
	private static final Integer timeout = 10;


	@When("users search for Order using {string} in Order Look Up container for Reship Item")
	public void order_search_for_reship_items(String order_number) throws Exception {

//		*** USER AUTHENTICATION AND WELCOME MESSAGE TEST STEPS WILL NOT BE APPLICABLE FOR NON-PROD****
		commonMethods.switch_windows(timeout);
		commonMethods.clickWhenVisible(SolePanelHomePage.closeWelcomeMessage, 5);
		commonMethods.switchToDefault(timeout);

		commonMethods.enterValueWhenVisible(SolePanelHomePage.enterOrderNumberSearch, order_number, 10);
		logger.info("Entered Order number" + order_number);
		commonMethods.clickWhenVisible(SolePanelHomePage.submitSearchButton, 10);
		assertTrue(commonMethods.isElementVisible(AthleteSummaryPage.orderNumber, 10));

		if(commonMethods.isElementVisible(AthleteSummaryPage.orderNumber, 10)){
			String Orderid = commonMethods.getTextFromLocator(AthleteSummaryPage.orderNumber, 10);
			System.out.println(Orderid);
			if (!("Order "+order_number).equalsIgnoreCase(Orderid))
			{
				Assert.fail("Search did not return any results for: "+order_number);
			}
		}
	}

	@And("users click on Reship Item button in Solepanel Order details page")
	public void click_Reship_Item() throws Exception {
		commonMethods.clickWhenVisible(AthleteSummaryPage.orderDetailsButton, 10);
		logger.info("Clicked on Order Details Button");

		if(commonMethods.isElementVisible(OrderDetailsPage.reshipButton, 10)){
			commonMethods.clickWhenVisible(OrderDetailsPage.reshipButton, 10);
		} else 	Assert.fail("Re-Shipping option is not available for this order");
	}
		
	@Then("users should be able to view,click,cancel and Reship Item")
	public void View_Cancel_Confirm_Reship() throws Exception {

		logger.info("Landing in Re-Shipping Tab");
		String resgipHeaderName = commonMethods.getTextFromLocator(ReshipPage.reshipHeader,10);
		assertTrue(resgipHeaderName.equalsIgnoreCase(reship_header));

		commonMethods.clickWhenVisible(ReshipPage.SelectItems, 10);
		commonMethods.clickWhenVisible(ReshipPage.NextStepButton, 10);
		commonMethods.clickWhenVisible(ReshipPage.SelectShippingOption, 10);
		commonMethods.clickWhenVisible(ReshipPage.NextStepButton, 10);
		commonMethods.hoverParentMenuAndClicksChild(ReshipPage.reshipCategoryDropdown,ReshipPage.selectReason,10);
		commonMethods.enterValueWhenVisible(ReshipPage.IncidentNotes, reshipNotes, 10);
		commonMethods.clickWhenVisible(ReshipPage.NextStepButton, 10);
		commonMethods.clickWhenVisible(ReshipPage.ReturnToOrder, 10);

//		******BELOW 2 LINES WILL COMPLETE ADJUSTMENT ********
//		********************************************************
//		commonMethods.clickWhenVisible(ReshipPage.NextStepButton, 10);
//		commonMethods.clickWhenVisible(ReshipPage.ConfirmReship, 10);
//		commonMethods.clickWhenVisible(ReshipPage.CloseConfirmReship,10);
//		********************************************************

		
				
	}
}
