package com.dsg.cucumber.step_definitions.sp;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.pages.sp.AthleteSummaryPage;
import com.dsg.pages.sp.SolePanelHomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class Smoke_SP_005_Verify_Order_Look_Up_with_Order_number_Phone_Number_Email {

private static final Logger logger = Logger.getLogger(Smoke_SP_005_Verify_Order_Look_Up_with_Order_number_Phone_Number_Email.class);
	
	CommonElementMethods commonMethods= new CommonElementMethods();
	private static final Integer timeout = 10;

	@And("users search for Order using order number {string} in Order Look Up container")
	public void Ordersearch_with_ordernumber(String order_number) throws Exception {

		commonMethods.switch_windows(timeout);
		commonMethods.clickWhenVisible(SolePanelHomePage.closeWelcomeMessage, 5);
		commonMethods.switchToDefault(timeout);

		commonMethods.enterValueWhenVisible(SolePanelHomePage.enterOrderNumberSearch, order_number, 10);
		System.out.println("Entered Order number" + order_number);
		commonMethods.clickWhenVisible(SolePanelHomePage.submitSearchButton, 10);
		}
	@Then("users should be navigated to Athlete Summary Page of the order number {string}")
	public void validate_ordernumber_search(String order_number) throws Exception {

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

	@When("users search for an Order using phone number {string} in Order Look Up container")
	public void Ordersearch_with_phone(String phone_number) throws Exception {
		commonMethods.clickWhenVisible(SolePanelHomePage.orderlookupnav,timeout);
		commonMethods.switchToDefault(timeout);

		commonMethods.enterValueWhenVisible(SolePanelHomePage.enterPhoneNumberSearch, phone_number, 10);
		commonMethods.clickWhenVisible(SolePanelHomePage.submitSearchButton, 10);

		assertTrue(commonMethods.isElementVisible(AthleteSummaryPage.phoneNumber, 10));

	}
	@Then("users should be navigated to Athlete Summary Page of the Phone_Number {string}")
	public void validate_phonenumber_search(String phone_number) throws Exception {


		assertTrue(commonMethods.isElementVisible(AthleteSummaryPage.phoneNumber, 10));

		if(commonMethods.isElementVisible(AthleteSummaryPage.phoneNumber, 10)){

			String phone = commonMethods.getTextFromLocator(AthleteSummaryPage.phoneNumber, 10);
	          System.out.println(phone);
	            	if (!("Phone: "+phone_number).equalsIgnoreCase(phone))
	            	{
	            		Assert.fail("Search did not return any results for: "+phone_number);
	            	} 
	            }
	        }	
	
	@When("users search for Order using email {string} in Order Look Up container")
	public void Ordersearch_with_email(String email) throws Exception {
		commonMethods.clickWhenVisible(SolePanelHomePage.orderlookupnav,timeout);
		commonMethods.switchToDefault(timeout);

	   	commonMethods.clickWhenVisible(SolePanelHomePage.searchByEmailLink, 10);
		System.out.println("Clicked Email link");
		commonMethods.enterValueWhenVisible(SolePanelHomePage.enterEmailId, email, 10);
		System.out.println("Entered Email id" +email);
		commonMethods.clickWhenVisible(SolePanelHomePage.submitSearchButton, 10);
	}
	@Then("users should be navigated to Athlete Summary Page of the email {string}")
	public void validate_email_search(String email) throws Exception {

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
	
	
}
