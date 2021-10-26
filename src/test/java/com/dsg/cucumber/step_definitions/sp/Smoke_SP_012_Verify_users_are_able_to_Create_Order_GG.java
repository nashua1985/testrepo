package com.dsg.cucumber.step_definitions.sp;

import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.pages.sp.OrderPlacementGGPage;
import com.dsg.pages.sp.SolePanelHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class Smoke_SP_012_Verify_users_are_able_to_Create_Order_GG {
	
	private static final Logger logger = Logger.getLogger(Smoke_SP_012_Verify_users_are_able_to_Create_Order_GG.class);
	
	CommonElementMethods commonMethods= new CommonElementMethods();
	private static final Integer timeout = 10;
	private static final String GG_order_placement_page = "Order Placement";
	private static final String productSearchGG = "Glove";


		@When("users click on Create an Order in Solepanel GG link")
		public void click_create_an_Order_GGlink() throws Exception {

			commonMethods.switch_windows(timeout);
			commonMethods.clickWhenVisible(SolePanelHomePage.closeWelcomeMessage, 5);
			commonMethods.switchToDefault(timeout);

			commonMethods.clickWhenVisible(SolePanelHomePage.createOrdernav,10);
			logger.info("Clicked on Create Order Navigation Bar");
			if(commonMethods.isElementVisible(SolePanelHomePage.createOrderGG,5))
			{
				commonMethods.clickWhenVisible(SolePanelHomePage.createOrderGG,10);
				logger.info("Clicked on Create Order GG Navigation Bar");

			} else 	Assert.fail("Golf Galaxy Order Placement Link not available");
		}
		  @Then ("users should be navigated to GG home page")
		  public void GG_Order_Placement() throws Exception 
		  {
			  String textFromLocator = commonMethods.getTextFromLocator(OrderPlacementGGPage.GG_Order_Placement_Page,10);
			  System.out.println(textFromLocator);
			  assertTrue(textFromLocator.equalsIgnoreCase(GG_order_placement_page));

			  commonMethods.switchToFrame(OrderPlacementGGPage.iFrame_title, 10);
			  System.out.println("switched to iframe");
//			  BrowserUtilities.promotionHandler();
		  }

		  @And("users should be able to browse,select, add items to cart, place order in Golf Galaxy")
		  public void browse_select_add_to_cart() throws Exception 
		  {
		  	Thread.sleep(2000);

          commonMethods.enterValueWhenVisible(OrderPlacementGGPage.searchTextBox, productSearchGG, 10);
			logger.info("Entering Product Search");
          commonMethods.clickWhenVisible(OrderPlacementGGPage.searchIcon,10);
			Thread.sleep(3000);
          commonMethods.clickWhenVisible(OrderPlacementGGPage.chooseProduct,10);
//          commonMethods.clickWhenVisible(OrderPlacementGGPage.chooseColor,10);
//          commonMethods.clickWhenVisible(OrderPlacementGGPage.chooseSize,10);
          commonMethods.clickWhenVisible(OrderPlacementGGPage.addToCart,10);
			  Thread.sleep(2000);
			  commonMethods.clickWhenVisible(OrderPlacementGGPage.goToCart,10);
			  Thread.sleep(5000);
          String GGOrderNumber = commonMethods.getTextFromLocator(OrderPlacementGGPage.getCartOrderNumber, 10);
			  Thread.sleep(5000);
          commonMethods.switchToDefault(10);
			  Thread.sleep(3000);
          String solePanelOrderNumber = commonMethods.getTextFromLocator(OrderPlacementGGPage.CartOrderNumber, 10);

		  logger.info("DSG Order# "+GGOrderNumber+" is Updated in Sole Panel Cart Order NUmber"+ solePanelOrderNumber);


		  }

}
