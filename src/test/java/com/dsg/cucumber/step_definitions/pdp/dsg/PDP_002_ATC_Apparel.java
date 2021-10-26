package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import com.dsg.cucumber.utilities.BrowserUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class PDP_002_ATC_Apparel {
    private static final Logger logger = Logger.getLogger(PDP_002_ATC_Apparel.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();


    @When("we filter by the color Black and the size Medium")
    public void filter_colorBlack_sizeMedium() throws Exception {
            BrowserUtilities.promotionHandler();
            WebElement blackCheckbox = Base.getDriver().findElement(By.xpath("//button[@aria-label='Black']"));
            WebElement mediumCheckbox= Base.getDriver().findElement(By.id("checkbox_299_3"));
            commonMethods.clickWhenVisible(blackCheckbox, timeout);
            commonMethods.clickWhenVisible(mediumCheckbox,timeout);
            Thread.sleep(3000);
    }

    @When("we filter by the color Black")
    public void filter_colorBlack() throws Exception {
        BrowserUtilities.promotionHandler();
        WebElement blackCheckbox = Base.getDriver().findElement(By.xpath("//button[@aria-label='checkbox_3232_2']"));
        commonMethods.clickWhenVisible(blackCheckbox, timeout);
        Thread.sleep(3000);
    }

    @When("we select the color Black")
    public void select_colorBlack() throws Exception {

        if(commonMethods.isElementVisible(ProductDetailsPage.colorBlack,timeout)){
            reg.clickwithJavascript(ProductDetailsPage.colorBlack);
        }
        else
        {
            List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
            if(colorList.size()>0) {
                new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button")));
                commonMethods.clickWhenVisible(colorList.get(0), timeout);
            }
            else
            {
                List<WebElement> colorList2 = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/span/button"));
                commonMethods.clickWhenVisible(colorList2.get(0), timeout);
            }

        }
    }


    @When("we select the size Medium")
    public void select_sizeMedium() throws Exception {
        reg.clickwithJavascript(ProductDetailsPage.sizeMedium);
        //commonMethods.clickWhenVisible(ProductDetailsPage.sizeMedium, timeout);
    }

    @And("we filter by the color {string} and the size {string}")
    public void weFilterByTheColorAndTheSize(String arg0, String arg1) {
        try {
            WebElement color = Base.getDriver().findElement(ProductDetailsPage.colorFilter);
            JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", color);
            js.executeScript("arguments[0].style.border='3px solid red'", color);
            if(commonMethods.isElementVisible(ProductDetailsPage.colorBlackHoodie,timeout))
            {
                WebElement blackButton = Base.getDriver().findElement(ProductDetailsPage.colorBlackHoodie);
                js.executeScript("arguments[0].click();", blackButton);
                //commonMethods.clickWhenVisible(blackButton, timeout);//select the black button
                Thread.sleep(3000);
            }
            else
            {
                //expand the color filter
                //commonMethods.clickWhenVisible(color, timeout);//click the dropdown
                js.executeScript("arguments[0].click();", color);
                WebElement blackButton = Base.getDriver().findElement(ProductDetailsPage.colorBlackHoodie);
                js.executeScript("arguments[0].click();", blackButton);//select the black button
                //commonMethods.clickWhenVisible(blackButton, timeout);
                Thread.sleep(3000);
            }
            if(commonMethods.isElementVisible(ProductDetailsPage.SizeMediumHoodie,timeout))
            {
                //select the medium size
                WebElement size = Base.getDriver().findElement(ProductDetailsPage.SizeMediumHoodie);
                js.executeScript("arguments[0].click();", size);//select the size
                //commonMethods.clickWhenVisible(size,timeout);
            }
            else {
                //expand the dropdown
                WebElement sizeDropdown = Base.getDriver().findElement(ProductDetailsPage.sizeFilter);
                //commonMethods.clickWhenVisible(sizeDropdown, timeout);
                js.executeScript("arguments[0].click();", sizeDropdown);
                //select the medium size
                WebElement size = Base.getDriver().findElement(ProductDetailsPage.SizeMediumHoodie);
                js.executeScript("arguments[0].click();", size);//select the size
                //commonMethods.clickWhenVisible(size, timeout);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
