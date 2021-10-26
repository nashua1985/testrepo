package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP {
    private static final Logger logger = Logger.getLogger(Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP.class);
    private static final Integer timeout = 10;
    public static final String ShipToMeBopisLocator =
            "//div[@class='dsg-flex align-items-center flex-grow-none flex-shrink dsg-rs-shipping-method-filter-container']//button[@class='dsg-rs-method-button selected ']";

    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we filter by brand name {string} and validate clear all function")
    public void filter_by_brand_name(String brandName) throws Exception {
        int totalBrandNumber = 0;
        WebElement brandNameCheckBox = Base.getDriver().findElement(By.xpath("//div[@alt='"+brandName+"']/span"));
        commonMethods.clickWhenVisible(brandNameCheckBox, timeout);
        Thread.sleep(3000);
        WebElement getVibeText = Base.getDriver().findElement(By.xpath("//div[@alt='"+brandName+"']"));
        String text = getVibeText.getText();
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(text);
        while(m.find()) {
            totalBrandNumber = Integer.parseInt(m.group(1));
    }
        WebElement getCountItemElement = Base.getDriver().findElement(By.xpath("//span[@class='rs-page-count-label']"));
        String getText = getCountItemElement.getText();
        int countItem = Integer.parseInt(getText.replaceAll("[^0-9]", ""));
        if(totalBrandNumber == countItem){
            logger.info("Brand total count matches with Item count on grid");
        }else{
            Assert.fail("Brand total count DOES NOT match with Item count on grid. Brand total: "+
                   totalBrandNumber+" | Item count grid: "+countItem);
        }
        commonMethods.clickWhenVisible(HomePage.clearAllLink, timeout);
        Thread.sleep(3000);
        WebElement getCountItemElementRefresh = Base.getDriver().findElement(By.xpath("//span[@class='rs-page-count-label']"));
        String getTextRefresh = getCountItemElementRefresh.getText();
        int countItemRefresh = Integer.parseInt(getTextRefresh.replaceAll("[^0-9]", ""));
        if(countItemRefresh > totalBrandNumber){
            logger.info("Item count on grid Increased");
        }else{
            Assert.fail("Brand total count less or equal to Item count. Filter may not work. Brand total: "+
                    totalBrandNumber+" | Item count grid: "+countItemRefresh);
        }
        //Validating ShipToMe, Bopis unselected
        int getSelected = commonMethods.getListSize(By.xpath(ShipToMeBopisLocator), timeout   );
        if(getSelected != 0){
            Assert.fail("ShipTome and/or BOPIS are still selected");
        }else{
            logger.info("Filters are removed from ShipToMe | BOPIS");
        }

    }
}

