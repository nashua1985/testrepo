package com.dsg.cucumber.step_definitions.pdp.dsg;
import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class PDP_014_ATC_Custom_Irons {
    private static final Logger logger = Logger.getLogger(PDP_014_ATC_Custom_Irons.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we select the hand Left and shaft material Steel")
    public void select_clubOptions() throws Exception {
        Base.getDriver().switchTo().frame(0);
        commonMethods.clickWhenVisible(ProductDetailsPage.handLeft, timeout);
        commonMethods.clickWhenVisible(ProductDetailsPage.shaftMaterialSteel, timeout);

    }

    @And("we select the hand {string} and shaft material {string}")
    public void weSelectTheHandAndShaftMaterial(String arg0, String arg1) {
        Base.getDriver().switchTo().frame(0);
        try {

            if(commonMethods.isElementVisible(By.xpath("//button[@id='gender-men’s']"),timeout)){
                //just click on next
                commonMethods.clickWhenVisible(ProductDetailsPage.customNext, timeout);
            }

            if (arg0.contains("Left")) {
                if(commonMethods.isElementVisible(ProductDetailsPage.handLeftIron,timeout)){
                    commonMethods.clickWhenVisible(ProductDetailsPage.handLeftIron, timeout);
                }
                else
                {
                    List<WebElement> List = Base.getDriver().findElements(By.xpath("//button[@class='optionImg sizing large hand blank']"));
                    commonMethods.clickWhenVisible(List.get(0), timeout);
                }

            }
            if (arg1.contains("Steel")) {
                if(commonMethods.isElementVisible(ProductDetailsPage.shaftMaterialSteel,timeout)){
                    commonMethods.clickWhenVisible(ProductDetailsPage.shaftMaterialSteel, timeout);
                }
                else
                {
                    List<WebElement> List = Base.getDriver().findElements(By.xpath("//button[@class='optionImg sizing large blank']"));
                    commonMethods.clickWhenVisible(List.get(0), timeout);
                }

            }
        }catch (Exception e) {
            logger.info("Error in selecting the hand and shaft material");
        }
    }

    @And("we select makeup {string} and iron selection {string}")
    public void weSelectMakeupAndIronSelection(String makeup, String iron) {
        try {
            if(commonMethods.isElementVisible(ProductDetailsPage.setMakeUp,timeout)){
                commonMethods.clickWhenVisible(ProductDetailsPage.setMakeUp, timeout);
            }
            else
            {
                List<WebElement> List = Base.getDriver().findElements(By.xpath("//button[@class='optionImg sizing large blank']"));
                commonMethods.clickWhenVisible(List.get(2), timeout);
            }
            if(commonMethods.isElementVisible(ProductDetailsPage.fiveIron, timeout)){
                commonMethods.clickWhenVisible(ProductDetailsPage.fiveIron, timeout);
            }
            else
            {
                List<WebElement> List = Base.getDriver().findElements(By.xpath("//button[@class='optionImg sizing medium blank optionImgSelected']"));
                commonMethods.clickWhenVisible(List.get(0), timeout);
            }

        } catch (Exception e) {
            logger.info("Error in selecting the makeup and iron selection");
        }
    }

    @And("we select the lie as {string}")
    public void weSelectTheLieAs(String lie) throws Exception {

        //check if there is a screen for Tipping
        if(commonMethods.isElementVisible(By.xpath("//select[@id='select-shafttipping']"),timeout)){
            //just click on next
            commonMethods.clickWhenVisible(ProductDetailsPage.customNext, timeout);
        }
        try {
            commonMethods.selectDropDownByText(ProductDetailsPage.lieDropdown,timeout,lie);
        } catch (Exception e) {
            logger.info("Error in selecting the lie dropdown");
        }
    }


    @And("we select the hand {string} and shaft material {string} for mobile")
    public void weSelectTheHandAndShaftMaterialForMobile(String arg0, String arg1) {
        Base.getDriver().switchTo().frame(0);
        try {
            if (arg0.contains("Left")) {
                if(commonMethods.isElementVisible(ProductDetailsPage.handLeftIron,timeout)){
                    commonMethods.clickWhenVisible(ProductDetailsPage.handLeftIron, timeout);
                }
                else
                {
                    List<WebElement> List = Base.getDriver().findElements(By.xpath("//button[@class='optionImg sizing large hand blank']"));
                    commonMethods.clickWhenVisible(List.get(0), timeout);
                }

            }
            commonMethods.clickWhenVisible(ProductDetailsPage.customNext, timeout);
            if (arg1.contains("Steel")) {
                if(commonMethods.isElementVisible(ProductDetailsPage.shaftMaterialSteel,timeout)){
                    commonMethods.clickWhenVisible(ProductDetailsPage.shaftMaterialSteel, timeout);
                }
                else
                {
                    List<WebElement> List = Base.getDriver().findElements(By.xpath("//button[@class='optionImg sizing large blank']"));
                    commonMethods.clickWhenVisible(List.get(0), timeout);
                }

            }
        }catch (Exception e) {
            logger.info("Error in selecting the hand and shaft material");
        }
    }

    @And("we select makeup {string} and iron selection {string} for mobile")
    public void weSelectMakeupAndIronSelectionForMobile(String arg0, String arg1) {
        try {
            if(commonMethods.isElementVisible(ProductDetailsPage.setMakeUp,timeout)){
                commonMethods.clickWhenVisible(ProductDetailsPage.setMakeUp, timeout);
            }
            else
            {
                List<WebElement> List = Base.getDriver().findElements(By.xpath("//button[@class='optionImg sizing large blank']"));
                commonMethods.clickWhenVisible(List.get(2), timeout);
            }

            commonMethods.clickWhenVisible(ProductDetailsPage.customNext, timeout);
            if(commonMethods.isElementVisible(ProductDetailsPage.fiveIron, timeout)){
                commonMethods.clickWhenVisible(ProductDetailsPage.fiveIron, timeout);
            }
            else
            {
                List<WebElement> List = Base.getDriver().findElements(By.xpath("//button[@class='optionImg sizing medium blank optionImgSelected']"));
                commonMethods.clickWhenVisible(List.get(0), timeout);
            }
        } catch (Exception e) {
            logger.info("Error in selecting the makeup and iron selection");
        }
    }

    @And("we select the first golf brand option and grip build {string} for mobile")
    public void weSelectTheGolfBrandAndGripBuildForMobile(String gripBuild) {
        try {
            Select gripBrand=new Select(Base.getDriver().findElement(ProductDetailsPage.gripBrandDropdown));
            gripBrand.selectByIndex(1);
            commonMethods.clickWhenVisible(ProductDetailsPage.customNext, timeout);
            commonMethods.clickWhenVisible(ProductDetailsPage.customNext, timeout);
            commonMethods.selectDropDownByText(ProductDetailsPage.gripBuildDropdown,timeout,gripBuild);
            commonMethods.clickWhenVisible(ProductDetailsPage.customNext, timeout);
        } catch (Exception e) {
            logger.info("Error in selecting the grip brand and build dropdown");
        }
    }

    @And("we select the first golf brand option and grip build {string}")
    public void weSelectTheFirstGolfBrandOptionAndGripBuild(String gripBuild) {
        try {
            Select gripBrand=new Select(Base.getDriver().findElement(ProductDetailsPage.gripBrandDropdown));
            gripBrand.selectByIndex(1);
            commonMethods.selectDropDownByText(ProductDetailsPage.gripBuildDropdown,timeout,gripBuild);
        } catch (Exception e) {
            logger.info("Error in selecting the grip brand and build dropdown");
        }
    }


    @Then("we should see {string} on customize panel")
    public void weShouldSeeOnCustomizePanel(String text) throws Exception {
        boolean isTextVisible = commonMethods.isElementVisible(By.xpath("//li[contains(text(), \"" + text + "\")]"), timeout);
        if (!isTextVisible) {
            Assert.fail(text + " is not VISIBLE");
        }
        WebElement element = Base.getDriver().findElement(By.xpath("//*[contains(text(), \"" + text + "\")]"));
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }
}
