package com.dsg.cucumber.step_definitions.athlete;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class Regression_ATHLETE_006_My_store_validation {
    private static final Logger logger = Logger.getLogger(Regression_ATHLETE_006_My_store_validation.class);
    private static final Integer timeout = 10;
    protected static final By searchAddressField = By.id("search_address");
    protected static final By searchAddressBtn = By.id("search_button");
    protected static final By googleMapIframe = By.id("dsg_stores");
    protected static final By getDirectionFrame = By.xpath("//iframe[@aria-hidden='true']");
    protected static final By getDirectionFirstOccur =
            By.xpath("(//div[@id='panel']//span[text()='Get Directions'])[1]");
    protected static final By googleMapSubmitBnt =
            By.xpath("(//input[@data-gaact='Click_to_BubbleDirectionsGo'])[4]");
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we click on findMyStore")
    public void we_click_on_find_my_store() throws Exception {
        commonMethods.clickWhenVisible(HomePage.findStoreLink, timeout);
    }

    @When("we validate Athlete is able to select store")
    public void we_validate_athlete_is_able_to_select_store(Map<String, String> storeSet) throws Exception {
//        List<WebElement> f = Base.getDriver().findElements(By.tagName("iframe"));
//        logger.info("Total number " + f.size());

        commonMethods.switchToFrame(googleMapIframe, timeout);
        for (Map.Entry<String, String> getStoreSet : storeSet.entrySet()) {
            commonMethods.clearWhenVisible(searchAddressField);
            commonMethods.enterValueWhenVisible(searchAddressField, getStoreSet.getKey(), timeout);
//            Thread.sleep(3000);
            commonMethods.clickWhenVisible(searchAddressBtn, timeout);
            Thread.sleep(5000);
            WebElement storeName = Base.getDriver().findElement(By.xpath("//div[text()='" + getStoreSet.getValue() + "']"));
            commonMethods.clickWhenVisible(storeName, timeout);
        }
    }

    @When("we validate Get Directions does not 404 takes user to google maps")
    public void we_validate_no_404() throws Exception {
//        commonMethods.switchToFrame(googleMapIframe, timeout);
        commonMethods.clickWhenVisible(getDirectionFirstOccur, timeout);//first occurrence of Get Direction
        commonMethods.switchToDefault(timeout);
        List<WebElement> f = Base.getDriver().findElements(By.tagName("frame"));
        logger.info("Total number " + f.size());

        boolean isVisible = commonMethods.isElementVisible(getDirectionFirstOccur, timeout);
        if (isVisible) {
            logger.info("Map Direction works");
        } else {
            Assert.fail("Map Direction might not work");
        }
    }
}
