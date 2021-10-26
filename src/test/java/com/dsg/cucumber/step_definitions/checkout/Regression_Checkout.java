package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
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

public class Regression_Checkout {
    private static final Logger logger = Logger.getLogger(Regression_Checkout.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();

    @Then("we should be taken to the payments page")
    public void weShouldBeTakenToThePaymentsPage() throws Exception {
        new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.creditcardNumber));
        boolean visible=commonMethods.isElementVisible(checkoutPage.creditcardNumber,timeout);
        if(visible==false)
        {
            Assert.fail("Payments page not visible");
        }

    }

    @And("we change street address {string} as billing address")
    public void weChangeStreetAddressAsBillingAddress(String arg0) {
        try {
            commonMethods.clickWhenVisible(checkoutPage.EditAddr,timeout);
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.streetAddEdit));
            WebElement add1=commonMethods.getWebElement(checkoutPage.streetAddEdit,timeout);
            add1.clear();
            commonMethods.enterValueWhenVisible(checkoutPage.streetAddEdit,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we change zip code {string} as billing zip code")
    public void weChangeZipCodeAsBillingZipCode(String arg0) {
        try {
            WebElement zipcode1=commonMethods.getWebElement(checkoutPage.zipcodeEdit,timeout);
            zipcode1.clear();
            commonMethods.enterValueWhenVisible(checkoutPage.zipcodeEdit,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we change street address {string} as shipping address")
    public void weChangeStreetAddressAsShippingAddress(String streetnum) {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.repFirstname,"firstname",timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.repLastname,"lastname",timeout);
            List<WebElement> add=Base.getDriver().findElements(checkoutPage.repstreetAddrEdit);
            commonMethods.enterValueWhenVisible(add.get(1),streetnum,timeout);
            List<WebElement> app=Base.getDriver().findElements(checkoutPage.repaptNumberEdit);
            commonMethods.enterValueWhenVisible(app.get(1),"10",timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we change zip code {string} as shipping zip code")
    public void weChangeZipCodeAsShippingZipCode(String zipcode) {
        try {
            List<WebElement> zip=Base.getDriver().findElements(checkoutPage.repzipcodeEdit);
            commonMethods.enterValueWhenVisible(zip.get(1),zipcode,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we change only street address {string} as billing address")
    public void weChangeOnlyStreetAddressAsBillingAddress(String arg0) {
        try {
            commonMethods.clickWhenVisible(checkoutPage.EditAddr,timeout);
            WebElement add1=commonMethods.getWebElement(By.id("mat-input-2"),timeout);
            add1.clear();
            commonMethods.enterValueWhenVisible(add1,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we change only zip code {string} as billing zip code")
    public void weChangeOnlyZipCodeAsBillingZipCode(String arg0) {
        try {
            WebElement zipcode1=commonMethods.getWebElement(By.id("mat-input-4"),timeout);
            zipcode1.clear();
            commonMethods.enterValueWhenVisible(zipcode1,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
