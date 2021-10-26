package com.dsg.cucumber.step_definitions.pdp.dsg;
import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;

public class PDP_012_ATC_Custom_Helmet {
    private static final Logger logger = Logger.getLogger(PDP_002_ATC_Apparel.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @And("we select the size Medium on customizer")
    public void weSelectTheSizeMediumOnCustomizer() {

        try {
        Base.getDriver().switchTo().frame(0);
        commonMethods.clickWhenVisible(ProductDetailsPage.sizeMedium, timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we select the size {string} on customizer")
    public void weSelectTheSizeOnCustomizer(String arg0) {
        {

            try {
                Base.getDriver().switchTo().frame(0);
                if(arg0.equalsIgnoreCase("Medium")){
                commonMethods.clickWhenVisible(ProductDetailsPage.customSizeMedium, timeout);}
                else if(arg0.equalsIgnoreCase("Large"))
                {
                    commonMethods.clickWhenVisible(ProductDetailsPage.customSizeLarge, timeout);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @And("we select the Facemask {string}")
    public void weSelectTheFacemask(String arg0) {
        try {
            if(arg0.equalsIgnoreCase("S2BD-HS4"))
            commonMethods.clickWhenVisible(ProductDetailsPage.facemaskS2BDHS4, timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @And("we select the color Black on customizer")
    public void weSelectTheColorBlackOnCustomizer() {
        try {
            commonMethods.clickWhenVisible(ProductDetailsPage.colorBlackFacemask, timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
