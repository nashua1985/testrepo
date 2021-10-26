package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.apache.log4j.Logger;
import java.util.List;

public class Regression_SB_005_Validate_SearchSuggest {
    private static final Logger logger = Logger.getLogger(Regression_SB_005_Validate_SearchSuggest.class);
    private static final Integer timeout = 10;
    private static final String EXACT_SEARCH = "There is an exact suggested search for keyWord: ";
    private static final String NO_EXACT_SEARCH = "No exact search suggestions found for: ";
    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we should see the suggested search for the following:")
    public void we_enter(List<String> keyWord) throws Exception {
        for (int i = 0; i < keyWord.size(); i++) {
                String key = keyWord.get(i);
                for (int k = 0; k < keyWord.get(i).length(); k++) {
                    char c = keyWord.get(i).charAt(k);
                    String keyC = Character.toString(c);//have to mimic human typing as suggestion engine indexes a char at a time
                    commonMethods.enterValueWhenVisible(HomePage.searchTextBox, keyC, timeout);
                }
                try {
                    if (commonMethods.isElementVisible(By.xpath("(//span[text()='" + key + "'])[1]"), timeout)) {
                        logger.info(EXACT_SEARCH + keyWord.get(i));
                        commonMethods.clickWhenVisible(HomePage.clearIcon, timeout);
                    }
                } catch (Exception e) {
                    if (e.toString().contains("TimeoutException")) {
                        logger.info(NO_EXACT_SEARCH + keyWord.get(i));
                        Assert.fail(e.getMessage());
                    }
                }
            }
    }
}

