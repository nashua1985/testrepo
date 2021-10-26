package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_024_BOPIS_ATC;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Regression_Checkout_012 {
    private static final Logger logger = Logger.getLogger(Regression_Checkout_012.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();
    PDP_024_BOPIS_ATC reg1=new PDP_024_BOPIS_ATC();
    String orderTotal;


    @And("we click enter")
    public void weClickEnter() {
        try {
            WebElement zip=commonMethods.getWebElement(checkoutPage.zipcode,timeout);
            zip.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Then("we validate that est tax is {string}")
    public void weValidateThatEstTaxIs(String arg0) {
    List<WebElement> price=Base.getDriver().findElements(By.xpath("//p[@class='grid-amount line-item-text p-0 col-3 ml-auto']"));
    orderTotal=price.get(0).getText();
    System.out.println("orderTotal"+orderTotal);
    String tax=price.get(2).getText();
        System.out.println("Tax"+tax);
    if(!(tax.equalsIgnoreCase("$0.00")))
    {
        Assert.fail("Tax amount is not $0.00");
    }
    }

    @And("we go back to Address Delivery page")
    public void weGoBackToAddressDeliveryPage() throws Exception {
        Thread.sleep(5000);
        Base.getDriver().navigate().back();
        Thread.sleep(5000);
        commonMethods.isElementVisible(checkoutPage.standardRadio,timeout);
    }

    @And("we change street address {string}")
    public void weChangeStreetAddress(String arg0) {
        try {
            commonMethods.clickWhenVisible(checkoutPage.EditAddr,timeout);
            WebElement add1=commonMethods.getWebElement(By.xpath("//input[@autocomplete='address-line1']"),timeout);
            add1.clear();
            commonMethods.enterValueWhenVisible(By.xpath("//input[@autocomplete='address-line1']"),arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we change zip code {string}")
    public void weChangeZipCode(String arg0) {
        try {
            WebElement add1=commonMethods.getWebElement(By.xpath("//input[@autocomplete='postal-code']"),timeout);
            add1.clear();
            commonMethods.enterValueWhenVisible(By.xpath("//input[@autocomplete='postal-code']"),arg0,timeout);
            add1.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("we validate that est tax is equal to {string} multiplied by the order total")
    public void weValidateThatEstTaxIsEqualToMultipliedByTheOrderTotal(String arg0) throws Exception {
        double shipcredit = 0;
        new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='grid-amount line-item-text p-0 col-3 ml-auto']/span")));
        List<WebElement> price=Base.getDriver().findElements(By.xpath("//p[@class='grid-amount line-item-text p-0 col-3 ml-auto']/span"));
        orderTotal=price.get(0).getText();
        String shipping=price.get(1).getText();
        String tax=price.get(2).getText();
        System.out.println("total"+orderTotal);
        System.out.println("shipping"+shipping);
        System.out.println("new tax"+tax);
        for(int i=0;i<price.size();i++)
        {
            System.out.println("Testingggggg");
            List<WebElement> a=Base.getDriver().findElements(By.xpath("//span[@class='float-right']"));
            System.out.println(a.get(i).getText());
        }
        if(commonMethods.isElementVisible(By.xpath("//p[@class='grid-amount line-item-text p-0 col-3 ml-auto line-item-text--promotion']/span"),timeout)) {
            String shipCredit = Base.getDriver().findElement(By.xpath("//p[@class='grid-amount line-item-text p-0 col-3 ml-auto line-item-text--promotion']/span")).getText();
            shipCredit=shipCredit.substring(2,shipCredit.length());
            shipcredit=Double.parseDouble(shipCredit);
            System.out.println("Shipping credit-----"+shipCredit);
        }
        orderTotal=orderTotal.substring(1,orderTotal.length());
        shipping=shipping.substring(1,shipping.length());
        double taxrate=Double.parseDouble(arg0);
        double ship=Double.parseDouble(shipping);
        double orderAmt=Double.parseDouble(orderTotal);
        if(shipcredit!=0)
        {
            orderAmt=(orderAmt+ship-shipcredit) * taxrate;
        }
        else {
            orderAmt = (orderAmt + ship) * taxrate;
        }
        String num = String.format("%.2f",orderAmt);
        System.out.println("expected tax"+num);
        if(!(tax.equalsIgnoreCase("$"+num)))
        {
            Assert.fail("Tax amount is not calculated correctly"+tax+"-----"+num);
        }
    }


}