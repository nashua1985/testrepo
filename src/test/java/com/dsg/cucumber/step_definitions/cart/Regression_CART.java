package com.dsg.cucumber.step_definitions.cart;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.cart.CartPage;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.util.List;

public class Regression_CART {
    private static final Logger logger = Logger.getLogger(PDP_001_ATC_Yeti.class);
    private static final Integer timeout = 50;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();
    String productprice,productOrgprice;


    @And("we remember the product price")
    public void weRememberTheProductPrice() {
        List<WebElement> price= Base.getDriver().findElements(CartPage.productPrice);
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",price.get(0));
        js.executeScript("arguments[0].style.border='3px solid red'",price.get(0));
        if(price.size()>1) {
            productprice = price.get(1).getText();
        }
        else
        {
            productprice = price.get(0).getText();
        }
        productprice = productprice.replaceAll("\\s", "");
        System.out.println("productprice----"+productprice);
    }

    @And("we verify the product price")
    public void weVerifyTheProductPrice() {
        WebElement price= Base.getDriver().findElement(CartPage.cartProductPrice);
        String cartPrice=price.getText();
        cartPrice = cartPrice.substring(0, cartPrice.length() - 2);
        cartPrice = cartPrice.replaceAll("\\s", "");
        if(cartPrice.equalsIgnoreCase(productprice))
        {
            System.out.println(cartPrice+"Price Matches"+productprice);
            Assert.assertEquals(cartPrice,productprice);
        }
        else {
            Assert.fail(cartPrice + "Product price doesn't match" + productprice);
        }
    }


    @And("we verify the discounted product price")
    public void weVerifyTheDiscountedProductPrice() {
        new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(CartPage.cartDiscountedProductPrice));
        WebElement price= Base.getDriver().findElement(CartPage.cartDiscountedProductPrice);
        String cartPrice=price.getText();
        cartPrice = cartPrice.substring(0, 7);
        cartPrice = cartPrice.replaceAll("\\s", "");
        if(cartPrice.equalsIgnoreCase(productprice))
        {
            System.out.println(cartPrice+"Price Matches"+productprice);
            Assert.assertEquals(cartPrice,productprice);
        }
        else {
            Assert.fail(cartPrice + "Product price doesn't match" + productprice);
        }
    }

    @And("we sort by Price High to Low")
    public void weSortByPriceHighToLow() {
        reg.clickwithJavascript(CartPage.sortDropdown);
        reg.clickwithJavascript(CartPage.priceHighToLow);
    }

    @And("we select attributes for sale item")
    public void weSelectAttributesForSaleItem() {

        try {

            //select the color
            List<WebElement> colorListSale = Base.getDriver().findElements(By.xpath("//div[@id='attr_Color1']/div/div/pdp-color-attribute/div/div[@class='color-attributes-container sliding_row_inner']/span/button"));
            if(commonMethods.isElementVisible(By.xpath("//div[@id='attr_Color1']/div/div/pdp-color-attribute/div/div[@class='color-attributes-container sliding_row_inner']/span/button"),timeout)) {
                commonMethods.clickWhenVisible(colorListSale.get(0), timeout);
            }

            else
            {
                //select the color
                List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
                commonMethods.clickWhenVisible(colorList.get(1), timeout);
            }
            //select the size
            List<WebElement> sizeList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
            commonMethods.clickWhenVisible(sizeList.get(0), timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @And("we select attributes")
    public void weSelectAttributes() {
        try {

        //select the color
            List<WebElement> colorListSale = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/span/button"));
            if(commonMethods.isElementVisible(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/span/button"),timeout)) {
                commonMethods.clickWhenVisible(colorListSale.get(0), timeout);
            }

        else
        {
            //select the color
            List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
            commonMethods.clickWhenVisible(colorList.get(1), timeout);
        }
        //select the size
            List<WebElement> sizeList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
            commonMethods.clickWhenVisible(sizeList.get(0), timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we remember the original price")
    public void weRememberTheOriginalPrice() {
        //price before sale
        WebElement orgPrice= Base.getDriver().findElement(CartPage.productOriginalPrice);
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",orgPrice);
        js.executeScript("arguments[0].style.border='3px solid red'",orgPrice);
        productOrgprice=orgPrice.getText();
        productOrgprice = productOrgprice.replaceAll("\\s", "");
    }

    @And("we verify the original price")
    public void weVerifyTheOriginalPrice() {
        WebElement price= Base.getDriver().findElement(CartPage.cartStrikethrProductPrice);
        String cartStrikePrice=price.getText();
        cartStrikePrice = cartStrikePrice.substring(0, cartStrikePrice.length() - 1);
        cartStrikePrice = cartStrikePrice.replaceAll("\\s", "");
        productOrgprice=productOrgprice.substring(4,productOrgprice.length());
        if(cartStrikePrice.equalsIgnoreCase(productOrgprice))
        {
            System.out.println(cartStrikePrice+"Price Matches"+productOrgprice);
            Assert.assertEquals(cartStrikePrice,productOrgprice);
        }
        else {
            Assert.fail(cartStrikePrice + "Product price doesn't match" + productOrgprice);
        }
    }

    @And("we filter by sale items")
        public void weFilterBySaleItems() {
        reg.clickwithJavascript(ProductDetailsPage.saleFilter);
        reg.clickwithJavascript(ProductDetailsPage.saletogglebutton);
        }

    @And("we click the item level promotion info link")
    public void weClickTheItemLevelPromotionInfoLink() {
        //reg.clickwithJavascript(CartPage.promoInfo);
        try {
            commonMethods.clickWhenVisible(CartPage.promoInfo,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we click Close")
    public void weClickClose() throws Exception {
        List<WebElement> elements=Base.getDriver().findElements(CartPage.promoClose);
        System.out.println(elements.size());
        commonMethods.clickWhenVisible(elements.get(elements.size()-1),timeout);

    }

    @Then("Store Pickup should be Free")
    public void store_Pickup_should_be_Free() {
        try {
            WebElement element = commonMethods.getWebElement(CartPage.storepickupShip,timeout);
        String shipping=element.getText();
        shipping = shipping.replaceAll("\\s", "");
        Assert.assertEquals(shipping,"Free");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("we verify estimated shipping is {string}")
    public void we_verify_estimated_shipping_is(String string) {

        new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(CartPage.EstShipping));
        WebElement element =Base.getDriver().findElement(CartPage.EstShipping);
        String shipping=element.getText();
        shipping = shipping.replaceAll("\\s", "");
        Assert.assertEquals(shipping,"$6.99");
    }
    @And("we filter by items less than ${int}")
    public void weFilterByItemsLessThan$(int arg0) {

        try {
            if(commonMethods.isElementVisible(HomePage.closePromoWindow,timeout))
            {
                commonMethods.clickWhenVisible(HomePage.closePromoWindow, timeout);
            }
            reg.clickwithJavascript(ProductDetailsPage.priceFilter);
            /*//reg.clickwithJavascript(ProductDetailsPage.under25);
            WebElement checkbox=Base.getDriver().findElement(ProductDetailsPage.under25);
            ((JavascriptExecutor) Base.getDriver()).executeScript("arguments[0].scrollIntoView(true);", checkbox);
            Thread.sleep(500);
            commonMethods.clickWhenVisible(ProductDetailsPage.under25,timeout);*/
            WebElement checkbox1=Base.getDriver().findElement(ProductDetailsPage.under50);
            ((JavascriptExecutor) Base.getDriver()).executeScript("arguments[0].scrollIntoView(true);", checkbox1);
            Thread.sleep(500);
            commonMethods.clickWhenVisible(ProductDetailsPage.under50,timeout);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @And("we see a shipping discount of {string}")
    public void weSeeAShippingDiscountOf(String arg0) {
        List<WebElement> element=Base.getDriver().findElements(CartPage.caliaPromoShip);
        for(int i=0;i<element.size();i++) {
            String shipping = element.get(i).getText();
            shipping = shipping.replaceAll("\\s", "");
            System.out.println("shipping" + shipping);
            if(shipping.equalsIgnoreCase(arg0));
        }
    }


    @And("we remove the {string} item from the cart")
    public void weRemoveTheItemFromTheCart(String arg0) throws Exception {
        List<WebElement> element=Base.getDriver().findElements(CartPage.cartProductNames);
        List<WebElement> elementdel=Base.getDriver().findElements(CartPage.deleteButton);
        for(int i=0;i<element.size();i++) {
            String productname = element.get(i).getText();
            System.out.println("product name" + productname);
            if(productname.contains("Nike"))
            {
                commonMethods.clickWhenVisible(elementdel.get(i),timeout);
            }
        }
    }

    @And("we verify that the first yeti has STH fulfillment")
    public void weVerifyThatTheFirstYetiHasSTHFulfillment() {
        List<WebElement> radioSTH=Base.getDriver().findElements(By.xpath("//input[@value='STH']"));
        Assert.assertEquals(radioSTH.size(),2);
        if(radioSTH.get(0).isSelected()||radioSTH.get(1).isSelected())
        {
            System.out.println("STH is selected");
        }
        else
        {
            Assert.fail("STH not selected");
        }
    }

    @And("we verify that the hoodie has BOPIS fulfillment")
    public void weVerifyThatTheHoodieHasBOPISFulfillment() {
        List<WebElement> radioBopis=Base.getDriver().findElements(By.xpath("//input[@value='BOPIS']"));
        Assert.assertEquals(radioBopis.size(),2);
        if(radioBopis.get(0).isSelected()||radioBopis.get(1).isSelected())
        {
            System.out.println("STH is selected");
        }
        else
        {
            Assert.fail("STH not selected");
        }
    }

    @And("we select the first color option")
    public void weSelectTheFirstColorOption() throws Exception {
        //select the color
        List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
        if(commonMethods.isElementVisible(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"),timeout)) {
            commonMethods.clickWhenVisible(colorList.get(0), timeout);
        }
        else
        {
            //select the color
            List<WebElement> colorListSale = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/span/button"));
            commonMethods.clickWhenVisible(colorListSale.get(0), timeout);
        }
    }

    @And("we select the second color option")
    public void weSelectTheSecondColorOption() throws Exception {
        //select the color
        List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
        if (commonMethods.isElementVisible(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"), timeout)) {
            commonMethods.clickWhenVisible(colorList.get(2), timeout);
        } else {
            //select the color
            List<WebElement> colorListSale = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/span/button"));
            commonMethods.clickWhenVisible(colorListSale.get(2), timeout);
        }
    }

    @And("we update the Qty of the Navy yeti to {string}")
    public void weUpdateTheQtyOfTheNavyYetiTo(String arg0) {
        WebElement itemQty = Base.getDriver().findElement(By.xpath("//div[@class='qty']/input"));
        try {
            WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(itemQty)).clear();
            commonMethods.enterValueWhenVisible(By.xpath("//div[@class='qty']/input"),arg0,timeout);
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @And("we update the Qty of the hoodie to {string}")
    public void weUpdateTheQtyOfTheHoodieTo(String arg0) {
        WebElement itemQty = Base.getDriver().findElement(By.xpath("//div[@class='qty']/input"));
        try {
            WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(itemQty)).clear();
            commonMethods.enterValueWhenVisible(By.xpath("//div[@class='qty']/input"),arg0,timeout);
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @And("we click Tab")
    public void weClickTab() {
        try {
            Robot robot=new Robot();
            Actions actions = new Actions(Base.getDriver());
            /*robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);*/
            robot.mouseMove(50,50);

            actions.click().build().perform();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @And("we click outside of the promotion info")
    public void weClickOutsideOfThePromotionInfo() {
        //clicking on the item quantity to come out of promo window
        try {
            commonMethods.clickWhenVisible(By.xpath("//div[@class='qty']/input"),timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we click the shipping promotion info link")
    public void weClickTheShippingPromotionInfoLink() {
        try {
            commonMethods.clickWhenVisible(CartPage.ShippingpromoInfo,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we click the Change Store link in cart")
    public void weClickTheChangeStoreLinkInCart() {
        try {
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(CartPage.cartChangeStore));
            commonMethods.clickWhenVisible(CartPage.cartChangeStore,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we click Continue Shopping")
    public void weClickContinueShopping() {
        try {
            commonMethods.clickWhenVisible(By.xpath("//button[contains(text(),'Continue Shopping')]"),timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we update to BOPIS fulfillment")
    public void weUpdateToBOPISFulfillment() {
        List<WebElement> bopis=Base.getDriver().findElements(By.xpath("//input[@value='BOPIS']"));
        try {
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(bopis.get(0)));
            commonMethods.clickWhenVisible(bopis.get(0),timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("we should see a list of stores")
    public void weShouldSeeAListOfStores() {
        List<WebElement> storenames=Base.getDriver().findElements(By.xpath("//span[@class='store-name']"));
        try {
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(storenames.get(0)));
            if(storenames.size()==0)
            {
                Assert.fail("Stores list is not visible");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("store address is visible")
    public void storeAddressIsVisible() {
        try {

            JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        commonMethods.getWebElement(By.xpath("//div[@class='store-address-container']"),timeout);
        new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='store-address-container']")));
            js.executeScript("arguments[0].style.border='3px solid red'",By.xpath("//div[@class='store-address-container']"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
