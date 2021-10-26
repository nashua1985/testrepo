package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.cart.CartPage;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class PDP_001_ATC_Yeti {
    private static final Logger logger = Logger.getLogger(PDP_001_ATC_Yeti.class);
    private static final Integer timeout = 40;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we click on the first product in search grid")
    public void click_first_product() throws Exception {
        Thread.sleep(3000);

            if(commonMethods.isElementVisible(HomePage.closePromoWindow,timeout))
            {
                commonMethods.clickWhenVisible(HomePage.closePromoWindow, timeout);
            }
        //commonMethods.clickWhenVisible(ProductDetailsPage.firstProductInGrid, timeout);
        WebElement firstProd = Base.getDriver().findElement(ProductDetailsPage.firstProductInGrid);
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",firstProd);
        js.executeScript("arguments[0].style.border='3px solid red'",firstProd);
        js.executeScript("arguments[0].click();", firstProd);
    }

    @When("we filter by the color Blue")
    public void click_colorBlue() throws Exception {
        if(commonMethods.isElementVisible(HomePage.closePromoWindow,timeout))
        {
            commonMethods.clickWhenVisible(HomePage.closePromoWindow, timeout);
        }
        //WebElement blueCheckbox = Base.getDriver().findElement(By.xpath("//button[@aria-label='Blue']"));
        if(!(commonMethods.isElementVisible(By.xpath("//span[@style=\"background-color: blue;\"]"),timeout)))
        {
        WebElement color = Base.getDriver().findElement(By.xpath("//div[@id='facet_list_label_Color']"));
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",color);
        js.executeScript("arguments[0].style.border='3px solid red'",color);
        js.executeScript("arguments[0].click();", color);
        //commonMethods.clickWhenVisible(color, timeout);
        }
        WebElement blueButton = Base.getDriver().findElement(By.xpath("//span[@style=\"background-color: blue;\"]"));
        commonMethods.clickWhenVisible(blueButton, timeout);
        Thread.sleep(3000);
    }
   @When("we click on Add to Cart button")
    public void click_addToCart() throws Exception {
//        BrowserUtilities.promotionHandler();
       commonMethods.isElementVisible(ProductDetailsPage.addToCart,40);
       WebElement addtoCart = Base.getDriver().findElement(ProductDetailsPage.addToCart);
       JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
       js.executeScript("arguments[0].scrollIntoView(true);",addtoCart);
       js.executeScript("arguments[0].style.border='3px solid red'",addtoCart);
       js.executeScript("arguments[0].click();", addtoCart);

    }

    @When("we should see {string}")
    public void check_message_(String text) throws Exception {
        boolean isTextVisible = commonMethods.isElementVisible(By.xpath("//*[contains(text(), \"" + text + "\")]"), timeout);
        if (!isTextVisible) {
            Assert.fail(text + " is not VISIBLE");
        }
        WebElement element = Base.getDriver().findElement(By.xpath("//*[contains(text(), \"" + text + "\")]"));
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);

    }

    @When("we select the color Navy")
        public void select_colorNavy()  {
        try {
            if(commonMethods.isElementVisible(ProductDetailsPage.colorNavy,timeout)){
                WebElement element = Base.getDriver().findElement(ProductDetailsPage.colorNavy);
                JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
                js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
                js.executeScript("arguments[0].click();", element);
            }
            else
            {
                selectTheFirstColorOption();
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @When("we click GO TO CART")
    public void click_goToCart() throws Exception {
        //commonMethods.clickWhenVisible(ProductDetailsPage.goToCart, timeout);
        WebElement element = Base.getDriver().findElement(By.xpath("//a[contains(text(),'GO TO CART')]"));
        WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @When("we click GO TO CART in safari")
    public void click_goToCartInSafari() throws Exception {
        //commonMethods.clickWhenVisible(ProductDetailsPage.goToCart, timeout);
        WebElement element = Base.getDriver().findElement(By.xpath("//a[contains(text(),'GO TO CART')]"));
        WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
        js.executeScript("arguments[0].click();", element);
    }

    @When("we click product details")
    public void click_productDetails() throws Exception {
        commonMethods.clickWhenVisible(CartPage.productDetails, timeout);
    }

    @And("we validate available to ship")
    public void weValidateAvailableToShip() throws Exception {
        List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
        if(colorList.size()>0) {
            boolean notAvailable = commonMethods.isElementVisible(By.xpath("//span[contains(text(),'Not Available to Ship')]"), timeout);
            if(notAvailable){
                logger.info("Available to Ship is NOT VISIBLE");
                for(int i=1; i<=colorList.size();i++){
                    commonMethods.clickWhenVisible(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button["+i+"]"), timeout);
                    notAvailable = commonMethods.isElementVisible(By.xpath("//span[contains(text(),'Not Available to Ship')]"), timeout);
                    if(notAvailable){
                        logger.info("Available to Ship is NOT VISIBLE");
                    }
                    else
                    {
                        logger.info("Available to Ship is VISIBLE");
                        break;
                    }
                }

            }else{
                WebElement ship=Base.getDriver().findElement(By.xpath("//span[contains(text(),'Available to Ship')]"));
                JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
                js.executeScript("arguments[0].scrollIntoView(true);",ship);
                js.executeScript("arguments[0].style.border='3px solid red'",ship);
                logger.info("Available to Ship is VISIBLE");
            }
        }
        else
        {
            logger.info("Alternate Color option");
            List<WebElement> colorList2 = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/span/button"));
            boolean notAvailable = commonMethods.isElementVisible(By.xpath("//span[contains(text(),'Not Available to Ship')]"), timeout);
            if(notAvailable){
                logger.info("Available to Ship is NOT VISIBLE");
                for(int i=1; i<=colorList2.size();i++){
                    commonMethods.clickWhenVisible(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/span["+i+"]/button"), timeout);
                    notAvailable = commonMethods.isElementVisible(By.xpath("//span[contains(text(),'Not Available to Ship')]"), timeout);
                    if(notAvailable){
                        logger.info("Available to Ship is NOT VISIBLE");
                    }
                    else
                    {
                        logger.info("Available to Ship is VISIBLE");
                        break;
                    }
                }

            }else{
                WebElement ship=Base.getDriver().findElement(By.xpath("//span[contains(text(),'Available to Ship')]"));
                JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
                js.executeScript("arguments[0].scrollIntoView(true);",ship);
                js.executeScript("arguments[0].style.border='3px solid red'",ship);
                logger.info("Available to Ship is VISIBLE");
            }
        }

    }


    @And("select the first color option")
    public void selectTheFirstColorOption() throws Exception {
        List<WebElement> colorList = Base.getDriver().findElements(By.xpath("//div[@class='color-attributes-container sliding_row_inner']/button"));
        commonMethods.clickWhenVisible(colorList.get(0), timeout);

    }

    @And("we click on the filter button")
    public void weClickOnTheFilterButton() {
        try {
            commonMethods.clickWhenVisible(ProductDetailsPage.filterButton, timeout);
        } catch (Exception e) {
            logger.info(e.getMessage());
            Assert.fail();
        }
    }
    // @When("we verify the product name")
    //public void verify_productName() throws Exception {
      //  String cartProductName = commonMethods.getTextFromLocator(CartPage.productName, timeout);
        //
        //Assert.assertEquals(cartProductName, text);
       // Assert.fail("Number of items in cart does not equal " + text);
    //}

    @And("we click with JS")
    public void clickwithJavascript(By locator) {
        try {
            WebElement element = Base.getDriver().findElement(locator);
            WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            js.executeScript("arguments[0].style.border='3px solid red'", element);
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            logger.info(e.getMessage());
            Assert.fail();
        }
    }

    @And("we click  Ship to me")
    public void weClickShipToMe() {
            WebElement element = Base.getDriver().findElement(By.xpath("//button[text()='Ship To Me']"));
            WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            clickwithJavascript(By.xpath("//button[text()='Ship To Me']"));
    }

    @And("we should see Continue Shopping")
    public void weShouldSeeContinueShopping() throws Exception {

        boolean isTextVisible = commonMethods.isElementVisible(By.xpath("//button[contains(text(), \"Continue Shopping\")]"), timeout);
        if (!isTextVisible) {
            Assert.fail( "Continue Shopping is not VISIBLE");
        }
        WebElement element = Base.getDriver().findElement(By.xpath("//button[contains(text(), \"Continue Shopping\")]"));
        JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }
}

