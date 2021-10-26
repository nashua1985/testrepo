package com.dsg.cucumber.step_definitions.checkout;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.cart.CartPage;
import com.dsg.cucumber.pages.checkout.checkoutPage;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.cucumber.step_definitions.Api_ProjectStepDefinition;
import com.dsg.cucumber.step_definitions.pdp.dsg.PDP_001_ATC_Yeti;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class Smoke_Checkout_001 {

    private static final Integer timeout = 40;
    CommonElementMethods commonMethods= new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();
    Api_ProjectStepDefinition apiMethods = new Api_ProjectStepDefinition();
    String orderNum;

    @And("we add a product {string} to cart")
    public void weAddAProductToCart(String arg0) {
        try {

            if(commonMethods.isElementVisible(HomePage.closePromoWindow,timeout))
            {
                commonMethods.clickWhenVisible(HomePage.closePromoWindow, timeout);
            }
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

            if (arg0.contains("hoodie"))
            {
                reg.clickwithJavascript(ProductDetailsPage.sizeMedium);
            }
            if(arg0.contains("bike"))
            {
                if(commonMethods.isElementVisible(ProductDetailsPage.frameSize3,timeout)){
                    commonMethods.clickWhenVisible(ProductDetailsPage.frameSize3, timeout);
                }
                else
                {
                    List<WebElement> frameList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
                    commonMethods.clickWhenVisible(frameList.get(0), timeout);
                }
            }
            reg.weValidateAvailableToShip();

            if(commonMethods.isElementVisible(HomePage.closePromoWindow,timeout))
            {
                commonMethods.clickWhenVisible(HomePage.closePromoWindow, timeout);
            }

            commonMethods.isElementVisible(ProductDetailsPage.addToCart,40);

            if(commonMethods.isElementVisible(HomePage.closePromoWindow,timeout))
            {
                commonMethods.clickWhenVisible(HomePage.closePromoWindow, timeout);
            }
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

    @And("we select CHECKOUT")
    public void weSelectCHECKOUT() throws Exception{
        try {
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(CartPage.checkoutButton));
            commonMethods.clickWhenVisible(CartPage.checkoutButton,timeout);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we validate Contact and Address info is not prefilled")
    public void weValidateContactAndAddressInfoIsNotPrefilled() {

        try {

            WebElement firstname = commonMethods.getWebElement(checkoutPage.firstname,timeout);
            WebElement lastname = commonMethods.getWebElement(checkoutPage.lastname,timeout);
            WebElement email = commonMethods.getWebElement(checkoutPage.email,timeout);
            WebElement phone = commonMethods.getWebElement(checkoutPage.phone,timeout);

            WebElement streetadd = commonMethods.getWebElement(checkoutPage.streetAdd,timeout);
            WebElement apt = commonMethods.getWebElement(checkoutPage.Apt,timeout);
            WebElement zipcode = commonMethods.getWebElement(checkoutPage.zipcode,timeout);

        String firstname1 = firstname.getAttribute("value");
        String lastname1 = firstname.getAttribute("value");
        String email1 = firstname.getAttribute("value");
        String phone1 = firstname.getAttribute("value");
        String streetadd1 = firstname.getAttribute("value");
        String apt1 = firstname.getAttribute("value");
        String zipcode1 = firstname.getAttribute("value");
        if(firstname1.equalsIgnoreCase("")& lastname1.equalsIgnoreCase("")&email1.equalsIgnoreCase("")
        & phone1.equalsIgnoreCase("")& streetadd1.equalsIgnoreCase("")& apt1.equalsIgnoreCase("")& zipcode1.equalsIgnoreCase(""))
        {
            System.out.println("contact and address info is not prefilled");
        }
        else {
            Assert.fail( "contact and address info is prefilled" + "");
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add first name {string}")
    public void weAddFirstName(String arg0) {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.firstname,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add last name {string}")
    public void weAddLastName(String arg0) {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.lastname,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add email {string}")
    public void weAddEmail(String arg0) {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.email,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add phone number {string}")
    public void weAddPhoneNumber(String arg0) {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.phone,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add street address {string}")
    public void weAddStreetAddress(String arg0) {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.streetAdd,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add zip code {string}")
    public void weAddZipCode(String arg0) {
        try {
            commonMethods.enterValueWhenVisible(checkoutPage.zipcode,arg0,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we click Continue to Payment")
    public void weClickContinueToPayment() {
        try {
            commonMethods.clickWhenVisible(checkoutPage.continueToPayment,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we add the TE Visa")
    public void weAddTheTEVisa() {
        try {

            InputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/dsg/cucumber/config/properties/payment.properties") ;

                Properties prop = new Properties();

                // load a properties file
                prop.load(input);

            System.out.println("card details:"+prop.getProperty("accountNumber")+prop.getProperty("expDate")+prop.getProperty("CVV"));
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.creditcardNumber));
            commonMethods.enterValueWhenVisible(checkoutPage.creditcardNumber,prop.getProperty("accountNumber"),timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.expiryDate,prop.getProperty("expDate"),timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.securityCode,prop.getProperty("CVV"),timeout);

        }
        catch (IOException e) {
            e.printStackTrace();
            }
        catch (TimeoutException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we click Place Order")
    public void weClickPlaceOrder() {
        try {
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(checkoutPage.placeorderbutton));
            commonMethods.clickWhenVisible(checkoutPage.placeorderbutton,timeout);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we remember the order id")
    public void weRememberTheOrderId() {
        try {
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(checkoutPage.orderNum));
            WebElement order=commonMethods.getWebElement(checkoutPage.orderNum,timeout);
            orderNum=order.getText();
            System.out.println("---"+orderNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("we are on solepanel page")
    public void weAreOnSolepanelPage() {

        //Base.getDriver().close();
        Base.getDriver().get("https://solepanel.dickssportinggoods.com/");
    }

    @And("we enter our credentials")
    public void weEnterOurCredentials() {
        try {

            InputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/dsg/cucumber/config/properties/payment.properties") ;

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);


            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.solepanelUsername));
            commonMethods.enterValueWhenVisible(checkoutPage.solepanelUsername,prop.getProperty("username"),timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.solepanelPassword,prop.getProperty("password"),timeout);
            commonMethods.clickWhenVisible(checkoutPage.signIn,timeout);

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we search for the order id")
    public void weSearchForTheOrderId() {
        try {
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.lookUpOrder));
            commonMethods.clickWhenVisible(checkoutPage.lookUpOrder,timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.lookupOrderNum,orderNum,timeout);
            commonMethods.clickWhenVisible(checkoutPage.searchButton,timeout);
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(checkoutPage.orderDetailBtn));
            commonMethods.clickWhenVisible(checkoutPage.orderDetailBtn,timeout);
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("we cancel the order")
    public void weCancelTheOrder() {
        try {
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.cancelorderBtn));
            commonMethods.clickWhenVisible(checkoutPage.cancelorderBtn,timeout);
            commonMethods.clickWhenVisible(checkoutPage.incidentCategory,timeout);
            commonMethods.clickWhenVisible(checkoutPage.incidentValue,timeout);
            commonMethods.enterValueWhenVisible(checkoutPage.incidentNotes,"Testing",timeout);
            new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(checkoutPage.YesCancelBtn));
            commonMethods.clickWhenVisible(checkoutPage.YesCancelBtn,timeout);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("we send api request to cancel a order")
    public void weSendApiRequestToCancelAOrder() {
        try {
            InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/dsg/cucumber/config/properties/payment.properties");

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            String username = prop.getProperty("username").trim();
            String password = prop.getProperty("password").trim();

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(Calendar.getInstance().getTime());
            orderNum = orderNum.substring(7, orderNum.length());
            JSONObject jsonComplex = new JSONObject();
            JSONObject athleteOrderCancelRequest = new JSONObject();
            JSONObject wcsCancelRequest = new JSONObject();

            wcsCancelRequest.put("storeId", "15108");

            athleteOrderCancelRequest.put("agent", "choitali.chakraborty@dcsg.com");
            athleteOrderCancelRequest.put("cancelDate", timeStamp);//"yyyy-MM-dd'T'HH:mm:ss.SSSZ"
            athleteOrderCancelRequest.put("cancelSource", "CallCenter");
            athleteOrderCancelRequest.put("reason", "CANCEL_ATHLETE_REQUEST");

            jsonComplex.put("athleteOrderCancelRequest", athleteOrderCancelRequest);
            jsonComplex.put("orderNumber", orderNum);
            jsonComplex.put("wcsCancelRequest", wcsCancelRequest);

            System.out.println(jsonComplex);

            Response response = apiMethods.getResponseBodyPostRequest("https://solepanel.dickssportinggoods.com/api/customerOrder/cancel/order/" + orderNum, jsonComplex, username, password);
            System.out.println("response" + response.asString());
            System.out.println("StatusCode" + response.getStatusCode());
            Assert.assertEquals(200, response.getStatusCode());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Then("the order status should be canceled")
    public void theOrderStatusShouldBeCanceled() {
    }

    @When("we add cookies to access delta:")
    public void weAddCookiesToAccessDelta(Map<String,String> cookies) {
        for (Map.Entry<String, String> keys : cookies.entrySet()) {
            String key = keys.getKey();
            String value = keys.getValue();
            Base.getDriver().manage().addCookie(new Cookie(key, value));
        }
    }

    @And("we select the TEST1 button")
    public void weSelectTheTESTButton() {
        try {
            commonMethods.clickWhenVisible(checkoutPage.deltaTestBtn,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
