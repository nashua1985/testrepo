package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.cart.CartPage;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Regression_Checkout_037 {
    private static final Logger logger = Logger.getLogger(Regression_Checkout_037.class);
    private static final Integer timeout = 50;
    private List<String> emails;
    private List<String> phoneNumbers;
    CommonElementMethods commonMethods = new CommonElementMethods();
    //expected color
    private static String errorColor = "#B80818";
    private static String StandardColor = "#8C8F8E";

    @And("enter the following in the email field form box should be highlighted in red")
    public void enterTheFollowingInTheEmailFieldFormBoxShouldBeHighlightedInRed(List<String> emails) throws Exception{
        try {

            this.emails = emails;
            for(int i=0;i<emails.size();i++ ) {
                WebElement emailboundry= commonMethods.getWebElement(By.xpath("//div[@class='col-12']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"),timeout);
                WebElement name= commonMethods.getWebElement(checkoutPage.email,timeout);
                name.clear();
                commonMethods.enterValueWhenVisible(checkoutPage.email, emails.get(i), timeout);
                name.sendKeys(Keys.TAB);
                String color = emailboundry.getCssValue("border");
                System.out.println("Border attribute" + color);
                //Use Color class to convert the value from rgba() to Hex code and store in a variable
                //String hexColorValue = Color.fromString(color).asHex();
                String[] numbers = color.replace("2px solid rgb(", "").replace(")", "").split(",");
                int r = Integer.parseInt(numbers[0].trim());
                int g = Integer.parseInt(numbers[1].trim());
                int b = Integer.parseInt(numbers[2].trim());
                System.out.println("r: " + r + "g: " + g + "b: " + b);

                //String hexColorValue = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
                String hex = String. format("#%02X%02X%02X", r, g, b);
                System.out.println(hex);
                //Verify if actual and expected color values are equal?
                Assert.assertEquals(hex, errorColor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("enter the following in the email field form box should NOT be highlighted in red")
    public void enterTheFollowingInTheEmailFieldFormBoxShouldNOTBeHighlightedInRed(List<String> emails) throws Exception{
        try {
            this.emails = emails;
            for(int i=0;i<emails.size();i++ ) {
                WebElement emailboundry= commonMethods.getWebElement(By.xpath("//div[@class='col-12']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"),timeout);
                WebElement name= commonMethods.getWebElement(checkoutPage.email,timeout);
                name.clear();
                commonMethods.enterValueWhenVisible(checkoutPage.email, emails.get(i), timeout);
                name.sendKeys(Keys.TAB);
                String color = emailboundry.getCssValue("border");
                System.out.println("Border attribute" + color);
                //Use Color class to convert the value from rgba() to Hex code and store in a variable
                //String hexColorValue = Color.fromString(color).asHex();
                String[] numbers = color.replace("1px solid rgb(", "").replace(")", "").split(",");
                int r = Integer.parseInt(numbers[0].trim());
                int g = Integer.parseInt(numbers[1].trim());
                int b = Integer.parseInt(numbers[2].trim());
                System.out.println("r: " + r + "g: " + g + "b: " + b);

                //String hexColorValue = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
                String hex = String. format("#%02X%02X%02X", r, g, b);
                System.out.println(hex);
                //Verify if actual and expected color values are equal?
                Assert.assertEquals(hex, StandardColor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("enter the following in the phone number field form box should be highlighted in red")
    public void enterTheFollowingInThePhoneNumberFieldFormBoxShouldBeHighlightedInRed(List<String> phoneNumbers) throws Exception{
        try {

            this.phoneNumbers = phoneNumbers;
            for(int i=0;i<phoneNumbers.size();i++ ) {
                List<WebElement> phoneNumboundry= Base.getDriver().findElements(By.xpath("//div[@class='col-12']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"));
                WebElement name= commonMethods.getWebElement(checkoutPage.phone,timeout);
                name.clear();
                new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(checkoutPage.phone));
                commonMethods.enterValueWhenVisible(checkoutPage.phone, phoneNumbers.get(i), timeout);
                name.sendKeys(Keys.TAB);
                String color = phoneNumboundry.get(1).getCssValue("border");
                System.out.println("Border attribute" + color);
                //Use Color class to convert the value from rgba() to Hex code and store in a variable
                //String hexColorValue = Color.fromString(color).asHex();
                String[] numbers = color.replace("2px solid rgb(", "").replace(")", "").split(",");
                int r = Integer.parseInt(numbers[0].trim());
                int g = Integer.parseInt(numbers[1].trim());
                int b = Integer.parseInt(numbers[2].trim());
                System.out.println("r: " + r + "g: " + g + "b: " + b);

                //String hexColorValue = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
                String hex = String. format("#%02X%02X%02X", r, g, b);
                System.out.println(hex);
                //Verify if actual and expected color values are equal?
                Assert.assertEquals(hex, errorColor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("enter the following in the phone number field form box should NOT be highlighted in red")
    public void enterTheFollowingInThePhoneNumberFieldFormBoxShouldNOTBeHighlightedInRed(List<String> phoneNumbers)throws Exception {
        try {

            this.phoneNumbers = phoneNumbers;
            for(int i=0;i<phoneNumbers.size();i++ ) {
                List<WebElement> phoneNumboundry= Base.getDriver().findElements(By.xpath("//div[@class='col-12']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"));
                WebElement name= commonMethods.getWebElement(checkoutPage.phone,timeout);
                name.clear();
                new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(checkoutPage.phone));
                commonMethods.enterValueWhenVisible(checkoutPage.phone, phoneNumbers.get(i), timeout);
                name.sendKeys(Keys.TAB);
                Thread.sleep(1000);
                String color = phoneNumboundry.get(1).getCssValue("border");
                System.out.println("Border attribute" + color);
                //Use Color class to convert the value from rgba() to Hex code and store in a variable
                //String hexColorValue = Color.fromString(color).asHex();
                String[] numbers = color.replace("1px solid rgb(", "").replace(")", "").split(",");
                int r = Integer.parseInt(numbers[0].trim());
                int g = Integer.parseInt(numbers[1].trim());
                int b = Integer.parseInt(numbers[2].trim());
                System.out.println("r: " + r + "g: " + g + "b: " + b);

                //String hexColorValue = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
                String hex = String. format("#%02X%02X%02X", r, g, b);
                System.out.println(hex);
                //Verify if actual and expected color values are equal?
                Assert.assertEquals(hex, StandardColor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("error in enterTheFollowingInThePhoneNumberFieldFormBoxShouldNOTBeHighlightedInRed");
        }
    }
    }