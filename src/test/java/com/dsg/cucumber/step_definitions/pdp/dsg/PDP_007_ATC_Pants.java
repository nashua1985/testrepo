package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class PDP_007_ATC_Pants {
    private static final Logger logger = Logger.getLogger(PDP_007_ATC_Pants.class);
    private static final Integer timeout = 30;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();

    @When("we filter by the pant size 32 and inseam 32")
    public void filter_colorBlack_sizeMedium() throws Exception {
        //BrowserUtilities.promotionHandler();
        if(commonMethods.isElementVisible(HomePage.closePromoWindow,timeout))
        {
            commonMethods.clickWhenVisible(HomePage.closePromoWindow,timeout);
        }
        WebElement redCheckbox = Base.getDriver().findElement(By.xpath("//button[@aria-label='[object Object]_facet_value_32']"));
        WebElement elevenCheckbox= Base.getDriver().findElement(By.xpath("//button[@aria-label='checkbox_1925_4']"));
        commonMethods.clickWhenVisible(redCheckbox, timeout);
        commonMethods.clickWhenVisible(elevenCheckbox,timeout);
        Thread.sleep(3000);
    }

    @When("we select pant size 32 and inseam 32")
    public void select_size_and_inseam() throws Exception {


        try {
            if(commonMethods.isElementVisible(ProductDetailsPage.pantSize32,timeout)){
                reg.clickwithJavascript(ProductDetailsPage.pantSize32);
            }
            else
            {
                List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
                commonMethods.clickWhenVisible(colorList.get(0), timeout);
            }

            if(commonMethods.isElementVisible(ProductDetailsPage.inseam32,timeout)){
                reg.clickwithJavascript(ProductDetailsPage.inseam32);
            }
            else
            {
                List<WebElement> sizeList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
                commonMethods.clickWhenVisible(sizeList.get(0), timeout);
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }


    @And("we filter by gender {string}")
    public void weFilterByGender(String arg0) {
        try {

            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(ProductDetailsPage.gendermens));
            //check if the filter is expanded or not
            if(commonMethods.isElementVisible(ProductDetailsPage.gendermens,timeout))
            {
                commonMethods.clickWhenVisible(ProductDetailsPage.gendermens,timeout);
            }
            else{
                reg.clickwithJavascript(ProductDetailsPage.genderFilter);
                commonMethods.clickWhenVisible(ProductDetailsPage.gendermens,timeout);
            }

        }
        catch(TimeoutException e) {
            System.out.println("Timeout occured");
        }
        catch(Exception e)
        {
            logger.info(e.getMessage());
            Assert.fail();
        }
    }
}
