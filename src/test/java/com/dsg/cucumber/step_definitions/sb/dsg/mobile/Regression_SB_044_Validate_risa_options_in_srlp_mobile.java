package com.dsg.cucumber.step_definitions.sb.dsg.mobile;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.cucumber.pages.sb.SrlpAndPlpPage;
import com.dsg.cucumber.pages.sb.StoreLayerPage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Regression_SB_044_Validate_risa_options_in_srlp_mobile {
    private static final Logger logger = Logger.getLogger(Regression_SB_044_Validate_risa_options_in_srlp_mobile.class);
    private static final Integer timeout = 10;
    private static final String NOT_AVAILABLE_TO_SHIP_MESSAGE = "Not Available to Ship";
    private static final String IMG_LIST_LOCATOR = "//div[@class='card_image']//img[contains(@src, 'https://images.dickssportinggoods.com/is/image/')]";
    private static final String SHIPPING_AVAILABLE = "Shipping Available";
    public static final String LIMITED_STOCK_TO_SHIP = "Limited Stock to Ship";
    private static final String NOT_AVAILABLE_TO_PICKUP = "Not Available to Pickup";
    private static final String IN_NEARBY_STORES = "In Nearby Stores";
    private static final String FREE_PICKUP = "Free Pickup Available";
    public static final String LIMITED_STOCK_TO_PICKUP = "Limited Stock to Pickup";
    public static final String SHIP_TO_ME_ASSERTION_MSG ="ShipToMe option count works incorrectly. Check the Risa option Ship To Me";
    public static final String IN_STORE_ASSERTION_MSG = "In Store Option count works incorrectly. Check the Risa option In Store";
    public static final String SCROLLING_RATE_JS = "window.scrollBy(0,500)";
    public static final String SCROLLING_RATE_JS_UP = "window.scrollBy(0,-500)";

    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we validate if risa options are displayed correctly in mobile")
    public void we_clear_all_filters_and_validate_shiptome_and_bopis_not_available_mobile() throws Exception {
        Base.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        boolean isClearAll = commonMethods.isElementVisible(HomePage.clearAllLink, timeout);
        if(isClearAll){
            commonMethods.clickWhenVisible(HomePage.clearAllLink,timeout);
        }
        //1. Ship To Me option is checked. Other stores may have shipToMe checked by default. Add logic later
        commonMethods.clickWhenVisible(SrlpAndPlpPage.shipToMeOption, timeout);
        // getting count of all items sorted by ShipToMe
        for (int i = 0; i < 60; i++) {//need to scroll down for the items to be downloaded
            ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_RATE_JS, "");
        }
        List<WebElement> getCountGridItem = Base.getDriver().findElements(By.xpath(IMG_LIST_LOCATOR));
        int countGridItem = getCountGridItem.size();
        logger.info("item count on GRID: " + countGridItem);
        // checking every item if 2 options are present: Shipping Available or Limited Stock to Ship
        List<WebElement> getShipToMeOptionCount =
                Base.getDriver().findElements(By.xpath("//span[text()='"+SHIPPING_AVAILABLE+"' or text()='"+LIMITED_STOCK_TO_SHIP+"']"));
        int countShipToMeOption = getShipToMeOptionCount.size();
        logger.info("item count with ShipToMe and Limited Stock to Ship: " + countShipToMeOption);
        if (countGridItem != countShipToMeOption) {
            Assert.fail(SHIP_TO_ME_ASSERTION_MSG);
            }else{
            logger.info("ShipToMe option works correctly");
            }
        //2. Reset. Clear and set In Store option.
        for (int i = 0; i < 60; i++) {//need to scroll up to see facets
            ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_RATE_JS_UP, "");
        }
        boolean getShipToMeElement = commonMethods.isElementVisible(SrlpAndPlpPage.shipToMeOption, timeout);
        if(getShipToMeElement){
            commonMethods.clickWhenVisible(SrlpAndPlpPage.shipToMeOption, timeout);
        }else{
            commonMethods.clickWhenVisible(HomePage.clearAllLink,timeout);
        }
        commonMethods.clickWhenVisible(SrlpAndPlpPage.inStoreOption, timeout);

        // getting count of all items sorted by In Store Option
        for (int i = 0; i < 60; i++) {//need to scroll down to download all images
            ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_RATE_JS, "");
        }
        List<WebElement> getCountGridItemInStoreOption = Base.getDriver().findElements(By.xpath(IMG_LIST_LOCATOR));
        int countGridItemInStore = getCountGridItemInStoreOption.size();
        logger.info("item count on GRID: " + countGridItemInStore);
        List<WebElement> getInStoreOption =
                Base.getDriver().findElements(By.xpath("//span[text()='"+LIMITED_STOCK_TO_PICKUP+"' or text()='"+FREE_PICKUP+"']"));
        int countInStoreOption = getInStoreOption.size();
        logger.info("item count with In Store Option and Free Pickup: " + countInStoreOption);
        if (countGridItemInStore != countInStoreOption) {
            Assert.fail(IN_STORE_ASSERTION_MSG);
        }else{
            logger.info("In Store Option works correctly");
            }
        }
    }


