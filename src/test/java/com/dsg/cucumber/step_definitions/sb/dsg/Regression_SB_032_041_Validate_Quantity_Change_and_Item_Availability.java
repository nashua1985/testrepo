package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.QuickViewPage;
import com.dsg.cucumber.utilities.BrowserUtilities;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.log4j.Logger;

import java.util.List;

public class Regression_SB_032_041_Validate_Quantity_Change_and_Item_Availability {
    private static final Logger logger = Logger.getLogger(Regression_SB_032_041_Validate_Quantity_Change_and_Item_Availability.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @And("we validate availability shipToMe")
    public void validate_availability_ship_to_me() throws Exception {
        List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='dsg-flex flex-column justify-content-center flex-grow-none flex-shrink swatch-container']//img"));
        for (int i = 1; i <= colorList.size(); i++) {
            commonMethods.clickWhenVisible(By.xpath("(//div[@class='dsg-flex flex-column justify-content-center flex-grow-none flex-shrink swatch-container']//img)[" + i + "]"), timeout);
            List<WebElement> sizeList = Base.getDriver().findElements(By.xpath("(//div[@class='dsg-flex flex-row flex-wrap'])[2]//div[@class='value false false' or @class='value selected false']//p"));
            for (int k = 1; k <= sizeList.size(); k++) {
                commonMethods.clickWhenVisible(By.xpath("((//div[@class='dsg-flex flex-row flex-wrap'])[2]//div[@class='value false false' or @class='value selected false']//p)[" + k + "]"), timeout);
                boolean isVisibleShipToMe = commonMethods.isElementVisible(By.xpath("//div[text()='Ship to Me']"), timeout);
                if (isVisibleShipToMe) {
                    logger.info("Ship to Me is VISIBLE For attribute selection(Length, size)");
                    break;
                } else {
                    logger.info("Ship to Me is NOT VISIBLE");
                }
            }
            boolean isVisibleShipToMe = commonMethods.isElementVisible(By.xpath("//div[text()='Ship to Me']"), timeout);
            if (isVisibleShipToMe) {
                logger.info("Ship to Me is VISIBLE For Color Attribute");
                break;
            } else {
                logger.info("Ship to Me is NOT VISIBLE");
            }
        }
    }
    @And("we validate quantity calculation")
    public void validate_quantity_calculation() throws Exception {
        String notFilteredPrice = commonMethods.getTextFromLocator(By.xpath("//span[@class='dsg-react-button-label dsg-flex align-items-center justify-content-center']"), timeout);
        System.out.println(notFilteredPrice);
        double price = BrowserUtilities.getNumberFromCart(notFilteredPrice);
        logger.info("getting price: " + price);
        System.out.println(price);
        commonMethods.clickWhenVisible(QuickViewPage.addQuantityIcon, timeout);
        String notFilteredPriceX2 = commonMethods.getTextFromLocator(By.xpath("//span[@class='dsg-react-button-label dsg-flex align-items-center justify-content-center']"), timeout);
        double priceX2 = BrowserUtilities.getNumberFromCart(notFilteredPriceX2);
        System.out.println(priceX2);
        logger.info("getting price after adding x1 item: " + priceX2);
        if (priceX2 == price * 2) {
            logger.info("one more item is added and calculation is accurate: " + price + " * 2 = " + priceX2);
            System.out.println("one more item is added and calculation is accurate: " + price + " * 2 = " + priceX2);
        } else {
            Assert.fail("Added item calculation is wrong. Should be: " + price * 2 + " But found: " + priceX2);
        }
    }
        @And("we validate quantity calculation on mobile")
        public void validate_quantity_calculation_mobile() throws Exception {
            String notFilteredPrice = commonMethods.getTextFromLocator(By.xpath("//span[@class='dsg-react-button-label dsg-flex align-items-center justify-content-center']"), timeout);
            System.out.println(notFilteredPrice);
            double price = BrowserUtilities.getNumberFromCart(notFilteredPrice);
            logger.info("getting price: "+price);
            System.out.println(price);
            commonMethods.clickWhenVisible(QuickViewPage.addQuantityIconMobile, timeout);
            String notFilteredPriceX2 = commonMethods.getTextFromLocator(By.xpath("//span[@class='dsg-react-button-label dsg-flex align-items-center justify-content-center']"), timeout);
            double priceX2 = BrowserUtilities.getNumberFromCart(notFilteredPriceX2);
            System.out.println(priceX2);
            logger.info("getting price after adding x1 item: "+priceX2);
            if(priceX2 == price*2){
                logger.info("one more item is added and calculation is accurate: "+ price+" * 2 = "+priceX2);
                System.out.println("one more item is added and calculation is accurate: "+ price+" * 2 = "+priceX2);
            }else{
                Assert.fail("Added item calculation is wrong. Should be: "+price*2+" But found: "+priceX2);
            }
    }

}

