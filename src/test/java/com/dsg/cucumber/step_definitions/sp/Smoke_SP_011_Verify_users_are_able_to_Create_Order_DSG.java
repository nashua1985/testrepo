package com.dsg.cucumber.step_definitions.sp;

import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.pages.sp.OrderPlacementDSGPage;
import com.dsg.pages.sp.SolePanelHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class Smoke_SP_011_Verify_users_are_able_to_Create_Order_DSG {
	
	private static final Logger logger = Logger.getLogger(Smoke_SP_011_Verify_users_are_able_to_Create_Order_DSG.class);
	CommonElementMethods commonMethods= new CommonElementMethods();
	private static final Integer timeout = 10;
	private static final String DSG_order_placement_page = "Order Placement";
    private static final String productSearch = "women wear";

		@When("users click on Create an Order in Solepanel DSG link")
		public void click_create_an_Order_DSGlink() throws Exception {
			commonMethods.switch_windows(timeout);
			commonMethods.clickWhenVisible(SolePanelHomePage.closeWelcomeMessage, 5);
			commonMethods.switchToDefault(timeout);

			commonMethods.clickWhenVisible(SolePanelHomePage.createOrdernav,10);
			logger.info("Clicked on Create Order Navigation Bar");
			if(commonMethods.isElementVisible(SolePanelHomePage.createOrderDSG,5))
			{
				commonMethods.clickWhenVisible(SolePanelHomePage.createOrderDSG,10);
				logger.info("Clicked on Create Order DSG Navigation Bar");

			} else 	Assert.fail("DSG Order Placement Link not available");
		}
		  @Then ("users should be navigated to DSG home page")
		  public void DSG_Order_Placement() throws Exception {

			String textFromLocator = commonMethods.getTextFromLocator(OrderPlacementDSGPage.Order_Placement_Page,10);
			  System.out.println(textFromLocator);
			  assertTrue(textFromLocator.equalsIgnoreCase(DSG_order_placement_page));

			  commonMethods.switchToFrame(OrderPlacementDSGPage.iFrame_title, 10);
			  System.out.println("switched to iframe");
//			  BrowserUtilities.promotionHandler();
			}

		  
		  @And ("users should be able to browse,select, add items to cart, place order")
		  public void browse_select_add_to_cart() throws Exception 
		  {
			Thread.sleep(4000);
		  	commonMethods.enterValueWhenVisible(OrderPlacementDSGPage.searchTextBox, productSearch, 10);
//          commonMethods.hoverParentMenuAndClicksChild(OrderPlacementDSGPage.searchTextBox,OrderPlacementDSGPage.searchIcon,10);
          	commonMethods.clickWhenVisible(OrderPlacementDSGPage.searchIcon,10);
          	logger.info("Clicked search");
			Thread.sleep(2000);
	        commonMethods.clickWhenVisible(OrderPlacementDSGPage.firstOccurenceAddToCart,10);
			logger.info("Clicked Add to cart");
			commonMethods.clickWhenVisible(OrderPlacementDSGPage.chooseColor,10);
			logger.info("Color & Size choices selected");
			commonMethods.clickWhenVisible(OrderPlacementDSGPage.chooseSize,10);
			Thread.sleep(1000);
//			commonMethods.hoverParentMenuAndClicksChild(OrderPlacementDSGPage.addToCartParent,OrderPlacementDSGPage.c,10);
			commonMethods.clickWhenVisible(OrderPlacementDSGPage.addToCartfinal,10);
			logger.info("Add to cart Finalised");
			Thread.sleep(1000);
	        commonMethods.clickWhenVisible(OrderPlacementDSGPage.viewCart,10);
			logger.info("Clicked on View Cart");
			Thread.sleep(5000);
	        String DSGOrderNumber = commonMethods.getTextFromLocator(OrderPlacementDSGPage.getCartOrderNumber, 10);
			String DSGOrder_trim = (DSGOrderNumber.substring(7,17));
			logger.info("DSGOrderNumber: "+DSGOrderNumber);
	        commonMethods.switchToDefault(10);
			logger.info("Switched to Default"+SolePanelHomePage.headerDSGNavLink);
			Thread.sleep(2000);
        	String solePanelOrderNumber = commonMethods.getTextFromLocator(OrderPlacementDSGPage.CartOrderNumber, 10);
			String SPOrder_trim=solePanelOrderNumber.substring(11,21);
        	System.out.println("solePanelOrderNumber: "+SPOrder_trim);
			logger.info("DSG Order# "+DSGOrderNumber+" is Updated in Sole Panel Cart Order NUmber"+ SPOrder_trim);
			}

}
