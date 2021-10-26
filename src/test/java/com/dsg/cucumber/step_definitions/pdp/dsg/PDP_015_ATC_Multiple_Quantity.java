package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class PDP_015_ATC_Multiple_Quantity {
    private static final Logger logger = Logger.getLogger(PDP_015_ATC_Multiple_Quantity.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

   @When ("we select the size Large")
   public void select_large() throws Exception {
       commonMethods.clickWhenVisible(ProductDetailsPage.sizeLarge, timeout);
    }
    @When("we change the quantity desired to {string}")
    public void change_quantity(String desiredQuantity) throws Exception {
       System.out.println("desiredQuantity:"+desiredQuantity);
       commonMethods.clearWhenVisible(ProductDetailsPage.quantityBox);
       commonMethods.enterValueWhenVisible(ProductDetailsPage.quantityBox,desiredQuantity,timeout);
    }
    @When("we verify product quantity is {string}")
    public void verify_qty(String actualQty) throws Exception {
       WebElement itemQty = Base.getDriver().findElement(By.xpath("//input[@class='qtyInput ng-untouched ng-pristine ng-valid']"));
       String cartQtyValue = itemQty.getAttribute("value");
        if(cartQtyValue.equalsIgnoreCase(actualQty))
        {
            System.out.println(actualQty+"matches"+cartQtyValue);

        }
        else {
            Assert.fail(cartQtyValue + "Quantity does not equal " + actualQty);
        }
    }



}
