package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class PDP_019_Cart_Icon {
    private static final Logger logger = Logger.getLogger(PDP_019_Cart_Icon.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();


    @When("cart count value is {string}")
    public void verify_cartCount(String qty) throws Exception {
        Thread.sleep(2000);
        WebElement cartCount = Base.getDriver().findElement(By.xpath("//div[@class='order-qty']"));
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", cartCount);
        String cartCountValue = cartCount.getText();
        Assert.assertEquals(cartCountValue,qty);
    }

}
