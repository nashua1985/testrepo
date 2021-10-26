package com.dsg.cucumber.step_definitions.sp;import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.pages.sp.OrderPlacementDSGPage;
import com.dsg.pages.sp.SolePanelHomePage;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class Smoke_SP_002_Verify_SolePanel_Launch_HomePage_Header_Firefox_Browser {
	   	private static final Logger logger = Logger.getLogger(Smoke_SP_002_Verify_SolePanel_Launch_HomePage_Header_Firefox_Browser.class);
	    private static final Integer timeout = 10;
		private static final String order_lookup_nav = "Look Up Order";
		private static final String create_Order_nav = "Create an Order";
		private static final String create_Order_DSG = "Dick’s Sporting Goods";
		private static final String create_Order_GG = "Golf Galaxy";
		private static final String header_DSG_NavLink = "DICK'S Sporting Goods - Official Site - Every Season Starts at DICK'S";
		private static final String header_GG_NavLink = "Golf Galaxy - Official Website";
		private static final String header_FnS_NavLink = "Field & Stream - Official Website - Where Traditions Begin";
		private static final String header_WhatsNew = "What's New";
		private static final String order_placement_page = "Order Placement";

		CommonElementMethods commonMethods= new CommonElementMethods();
	  
	    
	    @When("users click on Solepanel and Header Links in Sole Panel home page in Firefox Browser")
	    public void verify_homepage_links() throws Exception {
			commonMethods.switch_windows(timeout);
			commonMethods.clickWhenVisible(SolePanelHomePage.closeWelcomeMessage, 5);
			commonMethods.switchToDefault(timeout);

			Map<By, String> navBar = new LinkedHashMap<>();

			navBar.put(SolePanelHomePage.orderlookupnav, order_lookup_nav);
			navBar.put(SolePanelHomePage.createOrdernav, create_Order_nav);
			navBar.put(SolePanelHomePage.headerWhatsNew, header_WhatsNew);
//     		navBar.put(SolePanelHomePage.createOrdernav, headerUserInfo);

			for (Map.Entry<By, String> e : navBar.entrySet())
			{
				if(commonMethods.isElementVisible(e.getKey(), 5))
				{
					String textFromLocator = commonMethods.getTextFromLocator(e.getKey(),10);
					assertTrue(textFromLocator.equalsIgnoreCase(e.getValue()));
				}
			}


			Map<By, String> createOrdernavbar = new LinkedHashMap<>();
			createOrdernavbar.put(SolePanelHomePage.createOrderDSG, create_Order_DSG);
			createOrdernavbar.put(SolePanelHomePage.createOrderGG, create_Order_GG);

			for (Map.Entry<By, String> e : createOrdernavbar.entrySet())
			{
				commonMethods.clickWhenVisible(SolePanelHomePage.createOrdernav,10);
				if(commonMethods.isElementVisible(e.getKey(), 5))
				{
					commonMethods.clickWhenVisible(e.getKey(),10);
					String textFromLocator = commonMethods.getTextFromLocator(OrderPlacementDSGPage.Order_Placement_Page,10);
					System.out.println(textFromLocator);
					assertTrue(textFromLocator.equalsIgnoreCase(order_placement_page));
				}
			}

			Map<By, String> headerlinks = new LinkedHashMap<>();

			headerlinks.put(SolePanelHomePage.headerDSGNavLink, header_DSG_NavLink);
			headerlinks.put(SolePanelHomePage.headerGGNavLink, header_GG_NavLink);
			headerlinks.put(SolePanelHomePage.headerFnSNavLink, header_FnS_NavLink);

			for (Map.Entry<By, String> e : headerlinks.entrySet())
			{
				commonMethods.clickWhenVisible(e.getKey(), timeout);
				ArrayList<String> solepanelwindow = new ArrayList<String> (Base.getDriver().getWindowHandles());
				Base.getDriver().switchTo().window(solepanelwindow.get(2));
				System. out. println(Base.getDriver().getTitle());
				assertTrue(Base.getDriver().getTitle().equalsIgnoreCase(e.getValue()));
				Base.getDriver().close();
				Base.getDriver().switchTo().window(solepanelwindow.get(1));

			}

		}
}