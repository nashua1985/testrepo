package com.dsg.cucumber.step_definitions.pdp.dsg;
import com.dsg.cucumber.config.Base;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;


public class PDP_011_ATC_Custom_Jersey {
    private static final Logger logger = Logger.getLogger(PDP_010_ATC_Personalized_Golf_Balls.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we select Size 52")
    public void select_customSize52() throws Exception {
        commonMethods.clickWhenVisible(ProductDetailsPage.customSize52, timeout);
    }

    @When("we should see the customizer title")
    public void select_customTitle() throws Exception {
        commonMethods.isElementVisible(ProductDetailsPage.customTitle, timeout);
    }

    @When("we type {string} in Player Name field and {string} in the Player Number field")
    public void enter_customNameNumber(String name, String number) throws Exception {
        Base.getDriver().switchTo().frame(0);
        commonMethods.enterValueWhenVisible(ProductDetailsPage.customJerseyName,name,timeout);
        commonMethods.enterValueWhenVisible(ProductDetailsPage.customJerseyNumber,number,timeout);
    }

    @And("we type {string} in Player Name field and {string} in the Player Number field for mobile")
    public void weTypeInPlayerNameFieldAndInThePlayerNumberFieldForMobile(String name, String number) throws Exception {
        //Base.getDriver().switchTo().frame(0);
        commonMethods.switchToFrame(By.xpath("//iframe[@class='customizer-iframe ng-star-inserted']"),timeout);
        commonMethods.clickWhenVisible(ProductDetailsPage.customNext, timeout);
        commonMethods.enterValueWhenVisible(ProductDetailsPage.customJerseyName,name,timeout);
        commonMethods.clickWhenVisible(ProductDetailsPage.customNext, timeout);
        commonMethods.enterValueWhenVisible(ProductDetailsPage.customJerseyNumber,number,timeout);
    }

    @When("we click Next in the customizer")
    public void select_customNext() throws Exception {
        commonMethods.clickWhenVisible(ProductDetailsPage.customNext, timeout);
    }
    @When("we click Save Selections")
    public void select_customSaveSelection() throws Exception {
        commonMethods.clickWhenVisible(ProductDetailsPage.customSaveSelection, timeout);
        commonMethods.switchToDefault(10);
    }


}