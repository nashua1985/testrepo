package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class PDP_006_ATC_Shoes {
    private static final Logger logger = Logger.getLogger(PDP_006_ATC_Shoes.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();

    @When("we filter by the color Red and the size 11")
    public void filter_colorBlack_sizeMedium() {
        //BrowserUtilities.promotionHandler();
        try {
            if(commonMethods.isElementVisible(HomePage.closePromoWindow,timeout))
            {
                commonMethods.clickWhenVisible(HomePage.closePromoWindow, timeout);
            }
            WebElement colorDropdown = Base.getDriver().findElement(ProductDetailsPage.colorFilter);
            WebElement shoesizeDropdown = Base.getDriver().findElement(ProductDetailsPage.ShoeSizeFilter);

            //check if the filter is expanded or not
            if(commonMethods.isElementVisible(ProductDetailsPage.colorRedShoe,timeout))
            {
                WebElement redCheckbox = Base.getDriver().findElement(ProductDetailsPage.colorRedShoe);
                reg.clickwithJavascript(ProductDetailsPage.colorRedShoe);
            }
            else{
                reg.clickwithJavascript(ProductDetailsPage.colorFilter);
                reg.clickwithJavascript(ProductDetailsPage.colorRedShoe);
            }

            if(commonMethods.isElementVisible(ProductDetailsPage.viewAllSizes,timeout))
            {
                List<WebElement> moreSizes = Base.getDriver().findElements(ProductDetailsPage.viewAllSizes);
                JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", moreSizes.get(0));
                js.executeScript("arguments[0].click();", moreSizes.get(0));


                reg.clickwithJavascript(ProductDetailsPage.ShoeSize11);
                Thread.sleep(3000);
            }
            else{
                commonMethods.clickWhenVisible(shoesizeDropdown, timeout);
                List<WebElement> moreSizes = Base.getDriver().findElements(ProductDetailsPage.viewAllSizes);
                JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", moreSizes.get(0));
                js.executeScript("arguments[0].click();", moreSizes.get(0));

                reg.clickwithJavascript(ProductDetailsPage.ShoeSize11);
                Thread.sleep(3000);
            }

        }
        catch(Exception e)
        {
            logger.info(e.getMessage());
            Assert.fail();
        }
    }
    @When("we select the color Red")
    public void select_colorRed() throws Exception {
        try {
            if(commonMethods.isElementVisible(ProductDetailsPage.colorRed,timeout)){
                WebElement element = Base.getDriver().findElement(ProductDetailsPage.colorRed);
                JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
                js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
                js.executeScript("arguments[0].click();", element);
            }
            else
            {
                List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
                commonMethods.clickWhenVisible(colorList.get(0), timeout);
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }
    @When("we select shoe size 11")
    public void select_shoeSize11() throws Exception {
        try {
            if(commonMethods.isElementVisible(ProductDetailsPage.shoeSize11,timeout)){
                WebElement element = Base.getDriver().findElement(ProductDetailsPage.shoeSize11);
                JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
                js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
                js.executeScript("arguments[0].click();", element);
            }
            else
            {
                List<WebElement> sizeList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
                commonMethods.clickWhenVisible(sizeList.get(0), timeout);
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
