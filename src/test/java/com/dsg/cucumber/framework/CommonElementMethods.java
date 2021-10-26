package com.dsg.cucumber.framework;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.utilities.BrowserUtilities;
import com.dsg.cucumber.utilities.ProxyClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CommonElementMethods {
    private static final Logger logger = Logger.getLogger(CommonElementMethods.class);
    Actions actions = new Actions(Base.getDriver());
    /**
     * Returns an element by locator when visible
     * @param locator by Locator object
     * @param timeout value when time expires when no locator found
     * @return WebElement
     */
    public WebElement getWebElement(By locator, int timeout) throws Exception {
        WebElement getElement = ElementReadyStatus.getWebElementVisible(locator, timeout);
        WebElement getElementWrapped = ProxyClass.wrapperElement(getElement);
        try {
            logger.info("Searching for element: " + locator);
            if (ElementReadyStatus.elementVisibleAndEnabled(getElementWrapped, timeout)) {
                logger.info(locator + " is clicked");
                return getElementWrapped;
            } else {
                logger.info(locator + " cannot be found");
                Assert.fail();
            }
        } catch (Exception e) {
            logger.info("Cannot be found, some other Exceptions:" + locator);
            e.printStackTrace();
        }
        return getElementWrapped;
    }
    /**
     * Enters String value by locator
     * @param locator by Locator object
     * @param timeout value when time expires when no locator found
     * @param "string" text value to be entered
     */
    public void enterValueWhenVisible(By locator, String inputValue, int timeout) throws Exception {
        WebElement getElement = ElementReadyStatus.getWebElementVisible(locator,timeout);
        WebElement getElementWrapped = ProxyClass.wrapperElement(getElement);
        try{
            logger.info("checking if element is visible");
            if(ElementReadyStatus.elementVisibleAndEnabled(locator, timeout)){
//                Base.getDriver().findElement(locator).sendKeys(inputValue);
                getElementWrapped.sendKeys(inputValue);
            }else {
            	Assert.fail(locator+" was not ENTERED");
            }
        }catch (Exception e){
            Assert.fail(e.getMessage());
            BrowserUtilities.takeAScreenshotAndSave();
        }
    }

    /**
     * Enters String value by locator
     //* @param WebElement
     * @param timeout value when time expires when no WebElement found
     * @param "string" text value to be entered
     */
    public void enterValueWhenVisible(WebElement element, String inputValue, int timeout) throws Exception {
//        WebElement getElementWrapped = ProxyClass.wrapperElement(element);
        try{
            logger.info("checking if element is visible");
            if(ElementReadyStatus.elementVisibleAndEnabled(element, timeout)){
                element.sendKeys(inputValue);
            }else {
                Assert.fail(element+" was not ENTERED");
            }
        }catch (Exception e){
            Assert.fail(e.getMessage());
            BrowserUtilities.takeAScreenshotAndSave();
        }
    }
    /**
     * Sends Keys event used in Keyboard
     * @param locator by Locator object
     * @param timeout value when time expires when no locator found
     * @param keys keyboard event
     */
    public void enterValueWhenVisible(By locator, Keys keys, int timeout) throws Exception {
        try{
            logger.info("checking if element is visible");
            if(ElementReadyStatus.elementVisibleAndEnabled(locator, timeout)){
                Base.getDriver().findElement(locator).sendKeys(keys);
            }
        }catch (Exception e){
            if(e.toString().contains("NullPointerException")){
            	logger.info(locator+" cannot be ENTERED");
            }
            BrowserUtilities.takeAScreenshotAndSave();
        }
    }
    public void clearWhenVisible(By locator) throws Exception {
        try{
        	logger.info("checking if element is visible");
            if(ElementReadyStatus.elementVisibleAndEnabled(locator, 5)){
                Base.getDriver().findElement(locator).clear();
            }
        }catch (Exception e){
            e.printStackTrace();
            BrowserUtilities.takeAScreenshotAndSave();
        }
    }
    
    /**
     * Clicks on element by locator when visible
     * @param locator by Locator object
     * @param timeout value when time expires when no locator found
     */
    public void clickWhenVisible(By locator, int timeout) throws Exception {
        WebElement getElement = ElementReadyStatus.getWebElementVisible(locator,timeout);
        WebElement getElementWrapped = ProxyClass.wrapperElement(getElement);
        try{
        logger.info("Searching for element: "+locator);
            if(ElementReadyStatus.elementVisibleAndEnabled(getElementWrapped, timeout)){
//                Base.getDriver().findElement(locator).click();
                getElementWrapped.click();
                logger.info(locator+" is clicked");
            }else{
                logger.info(locator+" cannot be CLICKED");
                Assert.fail();
            }
        }catch (Exception e){
            logger.info("Cannot click, some other Exceptions:"+locator);
            e.printStackTrace();
        }
    }

    /**
     * Clicks on element twice by locator when visible
     * @param locator by Locator object
     * @param timeout value when time expires when no locator found
     */
    public void doubleClickWhenVisible(By locator, int timeout) throws Exception {
        WebElement getElement = ElementReadyStatus.getWebElementVisible(locator,timeout);
        WebElement getElementWrapped = ProxyClass.wrapperElement(getElement);
        try{
            logger.info("Searching for element: "+locator);
            if(ElementReadyStatus.elementVisibleAndEnabled(getElementWrapped, timeout)){
                logger.info(locator+" is clicked");
                actions.doubleClick(getElementWrapped).perform();
            }else{
                logger.info(locator+" cannot be CLICKED");
                Assert.fail();
            }
        }catch (Exception e){
            logger.info("Cannot click, some other Exceptions:"+locator);
            e.printStackTrace();
        }
    }
    /**
     * Clicks on element by WebElement when visible
     //* @param locator by Locator object
     * @param timeout value when time expires when no locator found
     */
    public void clickWhenVisible(WebElement webElement, int timeout) throws Exception {
        WebElement getElementWrapped = ProxyClass.wrapperElement(webElement);
        try{
            logger.info("Searching for element: "+webElement);
            if(ElementReadyStatus.elementVisibleAndEnabled(getElementWrapped, timeout)){
                logger.info(webElement+" is clicked");
                getElementWrapped.click();
            }else{
                logger.info(webElement+" cannot be CLICKED");
                Assert.fail();
            }
        }catch (Exception e){
            logger.info("Cannot click, some other Exceptions:");
            e.printStackTrace();
        }
    }

    /**
     * Clicks on element by locator when visible using Java Script
     * @param locator by Locator object
     * @param timeout value when time expires when no locator found
     */
    public void clickWhenVisibleJS(By locator, int timeout) throws Exception {
        try{
            logger.info("Searching for element: "+locator);
            if(ElementReadyStatus.elementVisibleAndEnabled(locator, timeout)){
                logger.info(locator+" is clicked");
                ((JavascriptExecutor) Base.getDriver()).executeScript("arguments[0].click();", locator);
            }else{
                logger.info(locator+" cannot be CLICKED");
                Assert.fail();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Validates if locator is visible and enabled. Returns true/false
     * @param locator by Locator object
     * @param timeout value when time expires when no locator found
     * @returns boolean
     */
    public boolean isElementVisible(By locator, int timeout) throws Exception {
        WebElement getElement = ElementReadyStatus.getWebElementVisible(locator,timeout);
        WebElement getElementWrapped = ProxyClass.wrapperElement(getElement);
        try {
            if (new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOf(getElementWrapped)) != null) {
                logger.info("element is visible and enabled: " + locator);
                return true;
            }else {
                logger.info("element is NOT visible and enabled: "+locator);
                return false;
            }
        }catch (Exception e){
            logger.info(locator+" cannot be FOUND");
            return false;
        }
    }
    /**
     * Validates if locator is invisible. Returns true/false
     * @param locator by Locator object
     * @param timeout value when time expires when no locator found
     * @returns boolean
     */
    public boolean elementShouldNotExist(By locator, int timeout) throws Exception {
    	boolean elementExists = ElementReadyStatus.elementVisibleAndEnabled(locator, timeout);
		if(!elementExists) {
            logger.info("element does NOT EXIST: "+locator);
            return false;
		}else {
            logger.info("element does EXISTS: "+locator);
			return true;
		}
    }
    /**
     * Returns list of Sting value from list of Elements
     * @param locator by Locator object
     * @param timeout value when time expires when no locator found
     * @returns List of Strings
     * @throws InterruptedException 
     */
    public List<String> getTextFromListOfElements(By locator, int timeout) throws InterruptedException {
    	List<WebElement> listElement = new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    	List<String> listArray = new ArrayList<>();
    	for(int i=0; i<listElement.size();i++) {
    		listArray.add(listElement.get(i).getText());
    		logger.info("Found texts in the list: "+listArray.get(i));
    	}
        logger.info("Total Count in the list: "+listArray.size());
        return listArray;
    }
    /**
     * Returns size of Elements in List
     * @param locator by Locator object
     * @param timeout value when time expires when no locator found
     * @returns Integer. Returns '0' if list doesn't exist
     */
    public int getListSize(By locator, int timeout) {
        int getSize = 0;
        try {
            List<WebElement> listOfElements = new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            getSize = listOfElements.size();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Elements DO NOT PRESENT IN DOM");
        }
        return getSize;
    }
    /**
     * Returns text from the locator
     * @param locator by Locator object
     * @param timeout value when time expires when no locator found
     * @returns string
     */
    public String getTextFromLocator(By locator, int timeout) {
        logger.info("Getting the text from : "+locator);
        return new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
    /**
     * Hovers parentElement and click on childElement
     * @param parentLocator by Locator object
     * @param childLocator by Locator object
     * @param timeout value when time expires when no locator found
     */
    public void hoverParentMenuAndClicksChild(By parentLocator, By childLocator, int timeout) throws Exception {
        ProxyClass.promotionHandler();;

//        WebElement getParentElement = ElementReadyStatus.getWebElementVisible(parentLocator,timeout);
//        WebElement getParentElementWrapped = ProxyClass.wrapperElement(getParentElement);

//        WebElement getChildElement = ElementReadyStatus.getWebElementVisible(childLocator,timeout);
//        WebElement getChildElementWrapped = ProxyClass.wrapperElement(getChildElement);

        try{
//            if(ElementReadyStatus.elementVisibleAndEnabled(getParentElementWrapped, timeout)){
                WebElement parentLocatorElement = ElementReadyStatus.getWebElementVisible(parentLocator,timeout);;
                logger.info("Hovering parentLocator: "+parentLocator);
                actions.moveToElement(parentLocatorElement).perform();
                logger.info("Hovered parentLocator: "+parentLocator);
                logger.info("Clicking after hovering childLocator parentLocator : "+childLocator);
                this.clickWhenVisible(childLocator, timeout);
                logger.info("Clicked childLocator: "+childLocator);
//            }
        }catch (Exception e){
            logger.info(parentLocator+" cannot be FOUND");
            Assert.fail(e.getMessage());
        }
    }
    /**
     * Hovers on WebElement
     * @param parentLocator by Locator object
     * @param timeout value when time expires when no locator found
     */
    public void hoverOnElement(By parentLocator, int timeout) {
        try{
            logger.info("Hovering locator: "+parentLocator);
            if(ElementReadyStatus.elementVisibleAndEnabled(parentLocator, timeout)){
                WebElement mainMenu = Base.getDriver().findElement(parentLocator);
                actions.moveToElement(mainMenu).perform();
                Thread.sleep(1000);
            }
        }catch (Exception e){
            logger.info(parentLocator+" cannot be FOUND");
            Assert.fail(e.getMessage());
        }
    }
    /**
     * Switch to IFrames
     *
     * @param locator
     * @param timeout value when time expires when no locator found
     */
    public void switchToFrame(By locator, int timeout) {
        try {
            logger.info("Switching from Default to Iframe:" + locator);
            if (ElementReadyStatus.elementVisibleAndEnabled(locator, timeout)) {
                Base.getDriver().switchTo().frame(Base.getDriver().findElement(locator));
            }

        } catch (Exception e) {
            logger.info(locator + " cannot be found");
            Assert.fail(e.getMessage());
        }
    }
    /**
     * Switch from Iframe to Default
     * @param timeout value when time expires when no locator found
     */
    public void switchToDefault(int timeout) {
        Base.getDriver().switchTo().defaultContent();
    }
    /**
     * Switch Window
     *
     * @param locator
     */
    public void switch_windows(int timeout) {
        try {
            logger.info("Switching Between Windows");
            ArrayList<String> tabs2 = new ArrayList<String>(Base.getDriver().getWindowHandles());
            Base.getDriver().switchTo().window(tabs2.get(1));
        } catch (Exception e) {
            logger.info("Child Window cannot be Found");
            Assert.fail(e.getMessage());
        }
    }
    /**
     * Switch to New Window and back
     * @param int
     */
    public void switch_windows_Back(int timeout) {
        try {
            logger.info("Switching Between Windows");
            ArrayList<String> parenttab = new ArrayList<String>(Base.getDriver().getWindowHandles());
            Base.getDriver().switchTo().window(parenttab.get(2));
            System.out.println(Base.getDriver().getTitle());
            Base.getDriver().close();
            Base.getDriver().switchTo().window(parenttab.get(1));
        }
        catch (Exception e) {
            logger.info("Child Window cannot be Found");
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Keys Tab
     * @param locator
     * @param int
     */
    public void sendkeys_tab(By locator, int timeout) {
        try {
            logger.info("Locating Element: " + locator);
            if (ElementReadyStatus.elementVisibleAndEnabled(locator, timeout)) {
                WebElement element = Base.getDriver().findElement(locator);
                element.sendKeys(Keys.TAB);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            logger.info(locator + " cannot be FOUND");
            Assert.fail(e.getMessage());
        }

    }

    /**
     * Keys Enter
     * @param locator
     * @param int
     */
    public void sendkeys_enter(By locator, int timeout) {
        try {
            logger.info("Locating Element: " + locator);
            if (ElementReadyStatus.elementVisibleAndEnabled(locator, timeout)) {
                WebElement element = Base.getDriver().findElement(locator);
                element.sendKeys(Keys.ENTER);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            logger.info(locator + " cannot be FOUND");
            Assert.fail(e.getMessage());
        }

    }
    /**
     * Keys Enter
     */
    public void sendkeys_enter_robot() throws AWTException {
        Robot alert = new Robot();
        alert.keyPress(KeyEvent.VK_ENTER);
    }

        /**
         * Select the dropdown option by text
         * @param locator
         * @param timeout
         * @param TextOption
         */
    public void selectDropDownByText(By locator, int timeout, String TextOption) throws Exception {

        WebElement getElement = ElementReadyStatus.getWebElementVisible(locator,timeout);
        WebElement getElementWrapped = ProxyClass.wrapperElement(getElement);

        try{
            logger.info("Searching for element: "+getElement);
            if(ElementReadyStatus.elementVisibleAndEnabled(getElementWrapped, timeout)){
                Select dropdown=new Select(getElementWrapped);
                dropdown.selectByVisibleText(TextOption);
                logger.info(getElement+" dropdown Selected");
            }else{
                logger.info(getElement+" cannot be Selected");
                Assert.fail();
            }
        }catch (Exception e){
            logger.info("Cannot click, some other Exceptions:");
            e.printStackTrace();
        }
    }
}
