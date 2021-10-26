package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Regression_Checkout_024 {
    private static final Logger logger = Logger.getLogger(Regression_Checkout_024.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();

    @And("we remove the gift card from the order")
    public void weRemoveTheGiftCardFromTheOrder() {
        try {
            commonMethods.clickWhenVisible(checkoutPage.removeButton,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add {string} as Gift Card Account Number")
    public void weAddAsGiftCardAccountNumber(String arg0) {
        try {

            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(checkoutPage.addGiftCard));
            //commonMethods.clickWhenVisible(checkoutPage.addGiftCard,timeout);
            reg.clickwithJavascript(checkoutPage.addGiftCard);
            commonMethods.enterValueWhenVisible(checkoutPage.giftcardcode,arg0,timeout);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add {string} as Gift Card Pin Code")
    public void weAddAsGiftCardPinCode(String arg0) {

        try {
            commonMethods.enterValueWhenVisible(checkoutPage.giftcardpin,arg0,timeout);
            commonMethods.clickWhenVisible(checkoutPage.applybutton,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("Gift Card is not added to order summary")
    public void giftCardIsNotAddedToOrderSummary() throws Exception {
        WebElement successmsg=commonMethods.getWebElement(By.xpath("//p[contains(text(),'Applied Gift Cards')]"),timeout);
        if(commonMethods.isElementVisible(By.xpath("//p[contains(text(),'Applied Gift Cards')]"),timeout))
        {
            Assert.fail("Incorrect Gift card was applied");
        }
    }

    @And("we change {string} as Gift Card Account Number")
    public void weChangeAsGiftCardAccountNumber(String arg0) {
        try {

            Base.getDriver().findElement(checkoutPage.giftcardcode).clear();
            commonMethods.enterValueWhenVisible(checkoutPage.giftcardcode,arg0,timeout);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we change {string} as Gift Card Pin Code")
    public void weChangeAsGiftCardPinCode(String arg0) {
        try {

            Base.getDriver().findElement(checkoutPage.giftcardpin).clear();
            commonMethods.enterValueWhenVisible(checkoutPage.giftcardpin,arg0,timeout);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @And("we select PayPal as payment method")
    public void weSelectPayPalAsPaymentMethod() {
        try {
            commonMethods.clickWhenVisible(checkoutPage.paypalRadio,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we click PayPal Checkout button")
    public void weClickPayPalCheckoutButton() {
        try {
            commonMethods.clickWhenVisible(checkoutPage.paypalCheckoutBtn,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}