package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_024_BOPIS_ATC;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Regression_Checkout_011 {
    private static final Logger logger = Logger.getLogger(Regression_Checkout_011.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();
    PDP_024_BOPIS_ATC reg1=new PDP_024_BOPIS_ATC();

    @And("we change the quantity of items in cart to {string}")
    public void weChangeTheQuantityOfItemsInCartTo(String arg0) {
        List<WebElement> itemQty = Base.getDriver().findElements(By.xpath("//div[@class='qty']/input"));
        try {

                WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='qty']/input")));
                itemQty.get(0).clear();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='qty']/input")));
                commonMethods.enterValueWhenVisible(itemQty.get(0), arg0, timeout);
                Thread.sleep(5000);

            List<WebElement> itemQty1 = Base.getDriver().findElements(By.xpath("//div[@class='qty']/input"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='qty']/input")));
            itemQty1.get(1).clear();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='qty']/input")));
            commonMethods.enterValueWhenVisible(itemQty1.get(1), arg0, timeout);
            Thread.sleep(5000);

            List<WebElement> itemQty2 = Base.getDriver().findElements(By.xpath("//div[@class='qty']/input"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='qty']/input")));
            itemQty2.get(2).clear();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='qty']/input")));
            commonMethods.enterValueWhenVisible(itemQty2.get(2), arg0, timeout);
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we change the quantity of first item in cart to {string}")
    public void weChangeTheQuantityOfFirstItemInCartTo(String arg0) {
        List<WebElement> itemQty = Base.getDriver().findElements(By.xpath("//div[@class='qty']/input"));
        try {

            WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='qty']/input")));
            itemQty.get(0).clear();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='qty']/input")));
            commonMethods.enterValueWhenVisible(itemQty.get(0), arg0, timeout);
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we validate subtotal")
    public void weValidateSubtotal() {
    }

    @And("we validate Estimated Order total")
    public void weValidateEstimatedOrderTotal() {
    }

    @And("we validate store pickup is FREE")
    public void weValidateStorePickupIsFREE() {
    }



}
