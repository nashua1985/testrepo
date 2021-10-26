package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.framework.enums.Browser;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regression_SB_023_Validate_Filter_Removal_PLP {
    private static final Logger logger = Logger.getLogger(Regression_SB_023_Validate_Filter_Removal_PLP.class);
    private static final Integer timeout = 10;
    private static final By firstBrandCheckBox = By.xpath("(//span[text()='Top Brands']/following-sibling::div//span)[1]");
    private static final By getFirstBrandText = By.xpath("(//span[text()='Top Brands']/following-sibling::div/div)[1]");
    private static final By getCountItemElement = By.xpath("//span[@class='rs-page-count-label']");
    private static final By brandWebElement = By.xpath("//div[text()='Brand']");
    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we filter by brand name {string}")
    public void filter_by_brand_name(String brandName) throws Exception {
        int totalBrandNumber = 0;
        String text = "";

        if(!brandName.contains("empty")){
             commonMethods.clickWhenVisible(By.xpath("//div[@alt='"+brandName+"']/span"), timeout);
             Thread.sleep(3000);
             text = commonMethods.getTextFromLocator(By.xpath("//div[@alt='"+brandName+"']"), timeout);
        }else{
            int isBrandVisible = commonMethods.getListSize(firstBrandCheckBox, timeout);
            System.out.println("size _____: "+isBrandVisible);
            if(isBrandVisible == 0){
                commonMethods.clickWhenVisible(brandWebElement, timeout);
            }
            commonMethods.clickWhenVisible(firstBrandCheckBox, timeout);
            Thread.sleep(3000);
            text = commonMethods.getTextFromLocator(getFirstBrandText, timeout);
        }
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(text);
        while(m.find()) {
            totalBrandNumber = Integer.parseInt(m.group(1));
    }
        Thread.sleep(3000);
        String getText = commonMethods.getTextFromLocator(getCountItemElement, timeout);
        int countItem = Integer.parseInt(getText.replaceAll("[^0-9]", ""));
        if(totalBrandNumber == countItem){
            logger.info("Brand total count matches with Item count on grid");
        }else{
            Assert.fail("Brand total count DOES NOT match with Item count on grid. Brand total: "+
                   totalBrandNumber+" | Item count grid: "+countItem);
        }
//        commonMethods.clickWhenVisible(HomePage.clearAllLink, timeout);
        commonMethods.clickWhenVisible(firstBrandCheckBox, timeout);

        Thread.sleep(5000);
        String getTextRefresh = commonMethods.getTextFromLocator(getCountItemElement, timeout);
        int countItemRefresh = Integer.parseInt(getTextRefresh.replaceAll("[^0-9]", ""));
        if(countItemRefresh > totalBrandNumber){
            logger.info("Item count on grid Increased");
        }else{
            Assert.fail("Brand total count less or equal to Item count. Filter may not work. Brand total: "+
                    totalBrandNumber+" | Item count grid: "+countItemRefresh);
        }
    }
}

