package com.dsg.pages.sp;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class SolePanelHomePage {
   
    //Welcome Message
	
    public static By welcomeMessage = By.xpath("//div[@class='welcome-container']");
    public static By closeWelcomeMessage = By.xpath("(//div[@class='close-icon']//*[name()='svg'])");

    //nav bar
    
    public static By orderlookupnav = By.xpath("//span[text()='Look Up Order']");
    public static By createOrdernav  = By.xpath("//span[text()='Create an Order']");
    public static By createOrderDSG  = By.xpath("//*[@alt='dsg']");
    public static By createOrderGG  = By.xpath("//img[@alt='gg']");
    
    //header tab links
    
    public static By headerDSGNavLink  = By.xpath("//*[@href='https://www.dickssportinggoods.com']/*");
    public static By headerGGNavLink  = By.xpath("//*[@title='Golf Galaxy']");
    public static By headerFnSNavLink  = By.xpath("//*[@title='Field & Stream']");
    public static By headerWhatsNew  = By.xpath("//*[@class='whats-new']");
    public static By gotItButtonWhatsNew  =   By.xpath("//span[text()='GOT IT, THANKS']");
    public static By closeWhatsNew  =   By.xpath("//*[@alt='Close']");
    public static By headerUserInfo  = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text authMenuButton']/span[@class='MuiButton-label' and 1]");
    public static By submitFeedBack  =   By.xpath("//li[@tabindex='0']");
    public static By feedBackBodyCategory  =   By.xpath("//div[@class='incident-form' and 1]//*[@class='MuiFormLabel-root MuiInputLabel-root MuiInputLabel-formControl MuiInputLabel-animated MuiInputLabel-outlined Mui-error Mui-error']");
    public static By categoryDropdown  =   By.xpath("//*[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense']");
    public static By categoryselection  =   By.xpath("//li[@tabindex='-1']");
    public static By submitFeedBackTextBox  =   By.xpath("//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline MuiOutlinedInput-inputMultiline']");
    public static By clearTextBox  =   By.xpath("//*[@class='feedback-buttons']/*[1]");
    public static By submitFeedBackButton  =   By.xpath("//*[@class='feedback-buttons']/*[2]");


    //orderLookupcontainer
    
    public static By orderLookupcontainer = By.xpath("//*[@class='order-lookup']");
    public static By enterOrderNumberSearch = By.xpath("//*[@id='order-lookup-Order #']");
    public static By enterPhoneNumberSearch = By.xpath("//*[@id='order-lookup-Phone Number']");
    public static By submitSearchButton = By.xpath("//button[@class='dsg-button-primary']");
    public static By clearButton = By.xpath("//*[@class='dsg-button-secondary']");
    
    public static By searchByEmailLink = By.xpath("//span[@class='search-by-email']");
    public static By enterEmailId = By.xpath("//input[@id='order-lookup-Email Address']");
  
    
  
    
  
}
