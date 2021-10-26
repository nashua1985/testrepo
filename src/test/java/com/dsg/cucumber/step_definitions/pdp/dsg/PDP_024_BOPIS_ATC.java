package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;


public class PDP_024_BOPIS_ATC {
    private static final Logger logger = Logger.getLogger(PDP_024_BOPIS_ATC.class);
    private static final Integer timeout = 40;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();

    @And("we click the Change Store link")
    public void weClickTheChangeStoreLink() throws Exception {
        commonMethods.clickWhenVisible(ProductDetailsPage.changeStorelink, timeout);
    }

    @And("we verify that the Show Stores with Availability checkbox is checked")
    public void weVerifyThatTheShowStoresWithAvailabilityCheckboxIsChecked() {
        WebElement checkbox= Base.getDriver().findElement(ProductDetailsPage.showStoresCheckbox);
        boolean check=checkbox.isSelected();
        Assert.assertTrue(check);
    }

    @And("we enter {string} into the zip code search field")
    public void weEnterIntoTheZipCodeSearchField(String zipcode) {
        try {
            Base.getDriver().findElement(ProductDetailsPage.zipcodeText).clear();
            commonMethods.enterValueWhenVisible(ProductDetailsPage.zipcodeText,zipcode,timeout);
            commonMethods.clickWhenVisible(ProductDetailsPage.zipcodeSearch,timeout);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @And("we select the first available store")
    public void weSelectTheFirstAvailableStore() {
        try {
            List<WebElement> setStoreRadio=Base.getDriver().findElements(ProductDetailsPage.selectStoreradio);
            commonMethods.clickWhenVisible(setStoreRadio.get(0),timeout);
            JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", setStoreRadio.get(0));
            commonMethods.clickWhenVisible(ProductDetailsPage.selectStoreButton,timeout);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @And("we check BOPIS availability")
    public void weCheckBOPISAvailability() throws Exception {

        /*if(commonMethods.isElementVisible(ProductDetailsPage.notifyMeButton,timeout)||commonMethods.isElementVisible(ProductDetailsPage.notAvailable,timeout))
        {
            List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
            for(WebElement color:colorList)
            {
                commonMethods.clickWhenVisible(color,timeout);
            }
        }
        if(commonMethods.isElementVisible(By.xpath("//span[@class='ship-mode-message-atc-v3 ng-tns-c119-0']"),timeout))
        {
            //commonMethods.clickWhenVisible(By.xpath("//input[@id='radioBOPIS']/label/div[@class='radio-indicator-wrapper-atc-v3 ng-tns-c119-0 indicateGreen']"),timeout);
            reg.clickwithJavascript(By.xpath("//input[@id='radioBOPIS']/label/div[@class='radio-indicator-wrapper-atc-v3 ng-tns-c119-0 indicateGreen']"));
        }*/
        boolean notAvailable = false;
        
            List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
        try {
            notAvailable = commonMethods.isElementVisible(ProductDetailsPage.notAvailable, timeout);
        }
        catch(TimeoutException e)
        {
            System.out.println("Timeout occured");
        }
            if (notAvailable) {
                logger.info("Not available at stores within 100 miles");
                for (int i = 1; i <= colorList.size(); i++) {
                    commonMethods.clickWhenVisible(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button[" + i + "]"), timeout);
                    List<WebElement> frameList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
                    if(frameList.size()>0) {
                        commonMethods.clickWhenVisible(frameList.get(0), timeout);
                    }
                    notAvailable = commonMethods.isElementVisible(ProductDetailsPage.notAvailable, timeout);
                    if (notAvailable) {
                        logger.info("Not available at stores within 100 miles is VISIBLE");
                    } else {
                        logger.info("Not available at stores within 100 miles is NOT VISIBLE");
                        commonMethods.clickWhenVisible(By.xpath("//label[@for='radioBOPIS']/div[starts-with(@class,'radio-indicator-wrapper-atc-v3')]"), timeout);
                        //reg.clickwithJavascript(By.xpath("//label[@for='radioBOPIS']/div[@class='radio-indicator-wrapper-atc-v3 ng-tns-c119-0 indicateGreen']']"));
                        break;
                    }
                }

            } else {
                WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[starts-with(@class,'ship-mode-message-atc-v3') and contains(text(),'In Stock at')]")));
                if (Base.getDriver().findElement(By.xpath("//span[starts-with(@class,'ship-mode-message-atc-v3') and contains(text(),'In Stock at')]")).getText().contains("In Stock at")) {
                    //commonMethods.clickWhenVisible(By.xpath("//label[@for='radioBOPIS']/div[@class='radio-indicator-wrapper-atc-v3 ng-tns-c119-1 indicateGreen']"),timeout);
                    reg.clickwithJavascript(By.xpath("//label[@for='radioBOPIS']/div[starts-with(@class,'radio-indicator-wrapper-atc-v3')]"));
                } else {
                    Assert.fail("BOPIS option not available");
                }
            }

    }

    @Then("the BOPIS radio button is selected for our product")
    public void theBOPISRadioButtonIsSelectedForOurProduct() {
        try {
            WebElement radio=Base.getDriver().findElement(By.xpath("//input[@value='BOPIS']"));
            if(radio.isSelected())
            {
                System.out.println("BOPIS is selected");
            }
            else
            {
                Assert.fail("BOPIS checkbox not checked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we select the bike frame size as {string}")
    public void weSelectTheBikeFrameSizeAs(String framesize) {
        try {

            switch (framesize) {
                case "15":
                    if(commonMethods.isElementVisible(ProductDetailsPage.frameSize15,timeout)){
                        commonMethods.clickWhenVisible(ProductDetailsPage.frameSize15, timeout);
                    }
                    else
                    {
                        List<WebElement> frameList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
                        commonMethods.clickWhenVisible(frameList.get(0),timeout);
                    }
                    break;
                case "17":
                    if(commonMethods.isElementVisible(ProductDetailsPage.frameSize17,timeout)){
                        commonMethods.clickWhenVisible(ProductDetailsPage.frameSize17, timeout);
                    }
                    else
                    {
                        List<WebElement> frameList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
                        commonMethods.clickWhenVisible(frameList.get(0),timeout);
                    }
                    break;
                case "19":
                    if(commonMethods.isElementVisible(ProductDetailsPage.frameSize19,timeout)){
                        commonMethods.clickWhenVisible(ProductDetailsPage.frameSize19, timeout);
                    }
                    else
                    {
                        List<WebElement> frameList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
                        commonMethods.clickWhenVisible(frameList.get(0),timeout);
                    }
                    break;
                case "21":
                    if(commonMethods.isElementVisible(ProductDetailsPage.frameSize21,timeout)){
                        commonMethods.clickWhenVisible(ProductDetailsPage.frameSize21, timeout);
                    }
                    else
                    {
                        List<WebElement> frameList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
                        commonMethods.clickWhenVisible(frameList.get(0),timeout);
                    }
                    break;
            }
        }
        catch(Exception e)
        {
            Assert.fail();
        }
    }



    @Then("we should see {string} for mobile")
    public void weShouldSeeForMobile(String text) throws Exception {


        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        //js.executeScript("window.scrollBy(0,300)", "");
        HashMap scrollObject = new HashMap<>();
        scrollObject.put("predicateString", "value == '" + text + "'");
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);

        Thread.sleep(20);
        WebDriverWait wait=new WebDriverWait(Base.getDriver(), 20);
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//span[contains(text(),'Select Product Options for Availability')]")));
        js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);

        boolean isTextVisible = commonMethods.isElementVisible(By.xpath("//*[contains(text(),'Select Product Options for Availability')]"), timeout);

        if (!isTextVisible) {
            Assert.fail(text + " is not VISIBLE");
        }
    }


    @And("we click on the first product in search grid in mobile")
    public void weClickOnTheFirstProductInSearchGridInMobile() throws InterruptedException {

        /*WebDriverWait wait=new WebDriverWait(Base.getDriver(), 20);
        if(wait.until(ExpectedConditions.alertIsPresent())==null)
            System.out.println("alert was not present");
        else
            Base.getDriver().switchTo().alert().accept();*/

        Thread.sleep(3000);
        //BrowserUtilities.promotionHandler();
        //commonMethods.clickWhenVisible(ProductDetailsPage.firstProductInGrid, timeout);
        WebElement firstProd = Base.getDriver().findElement(ProductDetailsPage.firstProductInGrid);
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",firstProd);
        js.executeScript("arguments[0].style.border='3px solid red'",firstProd);
        js.executeScript("arguments[0].click();", firstProd);

    }

    @And("we click on In store")
    public void weClickOnInStore() {
        WebElement element = Base.getDriver().findElement(By.xpath("//button[text()='In Store']"));
        WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        reg.clickwithJavascript(By.xpath("//button[text()='In Store']"));
    }
}
