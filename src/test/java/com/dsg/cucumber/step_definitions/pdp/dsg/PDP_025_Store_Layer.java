package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;


public class PDP_025_Store_Layer {
    private static final Logger logger = Logger.getLogger(PDP_025_Store_Layer.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @And("we uncheck the availability checkbox")
    public void weUncheckTheAvailabilityCheckbox() throws Exception {
        WebElement checkbox= Base.getDriver().findElement(ProductDetailsPage.showStoresCheckbox);
        boolean check=checkbox.isSelected();
        if(check)//un selecting the checkbox
        {
            commonMethods.clickWhenVisible(ProductDetailsPage.showStoresCheckbox,timeout);
        }
    }

    @And("we click store details")
    public void weClickStoreDetails() {
        List<WebElement> storeinfoLink=Base.getDriver().findElements(ProductDetailsPage.linkStoreInfo);
        try {
            commonMethods.clickWhenVisible(storeinfoLink.get(0),timeout);
        } catch (Exception e) {
            Assert.fail();
        }
    }



}
