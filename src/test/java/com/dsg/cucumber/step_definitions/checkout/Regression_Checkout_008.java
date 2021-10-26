package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Regression_Checkout_008 {
    private static final Logger logger = Logger.getLogger(Regression_Checkout_008.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();
    String estDelivery;
    String expitedDelivery;

    @And("we change to Expedited Shipping")
    public void weChangeToExpeditedShipping() {
        try {
            estDelivery=Base.getDriver().findElement(checkoutPage.estDelivery).getText();
            System.out.println("estDelivery-----"+estDelivery);
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(checkoutPage.expeditedRadio));
            commonMethods.clickWhenVisible(checkoutPage.expeditedRadio,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we validate EDD change")
    public void weValidateEDDChange() throws InterruptedException {
        Thread.sleep(2000);
        expitedDelivery=Base.getDriver().findElement(checkoutPage.estDelivery).getText();
        System.out.println("expitedDelivery-----"+expitedDelivery);
        System.out.println("estDelivery---------"+estDelivery);
        if(!(expitedDelivery.equalsIgnoreCase(estDelivery)))
        {
            Assert.fail("Delivery Date did not change, expitedDelivery--"+expitedDelivery+"estDelivery--"+estDelivery);
        }
    }

    @And("we validate that shipping is not null")
    public void weValidateThatShippingIsNotNull() {
        List<WebElement> shippingList=Base.getDriver().findElements(By.xpath("//p[@class='grid-amount line-item-text p-0 col-3 ml-auto']/span"));
        String shipping=shippingList.get(1).getText();
        System.out.println("shipping-----"+shipping);
        if(shipping==null)
        {
            Assert.fail("shipping is null");
        }
    }
    @And("we validate that shipping is {string}")
    public void weValidateThatShippingIs(String arg0) throws Exception {
        List<WebElement> shippingList=Base.getDriver().findElements(By.xpath("//p[@class='grid-amount line-item-text p-0 col-3 ml-auto']/span"));
        String shipping=shippingList.get(1).getText();
        System.out.println("shipping-----"+shipping);
        if(!shipping.equalsIgnoreCase(arg0))
        {
            Assert.fail("shipping is not"+arg0);
        }
    }

    @And("we change to Express Shipping")
    public void weChangeToExpressShipping() {
        try {
            if(commonMethods.isElementVisible(checkoutPage.expressRadio,timeout)){
                commonMethods.clickWhenVisible(checkoutPage.expressRadio, timeout);

                //also check if shipping is null or not
                List<WebElement> shippingList=Base.getDriver().findElements(By.xpath("//p[@class='grid-amount line-item-text p-0 col-3 ml-auto']/span"));
                String shipping=shippingList.get(1).getText();
                System.out.println("shipping-----"+shipping);
                if(shipping==null)
                {
                    Assert.fail("shipping is null");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
