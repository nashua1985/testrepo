package com.dsg.cucumber.step_definitions.sp;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.pages.sp.AthleteSummaryPage;
import com.dsg.pages.sp.OrderDetailsPage;
import com.dsg.pages.sp.SolePanelHomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class Smoke_SP_008_Verify_users_are_able_to_view_cancel_apply_Adjust_Item {
	
	private static final Logger logger = Logger.getLogger(Smoke_SP_008_Verify_users_are_able_to_view_cancel_apply_Adjust_Item.class);
	
	CommonElementMethods commonMethods= new CommonElementMethods();
	private static final Integer timeout = 10;
	private static final String adjustItem_Header = "Select Items to Apply Adjustment";
//	private static final String adjustmentCategoryOption = "BPG - Competitor Match";
	private static final String adjustment_Notes = "TEST TEST TEST";
	private static final String adjustmentCreditValue = "2";
	private static final String applyAdjustment_footer = "Apply Adjustment/Credit and Notes.";

	@And("users search for an Order using email {string} in Order Look Up container")
	public void order_email_search_for_adjust_item(String email) throws Exception {

		commonMethods.switch_windows(timeout);
		commonMethods.clickWhenVisible(SolePanelHomePage.closeWelcomeMessage, 5);
		commonMethods.switchToDefault(timeout);
		commonMethods.clickWhenVisible(SolePanelHomePage.searchByEmailLink, 10);
		System.out.println("Clicked Email link");
		commonMethods.enterValueWhenVisible(SolePanelHomePage.enterEmailId, email, 10);
		System.out.println("Entered Email id" +email);
		commonMethods.clickWhenVisible(SolePanelHomePage.submitSearchButton, 10);
		assertTrue(commonMethods.isElementVisible(AthleteSummaryPage.emailId, 10));

		if(commonMethods.isElementVisible(AthleteSummaryPage.emailId, 10)){

			String email_Id = commonMethods.getTextFromLocator(AthleteSummaryPage.emailId, 10);
			System.out.println(email_Id);

			if (!("Email: "+email).equalsIgnoreCase(email_Id))
			{
				Assert.fail("Search did not return any results for: "+email);
			}
		}
	}

	@And("users click on Adjust Item button in Solepanel Order details page")
	public void click_Adjust_Item() throws Exception {

		commonMethods.clickWhenVisible(AthleteSummaryPage.orderDetailsButton, 10);
		logger.info("Clicked on Order Details Button");

		if(commonMethods.isElementVisible(OrderDetailsPage.adjustItembutton, 10)){
			commonMethods.clickWhenVisible(OrderDetailsPage.adjustItembutton, 10);
		} else 	Assert.fail("Adjust Item option not available");

		commonMethods.switchToDefault(10);
		
	}
		
	@Then("users should be able to view,click,cancel and apply Adjustment on Item")
	public void click_cancel_adjust_item() throws Exception {

		logger.info("Landing in Adjust Item Tab");
		String adjustItemheaderName = commonMethods.getTextFromLocator(OrderDetailsPage.adjustItemHeader,10);
		assertTrue(adjustItemheaderName.equalsIgnoreCase(adjustItem_Header));
		commonMethods.clickWhenVisible(OrderDetailsPage.canceladjustItem, 10);
		logger.info("Cancelled Adjust Item");
		commonMethods.clickWhenVisible(OrderDetailsPage.adjustItembutton, 10);
		logger.info("Landing in Adjust Item Tab");
		Thread.sleep(1000);
		commonMethods.clickWhenVisible(OrderDetailsPage.selectItemsForAdjustments, 10);
		commonMethods.clickWhenVisible(OrderDetailsPage.nextStep, 10);
		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.adjustmentFormBody,OrderDetailsPage.adjustmentCategory,10);
		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.adjustmentFormBody,OrderDetailsPage.adjustmentCategorySelection,10);
		logger.info("Selected Adjustment Category");
		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.adjustmentFormBody,OrderDetailsPage.adjustmentNotes,10);
		commonMethods.enterValueWhenVisible(OrderDetailsPage.adjustmentNotes,adjustment_Notes, 10);
		logger.info("Adjustment Notes Added");
		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.adjustmentCreditDiv,OrderDetailsPage.adjustmentCredit,10);
		commonMethods.enterValueWhenVisible(OrderDetailsPage.adjustmentCredit,adjustmentCreditValue, 10);
		logger.info("Adjustment Credit Amount entered");
		commonMethods.sendkeys_tab(OrderDetailsPage.adjustmentCredit,10);
		String adjustItemfooterNote = commonMethods.getTextFromLocator(OrderDetailsPage.applyAdjustmentFooter,10);
		assertTrue(adjustItemfooterNote.equalsIgnoreCase(applyAdjustment_footer));
		commonMethods.clickWhenVisible(OrderDetailsPage.applyAdjustmentNextButton, 10);
		logger.info("Clicked Next for Apply Adjustment");
		commonMethods.clickWhenVisible(OrderDetailsPage.returnToOrderAdjustment, 10);
		logger.info("Confirmation Box - Returned to Order elected");

//		******BELOW 2 LINES WILL COMPLETE ADJUSTMENT ********
//		********************************************************
//		commonMethods.clickWhenVisible(OrderDetailsPage.applyAdjustmentNextButton, 10);
//		commonMethods.clickWhenVisible(OrderDetailsPage.completeAdjustment, 10);
//		********************************************************
	}
       
}
