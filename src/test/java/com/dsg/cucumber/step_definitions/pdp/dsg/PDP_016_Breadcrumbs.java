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
import org.testng.Assert;


public class PDP_016_Breadcrumbs {
    private static final Logger logger = Logger.getLogger(PDP_016_Breadcrumbs.class);
    private static final Integer timeout = 40;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we click the {string} breadcrumb")
    public void click_breadcrumb(String breadcrumbLink)  {
        try {
            if(breadcrumbLink.equalsIgnoreCase("Water Bottles"))
            {
                if(commonMethods.isElementVisible(By.xpath("//h1[contains(text(), \"Water Bottles\")]"),timeout))
                {
                    commonMethods.clickWhenVisible(By.xpath("//h1[contains(text(), \"Water Bottles\")]"),timeout);
                }
                else
                {
                    commonMethods.clickWhenVisible(By.xpath("//h1[contains(text(), \"Water Bottles\")]"),timeout);
                }
            }
            //a[@class='breadcrumb-link']/span[contains(text(), "Golf")]
            commonMethods.clickWhenVisible(By.xpath("//a[@class='breadcrumb-link']/span[contains(text(), \"" + breadcrumbLink + "\")]"), timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("we click {string}")
    public void click_Link(String linkText) throws Exception {
        WebElement link = Base.getDriver().findElement(By.xpath("//*[contains(text(), \"" + linkText + "\")]"));
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", link);
        commonMethods.clickWhenVisible(By.xpath("//*[contains(text(), \"" + linkText + "\")]"), timeout);
    }

    @And("we click to open the hamburger menu and select {string}")
    public void weClickToOpenTheHamburgerMenuAndSelect(String arg0) {

        switch (arg0) {
            case "Top Brands":
                try {
                    commonMethods.hoverParentMenuAndClicksChild(ProductDetailsPage.shopDepartments,ProductDetailsPage.topBrands,timeout);
                } catch (Exception e) {
                    Assert.fail();
                }
                break;

            case "Outdoor & Recreation":
                try {
                    commonMethods.hoverParentMenuAndClicksChild(ProductDetailsPage.shopDepartments,ProductDetailsPage.outdoorRec,timeout);
                } catch (Exception e) {
                    Assert.fail();
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + arg0);
        }
    }
    @And("we select {string}")
    public void weSelect(String arg0)  {
        switch (arg0) {
            case "Yeti":
                try {
                    commonMethods.clickWhenVisible(ProductDetailsPage.YetiBrand, timeout);
                } catch (Exception e) {
                    Assert.fail();
                }
                break;

            case "Bikes":
                try {
                    commonMethods.hoverParentMenuAndClicksChild(ProductDetailsPage.BikesCycling,ProductDetailsPage.bikes,timeout);
                } catch (Exception e) {
                    Assert.fail();
                }
                break;
            case "Fishing & Rods":
                try {
                    commonMethods.hoverParentMenuAndClicksChild(ProductDetailsPage.Fishing,ProductDetailsPage.rods,timeout);
                } catch (Exception e) {
                    Assert.fail();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + arg0);
        }
    }

    @Then("we should see {string} title")
    public void weShouldSeeTitle(String text) {
        boolean isTextVisible = false;
        try {
            isTextVisible = commonMethods.isElementVisible(By.xpath("//h1[contains(text(), \"" + text + "\")]"), timeout);
        } catch (Exception e) {
            Assert.fail();
        }
        if (!isTextVisible) {
            Assert.fail(text + " is not VISIBLE");
        }
    }


}
