package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_024_BOPIS_ATC;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Regression_Checkout_010 {
    private static final Logger logger = Logger.getLogger(Regression_Checkout_010.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();
    PDP_024_BOPIS_ATC reg1=new PDP_024_BOPIS_ATC();

    @And("we add a BOPIS product {string} to the cart")
    public void weAddABOPISProductToTheCart(String arg0) {

        try {
            commonMethods.enterValueWhenVisible(HomePage.searchTextBox, arg0, timeout);
            Thread.sleep(3000);//monitor behaviour of SB_032_041, when searching it goes directly to pdp
            commonMethods.clickWhenVisible(HomePage.searchIcon, timeout);
            commonMethods.getWebElement(By.xpath("//button[text()='Ship To Me']"),timeout);
            reg.clickwithJavascript(By.xpath("//button[text()='Ship To Me']"));

            Thread.sleep(3000);

            if(commonMethods.isElementVisible(HomePage.closePromoWindow,timeout))
            {
                commonMethods.clickWhenVisible(HomePage.closePromoWindow, timeout);
            }

            /*commonMethods.getWebElement(ProductDetailsPage.firstProductInGrid,timeout);
            reg.clickwithJavascript(ProductDetailsPage.firstProductInGrid);*/
            commonMethods.clickWhenVisible(ProductDetailsPage.firstProductInGrid,timeout);

            List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
            if(colorList.size()>0) {
                new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button")));
                commonMethods.clickWhenVisible(colorList.get(0), timeout);
            }
            else
            {
                List<WebElement> colorList2 = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/span/button"));
                commonMethods.clickWhenVisible(colorList2.get(0), timeout);
            }

            reg1.weCheckBOPISAvailability();

            commonMethods.isElementVisible(ProductDetailsPage.addToCart,40);

            commonMethods.clickWhenVisible(ProductDetailsPage.addToCart,timeout);
            commonMethods.clickWhenVisible(ProductDetailsPage.goToCart,timeout);
            commonMethods.isElementVisible(ProductDetailsPage.cart_title, 5);
            //reg.clickwithJavascript(By.xpath("//a[contains(text(),'GO TO CART')]"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @And("we validate product Info for the parcel item")
    public void weValidateProductInfoForTheParcelItem() {
        List<WebElement> products=Base.getDriver().findElements(By.xpath("//p[@class='grid-description font-weight-bold details-text details-text--emphasized']"));

            System.out.println(products.get(1).getText());
            if(!(products.get(1).getText().contains("Headband")))
            {
                Assert.fail("ParcelItem Product information not visible");
            }

    }

    @And("we validate EDD for the parcel item")
    public void weValidateEDDForTheParcelItem() {
        try {
            Thread.sleep(2000);
        String delivery=Base.getDriver().findElement(checkoutPage.estDelivery).getText();
        System.out.println("parcel Delivery-----"+delivery);
        if(delivery==null ||delivery.equals(""))
        {
            Assert.fail("Estimated Delivery Date not available");
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("we validate product info for the oversized item")
    public void weValidateProductInfoForTheOversizedItem() {
        List<WebElement> products=Base.getDriver().findElements(By.xpath("//p[@class='grid-description font-weight-bold details-text details-text--emphasized']"));

            System.out.println(products.get(0).getText());
            if(!(products.get(0).getText().contains("Kayak")))
            {
                Assert.fail("Oversize Product information not visible");
            }

        try {
            if(!(commonMethods.isElementVisible(checkoutPage.largeitemshipping,timeout)))
            {
                Assert.fail("Large item shipping detail not available");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we validate EDD for the oversized item")
    public void weValidateEDDForTheOversizedItem() {


        try {

            Thread.sleep(2000);
            List<WebElement> edd=Base.getDriver().findElements(checkoutPage.estDelivery);
            if(edd.size()<2)
            {
                Assert.fail("Delivery date not available");
            }
            reg.check_message_("Curbside");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we validate the product info for the BOPIS item")
    public void weValidateTheProductInfoForTheBOPISItem() throws Exception {
        List<WebElement> products=Base.getDriver().findElements(By.xpath("//p[@class='grid-description font-weight-bold details-text details-text--emphasized']"));
            System.out.println(products.get(2).getText());
            if(!(products.get(2).getText().contains("YETI")))
            {
                Assert.fail("BOPIS Item Product information not visible");
            }

    }

    @And("we validate the store infor for the BOPIS item")
    public void weValidateTheStoreInforForTheBOPISItem() throws Exception {
        if(!(commonMethods.isElementVisible(checkoutPage.bopisStoreInfo,timeout)))
        {
            Assert.fail("Store Info not available");
        }
    }

    @And("we validate the BOPIS product has no EDD")
    public void weValidateTheBOPISProductHasNoEDD() {
        try {
            reg.check_message_("Pickup at");
            reg.check_message_("Curbside & In-Store pickup available.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
