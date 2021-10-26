package com.dsg.pages.sp;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class OktaHomePage {
	 private static final Logger logger = Logger.getLogger(OktaHomePage.class);
	    
	    //Okta Login
	 
	    public static By oktaUserName = By.xpath("//input[@id='okta-signin-username']");
	    public static By oktapwd = By.xpath("//input[@id='okta-signin-password']");
	    public static By oktasignIn = By.id("okta-signin-submit");
	    public static By solePanelIcon = By.xpath("//a[@href='https://dcsg-hub.okta.com/home/bookmark/0oactaos94zeVJiVM1t7/2557?fromHome=true']");
}
