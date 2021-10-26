package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.List;

public class Regression_SB_001_Validate_Top_Search_Keys {
    private static final Logger logger = Logger.getLogger(Regression_SB_001_Validate_Top_Search_Keys.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we search for top10 keywords in the search box:")
    public void we_enter(List<String> keyWord) throws Exception {
        for(int i=0; i<keyWord.size();i++) {
            String key = keyWord.get(i);
            commonMethods.enterValueWhenVisible(HomePage.searchTextBox, key, timeout);
            commonMethods.clickWhenVisible(HomePage.searchIcon, timeout);
            boolean isVisible = commonMethods.isElementVisible(By.xpath("//div[contains(text(), 'results for \""+key+"\"')]"), timeout);
            if(!isVisible){
                Assert.fail("Search DID NOT return any results for: "+key);
            }
            boolean shouldNotBeVisible = commonMethods.isElementVisible(By.xpath("//*[contains(text(), 'Due to exceptional demand, \""+key+"\" are unavailable in your area. Please clear the filters below and change your store location to see what might be available.')]"), 5);
            if(shouldNotBeVisible){
                Assert.fail("Search DID NOT return any results for: "+key);
            }
            //            BrowserUtilities.promotionHandler();
            commonMethods.clickWhenVisible(HomePage.clearIcon, timeout);
        }
    }
}
