package com.dsg.cucumber.step_definitions.sb.dsg.mobile;


import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class Regression_SB_001_Validate_Top_Search_Keys_mobile {
    private static final Logger logger = Logger.getLogger(Regression_SB_001_Validate_Top_Search_Keys_mobile.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods= new CommonElementMethods();
    @When("we search for top10 keywords in the search box on mobile:")
    public void we_enter(List<String> keyWord) throws Exception {
        for(int i=0; i<keyWord.size();i++) {
            String key = keyWord.get(i);
            commonMethods.enterValueWhenVisible(HomePage.searchTextBox, key, timeout);
            if(commonMethods.getListSize(HomePage.suggestionSearchCloseIcon, timeout) >0){
                commonMethods.clickWhenVisible(HomePage.suggestionSearchCloseIcon, timeout);
                System.out.println("Found X window to close");
            }
            commonMethods.clickWhenVisible(HomePage.searchIconMobile, timeout);
            Thread.sleep(5000);
            boolean isVisible = commonMethods.isElementVisible(By.xpath("//div[contains(text(), 'results for \""+key+"\"')]"), timeout);
            if(!isVisible){
                Assert.fail("Search DID NOT return any results for: "+key);
            }
            //to improve performance, comment out below validation
//            boolean shouldNotBeVisible = commonMethods.isElementVisible(By.xpath("//*[contains(text(), 'Due to exceptional demand, \""+key+"\" are unavailable in your area. Please clear the filters below and change your store location to see what might be available.')]"), 5);
//            if(shouldNotBeVisible){
//                Assert.fail("Search DID NOT return any results for: "+key);
//            }
            commonMethods.clickWhenVisible(HomePage.clearIcon, timeout);
        }
    }
}
