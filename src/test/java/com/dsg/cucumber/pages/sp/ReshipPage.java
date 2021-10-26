package com.dsg.pages.sp;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class ReshipPage {
    private static final Logger logger = Logger.getLogger(ReshipPage.class);
    
    //Reship - Select Items
    public static By reshipHeader = By.xpath("//*[@class='display-skeleton-header-title']");
    public static By reshipCard = By.xpath("//*[@class='reship-card']");
    public static By cancelReshipCard = By.xpath("//*[text()='Cancel Reship']");
    public static By shipment = By.xpath("//*[@class='shipment-container']");
    public static By SelectItems = By.xpath("//*[2]/div[1 and @class='product-details card-item']/div[1 and @class='card-container line-item']/input[@name='selectItem' and 1 and @type='checkbox']");
    public static By NextStepButton = By.xpath("//*[@class='dsg-button-primary']");
    
    //Choose Shipping
    
    public static By SelectShippingOption = By.xpath("//*[@class='display-skeleton-header-title']");
    public static By ReshipMessage = By.xpath("//*[@class='reship-header-title']");
    public static By EditItems = By.xpath("//*[@class='edit-items']");
    public static By ReshipMethods = By.xpath("//*[@class='select-reship-methods']/*");
    public static By SelectStandardReship = By.xpath("//*[1]/td[@class='shipping-option-input']/input[1]");
    public static By SelectExpressReship = By.xpath("//*[2]/td[@class='shipping-option-input']/input[1]");
    public static By SelectExpeditedReship = By.xpath("//*[3]/td[@class='shipping-option-input']/input[1]");
    public static By Reshipfooter =   By.xpath("//*[@class='reship-footer']/*");
  
    
    //Review Order Reship
    
    public static By ReviewOrder =   By.xpath("//*[@class='reship-header reship-card']");
    public static By ReviewOrderMessage =   By.xpath("//*[@class='reship-header-title']");
    public static By EditShipping =   By.xpath("//*[@class='edit-items']");
    public static By reshipCategoryDropdown =   By.xpath("//*[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']");
    public static By selectReason =   By.xpath("//li[@tabindex='0']");
    public static By IncidentNotes =   By.xpath("//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline MuiOutlinedInput-inputMultiline']");
    
    //Confirm Reship
    
    public static By ConfirmReshipPopup =   By.xpath("//*[text()='Confirm Reship']");
    public static By ConfirmReshipMessage =   By.xpath("//*[text()='Continuing will complete reship and create a new incident.']");
    public static By ReturnToOrder =   By.xpath("//*[text()='RETURN TO ORDER']");
    public static By ConfirmReship =   By.xpath("//*[text()='CONFIRM RESHIP']");
    public static By CloseConfirmReship =   By.xpath("//*[1]/*[1 and @style='float: right;']");
    
}
