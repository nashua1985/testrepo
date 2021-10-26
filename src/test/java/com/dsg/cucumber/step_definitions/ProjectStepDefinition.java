package com.dsg.cucumber.step_definitions;


import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.config.ConfigurationReader;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.cucumber.pages.sb.QuickViewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class ProjectStepDefinition {
    private static final Logger logger = Logger.getLogger(ProjectStepDefinition.class);
    private static final Integer MULTIPLIER = 1000;
    private static final Integer timeout = 10;
    
    CommonElementMethods commonMethods= new CommonElementMethods();


    @Given("we are on {string} page")
    public void we_are_on_page(String url) {
        logger.info("Opening page...");
        String env = url;
        if (System.getProperty(url) != null) {
            env = System.getProperty(url);
        }
        String URL = ConfigurationReader.getProperty(env);
        logger.info("URL :: " + URL);
        Base.getDriver().get(URL);
    }
    @When("we add cookies to access zeta:")
    public void we_add_cookie_to_access_zeta(Map<String,String> cookies) throws Exception {
        for (Map.Entry<String, String> keys : cookies.entrySet()) {
            String key = keys.getKey();
            String value = keys.getValue();
            Base.getDriver().manage().addCookie(new Cookie(key, value));
        }
    }
    @When("we add cookies to block medalia popup:")
    public void we_add_cookie_to_block_medalia(Map<String,String> cookies) throws Exception {
        for (Map.Entry<String, String> keys : cookies.entrySet()) {
            String key = keys.getKey();
            String value = keys.getValue();
            Base.getDriver().manage().addCookie(new Cookie(key, value));
        }
    }
    @When("we search for {string} keyword in the search box")
    public void we_enter(String keyWord) throws Exception {
        commonMethods.enterValueWhenVisible(HomePage.searchTextBox, keyWord, timeout);
        Thread.sleep(3000);//monitor behaviour of SB_032_041, when searching it goes directly to pdp
        if(commonMethods.getListSize(HomePage.suggestionSearchCloseIcon, timeout) >0){
            commonMethods.clickWhenVisible(HomePage.suggestionSearchCloseIcon, timeout);
        }
        commonMethods.clickWhenVisible(HomePage.searchIcon, timeout);
    }

    @When("we click on addToCart button")
    public void click_addToCart() throws Exception {
        commonMethods.clickWhenVisible(QuickViewPage.addToCart, timeout);
    }
    @When("we click on first addToCart in search grid")
    public void click_first_addToCart() throws Exception {
        List<WebElement> getItemList = Base.getDriver().findElements(QuickViewPage.firstOccurenceAddToCart);
        if (getItemList.size() != 0) {
            commonMethods.clickWhenVisible(QuickViewPage.firstOccurenceAddToCart, timeout);
        }else{
            logger.info("redirecting to PDP");
        }

    }

    @When("we should see exact text {string}")
    public void should_see_exact_text(String text) throws Exception {
        boolean isTextVisible = commonMethods.isElementVisible(By.xpath("//*[text()=\""+text+"\"]"), timeout);
        if(!isTextVisible){
            Assert.fail(text+" is not VISIBLE");
        }
    }

    @When("we select the {int} color and the {int} size") //size number is the order number, not e-commerce size
    public void select_color_and_size(int color, int size) throws Exception {
        commonMethods.clickWhenVisible(By.xpath("(//div[@class='dsg-flex flex-column justify-content-center flex-grow-none flex-shrink swatch-container']//img)["+color+"]"), timeout);
        commonMethods.clickWhenVisible(By.xpath("((//div[@class='dsg-flex flex-row flex-wrap'])[2]//div[@class='value false false' or @class='value selected false']//p)["+size+"]"), timeout);
    }

    @When("we should see containing text {string}")
    public void should_see_containing_text(String text) throws Exception {
        boolean isTextVisible = commonMethods.isElementVisible(By.xpath("//*[contains(text(), \"" + text + "\")]"), timeout);
        if (!isTextVisible) {
            Assert.fail(text + " is not VISIBLE");
        }
    }

    /**
     * Pause test for some time
     * @param seconds
     */
    @When("we wait for {int} seconds")
    public void we_wait(int seconds) throws IOException, InterruptedException {
	    Thread.sleep(seconds * MULTIPLIER);
    }
    /**
     * Login Credentials for Okta-SP
     * @param username
     * @param password
     */
    @When("we login to Solepanel username {string} password {string}")
    public void solepanel_login_credentials(String username, String password) throws Exception {
        commonMethods.enterValueWhenVisible(com.dsg.pages.sp.OktaHomePage.oktaUserName, username, timeout);
        commonMethods.enterValueWhenVisible(com.dsg.pages.sp.OktaHomePage.oktapwd, password, timeout);
        commonMethods.clickWhenVisible(com.dsg.pages.sp.OktaHomePage.oktasignIn, timeout);
        commonMethods.clickWhenVisible(com.dsg.pages.sp.OktaHomePage.solePanelIcon, timeout);

    }
    @And("users search for Order using phone number {string} in Order Look Up container")
    public void Ordersearch_with_phone_number(String phone_number) throws Exception {

        commonMethods.switch_windows(timeout);
        commonMethods.clickWhenVisible(com.dsg.pages.sp.SolePanelHomePage.closeWelcomeMessage, 5);
        commonMethods.switchToDefault(timeout);

        commonMethods.enterValueWhenVisible(com.dsg.pages.sp.SolePanelHomePage.enterPhoneNumberSearch, phone_number, 10);
        commonMethods.clickWhenVisible(com.dsg.pages.sp.SolePanelHomePage.submitSearchButton, 10);

        assertTrue(commonMethods.isElementVisible(com.dsg.pages.sp.AthleteSummaryPage.phoneNumber, 10));

        if(commonMethods.isElementVisible(com.dsg.pages.sp.AthleteSummaryPage.phoneNumber, 10)){

            String phone = commonMethods.getTextFromLocator(com.dsg.pages.sp.AthleteSummaryPage.phoneNumber, 10);
            System.out.println(phone);
            if (!("Phone: "+phone_number).equalsIgnoreCase(phone))
            {
                Assert.fail("Search did not return any results for: "+phone_number);
            }
        }
    }
    @When("we enter {string} and click submit")
    public void we_enter_store_number_in_aos(String storeNumber) throws Exception {
        commonMethods.enterValueWhenVisible(HomePage.storeNumberBox, storeNumber, timeout);
        commonMethods.clickWhenVisible(HomePage.storeNumberSbmBtn, timeout);
    }
}

