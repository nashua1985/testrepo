package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.framework.CommonElementMethods;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;


public class PDP_017_Image_Viewer {
    private static final Logger logger = Logger.getLogger(PDP_017_Image_Viewer.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we click on the product image")
    public void click_image() throws Exception {
        commonMethods.clickWhenVisible(By.className("img-fluid"), timeout);
    }


    @When("we validate the image viewer")
    //this one needs help- cannot find the icons in the image viewer. I believe its a frame issue. This should ideally validate the "close" of the frame too
    public void validate_imageViewer() throws Exception {
        try {
            if(commonMethods.isElementVisible(By.xpath("//button[@class='lg-next lg-icon']"),timeout))
            {
                commonMethods.clickWhenVisible(By.xpath("//button[@class='lg-next lg-icon']"), timeout);
                commonMethods.clickWhenVisible(By.className("//button[@class='lg-next lg-icon']"), timeout);
            }
            else
                Assert.fail("Image not visible");
            commonMethods.clickWhenVisible(By.xpath("//button[@class='lg-next lg-icon']"), timeout);
            commonMethods.clickWhenVisible(By.className("//button[@class='lg-next lg-icon']"), timeout);
            commonMethods.clickWhenVisible(By.id("lg-zoom-in"), timeout);
            commonMethods.clickWhenVisible(By.id("lg-zoom-out"), timeout);
        }
        catch(Exception e)
        {
            logger.info(e.getMessage());
            Assert.fail();
        }
    }

    @When("we click close")
    public void click_close() throws Exception {
        commonMethods.clickWhenVisible(By.xpath("//button[@class='btn btn-close']/i"), timeout);
    }


}
