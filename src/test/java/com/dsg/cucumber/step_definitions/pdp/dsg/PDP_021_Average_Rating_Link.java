package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class PDP_021_Average_Rating_Link {
    private static final Logger logger = Logger.getLogger(PDP_021_Average_Rating_Link.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we click on the average rating link")
    public void click_avgRating() throws Exception {
        commonMethods.clickWhenVisible(ProductDetailsPage.ratingsButton, timeout);
    }

    @When("we search reviews for {string}")
    public void search_reviews(String searchTerm) throws Exception {
        commonMethods.enterValueWhenVisible(ProductDetailsPage.searchReviewtext,searchTerm,timeout);
        //commonMethods.clickWhenVisible(ProductDetailsPage.reviewSearch, timeout);
        JavascriptExecutor js = (JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].click();", Base.getDriver().findElement(ProductDetailsPage.reviewSearch));
    }

    @And("we search reviews again for {string}")
    public void weSearchReviewsAgainFor(String searchTerm) {
        try {
            Base.getDriver().findElement(ProductDetailsPage.searchReviewLightBoxtext).clear();
            commonMethods.enterValueWhenVisible(ProductDetailsPage.searchReviewLightBoxtext,searchTerm,timeout);
            List<WebElement> searchBtns=Base.getDriver().findElements(ProductDetailsPage.reviewSearch);
            commonMethods.clickWhenVisible(searchBtns.get(1), timeout);
        } catch (Exception e) {
            Assert.fail("Search review is not VISIBLE");
        }
    }

    @And("we search reviews again for {string} for mobile")
    public void weSearchReviewsAgainForForMobile(String searchTerm) {
        try {
            Base.getDriver().findElement(ProductDetailsPage.searchReviewLightBoxtext).clear();
            commonMethods.enterValueWhenVisible(ProductDetailsPage.searchReviewLightBoxtext,searchTerm,timeout);
            JavascriptExecutor js = (JavascriptExecutor)Base.getDriver();
            js.executeScript("arguments[0].click();", Base.getDriver().findElement(ProductDetailsPage.reviewSearch));
        } catch (Exception e) {
            Assert.fail("Search review is not VISIBLE");
        }
    }
}
