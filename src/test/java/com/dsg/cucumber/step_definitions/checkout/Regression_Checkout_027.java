package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.cart.CartPage;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Regression_Checkout_027 {
    private static final Logger logger = Logger.getLogger(Regression_Checkout_027.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @And("we click the Cart Icon")
    public void weClickTheCartIcon() {

        try {
            WebElement cart=commonMethods.getWebElement(By.xpath("//i[@id='mini-cart-icon']"),timeout);
            new WebDriverWait(Base.getDriver(), timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@id='mini-cart-icon']")));
            commonMethods.clickWhenVisible(cart,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @And("we remove an item from cart")
    public void weRemoveAnItemFromCart() {
        List<WebElement> deleteIcons=Base.getDriver().findElements(By.xpath("//img[@class='delete-icon']"));
        try {
            commonMethods.clickWhenVisible(deleteIcons.get(0),timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @And("we click the DSG Logo")
    public void weClickTheDSGLogo() {
        try {
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(checkoutPage.dsgLogo));
            commonMethods.clickWhenVisible(checkoutPage.dsgLogo,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we modify first name to {string}")
    public void weModifyFirstNameTo(String arg0) {
        try {
            System.out.println("Firstname:"+arg0);
            commonMethods.clickWhenVisible(By.id("editContactLabel"),timeout);
            commonMethods.getWebElement(checkoutPage.firstname,timeout).clear();
            commonMethods.enterValueWhenVisible(checkoutPage.firstname,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we enter {string} in the promo code field")
    public void weEnterInThePromoCodeField(String arg0) {
        try {

            commonMethods.enterValueWhenVisible(checkoutPage.promocode,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we click Apply Code")
    public void weClickApplyCode() {
        try {

            commonMethods.clickWhenVisible(checkoutPage.applyCodebutton,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}