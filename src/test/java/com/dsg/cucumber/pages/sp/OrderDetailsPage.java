package com.dsg.pages.sp;
import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class OrderDetailsPage {
	  private static final Logger logger = Logger.getLogger(OrderDetailsPage.class);


		public static By orderDetailHeader = By.xpath("//*[@class='display-skeleton-header-title']");

		//Shipping header
	  
	    public static By shippingHeaderOrderDate = By.xpath("//*[@class='shipping-header-order-date']");
	    public static By shippingHeaderOrderNumber = By.xpath("//span[@class='shipping-header-order-id']");
	    public static By pastEDMessage = By.xpath("//*[@class='past-estimated-date']");
	    
	    //Re-ship
	    
	    public static By reshipButton = By.xpath("//*[@class='dsg-button-secondary']");
	    public static By reshipCard = By.xpath("//*[@class='reship-card']");
	    public static By cancelReshipCard = By.xpath("//*[text()='Cancel Reship']");
		
	    //Shipment Details
	    
	    public static By shipmentDetails = By.xpath("//*[@class='shipment-container']");
	    
	    //Athlete Information
	    
	    public static By athleteAddress = By.xpath("//*[@class='athlete-information']");  
	    
	    //Create Order Incident
	    
	    public static By createOrderIncident = By.xpath("//*[text()='CREATE ORDER INCIDENT']");  
	    public static By orderIncidentHeader = By.xpath("//*[@class='display-skeleton-header-title']");  
	    public static By orderIncidentForm = By.xpath("//*[@class='incident-form']");
	    public static By orderIncidentCategoryDropdown = By.xpath("//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']");
	    public static By optionBOPIS = By.xpath("//*[@data-value='BOPIS_ORDER_STATUS']");
	    public static By optionCancelItem = By.xpath("//*[@data-value='CANCELLED_ITEM']");
	    public static By optionCancelOrder = By.xpath("//*[@data-value='CANCELLED_ORDER']");
	    public static By optionInTransit = By.xpath("//*[@data-value='IN_TRANSIT']");
	    public static By optionPreparingForShipment = By.xpath("//*[@data-value='PREPARING_FOR_SHIPMENT']");
	    public static By optionShippedandDelivered = By.xpath("//*[@data-value='SHIPPED_AND_DELIVERED']");
	    public static By optionShippedandLost = By.xpath("//*[@data-value='SHIPPED_AND_LOST']");
	    public static By optionExpertAdvisor = By.xpath("//*[@data-value='EXPERT_ADVISOR']");
	    public static By optionDeniedGTGT = By.xpath("//*[@data-value='DENIED_GTGT']");
	    public static By incidentNotes = By.xpath("//textarea[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline MuiOutlinedInput-inputMultiline']");
	    public static By cancelButton = By.xpath("//*[@class='dsg-button-secondary']");
	    public static By submitButton = By.xpath("//*[@class='dsg-button-primary']");
		public static By successMessage = By.xpath("//h2[@class='MuiTypography-root MuiTypography-h6']");
		public static By okButton = By.xpath("//span[text()='OK']");



	//Adjust Item

		public static By adjustItemHeader = By.xpath("//*[@class='display-skeleton-header-title']");
		public static By adjustItembutton = By.xpath("//*[text()='ADJUST ITEM']");
	    public static By canceladjustItem = By.xpath("//span[text()='Cancel Adjustment']");
	    public static By selectItemsForAdjustments = By.xpath("//div[@class='product-details card-item']//input[@name='selectItem']");
	    public static By nextStep = By.xpath("//*[text()='Next Step']");
		public static By adjustmentFormBody = By.xpath("//form[@class='incident-dropdown-form']");
	    public static By adjustmentCategory = By.xpath("//form[@class='incident-dropdown-form']//div[@id='incident-category']");
		public static By adjustmentCategorySelection =	By.xpath("//li[@tabindex='0']");
	    public static By adjustmentNotes = By.id("incident-notes");
		public static By adjustmentCreditDiv = By.xpath("//div[@class='form-fields']");
	    public static By adjustmentCredit = By.id("credit");
		public static By applyAdjustmentFooter = By.xpath("//div[@class='poa-footer-text']");
		public static By applyAdjustmentNextButton = By.xpath("//button[@class='poa-footer-button']");
		public static By returnToOrderAdjustment = By.xpath("//*[@class='dsg-button-secondary' and text()='RETURN TO ORDER']");
	    public static By completeAdjustment = By.xpath("//*[@class='dsg-button-primary' and text()='COMPLETE ADJUSTMENT']");
	    
	    
	    //Adjust Shipping
	    
	    public static By adjustShippingButton = By.xpath("//*[@class='dsg-button-primary' and text()='ADJUST SHIPPING']");
		public static By adjustShippingHeader = By.xpath("//*[@class='display-skeleton-header-title']");

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
	    
	    
	    // Resend Confirmation
	    
	    public static By resendConfirmationbutton = By.xpath("//*[@class='dsg-button-tertiary'and text()='RESEND CONFIRMATION']");
	    public static By returnToOrder = By.xpath("//*[@class='dsg-button-secondary' and text()='RETURN TO ORDER']");
	    public static By sentToDifferentEmail = By.xpath("//*[@class='email-button-text' and text()='Send to a different email address?']");
	    public static By enterValidEmail = By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input']");
	    public static By confirmResendConfirmationbutton = By.xpath("//*[@class='dsg-button-primary' and text()='RESEND CONFIRMATION']");
	    public static By ConfirmationSentOkbutton = By.xpath("//span[@class='confirmation-modal-ok-button']");
	    
	    
	    
	    
}
