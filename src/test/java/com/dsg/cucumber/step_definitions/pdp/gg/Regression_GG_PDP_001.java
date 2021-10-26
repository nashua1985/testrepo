package com.dsg.cucumber.step_definitions.pdp.gg;
import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
import com.dsg.testng.web.resources.WebNavigation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Regression_GG_PDP_001 {
    private static final Logger logger = Logger.getLogger(Regression_GG_PDP_001.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg = new PDP_001_ATC_Yeti();
    WebNavigation nav;


    @And("we select Flex")
    public void select_flex9() {
        WebElement flex = Base.getDriver().findElement(By.id("block-swatch_Flex_1"));
        WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(flex));
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", flex);
        js.executeScript("arguments[0].click();", flex);
        flex.click();
    }

    @And("we select Hand")
    public void select_rightHand() {
        WebElement rightHand = Base.getDriver().findElement(By.id("block-swatch_Hand_0"));
        WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(rightHand));
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", rightHand);
        js.executeScript("arguments[0].click();", rightHand);
        rightHand.click();
    }

    @And("we select Loft")
    public void select_ggLoft9() {
        WebElement loft = Base.getDriver().findElement(By.id("block-swatch_Loft_0"));
        WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(loft));
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", loft);
        js.executeScript("arguments[0].click();", loft);
        loft.click();
    }


    @And("we select any available Shaft")
    public void select_availableShaft() {
        WebElement shaft = Base.getDriver().findElement(By.xpath("//div[@class='btn-attr-select block-attr ng-star-inserted']"));
        WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(shaft));
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", shaft);
        js.executeScript("arguments[0].click();", shaft);
        shaft.click();
    }

    @When("we select the color Chrome")
    public void select_colorNavy() {
        WebElement chrome = Base.getDriver().findElement(ProductDetailsPage.colorChrome);
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", chrome);
        js.executeScript("arguments[0].click();", chrome);
        chrome.click();
    }

    @When("we filter by the color Black and the size 9")
    public void filter_colorBlack_size9() {
        //BrowserUtilities.promotionHandler();
        try {
            if (commonMethods.isElementVisible(HomePage.closePromoWindow, timeout)) {
                commonMethods.clickWhenVisible(HomePage.closePromoWindow, timeout);
            }
            WebElement colorDropdown = Base.getDriver().findElement(ProductDetailsPage.colorFilter);
            WebElement shoesizeDropdown = Base.getDriver().findElement(ProductDetailsPage.ShoeSizeFilter);

            //check if the filter is expanded or not
            if (commonMethods.isElementVisible(ProductDetailsPage.colorBlack, timeout)) {
                WebElement redCheckbox = Base.getDriver().findElement(ProductDetailsPage.colorBlack);
                reg.clickwithJavascript(ProductDetailsPage.colorBlack);
            } else {
                reg.clickwithJavascript(ProductDetailsPage.colorFilter);
                reg.clickwithJavascript(ProductDetailsPage.colorBlack);
            }

            if (commonMethods.isElementVisible(ProductDetailsPage.viewAllSizes, timeout)) {
                List<WebElement> moreSizes = Base.getDriver().findElements(ProductDetailsPage.viewAllSizes);
                JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", moreSizes.get(0));
                js.executeScript("arguments[0].click();", moreSizes.get(0));


                reg.clickwithJavascript(ProductDetailsPage.shoeSize9);
                Thread.sleep(3000);
            } else {
                commonMethods.clickWhenVisible(shoesizeDropdown, timeout);
                List<WebElement> moreSizes = Base.getDriver().findElements(ProductDetailsPage.viewAllSizes);
                JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", moreSizes.get(0));
                js.executeScript("arguments[0].click();", moreSizes.get(0));

                reg.clickwithJavascript(ProductDetailsPage.shoeSize9);
                Thread.sleep(3000);
            }

        } catch (Exception e) {
            logger.info(e.getMessage());
            Assert.fail();
        }

    }

    @When("we select shoe size 9")
    public void select_size9() {
        WebElement size9 = Base.getDriver().findElement(ProductDetailsPage.shoeSize9);
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", size9);
        js.executeScript("arguments[0].click();", size9);
        size9.click();
    }
}

