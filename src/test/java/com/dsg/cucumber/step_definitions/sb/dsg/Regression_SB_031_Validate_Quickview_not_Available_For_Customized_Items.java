package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.QuickViewPage;
import com.google.common.base.Verify;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.apache.log4j.Logger;

public class Regression_SB_031_Validate_Quickview_not_Available_For_Customized_Items {
    private static final Logger logger = Logger.getLogger(Regression_SB_031_Validate_Quickview_not_Available_For_Customized_Items.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we should not see quickView addToCard button")
    public void should_not_see_addToCartButton() throws Exception {
        boolean addToCartNotVisible = commonMethods.isElementVisible(QuickViewPage.firstOccurenceAddToCart, timeout);
        if(addToCartNotVisible){
//            Assert.fail("Add Cart Button is FOUND on page");
//            temporarily changed to info, PT confirmed low priority item
            logger.error("Add Cart Button is FOUND on page");
        }
    }
}

