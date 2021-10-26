package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Smoke_Checkout_002 {
    private static final Logger logger = Logger.getLogger(Smoke_Checkout_002.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();


    @And("we click Sign In")
    public void weClickSignIn() {
        try {
            commonMethods.clickWhenVisible(checkoutPage.signInBtn,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we sign in as a registered user")
    public void weSignInAsARegisteredUser() {
        try {
            InputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/dsg/cucumber/config/properties/payment.properties") ;

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            String username=prop.getProperty("signInUsername").trim();
            String password=prop.getProperty("signInPassword").trim();
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.email));
            commonMethods.enterValueWhenVisible(checkoutPage.email,username,timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.signInPass,password,timeout);
            //commonMethods.clickWhenVisible(By.xpath("//i[@data-toggle-password='#signinPass']"),timeout);
            Thread.sleep(10000);
            new WebDriverWait(Base.getDriver(), timeout).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            commonMethods.clickWhenVisible(checkoutPage.signInSubmitBtn,timeout);

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we validate Contact and Address info is prefilled")
    public void weValidateContactAndAddressInfoIsPrefilled() throws Exception {
        new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.contactInfo));
        List<WebElement> contactdetails=Base.getDriver().findElements(checkoutPage.contactInfo);
        if(contactdetails.get(0).getText().isEmpty()||contactdetails.get(0).getText().isEmpty()||contactdetails.get(0).getText().isEmpty())
        {
            Assert.fail("contact details is not prefilled");
        }
        WebElement scorecard=commonMethods.getWebElement(checkoutPage.scorecard,timeout);
        if(scorecard.getText().equalsIgnoreCase(""))
        {
            Assert.fail("scorecard is not prefilled");
        }
        List<WebElement> addressdetails=Base.getDriver().findElements(checkoutPage.addressInfo);
        if(addressdetails.get(0).getText().isEmpty()||addressdetails.get(0).getText().isEmpty())
        {
            Assert.fail("address details is not prefilled");
        }
    }

    @And("we add the TE Mastercard")
    public void weAddTheTEMastercard() {
        try {

            InputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/dsg/cucumber/config/properties/payment.properties") ;

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);


            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.creditcardNumber));
            commonMethods.enterValueWhenVisible(checkoutPage.creditcardNumber,prop.getProperty("accountNumberMaster"),timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.expiryDate,prop.getProperty("expDateMaster"),timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.securityCode,prop.getProperty("CVVMaster"),timeout);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



}
