package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PDP_005_ATC_Bike {
    private static final Logger logger = Logger.getLogger(PDP_005_ATC_Bike.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we select the color Matte Black")
    public void select_colorMatteBlack() throws Exception {

        if(commonMethods.isElementVisible(ProductDetailsPage.colorMatteBlack,timeout)){
            commonMethods.clickWhenVisible(ProductDetailsPage.colorMatteBlack, timeout);
        }
        else
        {
            List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
            commonMethods.clickWhenVisible(colorList.get(0), timeout);
        }
    }
    @When("we select the frame size")
    public void select_frameSize3() throws Exception {

        if(commonMethods.isElementVisible(ProductDetailsPage.frameSize3,timeout)){
            commonMethods.clickWhenVisible(ProductDetailsPage.frameSize3, timeout);
        }
        else
        {
            List<WebElement> frameList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
            commonMethods.clickWhenVisible(frameList.get(0), timeout);
        }


        }
}
