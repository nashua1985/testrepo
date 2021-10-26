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

public class Regression_Checkout_014 {
    private static final Logger logger = Logger.getLogger(Regression_Checkout_014.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();
    PDP_024_BOPIS_ATC reg1=new PDP_024_BOPIS_ATC();

    @And("we enter {string} in the Credit Card Number field")
    public void weEnterInTheCreditCardNumberField(String arg0) throws Exception {
        new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.creditcardNumber));
        commonMethods.enterValueWhenVisible(checkoutPage.creditcardNumber,arg0,timeout);
    }

    @And("we enter {string} in the Exp. date field")
    public void weEnterInTheExpDateField(String arg0) throws Exception {
        commonMethods.enterValueWhenVisible(checkoutPage.expiryDate,arg0,timeout);
    }

    @And("we enter {string} in the CVV field")
    public void weEnterInTheCVVField(String arg0) throws Exception {
        commonMethods.enterValueWhenVisible(checkoutPage.securityCode,arg0,timeout);
    }
    }