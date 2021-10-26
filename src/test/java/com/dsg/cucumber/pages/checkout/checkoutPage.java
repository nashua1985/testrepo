package com.dsg.cucumber.pages.checkout;

import org.openqa.selenium.By;

public class checkoutPage {

    public static By checkOut_title = By.xpath("//title[contains(text(), 'Checkout')]");
    public static By firstname = By.id("firstName");
    public static By lastname = By.id("lastName");
    public static By email = By.id("email");
    public static By phone = By.id("phone");

    public static By streetAdd = By.id("mat-input-5");
    public static By Apt = By.id("mat-input-6");
    public static By zipcode = By.id("mat-input-7");

    public static By EditAddr = By.xpath("//div[@class='col-12 hover-pointer p-0 ng-star-inserted']/a[contains(text(),'Edit')]");
    public static By streetAddEdit = By.xpath("//input[@autocomplete='address-line1']");
    public static By AptEdit = By.xpath("//input[@autocomplete='address-line2']");
    public static By zipcodeEdit = By.xpath("//input[@autocomplete='postal-code']");

    public static By estDelivery = By.xpath("//span[contains(text(),'Est. Delivery')]");
                                    //By.xpath("//class[contains(text(),'ng-trigger-dateUpdate')]")
    public static By standardRadio = By.id("mat-radio-2-input");
    public static By expeditedRadio = By.xpath("//*[@id='mat-radio-3']/label/div");
    public static By expressRadio = By.xpath("//*[@id='mat-radio-4']/label/div");

    public static By continueToPayment = By.xpath("//span[contains(text(),'Continue to Payment')]");

    public static By creditcardNumber = By.xpath("//input[@id='cc-number']");
    public static By expiryDate = By.xpath("//input[@id='cc-exp-date']");
    public static By securityCode = By.id("cc-cvc");

    public static By paypalRadio=By.xpath("//mat-radio-button[@id='paypal_logo']/label/div");
    public static By paypalCheckoutBtn=By.xpath("//button[@aria-label='Check out using PayPal']");
    public static By paypalCheckout=By.xpath("//button[@class='mat-focus-indicator paypal-button p-0 mat-flat-button mat-button-base ng-star-inserted']");
    public static By paypalNext=By.id("btnNext");
    public static By paypalpassword=By.id("password");
    public static By paypalLogin=By.id("btnLogin");
    public static By paypalContinue=By.id("payment-submit-btn");
    public static By addGiftCard=By.xpath("//mat-expansion-panel[@id='giftCardTab']/mat-expansion-panel-header/span[2]");//p[contains(text(),'Add Gift Card')]
    public static By giftcardcode=By.id("gift-card-code");
    public static By giftcardpin=By.id("gift-card-pin");
    public static By applybutton=By.xpath("//button[@class='btn btn-block dcsg-button-secondary w-100 d-flex justify-content-center align-items-center']");
    public static By removeButton=By.xpath("//a[@title='Remove Gift Card']");

    public static By promocode  =By.id("promo-code");
    public static By applyCodebutton=By.xpath("//button[contains(text(),'Apply Code')]");
    public static By placeorderbutton=By.xpath("//span[contains(text(),'PLACE ORDER')]");

    public static By orderNum=By.xpath("//p[contains(text(),'Order#')]");

    public static By solepanelUsername=By.xpath("//input[@id='okta-signin-username']");
    public static By solepanelPassword=By.xpath("//input[@id='okta-signin-password']");
    public static By signIn=By.xpath("//input[@id='okta-signin-submit']");
    public static By lookUpOrder=By.xpath("//span[contains(text(),'Look Up Order')]");
    public static By lookupOrderNum=By.xpath("//input[@id='order-lookup-Order #']");
    public static By searchButton=By.xpath("//button[contains(text(),'SEARCH')]");
    public static By orderDetailBtn=By.xpath("//button[contains(text(),'ORDER DETAILS')]");
    public static By cancelorderBtn=By.xpath("//button[contains(text(),'CANCEL ORDER')]");
    public static By incidentCategory=By.xpath("//div[@id='mui-component-select-category']");
    public static By incidentValue=By.xpath("//li[@data-value='CANCEL_ATHLETE_REQUEST']");
    public static By incidentNotes=By.xpath("//textarea[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline MuiOutlinedInput-inputMultiline']");
    public static By YesCancelBtn=By.xpath("//button[contains(text(),'Yes, CANCEL ORDER')]");

    public static By signInBtn=By.xpath("//a[contains(text(),'Sign In')]");
    public static By signInPass=By.id("signinPass");
    public static By signInSubmitBtn=By.xpath("//button[@id='btn-login']");
    public static By contactInfo=By.xpath("//div/div[@class='sessioncamhidetext col-12']");
    public static By scorecard=By.xpath("//span[@class='score-card-text']");
    public static By scorecardVal=By.id("scorecard");
    public static By addressInfo=By.xpath("//div[@class='col-12 px-0']/p");

    public static By CheckboxSameAdd=By.xpath("//span[text()='My Billing and Shipping are the same']");
    public static By repFirstname=By.id("shipFirstName");
    public static By repLastname=By.id("shipLastName");
    public static By repstreetAddr=By.id("mat-input-11");
    public static By repaptNumber=By.id("mat-input-12");
    public static By repzipcode=By.id("mat-input-13");

    public static By repstreetAddrEdit = By.xpath("//input[@autocomplete='address-line1']");
    public static By repaptNumberEdit = By.xpath("//input[@autocomplete='address-line2']");
    public static By repzipcodeEdit = By.xpath("//input[@autocomplete='postal-code']");
    public static By appliedGiftCard=By.xpath("//div[@class='gift-card ng-star-inserted']");//************2640

    public static By largeitemshipping = By.xpath("//div[contains(text(),'Large Item Shipping Details')]");
    public static By bopisStoreInfo=By.xpath("//div[@class='store-info py-3 px-4 mt-4']");

    public static By dsgLogo=By.xpath("//a[@class='logo header-logo pl-2']");

    public static By deltaTestBtn=By.xpath("//a[@class='base-height dsg-button dsg-button-primary']");
}
