package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Smoke_Checkout_004 {
    private static final Logger logger = Logger.getLogger(Smoke_Checkout_004.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();

    @And("we select PayPal Checkout")
    public void weSelectPayPalCheckout() {
        try {
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(checkoutPage.paypalCheckout));
            commonMethods.clickWhenVisible(checkoutPage.paypalCheckout,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add Paypal Email and click Next")
    public void weAddPaypalEmailAndClickNext() {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.email,"ismail.abouwafia@dcsg.com",timeout);
            commonMethods.clickWhenVisible(checkoutPage.paypalNext,timeout);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add PayPal Password and click Log In")
    public void weAddPayPalPasswordAndClickLogIn() {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.paypalpassword,"TE@PayPal",timeout);
            commonMethods.clickWhenVisible(checkoutPage.paypalLogin,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we click Continue")
    public void weClickContinue() {
        try {
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(checkoutPage.paypalContinue));
            Base.getDriver().findElement(checkoutPage.paypalContinue).sendKeys(Keys.RETURN);
            //commonMethods.clickWhenVisible(checkoutPage.paypalContinue,timeout);
            //reg.clickwithJavascript(checkoutPage.paypalContinue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
