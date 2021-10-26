package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Regression_Checkout_039 {
    private static final Logger logger = Logger.getLogger(Regression_Checkout_039.class);
    private static final Integer timeout = 50;
    private List<String> scorecards;
    private List<String> zipcodes;
    CommonElementMethods commonMethods = new CommonElementMethods();
    //expected color
    private static String errorColor = "#B80818";
    private static String StandardColor = "#8C8F8E";

    @And("enter the following in the scorecard field form box should be highlighted in red")
    public void enterTheFollowingInTheScorecardFieldFormBoxShouldBeHighlightedInRed(List<String> scorecards) throws Exception{
        try {

            this.scorecards = scorecards;
            commonMethods.clickWhenVisible(By.xpath("//a[@id='applyScoreCardButton']"),timeout);
            for(int i=0;i<scorecards.size();i++ ) {
                WebElement scrorecardboundry= commonMethods.getWebElement(By.xpath("//div[@class='d-flex flex-row pt-2']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"),timeout);
                WebElement scorecard= commonMethods.getWebElement(checkoutPage.scorecardVal,timeout);
                scorecard.clear();
                commonMethods.enterValueWhenVisible(checkoutPage.scorecardVal, scorecards.get(i), timeout);
                scorecard.sendKeys(Keys.TAB);
                String color = scrorecardboundry.getCssValue("border");
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

    @And("enter the following in the scorecard field form box should NOT be highlighted in red")
    public void enterTheFollowingInTheScorecardFieldFormBoxShouldNOTBeHighlightedInRed(List<String> scorecards) throws Exception{
        try {
            this.scorecards = scorecards;
            for(int i=0;i<scorecards.size();i++ ) {
                WebElement scrorecardboundry= commonMethods.getWebElement(By.xpath("//div[@class='d-flex flex-row pt-2']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"),timeout);
                WebElement scorecard= commonMethods.getWebElement(checkoutPage.scorecardVal,timeout);
                commonMethods.clickWhenVisible(By.xpath("//i[@class='material-icons mt-n2 mr-3 ng-star-inserted']"),timeout);
                scorecard.clear();
                commonMethods.enterValueWhenVisible(checkoutPage.scorecardVal, scorecards.get(i), timeout);
                //scorecard.sendKeys(Keys.TAB);
                String color = scrorecardboundry.getCssValue("border");
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
            Assert.fail("error in enterTheFollowingInTheScorecardFieldFormBoxShouldNOTBeHighlightedInRed");
        }
    }

    @And("enter the following in the zipcode field form box should be highlighted in red")
    public void enterTheFollowingInTheZipcodeFieldFormBoxShouldBeHighlightedInRed(List<String> zipcodes) throws Exception{
        try {

            this.zipcodes = zipcodes;
            for(int i=0;i<zipcodes.size();i++ ) {
                List<WebElement> zipcodeboundry= Base.getDriver().findElements(By.xpath("//div[@class='col-12 px-0']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"));
                WebElement zipcode= commonMethods.getWebElement(checkoutPage.zipcode,timeout);
                zipcode.clear();
                commonMethods.enterValueWhenVisible(checkoutPage.zipcode, zipcodes.get(i), timeout);
                zipcode.sendKeys(Keys.TAB);
                String color = zipcodeboundry.get(2).getCssValue("border");
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
            Assert.fail("error in enterTheFollowingInTheZipcodeFieldFormBoxShouldBeHighlightedInRed");
        }
    }

    @And("enter the following in the zipcode field form box should NOT be highlighted in red")
    public void enterTheFollowingInTheZipcodeFieldFormBoxShouldNOTBeHighlightedInRed(List<String> zipcodes)throws Exception {
        try {

            this.zipcodes = zipcodes;
            for(int i=0;i<zipcodes.size();i++ ) {
                List<WebElement> zipcodeboundry= Base.getDriver().findElements(By.xpath("//div[@class='col-12 px-0']/mat-form-field/div/div[@class='mat-input-flex mat-form-field-flex']"));
                WebElement zipcode= commonMethods.getWebElement(checkoutPage.zipcode,timeout);
                zipcode.clear();
                commonMethods.enterValueWhenVisible(checkoutPage.zipcode, zipcodes.get(i), timeout);
                zipcode.sendKeys(Keys.TAB);
                String color = zipcodeboundry.get(2).getCssValue("border");
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
            Assert.fail("error in enterTheFollowingInTheZipcodeFieldFormBoxShouldNOTBeHighlightedInRed");
        }
    }


}