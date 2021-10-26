package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;


public class PDP_018_Size_Chart {
    private static final Logger logger = Logger.getLogger(PDP_018_Size_Chart.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we click on the size chart")
    public void click_sizeChart() throws Exception {
        commonMethods.clickWhenVisible(By.className("size-chart"), timeout);
    }
    @Then("size chart is visible")
    public void sizeChartIsVisible() throws Exception {
        boolean isTextVisible = commonMethods.isElementVisible(ProductDetailsPage.sizeChartTitle, timeout);
        if (!isTextVisible) {
            Assert.fail("Size chart is not VISIBLE");
        }
    }
}
