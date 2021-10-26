package com.dsg.cucumber.step_definitions.sp;
import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.pages.sp.AthleteSummaryPage;
import com.dsg.pages.sp.OrderDetailsPage;
import com.dsg.pages.sp.SolePanelHomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class Smoke_SP_006_Verify_Users_are_able_to_Resend_confirmation {

	private static final Logger logger = Logger.getLogger(Smoke_SP_006_Verify_Users_are_able_to_Resend_confirmation.class);
	CommonElementMethods commonMethods= new CommonElementMethods();
	private static final Integer timeout = 10;

	@And("users click on Resend confirmation link in Solepanel Order details page")
		public void click_Resend_confirmation() throws Exception {

			commonMethods.clickWhenVisible(AthleteSummaryPage.orderDetailsButton, 10);
			System.out.println("Clicked on Order Details Button");
            assertTrue(commonMethods.isElementVisible(OrderDetailsPage.resendConfirmationbutton, 10));
            
            if(commonMethods.isElementVisible(OrderDetailsPage.resendConfirmationbutton, 10)){
            	
            	commonMethods.clickWhenVisible(OrderDetailsPage.resendConfirmationbutton, 10);
            	            	
            } else 	Assert.fail("Resend Confirmation option not available");
            
		}
		
		@Then("users should be able to view,click,close,Return to Order or Resend Order confirmation")
		public void Resend_confirmation() throws Exception {
            	
            	commonMethods.clickWhenVisible(OrderDetailsPage.confirmResendConfirmationbutton, 10);
            	commonMethods.clickWhenVisible(OrderDetailsPage.ConfirmationSentOkbutton, 10);
            	
		}		
	

}
