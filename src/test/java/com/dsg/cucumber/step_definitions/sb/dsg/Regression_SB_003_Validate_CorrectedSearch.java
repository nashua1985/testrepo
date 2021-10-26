package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Map;

public class Regression_SB_003_Validate_CorrectedSearch{
    private static final Logger logger = Logger.getLogger(Regression_SB_003_Validate_CorrectedSearch.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we should see the corrected search for the following:")
    public void we_enter(Map<String, String> searchTerms) throws Exception {
        for(Map.Entry<String,String> keys: searchTerms.entrySet()){
            int flag = 0; //need to set the flag, as sometimes search engine will not correct the search term. Flag allows to run
            //the same search term twice.
            while(flag != 3){
                String invalidKey = keys.getKey();
                String validKey = keys.getValue();
                commonMethods.enterValueWhenVisible(HomePage.searchTextBox, invalidKey, timeout);
                commonMethods.clickWhenVisible(HomePage.searchIcon, timeout);
                boolean isVisible = commonMethods.isElementVisible(By.xpath("//div[contains(text(), 'results for \""+validKey+"\"')]"), timeout);
                if(!isVisible) {
                    flag++;
                }else{
                    flag = 3;
                }
                if(flag == 2){
                        Assert.fail("Searching term is not corrected, expected:  "+validKey);
                    }
                commonMethods.clickWhenVisible(HomePage.clearIcon, timeout);
               }
            }
    }
}

