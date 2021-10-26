package com.dsg.cucumber.step_definitions.athlete;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.CategoriesPage;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.cucumber.pages.sb.QuickViewPage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.Key;
import java.util.*;

import static org.testng.Assert.assertTrue;

public class Regression_ATHLETE_004_Cart_page_and_cart_count {
    private static final Logger logger = Logger.getLogger(Regression_ATHLETE_004_Cart_page_and_cart_count.class);
    private static final Integer timeout = 10;
    private static final By colorList = By.xpath("//div[@class='dsg-flex flex-column justify-content-center flex-grow-none flex-shrink swatch-container']//img");
    private static final By sizeList = By.xpath("(//div[@class='dsg-flex flex-row flex-wrap'])[2]//div[@class='value false false' or @class='value selected false']//p");
    private static final By viewCartBtn = By.xpath("//span[contains(text(), 'View Cart')]");
    private static final By itemImgGrid = By.xpath("//img[contains(@src, '//dks.scene7.com/is/image/')]");
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we login to test account")
    public void we_login_to_test_account(Map<String,String> credentials) throws Exception {
        for(Map.Entry<String, String> getCredentials: credentials.entrySet()){
            commonMethods.clickWhenVisible(HomePage.signInHomePage, timeout);
            commonMethods.enterValueWhenVisible(HomePage.emailLoginBox, getCredentials.getKey(), timeout);
            commonMethods.enterValueWhenVisible(HomePage.pswdLoginBox, getCredentials.getValue(), timeout);
            Thread.sleep(5000);
            commonMethods.clickWhenVisible(HomePage.signInBtn, timeout);
        }
    }
    @When("we add the item to the cart and should see cart count_page")
    public void we_add_the_item_to_the_cart_and_should_see_cart_count() throws Exception {
        String getOrderQuantity = commonMethods.getTextFromLocator(HomePage.itemQuantityOnCart, timeout);
        int getOriginalNumberFromOrderQuantity = Integer.parseInt(getOrderQuantity);
        Thread.sleep(5000);
        commonMethods.clickWhenVisible(QuickViewPage.firstOccurenceAddToCart, timeout); //adding first possible item
        Thread.sleep(5000);
        //getting atribute selection resolved
        List<WebElement> getColorList = Base.getDriver().findElements(colorList);
        List<WebElement> getSizeList = Base.getDriver().findElements(sizeList);
        if(getColorList.size() > 1){ //if multiple color attributes, choose the 1st one
            logger.info("There are "+getColorList.size()+" color attributes.");
            commonMethods.clickWhenVisible(By.xpath("(//div[@class='dsg-flex flex-column justify-content-center flex-grow-none flex-shrink swatch-container']//img)[1]"), timeout);
        }else{
            //otherwise its auto-selected
            logger.info("just 1 color attribute found: "+getColorList.size());
        }
        if(getSizeList.size() > 1){
            logger.info("There are "+getSizeList.size()+" size attributes.");
            commonMethods.clickWhenVisible(By.xpath("((//div[@class='dsg-flex flex-row flex-wrap'])[2]//div[@class='value false false' or @class='value selected false']//p)[1]"), timeout);
        }else{
            logger.info("just 1 size attribute found: "+getSizeList.size());
            //otherwise its auto-selected
        }
        commonMethods.clickWhenVisible(QuickViewPage.addToCart, timeout);
        commonMethods.clickWhenVisible(viewCartBtn, timeout);
        Thread.sleep(5000);
        int itemsAdded = getOriginalNumberFromOrderQuantity + 1;
        //getting updated quantity on Cart circle
        String getUpdatedOrderQuantity = commonMethods.getTextFromLocator(HomePage.itemQuantityOnCart, timeout);
        int getUpdatedNumberFromOrderQuantity = Integer.parseInt(getUpdatedOrderQuantity);
        if(itemsAdded == getUpdatedNumberFromOrderQuantity){
            logger.info("Item count was successfully updated on cart circle");
        }else{
            Assert.fail("Item count on circle maybe not working. Expected quantity: "
                    + itemsAdded + " .But found: "
                    + getUpdatedOrderQuantity);
        }
        List<WebElement> getItemImgGridCount = Base.getDriver().findElements(itemImgGrid);
        if(getItemImgGridCount.size() >= 1){
            logger.info("Items are present at Cart Page. Found: "+ getItemImgGridCount.size());
        }else{
            Assert.fail("Items are missing at Cart Page. Found: "+getItemImgGridCount.size());
        }

    }
}