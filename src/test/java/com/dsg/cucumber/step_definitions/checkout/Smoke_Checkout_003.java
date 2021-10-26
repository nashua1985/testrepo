package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Smoke_Checkout_003 {
    private static final Logger logger = Logger.getLogger(Smoke_Checkout_003.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();

    @And("we uncheck the same billing and shipping address checkbox")
    public void weUncheckTheSameBillingAndShippingAddressCheckbox() {
        try {
            //commonMethods.clickWhenVisible(checkoutPage.CheckboxSameAdd,timeout);
            reg.clickwithJavascript(checkoutPage.CheckboxSameAdd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add street address {string} as shipping address")
    public void weAddStreetAddressAsShippingAddress(String streetnum) {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.repFirstname,"firstname",timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.repLastname,"lastname",timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.repstreetAddr,streetnum,timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.repaptNumber,"10",timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add zip code {string} as shipping zip code")
    public void weAddZipCodeAsShippingZipCode(String zipcode) {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.repzipcode,zipcode,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add TE GC")
    public void weAddTEGC() {
        try {

            InputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/dsg/cucumber/config/properties/payment.properties") ;

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(checkoutPage.addGiftCard));
            //commonMethods.clickWhenVisible(checkoutPage.addGiftCard,timeout);
            reg.clickwithJavascript(checkoutPage.addGiftCard);
            commonMethods.enterValueWhenVisible(checkoutPage.giftcardcode,prop.getProperty("GiftcardCode"),timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.giftcardpin,prop.getProperty("Giftcardpin"),timeout);
            commonMethods.clickWhenVisible(checkoutPage.applybutton,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we see the Gift Card in the order summary")
    public void weSeeTheGiftCardInTheOrderSummary() {
        try {
            boolean applied=commonMethods.isElementVisible(checkoutPage.appliedGiftCard,timeout);
            if(applied==false)
            {
                Assert.fail("Gift card not applied");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add street address {string} as billing address")
    public void weAddStreetAddressAsBillingAddress(String arg0) {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.streetAdd,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add zip code {string} as billing zip code")
    public void weAddZipCodeAsBillingZipCode(String arg0) {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.zipcode,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
