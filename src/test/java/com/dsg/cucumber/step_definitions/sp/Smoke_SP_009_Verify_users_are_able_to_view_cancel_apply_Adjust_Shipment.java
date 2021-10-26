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

public class Smoke_SP_009_Verify_users_are_able_to_view_cancel_apply_Adjust_Shipment {

	private static final Logger logger = Logger.getLogger(Smoke_SP_009_Verify_users_are_able_to_view_cancel_apply_Adjust_Shipment.class);
	
	CommonElementMethods commonMethods= new CommonElementMethods();
	private static final Integer timeout = 10;
	private static final String adjustmentNotes = "TEST TEST TEST";
	private static final String adjust_Shipping_Header = "Apply Adjustment";

	@And("users search for an Order using order number {string} in Order Look Up container")
	public void order_number_search_for_adjust_shipping(String order_number) throws Exception {

		commonMethods.switch_windows(timeout);
		commonMethods.clickWhenVisible(SolePanelHomePage.closeWelcomeMessage, 5);
		commonMethods.switchToDefault(timeout);

		commonMethods.enterValueWhenVisible(SolePanelHomePage.enterOrderNumberSearch, order_number, 10);
		System.out.println("Entered Order number" + order_number);
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
	@And("users click on Adjust Shipment button in Solepanel Order details page")
	public void click_adjust_shipment() throws Exception {

		commonMethods.clickWhenVisible(AthleteSummaryPage.orderDetailsButton, 10);
		logger.info("Clicked on Order Details Button");

		if(commonMethods.isElementVisible(OrderDetailsPage.adjustShippingButton, 10)){
			commonMethods.clickWhenVisible(OrderDetailsPage.adjustShippingButton, 10);
		} else 	Assert.fail("Adjust Shipping option not available");

		commonMethods.switchToDefault(10);

		}

	@Then("users should be able to view,click,cancel and apply Adjust Shipment")
	public void cancel_apply_adjust_shipping() throws Exception {

		logger.info("Landing in Adjust Shipping Tab");
		String adjustShippingHeaderName = commonMethods.getTextFromLocator(OrderDetailsPage.adjustShippingHeader,10);
		assertTrue(adjustShippingHeaderName.equalsIgnoreCase(adjust_Shipping_Header));

		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.adjustmentFormBody,OrderDetailsPage.adjustmentCategory,10);
		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.adjustmentFormBody,OrderDetailsPage.adjustmentCategorySelection,10);
		logger.info("Selected Adjustment Category");
		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.adjustmentFormBody,OrderDetailsPage.adjustmentNotes,10);
		commonMethods.enterValueWhenVisible(OrderDetailsPage.adjustmentNotes,adjustmentNotes, 10);
		logger.info("Adjustment Notes Added");

		commonMethods.clickWhenVisible(OrderDetailsPage.applyAdjustmentNextButton, 10);
		commonMethods.clickWhenVisible(OrderDetailsPage.returnToOrderAdjustment, 10);

//		******BELOW 2 LINES WILL COMPLETE ADJUSTMENT ********
//		********************************************************
//		commonMethods.clickWhenVisible(OrderDetailsPage.applyAdjustmentNextButton, 10);
//		commonMethods.clickWhenVisible(OrderDetailsPage.completeAdjustment, 10);
//		********************************************************
	}

}
