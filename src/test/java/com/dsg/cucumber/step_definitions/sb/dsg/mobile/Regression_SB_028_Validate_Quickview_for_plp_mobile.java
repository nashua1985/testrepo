package com.dsg.cucumber.step_definitions.sb.dsg.mobile;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.SrlpAndPlpPage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Regression_SB_028_Validate_Quickview_for_plp_mobile {
    private static final Logger logger = Logger.getLogger(Regression_SB_028_Validate_Quickview_for_plp_mobile.class);
    private static final Integer timeout = 10;

    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we validate addToCart quick view by filtering {string} on mobile")
    public void validate_quick_view(String brandName) throws Exception {
        commonMethods.clickWhenVisible(By.xpath("//div[@class='rs-filter-text']"),timeout);
        commonMethods.clickWhenVisible(By.xpath("//div[@alt='"+brandName+"']/span"),timeout);
        String getVibeText = commonMethods.getTextFromLocator(By.xpath("//div[@alt='"+brandName+"']"),timeout);
        commonMethods.clickWhenVisible(By.xpath("//span[text()='Apply']"),timeout);

        logger.info("Capturing total count of items after filter...");
        String getCountItemElementAfterFilter = commonMethods.getTextFromLocator(By.xpath("//span[@class='rs-page-count-label']"),timeout);
        int countItemAfterFilter = Integer.parseInt(getCountItemElementAfterFilter.replaceAll("[^0-9]", ""));

        List<WebElement> countAddToCart = Base.getDriver().findElements(SrlpAndPlpPage.addToCartButton);
        int countTotalAddToCart = countAddToCart.size();
        if(countItemAfterFilter == countTotalAddToCart){
            logger.info("All items have 'AddToCart Button' ");
        }else{
            Assert.fail("AddToCart Button MAY BE MISSING"+".: Total Items: "+
                    countItemAfterFilter+" | Items having AddToCart button "+countTotalAddToCart);
        }
    }
}

