package com.dsg.cucumber.step_definitions.athlete;

import com.dsg.cucumber.framework.CommonElementMethods;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class Regression_ATHLETE_005_my_account_page_and_name_in_header {
    private static final Logger logger = Logger.getLogger(Regression_ATHLETE_005_my_account_page_and_name_in_header.class);
    private static final Integer timeout = 10;

    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we should land on Sign In page by validating headers")
    public void we_should_land_on_sign_in_page_by_validating_headers(List<String> headerList) throws Exception {
        for(int i = 0; i < headerList.size();i++){
            boolean isTextVisible = commonMethods.isElementVisible(By.xpath("//h1[contains(text(), \"" + headerList.get(i) + "\")]"), timeout);
            if (!isTextVisible) {
                Assert.fail(headerList + " is not VISIBLE");
            }
        }
    }
}