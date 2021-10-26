package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class PDP_004_ATC_Fishing_Rod {
    private static final Logger logger = Logger.getLogger(PDP_004_ATC_Fishing_Rod.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @And("we filter by rod length {string}")
    public void weFilterByRodLength(String arg0) {
        try {
            //commonMethods.clickWhenVisible(ProductDetailsPage.rodLengthDropdown,timeout);
           //div[@aria-labelledby='2147_facet_value_7'0"']/input
            WebElement rodLengthCheckbox = Base.getDriver().findElement(By.xpath("//input[@id='checkbox_2147_27']"));
            JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);",rodLengthCheckbox);
            js.executeScript("arguments[0].style.border='3px solid red'",rodLengthCheckbox);
            js.executeScript("arguments[0].click();", rodLengthCheckbox);
        } catch (Exception e) {
            logger.info(e.getMessage());
            Assert.fail();
        }

    }

    @And("we select the rod length {string} and power {string}")
    public void weSelectTheRodLengthAndPower(String arg0, String arg1) {
        try {
            commonMethods.clickWhenVisible(ProductDetailsPage.rodLength7, timeout);
            //commented the medium selection as the power is being auto selected now by availability
            //commonMethods.clickWhenVisible(ProductDetailsPage.rodPower, timeout);
        } catch (Exception e) {
            logger.info(e.getMessage());
            Assert.fail();
        }
    }


}