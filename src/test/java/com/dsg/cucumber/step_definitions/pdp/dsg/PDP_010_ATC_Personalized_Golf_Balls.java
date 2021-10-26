package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class PDP_010_ATC_Personalized_Golf_Balls {
    private static final Logger logger = Logger.getLogger(PDP_010_ATC_Personalized_Golf_Balls.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();

    /*@When("we type {string} in Text Line One")
    public void enter_textLine1(String text1) throws Exception {
        commonMethods.enterValueWhenVisible(ProductDetailsPage.textLine1,text1,timeout);
    }

    @When("we type {string} in Text Line Two")
    public void enter_textLine2(String text2) throws Exception {
        commonMethods.enterValueWhenVisible(ProductDetailsPage.textLine2,text2,timeout);
    }
    @When("we type {string} in Text Line Three")
    public void enter_textLine3(String text3) throws Exception {
        commonMethods.enterValueWhenVisible(ProductDetailsPage.textLine3,text3,timeout);
    }*/


    @And("I write  {string} with {string} and {string} and {string}")
    public void iWriteWithAndAnd(String arg0, String arg1, String arg2, String arg3) {
        try {
            commonMethods.enterValueWhenVisible(ProductDetailsPage.textLine1,arg0,timeout);
            Thread.sleep(3);
            commonMethods.enterValueWhenVisible(ProductDetailsPage.textLine2,arg1,timeout);
            Thread.sleep(3);
            commonMethods.enterValueWhenVisible(ProductDetailsPage.textLine3,arg2,timeout);
            if(commonMethods.isElementVisible(ProductDetailsPage.personalizationNum,timeout)){
                commonMethods.enterValueWhenVisible(ProductDetailsPage.personalizationNum,arg3,timeout);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @And("we click the details section")
    public void weClickTheDetailsSection() {
        try {
            reg.clickwithJavascript(ProductDetailsPage.detail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("we should see detail {string}")
    public void weShouldSeeDetail(String text) throws Exception {
        boolean isTextVisible = commonMethods.isElementVisible(By.xpath("//span[contains(text(), \"" + text + "\")]"), timeout);
        if (!isTextVisible) {
            Assert.fail(text + " is not VISIBLE");
        }
        WebElement element = Base.getDriver().findElement(By.xpath("//span[contains(text(), \"" + text + "\")]"));
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }

}



