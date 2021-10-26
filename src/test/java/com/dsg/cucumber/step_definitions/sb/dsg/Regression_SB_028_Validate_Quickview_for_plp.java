package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.SrlpAndPlpPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regression_SB_028_Validate_Quickview_for_plp {
    private static final Logger logger = Logger.getLogger(Regression_SB_028_Validate_Quickview_for_plp.class);
    private static final Integer timeout = 10;

    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we validate addToCart quick view by filtering {string}")
    public void validate_quick_view(String brandName) throws Exception {
        int totalBrandNumber = 0;
        WebElement brandNameCheckBox = Base.getDriver().findElement(By.xpath("//div[@alt='"+brandName+"']/span"));
        commonMethods.clickWhenVisible(brandNameCheckBox, timeout);
        Thread.sleep(3000);
        WebElement getVibeText = Base.getDriver().findElement(By.xpath("//div[@alt='"+brandName+"']"));
        String text = getVibeText.getText();
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(text);
        while(m.find()) {
            totalBrandNumber = Integer.parseInt(m.group(1));
    }
        List<WebElement> countAddToCart = Base.getDriver().findElements(SrlpAndPlpPage.addToCartButton);
        int countTotalAddToCart = countAddToCart.size();
        if(totalBrandNumber == countTotalAddToCart){
            logger.info("All items have 'AddToCart Button' ");
        }else{
            Assert.fail("AddToCart Button MAY BE MISSING"+".: Total Items: "+
                    totalBrandNumber+" | Items having AddToCart button "+countTotalAddToCart);
        }
    }
}

