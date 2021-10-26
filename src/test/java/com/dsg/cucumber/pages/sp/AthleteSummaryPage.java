package com.dsg.pages.sp;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class AthleteSummaryPage {
private static final Logger logger = Logger.getLogger(AthleteSummaryPage.class);
    
    //AthleteSummary

    public static By athleteSummaryPage = By.xpath("//span[@class='display-skeleton-header-title']");
    public static By orderInformation = By.xpath("//div[@class='athlete-summary-title']/span[1]");

    //Shipping header
    
    public static By orderDate = By.xpath("//span[@class='athlete-summary-title-order-date']");
    public static By orderNumber = By.xpath("//span[@class='shipping-header-order-id']");
    
    //Order Details
    
    
    public static By orderDetailsButton = By.xpath("//*[@class='dsg-button-secondary']");
    
    //Order Information
    
    public static By trackingNumberLabel = By.xpath("//span[text()='Tracking Number']");
    public static By trackingNumberLink = By.xpath("//a/span[1 and @class='shipment-row-value']");
    public static By shippingStatusLabel = By.xpath("//span[text()='Shipping Status']");        
    public static By shippingStatus = By.xpath("//div[2]/span[2 and @class='shipment-row-value']");
    public static By estimatedDeliveryDateLabel = By.xpath("//span[text()='Estimated Delivery Date']");
    public static By estimatedDeliveryDate = By.xpath("//div[3]/span[2 and @class='shipment-row-value']");
    public static By shipMethodLabel = By.xpath("//span[text()='Ship Method']");
    public static By shipMethod = By.xpath("//div[4]/span[2 and @class='shipment-row-value']");
    public static By orderDateLabel = By.xpath("//span[text()='Order Date']");
    public static By shipmentOrderDate = By.xpath("//div[5]/span[2 and @class='shipment-row-value']");
    
    
    //Athlete Information

    public static By shipmentAddress = By.xpath("//*[@class='address-block']");  
    public static By phoneNumber = By.xpath("//span[5][@class='address-info']");
    public static By emailId = By.xpath("//span[6][@class='address-info']");
    
    

}
