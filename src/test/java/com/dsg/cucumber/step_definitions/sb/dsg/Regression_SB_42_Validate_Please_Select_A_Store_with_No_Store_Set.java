package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.framework.ElementReadyStatus;
import com.dsg.cucumber.pages.sb.StoreLayerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Regression_SB_42_Validate_Please_Select_A_Store_with_No_Store_Set {
    private static final Logger logger = Logger.getLogger(Regression_SB_42_Validate_Please_Select_A_Store_with_No_Store_Set.class);
    private static final Integer timeout = 10;
    public static final String SEE_PRICE_IN_CART = "ADD TO CART";
    private static final String SELECT_STORE_MESSAGE = "No Store Selected";
    private static final String SELECT_STORE_MESSAGE_2 = "Please Select a Store";
    private static final String NOT_AVAILABLE_TO_SHIP_MESSAGE = "Not Available to Ship";

    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we clear all filter and validate shipToMe and BOPIS not available")
    public void we_clear_all_filters_and_validate_shiptome_and_bopis_not_available() throws Exception {
        commonMethods.clickWhenVisible(StoreLayerPage.changeStore, timeout);
        commonMethods.clickWhenVisible(StoreLayerPage.clearStoreButton, timeout);
        commonMethods.clickWhenVisible(StoreLayerPage.setStoreButton, timeout);
        boolean isStorePickupText = ElementReadyStatus.elementVisibleAndEnabled(StoreLayerPage.storePickupText, timeout);
        if (isStorePickupText) {
            logger.info("the Store is REMOVED");
        } else {
            Assert.fail("The Store is NOT REMOVED");
        }
    }

    @And("we should see storePickup not available")
    public void we_should_see_storePickup_not_available() throws Exception {
            List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='dsg-flex flex-column justify-content-center flex-grow-none flex-shrink swatch-container']//img"));
            for (int i = 1; i <= colorList.size(); i++) {
                commonMethods.clickWhenVisible(By.xpath("(//div[@class='dsg-flex flex-column justify-content-center flex-grow-none flex-shrink swatch-container']//img)[" + i + "]"), timeout);
                List<WebElement> sizeList = Base.getDriver().findElements(By.xpath("(//div[@class='dsg-flex flex-row flex-wrap'])[2]//div[@class='value false false' or @class='value selected false']//p"));
                for (int k = 1; k <= sizeList.size(); k++) {
                    commonMethods.clickWhenVisible(By.xpath("((//div[@class='dsg-flex flex-row flex-wrap'])[2]//div[@class='value false false' or @class='value selected false']//p)[" + k + "]"), timeout);
                    boolean isPleaseSelectStore = commonMethods.isElementVisible(By.xpath("//span[text()='" + SELECT_STORE_MESSAGE + "']"), timeout);
                    boolean isNoStoreSelected = commonMethods.isElementVisible(By.xpath("//div[text()='" + SELECT_STORE_MESSAGE_2 + "']"), timeout);
                    if (isPleaseSelectStore) {
                        logger.info(SELECT_STORE_MESSAGE + " is VISIBLE");
                        break;
                    }else if (isNoStoreSelected){
                        logger.info(SELECT_STORE_MESSAGE+" is VISIBLE");
                        break;
                    }else{
                        Assert.fail(SELECT_STORE_MESSAGE+" is NOT VISIBLE");
                    }
                }
                boolean isPleaseSelectStore = commonMethods.isElementVisible(By.xpath("//span[text()='" + SELECT_STORE_MESSAGE + "']"), timeout);
                boolean isNoStoreSelected = commonMethods.isElementVisible(By.xpath("//div[text()='" + SELECT_STORE_MESSAGE_2 + "']"), timeout);
                if (isPleaseSelectStore) {
                    logger.info(SELECT_STORE_MESSAGE + " is VISIBLE");
                    break;
                }else if (isNoStoreSelected){
                    logger.info(SELECT_STORE_MESSAGE+" is VISIBLE");
                    break;
                }
            }
        }
    }


