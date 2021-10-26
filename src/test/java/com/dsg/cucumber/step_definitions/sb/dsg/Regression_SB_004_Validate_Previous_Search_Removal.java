package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Regression_SB_004_Validate_Previous_Search_Removal {
    private static final Logger logger = Logger.getLogger(Regression_SB_004_Validate_Previous_Search_Removal.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we clear the search box and should not see {string}")
    public void we_clear_the_search_box_and_should_not_see(String keyWord) throws Exception {
//        BrowserUtilities.promotionHandler();
        commonMethods.clickWhenVisible(HomePage.clearIcon, timeout);
        boolean isSearchTermVisible = commonMethods.isElementVisible(By.xpath("//input[@id='SearchBoxText' and @value='"+keyWord+"']"),timeout);
            if(isSearchTermVisible) {
                Assert.fail("Search Term was NOT CLEARED. Found: "+keyWord);
            }
    }
}

