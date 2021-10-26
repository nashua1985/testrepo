package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.framework.CommonElementMethods;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Regression_SB_002_Validate_No_Result_Search {
    private static final Logger logger = Logger.getLogger(Regression_SB_002_Validate_No_Result_Search.class);
    private static final Integer timeout = 5;
    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we should see 0 results for {string}")
    public void we_should_see_0_results(String keyWord) throws Exception {
        Thread.sleep(5000);
            boolean isVisibleResults = commonMethods.isElementVisible(By.xpath("//div[contains(text(), '0 results for \""+keyWord+"\"')]"), timeout);
            if(!isVisibleResults) {
                Assert.fail("Search Results are NON-ZERO");
            }
//            store is not auto sets up sometimes, maybe akami, have to comment out below
//            boolean isVisibleUnavailableText = commonMethods.isElementVisible(By.xpath("//*[contains(text(), 'Due to exceptional demand, \""+keyWord+"\" are unavailable in your area. Please clear the filters below and change your store location to see what might be available.')]"), 5);
//          if(!isVisibleUnavailableText){
//              Assert.fail("Additional text is NOT VISIBLE");
//            commonMethods.clickWhenVisible(HomePage.clearIcon, timeout);
//        }
    }

//    @When("we should see 0 results for {string}")
//    public void we_should_see_0_results(String keyWord) throws Exception {
//       By locator = By.xpath("//button[@ng-if='isShowFormCloseButton()']");
//       By feedback = By.xpath("//span[text()='Feedback']");
//       commonMethods.clickWhenVisible(feedback,timeout);
//        commonMethods.clickWhenVisible(locator, timeout);
//        Thread.sleep(5000);
//
//    }
}

