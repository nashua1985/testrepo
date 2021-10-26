package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.CategoriesPage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Regression_SB_046_Validate_Hyper_Cat {
    private static final Logger logger = Logger.getLogger(Regression_SB_046_Validate_Hyper_Cat.class);
    private static final Integer timeout = 10;
    private static final By hyperLinksTotal = By.xpath("//div[@class='dsg-react-accordion-body show expansion-details']//a");
    private static final By hyperPageItemTotal = By.xpath("//a[@class='rs_product_description d-block']");

    CommonElementMethods commonMethods = new CommonElementMethods();
    @When("we validate if hyper cat is live")
    public void validate_hyper_link() throws Exception {
        commonMethods.clickWhenVisible(CategoriesPage.hyperCatTextLink, timeout);
        List<WebElement> hyperUrls = Base.getDriver().findElements(hyperLinksTotal);
        if (hyperUrls.size() == 0){
            Assert.fail("Page doesnt have Hyper Urls, please change the family page");
        }
        for(int i = 1; true; i++){
            By webElementHyperUrl = By.xpath("(//div[@class='dsg-react-accordion-body show expansion-details']//a)["+i+"]"); //getting one by one
            commonMethods.clickWhenVisible(webElementHyperUrl, timeout);
            if(commonMethods.isElementVisible(hyperPageItemTotal, timeout)){
                logger.info("Hyper page is FOUND");
                break;
            }else{
                logger.info("Searching for Hyper page: "+ hyperUrls.get(i).toString());
            }
            Assert.fail("Hyper Urls are NOT FOUND");
        }
    }
}


