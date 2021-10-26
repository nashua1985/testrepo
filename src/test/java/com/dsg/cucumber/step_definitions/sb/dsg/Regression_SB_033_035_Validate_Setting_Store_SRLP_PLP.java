package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.framework.ElementReadyStatus;
import com.dsg.cucumber.pages.sb.StoreLayerPage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Regression_SB_033_035_Validate_Setting_Store_SRLP_PLP {
    private static final Logger logger = Logger.getLogger(Regression_SB_033_035_Validate_Setting_Store_SRLP_PLP.class);
    private static final Integer timeout = 5;
    CommonElementMethods commonMethods= new CommonElementMethods();
    public static final String INVALID_ZIP_CODE_MESSAGE = "'Please enter a valid ZIP Code'";
    public static final Double milesRange = 100.0;
    @When("we validate store layer zip code:")
    public void we_validate_store_layer_zip_code(List<String> invalidInputs) throws Exception {
        commonMethods.clickWhenVisible(StoreLayerPage.changeStore, timeout);
        for (int i = 0; i < invalidInputs.size(); i++) {
            commonMethods.clearWhenVisible(StoreLayerPage.zipCodeBox);
            commonMethods.enterValueWhenVisible(StoreLayerPage.zipCodeBox, invalidInputs.get(i), timeout);
            commonMethods.clickWhenVisible(StoreLayerPage.zipCodeSubmitBtn, timeout);
            boolean isInvalidZipCodeTextPresent = Base.getDriver().
                    findElement(StoreLayerPage.invalidZipCodeWarningMessage).isDisplayed();
            Assert.assertTrue(isInvalidZipCodeTextPresent);
            logger.info(INVALID_ZIP_CODE_MESSAGE + " is displayed");
        }
    }
        @When("we validate stores within hundred miles {string}")
        public void we_validate_store_layer_zip_code(String zipCode) throws Exception {
//            commonMethods.clickWhenVisible(StoreLayerPage.changeStore, timeout);
            commonMethods.clearWhenVisible(StoreLayerPage.zipCodeBox);
            commonMethods.enterValueWhenVisible(StoreLayerPage.zipCodeBox, zipCode, timeout);
            commonMethods.clickWhenVisible(StoreLayerPage.zipCodeSubmitBtn, timeout);
            Thread.sleep(3000);
            List<WebElement> storeListMiles = Base.getDriver().findElements(By.xpath("//span[@class='store-pickup-store-distance']"));
            int storeCount = storeListMiles.size();
            System.out.println("How many stores: "+storeCount);
            for (int i = 1; i <= storeCount; i++) {
                String text = Base.getDriver().findElement(By.xpath("(//span[@class='store-pickup-store-distance'])["+i+"]")).getText();
                String newText = text.replace("|", "");
                String asd[] = newText.split(" ");
                double dbl = Double.parseDouble(asd[1]);
//                System.out.println(dbl);
                if (dbl <= milesRange) {
                    logger.info("Stores is within the " + milesRange + " miles range");
                } else {
                    Assert.fail("Store is outside " + milesRange + " miles: store position # is " +i);
                }
            }
        }
    @When("we select the store in store layer {string}")
    public void we_select_the_store_in_store_layer(String storeName) throws Exception {
        commonMethods.clickWhenVisible(By.xpath("//span[text()='"+storeName+"']"), timeout);
        commonMethods.clickWhenVisible(StoreLayerPage.setStoreButton, timeout);
        boolean isStoreSet = ElementReadyStatus.elementVisibleAndEnabled(By.xpath("//span[text()='"+storeName+"']"), timeout);
        if(isStoreSet){
            logger.info(storeName+" is SET");
        }else{
            Assert.fail(storeName+" is NOT SET");
        }
    }
    @When("we clear the store and validate it is removed {string}")
    public void we_clear_the_store_and_validate_it_is_removed(String storeName) throws Exception {
        commonMethods.clickWhenVisible(StoreLayerPage.changeStore, timeout);
        commonMethods.clickWhenVisible(StoreLayerPage.clearStoreButton, timeout);
        Thread.sleep(3000);
        commonMethods.clickWhenVisible(StoreLayerPage.setStoreButton, timeout);
        Thread.sleep(5000);
        boolean isStoreSet = ElementReadyStatus.elementVisibleAndEnabled(By.xpath("//span[text()='"+storeName+"']"), timeout);
        boolean isStorePickupText = ElementReadyStatus.elementVisibleAndEnabled(StoreLayerPage.storePickupText, timeout);
        if(isStorePickupText){
            logger.info("the Store is REMOVED");
        }else{
            Assert.fail("The Store is NOT REMOVED");
        }
    }
}