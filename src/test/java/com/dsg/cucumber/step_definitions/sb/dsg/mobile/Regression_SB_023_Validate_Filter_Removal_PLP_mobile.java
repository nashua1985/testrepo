package com.dsg.cucumber.step_definitions.sb.dsg.mobile;


import com.dsg.cucumber.framework.CommonElementMethods;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regression_SB_023_Validate_Filter_Removal_PLP_mobile {
    private static final Logger logger = Logger.getLogger(Regression_SB_023_Validate_Filter_Removal_PLP_mobile.class);
    private static final Integer timeout = 10;

    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we filter by brand name {string} on mobile")
    public void filter_by_brand_name(String brandName) throws Exception {
        commonMethods.clickWhenVisible(By.xpath("//div[@class='rs-filter-text']"),timeout);
        commonMethods.clickWhenVisible(By.xpath("//div[@alt='"+brandName+"']/span"),timeout);
        String getVibeText = commonMethods.getTextFromLocator(By.xpath("//div[@alt='"+brandName+"']"),timeout);
        commonMethods.clickWhenVisible(By.xpath("//span[text()='Apply' or text()='Apply Filters']"),timeout);

        logger.info("Capturing total count of items after filter...");
        String getCountItemElementAfterFilter = commonMethods.getTextFromLocator(By.xpath("//span[@class='rs-page-count-label']"),timeout);
        int countItemAfterFilter = Integer.parseInt(getCountItemElementAfterFilter.replaceAll("[^0-9]", ""));

        logger.info("checking if total number of items match with filtered total...");
        int totalBrandNumber = 0;
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(getVibeText);
        while(m.find()) {
            totalBrandNumber = Integer.parseInt(m.group(1));
        }
        if(totalBrandNumber == countItemAfterFilter){
            logger.info("Brand total count matches with Item count on grid");
        }else{
            Assert.fail("Brand total count DOES NOT match with Item count on grid. Brand total: "+
                    totalBrandNumber+" | Item count grid: "+countItemAfterFilter);
        }
        logger.info("Clearing all filters...");
        commonMethods.clickWhenVisible(By.xpath("//div[@class='rs-filter-text']"),timeout);
        commonMethods.clickWhenVisible(By.xpath("//span[text()='Clear All']"),timeout);
        commonMethods.clickWhenVisible(By.xpath("//span[text()='Apply']"),timeout);
        logger.info("Getting total number of items after filters are removed...");
        String getTextRefresh = commonMethods.getTextFromLocator(By.xpath("//span[@class='rs-page-count-label']"),timeout);
        int countItemRefresh = Integer.parseInt(getTextRefresh.replaceAll("[^0-9]", ""));
        if(countItemRefresh > totalBrandNumber){
            logger.info("Item count on grid Increased");
        }else{
            Assert.fail("Brand total count less or equal to Item count. Filter may not work. Brand total: "+
                    totalBrandNumber+" | Item count grid: "+countItemRefresh);
        }
    }
}

