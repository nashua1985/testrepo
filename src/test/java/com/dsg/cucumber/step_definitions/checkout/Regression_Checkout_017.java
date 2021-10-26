package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_024_BOPIS_ATC;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Regression_Checkout_017 {
    private static final Logger logger = Logger.getLogger(Regression_Checkout_017.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    String bopisProduct, bopisQuantity, parcelName, parcelQuantity,oversized,oversizedQuantity,storename;
    List<String> procNames = new ArrayList<String>();
    List<String> procQuantities = new ArrayList<String>();
    List<String> procNamesRemoval = new ArrayList<String>();
    List<String> estDeliverydates= new ArrayList<String>();

    @And("we remember product name, attributes, and qty for items in cart")
    public void weRememberProductNameAttributesAndQtyForItemsInCart() {

        if(procNames!=null && !procNames.isEmpty())
        {
            procNames.clear();//to clear the previous values if any
        }
        if(procQuantities!=null && !procQuantities.isEmpty())
        {
            procQuantities.clear();//to clear the previous values if any
        }
        new WebDriverWait(Base.getDriver(), timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='product-name']")));
        List<WebElement> productNames=Base.getDriver().findElements(By.xpath("//p[@class='product-name']"));

        new WebDriverWait(Base.getDriver(), timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='qtyInput ng-untouched ng-pristine ng-valid']")));
        List<WebElement> quantity=Base.getDriver().findElements(By.xpath("//input[@class='qtyInput ng-untouched ng-pristine ng-valid']"));

        for(int i=0;i<productNames.size();i++) {
            productNames=Base.getDriver().findElements(By.xpath("//p[@class='product-name']"));
            quantity=Base.getDriver().findElements(By.xpath("//input[@class='qtyInput ng-untouched ng-pristine ng-valid']"));

            bopisProduct = productNames.get(i).getText();
            System.out.println(bopisProduct);
            procNames.add(bopisProduct);
            bopisQuantity = quantity.get(i).getAttribute("value");
            System.out.println("bopisQuantity" + bopisQuantity);
            procQuantities.add(bopisQuantity);
            /*parcelName = productNames.get(1).getText();
            System.out.println("parcelName" + parcelName);
            procNames.add(parcelName);
            parcelQuantity = quantity.get(1).getText();
            System.out.println("parcelQuantity" + parcelQuantity);
            oversized = productNames.get(2).getText();
            System.out.println("oversized" + oversized);
            procNames.add(oversized);
            oversizedQuantity = quantity.get(2).getText();
            System.out.println("oversizedQuantity" + oversizedQuantity);*/
        }

    }

    @And("we remember BOPIS store name")
    public void weRememberBOPISStoreName() throws Exception {
        WebElement storenames=commonMethods.getWebElement(By.xpath("//p[@class='not-selectable__text not-selectable__text--store-name ng-star-inserted']"),timeout);
         storename=storenames.getText();
    }

    @And("billing address is {string}")
    public void billingAddressIs(String arg0) {
        List<WebElement> BAddr=Base.getDriver().findElements(By.xpath("//div[@id='billingAddress']/p"));
        String billingAdd=BAddr.get(1).getText();
        billingAdd=billingAdd.substring(0,billingAdd.length()-5);
        System.out.println(billingAdd);
        System.out.println(arg0);
        if(!(arg0.contains(billingAdd)))
        {
            Assert.fail("Billing address not as expected");
        }
    }

    @And("shipping address is {string}")
    public void shippingAddressIs(String arg0) {
        List<WebElement> ShipAddr=Base.getDriver().findElements(By.xpath("//div[@id='shippingDeliveryMethods']/div/div/p"));
        String shippingAdd=ShipAddr.get(2).getText();
        shippingAdd=shippingAdd.substring(0,shippingAdd.length()-5);
        System.out.println(shippingAdd);
        System.out.println(arg0);
        if(!(arg0.contains(shippingAdd)))
        {
            Assert.fail("Shipping address not as expected");
        }
    }

    @And("we validate product name, attributes, and qty for items in cart")
    public void weValidateProductNameAttributesAndQtyForItemsInCart() {
        new WebDriverWait(Base.getDriver(), timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='grid-description font-weight-bold details-text details-text--emphasized']")));
        List<WebElement> CheckoutproductNames=Base.getDriver().findElements(By.xpath("//p[@class='grid-description font-weight-bold details-text details-text--emphasized']"));
        List<String> CheckoutproductFinal = new ArrayList<String>();
        List<String> CheckoutQuantityFinal = new ArrayList<String>();

        for(int i=0;i<CheckoutproductNames.size();i++)
        {
            String productName=CheckoutproductNames.get(i).getText();
            System.out.println(productName);
            CheckoutproductFinal.add(productName);
            /*if(!(productName.equalsIgnoreCase(procNames.get(i))))
            {
                Assert.fail("Product name did not match "+productName+"----"+procNames.get(i));
            }*/
        }
        List<WebElement> Checkoutquantity=Base.getDriver().findElements(By.xpath("//p[@class='grid-details details-text']"));
        for(int i=0;i<Checkoutquantity.size();i++)
        {
            System.out.println(Checkoutquantity.get(i).getText());
            CheckoutQuantityFinal.add(Checkoutquantity.get(i).getText());
        }

        //compare
        Collections.sort(CheckoutproductFinal);
        System.out.println(CheckoutproductFinal);
        Collections.sort(procNames);
        System.out.println(procNames);
        boolean boolval = CheckoutproductFinal.equals(procNames); //will return true if lists are equal
        System.out.println("the lists match"+boolval);
        if(boolval==false)
        {
            Assert.fail("The Product names don't match");
        }

        Collections.sort(CheckoutQuantityFinal);
        System.out.println(CheckoutQuantityFinal);
        Collections.sort(procQuantities);
        System.out.println(procQuantities);
        boolean boolval1 = CheckoutQuantityFinal.equals(procQuantities); //will return true if lists are equal
        System.out.println("the lists match"+boolval);
        if(boolval==false)
        {
            Assert.fail("The Quantities don't match");
        }

    }

    @And("we remember product name, attributes, and qty for items in cart after removal")
    public void weRememberProductNameAttributesAndQtyForItemsInCartAfterRemoval() {
        new WebDriverWait(Base.getDriver(), timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='product-name']")));
        List<WebElement> productNames=Base.getDriver().findElements(By.xpath("//p[@class='product-name']"));

        new WebDriverWait(Base.getDriver(), timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='qtyInput ng-untouched ng-pristine ng-valid']")));
        List<WebElement> quantity=Base.getDriver().findElements(By.xpath("//input[@class='qtyInput ng-untouched ng-pristine ng-valid']"));

        bopisProduct=productNames.get(0).getText();
        System.out.println(bopisProduct);
        procNamesRemoval.add(bopisProduct);
        bopisQuantity=quantity.get(0).getText();
        System.out.println("bopisQuantity"+bopisQuantity);
        parcelName=productNames.get(1).getText();
        System.out.println("parcelName"+parcelName);
        procNamesRemoval.add(parcelName);
        parcelQuantity=quantity.get(1).getText();
        System.out.println("parcelQuantity"+parcelQuantity);

    }
    @And("we validate BOPIS store name")
    public void weValidateBOPISStoreName() {
        try {
            WebElement store=commonMethods.getWebElement(By.xpath("//p[@class='delivery-group-title mb-0 font-weight-bold d-flex align-items-baseline']/span"),timeout);
            String actualStorename=store.getText();
            if(!(actualStorename.contains(storename)))
            {
                Assert.fail("The Store names dont match");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @And("we validate product name, attributes, and qty for items in cart after removal")
    public void weValidateProductNameAttributesAndQtyForItemsInCartAfterRemoval() {
        new WebDriverWait(Base.getDriver(), timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='grid-description font-weight-bold details-text details-text--emphasized']")));
        List<WebElement> CheckoutproductNames=Base.getDriver().findElements(By.xpath("//p[@class='grid-description font-weight-bold details-text details-text--emphasized']"));

        System.out.println(CheckoutproductNames.get(0).getText());
        for(int i=0;i<CheckoutproductNames.size();i++)
        {
            String productName=CheckoutproductNames.get(i).getText();
            if(!(productName.equalsIgnoreCase(procNamesRemoval.get(i))))
            {
                Assert.fail("Product name did not match "+productName+"----"+procNamesRemoval.get(i));
            }
        }
        List<WebElement> Checkoutquantity=Base.getDriver().findElements(By.xpath("//p[@class='grid-details details-text']"));
        for(int i=0;i<Checkoutquantity.size();i++)
        {
            System.out.println(Checkoutquantity.get(i).getText());
        }
    }

    @And("we change the BOPIS Store")
    public void weChangeTheBOPISStore() {
        try {
            commonMethods.clickWhenVisible(ProductDetailsPage.changeStorelink, timeout);
            List<WebElement> setStoreRadio=Base.getDriver().findElements(ProductDetailsPage.selectStoreradio);
            commonMethods.clickWhenVisible(setStoreRadio.get(0),timeout);
            JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", setStoreRadio.get(0));
            commonMethods.clickWhenVisible(ProductDetailsPage.selectStoreButton,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we click edit billing address link")
    public void weClickEditBillingAddressLink() {
        try {
            commonMethods.clickWhenVisible(By.id("editContactLabel"),timeout);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("we remember EDD for shipping containers")
    public void we_remember_EDD_for_shipping_containers() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> estDelivery=Base.getDriver().findElements(checkoutPage.estDelivery);
        System.out.println("expitedDelivery-----"+estDelivery.get(0).getText());
        for(int i=0;i<estDelivery.size();i++)
        {
            String date=estDelivery.get(i).getText();
            estDeliverydates.add(date);
        }

    }

    @Given("we validate EDD for shipping containers")
    public void we_validate_EDD_for_shipping_containers() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> expectedDelivery=Base.getDriver().findElements(checkoutPage.estDelivery);
        List<String> expectedDeliverydt=new ArrayList<>();
        System.out.println(expectedDelivery.get(0).getText());
        for(int i=0;i<expectedDelivery.size();i++)
        {
            String expectedDate=expectedDelivery.get(i).getText();
            expectedDeliverydt.add(expectedDate);
        }

        //compare
        Collections.sort(expectedDeliverydt);
        System.out.println(expectedDeliverydt);
        Collections.sort(estDeliverydates);
        System.out.println(estDeliverydates);
        boolean boolval = expectedDeliverydt.equals(estDeliverydates); //will return true if lists are equal
        System.out.println("the EDD match"+boolval);
        if(boolval==false)
        {
            Assert.fail("The estimated dates don't match");
        }
    }
}