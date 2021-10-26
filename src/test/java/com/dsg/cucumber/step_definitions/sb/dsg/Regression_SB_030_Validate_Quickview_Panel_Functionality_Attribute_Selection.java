package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.SrlpAndPlpPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import java.util.List;

public class Regression_SB_030_Validate_Quickview_Panel_Functionality_Attribute_Selection {
    private static final Logger logger = Logger.getLogger(Regression_SB_030_Validate_Quickview_Panel_Functionality_Attribute_Selection.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we validate attribute selection in quick view")
    public void validate_quick_view() throws Exception {
        List<WebElement> countAddToCart = Base.getDriver().findElements(SrlpAndPlpPage.addToCartButton);
        int countTotalAddToCart = countAddToCart.size();
        for (int i = 1; i < countTotalAddToCart; i++) {
            List<WebElement> attributeCount = Base.getDriver().findElements(By.xpath(("(//div[@class=' dsg-flex flex-column rs_card_layout quickviewButton '])[" + i + "]//li")));
            int attributeCountSize = attributeCount.size();
            logger.info("color attributes found: " + attributeCountSize);
            if (attributeCountSize > 1 ){//color attribute is more than 1 option for an item displayed
                logger.info("after if statement 'i': " + i);
                WebElement addToCartItem = Base.getDriver().findElement(By.xpath("(//span[text()=' ADD TO CART' or text()='ADD TO CART'])[" + i + "]"));
                commonMethods.clickWhenVisible(addToCartItem,timeout);
                break;
            } else {
                logger.info("skipping item as it has only one color attribute");
            }
        }
    }
}

