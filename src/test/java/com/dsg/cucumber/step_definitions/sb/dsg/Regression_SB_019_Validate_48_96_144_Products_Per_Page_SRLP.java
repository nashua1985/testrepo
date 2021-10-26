package com.dsg.cucumber.step_definitions.sb.dsg;



import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.framework.ElementReadyStatus;
import com.dsg.cucumber.pages.sb.SrlpAndPlpPage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Regression_SB_019_Validate_48_96_144_Products_Per_Page_SRLP {
    private static final Logger logger = Logger.getLogger(Regression_SB_019_Validate_48_96_144_Products_Per_Page_SRLP.class);
    private static final Integer TIMEOUT = 10;
    public static final String IMG_LIST_LOCATOR = "//div[@class='card_image']//img[contains(@src, 'https://images.dickssportinggoods.com/is/image/')]";
    public static final String SCROLLING_JS = "arguments[0].scrollIntoView(false);";
    public static final String SCROLLING_RATE_JS = "window.scrollBy(0,100)";
    public static final String ITEM_NOT_SELECTED_MESSAGE = "view is not selected";
    public static final String GRID_ITEM_COUNT_MESSAGE = "item count on GRID:";
    public static final Integer view48 = 48;
    public static final Integer view96 = 96;
    public static final Integer view144 = 144;


    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we validate srlp-plp page selecting different numbers")
    public void we_validate_srlp_plp_page_selecting_different_numbers() throws Exception {
        List<WebElement> countPinnedItems = Base.getDriver().findElements(SrlpAndPlpPage.pinnedItemsCount);
        if (countPinnedItems.size() != 0) {
            logger.error("Pinned items found. Please search the items with no Pinned Products on Grid");
        } else {
            // 48 View
            boolean is48ViewActive = commonMethods.isElementVisible(SrlpAndPlpPage.active48View, TIMEOUT);
            if (is48ViewActive) {
                for (int i = 0; i < 120; i++) {//need to scroll down to download all images
                    ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_RATE_JS, "");
                }
                List<WebElement> getCountGridItem = Base.getDriver().findElements(By.xpath(IMG_LIST_LOCATOR));
                int countGridItem = getCountGridItem.size();
                logger.info(GRID_ITEM_COUNT_MESSAGE + countGridItem);
//                Assert.assertEquals(countGridItem, (int) view48);
                if(countGridItem == view48 || countGridItem >= view48 && countGridItem <= view48 +5 ||
                        countGridItem <= view48 && countGridItem >= view48 - 5){
                    logger.info("Item count matches with Grid count: countItem: "+countGridItem+" || view48: "+view48);
                }else{
                    Assert.fail("Item count DOES not match. Expected: "+view48+" But FOUND: "+countGridItem);
                }
            } else {
                Assert.fail(view48 + " is not selected by Default");
            }
            //96 View
            WebElement nonActive96View = ElementReadyStatus.getWebElementVisible(SrlpAndPlpPage.nonActive96View, TIMEOUT);
            ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_JS, nonActive96View);//to focus on web elements
            commonMethods.clickWhenVisible(nonActive96View, TIMEOUT);
            boolean is96ViewActive = commonMethods.isElementVisible(SrlpAndPlpPage.active96View, TIMEOUT);
            if (is96ViewActive) {
                for (int i = 0; i < 120*2; i++) {//need to scroll down to download all images
                    ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_RATE_JS, "");
                }
                List<WebElement> getCountGridItem = Base.getDriver().findElements(By.xpath(IMG_LIST_LOCATOR));
                int countGridItem = getCountGridItem.size();
                logger.info(GRID_ITEM_COUNT_MESSAGE + countGridItem);
                if(countGridItem == view96 || countGridItem >= view96 && countGridItem <= view96 +5 ||
                countGridItem <= view96 && countGridItem >= view96 - 5){
                    logger.info("Item count matches with Grid count: countItem: "+countGridItem+" || view48: "+view96);
                }else{
                    Assert.fail("Item count DOES not match. Expected: "+view96+" But FOUND: "+countGridItem);
                }
            } else {
                Assert.fail(view96 + ITEM_NOT_SELECTED_MESSAGE);
            }
            // 144 View
            WebElement nonActive144View = ElementReadyStatus.getWebElementVisible(SrlpAndPlpPage.nonActive144View, TIMEOUT);
            ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_JS, nonActive144View);//to focus on web elements
            commonMethods.clickWhenVisible(nonActive144View, TIMEOUT);
            boolean is144ViewActive = commonMethods.isElementVisible(SrlpAndPlpPage.active144View, TIMEOUT);
            if (is144ViewActive) {
                for (int i = 0; i < 120*3; i++) {//need to scroll down to download all images
                    ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_RATE_JS, "");
                }
                List<WebElement> getCountGridItem = Base.getDriver().findElements(By.xpath(IMG_LIST_LOCATOR));
                int countGridItem = getCountGridItem.size();
                logger.info(GRID_ITEM_COUNT_MESSAGE + countGridItem);
                if(countGridItem == view144 || countGridItem >= view144 && countGridItem <= view144 +5 ||
                        countGridItem <= view144 && countGridItem >= view144 - 5){
                    logger.info("Item count matches with Grid count: countItem: "+countGridItem+" || view48: "+view144);
                }else{
                    Assert.fail("Item count DOES not match. Expected: "+view144+" But FOUND: "+countGridItem);
                }
            } else {
                Assert.fail(view144 + ITEM_NOT_SELECTED_MESSAGE);
            }
        }
    }
}
