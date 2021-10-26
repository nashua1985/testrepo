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

public class Regression_SB_011_Validate_SRLP_layout_item_grid_img {
    private static final Logger logger = Logger.getLogger(Regression_SB_011_Validate_SRLP_layout_item_grid_img.class);
    private static final Integer timeout = 10;
    public static final By totalItemCountLocator = By.xpath("//span[@class='rs-page-count-label']");
    public static final By nextPageArrow = By.xpath("//a[@class='rs-page-item rs-next-item ' or @class='dsg-flex flex-column rs-page-item rs-next-item']");
    public static final String IMG_LIST_LOCATOR = "//div[@class='card_image']//img[contains(@src, 'https://images.dickssportinggoods.com/is/image/')]";
    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we validate srlp page layout, image and item count")
    public void we_validate_srlp_page_layout_image_itemCount() throws Exception {
        WebElement getCountItemElement = ElementReadyStatus.getWebElementVisible(totalItemCountLocator, timeout);
        String getText = getCountItemElement.getText();
        int countItem = Integer.parseInt(getText.replaceAll("[^0-9]", ""));
        int totalGridCount = 0;
        boolean flag = true;
        int pageNumber = 2; //pagination starts from having 2nd page
        while(flag) {
            Thread.sleep(2000);
            for (int i = 0; i < 40; i++) {//need to scroll down to download all images
                ((JavascriptExecutor) Base.getDriver()).executeScript("window.scrollBy(0,300)", "");
            }
            List<WebElement> getCountGridItem = Base.getDriver().findElements(By.xpath(IMG_LIST_LOCATOR));
            int countGridItem = getCountGridItem.size();
            logger.info("item count on GRID: " + countGridItem);
            totalGridCount += countGridItem;
            boolean isPagination = commonMethods.isElementVisible(nextPageArrow, timeout);
                if(isPagination){
                WebElement paginationToClick = ElementReadyStatus.getWebElementVisible(nextPageArrow, timeout);
                ((JavascriptExecutor) Base.getDriver()).executeScript("arguments[0].scrollIntoView(false);", paginationToClick);//to focus on pagination elements
                Thread.sleep(500);
                commonMethods.clickWhenVisible(nextPageArrow, timeout);
//                pageNumber++;
            }else{
                flag = false;
            }
        }
        if(countItem == totalGridCount || countItem == totalGridCount + 5 || countItem == totalGridCount - 5 ){
            logger.info("Item count matches with Grid count: countItem: "+countItem+" || totalGridCount: "+totalGridCount);
        }else{
            Assert.fail("Item count DOES not match. Expected: "+countItem+" But FOUND: "+totalGridCount);
        }
    }
}