package com.dsg.cucumber.step_definitions.sp;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.pages.sp.AthleteSummaryPage;
import com.dsg.pages.sp.OrderDetailsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class Smoke_SP_007_Verify_Users_are_able_to_Create_Order_Incident {

	private static final Logger logger = Logger.getLogger(Smoke_SP_007_Verify_Users_are_able_to_Create_Order_Incident.class);
	private static final Integer timeout = 10;
    private static final String Create_Order_Incident = "Create Order Incident";
	private static final String incidentNotes = "TEST TEST TEST";
	private static final String successfulMessage = "Success!";
	private static final String orderDetail_Header = "Order Details";


	CommonElementMethods commonMethods= new CommonElementMethods();

	@And("users click on Create Order Incident button in Solepanel Order details page")
	public void click_Create_Order_Incident() throws Exception {

		commonMethods.clickWhenVisible(AthleteSummaryPage.orderDetailsButton, 10);
		logger.info("Clicked on Order Details Button");
        assertTrue(commonMethods.isElementVisible(OrderDetailsPage.createOrderIncident, 10));
        
        if(commonMethods.isElementVisible(OrderDetailsPage.createOrderIncident, 10)){
        	commonMethods.clickWhenVisible(OrderDetailsPage.createOrderIncident, 10);
	        } else 	Assert.fail("Create Order Incident option not available");
		commonMethods.switchToDefault(10);
	}
		
	@Then("users should be able to view,click,cancel and Create Order Incident")
	public void Create_Order_Incident() throws Exception {

		logger.info("Landing in Create Order Incident Tab");
		String headerName = commonMethods.getTextFromLocator(OrderDetailsPage.orderIncidentHeader,10);
		assertTrue(headerName.equalsIgnoreCase(Create_Order_Incident));
		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.orderIncidentForm,OrderDetailsPage.orderIncidentCategoryDropdown,10);
		logger.info("Clicked OrderIncident CategoryDropdown");
		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.orderIncidentCategoryDropdown,OrderDetailsPage.optionShippedandDelivered,10);
		logger.info("Selected OrderIncident Reason");
//		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.orderIncidentForm,OrderDetailsPage.incidentNotes,10);
		commonMethods.enterValueWhenVisible(OrderDetailsPage.incidentNotes, incidentNotes, 10);
		logger.info("Entered OrderIncident Notes");
		commonMethods.clickWhenVisible(OrderDetailsPage.cancelButton, 10);
		logger.info("Order Incident Canceled");
		logger.info("Creating New Incident Canceled");
		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.orderIncidentForm,OrderDetailsPage.orderIncidentCategoryDropdown,10);
		logger.info("Clicked OrderIncident CategoryDropdown");
		commonMethods.hoverParentMenuAndClicksChild(OrderDetailsPage.orderIncidentCategoryDropdown,OrderDetailsPage.optionShippedandDelivered,10);
		logger.info("Selected OrderIncident Reason");
		commonMethods.enterValueWhenVisible(OrderDetailsPage.incidentNotes, incidentNotes, 10);
		logger.info("Entered OrderIncident Notes");
		Thread.sleep(1000);
		commonMethods.clickWhenVisible(OrderDetailsPage.submitButton, 10);
		logger.info("Submitting Order Incident");
		String successful = commonMethods.getTextFromLocator(OrderDetailsPage.successMessage,10);
		assertTrue(successfulMessage.equalsIgnoreCase(successful));
		logger.info("Created Order Incident Successfully");
		commonMethods.hoverOnElement(OrderDetailsPage.okButton,5);
		commonMethods.clickWhenVisible(OrderDetailsPage.okButton,10);
		logger.info("Successfully Created Order Incident");
		Thread.sleep(1000);
		String orderDetails_HeaderName = commonMethods.getTextFromLocator(OrderDetailsPage.orderDetailHeader,10);
		System.out.println(orderDetails_HeaderName);
		logger.info("Landing in Create Order Incident Tab");
		assertTrue(orderDetails_HeaderName.equalsIgnoreCase(orderDetail_Header));
	}

	
}
