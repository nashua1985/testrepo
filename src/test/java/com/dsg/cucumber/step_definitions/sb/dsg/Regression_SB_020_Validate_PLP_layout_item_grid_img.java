package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.framework.ElementReadyStatus;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Regression_SB_020_Validate_PLP_layout_item_grid_img {
    private static final Logger logger = Logger.getLogger(Regression_SB_020_Validate_PLP_layout_item_grid_img.class);
    private static final Integer TIMEOUT = 10;
    public static final String SCROLLING_RATE_JS = "window.scrollBy(0,100)";
    public static final String SCROLLING_JS = "arguments[0].scrollIntoView(false);";
    public static final By totalItemCountLocator = By.xpath("//span[@class='rs-page-count-label']");
    public static final String IMG_LIST_LOCATOR = "//div[@class='card_image']//img[contains(@src, 'https://images.dickssportinggoods.com/is/image/')]";
    public static final By NEXT_ARROW_LOCATOR = By.xpath("//a[@class='rs-page-item rs-next-item ']");

    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we validate plp page layout, image and item count")
    public void we_validate_plp_page_layout_image_itemCount() throws Exception {
        WebElement getCountItemElement = ElementReadyStatus.getWebElementVisible(totalItemCountLocator, TIMEOUT);
        String getText = getCountItemElement.getText();
        int countItem = Integer.parseInt(getText.replaceAll("[^0-9]", ""));
        int totalGridCount = 0;
        boolean flag = true;
        int pageNumber = 2; //pagination starts from having 2nd page
        while (flag) {
            Thread.sleep(2000);
            if (pageNumber == 5) {
                WebElement nextArrow = ElementReadyStatus.getWebElementVisible(NEXT_ARROW_LOCATOR, TIMEOUT);
                ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_JS, nextArrow);//to focus on pagination elements
                commonMethods.clickWhenVisible(nextArrow, TIMEOUT);
                logger.info(NEXT_ARROW_LOCATOR + " is clicked");
            }
            for (int i = 0; i < 120; i++) {//need to scroll down to download all images
                ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_RATE_JS, "");
            }
            List<WebElement> getCountGridItem = Base.getDriver().findElements(By.xpath(IMG_LIST_LOCATOR));
            int countGridItem = getCountGridItem.size();
            logger.info("item count on GRID: " + countGridItem);
            totalGridCount += countGridItem;
            boolean isPagination = commonMethods.isElementVisible(By.xpath("//a[@role='button' and text()=" + pageNumber + "]"), TIMEOUT);
            if (isPagination) {
                WebElement paginationToClick = ElementReadyStatus.getWebElementVisible(By.xpath("//a[@role='button' and text()=" + pageNumber + "]"), TIMEOUT);
                ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_JS, paginationToClick);//to focus on pagination elements
                commonMethods.clickWhenVisible(By.xpath("//a[@role='button' and text()=" + pageNumber + "]"), TIMEOUT);
                pageNumber++;
            } else {
                flag = false;
            }
        }
            if (countItem == totalGridCount) {
                logger.info("Item count matches with Grid count: countItem: " + countItem + " || totalGridCount: " + totalGridCount);
            } else {
                Assert.fail("Item count DOES not match. Expected: " + countItem + " But FOUND: " + totalGridCount);
            }
        }
    }


