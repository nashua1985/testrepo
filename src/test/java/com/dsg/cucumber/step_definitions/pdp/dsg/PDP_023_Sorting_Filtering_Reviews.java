package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class PDP_023_Sorting_Filtering_Reviews {
    private static final Logger logger = Logger.getLogger(PDP_023_Sorting_Filtering_Reviews.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @And("we click to view {int} star reviews")
    public void weClickToViewStarReviews(int arg0) {

        try {
            commonMethods.clickWhenVisible(By.xpath("//div[@data-bv-histogram-rating-value='"+arg0+"']"), timeout);
        } catch (Exception e) {
            Assert.fail();
        }
    }


    @And("we click the filter button")
    public void weClickTheFilterButton() {
        try {
            WebDriverWait wait=new WebDriverWait(Base.getDriver(), 40);
            WebElement element = Base.getDriver().findElement(ProductDetailsPage.reviewFilterBtn);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            Assert.fail();
            e.printStackTrace();
        }
    }


    @And("we select {string} on review dropdown")
    public void weSelectOnReviewDropdown(String arg0) {
        try {
            if(arg0.equalsIgnoreCase("Most Recent"))
                commonMethods.hoverParentMenuAndClicksChild(ProductDetailsPage.reviewDropdown,ProductDetailsPage.mostRecent,20);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @And("we click the filter {string} and select {string}")
    public void weClickTheFilterAndSelect(String arg0, String arg1) {
        try {
            if(arg0.equalsIgnoreCase("owned for") & arg1.equalsIgnoreCase("1 month or less"))
            commonMethods.hoverParentMenuAndClicksChild(ProductDetailsPage.ownedforDropdown,ProductDetailsPage.oneMonthorLess,20);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Then("we should see {string} button")
    public void weShouldSeeButton(String text) throws Exception {
        boolean isTextVisible = commonMethods.isElementVisible(By.xpath("//button[contains(text(), \"" + text + "\")]"), timeout);
        if (!isTextVisible) {
            Assert.fail(text + " is not VISIBLE");
        }
        WebElement element = Base.getDriver().findElement(By.xpath("//*[contains(text(), \"" + text + "\")]"));
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }

    @And("we click the filter {string} and select {string} for mobile")
    public void weClickTheFilterAndSelectForMobile(String arg0, String arg1) {
        try {
            WebDriverWait wait=new WebDriverWait(Base.getDriver(), 40);
            //button/span[@class='bv-dropdown-arrow']
            Select element = new Select(Base.getDriver().findElement(By.xpath("//select[@class='bv-content-filter-select-element bv-focusable bv-dropdown' and @data-bv-filter-for='Owned for']")));


            JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
            js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);

            element.selectByValue("1month");
            /*wait.until(ExpectedConditions.elementToBeClickable(Base.getDriver().findElement(ProductDetailsPage.oneMonthorLess)));
            commonMethods.clickWhenVisible(ProductDetailsPage.oneMonthorLess,timeout);*/
        } catch (Exception e) {
            logger.info(e.getMessage());
            Assert.fail();
        }

    }
}
