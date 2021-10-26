package com.dsg.cucumber.pages.sb;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class StoreLayerPage {
    private static final Logger logger = Logger.getLogger(StoreLayerPage.class);
    public static By changeStore = By.xpath("//a[text()='Change' or text()='Select']");
    public static By zipCodeBox = By.xpath("//input[@class='store-pickup-zip-input']");
    public static By zipCodeSubmitBtn = By.xpath("//button[@data-testid='storePickupZipCodeSubmit']");
    public static By invalidZipCodeWarningMessage = By.xpath("//span[contains(text(), 'Please enter a valid ZIP Code.')]");
    public static By setStoreButton = By.xpath("//span[text()='Set Store']");
    public static By clearStoreButton = By.xpath("//div[@class='store-pickup-controls']//span[text()='Clear']");
    public static By storePickupText = By.xpath("//div[@class='dsg-flex flex-shrink justify-content-space-between align-items-center dsg-rs-store-options-choose-store']//span[text()='Store Pickup']");


}
