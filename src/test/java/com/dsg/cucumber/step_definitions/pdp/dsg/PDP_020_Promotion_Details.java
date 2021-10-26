package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;


public class PDP_020_Promotion_Details {
    private static final Logger logger = Logger.getLogger(PDP_020_Promotion_Details.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we click promotion description text")
    public void click_promoDetails() throws Exception {
        commonMethods.clickWhenVisible(By.className("promotion-description-text"), timeout);
    }

    @Then("promotion description is visible")
    public void promotionDescriptionIsVisible() throws Exception {
        boolean isTextVisible = commonMethods.isElementVisible(ProductDetailsPage.promodescTitle, timeout);
        if (!isTextVisible) {
            Assert.fail("Promotion Desc is not VISIBLE");
        }
    }

}
