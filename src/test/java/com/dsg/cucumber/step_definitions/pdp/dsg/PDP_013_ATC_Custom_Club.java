package com.dsg.cucumber.step_definitions.pdp.dsg;
import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import com.dsg.testng.web.resources.WebNavigation;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;

public class PDP_013_ATC_Custom_Club {
    private static final Logger logger = Logger.getLogger(PDP_013_ATC_Custom_Club.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();
    WebNavigation nav;


    @And("we select the gender {string} and the hand {string}")
    public void weSelectTheGenderAndTheHand(String arg0, String arg1) {
        Base.getDriver().switchTo().frame(0);

        try {
            if(arg1.equalsIgnoreCase("left")) {
                reg.clickwithJavascript(ProductDetailsPage.handLeft);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @And("we select the loft {string}")
    public void weSelectTheLoft(String arg0) {
        try {
            commonMethods.selectDropDownByText(ProductDetailsPage.loftDropdown,20,arg0);
            //commonMethods.clickWhenVisible(ProductDetailsPage.loft9, timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*@When("we select the shaft manufacturer Fujikura")
    public void select_shaftFujikura() throws Exception {
        commonMethods.clickWhenVisible(ProductDetailsPage.shaftManufacturerDropDown, timeout);
        commonMethods.clickWhenVisible(ProductDetailsPage.shaftFujikura, timeout);
    }*/

    @And("we select the shaft manufacturer {string}")
    public void weSelectTheShaftManufacturer(String arg0) {
        try {
            commonMethods.selectDropDownByText(ProductDetailsPage.shaftManufacturerDropDown,20,arg0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* @When("we select the length Women's Standard")
    public void select_lengthWomensStandard() throws Exception {
        commonMethods.clickWhenVisible(ProductDetailsPage.driverLengthDropdown, timeout);
        commonMethods.clickWhenVisible(ProductDetailsPage.driverLengthWomensStandard, timeout);
    }*/

    @And("we select the length {string}")
    public void weSelectTheLength(String arg0) {
        try {
            commonMethods.selectDropDownByText(ProductDetailsPage.driverLengthDropdown,20,arg0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @And("we select the gripbrand {string}")
    public void weSelectTheGripbrand(String arg0) {
        try {
            commonMethods.selectDropDownByText(ProductDetailsPage.gripBrandDropdown,20,arg0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

