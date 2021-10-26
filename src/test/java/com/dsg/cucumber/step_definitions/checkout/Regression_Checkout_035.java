package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Regression_Checkout_035 {
    private static final Logger logger = Logger.getLogger(Regression_Checkout_035.class);
    private static final Integer timeout = 50;
    private List<String> firstnames;
    private List<String> lastnames;
    CommonElementMethods commonMethods = new CommonElementMethods();
    //expected color
    private static String errorColor = "#B80818";
    private static String StandardColor = "#8C8F8E";

    @And("enter the following in the first name field form box should be highlighted in red")
    public void enterTheFollowingInTheFirstNameFieldFormBoxShouldBeHighlightedInRed(List<String> firstnames) throws Exception{
        try {

            this.firstnames = firstnames;
            for(int i=0;i<firstnames.size();i++ ) {
                WebElement nameboundry= commonMethods.getWebElement(By.xpath("//div[@class='col-6 col-md-12 col-lg-6 firstName']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"),timeout);
                WebElement name= commonMethods.getWebElement(checkoutPage.firstname,timeout);
                name.clear();
                commonMethods.enterValueWhenVisible(checkoutPage.firstname, firstnames.get(i), timeout);
                name.sendKeys(Keys.TAB);
                String color = nameboundry.getCssValue("border");
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

    @And("enter the following in the first name field form box should NOT be highlighted in red")
    public void enterTheFollowingInTheFirstNameFieldFormBoxShouldNOTBeHighlightedInRed(List<String> firstnames) throws Exception{
        try {
            this.firstnames = firstnames;
            for(int i=0;i<firstnames.size();i++ ) {
                WebElement nameboundry= commonMethods.getWebElement(By.xpath("//div[@class='col-6 col-md-12 col-lg-6 firstName']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"),timeout);
                WebElement name= commonMethods.getWebElement(checkoutPage.firstname,timeout);
                name.clear();
                commonMethods.enterValueWhenVisible(checkoutPage.firstname, firstnames.get(i), timeout);
                name.sendKeys(Keys.TAB);
                String color = nameboundry.getCssValue("border");
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

    @And("enter the following in the last name field form box should be highlighted in red")
    public void enterTheFollowingInTheLastNameFieldFormBoxShouldBeHighlightedInRed(List<String> lastnames) throws Exception{
        try {

            this.lastnames = lastnames;
            for(int i=0;i<lastnames.size();i++ ) {
                WebElement nameboundry= commonMethods.getWebElement(By.xpath("//div[@class='col-6 col-md-12 col-lg-6 lastName']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"),timeout);
                WebElement name= commonMethods.getWebElement(checkoutPage.lastname,timeout);
                name.clear();
                commonMethods.enterValueWhenVisible(checkoutPage.lastname, lastnames.get(i), timeout);
                name.sendKeys(Keys.TAB);
                String color = nameboundry.getCssValue("border");
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

    @And("enter the following in the last name field form box should NOT be highlighted in red")
    public void enterTheFollowingInTheLastNameFieldFormBoxShouldNOTBeHighlightedInRed(List<String> lastnames)throws Exception {
        try {

            this.lastnames = lastnames;
            for(int i=0;i<lastnames.size();i++ ) {
                WebElement nameboundry= commonMethods.getWebElement(By.xpath("//div[@class='col-6 col-md-12 col-lg-6 lastName']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"),timeout);
                WebElement name= commonMethods.getWebElement(checkoutPage.lastname,timeout);
                name.clear();
                commonMethods.enterValueWhenVisible(checkoutPage.lastname, lastnames.get(i), timeout);
                name.sendKeys(Keys.TAB);
                String color = nameboundry.getCssValue("border");
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


}