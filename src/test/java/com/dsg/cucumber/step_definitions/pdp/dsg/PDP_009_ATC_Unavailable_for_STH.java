package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.StoreLayerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class PDP_009_ATC_Unavailable_for_STH {
    private static final Logger logger = Logger.getLogger(PDP_009_ATC_Unavailable_for_STH.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();


    @When("we clear filters")
    public void clear_filters() throws Exception {
        try {
            //commonMethods.clickWhenVisible(ProductDetailsPage.clearFilters, timeout);
            Base.getDriver().navigate().refresh();

        } catch (Exception e) {
            Assert.fail();
        }

    }
    @And("we change the store to {string}")
    public void weChangeTheStoreTo(String arg0) {
        try {
            commonMethods.clickWhenVisible(StoreLayerPage.changeStore, timeout);
        commonMethods.clearWhenVisible(StoreLayerPage.zipCodeBox);
        commonMethods.enterValueWhenVisible(StoreLayerPage.zipCodeBox, "15205", timeout);
        commonMethods.clickWhenVisible(StoreLayerPage.zipCodeSubmitBtn, timeout);

        List<WebElement> setStoreRadio=Base.getDriver().findElements(By.xpath("//span[@class='store-pickup-store-select-radio-custom']"));
        commonMethods.clickWhenVisible(setStoreRadio.get(0),timeout);
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", setStoreRadio.get(0));

        commonMethods.clickWhenVisible(StoreLayerPage.setStoreButton, timeout);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @And("click the change store link")
    public void changeTheStoreTo() throws Exception {
        commonMethods.clickWhenVisible(StoreLayerPage.changeStore, timeout);
        commonMethods.clearWhenVisible(StoreLayerPage.zipCodeBox);
        commonMethods.enterValueWhenVisible(StoreLayerPage.zipCodeBox, "15205", timeout);
        commonMethods.clickWhenVisible(StoreLayerPage.zipCodeSubmitBtn, timeout);
        //commonMethods.clickWhenVisible(StoreLayerPage.clearStoreButton, timeout);
        //commonMethods.clickWhenVisible(By.xpath("//span[text()='"+storeName+"']"), timeout);
        commonMethods.clickWhenVisible(StoreLayerPage.setStoreButton, timeout);
        //commonMethods.clickWhenVisible(StoreLayerPage.setStoreButton, timeout);
    }

}

