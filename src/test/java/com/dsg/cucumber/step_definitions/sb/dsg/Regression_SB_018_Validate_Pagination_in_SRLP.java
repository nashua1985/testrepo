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

public class Regression_SB_018_Validate_Pagination_in_SRLP {
    private static final Logger logger = Logger.getLogger(Regression_SB_018_Validate_Pagination_in_SRLP.class);
    private static final Integer TIMEOUT = 10;
    public static final By paginationNumber = By.xpath("//div[@class='rs-page-item-bubble ']");
    public static final String SCROLLING_JS = "arguments[0].scrollIntoView(false);";
    public static final String NEXT_ARROW_LOCATOR = "//a[@class='rs-page-item rs-next-item ' or @class='dsg-flex flex-column rs-page-item rs-next-item']";
    public static final String PREV_ARROW_LOCATOR = "//a[@class='rs-page-item rs-prev-item']";

    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we validate pagination on SRLP-PLP by clicking page numbers")
    public void we_validate_srlp_plp_pagination_by_clicking_page_numbers() throws Exception {
        int getPaginationCount = commonMethods.getListSize(paginationNumber, TIMEOUT);
        if (getPaginationCount > 0) {
            for (int i = 2, k = 0; k <= getPaginationCount; i++, k++) {
                boolean isPagination = commonMethods.isElementVisible(By.xpath("//a[@role='button' and text()=" + i + "]"), TIMEOUT);
                if (isPagination) {
                    WebElement paginationToClick = ElementReadyStatus.getWebElementVisible(By.xpath("//a[@role='button' and text()=" + i + "]"), TIMEOUT);
                    ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_JS, paginationToClick);//to focus on pagination elements
                    Thread.sleep(500);
                    commonMethods.clickWhenVisible(By.xpath("//a[@role='button' and text()=" + i + "]"), TIMEOUT);
                    boolean isOnActivePage = commonMethods.isElementVisible(By.xpath("//a[@role='button' and text()=" + i + "]"), TIMEOUT);
                    if (isOnActivePage) {
                        logger.info("Page: " + i + " is active");
                    } else {
                        Assert.fail("Page clicked: " + i + " is not active");
                    }
                }
            }
        }else{
            logger.info("Only 1 page is displayed");
        }
    }
    @When("we validate pagination on SRLP-PLP by clicking arrows")
    public void we_validate_srlp_plp_pagination_by_clicking_arrows() throws Exception {
        int getPaginationCount = commonMethods.getListSize(paginationNumber, TIMEOUT);
        System.out.println("PageCount: "+getPaginationCount);
        int nextPage= 2;
        int previousPage = 1;
        if(getPaginationCount>0){
            System.out.println("if block");
            WebElement paginationToClick = ElementReadyStatus.getWebElementVisible(By.xpath("//a[@role='button' and text()='1']"), TIMEOUT);
            ((JavascriptExecutor) Base.getDriver()).executeScript(SCROLLING_JS, paginationToClick);//to focus on pagination elements
            Thread.sleep(500);
            commonMethods.clickWhenVisible(By.xpath(NEXT_ARROW_LOCATOR), TIMEOUT);
        }else{
            logger.info("Only 1 page is displayed");
        }
        boolean isOnActivePage = commonMethods.isElementVisible(By.xpath("//a[@class='active rs-page-item' and text()=" + nextPage + " or @role='button' and text()="+nextPage+"]"), TIMEOUT);
        if (isOnActivePage) {
            logger.info("Page: " + nextPage + " is active");
        } else {
            Assert.fail("Page clicked: " + nextPage + " is not active");
        }
        commonMethods.clickWhenVisible(By.xpath(PREV_ARROW_LOCATOR), TIMEOUT);
        boolean isOnActivePageAfterPreviousClick = commonMethods.isElementVisible(By.xpath("//a[@class='active rs-page-item' and text()=" + nextPage + " or @role='button' and text()="+previousPage+"]"), TIMEOUT);
        if (isOnActivePageAfterPreviousClick) {
            logger.info("Page: " + previousPage + " is active");
        } else {
            Assert.fail("Page clicked: " + previousPage + " is not active");
        }
    }
}

